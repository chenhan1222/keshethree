package data;

import JDBCUtil.JDBCUtils;
import rowmapper.Order_goodsRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/*
 * 订单商品类
 * 用来记录每个订单的具体商品信息
 * */
public class Order_goods {
    public int o_g_id;
    public String ordernum;//订单号
    public int store_id;//商店号
    public int goods_id;//商品号
    public int buynum;//购买数量
    public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 更新订单-菜品表
     **/
    public static void addorder_goods(String ordernum, int store_id, int goods_id, int buynum) {
        String sql = "select count(*)+1 from order_goods ";
        String sql1 = "insert into order_goods values(?,?,?,?,?)";
        int o_g_id = template.queryForObject(sql, int.class);
        template.update(sql1, o_g_id, ordernum, store_id, goods_id, buynum);

    }

    public static void addorder_goods(String ordernum, List<Order_goods> ordergoodslist) {
        String sql = "select max(o_g_id)+1 from order_goods ";
        String sql1 = "insert into order_goods values(?,?,?,?,?)";
        int o_g_id;
        try {
            o_g_id = template.queryForObject(sql, int.class);
        } catch (Exception e) {
            o_g_id = 1;
        }
        int size = ordergoodslist.size();
        for (int i = 0; i < size; i++) {
            template.update(sql1, o_g_id, ordernum, ordergoodslist.get(i).store_id, ordergoodslist.get(i).goods_id, ordergoodslist.get(i).buynum);
            o_g_id++;
        }

    }

    public static List<Order_goods> getOrder_GoodsList(String ordernum) {

        String sql = "select * from order_goods where ordernum = ?";
        //List<Order_goods> order_goodslist = template.query(sql, new BeanPropertyRowMapper<>(Order_goods.class),ordernum);
        List<Order_goods> order_goodslist = template.query(sql, new Order_goodsRowMapper(), ordernum);

        return order_goodslist;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }
}
