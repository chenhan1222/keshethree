package student_end;
import data.*;
import Login.LoginFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import control_packet.FrameChange;
import control_packet.TableRefresh;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
public class MyOrderFrame {
    public JFrame frame;
    private JTable table;
    private String usernum;
    /**
     * Launch the application.
     */
    public MyOrderFrame() {
        usernum = LoginFrame.usernum;
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("宋体", Font.BOLD, 16));
        frame.getContentPane().setLayout(null);

        table = new JTable();
        //DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(654, 347);
        scrollPane.setLocation(10, 52);
        frame.getContentPane().add(scrollPane);
        List<Userorder> userorders = Userorder.getAllUserorder(usernum);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);

        JButton btnNewButton = new JButton("申请退款");
        btnNewButton.setIcon(new ImageIcon("src/images/取消订单.png"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_applyForRefundActionPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton.setBounds(674, 155, 140, 30);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("联系商家");
        btnNewButton_1.setIcon(new ImageIcon("src/images/联系商家.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//联系商家
                btn_connectStoreActionPerformed(e);
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_1.setBounds(674, 217, 140, 30);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("已评价");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            //获得待评价的订单
                btn_getFinishUserorderActionPerformed( e);
            }
        });
        btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_2.setBounds(338, 10, 120, 25);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("待评价");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            //获得已完成的订单
                btn_getWaitComentUserorderActionPerformed(e);
            }
        });
        btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_3.setBounds(180, 10, 120, 25);
        frame.getContentPane().add(btnNewButton_3);

        JButton button = new JButton("评价");
        button.setIcon(new ImageIcon("src/images/评价.png"));
        button.addActionListener(new ActionListener() {//评价
            //btnNewButton
            public void actionPerformed(ActionEvent e) {
                btn_comemntActionPerformed(e);
            }
        });
        button.setFont(new Font("宋体", Font.BOLD, 16));
        button.setBounds(674, 283, 140, 30);
        frame.getContentPane().add(button);

        JButton btnNewButton_4 = new JButton("全部订单");//获得用户的所有订单
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_getAllUserorderActionPerformed(e);
            }
        });
        btnNewButton_4.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_4.setBounds(23, 10, 120, 25);
        frame.getContentPane().add(btnNewButton_4);

        JButton btnNewButton_6 = new JButton("已退款");
        btnNewButton_6.setIcon(new ImageIcon("src/images/退款.png"));
        btnNewButton_6.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {        //获取已退款的订单
                btn_getrefundedUserorderActionPerformed( e);
            }
        });
        btnNewButton_6.setBounds(641, 10, 120, 25);
        frame.getContentPane().add(btnNewButton_6);

        JButton btnNewButton_7 = new JButton("取消订单");//取消订单按钮，只有在未付款的情况下可以取消
        btnNewButton_7.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_cancelUserorderActionPerformed(e);
            }
        });
        btnNewButton_7.setBounds(674, 85, 140, 30);
        frame.getContentPane().add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("申请退款");
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_getApplyForRefundUserorderActionPerformed(e);
            }
        });
        btnNewButton_8.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_8.setBounds(485, 10, 120, 25);
        frame.getContentPane().add(btnNewButton_8);

        JButton btnNewButton_5 = new JButton("支付");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_paytActionPerformed(e);
            }
        });
        btnNewButton_5.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_5.setBounds(674, 344, 140, 30);
        frame.getContentPane().add(btnNewButton_5);
        frame.setTitle("我的订单");
        frame.setBounds(100, 100, 840, 484);
    }
    /******************************************消息响应函数****************************************/
    /**
     * 获取全部订单
     * */
    private void btn_getAllUserorderActionPerformed(ActionEvent e) {
        List<Userorder> userorders = Userorder.getAllUserorder(usernum);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }
    /**
     * 获取待评价订单
     * */
    private void btn_getWaitComentUserorderActionPerformed(ActionEvent e) {
        String orderstatus = "订单已完成";
        List<Userorder> userorders = Userorder.getUserorder(usernum, "orderstatus", orderstatus);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }
    /**
     * 获取已评价订单
     * */
    private void btn_getFinishUserorderActionPerformed(ActionEvent e) {
        String orderstatus = "订单已评价";
        List<Userorder> userorders = Userorder.getUserorder(usernum, "orderstatus", orderstatus);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }
    /**
     * 获取申请退款订单
     * */
    private void btn_getApplyForRefundUserorderActionPerformed(ActionEvent e) {
        String orderstatus = "申请退款";
        List<Userorder> userorders = Userorder.getUserorder(usernum, "orderstatus", orderstatus);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }
    /**
     * 获取已退款订单
     * */
    private void btn_getrefundedUserorderActionPerformed(ActionEvent e) {
        String orderstatus = "已退款";
        List<Userorder> userorders = Userorder.getUserorder(usernum, "orderstatus", orderstatus);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }
    /**
     * 联系商家
     * */
    private void btn_connectStoreActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        int ifselectcolumn=dtm.findColumn("是否选中");
        int ordernumcolumn= dtm.findColumn("订单号");
        for (int i = 0; i < table.getRowCount(); i++) {
            String value = table.getValueAt(i, ifselectcolumn).toString();//读取你获取行号的某一列的值（也就是字段）
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            if (value == "true") {
                JOptionPane.showMessageDialog(null, Userorder.Getstorephone(ordernum), "商家联系电话:", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    /**
     * 取消订单
     * */
    private void btn_cancelUserorderActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        int valuecolumn=dtm.findColumn("是否选中");
        int ordernumcolumn = dtm.findColumn("订单号");
        int orderstatuscolumn=dtm.findColumn("订单状态");
        for (int i = 0; i < table.getRowCount(); i++) {
            String value = table.getValueAt(i, valuecolumn).toString();//读取你获取行号的某一列的值（也就是字段）
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            if (value == "true") {
                if (orderstatus.equals("等待用户支付")) {
                    JOptionPane.showMessageDialog(null, "订单已取消", "提示", JOptionPane.PLAIN_MESSAGE);
                    Userorder.deleteUserorder(ordernum);
                } else {
                    JOptionPane.showMessageDialog(null, "不满足取消条件",null, JOptionPane.PLAIN_MESSAGE);
                }

            }
        }
        List<Userorder> userorders = Userorder.getAllUserorder(usernum);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }
    /**
     * 申请退款
     * */
    private void btn_applyForRefundActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        int valuecolumn=dtm.findColumn("是否选中");
        int ordernumcolumn = dtm.findColumn("订单号");
        int orderstatuscolumn=dtm.findColumn("订单状态");
        for (int i = 0; i < table.getRowCount(); i++) {
            String value = table.getValueAt(i, valuecolumn).toString();//读取你获取行号的某一列的值（也就是字段）
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            if (value == "true") {
                if (orderstatus.equals("用户已付款")) {
                    JOptionPane.showMessageDialog(null, "申请退款中", "提示", JOptionPane.PLAIN_MESSAGE);
                    Userorder.updateOrderstatus(ordernum, "申请退款");
                } else {
                    JOptionPane.showMessageDialog(null, "不满足申请条件，如有需要请联系商家！", "申请退款失败", JOptionPane.PLAIN_MESSAGE);
                }

            }
        }
        List<Userorder> userorders = Userorder.getAllUserorder(usernum);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }


    /**
     * 评价
     * */
    private void btn_comemntActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        int ordernumcolumn= dtm.findColumn("订单号");
        int ifselectcolumn = dtm.findColumn("是否选中");
        int orderstatuscolumn = dtm.findColumn("订单状态");
        for (int i = 0; i < table.getRowCount(); i++) {
            String value = table.getValueAt(i, ifselectcolumn).toString();//读取你获取行号的某一列的值（也就是字段）
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            if (value == "true") {
                if (orderstatus.equals("订单已完成")) {
                    CommentFrame window = new CommentFrame(ordernum);
                    window.evaluateframe.setVisible(true);
                } else if (orderstatus.equals("订单已评价"))
                    JOptionPane.showMessageDialog(null, "订单已经评价过了！", "提示", JOptionPane.PLAIN_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "订单未完成不能评价！", "提示", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    /**
     * 支付
     * */
    private void btn_paytActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        int num=0;
        String getvalue;
        String ordernum;
        String orderstatus;
        double total_price;
        int ifselectcolumn = dtm.findColumn("是否选中");
        int ordernumcolumn= dtm.findColumn("订单号");
        int total_pricecolumn = dtm.findColumn("总价");
        int orderstatuscolumn=dtm.findColumn("订单状态");
        for (int i = 0; i < table.getRowCount(); i++) {
            getvalue = table.getValueAt(i, ifselectcolumn).toString();
            if (getvalue == "true") {
                num++;
            }
            if(num>1)
                break;
        }
        if(num==1) {
            for (int j = 0; j < table.getRowCount(); j++) {
                getvalue = table.getValueAt(j, ifselectcolumn).toString();
                if (getvalue == "true") {
                    ordernum= table.getValueAt(j, ordernumcolumn).toString();
                    total_price=Double.valueOf(table.getValueAt(j, total_pricecolumn).toString());
                    orderstatus=table.getValueAt(j, orderstatuscolumn).toString();
                    if(orderstatus.equals("等待用户支付")){//如果该订单未支付
                        //在此打开支付网页
                        String url="http://47.95.200.90:8080/se_wm?";
                        String finalurl=url+"ordernum="+ordernum+"&total_price="+total_price;
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            desktop.browse(new URI(finalurl));
                        } catch (IOException | URISyntaxException e1) {
                            // TODO Auto-generated catch block
                        }

                    }else {
                        JOptionPane.showMessageDialog(null, "该订单不能支付！");
                    }
                    break;
                }
            }
        }else {
            JOptionPane.showMessageDialog(null, "选中过多，请一次选择一个订单 进行支付！");
        }

    }
}

