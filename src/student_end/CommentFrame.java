package student_end;
import javax.swing.*;
import data.*;
import control_packet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CommentFrame {
    public JFrame evaluateframe;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnNewRadioButton_1;
    private JRadioButton rdbtnNewRadioButton_2;
    private JRadioButton rdbtnNewRadioButton_3;
    private JRadioButton rdbtnNewRadioButton_4;
    private JTextArea textArea999;
    private String ordernum;
    public CommentFrame(String ordernum1) {
    	ordernum=ordernum1;
        evaluateframe = new JFrame();
        evaluateframe.setTitle("���۽���");
        evaluateframe.setBounds(100, 100, 557, 371);
        evaluateframe.getContentPane().setLayout(null);
        FrameChange.setCenter(evaluateframe);//���������ʾ

        JLabel lblNewLabel999 = new JLabel("�����̼�/��Ʒ������");
        lblNewLabel999.setBounds(21, 26, 194, 22);
        lblNewLabel999.setFont(new Font("����", Font.BOLD, 18));
        evaluateframe.getContentPane().add(lblNewLabel999);

        rdbtnNewRadioButton = new JRadioButton("1��");
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_2.setSelected(false);
                rdbtnNewRadioButton_3.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);
            }
        });
        rdbtnNewRadioButton.setBounds(23, 55, 56, 23);
        rdbtnNewRadioButton.setFont(new Font("����", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_1 = new JRadioButton("2��");//2��
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
                rdbtnNewRadioButton_2.setSelected(false);
                rdbtnNewRadioButton_3.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);
            }
        });
        rdbtnNewRadioButton_1.setBounds(89, 55, 56, 23);
        rdbtnNewRadioButton_1.setFont(new Font("����", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton_1);

        rdbtnNewRadioButton_2 = new JRadioButton("3��");//3��
        rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_3.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);

            }
        });
        rdbtnNewRadioButton_2.setBounds(147, 55, 52, 23);
        rdbtnNewRadioButton_2.setFont(new Font("����", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton_2);

        rdbtnNewRadioButton_3 = new JRadioButton("4��");//4��
        rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_2.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);
            }
        });
        rdbtnNewRadioButton_3.setBounds(209, 55, 57, 23);
        rdbtnNewRadioButton_3.setFont(new Font("����", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton_3);

        rdbtnNewRadioButton_4 = new JRadioButton("5��");//5��
        rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_2.setSelected(false);
                rdbtnNewRadioButton_3.setSelected(false);
            }
        });
        rdbtnNewRadioButton_4.setBounds(279, 55, 51, 23);
        rdbtnNewRadioButton_4.setFont(new Font("����", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton_4);

        JButton btnNewButton999 = new JButton("�ύ");
        btnNewButton999.setIcon(new ImageIcon("src/images/�ύ.png"));
        btnNewButton999.addActionListener(new ActionListener() {//�����ύ
            public void actionPerformed(ActionEvent e) {
            	btn_commitActionPerformed(e);
            }
        });
        btnNewButton999.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton999.setBounds(33, 299, 97, 23);
        evaluateframe.getContentPane().add(btnNewButton999);

        JLabel lblNewLabel998 = new JLabel("��ζ��Σ��԰�װ����������");
        lblNewLabel998.setFont(new Font("����", Font.BOLD, 18));
        lblNewLabel998.setBounds(19, 84, 258, 21);
        evaluateframe.getContentPane().add(lblNewLabel998);

        textArea999 = new JTextArea();
        textArea999.setLineWrap(true);
        textArea999.setWrapStyleWord(true);
        textArea999.setFont(new Font("����", Font.BOLD, 16));
        textArea999.setRows(10);
        textArea999.setBounds(26, 121, 413, 154);
        evaluateframe.getContentPane().add(textArea999);
    }
/********************************��Ϣ��Ӧ����**********************************/
    private void btn_commitActionPerformed(ActionEvent e) {
    	 int evaluategrade;
         String comment = textArea999.getText();
         if (rdbtnNewRadioButton.isSelected())
             evaluategrade = 1;
         else if (rdbtnNewRadioButton_1.isSelected())
             evaluategrade = 2;
         else if (rdbtnNewRadioButton_2.isSelected())
             evaluategrade = 3;
         else if (rdbtnNewRadioButton_3.isSelected())
             evaluategrade = 4;
         else
             evaluategrade = 5;
         Evaluate evaluate = new Evaluate();
         evaluate.ordernum = ordernum;    
         evaluate.comment = comment;
         evaluate.grade = evaluategrade;
         Evaluate.addEvaluate(evaluate);//��������
         int store_id=Userorder.getStore_id(ordernum);//��ȡ�ö�����Ӧ���̵��
         Evaluate.updateStoreGrade(store_id);//�����̵�����
         JOptionPane.showMessageDialog(null, "���۳ɹ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
         evaluateframe.dispose();
         Userorder.updateOrderstatus(ordernum, "����������");
	 }
}