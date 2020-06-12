package rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import data.Student;
	public class StudentRowMapper implements RowMapper<Student> {
	      //  获取结果集中的数据
	public Student mapRow(ResultSet rs, int i) throws SQLException {
	  Student student = new Student();
	  String s_usernum = rs.getString("s_usernum");
      String s_password = rs.getString("s_password");
      String s_apartment_num = rs.getString("s_apartment_num");
      String s_dormitory_num = rs.getString("s_dormitory_num");
      String s_department_name= rs.getString("s_department_name");
      String s_class_num = rs.getString("s_class_num");
      String s_name = rs.getString("s_name");
      String s_phonenum = rs.getString("s_phonenum");
      String s_nickname =rs.getString("s_nickname");
      student.setS_apartment_num(s_apartment_num);
      student.setS_class_num(s_class_num);
      student.setS_department_name(s_department_name);
      student.setS_dormitory_num(s_dormitory_num);
      student.setS_name(s_name);
      student.setS_nickname(s_nickname);
      student.setS_password(s_password);
      student.setS_phonenum(s_phonenum);
      student.setS_usernum(s_usernum);    
      return student;       
  }
}

