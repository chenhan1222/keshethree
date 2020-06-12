package data;

import org.springframework.jdbc.core.JdbcTemplate;

import JDBCUtil.JDBCUtils;

/**
 * 用户商店绑定表
 * */
public class User_store {
	public int binding_id;
	public String usernum;
	public int store_id;
	public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public int getBinding_id() {
		return binding_id;
	}
	public void setBinding_id(int binding_id) {
		this.binding_id = binding_id;
	}
	public String getUsernum() {
		return usernum;
	}
	public void setUsernum(String usernum) {
		this.usernum = usernum;
	}
	
	
	/**
	 * 获取某用户对应的订单号
	 * */
	public static int getStore_id(String usernum) {//获取某商店的公告
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select store_id from user_store where usernum=?";
        int store_id = template.queryForObject(sql, int.class, usernum);
        return store_id;
    }
	
	
}
