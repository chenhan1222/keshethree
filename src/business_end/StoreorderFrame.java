package business_end;

import Login.LoginFrame;
import control_packet.TableRefresh;
import data.Order_goods;
import data.Store;
import data.Userorder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
public class StoreorderFrame {
    public JFrame frame;
    private JTable table;
    private int store_id ;
    /**
     * Launch the application.
     */
    public StoreorderFrame() {
        store_id = LoginFrame.store_id;
        frame = new JFrame();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 939, 557);
        frame.setTitle("\u6211\u7684\u8BA2\u5355");
        frame.getContentPane().setFont(new Font("����", Font.BOLD, 16));
        frame.getContentPane().setLayout(null);

        table = new JTable();
        //DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(743, 451);
        scrollPane.setLocation(10, 32);
        frame.getContentPane().add(scrollPane);
        List<Userorder> userorders = Userorder.getStoreOrder(store_id);
        TableRefresh.refreshStore_UserorderTable(userorders, table);

        JButton btnNewButton_7 = new JButton("�ܾ��ӵ�");
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_rejectOrderActionPerformed(e);
            }
        });
        btnNewButton_7.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_7.setBounds(763, 78, 111, 30);
        frame.getContentPane().add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("�ӵ�");//�ӵ���ť
        btnNewButton_8.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_acceptOrderActionPerformed(e);
            }
        });
        btnNewButton_8.setBounds(763, 152, 111, 30);
        frame.getContentPane().add(btnNewButton_8);

        JButton btnNewButton_9 = new JButton("��ʼ����");
        btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_deliverOrderActionPerformed(e);
            }
        });
        btnNewButton_9.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_9.setBounds(763, 220, 111, 30);
        frame.getContentPane().add(btnNewButton_9);

        JButton btnNewButton_10 = new JButton("�ʹ�");
        btnNewButton_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_finishOrderActionPerformed(e);
            }
        });
        btnNewButton_10.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_10.setBounds(762, 288, 112, 30);
        frame.getContentPane().add(btnNewButton_10);

        JButton btnNewButton = new JButton("�˿�");//�˿�
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_refundActionPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton.setBounds(764, 358, 110, 30);
        frame.getContentPane().add(btnNewButton);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnNewMenu_1 = new JMenu("��������(C)");
        mnNewMenu_1.setMnemonic(KeyEvent.VK_C);
        mnNewMenu_1.setFont(new Font("����", Font.BOLD, 16));
        menuBar.add(mnNewMenu_1);

        JMenu mnNewMenu = new JMenu("\u5168\u90E8");
        mnNewMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mnNewMenu_1.setMnemonic(KeyEvent.VK_A);
        mnNewMenu.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu_1.add(mnNewMenu);

        JMenuItem mntmNewMenuItem_6 = new JMenuItem("ȫ��         ", 'A');
        mntmNewMenuItem_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        mntmNewMenuItem_6.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_6);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("δ�ӵ�         ", 'Y');
        mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "�ȴ��̼ҽӵ�";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_4.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_4);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("�ѽӵ�         ");
        mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));//��ݼ�
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "�̼��ѽӵ�";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_1.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("������         ", 'D');
        mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke('D', ActionEvent.CTRL_MASK));//��ݼ�
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "������";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_2.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_2);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("�����         ", 'F');
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "���������";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke('F', ActionEvent.CTRL_MASK));//��ݼ�
        mntmNewMenuItem_3.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem = new JMenuItem("�����˿�         ", 'L');
        mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke('L', ActionEvent.CTRL_MASK));//��ݼ�
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "�����˿�";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem tadayorder = new JMenuItem("���ն���      ", 'T');
        tadayorder.setAccelerator(KeyStroke.getKeyStroke('T'));//��ݼ�
        tadayorder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOneDayOrder(store_id);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        tadayorder.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu_1.add(tadayorder);

        JMenu mnNewMenu_5 = new JMenu("����(S)");
        mnNewMenu_5.setFont(new Font("����", Font.BOLD, 16));
        menuBar.add(mnNewMenu_5);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("��������������");
        mntmNewMenuItem_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOrderSortByData(store_id);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_5.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu_5.add(mntmNewMenuItem_5);


        JMenu mnNewMenu_4 = new JMenu("ˢ��");//ˢ�²˵���

        mnNewMenu_4.setFont(new Font("����", Font.BOLD, 16));
        menuBar.add(mnNewMenu_4);

        JMenuItem mntmNewMenuItem_7 = new JMenuItem("ˢ��");
        mntmNewMenuItem_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_7.setFont(new Font("����", Font.BOLD, 16));
        mnNewMenu_4.add(mntmNewMenuItem_7);

        JMenu mnNewMenu_3 = new JMenu("\u9000\u51FA\uFF08Q\uFF09");
        mnNewMenu_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
        });
        mnNewMenu_3.setFont(new Font("����", Font.BOLD, 16));
        menuBar.add(mnNewMenu_3);
    }
    /*******************************************��Ϣ��Ӧ����*****************************************/
    /**
     * �ܵ�
     * */
    private void btn_rejectOrderActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        String neworderstatus = "�̼��Ѿܵ�";
        int valuecolumn=dtm.findColumn("�Ƿ�ѡ��");
        int ordernumcolumn = dtm.findColumn("������");
        int orderstatuscolumn=dtm.findColumn("����״̬");
        for (int i = 0; i < table.getRowCount(); i++) {
            String getvalue = table.getValueAt(i, valuecolumn).toString();
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            if (getvalue == "true") {
                if (orderstatus.equals("�ȴ��̼ҽӵ�")) {
                    Userorder.updateOrderstatus(ordernum, neworderstatus);
                    JOptionPane.showMessageDialog(null, "�ܵ��ɹ���");
                    List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                    TableRefresh.refreshStore_UserorderTable(userorders, table);
                } else
                    JOptionPane.showMessageDialog(null, "�ܵ�ʧ�ܣ�");
            }
        }
    }
    /**
     * �ӵ�
     * */
    private void btn_acceptOrderActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        String neworderstatus = "�̼��ѽӵ�";
        int valuecolumn=dtm.findColumn("�Ƿ�ѡ��");
        int ordernumcolumn = dtm.findColumn("������");
        int orderstatuscolumn=dtm.findColumn("����״̬");
        for (int i = 0; i < table.getRowCount(); i++) {
            String getvalue = table.getValueAt(i, valuecolumn).toString();
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            if (getvalue == "true") {
                if (orderstatus.equals("�û��Ѹ���")) {
                    Userorder.updateOrderstatus(ordernum, neworderstatus);
                    JOptionPane.showMessageDialog(null, "�ӵ��ɹ���");
                    List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                    TableRefresh.refreshStore_UserorderTable(userorders, table);
                } else
                    JOptionPane.showMessageDialog(null, "�ӵ�ʧ�ܣ�");
            }
        }
    }
    /**
     * ����
     * */
    public void btn_deliverOrderActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        String neworderstatus = "������";
        int valuecolumn=dtm.findColumn("�Ƿ�ѡ��");
        int ordernumcolumn = dtm.findColumn("������");
        int orderstatuscolumn=dtm.findColumn("����״̬");
        for (int i = 0; i < table.getRowCount(); i++) {
            String getvalue = table.getValueAt(i, valuecolumn).toString();
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            if (getvalue == "true") {
                if (orderstatus.equals("�̼��ѽӵ�")) {
                    Userorder.updateOrderstatus(ordernum, neworderstatus);
                    JOptionPane.showMessageDialog(null, "������ʼ���ͣ�");
                    List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                    TableRefresh.refreshStore_UserorderTable(userorders, table);
                } else
                    JOptionPane.showMessageDialog(null, "�ӵ�����ܿ�ʼ���ͣ�");
            }
        }
    }
    /**
     * �ʹ�
     * */
    public void btn_finishOrderActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        String neworderstatus = "���������";
        int valuecolumn=dtm.findColumn("�Ƿ�ѡ��");
        int ordernumcolumn = dtm.findColumn("������");
        int orderstatuscolumn=dtm.findColumn("����״̬");
        for (int i = 0; i < table.getRowCount(); i++) {
            String getvalue = table.getValueAt(i, valuecolumn).toString();
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            if (getvalue == "true") {
                if (orderstatus.equals("������")) {
                    Userorder.updateOrderstatus(ordernum, neworderstatus);//�Ķ���״̬Ϊ�����
                    List<Order_goods>list=Order_goods.getOrder_GoodsList(ordernum);	//��ȡ��������Ʒ��Ϣ������
                    for (int j = 0; j < list.size(); j++) {
                        int store_id = list.get(j).store_id;
                        int goods_id = list.get(j).goods_id;
                        int buynum = list.get(j).buynum;
                        Store.upDateGoodsSaleNum(store_id, goods_id, buynum);//����Ʒ��������
                    }
                    JOptionPane.showMessageDialog(null, "��������ɣ�");
                    List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                    TableRefresh.refreshStore_UserorderTable(userorders, table);
                } else
                    JOptionPane.showMessageDialog(null, "��Ч������");
            }
        }
    }
    /**
     * �˿�
     * */
    public void btn_refundActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        int valuecolumn=dtm.findColumn("�Ƿ�ѡ��");
        int ordernumcolumn = dtm.findColumn("������");
        for (int i = 0; i < table.getRowCount(); i++) {
            String getvalue = table.getValueAt(i, valuecolumn).toString();
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            if (getvalue == "true") {
                String total_price=String.valueOf(Userorder.getTotal_price(ordernum));//��ȡ�ܼ۸�
                String url="http://47.95.200.90:8080/se_wm/refund.jsp?";
                String finalurl=url+"refund_ordernum="+ordernum+"&refund_total_price="+total_price;
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI(finalurl));
                } catch (IOException | URISyntaxException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }
}
