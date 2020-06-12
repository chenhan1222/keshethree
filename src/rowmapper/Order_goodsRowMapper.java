package rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import data.Order_goods;
public class Order_goodsRowMapper implements RowMapper<Order_goods>{
	  public Order_goods mapRow(ResultSet rs, int i) throws SQLException {
          Order_goods order_goods = new Order_goods();
          String ordernum = rs.getString("ordernum");//订单号
          int store_id = rs.getInt("store_id");//商店号
          int goods_id = rs.getInt("goods_id");//商品号
          int buynum = rs.getInt("buynum");//购买数量
          order_goods.setGoods_id(goods_id);
          order_goods.setBuynum(buynum);
          order_goods.setOrdernum(ordernum);
          order_goods.setStore_id(store_id);
          return order_goods;
      }
}
