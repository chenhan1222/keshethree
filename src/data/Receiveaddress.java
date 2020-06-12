package data;
import JDBCUtil.JDBCUtils;
import rowmapper.ReceiveAddressRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * * �ջ���ַ��
 **/
public class Receiveaddress {
    public int r_id;//�ջ���Ϣ��
	public String usernum;
    public String contact;//��ϵ��;
    public String address;//�ջ���ַ
    public String phonenum;//��ϵ�绰
    public String sex;//�Ա�
    public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public static void addReceiveAddress(Receiveaddress newaddress) {//����ջ��ַ
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

    public static List<Receiveaddress> getReceiveAddress(String usernum) {//����ջ��ַ  
        String sql = "select * from receiveaddress where usernum = ? ";
        List<Receiveaddress> list = template.query(sql, new ReceiveAddressRowMapper(), usernum);
        return list;
    }

    public static void updateAddress(Receiveaddress newaddress) {//���µ�ַ    
        String sql = "update receiveaddress set address=?,phonenum=?,sex=? where usernum=? and contact=?";
        template.update(sql, newaddress.address, newaddress.phonenum, newaddress.sex, newaddress.usernum, newaddress.contact);
    }

    public static void deleteAddress(String usernum, String contact) {//ɾ����ַ��ť   
        String sql = "delete from receiveaddress where usernum=? and contact =?";
        template.update(sql, usernum, contact);
    }

}
