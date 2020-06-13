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
        frame.setTitle("�ջ���Ϣ����");
        frame.getContentPane().setLayout(null);

        MyReceiveAddressTableModel dtm=new  MyReceiveAddressTableModel();
        table = new JTable(dtm);
        table.setFont(new Font("����", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 38, 531, 317);
        frame.getContentPane().add(scrollPane);
        List<Receiveaddress> list = Receiveaddress.getReceiveAddress(LoginFrame.usernum);
        TableRefresh.refreshReceiveAddressTable(list, table);

        JButton btnNewButton_1 = new JButton("������ַ");
        btnNewButton_1.setIcon(new ImageIcon("src/images/���.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//������ַ��ť
                btn_addAddressActionPerformed( e);
            }
        });
        btnNewButton_1.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_1.setBounds(540, 10, 118, 25);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("�޸�");
        btnNewButton_2.setIcon(new ImageIcon("src/images/�޸�.png"));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//�޸Ĺ���
                btn_modifyaddressActionPerformed(e);
            }
        });
        btnNewButton_2.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_2.setBounds(551, 154, 107, 25);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("ɾ��");
        btnNewButton_3.setIcon(new ImageIcon("src/images/ɾ��.png"));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//ɾ����ַ��ť
                btn_deleteAddressActionPerformed( e);
            }
        });
        btnNewButton_3.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_3.setBounds(551, 216, 107, 25);
        frame.getContentPane().add(btnNewButton_3);

    }
    /**************************��Ϣ��Ӧ����**********************/
    /**
     * ��ȡȫ����ַ
     * */
    private void btn_getAlladdAddressActionPerformed(ActionEvent e) {
        List<Receiveaddress> list = Receiveaddress.getReceiveAddress(LoginFrame.usernum);
        TableRefresh.refreshReceiveAddressTable(list, table);
    }
    /**
     * ����ջ���ַ
     * */
    private void btn_addAddressActionPerformed(ActionEvent e) {
        AddAddressFrame window = new AddAddressFrame();
        window.frame.setVisible(true);
    }
    private void btn_modifyaddressActionPerformed(ActionEvent e) {
        MyReceiveAddressTableModel dtm = (MyReceiveAddressTableModel) table.getModel();
        boolean ifchange = false;//�Ƿ�ı�ı�־
        int ifselectcolumn=dtm.findColumn("�Ƿ�ѡ��");
        int contactcolumn=dtm.findColumn("��ϵ��");
        int addresscolumn=dtm.findColumn("��ַ");
        int phonenumcolumn=dtm.findColumn("��ϵ�绰");
        int sexcolumn=dtm.findColumn("�Ա�");
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
            JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "��ʾ:", JOptionPane.PLAIN_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "δ���κ��޸�", "��ʾ:", JOptionPane.PLAIN_MESSAGE);
    }
    /**
     * ɾ��
     * */
    private void btn_deleteAddressActionPerformed(ActionEvent e) {
        MyReceiveAddressTableModel dtm = (MyReceiveAddressTableModel) table.getModel();
        int ifselectcolumn=dtm.findColumn("�Ƿ�ѡ��");
        int contactcolumn=dtm.findColumn("��ϵ��");
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