package data;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import JDBCUtil.JDBCUtils;
import rowmapper.Tuition_feeRowMapper;
/*ѧ����*/
public class Tuition_fee {
	public String year;//���
	public String term;//ѧ��
	public String s_usernum;//ѧ��
	public double cost;//ѧ�ѽ��
	public String paystatus;//ѧ��֧��״̬
	public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//���ݿ����ӳض���
	/**
	 * get() and set()����
	 * */
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getS_usernum() {
		return s_usernum;
	}
	public void setS_usernum(String s_usernum) {
		this.s_usernum = s_usernum;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}
	/**
	 * �ж�ĳ��Ϣ�Ƿ��Ѿ�¼��
	 * */
	public static boolean ifTuition_feeexist(String year,String term,String s_usernum) {
		String sql = "select year from Tuition_fee where year=? and term =? and s_usernum =?";
		try {
			template.queryForObject(sql, String.class, year,term,s_usernum);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * ¼��ĳѧ��ĳѧ�ڵ�ѧ����Ϣ��Ĭ��δ֧��״̬��
	 * */
	public static void addTuition_fee(String year,String term,String s_usernum,double cost) {
		String sql = "insert into Tuition_fee values(?,?,?,?,?)";
		template.update(sql, year, term,s_usernum,cost,"δ����");
	}
	/**
	 * ɾ��ĳѧ��ĳѧ�ڵ�ѧ����Ϣ
	 * */
	public static void deleteTuition_fee(String year,String term,String s_usernum) {
		String sql = "delete from Tuition_fee where year=? and term =? and s_usernum=?";
		template.update(sql, year, term,s_usernum);
	}
	/**
	 * ���ĳѧ��ȫ��ѧ����Ϣ
	 * */
	public static List<Tuition_fee> getTuition_fee(String s_usernum) {
		String sql = "select * from Tuition_fee where s_usernum= ?";
		List<Tuition_fee> tuition_feelist = template.query(sql, new Tuition_feeRowMapper(),s_usernum);
		return tuition_feelist;
	}
	/**
	 *����� ���ȫ��ѧ����Ϣ
	 * */
	public static List<Tuition_fee> getTuition_fee() {
		String sql = "select * from Tuition_fee ";
		List<Tuition_fee> tuition_feelist = template.query(sql, new Tuition_feeRowMapper());
		return tuition_feelist;
	}
	/**
	 * ѧ�����ĳ��ĳѧ��ĳ֧��״̬ѧ����Ϣ
	 * */
	public static List<Tuition_fee> getTuition_fee(String s_usernum,String year,String term,String paystatus) {
		String sql = "select * from Tuition_fee where s_usernum= ? and year like ? and term like ? and paystatus like ?";
		if(year.equals("ȫ��"))
			year="";
		if(term.equals("ȫ��"))
			term="";
		if(paystatus.equals("ȫ��"))
			paystatus="";
		System.out.println(year+","+term+","+paystatus);
		List<Tuition_fee> tuition_feelist = template.query(sql, new Tuition_feeRowMapper(),s_usernum,"%"+year+"%","%"+term+"%","%"+paystatus+"%");
		return tuition_feelist;
	}
	/**
	 * ������Աģ������ѧ��ѧ����Ϣ
	 * */
	public static List<Tuition_fee> selectTuition_fee(String str) {
		String sql = "select * from Tuition_fee where s_usernum like ? or year like ? or term like ? or paystatus like ?";
		List<Tuition_fee> tuition_feelist = template.query(sql, new Tuition_feeRowMapper(),"%"+str+"%","%"+str+"%","%"+str+"%","%"+str+"%");
		return tuition_feelist;
	}

	/**
	 * ���ĳѧ��ĳѧ��ѧ��֧��״̬
	 * */
	public static String getPayStatus(String year,String term,String s_usernum) {
		String sql = "select paystatus from Tuition_fee where year=? and term =? and s_usernum=?";
		String paystatus = template.queryForObject(sql, String.class, year, term,s_usernum);
		return paystatus;


	}

	public static void main(String[] args) {
		List<Tuition_fee>a=getTuition_fee("1","ȫ��","ȫ��","ȫ��");
		System.out.println(a.get(0).cost);
	}
}
