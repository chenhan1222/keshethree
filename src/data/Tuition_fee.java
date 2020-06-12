package data;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import JDBCUtil.JDBCUtils;
import rowmapper.Tuition_feeRowMapper;
/*学费类*/
public class Tuition_fee {
	public String year;//年分
	public String term;//学期
	public String s_usernum;//学号
	public double cost;//学费金额
	public String paystatus;//学费支付状态
	public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//数据库连接池对象
	/**
	 * get() and set()方法
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
	 * 判断某信息是否已经录入
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
	 * 录入某学生某学期的学费信息（默认未支付状态）
	 * */
	public static void addTuition_fee(String year,String term,String s_usernum,double cost) {
		String sql = "insert into Tuition_fee values(?,?,?,?,?)";
		template.update(sql, year, term,s_usernum,cost,"未付款");
	}
	/**
	 * 删除某学生某学期的学费信息
	 * */
	public static void deleteTuition_fee(String year,String term,String s_usernum) {
		String sql = "delete from Tuition_fee where year=? and term =? and s_usernum=?";
		template.update(sql, year, term,s_usernum);
	}
	/**
	 * 获得某学生全部学费信息
	 * */
	public static List<Tuition_fee> getTuition_fee(String s_usernum) {
		String sql = "select * from Tuition_fee where s_usernum= ?";
		List<Tuition_fee> tuition_feelist = template.query(sql, new Tuition_feeRowMapper(),s_usernum);
		return tuition_feelist;
	}
	/**
	 *管理端 获得全部学费信息
	 * */
	public static List<Tuition_fee> getTuition_fee() {
		String sql = "select * from Tuition_fee ";
		List<Tuition_fee> tuition_feelist = template.query(sql, new Tuition_feeRowMapper());
		return tuition_feelist;
	}
	/**
	 * 学生获得某年某学期某支付状态学费信息
	 * */
	public static List<Tuition_fee> getTuition_fee(String s_usernum,String year,String term,String paystatus) {
		String sql = "select * from Tuition_fee where s_usernum= ? and year like ? and term like ? and paystatus like ?";
		if(year.equals("全部"))
			year="";
		if(term.equals("全部"))
			term="";
		if(paystatus.equals("全部"))
			paystatus="";
		System.out.println(year+","+term+","+paystatus);
		List<Tuition_fee> tuition_feelist = template.query(sql, new Tuition_feeRowMapper(),s_usernum,"%"+year+"%","%"+term+"%","%"+paystatus+"%");
		return tuition_feelist;
	}
	/**
	 * 管理人员模糊搜索学生学费信息
	 * */
	public static List<Tuition_fee> selectTuition_fee(String str) {
		String sql = "select * from Tuition_fee where s_usernum like ? or year like ? or term like ? or paystatus like ?";
		List<Tuition_fee> tuition_feelist = template.query(sql, new Tuition_feeRowMapper(),"%"+str+"%","%"+str+"%","%"+str+"%","%"+str+"%");
		return tuition_feelist;
	}

	/**
	 * 获得某学生某学期学费支付状态
	 * */
	public static String getPayStatus(String year,String term,String s_usernum) {
		String sql = "select paystatus from Tuition_fee where year=? and term =? and s_usernum=?";
		String paystatus = template.queryForObject(sql, String.class, year, term,s_usernum);
		return paystatus;


	}

	public static void main(String[] args) {
		List<Tuition_fee>a=getTuition_fee("1","全部","全部","全部");
		System.out.println(a.get(0).cost);
	}
}
