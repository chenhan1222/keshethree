package rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import data.Receiveaddress;

public class ReceiveAddressRowMapper implements RowMapper<Receiveaddress> {
	   public Receiveaddress mapRow(ResultSet rs, int i) throws SQLException {
		   Receiveaddress receiveaddress = new Receiveaddress();
           String usernum = rs.getString("usernum");
           String contact = rs.getString("contact");
           String address = rs.getString("address");
           String phonenum = rs.getString("phonenum");
           String sex = rs.getString("sex");
           receiveaddress.address = address;
           receiveaddress.contact = contact;
           receiveaddress.phonenum = phonenum;
           receiveaddress.sex = sex;
           receiveaddress.usernum = usernum;
           return receiveaddress;
      }
}
