package data;
import JDBCUtil.JDBCUtils;
import rowmapper.GoodsRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
//���ﳵ��
public class Shoppinglist {
	public int shoppinglist_id;//�����
    public String usernum;//�û��˺�
    public int store_id;//�̵��
    public int goods_id;//��Ʒ��
    public int buynum;//��������
	public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * ��ö���Ʒ�Ĺ�������
     */
    public static int getBuyNum(String usernum, int store_id, int goods_id) {
        String sql = "select buynum from shoppinglist where usernum=? and store_id =? and goods_id=?";
        int buynum = template.queryForObject(sql, int.class, usernum, store_id, goods_id);
        return buynum;
    }
    /**
        * �����Ʒ���빺�ﳵ�������Ʒ�Ѵ��������¼��㹺������
    * */
    public static void addShoppinglist(String usernum, int store_id, int goods_id, int buynum) {//ĳ���̵Ĺ��ﳵ
        String sql="select count(*) from shoppinglist where usernum =? and store_id= ? and goods_id=?";
        String sql1 = "select buynum from shoppinglist where usernum =? and store_id= ? and goods_id=?";
        String sql2 = "insert into shoppinglist values(?,?,?,?,?)";
        String sql3 = "update shoppinglist set buynum=? where usernum =? and store_id=? and goods_id=?";
        String sql4="select max(shoppinglist_id)+1 from shoppinglist ";
        int ifexist;
        int existbuynum;
        int shoppinglist_id ;
        ifexist=template.queryForObject(sql, int.class, usernum, store_id, goods_id);
        if(ifexist==1) {
            existbuynum = template.queryForObject(sql1, int.class, usernum, store_id, goods_id);
            shoppinglist_id=template.queryForObject(sql4, int.class);
            template.update(sql3, buynum + existbuynum, usernum, store_id, goods_id);
        }else {
            try {
                shoppinglist_id=template.queryForObject(sql4, int.class);
            } catch (Exception e) {
                shoppinglist_id=1;
            }
            template.update(sql2, shoppinglist_id,usernum, store_id, goods_id, buynum);
        }

    }
    /**
     * ���ĳ�û���ĳ�̵�Ĺ��ﳵ
     * */
    public static List<Goods> getShoppinglist(String usernum, int store_id) {
        String sql = "select * from goods where (store_id,goods_id) in (select store_id,goods_id from shoppinglist where usernum= ? and store_id= ?) ";
        List<Goods> goods = template.query(sql, new GoodsRowMapper(), usernum, store_id);
        return goods;
    }

    public static void deleteFromShoppinglist(String usernum, int store_id, int goods_id) {
        String sql = "delete from shoppinglist where usernum = ? and store_id = ? and goods_id =?";
        template.update(sql, usernum, store_id, goods_id);
    }
}

