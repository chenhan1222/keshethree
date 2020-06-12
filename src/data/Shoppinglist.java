package data;
import JDBCUtil.JDBCUtils;
import rowmapper.GoodsRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
//购物车类
public class Shoppinglist {
	public int shoppinglist_id;//购物号
    public String usernum;//用户账号
    public int store_id;//商店号
    public int goods_id;//商品号
    public int buynum;//购买数量
	public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 获得对商品的购买数量
     */
    public static int getBuyNum(String usernum, int store_id, int goods_id) {
        String sql = "select buynum from shoppinglist where usernum=? and store_id =? and goods_id=?";
        int buynum = template.queryForObject(sql, int.class, usernum, store_id, goods_id);
        return buynum;
    }
    /**
        * 添加商品进入购物车，如果商品已存在则重新计算购买数量
    * */
    public static void addShoppinglist(String usernum, int store_id, int goods_id, int buynum) {//某店铺的购物车
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
     * 获得某用户在某商店的购物车
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

