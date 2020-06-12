package rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import data.Store_binding;;

public class Store_bindingRowMapper implements RowMapper<Store_binding>  {
	public Store_binding mapRow(ResultSet rs, int i) throws SQLException {
		  Store_binding store_binding = new Store_binding();
		  String staff_usernum = rs.getString("staff_usernum");
	      String staff_name = rs.getString("staff_name");
	      int store_id = rs.getInt("store_id");
	      String store_name =rs.getString("store_name");
	      store_binding.setStaff_usernum(staff_usernum);
	      store_binding.setStore_id(store_id);
	      store_binding.setStaff_name(staff_name);
	      store_binding.setStore_name(store_name);
	      return  store_binding;       
	}
}