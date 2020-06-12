package data;
import org.springframework.jdbc.core.JdbcTemplate;
import JDBCUtil.JDBCUtils;
public class Login {
	public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//���ݿ����ӳض���
	/**
	 * ѧ����½�жϺ���
	 * */
	public static int studentLogin(String s_usernum,String s_password) {
		String sql1="select count(*) from Student where s_usernum =?";
		String sql2="select count(*) from Student where s_usernum=? and s_password=?";
		int n= template.queryForObject(sql1, int.class, s_usernum);
		int m=template.queryForObject(sql2, int.class, s_usernum,s_password);
		if(n==0)
			return 0;//��ʾ�޴��û�
		else if(m==0)
			return 1;//��ʾ���벻��ȷ
		return 2;//��ʾ��½�ɹ�
	}
	/**
	 * ������Ա��½�жϺ���
	 * */
	public static int managerLogin(String m_usernum,String m_password) {
		String sql1="select count(*) from Manager where m_usernum =?";
		String sql2="select count(*) from Manager where m_usernum=? and m_password=?";
		int n= template.queryForObject(sql1, int.class, m_usernum);
		int m=template.queryForObject(sql2, int.class, m_usernum,m_password);
		if(n==0)
			return 0;//��ʾ�޴��û�
		else if(m==0)
			return 1;//��ʾ���벻��ȷ
		return 2;//��ʾ��½�ɹ�
	}
	/**
	 * ��ʦ��½�жϺ���
	 * */
	public static int teacherLogin(String t_usernum,String t_password) {
		String sql1="select count(*) from Teacher where t_usernum =?";
		String sql2="select count(*) from Teacher where t_usernum=? and t_password=?";
		int n= template.queryForObject(sql1, int.class, t_usernum);
		int m=template.queryForObject(sql2, int.class, t_usernum,t_password);
		if(n==0)
			return 0;//��ʾ�޴��û�
		else if(m==0)
			return 1;//��ʾ���벻��ȷ
		return 2;//��ʾ��½�ɹ�
	}
	/**
	 * �̼ҵ�½�жϺ���
	 * */
	public static int storeLogin(String staff_usernum,String staff_password) {
		String sql1="select count(*) from Staff where staff_usernum =?";
		String sql2="select count(*) from Staff where staff_usernum=? and staff_password=?";
		String sql3="select count(*) from user_store where usernum=?";
		int n= template.queryForObject(sql1, int.class, staff_usernum);
		int m=template.queryForObject(sql2, int.class, staff_usernum,staff_password);
		int q=template.queryForObject(sql3, int.class, staff_usernum);
		if(n==0)
			return 0;//��ʾ�޴��û�
		else if(m==0)
			return 1;//��ʾ���벻��ȷ
		else if(q==0)
			return 2;//��ʾδ���̵�
		return 3;//��ʾ��½�ɹ�
	}
	/**
	 * �̼��޸������ж��˺�
	 */
	public static int storeModifyLogin(String staff_usernum, String staff_password) {
		String sql1 = "select count(*) from Staff where staff_usernum =?";
		String sql2 = "select count(*) from Staff where staff_usernum=? and staff_password=?";
		int n = template.queryForObject(sql1, int.class, staff_usernum);
		int m = template.queryForObject(sql2, int.class, staff_usernum, staff_password);
		if (n == 0)
			return 0;//��ʾ�޴��û�
		else if (m == 0)
			return 1;//��ʾ���벻��ȷ
		return 2;//��ʾ����������˺Ŷ�׼ȷ
	}
}
