package Login;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import control_packet.Str;
import data.Login;
import data.Manager;
public class ManagerModifyPasswordFrame  {

    public JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ManagerModifyPasswordFrame  window = new ManagerModifyPasswordFrame ();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ManagerModifyPasswordFrame () {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 393, 382);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("输入您的账号：");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel.setBounds(25, 27, 113, 21);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 16));
        textField.setBounds(167, 28, 144, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("输入您的旧密码：");
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel_1.setBounds(25, 77, 135, 21);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("宋体", Font.BOLD, 16));
        textField_1.setBounds(167, 78, 144, 21);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("输入您的新密码：");
        lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel_2.setBounds(25, 131, 135, 21);
        frame.getContentPane().add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("宋体", Font.BOLD, 16));
        textField_2.setBounds(167, 132, 144, 21);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("再次输入新密码：");
        lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel_3.setBounds(25, 183, 135, 21);
        frame.getContentPane().add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("宋体", Font.BOLD, 16));
        textField_3.setBounds(167, 184, 144, 21);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JButton btnNewButton = new JButton("确定");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_studentModifypasswordActionPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton.setBounds(133, 248, 97, 23);
        frame.getContentPane().add(btnNewButton);
    }

    /***************************消息响应函数*******************************/
    private void btn_studentModifypasswordActionPerformed(ActionEvent e) {
        String usernum = textField.getText();
        String oldpassword = textField_1.getText();
        String newpassword1 = textField_2.getText();
        String newpassword2 = textField_3.getText();
        int returnnum;
        if (usernum.length() == 0 || oldpassword.length() == 0 || newpassword1.length() == 0 || newpassword2.length() == 0)
            JOptionPane.showMessageDialog(null, "输入不能为空！");
        else if (Str.isContainChinese(newpassword1) || newpassword1.length() < 6 || newpassword1.length() > 12)
            JOptionPane.showMessageDialog(null, "新密码不符合规则，请重新输入");//密码不能含有汉字，且位数为6~12
        else if (!newpassword1.equals(newpassword2))
            JOptionPane.showMessageDialog(null, "您输入的两次密码不一致请重新输入！");
        else if (oldpassword.equals(newpassword1))
            JOptionPane.showMessageDialog(null, "新旧密码不能相同请重新输入！");
        else {
            returnnum = Login.managerLogin(usernum, oldpassword);
            if (returnnum == 0)
                JOptionPane.showMessageDialog(null, "该账号不存在");
            if (returnnum == 1)
                JOptionPane.showMessageDialog(null, "旧密码错误请重新输入");
            if (returnnum == 2) {
                Manager.modifyManagerPassword(usernum, newpassword1);
                JOptionPane.showMessageDialog(null, "密码修改成功！");
                frame.dispose();
            }
        }

    }
}