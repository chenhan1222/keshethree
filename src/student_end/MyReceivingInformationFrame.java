package student_end;

import Login.LoginFrame;
import control_packet.TableRefresh;
import data.Receiveaddress;
import tabletools.MyReceiveAddressTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MyReceivingInformationFrame {
    public JFrame frame;
    public static JTable table;
    /**
     * Launch the application.
     */

    public MyReceivingInformationFrame() {
        initialize();
    }

    /**
     * Create the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyReceivingInformationFrame window = new MyReceivingInformationFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 682, 407);
        frame.setTitle("收获信息管理");
        frame.getContentPane().setLayout(null);

        MyReceiveAddressTableModel dtm=new  MyReceiveAddressTableModel();
        table = new JTable(dtm);
        table.setFont(new Font("宋体", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 38, 531, 317);
        frame.getContentPane().add(scrollPane);
        List<Receiveaddress> list = Receiveaddress.getReceiveAddress(LoginFrame.usernum);
        TableRefresh.refreshReceiveAddressTable(list, table);

        JButton btnNewButton_1 = new JButton("新增地址");
        btnNewButton_1.setIcon(new ImageIcon("src/images/添加.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//新增地址按钮
                btn_addAddressActionPerformed( e);
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton_1.setBounds(540, 10, 118, 25);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("修改");
        btnNewButton_2.setIcon(new ImageIcon("src/images/修改.png"));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//修改功能
                btn_modifyaddressActionPerformed(e);
            }
        });
        btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton_2.setBounds(551, 154, 107, 25);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("删除");
        btnNewButton_3.setIcon(new ImageIcon("src/images/删除.png"));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//删除地址按钮
                btn_deleteAddressActionPerformed( e);
            }
        });
        btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton_3.setBounds(551, 216, 107, 25);
        frame.getContentPane().add(btnNewButton_3);

    }
    /**************************消息响应函数**********************/
    /**
     * 获取全部地址
     * */
    private void btn_getAlladdAddressActionPerformed(ActionEvent e) {
        List<Receiveaddress> list = Receiveaddress.getReceiveAddress(LoginFrame.usernum);
        TableRefresh.refreshReceiveAddressTable(list, table);
    }
    /**
     * 添加收货地址
     * */
    private void btn_addAddressActionPerformed(ActionEvent e) {
        AddAddressFrame window = new AddAddressFrame();
        window.frame.setVisible(true);
    }
    private void btn_modifyaddressActionPerformed(ActionEvent e) {
        MyReceiveAddressTableModel dtm = (MyReceiveAddressTableModel) table.getModel();
        boolean ifchange = false;//是否改变的标志
        int ifselectcolumn=dtm.findColumn("是否选中");
        int contactcolumn=dtm.findColumn("联系人");
        int addresscolumn=dtm.findColumn("地址");
        int phonenumcolumn=dtm.findColumn("联系电话");
        int sexcolumn=dtm.findColumn("性别");
        for (int i = 0; i < table.getRowCount(); i++) {
            String contact = table.getValueAt(i, contactcolumn).toString();
            String newaddress = table.getValueAt(i, addresscolumn).toString();
            String newphonenum = table.getValueAt(i,  phonenumcolumn).toString();
            String newsex = table.getValueAt(i,  sexcolumn).toString();
            String value;
            try {
                value = table.getValueAt(i, ifselectcolumn).toString();
            } catch (Exception e2) {
                value = "false";
            }
            if (value.equals("true")) {
                ifchange = true;
                Receiveaddress receiveaddress = new Receiveaddress();
                receiveaddress.usernum = LoginFrame.usernum;
                receiveaddress.contact = contact;
                receiveaddress.address = newaddress;
                receiveaddress.phonenum = newphonenum;
                receiveaddress.sex = newsex;
                Receiveaddress.updateAddress(receiveaddress);
            }
        }
        List<Receiveaddress> list = Receiveaddress.getReceiveAddress(LoginFrame.usernum);
        TableRefresh.refreshReceiveAddressTable(list, table);
        if (ifchange == true)
            JOptionPane.showMessageDialog(null, "修改成功", "提示:", JOptionPane.PLAIN_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "未作任何修改", "提示:", JOptionPane.PLAIN_MESSAGE);
    }
    /**
     * 删除
     * */
    private void btn_deleteAddressActionPerformed(ActionEvent e) {
        MyReceiveAddressTableModel dtm = (MyReceiveAddressTableModel) table.getModel();
        int ifselectcolumn=dtm.findColumn("是否选中");
        int contactcolumn=dtm.findColumn("联系人");
        for (int i = 0; i < table.getRowCount(); i++) {
            String contact = table.getValueAt(i, contactcolumn).toString();
            String value;
            try {
                value = table.getValueAt(i, ifselectcolumn).toString();
            } catch (Exception e2) {
                value = "false";
            }
            if (value.equals("true")) {
                Receiveaddress.deleteAddress(LoginFrame.usernum, contact);
                List<Receiveaddress> list = Receiveaddress.getReceiveAddress(LoginFrame.usernum);
                TableRefresh.refreshReceiveAddressTable(list, table);
            }
        }
    }
}