package data;

import org.springframework.jdbc.core.JdbcTemplate;

import JDBCUtil.JDBCUtils;

/*管理人员类*/
public class Manager {
	public String m_usernum;//管理者账号(工号)
	public String m_password;//密码	
	public String m_name;//姓名
	public String m_phonennum;//电话号
	public String m_office;//办公室地点
	public String m_email;//电子邮箱
	public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//数据库连接池对象
	/**
	 * get() and set()方法
	 * */
	public String getM_usernum() {
		return m_usernum;
	}
	public void setM_usernum(String m_usernum) {
		this.m_usernum = m_usernum;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_phonennum() {
		return m_phonennum;
	}
	public void setM_phonennum(String m_phonennum) {
		this.m_phonennum = m_phonennum;
	}
	public String getM_office() {
		return m_office;
	}
	public void setM_office(String m_office) {
		this.m_office = m_office;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	 /**
     * 修改密码
     */
    public static void modifyManagerPassword(String m_usernum, String m_password) {
        String sql = "update Manager set m_password=? where m_usernum=?";
        template.update(sql, m_password, m_usernum);
    }
}
