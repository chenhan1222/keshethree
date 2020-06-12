package rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import data.Staff;
public class StaffRowMapper implements RowMapper<Staff>  {
	public Staff mapRow(ResultSet rs, int i) throws SQLException {
		  Staff staff = new Staff();
		  String staff_usernum = rs.getString("staff_usernum");
	      String staff_password = rs.getString("staff_password");   
	      String staff_name = rs.getString("staff_name");
	      String staff_worktype = rs.getString("staff_worktype");
	      String staff_phonenum =rs.getString("staff_phonenum");
	      staff.setStaff_usernum(staff_usernum);
	      staff.setStaff_password(staff_password);
	      staff.setStaff_phonenum(staff_phonenum);
	      staff.setStaff_usernum(staff_usernum);
	      staff.setStaff_worktype(staff_worktype);
	      staff.setStaff_name(staff_name);
	      return staff;       
	  }
}
