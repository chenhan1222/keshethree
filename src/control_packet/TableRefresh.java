package control_packet;

import data.*;
import tabletools.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.util.List;
import java.util.Vector;

public class TableRefresh {
    /**
     * 刷新学生表
     */
    public static void refreshStudentTable(List<Student> studentlist, JTable table) {
        MyStudentTableModel dtm = (MyStudentTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"学号", "密码", "系名", "班号", "姓名", "公寓", "宿舍号", "手机号", "昵称", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        for (int i = 0; i < studentlist.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(studentlist.get(i).s_usernum);
            v.add(studentlist.get(i).s_password);
            v.add(studentlist.get(i).s_department_name);
            v.add(studentlist.get(i).s_class_num);
            v.add(studentlist.get(i).s_name);
            v.add(studentlist.get(i).s_apartment_num);
            v.add(studentlist.get(i).s_dormitory_num);
            v.add(studentlist.get(i).s_phonenum);
            v.add(studentlist.get(i).s_nickname);
            v.add(false);
            dtm.addRow(v);
        }
        /*****设置table的列模型****/
        TableColumnModel tcm = table.getColumnModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }

    /**
     * 刷新教师表
     */
    public static void refreshTeacherTable(List<Teacher> teacherlist, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"工号", "密码", "姓名", "系名", "手机号", "办公室", "邮箱", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        for (int i = 0; i < teacherlist.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(teacherlist.get(i).t_usernum);
            v.add(teacherlist.get(i).t_password);
            v.add(teacherlist.get(i).t_name);
            v.add(teacherlist.get(i).t_department_name);
            v.add(teacherlist.get(i).t_phonenum);
            v.add(teacherlist.get(i).t_office);
            v.add(teacherlist.get(i).t_email);
            v.add(false);
            dtm.addRow(v);
        }
        /*****设置table的列模型****/
        TableColumnModel tcm = table.getColumnModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }
    /**
     * 刷新学生界面的教师信息表
     */
    public static void refreshStudent_TeacherTable(List<Teacher> teacherlist, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"工号", "姓名", "系名", "手机号", "办公室", "邮箱"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        for (int i = 0; i < teacherlist.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(teacherlist.get(i).t_usernum);
            v.add(teacherlist.get(i).t_name);
            v.add(teacherlist.get(i).t_department_name);
            v.add(teacherlist.get(i).t_phonenum);
            v.add(teacherlist.get(i).t_office);
            v.add(teacherlist.get(i).t_email);
            dtm.addRow(v);
        }
        /*****设置table的列模型****/
        TableColumnModel tcm = table.getColumnModel();
        /*
        int ifselectcolumn = dtm.findColumn("是否选中");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
         */
    }
    /**
     * 刷新员工表
     */
    public static void refreshStaffTable(List<Staff> stafflist, JTable table) {
        MyStaffTableModel dtm = (MyStaffTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"工号", "密码", "姓名", "工作类型", "手机号", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        for (int i = 0; i < stafflist.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(stafflist.get(i).staff_usernum);
            v.add(stafflist.get(i).staff_password);
            v.add(stafflist.get(i).staff_name);
            v.add(stafflist.get(i).staff_worktype);
            v.add(stafflist.get(i).staff_phonenum);
            v.add(false);
            dtm.addRow(v);
        }
        /*****设置table的列模型****/
        TableColumnModel tcm = table.getColumnModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }

    /**
     * 刷新商家商品表
     */
    public static void refreshStore_GoodsTable(List<Goods> goods, JTable table) {    //刷新商品信息的函数
        MyGoodsTableImageModel dtm = (MyGoodsTableImageModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"编号", "图片", "名称", "种类", "价格", "销售量", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        for (int i = 0; i < goods.size(); i++) {
            Object[] data = {goods.get(i).goods_id, goods.get(i).imageicon, goods.get(i).name, goods.get(i).type, goods.get(i).price, goods.get(i).salesnum, false};
            dtm.addRow(data);
        }
        //this.table=new JTable(dtm);
        /*****设置table的列模型****/
        int ifselectcolumn = dtm.findColumn("是否选中");
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));

        tcm.getColumn(ifselectcolumn).setMaxWidth(100);
        tcm.getColumn(ifselectcolumn).setMinWidth(100);

        int idcolumn = dtm.findColumn("编号");
        tcm.getColumn(idcolumn).setMaxWidth(100);
        tcm.getColumn(idcolumn).setMinWidth(100);

        int typecolumn = dtm.findColumn("种类");
        tcm.getColumn(typecolumn).setMaxWidth(120);
        tcm.getColumn(typecolumn).setMinWidth(120);

        int pricecolumn = dtm.findColumn("价格");
        tcm.getColumn(pricecolumn).setMaxWidth(120);
        tcm.getColumn(pricecolumn).setMinWidth(120);

        int imagecolumn = dtm.findColumn("图片");
        //table.getColumnModel().getColumn(imagecolumn).setCellRenderer(new Mytablerencender());//渲染图片
        tcm.getColumn(imagecolumn).setCellRenderer(new MyGoodsTableImageRencender());
        tcm.getColumn(imagecolumn).setMinWidth(120);
        tcm.getColumn(imagecolumn).setWidth(120);
        tcm.getColumn(imagecolumn).setMaxWidth(120);
        table.setRowHeight(100);//设置每行高度为100
        int salenumcolumn = dtm.findColumn("销售量");
        tcm.getColumn(salenumcolumn ).setMaxWidth(120);
        tcm.getColumn(salenumcolumn ).setMinWidth(120);
    }

    /**
     * 刷新学生商品表
     */
    public static void refreshStudent_GoodsTable(List<Goods> goods, JTable table) {    //刷新商品信息的函数
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"编号", "图片", "名称", "种类", "价格", "销售量", "购买数量", "增加", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        for (int i = 0; i < goods.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(goods.get(i).goods_id);
            v.add(goods.get(i).imageicon);
            v.add(goods.get(i).name);
            v.add(goods.get(i).type);
            v.add(goods.get(i).price);
            v.add(goods.get(i).salesnum);
            v.add(1);
            v.add("");
            v.add(false);
            dtm.addRow(v);
        }
        /*****设置table的列模型****/
        TableColumnModel tcm = table.getColumnModel();
        int buynumcolumn = dtm.findColumn("增加");
        tcm.getColumn(buynumcolumn).setCellEditor(new MyGoodsTableButtonEditor(table));
        tcm.getColumn(buynumcolumn).setCellRenderer(new MyGoosTableButtonRencender());
        tcm.getColumn(buynumcolumn).setPreferredWidth(40);
        tcm.getColumn(buynumcolumn).setWidth(40);
        tcm.getColumn(buynumcolumn).setMaxWidth(40);

        int imagecolumn = dtm.findColumn("图片");
        tcm.getColumn(imagecolumn).setCellRenderer(new MyGoodsTableImageRencender());
        tcm.getColumn(imagecolumn).setPreferredWidth(100);
        tcm.getColumn(imagecolumn).setWidth(100);
        tcm.getColumn(imagecolumn).setMaxWidth(100);

        int namecolumn = dtm.findColumn("名称");
        tcm.getColumn(namecolumn).setPreferredWidth(100);
        tcm.getColumn(namecolumn).setWidth(100);
        tcm.getColumn(namecolumn).setMaxWidth(100);

        int ifselectcolumn = dtm.findColumn("是否选中");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
        table.setRowHeight(100);
    }

    /**
     * 刷新收获信息表
     */
    public static void refreshReceiveAddressTable(List<Receiveaddress> list, JTable table) {
        MyReceiveAddressTableModel dtm = (MyReceiveAddressTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"联系人", "地址", "联系电话", "性别", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object data[] = {list.get(i).contact, list.get(i).address, list.get(i).phonenum, list.get(i).sex};
            dtm.addRow(data);
        }
        //this.table=new JTable(dtm);
        /*****设置table的列模型****/
        int ifselectcolumn = dtm.findColumn("是否选中");
        int addresscolumn = dtm.findColumn("地址");
        int sexscolumn = dtm.findColumn("性别");
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setMaxWidth(60);
        tcm.getColumn(addresscolumn).setMinWidth(135);
        tcm.getColumn(sexscolumn).setMaxWidth(60);

    }

    /**
     * 刷新购物车
     */
    public static void refreshShoppinListTable(String usernum, int store_id, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"编号", "图片", "名称", "种类", "价格", "购买数量", "增加", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        List<Goods> goods = Shoppinglist.getShoppinglist(usernum, store_id);
        //设置JTable的表格数
        for (int i = 0; i < goods.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(goods.get(i).goods_id);
            v.add(goods.get(i).imageicon);
            v.add(goods.get(i).name);
            v.add(goods.get(i).type);
            v.add(goods.get(i).price);
            v.add(Shoppinglist.getBuyNum(usernum, store_id, goods.get(i).goods_id));
            v.add("");
            v.add(false);
            dtm.addRow(v);
        }
        /*****设置table的列模型****/
        TableColumnModel tcm = table.getColumnModel();
        int buynumcolumn = dtm.findColumn("增加");
        tcm.getColumn(buynumcolumn).setCellEditor(new MyGoodsTableButtonEditor(table));
        tcm.getColumn(buynumcolumn).setCellRenderer(new MyGoosTableButtonRencender());
        tcm.getColumn(buynumcolumn).setPreferredWidth(40);
        tcm.getColumn(buynumcolumn).setWidth(40);
        tcm.getColumn(buynumcolumn).setMaxWidth(40);

        int imagecolumn = dtm.findColumn("图片");
        tcm.getColumn(imagecolumn).setCellRenderer(new MyGoodsTableImageRencender());
        tcm.getColumn(imagecolumn).setPreferredWidth(100);
        tcm.getColumn(imagecolumn).setWidth(100);
        tcm.getColumn(imagecolumn).setMaxWidth(100);

        int namecolumn = dtm.findColumn("名称");
        tcm.getColumn(namecolumn).setPreferredWidth(100);
        tcm.getColumn(namecolumn).setWidth(100);
        tcm.getColumn(namecolumn).setMaxWidth(100);

        int ifselectcolumn = dtm.findColumn("是否选中");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
        table.setRowHeight(100);
    }

    /**
     * 刷新商家端用户订单表
     */
    public static void refreshStore_UserorderTable(List<Userorder> userorders, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"订单号", "客户名", "客户电话", "住址", "所买物品", "下单时间", "备注", "订单状态", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        for (int i = 0; i < userorders.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(userorders.get(i).ordernum);
            v.add(userorders.get(i).contact);
            v.add(userorders.get(i).phonenum);
            v.add(userorders.get(i).address);
            v.add("");
            v.add(userorders.get(i).buytime);
            v.add(userorders.get(i).note);
            v.add(userorders.get(i).orderstatus);
            v.add(false);
            dtm.addRow(v);
        }
        /*****设置table的列模型****/
        int ifselectcolumn = dtm.findColumn("是否选中");
        int goodscolumn = dtm.findColumn("所买物品");
        int buytimecolumn = dtm.findColumn("下单时间");
        int orderstatuscolumn = dtm.findColumn("订单状态");
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(goodscolumn).setCellEditor(new MyUserorderTableCellEditor(table));
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(70);
        tcm.getColumn(ifselectcolumn).setMinWidth(70);
        tcm.getColumn(buytimecolumn).setMaxWidth(70);
        tcm.getColumn(buytimecolumn).setMinWidth(70);
        tcm.getColumn(orderstatuscolumn).setMaxWidth(80);
    }

    /**
     * 刷新学生端用户订单表
     */
    public static void refreshStudent_UserorderTable(List<Userorder> userorders, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"订单号", "商家名字", "所买物品", "总价", "下单时间", "预计送达时间", "订单状态", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        for (int i = 0; i < userorders.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(userorders.get(i).ordernum);
            v.add(Store.getStoreName(userorders.get(i).store_id));
            v.add(null);
            v.add(userorders.get(i).total_price);
            v.add(userorders.get(i).buytime);
            v.add(Userorder.makeServicetime(userorders.get(i).buytime, userorders.get(i).store_id));
            v.add(userorders.get(i).orderstatus);
            v.add(false);
            dtm.addRow(v);
        }
        /*****设置table的列模型****/
        int ordernumcolumn = dtm.findColumn("订单号");
        int ifselectcolumn = dtm.findColumn("是否选中");
        int goodscolumn = dtm.findColumn("所买物品");
        int buytimecolumn = dtm.findColumn("下单时间");
        int orderstatuscolumn = dtm.findColumn("订单状态");
        int totalpricecolumn = dtm.findColumn("总价");
        int yjsdsjcolumn = dtm.findColumn("预计送达时间");
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(goodscolumn).setCellEditor(new MyUserorderTableCellEditor(table));
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(50);
        tcm.getColumn(ifselectcolumn).setWidth(50);
        tcm.getColumn(ordernumcolumn).setMaxWidth(70);
        tcm.getColumn(totalpricecolumn).setMaxWidth(40);
        tcm.getColumn(buytimecolumn).setMaxWidth(50);
        tcm.getColumn(yjsdsjcolumn).setMaxWidth(65);
        tcm.getColumn(orderstatuscolumn).setMaxWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(50);
    }

    /**
     * 刷新学生端商店信息表
     */
    public static void refreshStoresTable(List<Store> stores, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"编号", "名称", "评分", "订单数", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        for (int i = 0; i < stores.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(stores.get(i).store_id);
            v.add(stores.get(i).name);
            v.add(stores.get(i).grade);
            v.add(stores.get(i).salesnum);
            v.add(false);
            dtm.addRow(v);
        }
        /*****设置table的列模型****/
        int ifselectcolumn = dtm.findColumn("是否选中");
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }

    /**
     * 刷新老师端预约日程表
     */
    public static void refreshTeacherBespokeTable(List<Bespoke> bespokelist, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"预约号", "老师", "答疑时间", "答疑地点", "预约状态", "预约学生姓名", "预约学生留言", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        for (int i = 0; i < bespokelist.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(bespokelist.get(i).qa_id);
            v.add(bespokelist.get(i).t_name);
            v.add(bespokelist.get(i).qa_time);
            v.add(bespokelist.get(i).qa_address);
            v.add(bespokelist.get(i).qa_status);
            v.add(bespokelist.get(i).s_name);
            v.add(bespokelist.get(i).qa_message);
            v.add(false);
            dtm.addRow(v);
        }
        /*****设置table的列模型****/
        int ifselectcolumn = dtm.findColumn("是否选中");
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }

    /**
     * 刷新学生端预约日程表
     */
    public static void refreshStudentBespokeTable(List<Bespoke> bespokelist, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"预约号", "老师姓名", "答疑时间", "答疑地点", "预约状态", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        for (int i = 0; i < bespokelist.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(bespokelist.get(i).qa_id);
            v.add(bespokelist.get(i).t_name);
            v.add(bespokelist.get(i).qa_time);
            v.add(bespokelist.get(i).qa_address);
            v.add(bespokelist.get(i).qa_status);
            v.add(false);
            dtm.addRow(v);
        }
        /*****设置table的列模型****/
        int ifselectcolumn = dtm.findColumn("是否选中");
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }

    /**
     * 刷新学费表
     */
    public static void refreshTuition_feeTable(List<Tuition_fee> tuition_feelist, JTable table) {
        MyTuition_feeTableModel dtm = (MyTuition_feeTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"学号", "年", "学期", "金额", "支付状态", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        for (int i = 0; i < tuition_feelist.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(tuition_feelist.get(i).s_usernum);
            v.add(tuition_feelist.get(i).year);
            v.add(tuition_feelist.get(i).term);
            v.add(tuition_feelist.get(i).cost);
            v.add(tuition_feelist.get(i).paystatus);
            v.add(false);
            dtm.addRow(v);
        }
        /*****设置table的列模型****/
        TableColumnModel tcm = table.getColumnModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }

    /**
     * 刷新绑定表
     */
    public static void refreshStore_bindingTable(List<Store_binding> store_bindinglist, JTable table) {
        MyStore_bindingTableModel dtm = (MyStore_bindingTableModel) table.getModel();
        dtm.setRowCount(0);//清空列表
        String[] tableHeads = new String[]{"工号", "姓名", "商店号", "商店名", "是否选中"};
        dtm.setColumnIdentifiers(tableHeads);
        //设置JTable的表格数
        for (int i = 0; i < store_bindinglist.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(store_bindinglist.get(i).staff_usernum);
            v.add(store_bindinglist.get(i).staff_name);
            v.add(store_bindinglist.get(i).store_id);
            v.add(store_bindinglist.get(i).store_name);
            v.add(false);
            dtm.addRow(v);
        }
        /*****设置table的列模型****/
        TableColumnModel tcm = table.getColumnModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }
}
