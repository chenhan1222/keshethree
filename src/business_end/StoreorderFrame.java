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
        frame.getContentPane().setFont(new Font("宋体", Font.BOLD, 16));
        frame.getContentPane().setLayout(null);

        table = new JTable();
        //DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(743, 451);
        scrollPane.setLocation(10, 32);
        frame.getContentPane().add(scrollPane);
        List<Userorder> userorders = Userorder.getStoreOrder(store_id);
        TableRefresh.refreshStore_UserorderTable(userorders, table);

        JButton btnNewButton_7 = new JButton("拒绝接单");
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_rejectOrderActionPerformed(e);
            }
        });
        btnNewButton_7.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_7.setBounds(763, 78, 111, 30);
        frame.getContentPane().add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("接单");//接单按钮
        btnNewButton_8.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_acceptOrderActionPerformed(e);
            }
        });
        btnNewButton_8.setBounds(763, 152, 111, 30);
        frame.getContentPane().add(btnNewButton_8);

        JButton btnNewButton_9 = new JButton("开始配送");
        btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_deliverOrderActionPerformed(e);
            }
        });
        btnNewButton_9.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_9.setBounds(763, 220, 111, 30);
        frame.getContentPane().add(btnNewButton_9);

        JButton btnNewButton_10 = new JButton("送达");
        btnNewButton_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_finishOrderActionPerformed(e);
            }
        });
        btnNewButton_10.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_10.setBounds(762, 288, 112, 30);
        frame.getContentPane().add(btnNewButton_10);

        JButton btnNewButton = new JButton("退款");//退款
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_refundActionPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton.setBounds(764, 358, 110, 30);
        frame.getContentPane().add(btnNewButton);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnNewMenu_1 = new JMenu("订单管理(C)");
        mnNewMenu_1.setMnemonic(KeyEvent.VK_C);
        mnNewMenu_1.setFont(new Font("宋体", Font.BOLD, 16));
        menuBar.add(mnNewMenu_1);

        JMenu mnNewMenu = new JMenu("\u5168\u90E8");
        mnNewMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mnNewMenu_1.setMnemonic(KeyEvent.VK_A);
        mnNewMenu.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu_1.add(mnNewMenu);

        JMenuItem mntmNewMenuItem_6 = new JMenuItem("全部         ", 'A');
        mntmNewMenuItem_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        mntmNewMenuItem_6.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_6);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("未接单         ", 'Y');
        mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "等待商家接单";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_4.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_4);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("已接单         ");
        mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));//快捷键
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "商家已接单";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_1.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("配送中         ", 'D');
        mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke('D', ActionEvent.CTRL_MASK));//快捷键
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "配送中";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_2.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_2);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("已完成         ", 'F');
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "订单已完成";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke('F', ActionEvent.CTRL_MASK));//快捷键
        mntmNewMenuItem_3.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem = new JMenuItem("申请退款         ", 'L');
        mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke('L', ActionEvent.CTRL_MASK));//快捷键
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "申请退款";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem tadayorder = new JMenuItem("今日订单      ", 'T');
        tadayorder.setAccelerator(KeyStroke.getKeyStroke('T'));//快捷键
        tadayorder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOneDayOrder(store_id);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        tadayorder.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu_1.add(tadayorder);

        JMenu mnNewMenu_5 = new JMenu("排序(S)");
        mnNewMenu_5.setFont(new Font("宋体", Font.BOLD, 16));
        menuBar.add(mnNewMenu_5);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("按日期优先排序");
        mntmNewMenuItem_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOrderSortByData(store_id);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_5.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu_5.add(mntmNewMenuItem_5);


        JMenu mnNewMenu_4 = new JMenu("刷新");//刷新菜单项

        mnNewMenu_4.setFont(new Font("宋体", Font.BOLD, 16));
        menuBar.add(mnNewMenu_4);

        JMenuItem mntmNewMenuItem_7 = new JMenuItem("刷新");
        mntmNewMenuItem_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                TableRefresh.refreshStore_UserorderTable(userorders, table);
            }
        });
        mntmNewMenuItem_7.setFont(new Font("宋体", Font.BOLD, 16));
        mnNewMenu_4.add(mntmNewMenuItem_7);

        JMenu mnNewMenu_3 = new JMenu("\u9000\u51FA\uFF08Q\uFF09");
        mnNewMenu_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
        });
        mnNewMenu_3.setFont(new Font("宋体", Font.BOLD, 16));
        menuBar.add(mnNewMenu_3);
    }
    /*******************************************消息响应函数*****************************************/
    /**
     * 拒单
     * */
    private void btn_rejectOrderActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        String neworderstatus = "商家已拒单";
        int valuecolumn=dtm.findColumn("是否选中");
        int ordernumcolumn = dtm.findColumn("订单号");
        int orderstatuscolumn=dtm.findColumn("订单状态");
        for (int i = 0; i < table.getRowCount(); i++) {
            String getvalue = table.getValueAt(i, valuecolumn).toString();
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            if (getvalue == "true") {
                if (orderstatus.equals("等待商家接单")) {
                    Userorder.updateOrderstatus(ordernum, neworderstatus);
                    JOptionPane.showMessageDialog(null, "拒单成功！");
                    List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                    TableRefresh.refreshStore_UserorderTable(userorders, table);
                } else
                    JOptionPane.showMessageDialog(null, "拒单失败！");
            }
        }
    }
    /**
     * 接单
     * */
    private void btn_acceptOrderActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        String neworderstatus = "商家已接单";
        int valuecolumn=dtm.findColumn("是否选中");
        int ordernumcolumn = dtm.findColumn("订单号");
        int orderstatuscolumn=dtm.findColumn("订单状态");
        for (int i = 0; i < table.getRowCount(); i++) {
            String getvalue = table.getValueAt(i, valuecolumn).toString();
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            if (getvalue == "true") {
                if (orderstatus.equals("用户已付款")) {
                    Userorder.updateOrderstatus(ordernum, neworderstatus);
                    JOptionPane.showMessageDialog(null, "接单成功！");
                    List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                    TableRefresh.refreshStore_UserorderTable(userorders, table);
                } else
                    JOptionPane.showMessageDialog(null, "接单失败！");
            }
        }
    }
    /**
     * 配送
     * */
    public void btn_deliverOrderActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        String neworderstatus = "配送中";
        int valuecolumn=dtm.findColumn("是否选中");
        int ordernumcolumn = dtm.findColumn("订单号");
        int orderstatuscolumn=dtm.findColumn("订单状态");
        for (int i = 0; i < table.getRowCount(); i++) {
            String getvalue = table.getValueAt(i, valuecolumn).toString();
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            if (getvalue == "true") {
                if (orderstatus.equals("商家已接单")) {
                    Userorder.updateOrderstatus(ordernum, neworderstatus);
                    JOptionPane.showMessageDialog(null, "订单开始配送！");
                    List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                    TableRefresh.refreshStore_UserorderTable(userorders, table);
                } else
                    JOptionPane.showMessageDialog(null, "接单后才能开始配送！");
            }
        }
    }
    /**
     * 送达
     * */
    public void btn_finishOrderActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        String neworderstatus = "订单已完成";
        int valuecolumn=dtm.findColumn("是否选中");
        int ordernumcolumn = dtm.findColumn("订单号");
        int orderstatuscolumn=dtm.findColumn("订单状态");
        for (int i = 0; i < table.getRowCount(); i++) {
            String getvalue = table.getValueAt(i, valuecolumn).toString();
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            if (getvalue == "true") {
                if (orderstatus.equals("配送中")) {
                    Userorder.updateOrderstatus(ordernum, neworderstatus);//改订单状态为已完成
                    List<Order_goods>list=Order_goods.getOrder_GoodsList(ordernum);	//获取订单和商品信息关联表
                    for (int j = 0; j < list.size(); j++) {
                        int store_id = list.get(j).store_id;
                        int goods_id = list.get(j).goods_id;
                        int buynum = list.get(j).buynum;
                        Store.upDateGoodsSaleNum(store_id, goods_id, buynum);//改商品的销售量
                    }
                    JOptionPane.showMessageDialog(null, "订单已完成！");
                    List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                    TableRefresh.refreshStore_UserorderTable(userorders, table);
                } else
                    JOptionPane.showMessageDialog(null, "无效操作！");
            }
        }
    }
    /**
     * 退款
     * */
    public void btn_refundActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        int valuecolumn=dtm.findColumn("是否选中");
        int ordernumcolumn = dtm.findColumn("订单号");
        for (int i = 0; i < table.getRowCount(); i++) {
            String getvalue = table.getValueAt(i, valuecolumn).toString();
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            if (getvalue == "true") {
                String total_price=String.valueOf(Userorder.getTotal_price(ordernum));//获取总价格
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
