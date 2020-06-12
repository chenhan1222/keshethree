package data;
import org.springframework.jdbc.core.JdbcTemplate;
import JDBCUtil.JDBCUtils;
public class Login {
	public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//数据库连接池对象
	/**
	 * 学生登陆判断函数
	 * */
	public static int studentLogin(String s_usernum,String s_password) {
		String sql1="select count(*) from Student where s_usernum =?";
		String sql2="select count(*) from Student where s_usernum=? and s_password=?";
		int n= template.queryForObject(sql1, int.class, s_usernum);
		int m=template.queryForObject(sql2, int.class, s_usernum,s_password);
		if(n==0)
			return 0;//表示无此用户
		else if(m==0)
			return 1;//表示密码不正确
		return 2;//表示登陆成功
	}
	/**
	 * 管理人员登陆判断函数
	 * */
	public static int managerLogin(String m_usernum,String m_password) {
		String sql1="select count(*) from Manager where m_usernum =?";
		String sql2="select count(*) from Manager where m_usernum=? and m_password=?";
		int n= template.queryForObject(sql1, int.class, m_usernum);
		int m=template.queryForObject(sql2, int.class, m_usernum,m_password);
		if(n==0)
			return 0;//表示无此用户
		else if(m==0)
			return 1;//表示密码不正确
		return 2;//表示登陆成功
	}
	/**
	 * 教师登陆判断函数
	 * */
	public static int teacherLogin(String t_usernum,String t_password) {
		String sql1="select count(*) from Teacher where t_usernum =?";
		String sql2="select count(*) from Teacher where t_usernum=? and t_password=?";
		int n= template.queryForObject(sql1, int.class, t_usernum);
		int m=template.queryForObject(sql2, int.class, t_usernum,t_password);
		if(n==0)
			return 0;//表示无此用户
		else if(m==0)
			return 1;//表示密码不正确
		return 2;//表示登陆成功
	}
	/**
	 * 商家登陆判断函数
	 * */
	public static int storeLogin(String staff_usernum,String staff_password) {
		String sql1="select count(*) from Staff where staff_usernum =?";
		String sql2="select count(*) from Staff where staff_usernum=? and staff_password=?";
		String sql3="select count(*) from user_store where usernum=?";
		int n= template.queryForObject(sql1, int.class, staff_usernum);
		int m=template.queryForObject(sql2, int.class, staff_usernum,staff_password);
		int q=template.queryForObject(sql3, int.class, staff_usernum);
		if(n==0)
			return 0;//表示无此用户
		else if(m==0)
			return 1;//表示密码不正确
		else if(q==0)
			return 2;//表示未绑定商店
		return 3;//表示登陆成功
	}
	/**
	 * 商家修改密码判断账号
	 */
	public static int storeModifyLogin(String staff_usernum, String staff_password) {
		String sql1 = "select count(*) from Staff where staff_usernum =?";
		String sql2 = "select count(*) from Staff where staff_usernum=? and staff_password=?";
		int n = template.queryForObject(sql1, int.class, staff_usernum);
		int m = template.queryForObject(sql2, int.class, staff_usernum, staff_password);
		if (n == 0)
			return 0;//表示无此用户
		else if (m == 0)
			return 1;//表示密码不正确
		return 2;//表示输入的密码账号都准确
	}
}
