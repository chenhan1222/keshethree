package data;

import JDBCUtil.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import rowmapper.StoreRowMapper;
import rowmapper.StudentRowMapper;

import java.util.List;

/*学生类*/
public class Student {
    public String s_usernum;//账号（学号）
    public String s_password;//密码
    public String s_apartment_num;//公寓号
    public String s_dormitory_num;//宿舍号
    public String s_department_name;//系名
    public String s_class_num;//班名
    public String s_name;//学生名字
    public String s_phonenum;//学生电话号
    public String s_nickname;//学生昵称
    public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//数据库连接池对象

    /**
     * get() and set()方法
     */
    public String getS_usernum() {
        return s_usernum;
    }

    public void setS_usernum(String s_usernum) {
        this.s_usernum = s_usernum;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

    public String getS_apartment_num() {
        return s_apartment_num;
    }

    public void setS_apartment_num(String s_apartment_num) {
        this.s_apartment_num = s_apartment_num;
    }

    public String getS_dormitory_num() {
        return s_dormitory_num;
    }

    public void setS_dormitory_num(String s_dormitory_num) {
        this.s_dormitory_num = s_dormitory_num;
    }

    public String getS_department_name() {
        return s_department_name;
    }

    public void setS_department_name(String s_department_name) {
        this.s_department_name = s_department_name;
    }

    public String getS_class_num() {
        return s_class_num;
    }

    public void setS_class_num(String s_class_num) {
        this.s_class_num = s_class_num;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_phonenum() {
        return s_phonenum;
    }

    public void setS_phonenum(String s_phonenum) {
        this.s_phonenum = s_phonenum;
    }

    public String getS_nickname() {
        return s_nickname;
    }

    public void setS_nickname(String s_nickname) {
        this.s_nickname = s_nickname;
    }

    /**
     * 判断是否存在某学生的信息
     */
    public static boolean ifStudentexist(String s_usernum) {
        String sql = "select s_usernum from student where s_usernum=?";
        try {
            template.queryForObject(sql, String.class, s_usernum);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 增加学生信息
     */
    public static void addStudent(String s_usernum, String s_password, String s_apartment_num, String s_dormitory_num, String s_department_name, String s_class_num, String s_name) {
        String sql = "insert into Student values(?,?,?,?,?,?,?,?,?)";
        template.update(sql, s_usernum, s_password, s_apartment_num, s_dormitory_num,  s_department_name,s_class_num, s_name, "无", "无");
    }

    /**
     * 管理端修改学生信息
     */
    public static void modifyStudent(Student newstudent) {
        String sql = "update Student set s_password=?,s_apartment_num=?,s_dormitory_num=?,s_department_name=?,s_class_num=?,s_name=?,s_phonenum=?,s_nickname=? where s_usernum=?";
        template.update(sql, newstudent.s_password, newstudent.s_apartment_num, newstudent.s_dormitory_num, newstudent.s_department_name, newstudent.s_class_num, newstudent.s_name, newstudent.s_phonenum, newstudent.s_nickname, newstudent.s_usernum);
    }
    /**
     * 学生端修改学生信息
     */
    public static void modifyStudent(String s_usernum,String s_apartment_num,String s_dormitory_num,String s_class_num,String s_name,String s_phonenum,String s_nickname) {
        String sql = "update Student set s_apartment_num=?,s_dormitory_num=?,s_class_num=?,s_name=?,s_phonenum=?,s_nickname=? where s_usernum=?";
        template.update(sql, s_apartment_num, s_dormitory_num,  s_class_num, s_name, s_phonenum, s_nickname,s_usernum);
    }
    /**
     * 删除学生信息
     */
    public static void deleteStudent(String s_usernum) {
        String sql = "delete from Student where s_usernum=?";
        template.update(sql, s_usernum);
    }

    /**
     * 获取所有学生信息
     */
    public static List<Student> getStudent() {
        String sql = "select * from Student";
        List<Student> studentlist = template.query(sql, new StudentRowMapper());
        return studentlist;
    }
    /**
     * 获取某个学生信息
     */
    public static Student getStudent(String s_usernum) {
        String sql = "select * from Student where s_usernum=?";
        Student student = template.queryForObject(sql, new StudentRowMapper(),s_usernum);
        return student;
    }
    /**
     * 按学号模糊查询学生信息
     */
    public static List<Student> selectStudentByS_usernum(String s_usernum) {
        String sql = "select *  from Student where s_usernum like ?";
        List<Student> studentlist = template.query(sql, new StudentRowMapper(), "%" + s_usernum + "%");
        return studentlist;
    }

    /**
     * 按系名模糊查询学生信息
     */
    public static List<Student> selectStudentByS_department_name(String s_department_name) {
        String sql = "select * from Student where s_department_name like ?";
        List<Student> studentlist = template.query(sql, new StudentRowMapper(), "%" + s_department_name + "%");
        return studentlist;
    }

    /**
     * 按公寓模糊查询学生信息
     */
    public static List<Student> selectStudentByS_apartment_num(String s_apartment_num) {
        String sql = "select * from Student where s_apartment_num like ?";
        List<Student> studentlist = template.query(sql, new StudentRowMapper(), "%" + s_apartment_num + "%");
        return studentlist;
    }

    /**
     * 按班号模糊查询学生信息
     */
    public static List<Student> selectStudentByS_class_num(String s_class_num) {
        String sql = "select * from Student where  s_class_num like ?";
        List<Student> studentlist = template.query(sql, new StudentRowMapper(), "%" + s_class_num + "%");
        return studentlist;
    }

    /**
     * 按姓名模糊查询学生信息
     */
    public static List<Student> selectStudentByS_name(String s_name) {
        String sql = "select * from Student where  s_name like ?";
        List<Student> studentlist = template.query(sql, new StudentRowMapper(), "%" + s_name + "%");
        return studentlist;
    }

    /**
     * 整体模糊查询学生信息
     */
    public static List<Student> selectStudent(String str) {
        String sql = "select * from Student where s_usernum like ? or s_department_name like ? or s_apartment_num like ? or s_class_num like ? or s_name like ?";
        List<Student> studentlist = template.query(sql, new StudentRowMapper(), "%" + str + "%", "%" + str + "%", "%" + str + "%", "%" + str + "%", "%" + str + "%");
        return studentlist;
    }

    /**
     * 添加关心的店铺
     */
    public static void addUserfollow(String usernum, int store_id) {//为客户添加关心的店铺
        String sql = "select max(f_id)+1 from focused_store";
        String sql1 = "insert into focused_store values(?,?,?)";
        int f_id;
        try {
            f_id = template.queryForObject(sql, int.class);
        } catch (Exception e) {
            f_id = 1;
        }
        template.update(sql1, f_id, usernum, store_id);
    }

    public static void deleteUserfollow(String usernum, int store_id) {//取消关心的店铺
        String sql = "delete from focused_store where usernum =? and store_id=?";
        template.update(sql, usernum, store_id);
    }

    public static boolean ifFollow(String usernum, int store_id) {     //判断是否关心了某店铺的函数
        String sql = "select usernum from focused_store where usernum =? and store_id =?";
        String rs = null;
        try {
            rs = template.queryForObject(sql, String.class, usernum, store_id);
        } catch (EmptyResultDataAccessException e) {
            rs = null;
        }
        if (rs == null)
            return false;
        else
            return true;
    }

    public static List<Store> getYourFollwStores(String usernum) {
        String sql = "select * from store where store_id in (select store_id from focused_store where usernum =?)";
        List<Store> stores = template.query(sql, new StoreRowMapper(), usernum);
        return stores;
    }


    public static String getNickname(String usernum) {//获得昵称
        String sql = "select nickname from Student where s_usernum=?";
        String nickname = template.queryForObject(sql, String.class, usernum);
        return nickname;

    }

    public static String getPhonenum(String usernum) {//获得电话
        String sql = "select phonenum from Student where s_usernum=?";
        String nickname = template.queryForObject(sql, String.class, usernum);
        return nickname;

    }
    /**
     * 修改密码
     */
    public static void modifyStudentPassword(String s_usernum, String s_password) {
        String sql = "update Student set s_password=? where s_usernum=?";
        template.update(sql, s_password, s_usernum);
    }
	   
	    /*
	    public static void updatePersonalInformation(String usernum, String phonenum, String nickname, Image icon) {//修改个人信息
	        String sql = "update user set phonenum=?,nickname=? where usernum= ?";
	        template.update(sql, phonenum, nickname, usernum);
	        ImageDemo.readImage2DB(usernum, icon);
	    }
	    */
}
