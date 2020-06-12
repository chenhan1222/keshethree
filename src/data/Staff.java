package data;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import JDBCUtil.JDBCUtils;
import rowmapper.StaffRowMapper;
/*У�ڹ�����Ա��*/
public class Staff {
	public String staff_usernum;//�˺ţ����ţ�
	public String staff_password;//����
	public String staff_name;//����
	public String staff_worktype;//��������
	public String staff_phonenum;//�ֻ���
	public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//���ݿ����ӳض���
	//public static 
	/**
	 * get() and set()����
	 * */
	
	public String getStaff_usernum() {
		return staff_usernum;
	}
	public void setStaff_usernum(String staff_usernum) {
		this.staff_usernum = staff_usernum;
	}
	public String getStaff_password() {
		return staff_password;
	}
	public void setStaff_password(String staff_password) {
		this.staff_password = staff_password;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getStaff_worktype() {
		return staff_worktype;
	}
	public void setStaff_worktype(String staff_worktype) {
		this.staff_worktype = staff_worktype;
	}
	public String getStaff_phonenum() {
		return staff_phonenum;
	}
	public void setStaff_phonenum(String staff_phonenum) {
		this.staff_phonenum = staff_phonenum;
	}
	/**
	 * �ж��Ƿ����ĳ������Ա����Ϣ
	 * */
	public static boolean ifStaffexist(String staff_usernum) {	  
        String sql = "select staff_usernum from Staff where staff_usernum=?";
        try {
            template.queryForObject(sql, String.class, staff_usernum);
        } catch (Exception e) {
            return false;
        }
        return true;
	}
	/**
	 * �ж��Ƿ���й��̵��
	 * */
	public static boolean ifstore_bindingexist(String staff_usernum) {	  
        String sql = "select usernum from user_store where usernum=?";
        try {
            template.queryForObject(sql, String.class, staff_usernum);
        } catch (Exception e) {
            return false;
        }
        return true;
	}
	
	/**
	 * ���ӹ�����Ա��Ϣ
	 * */
	public static void addStaff(String staff_usernum,String staff_password,String staff_name,String staff_worktype,String staff_phonenum)  {	  
        String sql = "insert into Staff values(?,?,?,?,?)";
        template.update(sql, staff_usernum, staff_password,staff_name,staff_worktype,staff_phonenum);	
	}
	/**
	 * �޸�Ա����Ϣ
	 * */
	public static void modifyStaff(Staff newstaff) {	  
        String sql = "update Staff set staff_password=?,staff_name=?,staff_worktype=?,staff_phonenum=? where staff_usernum=?";
        template.update(sql, newstaff.staff_password,newstaff.staff_name,newstaff.staff_worktype,newstaff.staff_phonenum,newstaff.staff_usernum);	
	}
	/**
	 * �޸�����
	 * */
	public static void modifyStaffPassword(String staff_usernum,String staff_password) {	  
        String sql = "update Staff set staff_password=? where staff_usernum=?";
        template.update(sql, staff_password,staff_usernum);	
	}
	/**
	 *ɾ��������Ա��Ϣ
	 * */
	public static void deleteStaff(String staff_usernum) {	  
        String sql = "delete from Staff where staff_usernum=?";
        template.update(sql, staff_usernum);	
	}
	/**
	 *��ȡ���й�����Ա��Ϣ
	 * */
	public static List<Staff> getStaff() {	  
        String sql = "select * from Staff";
        List<Staff> stafflist = template.query(sql, new StaffRowMapper());
        return stafflist;
	}
	/**
	 *����ģ����ѯ������Ա��Ϣ (���ţ���������������)
	 * */
	public static  List<Staff>  selectStafft(String str) {	 
        String sql = "select * from Staff where staff_usernum like ? or staff_name like ? or staff_worktype like ?";
        List<Staff>stafflist= template.query(sql, new StaffRowMapper(), "%"+str+"%","%"+str+"%","%"+str+"%");
        return stafflist;
	}
	
	
	
	
}
