package data;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.springframework.jdbc.core.JdbcTemplate;
import JDBCUtil.JDBCUtils;
import control_packet.ImageDemo;
import rowmapper.TeacherRowMapper;
/*教师类*/
public class Teacher {
	public String t_usernum;//账号（工号）
	public String t_password;//密码
	public String t_name;//姓名
	public String t_department_name;//系号
	public String t_phonenum;//手机号
	public String t_office;//办公室地点
	public String t_email;//电子邮箱
	public ImageIcon t_head_sculpture;//头像
	public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//数据库连接池对象
	/**
	 * get() and set()方法
	 * */
	public String getT_usernum() {
		return t_usernum;
	}
	public void setT_usernum(String t_usernum) {
		this.t_usernum = t_usernum;
	}
	public String getT_password() {
		return t_password;
	}
	public void setT_password(String t_password) {
		this.t_password = t_password;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_department_name() {
		return t_department_name;
	}
	public void setT_department_name(String t_department_name) {
		this.t_department_name = t_department_name;
	}
	public String getT_phonenum() {
		return t_phonenum;
	}
	public void setT_phonenum(String t_phonenum) {
		this.t_phonenum = t_phonenum;
	}
	public String getT_office() {
		return t_office;
	}
	public void setT_office(String t_office) {
		this.t_office = t_office;
	}
	public String getT_email() {
		return t_email;
	}
	public void setT_email(String t_email) {
		this.t_email = t_email;
	}
	public ImageIcon getT_head_sculpture() {
		return t_head_sculpture;
	}
	public void setT_head_sculpture(ImageIcon t_head_sculpture) {
		this.t_head_sculpture = t_head_sculpture;
	}
	
	/**
	 * 判断是否存在某教师的信息
	 * */
	public static boolean ifTeacherexist(String t_usernum) {	  
        String sql = "select t_usernum from student where t_usernum=?";
        try {
            template.queryForObject(sql, String.class, t_usernum);
        } catch (Exception e) {
            return false;
        }
        return true;
	}
	/**
	 * 增加教师信息
	 * @throws IOException 
	 * */
	public static void addTeacher(String t_usernum,String t_password,String t_name,String t_department_name,String t_phonenum,String t_office) throws IOException {	  
        String sql = "insert into Teacher values(?,?,?,?,?,?,?,?)";
    	FileInputStream fis = new FileInputStream("src/images/飞雁.jpg");
        template.update(sql, t_usernum, t_password, t_name,  t_department_name, t_phonenum, t_office,"无",fis);	
        fis.close();
	}
	/**
	  * 教师修改教师信息
	 * @throws IOException 
	 * */
	public static void t_modifyTeacher(Teacher newteacher) throws IOException {	  
        String sql = "update Teacher set t_password=?,t_name=?,t_department_name=?,t_phonenum=?,t_office=?,t_email=? where t_usernum=?";
        /*Image image=newteacher.t_head_sculpture.getImage();
        File outputfile = new File("D:\\java图标store.jpg");//存储商家上传的图片
        if (!outputfile.exists() && !outputfile.isDirectory()) {
            System.out.println("文件夹路径不存在，创建路径:");
            outputfile.mkdirs();
        } else {
            System.out.println("文件夹路径存在:");
        }
        ImageIO.write(ImageDemo.toBufferedImage(image), "jpg", outputfile);
        FileInputStream in = new FileInputStream("D:\\java图标store.jpg");*/
        template.update(sql,newteacher.t_password,newteacher.t_name,newteacher.t_department_name,newteacher.t_phonenum,newteacher.t_office,newteacher.t_email,newteacher.t_usernum);
	}
	/**
	  * 管理员修改教师信息
	 * 
	 * */
	public static void m_modifyTeacher(Teacher newteacher) throws IOException {	  
       String sql = "update Teacher set t_password=?,t_name=?,t_department_name=?,t_phonenum=?,t_office=? where t_usernum=?";
       template.update(sql,newteacher.t_password,newteacher.t_name,newteacher.t_department_name,newteacher.t_phonenum,newteacher.t_office,newteacher.t_usernum);	
	}
	/**
	 *删除教师信息
	 * */
	public static void deleteTeacher(String t_usernum) {	  
        String sql = "delete from Teacher where t_usernum=?";
        template.update(sql, t_usernum);	
	}
	/**
	 *获取所有教师信息
	 * */
	public static List<Teacher> getTeacher() {	  
        String sql = "select * from Teacher";
        List<Teacher> teacherlist = template.query(sql, new TeacherRowMapper());
        return teacherlist;
	}
	/**
	 *按学号模糊查询教师信息 
	 * */
	public static List<Teacher>  selectTeacherByT_usernum(String t_usernum) {	  
        String sql = "select *  from Teacher where t_usernum like ?";
        List<Teacher> teacherlist= template.query(sql, new TeacherRowMapper(), "%" + t_usernum + "%");
        return teacherlist;
	}
	/**
	 *按系名模糊查询教师信息 
	 * */
	public static List<Teacher>  selectTeacherByT_department_name(String t_department_name) {	 
        String sql = "select * from Teacher where t_department_name like ?";
        List<Teacher> teacherlist= template.query(sql, new TeacherRowMapper(), "%"+t_department_name + "%");
        return teacherlist;
	}
	/**
	 *按姓名模糊查询老师信息 
	 * */
	public static List<Teacher>  selectTeacherByt_name(String t_name) {	  
        String sql = "select * from Teacher where  t_name like ?";
        List<Teacher> teacherlist= template.query(sql,new TeacherRowMapper(), "%" +  t_name + "%");
        return teacherlist;
	}
	/**
	 *按办公室模糊查询老师信息 
	 * */
	public static List<Teacher>  selectTeacherByt_office(String t_office) {	  
        String sql = "select * from Teacher where  t_office like ?";
        List<Teacher> teacherlist= template.query(sql,new TeacherRowMapper(), "%" +  t_office + "%");
        return teacherlist;
	}
	/**
	 *整体模糊查询教师信息 
	 * */
	public static  List<Teacher>  selectTeacher(String str) {	 
        String sql = "select * from Teacher where t_usernum like ? or t_department_name like ? or t_name like ? or t_office like ?";
        List<Teacher> teacherlist= template.query(sql, new TeacherRowMapper(), "%"+str+"%","%"+str+"%","%"+str+"%","%"+str+"%");
        return teacherlist;
	}
	 /**
     * 修改密码
     */
    public static void modifyTeacherPassword(String t_usernum, String t_password) {
        String sql = "update Teacher set t_password=? where t_usernum=?";
        template.update(sql, t_password, t_usernum);
    }
}
