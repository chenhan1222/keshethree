package data;

import org.springframework.jdbc.core.JdbcTemplate;

import JDBCUtil.JDBCUtils;

/*������Ա��*/
public class Manager {
	public String m_usernum;//�������˺�(����)
	public String m_password;//����	
	public String m_name;//����
	public String m_phonennum;//�绰��
	public String m_office;//�칫�ҵص�
	public String m_email;//��������
	public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//���ݿ����ӳض���
	/**
	 * get() and set()����
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
     * �޸�����
     */
    public static void modifyManagerPassword(String m_usernum, String m_password) {
        String sql = "update Manager set m_password=? where m_usernum=?";
        template.update(sql, m_password, m_usernum);
    }
}
