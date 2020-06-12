package data;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import JDBCUtil.JDBCUtils;
import rowmapper.Store_bindingRowMapper;
import rowmapper.StudentRowMapper;

public class Store_binding {
	public String staff_usernum;
	public String staff_name;
	public int store_id;
	public String store_name;
	public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//数据库连接池对象
	
	public String getStaff_usernum() {
		return staff_usernum;
	}
	public void setStaff_usernum(String staff_usernum) {
		this.staff_usernum = staff_usernum;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	/**
	 * 获得所有商店绑定信息
	 * */
	public static List<Store_binding> getAllStore_binding(){
		String sql="SELECT staff_usernum,staff_name,store_id,NAME store_name FROM (user_store LEFT JOIN staff ON user_store.usernum=staff.staff_usernum) NATURAL JOIN store";
		 List<Store_binding>store_bindingtlist= template.query(sql, new Store_bindingRowMapper());
	     return store_bindingtlist;
		
	}
	/**
	 * 搜索商店绑定信息(整体模糊查找)
	 * */
	public static List<Store_binding> selectStore_binding(String str){
		 String sql="SELECT staff_usernum,staff_name,store_id,NAME store_name FROM (user_store LEFT JOIN staff ON user_store.usernum=staff.staff_usernum) NATURAL JOIN store where staff_usernum like? or staff_name like ? or store_id like ? or store.name like ?";
		 List<Store_binding>store_bindingtlist= template.query(sql, new Store_bindingRowMapper(),"%"+str+"%","%"+str+"%","%"+str+"%","%"+str+"%");
	     return store_bindingtlist;
		
	}
	/**
	 * 解除绑定(同时删除商店和所有商品信息)
	 * */
	public static void deleteStore_binding(int store_id){
		 String sql="delete from User_store where store_id=?"; 
		 String sql1="delete from Goods where store_id= ?";
		 String sql2="delete from Store where store_id =?";
		 template.update(sql,store_id);
		 template.update(sql1,store_id);
		 template.update(sql2,store_id);	 
	}
	/**
	 * 修改绑定
	 * */
	public static void modifyStore_binding(int store_id,String usernum){
		 String sql="update user_store set usernum=? where store_id=?";
		 template.update(sql,usernum,store_id);		
	}
}
