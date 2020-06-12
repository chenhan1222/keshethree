package teacher_end;

import control_packet.TableRefresh;
import data.Bespoke;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentMessageFrame {
    public JFrame studentmessageframe;
    public JTextField textField_01;
    public JTextField textField_02;
    private JLabel label_1;
    private JLabel label_2;
    private JScrollPane scrollPane;
    private DefaultTableModel dtm;
    private DefaultTableCellRenderer r;
    private JButton btnNewButton_1;
    public String bespokenum;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentMessageFrame window = new StudentMessageFrame("");
                    window.studentmessageframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public StudentMessageFrame(String bespokenum1) {
        initialize(bespokenum1);
    }

    /**
     * Initialize the contents of the frame.
     */

    /*******************************************学生端答疑预约子模块界面布局*************************************************/

    private void initialize(String bespokenum1) {
        bespokenum=bespokenum1;
        studentmessageframe = new JFrame();
        studentmessageframe.setTitle("提交预约");
        studentmessageframe.setBounds(100, 100, 334, 200);
        studentmessageframe.getContentPane().setLayout(null);

        label_1 = new JLabel("请输入你的姓名：");
        label_1.setFont(new Font("宋体", Font.BOLD, 13));
        label_1.setBounds(12, 25, 104, 19);
        studentmessageframe.getContentPane().add(label_1);

        textField_01 = new JTextField();
        textField_01.setFont(new Font("宋体", Font.BOLD, 14));
        textField_01.setBounds(119, 23, 138, 21);
        studentmessageframe.getContentPane().add(textField_01);
        textField_01.setColumns(10);

        btnNewButton_1 = new JButton("提交预约");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_submitBespokeActionPerformed(e);
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton_1.setBounds(103, 126, 111, 25);
        studentmessageframe.getContentPane().add(btnNewButton_1);

        label_2 = new JLabel("\u7ED9\u8001\u5E08\u7684\u7559\u8A00\uFF1A");
        label_2.setFont(new Font("宋体", Font.BOLD, 13));
        label_2.setBounds(12, 72, 104, 19);
        studentmessageframe.getContentPane().add(label_2);

        textField_02 = new JTextField();
        textField_02.setFont(new Font("宋体", Font.BOLD, 14));
        textField_02.setBounds(119, 70, 138, 21);
        studentmessageframe.getContentPane().add(textField_02);
        textField_02.setColumns(10);
    }

    /*************************************消息响应函数*******************************************************/
    private void btn_submitBespokeActionPerformed(ActionEvent e) {
        String qa_message=textField_02.getText();
        String s_name=textField_01.getText();
        Bespoke.updateBespokestatus(bespokenum,"已预约",qa_message,s_name);
        JOptionPane.showMessageDialog(null, "答疑预约成功！");
        List<Bespoke> bespokeList = Bespoke.getStudentBespoke();
        TableRefresh.refreshStudentBespokeTable(bespokeList, StudentSchedule.table_001);
    }
}
