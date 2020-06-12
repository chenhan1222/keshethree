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
        frame.getContentPane().setFont(new Font("����", Font.BOLD, 16));
        frame.getContentPane().setLayout(null);

        table = new JTable();
        //DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(654, 347);
        scrollPane.setLocation(10, 52);
        frame.getContentPane().add(scrollPane);
        List<Userorder> userorders = Userorder.getAllUserorder(usernum);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);

        JButton btnNewButton = new JButton("�����˿�");
        btnNewButton.setIcon(new ImageIcon("src/images/ȡ������.png"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_applyForRefundActionPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton.setBounds(674, 155, 140, 30);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("��ϵ�̼�");
        btnNewButton_1.setIcon(new ImageIcon("src/images/��ϵ�̼�.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//��ϵ�̼�
                btn_connectStoreActionPerformed(e);
            }
        });
        btnNewButton_1.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_1.setBounds(674, 217, 140, 30);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("������");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            //��ô����۵Ķ���
                btn_getFinishUserorderActionPerformed( e);
            }
        });
        btnNewButton_2.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_2.setBounds(338, 10, 120, 25);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("������");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            //�������ɵĶ���
                btn_getWaitComentUserorderActionPerformed(e);
            }
        });
        btnNewButton_3.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_3.setBounds(180, 10, 120, 25);
        frame.getContentPane().add(btnNewButton_3);

        JButton button = new JButton("����");
        button.setIcon(new ImageIcon("src/images/����.png"));
        button.addActionListener(new ActionListener() {//����
            //btnNewButton
            public void actionPerformed(ActionEvent e) {
                btn_comemntActionPerformed(e);
            }
        });
        button.setFont(new Font("����", Font.BOLD, 16));
        button.setBounds(674, 283, 140, 30);
        frame.getContentPane().add(button);

        JButton btnNewButton_4 = new JButton("ȫ������");//����û������ж���
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_getAllUserorderActionPerformed(e);
            }
        });
        btnNewButton_4.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_4.setBounds(23, 10, 120, 25);
        frame.getContentPane().add(btnNewButton_4);

        JButton btnNewButton_6 = new JButton("���˿�");
        btnNewButton_6.setIcon(new ImageIcon("src/images/�˿�.png"));
        btnNewButton_6.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {        //��ȡ���˿�Ķ���
                btn_getrefundedUserorderActionPerformed( e);
            }
        });
        btnNewButton_6.setBounds(641, 10, 120, 25);
        frame.getContentPane().add(btnNewButton_6);

        JButton btnNewButton_7 = new JButton("ȡ������");//ȡ��������ť��ֻ����δ���������¿���ȡ��
        btnNewButton_7.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_cancelUserorderActionPerformed(e);
            }
        });
        btnNewButton_7.setBounds(674, 85, 140, 30);
        frame.getContentPane().add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("�����˿�");
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_getApplyForRefundUserorderActionPerformed(e);
            }
        });
        btnNewButton_8.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_8.setBounds(485, 10, 120, 25);
        frame.getContentPane().add(btnNewButton_8);

        JButton btnNewButton_5 = new JButton("֧��");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_paytActionPerformed(e);
            }
        });
        btnNewButton_5.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_5.setBounds(674, 344, 140, 30);
        frame.getContentPane().add(btnNewButton_5);
        frame.setTitle("�ҵĶ���");
        frame.setBounds(100, 100, 840, 484);
    }
    /******************************************��Ϣ��Ӧ����****************************************/
    /**
     * ��ȡȫ������
     * */
    private void btn_getAllUserorderActionPerformed(ActionEvent e) {
        List<Userorder> userorders = Userorder.getAllUserorder(usernum);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }
    /**
     * ��ȡ�����۶���
     * */
    private void btn_getWaitComentUserorderActionPerformed(ActionEvent e) {
        String orderstatus = "���������";
        List<Userorder> userorders = Userorder.getUserorder(usernum, "orderstatus", orderstatus);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }
    /**
     * ��ȡ�����۶���
     * */
    private void btn_getFinishUserorderActionPerformed(ActionEvent e) {
        String orderstatus = "����������";
        List<Userorder> userorders = Userorder.getUserorder(usernum, "orderstatus", orderstatus);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }
    /**
     * ��ȡ�����˿��
     * */
    private void btn_getApplyForRefundUserorderActionPerformed(ActionEvent e) {
        String orderstatus = "�����˿�";
        List<Userorder> userorders = Userorder.getUserorder(usernum, "orderstatus", orderstatus);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }
    /**
     * ��ȡ���˿��
     * */
    private void btn_getrefundedUserorderActionPerformed(ActionEvent e) {
        String orderstatus = "���˿�";
        List<Userorder> userorders = Userorder.getUserorder(usernum, "orderstatus", orderstatus);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }
    /**
     * ��ϵ�̼�
     * */
    private void btn_connectStoreActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        int ifselectcolumn=dtm.findColumn("�Ƿ�ѡ��");
        int ordernumcolumn= dtm.findColumn("������");
        for (int i = 0; i < table.getRowCount(); i++) {
            String value = table.getValueAt(i, ifselectcolumn).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            if (value == "true") {
                JOptionPane.showMessageDialog(null, Userorder.Getstorephone(ordernum), "�̼���ϵ�绰:", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    /**
     * ȡ������
     * */
    private void btn_cancelUserorderActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        int valuecolumn=dtm.findColumn("�Ƿ�ѡ��");
        int ordernumcolumn = dtm.findColumn("������");
        int orderstatuscolumn=dtm.findColumn("����״̬");
        for (int i = 0; i < table.getRowCount(); i++) {
            String value = table.getValueAt(i, valuecolumn).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            if (value == "true") {
                if (orderstatus.equals("�ȴ��û�֧��")) {
                    JOptionPane.showMessageDialog(null, "������ȡ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
                    Userorder.deleteUserorder(ordernum);
                } else {
                    JOptionPane.showMessageDialog(null, "������ȡ������",null, JOptionPane.PLAIN_MESSAGE);
                }

            }
        }
        List<Userorder> userorders = Userorder.getAllUserorder(usernum);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }
    /**
     * �����˿�
     * */
    private void btn_applyForRefundActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        int valuecolumn=dtm.findColumn("�Ƿ�ѡ��");
        int ordernumcolumn = dtm.findColumn("������");
        int orderstatuscolumn=dtm.findColumn("����״̬");
        for (int i = 0; i < table.getRowCount(); i++) {
            String value = table.getValueAt(i, valuecolumn).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            if (value == "true") {
                if (orderstatus.equals("�û��Ѹ���")) {
                    JOptionPane.showMessageDialog(null, "�����˿���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
                    Userorder.updateOrderstatus(ordernum, "�����˿�");
                } else {
                    JOptionPane.showMessageDialog(null, "����������������������Ҫ����ϵ�̼ң�", "�����˿�ʧ��", JOptionPane.PLAIN_MESSAGE);
                }

            }
        }
        List<Userorder> userorders = Userorder.getAllUserorder(usernum);
        TableRefresh.refreshStudent_UserorderTable(userorders, table);
    }


    /**
     * ����
     * */
    private void btn_comemntActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        int ordernumcolumn= dtm.findColumn("������");
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        int orderstatuscolumn = dtm.findColumn("����״̬");
        for (int i = 0; i < table.getRowCount(); i++) {
            String value = table.getValueAt(i, ifselectcolumn).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
            String orderstatus = table.getValueAt(i, orderstatuscolumn).toString();
            String ordernum = table.getValueAt(i, ordernumcolumn).toString();
            if (value == "true") {
                if (orderstatus.equals("���������")) {
                    CommentFrame window = new CommentFrame(ordernum);
                    window.evaluateframe.setVisible(true);
                } else if (orderstatus.equals("����������"))
                    JOptionPane.showMessageDialog(null, "�����Ѿ����۹��ˣ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "����δ��ɲ������ۣ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    /**
     * ֧��
     * */
    private void btn_paytActionPerformed(ActionEvent e) {
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        int num=0;
        String getvalue;
        String ordernum;
        String orderstatus;
        double total_price;
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        int ordernumcolumn= dtm.findColumn("������");
        int total_pricecolumn = dtm.findColumn("�ܼ�");
        int orderstatuscolumn=dtm.findColumn("����״̬");
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
                    if(orderstatus.equals("�ȴ��û�֧��")){//����ö���δ֧��
                        //�ڴ˴�֧����ҳ
                        String url="http://47.95.200.90:8080/se_wm?";
                        String finalurl=url+"ordernum="+ordernum+"&total_price="+total_price;
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            desktop.browse(new URI(finalurl));
                        } catch (IOException | URISyntaxException e1) {
                            // TODO Auto-generated catch block
                        }

                    }else {
                        JOptionPane.showMessageDialog(null, "�ö�������֧����");
                    }
                    break;
                }
            }
        }else {
            JOptionPane.showMessageDialog(null, "ѡ�й��࣬��һ��ѡ��һ������ ����֧����");
        }

    }
}

