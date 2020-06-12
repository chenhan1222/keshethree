package data;

import JDBCUtil.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import rowmapper.StoreRowMapper;
import rowmapper.StudentRowMapper;

import java.util.List;

/*ѧ����*/
public class Student {
    public String s_usernum;//�˺ţ�ѧ�ţ�
    public String s_password;//����
    public String s_apartment_num;//��Ԣ��
    public String s_dormitory_num;//�����
    public String s_department_name;//ϵ��
    public String s_class_num;//����
    public String s_name;//ѧ������
    public String s_phonenum;//ѧ���绰��
    public String s_nickname;//ѧ���ǳ�
    public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//���ݿ����ӳض���

    /**
     * get() and set()����
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
     * �ж��Ƿ����ĳѧ������Ϣ
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
     * ����ѧ����Ϣ
     */
    public static void addStudent(String s_usernum, String s_password, String s_apartment_num, String s_dormitory_num, String s_department_name, String s_class_num, String s_name) {
        String sql = "insert into Student values(?,?,?,?,?,?,?,?,?)";
        template.update(sql, s_usernum, s_password, s_apartment_num, s_dormitory_num,  s_department_name,s_class_num, s_name, "��", "��");
    }

    /**
     * ������޸�ѧ����Ϣ
     */
    public static void modifyStudent(Student newstudent) {
        String sql = "update Student set s_password=?,s_apartment_num=?,s_dormitory_num=?,s_department_name=?,s_class_num=?,s_name=?,s_phonenum=?,s_nickname=? where s_usernum=?";
        template.update(sql, newstudent.s_password, newstudent.s_apartment_num, newstudent.s_dormitory_num, newstudent.s_department_name, newstudent.s_class_num, newstudent.s_name, newstudent.s_phonenum, newstudent.s_nickname, newstudent.s_usernum);
    }
    /**
     * ѧ�����޸�ѧ����Ϣ
     */
    public static void modifyStudent(String s_usernum,String s_apartment_num,String s_dormitory_num,String s_class_num,String s_name,String s_phonenum,String s_nickname) {
        String sql = "update Student set s_apartment_num=?,s_dormitory_num=?,s_class_num=?,s_name=?,s_phonenum=?,s_nickname=? where s_usernum=?";
        template.update(sql, s_apartment_num, s_dormitory_num,  s_class_num, s_name, s_phonenum, s_nickname,s_usernum);
    }
    /**
     * ɾ��ѧ����Ϣ
     */
    public static void deleteStudent(String s_usernum) {
        String sql = "delete from Student where s_usernum=?";
        template.update(sql, s_usernum);
    }

    /**
     * ��ȡ����ѧ����Ϣ
     */
    public static List<Student> getStudent() {
        String sql = "select * from Student";
        List<Student> studentlist = template.query(sql, new StudentRowMapper());
        return studentlist;
    }
    /**
     * ��ȡĳ��ѧ����Ϣ
     */
    public static Student getStudent(String s_usernum) {
        String sql = "select * from Student where s_usernum=?";
        Student student = template.queryForObject(sql, new StudentRowMapper(),s_usernum);
        return student;
    }
    /**
     * ��ѧ��ģ����ѯѧ����Ϣ
     */
    public static List<Student> selectStudentByS_usernum(String s_usernum) {
        String sql = "select *  from Student where s_usernum like ?";
        List<Student> studentlist = template.query(sql, new StudentRowMapper(), "%" + s_usernum + "%");
        return studentlist;
    }

    /**
     * ��ϵ��ģ����ѯѧ����Ϣ
     */
    public static List<Student> selectStudentByS_department_name(String s_department_name) {
        String sql = "select * from Student where s_department_name like ?";
        List<Student> studentlist = template.query(sql, new StudentRowMapper(), "%" + s_department_name + "%");
        return studentlist;
    }

    /**
     * ����Ԣģ����ѯѧ����Ϣ
     */
    public static List<Student> selectStudentByS_apartment_num(String s_apartment_num) {
        String sql = "select * from Student where s_apartment_num like ?";
        List<Student> studentlist = template.query(sql, new StudentRowMapper(), "%" + s_apartment_num + "%");
        return studentlist;
    }

    /**
     * �����ģ����ѯѧ����Ϣ
     */
    public static List<Student> selectStudentByS_class_num(String s_class_num) {
        String sql = "select * from Student where  s_class_num like ?";
        List<Student> studentlist = template.query(sql, new StudentRowMapper(), "%" + s_class_num + "%");
        return studentlist;
    }

    /**
     * ������ģ����ѯѧ����Ϣ
     */
    public static List<Student> selectStudentByS_name(String s_name) {
        String sql = "select * from Student where  s_name like ?";
        List<Student> studentlist = template.query(sql, new StudentRowMapper(), "%" + s_name + "%");
        return studentlist;
    }

    /**
     * ����ģ����ѯѧ����Ϣ
     */
    public static List<Student> selectStudent(String str) {
        String sql = "select * from Student where s_usernum like ? or s_department_name like ? or s_apartment_num like ? or s_class_num like ? or s_name like ?";
        List<Student> studentlist = template.query(sql, new StudentRowMapper(), "%" + str + "%", "%" + str + "%", "%" + str + "%", "%" + str + "%", "%" + str + "%");
        return studentlist;
    }

    /**
     * ��ӹ��ĵĵ���
     */
    public static void addUserfollow(String usernum, int store_id) {//Ϊ�ͻ���ӹ��ĵĵ���
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

    public static void deleteUserfollow(String usernum, int store_id) {//ȡ�����ĵĵ���
        String sql = "delete from focused_store where usernum =? and store_id=?";
        template.update(sql, usernum, store_id);
    }

    public static boolean ifFollow(String usernum, int store_id) {     //�ж��Ƿ������ĳ���̵ĺ���
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


    public static String getNickname(String usernum) {//����ǳ�
        String sql = "select nickname from Student where s_usernum=?";
        String nickname = template.queryForObject(sql, String.class, usernum);
        return nickname;

    }

    public static String getPhonenum(String usernum) {//��õ绰
        String sql = "select phonenum from Student where s_usernum=?";
        String nickname = template.queryForObject(sql, String.class, usernum);
        return nickname;

    }
    /**
     * �޸�����
     */
    public static void modifyStudentPassword(String s_usernum, String s_password) {
        String sql = "update Student set s_password=? where s_usernum=?";
        template.update(sql, s_password, s_usernum);
    }
	   
	    /*
	    public static void updatePersonalInformation(String usernum, String phonenum, String nickname, Image icon) {//�޸ĸ�����Ϣ
	        String sql = "update user set phonenum=?,nickname=? where usernum= ?";
	        template.update(sql, phonenum, nickname, usernum);
	        ImageDemo.readImage2DB(usernum, icon);
	    }
	    */
}
