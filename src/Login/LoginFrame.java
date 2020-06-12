package Login;

import business_end.BusinessMainFrame;
import control_packet.FrameChange;
import data.Login;
import data.User_store;
import management_end.ManageMainFrame;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import student_end.StudentMainFrame;
import teacher_end.TeacherFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame {
    public static String usernum;//用户名
    public static int store_id;//商店号
    private JFrame Loginframe;
    private JTextField textField;
    private JPasswordField passwordField;
    private JRadioButton managerRadioButton;
    private JRadioButton studentRadioButton;
    private JRadioButton storeRadioButton;
    private JRadioButton teacherRadioButton;
    private JButton btnNewButton_2;

    /**
     * Create the application.
     */
    public LoginFrame() {

        initialize();
    }

    /**
     * Launch the application.
     *
     * @throws UnsupportedLookAndFeelException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    /*SubstanceBusinessBlackSteelLookAndFeel()
     * SubstanceCremeCoffeeLookAndFeel()
     * SubstanceCremeLookAndFeel()
     * SubstanceMistAquaLookAndFeel()
     * SubstanceOfficeSilver2007LookAndFeel()
     * substance.skin.SubstanceSaharaLookAndFeel()
     * */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        //UIManager.setLookAndFeel(new org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel());
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                try {
                    //UIManager.setLookAndFeel(new org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel());
                    BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
                    UIManager.put("RootPane.setButtonVisible",false);
                    BeautyEyeLNFHelper.debug=true;
                    BeautyEyeLNFHelper.translucencyAtFrameInactive=false;
                    BeautyEyeLNFHelper.launchBeautyEyeLNF();

                    //org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
                    LoginFrame window = new LoginFrame();


                    window.Loginframe.setVisible(true);
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
        Loginframe = new JFrame();
        Loginframe.setTitle("欢迎来到登陆界面");
        Loginframe.setBounds(100, 100, 547, 413);
        Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Loginframe.getContentPane().setLayout(null);

        FrameChange.setCenter(Loginframe);
        textField = new JTextField();
        textField.setBounds(147, 121, 243, 25);
        Loginframe.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("账 号:");
        lblNewLabel.setIcon(new ImageIcon("src/images/用户名.png"));
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel.setBounds(35, 115, 109, 34);
        Loginframe.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("密 码:");
        lblNewLabel_1.setIcon(new ImageIcon("src/images/密码.png"));
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel_1.setBounds(35, 192, 109, 25);
        Loginframe.getContentPane().add(lblNewLabel_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(147, 193, 243, 25);
        Loginframe.getContentPane().add(passwordField);

        JButton btnNewButton = new JButton();
        //btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
        btnNewButton.setIcon(new ImageIcon("src/images/提交.png"));
        //btnNewButton.setHorizontalTextPosition(SwingConstants.RIGHT);//
        btnNewButton.setText("登陆");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_userLoginActionPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton.setBounds(45, 304, 100, 34);
        Loginframe.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.setIcon(new ImageIcon("src/images/重置.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                passwordField.setText("");
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_1.setBounds(188, 304, 100, 34);
        Loginframe.getContentPane().add(btnNewButton_1);

        JLabel lblNewLabel_2 = new JLabel("Hitwh\u6821\u56ED\u670D\u52A1\u7CFB\u7EDF\u6B22\u8FCE\u60A8!");
        lblNewLabel_2.setIcon(new ImageIcon("src/images/美食.png"));
        lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
        lblNewLabel_2.setBounds(78, 25, 342, 70);
        Loginframe.getContentPane().add(lblNewLabel_2);

        managerRadioButton = new JRadioButton("管理员");
        managerRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_managerSelectActionPerformed(e);
            }
        });
        managerRadioButton.setFont(new Font("宋体", Font.BOLD, 16));
        managerRadioButton.setBounds(45, 252, 99, 23);
        Loginframe.getContentPane().add(managerRadioButton);

        teacherRadioButton = new JRadioButton("教师");
        teacherRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_teacherSelectActionPerformed(e);
            }
        });
        teacherRadioButton.setFont(new Font("宋体", Font.BOLD, 16));
        teacherRadioButton.setBounds(163, 252, 74, 23);
        Loginframe.getContentPane().add(teacherRadioButton);

        storeRadioButton = new JRadioButton("商家");
        storeRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_storeSelectActionPerformed(e);
            }
        });
        storeRadioButton.setFont(new Font("宋体", Font.BOLD, 16));
        storeRadioButton.setBounds(260, 252, 74, 23);
        Loginframe.getContentPane().add(storeRadioButton);

        studentRadioButton = new JRadioButton("学生");
        studentRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_studentSelectActionPerformed(e);
            }
        });
        studentRadioButton.setFont(new Font("宋体", Font.BOLD, 16));
        studentRadioButton.setBounds(352, 252, 68, 23);
        Loginframe.getContentPane().add(studentRadioButton);

        btnNewButton_2 = new JButton("改密");
        btnNewButton_2.setIcon(new ImageIcon("src/images/修改.png"));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_modifyPasswordActionPerformed(e);
            }
        });
        btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_2.setBounds(326, 305, 100, 34);
        Loginframe.getContentPane().add(btnNewButton_2);

    }

    /**************************************消息响应函数***************************************/
    /**
     * 用户登陆
     */
    private void btn_userLoginActionPerformed(ActionEvent e) {
        String usernum = textField.getText();
        String password = String.valueOf(passwordField.getPassword());
        int returnnum;
        if (studentRadioButton.isSelected()) {
            if (usernum.equals("") || password.equals(""))
                JOptionPane.showMessageDialog(null, "输入不能为空请重新输入！");
            else {
                returnnum = Login.studentLogin(usernum, password);
                if (returnnum == 0)
                    JOptionPane.showMessageDialog(null, "用户名不存在");
                if (returnnum == 1)
                    JOptionPane.showMessageDialog(null, "密码错误请重新输入");
                if (returnnum == 2) {
                    JOptionPane.showMessageDialog(null, "登陆成功");
                    LoginFrame.usernum = usernum;
                    StudentMainFrame studenframe = new StudentMainFrame();
                    FrameChange.setCenter(studenframe.frame);
                    studenframe.frame.setVisible(true);
                    Loginframe.dispose();
                }
            }
        }
        if (storeRadioButton.isSelected()) {
            if (usernum.equals("") || password.equals(""))
                JOptionPane.showMessageDialog(null, "输入不能为空请重新输入！");
            else {
                //System.out.println(11);
                returnnum = Login.storeLogin(usernum, password);
                System.out.println(returnnum);
                if (usernum.equals("") || password.equals(""))
                    JOptionPane.showMessageDialog(null, "输入不能为空请重新输入！");
                if (returnnum == 0)
                    JOptionPane.showMessageDialog(null, "用户名不存在");
                if (returnnum == 1)
                    JOptionPane.showMessageDialog(null, "密码错误请重新输入");
                if (returnnum == 2) {
                    JOptionPane.showMessageDialog(null, "该用户未进行商店绑定");
                }
                if (returnnum == 3) {
                    int store_id = User_store.getStore_id(usernum);
                    LoginFrame.usernum = usernum;
                    LoginFrame.store_id = store_id;
                    BusinessMainFrame window = new BusinessMainFrame();
                    FrameChange.setCenter(window.businessframe);
                    window.businessframe.setVisible(true);
                    Loginframe.dispose();
                }
            }
        }
        if (teacherRadioButton.isSelected()) {
            if (usernum.equals("") || password.equals(""))
                JOptionPane.showMessageDialog(null, "输入不能为空请重新输入！");
            else {
                returnnum = Login.teacherLogin(usernum, password);
                if (returnnum == 0)
                    JOptionPane.showMessageDialog(null, "用户名不存在");
                if (returnnum == 1)
                    JOptionPane.showMessageDialog(null, "密码错误请重新输入");
                if (returnnum == 2) {
                    JOptionPane.showMessageDialog(null, "登陆成功");
                    TeacherFrame teacherframe = new TeacherFrame();
                    FrameChange.setCenter(teacherframe.teacherframe);
                    teacherframe.teacherframe.setVisible(true);
                    Loginframe.dispose();
                }
            }
        }
        if (managerRadioButton.isSelected()) {
            if (usernum.equals("") || password.equals(""))
                JOptionPane.showMessageDialog(null, "输入不能为空请重新输入！");
            else {
                returnnum = Login.managerLogin(usernum, password);
                if (returnnum == 0)
                    JOptionPane.showMessageDialog(null, "用户名不存在");
                if (returnnum == 1)
                    JOptionPane.showMessageDialog(null, "密码错误请重新输入");
                if (returnnum == 2) {
                    JOptionPane.showMessageDialog(null, "登陆成功");
                    ManageMainFrame manageframe = new ManageMainFrame();
                    FrameChange.setCenter(manageframe.frame);
                    manageframe.frame.setVisible(true);
                    Loginframe.dispose();

                }
            }
        }
    }

    /**
     * 选择教师角色登陆
     */
    private void btn_teacherSelectActionPerformed(ActionEvent e) {
        storeRadioButton.setSelected(false);
        managerRadioButton.setSelected(false);
        studentRadioButton.setSelected(false);

    }

    /**
     * 选择管理员角色登陆
     */
    private void btn_managerSelectActionPerformed(ActionEvent e) {
        storeRadioButton.setSelected(false);
        teacherRadioButton.setSelected(false);
        studentRadioButton.setSelected(false);

    }

    /**
     * 选择学生角色登陆
     */
    private void btn_studentSelectActionPerformed(ActionEvent e) {
        storeRadioButton.setSelected(false);
        teacherRadioButton.setSelected(false);
        managerRadioButton.setSelected(false);

    }

    /**
     * 选择商家角色登陆
     */
    private void btn_storeSelectActionPerformed(ActionEvent e) {
        studentRadioButton.setSelected(false);
        teacherRadioButton.setSelected(false);
        managerRadioButton.setSelected(false);
    }

    /**
     * 修改密码
     */
    private void btn_modifyPasswordActionPerformed(ActionEvent e) {
        if (studentRadioButton.isSelected()) {
            StudentModifyPasswordFrame window = new StudentModifyPasswordFrame();
            FrameChange.setCenter(window.frame);
            window.frame.setVisible(true);
        } else if (storeRadioButton.isSelected()) {
            StoreModifyPasswordFrame window = new StoreModifyPasswordFrame();
            FrameChange.setCenter(window.frame);
            window.frame.setVisible(true);
        } else if (managerRadioButton.isSelected()) {
            ManagerModifyPasswordFrame window = new ManagerModifyPasswordFrame();
            FrameChange.setCenter(window.frame);
            window.frame.setVisible(true);
        } else if (teacherRadioButton.isSelected()) {
            TeacherModifyPasswordFrame window = new TeacherModifyPasswordFrame();
            FrameChange.setCenter(window.frame);
            window.frame.setVisible(true);
        } else
            JOptionPane.showMessageDialog(null, "请选择身份进行改密");
    }
}

