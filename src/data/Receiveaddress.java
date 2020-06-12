package data;
import JDBCUtil.JDBCUtils;
import rowmapper.ReceiveAddressRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * * 收货地址类
 **/
public class Receiveaddress {
    public int r_id;//收货信息号
	public String usernum;
    public String contact;//联系人;
    public String address;//收货地址
    public String phonenum;//联系电话
    public String sex;//性别
    public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public static void addReceiveAddress(Receiveaddress newaddress) {//添加收获地址
        String sql1="select max(r_id)+1 from receiveaddress";
        String sql2 = "insert into receiveaddress values(?,?,?,?,?,?)";
        int r_id;
        try {
            r_id = template.queryForObject(sql1, int.class);
        } catch (Exception e) {
            r_id=1;
        }
        template.update(sql2, r_id,newaddress.usernum, newaddress.contact, newaddress.address, newaddress.phonenum, newaddress.sex);
    }

    public static List<Receiveaddress> getReceiveAddress(String usernum) {//获得收获地址  
        String sql = "select * from receiveaddress where usernum = ? ";
        List<Receiveaddress> list = template.query(sql, new ReceiveAddressRowMapper(), usernum);
        return list;
    }

    public static void updateAddress(Receiveaddress newaddress) {//更新地址    
        String sql = "update receiveaddress set address=?,phonenum=?,sex=? where usernum=? and contact=?";
        template.update(sql, newaddress.address, newaddress.phonenum, newaddress.sex, newaddress.usernum, newaddress.contact);
    }

    public static void deleteAddress(String usernum, String contact) {//删除地址按钮   
        String sql = "delete from receiveaddress where usernum=? and contact =?";
        template.update(sql, usernum, contact);
    }

}
