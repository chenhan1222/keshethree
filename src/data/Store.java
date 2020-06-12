package data;
import JDBCUtil.JDBCUtils;
import rowmapper.StoreRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.io.InputStream;
import java.util.List;
/**
 * �̵���Ϣ��
 **/
public class Store {
    public int store_id;
    public String name;
    public double grade;//����
    public String address;//�̵��ַ
    public String notice;//����
    public int salesnum;
    public int deliverytime;//����ʱ��
    public String storephone;//�̵���ϵ�绰
    public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public static int getStore_id(String usernum) {//����̵���
        String sql = "select store_id from user_store where usernum=?";
        int store_id = template.queryForObject(sql, int.class, usernum);
        return store_id;
    }
    
    public static boolean ifRegist(String usernum) {//�ж��û��Ƿ�ע�����̵�
        String sql = "select store_id from user_store where usernum=?";
        try {
            template.queryForObject(sql, int.class, usernum);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void addStore(String usernum, String name, String notice, String address, String storephone) {//ע���̵�
        String sql = "select max(store_id)+1 from store";
        String sql1 = "insert into store values(?,?,?,?,?,?,?,?)";
        String sql2 = "select max(store_id)+1 from user_store";
        String sql3 = "insert into user_store values(?,?,?)";
        int store_id;    //�Զ������̵���      
        int binding_id;
        try {
            store_id = template.queryForObject(sql, int.class);
        } catch (Exception e) {
            store_id = 1;
        }
        try {
            binding_id = template.queryForObject(sql2, int.class);
        } catch (Exception e) {
            binding_id = 1;
        }
        template.update(sql1, store_id, name, notice, 5, 0, address, 40, storephone);
        template.update(sql3,  binding_id,usernum, store_id);
    }

    public static List<Store> getstores() {
        String sql = "select * from store ";
        List<Store> stores = template.query(sql, new StoreRowMapper());
        return stores;

    }

    public static List<Store> getstores(String storename) {
        String sql = "select * from store where name like ?";
        List<Store> stores = template.query(sql, new StoreRowMapper(), "%" + storename + "%");
        return stores;

    }

    public static List<Store> sqlSortByGrade() {//���ݿ��ѯֱ�Ӱ���������
        String sql = "select * from store order by grade DESC";
        List<Store> stores = template.query(sql, new StoreRowMapper());
        return stores;
    }

    public static List<Store> sqlSortByMonthsale() {//���ݿ��ѯֱ�Ӱ�������������
        String sql = "select * from store order by salenum DESC";
        List<Store> stores = template.query(sql, new  StoreRowMapper());
        return stores;
    }

    public static void updateNotice(int store_id, String newnotice) {//���¹���
        String sql = "update store set notice=? where store_id=?";
        template.update(sql, newnotice, store_id);
    }

    public static void updateName(int store_id, String newname) {//��������
        String sql = "update store set name=? where store_id=?";
        template.update(sql, newname, store_id);
    }

    public static void updateSalesNum(int store_id) {//�����̵�����������������+1��
        String sql = "update store set salenum=salenum+1 where store_id=?";
        template.update(sql, store_id);
    }

    public static void updatePhoneNum(int store_id, String storephone) {//�����̵���ϵ��ʽ
        String sql = "update store set storephone=? where store_id=?";
        template.update(sql, storephone, store_id);
    }

    public static void updateAddress(int store_id, String address) {//�����̵���ϵ��ʽ
        String sql = "update store set address=? where store_id=?";
        template.update(sql, address, store_id);
    }

    public static String getStoreName(int store_id) {//��ȡĳ�̵������
        String sql = "select name from store where store_id=?";
        String storename;
		try {
			storename = template.queryForObject(sql, String.class, store_id);
		} catch (Exception e) {
			storename="�̵���Ϣ��ɾ��";
		}
        return storename;
    }

    public static String getNotice(int store_id) {//��ȡĳ�̵�Ĺ���
        String sql = "select notice from store where store_id=?";
        String notice = template.queryForObject(sql, String.class, store_id);
        return notice;
    }

    public static double getGrade(int store_id) {//��ȡĳ�̵������
        String sql = "select grade from store where store_id=?";
        double notice = template.queryForObject(sql, double.class, store_id);
        return notice;
    }

    public static String getStorePhone(int store_id) {//��ȡĳ�̵����ϵ�绰
        String sql = "select storephone from store where store_id=?";
        String storephone = template.queryForObject(sql, String.class, store_id);
        return storephone;
    }

    public static String getAddress(int store_id) {  //��ȡĳ�̵�ĵ�ַ
        String sql = "select address from store where store_id=?";
        String address = template.queryForObject(sql, String.class, store_id);
        return address;
    }

    public static void addGoods(int store_id, String name, String type, double price,InputStream imputstream) {//Ϊ�̵����Ӳ�Ʒ
        String sql = "select max(goods_id)+1 from goods where store_id=?";
        String sql1 = "insert into Goods values(?,?,?,?,?,?,?)";
        int goods_id;    //�Զ�������Ʒ���
        try {
            goods_id = template.queryForObject(sql, int.class, store_id);
        } catch (Exception e) {
            // TODO: handle exception
            goods_id = 1;//���û��Ʒ���Ϊ0
        }
        int salesnum = 0;
        template.update(sql1, store_id, goods_id, name, type, price, salesnum,imputstream);
    }

    public static void modifyGoods(int store_id, int goods_id, Goods newgoods) {//������Ʒ������
        String sql = "update goods set name = ?,type = ?,price = ?,salesnum=? where store_id=? and goods_id =?";
        template.update(sql, newgoods.name, newgoods.type, newgoods.price, newgoods.salesnum, store_id, goods_id);
    }
    
    public static void DeleteyGoods(int store_id, int goods_id) {//ɾ��ָ����Ʒ
        String sql = "delete from Goods where store_id = ? and goods_id = ? ";
        template.update(sql,store_id, goods_id);
    }
    
    public static void upDateGoodsSaleNum(int store_id, int goods_id, int buynum) {//������Ʒ������
        String sql = "update goods set salesnum=salesnum+? where store_id =? and goods_id=?";
        template.update(sql, buynum, store_id, goods_id);
    }

    public static void main(String[] args) {
        System.out.println(ifRegist("170400327"));
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStorephone() {
        return storephone;
    }

    public void setStorephone(String storephone) {
        this.storephone = storephone;
    }

    public int getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(int deliverytime) {
        this.deliverytime = deliverytime;
    }

    public int getSalesnum() {
        return salesnum;
    }

    public void setSalesnum(int monthsale) {
        this.salesnum = monthsale;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

