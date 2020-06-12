package rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import data.Userorder;
/**
 * ��ѯ������Ϣ���Զ���RowMapper
 * */
public class UserorderRowMapper implements RowMapper<Userorder> {
    public Userorder mapRow(ResultSet rs, int i) throws SQLException {
        Userorder userorder = new Userorder();
        String ordernum = rs.getString("ordernum");//������
        String contact = rs.getString("contact");//��ϵ��
        String phonenum = rs.getString("phonenum");//�绰��
        String address = rs.getString("address");//��ϵ�˵�ַ
        int store_id = rs.getInt("store_id");//�̼���
        String note = rs.getString("note");
        String buytime = rs.getString("buytime");//�µ�ʱ��
        String orderstatus = rs.getString("orderstatus");//����״̬
        double total_price=rs.getDouble("total_price");//�����ܼ�
        String usernum = rs.getString("usernum");      //�û���
        userorder.setOrdernum(ordernum);
        userorder.setContact(contact);
        userorder.setPhonenum(phonenum);
        userorder.setAddress(address);
        userorder.setStore_id(store_id);
        userorder.setOrderstatus(orderstatus);
        userorder.setBuytime(buytime);
        userorder.setNote(note);
        userorder.setUsernum(usernum);
        userorder.setTotal_price(total_price);
        return userorder;

    }
}
