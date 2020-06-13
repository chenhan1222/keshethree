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
     * ˢ��ѧ����
     */
    public static void refreshStudentTable(List<Student> studentlist, JTable table) {
        MyStudentTableModel dtm = (MyStudentTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"ѧ��", "����", "ϵ��", "���", "����", "��Ԣ", "�����", "�ֻ���", "�ǳ�", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
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
        /*****����table����ģ��****/
        TableColumnModel tcm = table.getColumnModel();
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }

    /**
     * ˢ�½�ʦ��
     */
    public static void refreshTeacherTable(List<Teacher> teacherlist, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"����", "����", "����", "ϵ��", "�ֻ���", "�칫��", "����", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
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
        /*****����table����ģ��****/
        TableColumnModel tcm = table.getColumnModel();
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }
    /**
     * ˢ��ѧ������Ľ�ʦ��Ϣ��
     */
    public static void refreshStudent_TeacherTable(List<Teacher> teacherlist, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"����", "����", "ϵ��", "�ֻ���", "�칫��", "����"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
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
        /*****����table����ģ��****/
        TableColumnModel tcm = table.getColumnModel();
        /*
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
         */
    }
    /**
     * ˢ��Ա����
     */
    public static void refreshStaffTable(List<Staff> stafflist, JTable table) {
        MyStaffTableModel dtm = (MyStaffTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"����", "����", "����", "��������", "�ֻ���", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
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
        /*****����table����ģ��****/
        TableColumnModel tcm = table.getColumnModel();
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }

    /**
     * ˢ���̼���Ʒ��
     */
    public static void refreshStore_GoodsTable(List<Goods> goods, JTable table) {    //ˢ����Ʒ��Ϣ�ĺ���
        MyGoodsTableImageModel dtm = (MyGoodsTableImageModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"���", "ͼƬ", "����", "����", "�۸�", "������", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
        for (int i = 0; i < goods.size(); i++) {
            Object[] data = {goods.get(i).goods_id, goods.get(i).imageicon, goods.get(i).name, goods.get(i).type, goods.get(i).price, goods.get(i).salesnum, false};
            dtm.addRow(data);
        }
        //this.table=new JTable(dtm);
        /*****����table����ģ��****/
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));

        tcm.getColumn(ifselectcolumn).setMaxWidth(100);
        tcm.getColumn(ifselectcolumn).setMinWidth(100);

        int idcolumn = dtm.findColumn("���");
        tcm.getColumn(idcolumn).setMaxWidth(100);
        tcm.getColumn(idcolumn).setMinWidth(100);

        int typecolumn = dtm.findColumn("����");
        tcm.getColumn(typecolumn).setMaxWidth(120);
        tcm.getColumn(typecolumn).setMinWidth(120);

        int pricecolumn = dtm.findColumn("�۸�");
        tcm.getColumn(pricecolumn).setMaxWidth(120);
        tcm.getColumn(pricecolumn).setMinWidth(120);

        int imagecolumn = dtm.findColumn("ͼƬ");
        //table.getColumnModel().getColumn(imagecolumn).setCellRenderer(new Mytablerencender());//��ȾͼƬ
        tcm.getColumn(imagecolumn).setCellRenderer(new MyGoodsTableImageRencender());
        tcm.getColumn(imagecolumn).setMinWidth(120);
        tcm.getColumn(imagecolumn).setWidth(120);
        tcm.getColumn(imagecolumn).setMaxWidth(120);
        table.setRowHeight(100);//����ÿ�и߶�Ϊ100
        int salenumcolumn = dtm.findColumn("������");
        tcm.getColumn(salenumcolumn ).setMaxWidth(120);
        tcm.getColumn(salenumcolumn ).setMinWidth(120);
    }

    /**
     * ˢ��ѧ����Ʒ��
     */
    public static void refreshStudent_GoodsTable(List<Goods> goods, JTable table) {    //ˢ����Ʒ��Ϣ�ĺ���
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"���", "ͼƬ", "����", "����", "�۸�", "������", "��������", "����", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
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
        /*****����table����ģ��****/
        TableColumnModel tcm = table.getColumnModel();
        int buynumcolumn = dtm.findColumn("����");
        tcm.getColumn(buynumcolumn).setCellEditor(new MyGoodsTableButtonEditor(table));
        tcm.getColumn(buynumcolumn).setCellRenderer(new MyGoosTableButtonRencender());
        tcm.getColumn(buynumcolumn).setPreferredWidth(40);
        tcm.getColumn(buynumcolumn).setWidth(40);
        tcm.getColumn(buynumcolumn).setMaxWidth(40);

        int imagecolumn = dtm.findColumn("ͼƬ");
        tcm.getColumn(imagecolumn).setCellRenderer(new MyGoodsTableImageRencender());
        tcm.getColumn(imagecolumn).setPreferredWidth(100);
        tcm.getColumn(imagecolumn).setWidth(100);
        tcm.getColumn(imagecolumn).setMaxWidth(100);

        int namecolumn = dtm.findColumn("����");
        tcm.getColumn(namecolumn).setPreferredWidth(100);
        tcm.getColumn(namecolumn).setWidth(100);
        tcm.getColumn(namecolumn).setMaxWidth(100);

        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
        table.setRowHeight(100);
    }

    /**
     * ˢ���ջ���Ϣ��
     */
    public static void refreshReceiveAddressTable(List<Receiveaddress> list, JTable table) {
        MyReceiveAddressTableModel dtm = (MyReceiveAddressTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"��ϵ��", "��ַ", "��ϵ�绰", "�Ա�", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object data[] = {list.get(i).contact, list.get(i).address, list.get(i).phonenum, list.get(i).sex};
            dtm.addRow(data);
        }
        //this.table=new JTable(dtm);
        /*****����table����ģ��****/
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        int addresscolumn = dtm.findColumn("��ַ");
        int sexscolumn = dtm.findColumn("�Ա�");
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setMaxWidth(60);
        tcm.getColumn(addresscolumn).setMinWidth(135);
        tcm.getColumn(sexscolumn).setMaxWidth(60);

    }

    /**
     * ˢ�¹��ﳵ
     */
    public static void refreshShoppinListTable(String usernum, int store_id, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"���", "ͼƬ", "����", "����", "�۸�", "��������", "����", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        List<Goods> goods = Shoppinglist.getShoppinglist(usernum, store_id);
        //����JTable�ı����
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
        /*****����table����ģ��****/
        TableColumnModel tcm = table.getColumnModel();
        int buynumcolumn = dtm.findColumn("����");
        tcm.getColumn(buynumcolumn).setCellEditor(new MyGoodsTableButtonEditor(table));
        tcm.getColumn(buynumcolumn).setCellRenderer(new MyGoosTableButtonRencender());
        tcm.getColumn(buynumcolumn).setPreferredWidth(40);
        tcm.getColumn(buynumcolumn).setWidth(40);
        tcm.getColumn(buynumcolumn).setMaxWidth(40);

        int imagecolumn = dtm.findColumn("ͼƬ");
        tcm.getColumn(imagecolumn).setCellRenderer(new MyGoodsTableImageRencender());
        tcm.getColumn(imagecolumn).setPreferredWidth(100);
        tcm.getColumn(imagecolumn).setWidth(100);
        tcm.getColumn(imagecolumn).setMaxWidth(100);

        int namecolumn = dtm.findColumn("����");
        tcm.getColumn(namecolumn).setPreferredWidth(100);
        tcm.getColumn(namecolumn).setWidth(100);
        tcm.getColumn(namecolumn).setMaxWidth(100);

        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
        table.setRowHeight(100);
    }

    /**
     * ˢ���̼Ҷ��û�������
     */
    public static void refreshStore_UserorderTable(List<Userorder> userorders, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"������", "�ͻ���", "�ͻ��绰", "סַ", "������Ʒ", "�µ�ʱ��", "��ע", "����״̬", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
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
        /*****����table����ģ��****/
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        int goodscolumn = dtm.findColumn("������Ʒ");
        int buytimecolumn = dtm.findColumn("�µ�ʱ��");
        int orderstatuscolumn = dtm.findColumn("����״̬");
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
     * ˢ��ѧ�����û�������
     */
    public static void refreshStudent_UserorderTable(List<Userorder> userorders, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"������", "�̼�����", "������Ʒ", "�ܼ�", "�µ�ʱ��", "Ԥ���ʹ�ʱ��", "����״̬", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
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
        /*****����table����ģ��****/
        int ordernumcolumn = dtm.findColumn("������");
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        int goodscolumn = dtm.findColumn("������Ʒ");
        int buytimecolumn = dtm.findColumn("�µ�ʱ��");
        int orderstatuscolumn = dtm.findColumn("����״̬");
        int totalpricecolumn = dtm.findColumn("�ܼ�");
        int yjsdsjcolumn = dtm.findColumn("Ԥ���ʹ�ʱ��");
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
     * ˢ��ѧ�����̵���Ϣ��
     */
    public static void refreshStoresTable(List<Store> stores, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"���", "����", "����", "������", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
        for (int i = 0; i < stores.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(stores.get(i).store_id);
            v.add(stores.get(i).name);
            v.add(stores.get(i).grade);
            v.add(stores.get(i).salesnum);
            v.add(false);
            dtm.addRow(v);
        }
        /*****����table����ģ��****/
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }

    /**
     * ˢ����ʦ��ԤԼ�ճ̱�
     */
    public static void refreshTeacherBespokeTable(List<Bespoke> bespokelist, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"ԤԼ��", "��ʦ", "����ʱ��", "���ɵص�", "ԤԼ״̬", "ԤԼѧ������", "ԤԼѧ������", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
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
        /*****����table����ģ��****/
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }

    /**
     * ˢ��ѧ����ԤԼ�ճ̱�
     */
    public static void refreshStudentBespokeTable(List<Bespoke> bespokelist, JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"ԤԼ��", "��ʦ����", "����ʱ��", "���ɵص�", "ԤԼ״̬", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
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
        /*****����table����ģ��****/
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }

    /**
     * ˢ��ѧ�ѱ�
     */
    public static void refreshTuition_feeTable(List<Tuition_fee> tuition_feelist, JTable table) {
        MyTuition_feeTableModel dtm = (MyTuition_feeTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"ѧ��", "��", "ѧ��", "���", "֧��״̬", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
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
        /*****����table����ģ��****/
        TableColumnModel tcm = table.getColumnModel();
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }

    /**
     * ˢ�°󶨱�
     */
    public static void refreshStore_bindingTable(List<Store_binding> store_bindinglist, JTable table) {
        MyStore_bindingTableModel dtm = (MyStore_bindingTableModel) table.getModel();
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"����", "����", "�̵��", "�̵���", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
        for (int i = 0; i < store_bindinglist.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(store_bindinglist.get(i).staff_usernum);
            v.add(store_bindinglist.get(i).staff_name);
            v.add(store_bindinglist.get(i).store_id);
            v.add(store_bindinglist.get(i).store_name);
            v.add(false);
            dtm.addRow(v);
        }
        /*****����table����ģ��****/
        TableColumnModel tcm = table.getColumnModel();
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        tcm.getColumn(ifselectcolumn).setCellEditor(table.getDefaultEditor(Boolean.class));
        tcm.getColumn(ifselectcolumn).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tcm.getColumn(ifselectcolumn).setPreferredWidth(80);
        tcm.getColumn(ifselectcolumn).setWidth(80);
        tcm.getColumn(ifselectcolumn).setMaxWidth(80);
    }
}
