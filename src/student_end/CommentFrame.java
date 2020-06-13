package student_end;

import control_packet.FrameChange;
import data.Evaluate;
import data.Userorder;

import javax.swing.*;
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
        evaluateframe.setTitle("评价界面");
        evaluateframe.setBounds(100, 100, 557, 371);
        evaluateframe.getContentPane().setLayout(null);
        FrameChange.setCenter(evaluateframe);//窗体居中显示

        JLabel lblNewLabel999 = new JLabel("您对商家/菜品满意吗？");
        lblNewLabel999.setBounds(21, 26, 238, 22);
        lblNewLabel999.setFont(new Font("宋体", Font.BOLD, 18));
        evaluateframe.getContentPane().add(lblNewLabel999);

        rdbtnNewRadioButton = new JRadioButton("1分");
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_2.setSelected(false);
                rdbtnNewRadioButton_3.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);
            }
        });
        rdbtnNewRadioButton.setBounds(23, 55, 71, 23);
        rdbtnNewRadioButton.setFont(new Font("宋体", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_1 = new JRadioButton("2分");//2分
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
                rdbtnNewRadioButton_2.setSelected(false);
                rdbtnNewRadioButton_3.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);
            }
        });
        rdbtnNewRadioButton_1.setBounds(100, 55, 65, 23);
        rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton_1);

        rdbtnNewRadioButton_2 = new JRadioButton("3分");//3分
        rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_3.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);

            }
        });
        rdbtnNewRadioButton_2.setBounds(171, 55, 68, 23);
        rdbtnNewRadioButton_2.setFont(new Font("宋体", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton_2);

        rdbtnNewRadioButton_3 = new JRadioButton("4分");//4分
        rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_2.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);
            }
        });
        rdbtnNewRadioButton_3.setBounds(245, 55, 68, 23);
        rdbtnNewRadioButton_3.setFont(new Font("宋体", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton_3);

        rdbtnNewRadioButton_4 = new JRadioButton("5分");//5分
        rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_2.setSelected(false);
                rdbtnNewRadioButton_3.setSelected(false);
            }
        });
        rdbtnNewRadioButton_4.setBounds(319, 55, 70, 23);
        rdbtnNewRadioButton_4.setFont(new Font("宋体", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton_4);

        JButton btnNewButton999 = new JButton("提交");
        btnNewButton999.setIcon(new ImageIcon("src/images/提交.png"));
        btnNewButton999.addActionListener(new ActionListener() {//评价提交
            public void actionPerformed(ActionEvent e) {
                btn_commitActionPerformed(e);
            }
        });
        btnNewButton999.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton999.setBounds(162, 288, 97, 23);
        evaluateframe.getContentPane().add(btnNewButton999);

        JLabel lblNewLabel998 = new JLabel("口味如何？对包装服务满意吗");
        lblNewLabel998.setFont(new Font("宋体", Font.BOLD, 18));
        lblNewLabel998.setBounds(19, 84, 258, 21);
        evaluateframe.getContentPane().add(lblNewLabel998);

        textArea999 = new JTextArea();
        textArea999.setLineWrap(true);
        textArea999.setWrapStyleWord(true);
        textArea999.setFont(new Font("宋体", Font.BOLD, 16));
        textArea999.setRows(10);
        textArea999.setBounds(26, 121, 413, 154);
        evaluateframe.getContentPane().add(textArea999);
    }
    /********************************消息响应函数**********************************/
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
        Evaluate.addEvaluate(evaluate);//增加评价
        int store_id=Userorder.getStore_id(ordernum);//获取该订单对应的商店号
        Evaluate.updateStoreGrade(store_id);//更新商店评分
        JOptionPane.showMessageDialog(null, "评价成功！", "提示", JOptionPane.PLAIN_MESSAGE);
        evaluateframe.dispose();
        Userorder.updateOrderstatus(ordernum, "订单已评价");
    }
}