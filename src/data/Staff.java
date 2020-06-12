package data;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import JDBCUtil.JDBCUtils;
import rowmapper.StaffRowMapper;
/*校内工作人员类*/
public class Staff {
	public String staff_usernum;//账号（工号）
	public String staff_password;//密码
	public String staff_name;//姓名
	public String staff_worktype;//工作类型
	public String staff_phonenum;//手机号
	public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//数据库连接池对象
	//public static 
	/**
	 * get() and set()方法
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
	 * 判断是否存在某工作人员的信息
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
	 * 判断是否进行过商店绑定
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
	 * 增加工作人员信息
	 * */
	public static void addStaff(String staff_usernum,String staff_password,String staff_name,String staff_worktype,String staff_phonenum)  {	  
        String sql = "insert into Staff values(?,?,?,?,?)";
        template.update(sql, staff_usernum, staff_password,staff_name,staff_worktype,staff_phonenum);	
	}
	/**
	 * 修改员工信息
	 * */
	public static void modifyStaff(Staff newstaff) {	  
        String sql = "update Staff set staff_password=?,staff_name=?,staff_worktype=?,staff_phonenum=? where staff_usernum=?";
        template.update(sql, newstaff.staff_password,newstaff.staff_name,newstaff.staff_worktype,newstaff.staff_phonenum,newstaff.staff_usernum);	
	}
	/**
	 * 修改密码
	 * */
	public static void modifyStaffPassword(String staff_usernum,String staff_password) {	  
        String sql = "update Staff set staff_password=? where staff_usernum=?";
        template.update(sql, staff_password,staff_usernum);	
	}
	/**
	 *删除工作人员信息
	 * */
	public static void deleteStaff(String staff_usernum) {	  
        String sql = "delete from Staff where staff_usernum=?";
        template.update(sql, staff_usernum);	
	}
	/**
	 *获取所有工作人员信息
	 * */
	public static List<Staff> getStaff() {	  
        String sql = "select * from Staff";
        List<Staff> stafflist = template.query(sql, new StaffRowMapper());
        return stafflist;
	}
	/**
	 *整体模糊查询工作人员信息 (工号，姓名，工作类型)
	 * */
	public static  List<Staff>  selectStafft(String str) {	 
        String sql = "select * from Staff where staff_usernum like ? or staff_name like ? or staff_worktype like ?";
        List<Staff>stafflist= template.query(sql, new StaffRowMapper(), "%"+str+"%","%"+str+"%","%"+str+"%");
        return stafflist;
	}
	
	
	
	
}
