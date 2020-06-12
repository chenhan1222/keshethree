package management_end;

import control_packet.TableRefresh;
import data.*;
import tabletools.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

//import data_packet.Student;
//import javax.security.auth.Refreshable;

public class ManageMainFrame {
    public JFrame frame;
    private JPanel store_bingdingpanel;
    private JPanel tuition_feepanel;
    private JPanel studentpanel;
    private JPanel teacherpanel;
    private JPanel staffpanel;
    /***************s*************/
    private JScrollPane scrollPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_8;
    private JComboBox<String> comboBox;
    private JTable s_table;
    /***************t*************/
    private JScrollPane scrollPane_1;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;
    private JLabel lblNewLabel_11;
    private JLabel lblNewLabel_12;
    private JLabel lblNewLabel_13;
    private JLabel lblNewLabel_14;
    private JButton btnNewButton_5;
    private JButton btnNewButton_6;
    private JButton btnNewButton_7;
    private JButton btnNewButton_8;
    private JButton btnNewButton_9;
    private JTextField textField_7;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JComboBox<String> comboBox_1;
    private JTable t_table;
    /***************staff*************/
    private JScrollPane scrollPane_2;
    private JLabel lblNewLabel_15;
    private JLabel lblNewLabel_16;
    private JLabel lblNewLabel_17;
    private JLabel lblNewLabel_18;
    private JLabel lblNewLabel_19;
    private JButton btnNewButton_10;
    private JButton btnNewButton_11;
    private JButton btnNewButton_12;
    private JButton btnNewButton_13;
    private JButton btnNewButton_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JTextField textField_17;
    private JTextField textField_18;
    private JTextField textField_19;
    private JTextField textField_20;
    private JTable staff_table;
    /**********store_binding***********/
    private JTable store_binding_table;
    private JTextField textField_21;
    private JScrollPane scrollPane_3;
    private JButton btnNewButton_15;
    private JButton btnNewButton_16;
    private JButton btnNewButton_18;
    private JButton btnNewButton_19;
    private JTextField textField_22;
    private JTextField textField_23;
    /*********Tuition_fee***************/
    private JTable tuition_fee_table;
    private JComboBox<String> comboBox_3;
    private JComboBox<String> comboBox_2;
    private JLabel lblNewLabel_20;
    private JLabel lblNewLabel_21;
    private JLabel lblNewLabel_22;
    private JLabel lblNewLabel_23;
    private JButton btnNewButton_20;
    private JButton btnNewButton_21;
    private JScrollPane scrollPane_4;
    private JButton btnNewButton_22;
    private JTextField textField_24;
    private JButton btnNewButton_23;

    /**
     * Create the application.
     */
    public ManageMainFrame() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManageMainFrame window = new ManageMainFrame();
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
        frame.setBounds(100, 100, 970, 626);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tuition_feepanel = new JPanel();//学费管理布局
        tuition_feepanel.setLayout(null);
        frame.setContentPane(tuition_feepanel);

        store_bingdingpanel = new JPanel();
        store_bingdingpanel.setLayout(null);

        studentpanel = new JPanel();//学生管理布局
        studentpanel.setLayout(null);


        staffpanel = new JPanel();//员工管理布局
        staffpanel.setLayout(null);
        staffpanel.setBounds(10, 45, 860, 626);

        teacherpanel = new JPanel();//教师管理布局
        teacherpanel.setLayout(null);
        teacherpanel.setBounds(0, 40, 917, 626);


        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("用户信息管理");
        mnNewMenu.setFont(new Font("宋体", Font.BOLD, 14));
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("学生信息管理");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentpanel.setBounds(0, 40, 860, 626);
                frame.setContentPane(studentpanel);
            }
        });
        mntmNewMenuItem.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("教师信息管理");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                teacherpanel.setBounds(0, 40, 860, 626);
                frame.setContentPane(teacherpanel);
            }
        });
        mntmNewMenuItem_1.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("工作人员信息管理");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                staffpanel.setBounds(0, 45, 860, 626);
                frame.setContentPane(staffpanel);
            }
        });
        mntmNewMenuItem_2.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_2);

        JMenu mnNewMenu_1 = new JMenu("学费信息管理");
        mnNewMenu_1.setFont(new Font("宋体", Font.BOLD, 14));
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("学费管理");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tuition_feepanel.setBounds(5, 32, 860, 626);
                frame.setContentPane(tuition_feepanel);
            }
        });
        mntmNewMenuItem_3.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu_1.add(mntmNewMenuItem_3);

        JMenu mnNewMenu_3 = new JMenu("商定绑定");
        mnNewMenu_3.setFont(new Font("宋体", Font.BOLD, 14));
        menuBar.add(mnNewMenu_3);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("商店绑定");
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                store_bingdingpanel.setBounds(0, 50, 860, 626);
                frame.setContentPane(store_bingdingpanel);
            }
        });
        mntmNewMenuItem_4.setFont(new Font("宋体", Font.BOLD, 14));
        mnNewMenu_3.add(mntmNewMenuItem_4);

        /*******************************************学生管理布局*************************************************/

        lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel.setBounds(23, 25, 36, 20);
        studentpanel.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 12));
        textField.setBounds(80, 25, 102, 20);
        studentpanel.add(textField);
        textField.setColumns(10);

        lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_1.setBounds(23, 65, 36, 20);
        studentpanel.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("宋体", Font.BOLD, 12));
        textField_1.setBounds(80, 65, 102, 20);
        studentpanel.add(textField_1);
        textField_1.setColumns(10);

        lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
        lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_2.setBounds(23, 105, 36, 20);
        studentpanel.add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("宋体", Font.BOLD, 12));
        textField_2.setBounds(80, 105, 102, 20);
        studentpanel.add(textField_2);
        textField_2.setColumns(10);

        lblNewLabel_3 = new JLabel("\u7CFB\u540D\uFF1A");
        lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_3.setBounds(23, 145, 54, 15);
        studentpanel.add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("宋体", Font.BOLD, 12));
        textField_3.setBounds(80, 145, 102, 20);
        studentpanel.add(textField_3);
        textField_3.setColumns(10);

        lblNewLabel_4 = new JLabel("\u73ED\u53F7\uFF1A");
        lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_4.setBounds(23, 185, 54, 15);
        studentpanel.add(lblNewLabel_4);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("宋体", Font.BOLD, 12));
        textField_4.setBounds(80, 185, 102, 20);
        studentpanel.add(textField_4);
        textField_4.setColumns(10);

        lblNewLabel_6 = new JLabel("\u516C\u5BD3\u53F7\uFF1A");
        lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_6.setBounds(23, 265, 48, 21);
        studentpanel.add(lblNewLabel_6);

        textField_5 = new JTextField();
        textField_5.setFont(new Font("宋体", Font.BOLD, 12));
        textField_5.setBounds(80, 225, 102, 20);
        studentpanel.add(textField_5);
        textField_5.setColumns(10);

        lblNewLabel_5 = new JLabel("\u5BBF\u820D\u53F7\uFF1A");
        lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_5.setBounds(23, 225, 48, 15);
        studentpanel.add(lblNewLabel_5);

        textField_6 = new JTextField();
        textField_6.setFont(new Font("宋体", Font.BOLD, 12));
        textField_6.setBounds(80, 265, 102, 20);
        studentpanel.add(textField_6);
        textField_6.setColumns(10);

        btnNewButton = new JButton("录入");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_AddStudentActionPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton.setBounds(67, 309, 93, 30);
        studentpanel.add(btnNewButton);

        lblNewLabel_7 = new JLabel("\u9009\u62E9\u641C\u7D22\u7C7B\u578B\uFF1A");
        lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_7.setBounds(321, 25, 102, 20);
        studentpanel.add(lblNewLabel_7);

        textField_7 = new JTextField();
        textField_7.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 12));
        textField_7.setText("\u8BF7\u8F93\u5165\u641C\u7D22\u5185\u5BB9");
        textField_7.setBounds(585, 20, 155, 25);
        studentpanel.add(textField_7);
        textField_7.setColumns(10);

        btnNewButton_1 = new JButton("搜索");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_searchStudentActionPerformed(e);
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_1.setBounds(750, 20, 93, 30);
        studentpanel.add(btnNewButton_1);

        btnNewButton_2 = new JButton("修改");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_modifyStudentActionPerformed(e);
            }
        });
        btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_2.setBounds(401, 514, 93, 30);
        studentpanel.add(btnNewButton_2);

        btnNewButton_3 = new JButton("删除");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_deleteStudentActionPerformed(e);
            }
        });
        btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_3.setBounds(538, 514, 93, 30);
        studentpanel.add(btnNewButton_3);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(219, 55, 624, 438);
        studentpanel.add(scrollPane);

        s_table = new JTable(new MyStudentTableModel());
        scrollPane.setViewportView(s_table);

        btnNewButton_4 = new JButton("\u5168\u90E8\u5B66\u751F");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_selectAllStudentActionPerformed(e);
            }
        });
        btnNewButton_4.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_4.setBounds(218, 20, 93, 30);
        studentpanel.add(btnNewButton_4);

        comboBox = new JComboBox<String>();
        comboBox.setFont(new Font("宋体", Font.BOLD, 12));
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[]{"\u6309\u5B66\u53F7\u641C\u7D22", "\u6309\u59D3\u540D\u641C\u7D22", "\u6309\u7CFB\u540D\u641C\u7D22", "\u6309\u73ED\u53F7\u641C\u7D22", "\u6309\u516C\u5BD3\u53F7\u641C\u7D22", "\u6574\u4F53\u6A21\u7CCA\u641C\u7D22"}));
        comboBox.setBounds(416, 20, 142, 25);
        studentpanel.add(comboBox);


        /*******************************************教师管理布局*************************************************/


        lblNewLabel_8 = new JLabel("\u5DE5\u53F7\uFF1A");
        lblNewLabel_8.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_8.setBounds(35, 29, 54, 15);
        teacherpanel.add(lblNewLabel_8);

        textField_8 = new JTextField();
        textField_8.setBounds(99, 26, 108, 21);
        teacherpanel.add(textField_8);
        textField_8.setColumns(10);

        lblNewLabel_9 = new JLabel("\u5BC6\u7801\uFF1A");
        lblNewLabel_9.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_9.setBounds(35, 78, 54, 15);
        teacherpanel.add(lblNewLabel_9);

        textField_9 = new JTextField();
        textField_9.setBounds(99, 75, 108, 21);
        teacherpanel.add(textField_9);
        textField_9.setColumns(10);

        lblNewLabel_10 = new JLabel("\u59D3\u540D\uFF1A");
        lblNewLabel_10.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_10.setBounds(35, 123, 54, 15);
        teacherpanel.add(lblNewLabel_10);

        textField_10 = new JTextField();
        textField_10.setBounds(99, 120, 108, 21);
        teacherpanel.add(textField_10);
        textField_10.setColumns(10);

        lblNewLabel_11 = new JLabel("\u7CFB\u540D\uFF1A");
        lblNewLabel_11.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_11.setBounds(35, 172, 54, 15);
        teacherpanel.add(lblNewLabel_11);

        textField_11 = new JTextField();
        textField_11.setBounds(99, 169, 108, 21);
        teacherpanel.add(textField_11);
        textField_11.setColumns(10);

        lblNewLabel_12 = new JLabel("\u624B\u673A\u53F7\uFF1A");
        lblNewLabel_12.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_12.setBounds(35, 218, 54, 15);
        teacherpanel.add(lblNewLabel_12);

        textField_12 = new JTextField();
        textField_12.setBounds(99, 215, 108, 21);
        teacherpanel.add(textField_12);
        textField_12.setColumns(10);

        lblNewLabel_13 = new JLabel("\u529E\u516C\u5BA4\uFF1A");
        lblNewLabel_13.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_13.setBounds(35, 268, 54, 15);
        teacherpanel.add(lblNewLabel_13);

        textField_13 = new JTextField();
        textField_13.setBounds(99, 265, 108, 21);
        teacherpanel.add(textField_13);
        textField_13.setColumns(10);

        btnNewButton_5 = new JButton("全部教师");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_selectAllTeacherActionPerformed(e);
            }
        });
        btnNewButton_5.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_5.setBounds(238, 21, 93, 30);
        teacherpanel.add(btnNewButton_5);

        lblNewLabel_14 = new JLabel("\u9009\u62E9\u641C\u7D22\u7C7B\u578B:");
        lblNewLabel_14.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_14.setBounds(349, 24, 93, 25);
        teacherpanel.add(lblNewLabel_14);

        comboBox_1 = new JComboBox<String>();
        comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[]{"\u6309\u5DE5\u53F7\u641C\u7D22", "\u6309\u59D3\u540D\u641C\u7D22", "\u6309\u7CFB\u540D\u641C\u7D22", "\u6309\u529E\u516C\u5BA4\u641C\u7D22", "\u6574\u4F53\u6A21\u7CCA\u641C\u7D22"}));
        comboBox_1.setFont(new Font("宋体", Font.BOLD, 12));
        comboBox_1.setBounds(442, 25, 150, 23);
        teacherpanel.add(comboBox_1);

        textField_14 = new JTextField();
        textField_14.setBounds(602, 25, 150, 23);
        teacherpanel.add(textField_14);
        textField_14.setColumns(10);

        btnNewButton_6 = new JButton("搜索");
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_searchTeacherActionPerformed(e);
            }
        });
        btnNewButton_6.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_6.setBounds(762, 21, 93, 30);
        teacherpanel.add(btnNewButton_6);

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(238, 71, 611, 404);
        teacherpanel.add(scrollPane_1);

        t_table = new JTable(new MyTeacherTableModel());
        scrollPane_1.setViewportView(t_table);

        btnNewButton_7 = new JButton("修改");
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    btn_modifyTeachertActionPerformed(e);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "未知错误！");
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_7.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_7.setBounds(440, 485, 93, 30);
        teacherpanel.add(btnNewButton_7);

        btnNewButton_8 = new JButton("删除");
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_deleteTeacherActionPerformed(e);
            }
        });
        btnNewButton_8.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_8.setBounds(610, 485, 93, 30);
        teacherpanel.add(btnNewButton_8);

        btnNewButton_9 = new JButton("录入");
        btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_AddTeacherActionPerformed(e);
            }
        });
        btnNewButton_9.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_9.setBounds(99, 307, 93, 30);
        teacherpanel.add(btnNewButton_9);


        /*******************************************员工管理布局*************************************************/

        lblNewLabel_15 = new JLabel("\u5DE5\u53F7\uFF1A");
        lblNewLabel_15.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_15.setBounds(21, 24, 54, 15);
        staffpanel.add(lblNewLabel_15);

        textField_15 = new JTextField();
        textField_15.setBounds(85, 21, 101, 21);
        staffpanel.add(textField_15);
        textField_15.setColumns(10);

        lblNewLabel_16 = new JLabel("\u5BC6\u7801\uFF1A");
        lblNewLabel_16.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_16.setBounds(21, 68, 54, 15);
        staffpanel.add(lblNewLabel_16);

        textField_16 = new JTextField();
        textField_16.setBounds(85, 65, 101, 21);
        staffpanel.add(textField_16);
        textField_16.setColumns(10);

        lblNewLabel_17 = new JLabel("\u59D3\u540D\uFF1A");
        lblNewLabel_17.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_17.setBounds(21, 108, 54, 15);
        staffpanel.add(lblNewLabel_17);

        textField_17 = new JTextField();
        textField_17.setBounds(85, 105, 101, 21);
        staffpanel.add(textField_17);
        textField_17.setColumns(10);

        lblNewLabel_18 = new JLabel("\u5DE5\u4F5C\u7C7B\u578B\uFF1A");
        lblNewLabel_18.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_18.setBounds(21, 150, 67, 15);
        staffpanel.add(lblNewLabel_18);

        textField_18 = new JTextField();
        textField_18.setBounds(85, 147, 101, 21);
        staffpanel.add(textField_18);
        textField_18.setColumns(10);

        lblNewLabel_19 = new JLabel("\u7535\u8BDD\u53F7\uFF1A");
        lblNewLabel_19.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_19.setBounds(21, 193, 54, 15);
        staffpanel.add(lblNewLabel_19);

        textField_19 = new JTextField();
        textField_19.setBounds(85, 190, 101, 21);
        staffpanel.add(textField_19);
        textField_19.setColumns(10);

        textField_20 = new JTextField();
        textField_20.setBounds(358, 21, 138, 21);
        staffpanel.add(textField_20);
        textField_20.setColumns(10);

        btnNewButton_10 = new JButton("录入");
        btnNewButton_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_AddStaffActionPerformed(e);
            }
        });
        btnNewButton_10.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_10.setBounds(60, 239, 93, 30);
        staffpanel.add(btnNewButton_10);

        btnNewButton_11 = new JButton("全部员工");
        btnNewButton_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_selectAllStaffActionPerformed(e);
            }
        });
        btnNewButton_11.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_11.setBounds(226, 16, 93, 30);
        staffpanel.add(btnNewButton_11);

        scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(226, 67, 596, 383);
        staffpanel.add(scrollPane_2);

        staff_table = new JTable(new MyStaffTableModel());
        scrollPane_2.setViewportView(staff_table);

        btnNewButton_12 = new JButton("搜索");
        btnNewButton_12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_searchStaffActionPerformed(e);
            }
        });
        btnNewButton_12.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_12.setBounds(538, 16, 93, 30);
        staffpanel.add(btnNewButton_12);

        btnNewButton_13 = new JButton("修改");
        btnNewButton_13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    btn_modifyStaffActionPerformed(e);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "修改失败！");
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_13.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_13.setBounds(358, 475, 93, 30);
        staffpanel.add(btnNewButton_13);

        btnNewButton_14 = new JButton("删除");
        btnNewButton_14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_deletestaffActionPerformed(e);
            }
        });
        btnNewButton_14.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_14.setBounds(510, 475, 93, 30);
        staffpanel.add(btnNewButton_14);

        btnNewButton_15 = new JButton("商店绑定");
        btnNewButton_15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_store_BingdingActionPerformed(e);
            }
        });
        btnNewButton_15.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_15.setBounds(651, 475, 93, 30);
        staffpanel.add(btnNewButton_15);


        /*******************************************商店绑定管理布局*************************************************/

        store_bingdingpanel.setBounds(100, 100, 860, 626);
        frame.setContentPane(store_bingdingpanel);

        scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(75, 72, 671, 413);
        store_bingdingpanel.add(scrollPane_3);

        store_binding_table = new JTable(new MyStore_bindingTableModel());
        scrollPane_3.setViewportView(store_binding_table);

        btnNewButton_16 = new JButton("全部绑定");
        btnNewButton_16.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_gettAllStore_bindingActionPerformed(e);
            }
        });
        btnNewButton_16.setBounds(75, 23, 93, 30);
        store_bingdingpanel.add(btnNewButton_16);

        JButton btnNewButton_17 = new JButton("搜索");
        btnNewButton_17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_selectStore_bindingActionPerformed(e);
            }
        });
        btnNewButton_17.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_17.setBounds(388, 23, 93, 30);
        store_bingdingpanel.add(btnNewButton_17);

        textField_21 = new JTextField();
        textField_21.setFont(new Font("宋体", Font.BOLD, 12));
        textField_21.setBounds(203, 23, 130, 21);
        store_bingdingpanel.add(textField_21);
        textField_21.setColumns(10);

        btnNewButton_18 = new JButton("解除绑定");
        btnNewButton_18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_deleteStore_bindingActionPerformed(e);
            }
        });
        btnNewButton_18.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_18.setBounds(504, 513, 93, 30);
        store_bingdingpanel.add(btnNewButton_18);

        btnNewButton_19 = new JButton("修改绑定");
        btnNewButton_19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_modifyStore_bindingActionPerformed(e);
            }
        });
        btnNewButton_19.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_19.setBounds(273, 513, 93, 30);
        store_bingdingpanel.add(btnNewButton_19);


        /*******************************************学费信息管理布局*************************************************/
        lblNewLabel_20 = new JLabel("年：");
        lblNewLabel_20.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_20.setBounds(31, 33, 34, 15);
        tuition_feepanel.add(lblNewLabel_20);

        comboBox_2 = new JComboBox<String>();
        comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[]{"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
        comboBox_2.setFont(new Font("宋体", Font.BOLD, 12));
        comboBox_2.setBounds(75, 29, 117, 23);
        tuition_feepanel.add(comboBox_2);

        lblNewLabel_21 = new JLabel("学期：");
        lblNewLabel_21.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_21.setBounds(219, 33, 44, 15);
        tuition_feepanel.add(lblNewLabel_21);

        comboBox_3 = new JComboBox<String>();
        comboBox_3.setModel(new DefaultComboBoxModel<String>(new String[]{"春季学期", "秋季学期"}));
        comboBox_3.setBounds(273, 29, 117, 23);
        tuition_feepanel.add(comboBox_3);

        lblNewLabel_22 = new JLabel("学号：");
        lblNewLabel_22.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_22.setBounds(408, 33, 42, 15);
        tuition_feepanel.add(lblNewLabel_22);

        textField_22 = new JTextField();
        textField_22.setFont(new Font("宋体", Font.BOLD, 12));
        textField_22.setBounds(449, 30, 117, 21);
        tuition_feepanel.add(textField_22);
        textField_22.setColumns(10);

        lblNewLabel_23 = new JLabel("金额：");
        lblNewLabel_23.setFont(new Font("宋体", Font.BOLD, 12));
        lblNewLabel_23.setBounds(576, 33, 54, 15);
        tuition_feepanel.add(lblNewLabel_23);

        textField_23 = new JTextField();
        textField_23.setFont(new Font("宋体", Font.BOLD, 12));
        textField_23.setBounds(622, 30, 117, 21);
        tuition_feepanel.add(textField_23);
        textField_23.setColumns(10);

        btnNewButton_21 = new JButton("录入");
        btnNewButton_21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_AddTuition_feeActionPerformed(e);
            }
        });
        btnNewButton_21.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_21.setBounds(761, 25, 85, 30);
        tuition_feepanel.add(btnNewButton_21);

        scrollPane_4 = new JScrollPane();
        scrollPane_4.setBounds(31, 114, 814, 376);
        tuition_feepanel.add(scrollPane_4);

        tuition_fee_table = new JTable(new MyTuition_feeTableModel());
        scrollPane_4.setViewportView(tuition_fee_table);

        btnNewButton_20 = new JButton("删除");
        btnNewButton_20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_deleteTuition_feeActionPerformed(e);
            }
        });
        btnNewButton_20.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_20.setBounds(365, 506, 93, 30);
        tuition_feepanel.add(btnNewButton_20);

        btnNewButton_22 = new JButton("全部信息");
        btnNewButton_22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_getAllTuition_feeActionPerformed(e);
            }
        });
        btnNewButton_22.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_22.setBounds(31, 67, 93, 30);
        tuition_feepanel.add(btnNewButton_22);

        textField_24 = new JTextField();
        textField_24.setBounds(147, 72, 126, 21);
        tuition_feepanel.add(textField_24);
        textField_24.setColumns(10);

        btnNewButton_23 = new JButton("搜索");
        btnNewButton_23.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_selectTuition_feeActionPerformed(e);
            }
        });
        btnNewButton_23.setFont(new Font("宋体", Font.BOLD, 12));
        btnNewButton_23.setBounds(297, 67, 93, 30);
        tuition_feepanel.add(btnNewButton_23);
    }
    /*************************************学生信息管理消息响应函数*******************************************************/
    /**
     * 获得全部学生信息按钮的消息响应函数
     */
    private void btn_selectAllStudentActionPerformed(ActionEvent e) {
        List<Student> studentlist = Student.getStudent();
        TableRefresh.refreshStudentTable(studentlist, s_table);
    }

    /**
     * 录入学生信息的消息响应函数
     */
    private void btn_AddStudentActionPerformed(ActionEvent e) {
        String s_usernum = textField.getText();//账号（学号）
        String s_password = textField_1.getText();//密码
        String s_name = textField_2.getText();//学生名字
        String s_department_name = textField_3.getText();//系名
        String s_class_num = textField_4.getText();//班号
        String s_apartment_num = textField_6.getText();//公寓号
        String s_dormitory_num = textField_5.getText();//宿舍号
        if (s_usernum.equals("") || s_password.equals("") || s_name.equals("") || s_department_name.equals("") || s_class_num.equals(""))
            JOptionPane.showMessageDialog(null, "学号，密码，姓名，系名，班号不能为空！");
        else {
            try {
                if (Student.ifStudentexist(s_usernum))
                    JOptionPane.showMessageDialog(null, "该学生信息已存在！");
                else {
                    Student.addStudent(s_usernum, s_password, s_apartment_num, s_dormitory_num, s_department_name, s_class_num, s_name);
                    JOptionPane.showMessageDialog(null, "成功录入学生信息！");
                    List<Student> studentlist = Student.getStudent();
                    TableRefresh.refreshStudentTable(studentlist, s_table);
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "发生未知错误");
                e1.printStackTrace();
            }
        }

    }

    /**
     * 按选项搜索学生信息
     */
    private void btn_searchStudentActionPerformed(ActionEvent e) {
        String selectstr = textField_7.getText();//输入的内容
        String comboxstr = comboBox.getSelectedItem().toString();//选择的搜索类型
        if (comboxstr.equals("按学号搜索")) {
            List<Student> studentlist = Student.selectStudentByS_usernum(selectstr);
            TableRefresh.refreshStudentTable(studentlist, s_table);
        } else if (comboxstr.equals("按姓名搜索")) {
            List<Student> studentlist = Student.selectStudentByS_name(selectstr);
            TableRefresh.refreshStudentTable(studentlist, s_table);
        } else if (comboxstr.equals("按系名搜索")) {
            List<Student> studentlist = Student.selectStudentByS_department_name(selectstr);
            TableRefresh.refreshStudentTable(studentlist, s_table);
        } else if (comboxstr.equals("按公寓号搜索")) {
            List<Student> studentlist = Student.selectStudentByS_apartment_num(selectstr);
            TableRefresh.refreshStudentTable(studentlist, s_table);
        } else if (comboxstr.equals("按班级搜索")) {
            List<Student> studentlist = Student.selectStudentByS_class_num(selectstr);
            TableRefresh.refreshStudentTable(studentlist, s_table);
        } else if (comboxstr.equals("整体模糊搜索")) {
            List<Student> studentlist = Student.selectStudent(selectstr);
            TableRefresh.refreshStudentTable(studentlist, s_table);
        }
    }

    /**
     * 删除选中学生的信息
     */
    private void btn_deleteStudentActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) s_table.getModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        int idcolumn = dtm.findColumn("学号");
        for (int i = 0; i < s_table.getRowCount(); i++) {
            String getvalue = s_table.getValueAt(i, ifselectcolumn).toString();
            String s_usernum = s_table.getValueAt(i, idcolumn).toString();
            if (getvalue == "true") {
                Student.deleteStudent(s_usernum);
                JOptionPane.showMessageDialog(null, "学生信息已删除！");
                List<Student> studentlist = Student.getStudent();
                TableRefresh.refreshStudentTable(studentlist, s_table);
            }
        }
    }

    /**
     * 修改选中学生的信息
     */
    private void btn_modifyStudentActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) s_table.getModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        int s_usernumcolumn = dtm.findColumn("学号");
        int s_passwordcolumn = dtm.findColumn("密码");
        int s_namecolumn = dtm.findColumn("姓名");
        int s_dormitory_numcolumn = dtm.findColumn("宿舍号");
        int s_apartment_numcolumn = dtm.findColumn("公寓");
        int s_department_namecolumn = dtm.findColumn("系名");
        int s_class_numcolumn = dtm.findColumn("班号");
        int s_phonenumcolumn = dtm.findColumn("手机号");
        int s_nicknamecolumn = dtm.findColumn("昵称");

        for (int i = 0; i < s_table.getRowCount(); i++) {
            String getvalue = s_table.getValueAt(i, ifselectcolumn).toString(); //判断是否选中    
            if (getvalue == "true") {
                Student newstudent = new Student();
                newstudent.s_usernum = s_table.getValueAt(i, s_usernumcolumn).toString();
                newstudent.s_password = s_table.getValueAt(i, s_passwordcolumn).toString();
                newstudent.s_apartment_num = s_table.getValueAt(i, s_apartment_numcolumn).toString();
                newstudent.s_dormitory_num = s_table.getValueAt(i, s_dormitory_numcolumn).toString();
                newstudent.s_department_name = s_table.getValueAt(i, s_department_namecolumn).toString();
                newstudent.s_class_num = s_table.getValueAt(i, s_class_numcolumn).toString();
                newstudent.s_phonenum = s_table.getValueAt(i, s_phonenumcolumn).toString();
                newstudent.s_nickname = s_table.getValueAt(i, s_nicknamecolumn).toString();
                newstudent.s_name = s_table.getValueAt(i, s_namecolumn).toString();
                Student.modifyStudent(newstudent);
                JOptionPane.showMessageDialog(null, "已全部修改");
                List<Student> studentlist = Student.getStudent();
                TableRefresh.refreshStudentTable(studentlist, s_table);
            }
        }
    }

    /*************************************教师信息管理消息响应函数*******************************************************/
    /**
     * 获得全部教师信息按钮的消息响应函数
     */
    private void btn_selectAllTeacherActionPerformed(ActionEvent e) {
        List<Teacher> teacherlist = Teacher.getTeacher();
        TableRefresh.refreshTeacherTable(teacherlist, t_table);
    }

    /**
     * 录入教师信息的消息响应函数
     */
    private void btn_AddTeacherActionPerformed(ActionEvent e) {
        String t_usernum = textField_8.getText();//账号（工号）
        String t_password = textField_9.getText();//密码
        String t_name = textField_10.getText();//姓名
        String t_department_name = textField_11.getText();//系名
        String t_phonenum = textField_12.getText();//手机号
        String t_office = textField_13.getText();//办公室地点
        if (t_usernum.equals("") || t_password.equals("") || t_name.equals("") || t_department_name.equals(""))
            JOptionPane.showMessageDialog(null, "工号，密码，姓名，系名不能为空！");
        else {
            try {
                if (Teacher.ifTeacherexist(t_usernum))
                    JOptionPane.showMessageDialog(null, "该教师信息已存在！");
                else {
                    Teacher.addTeacher(t_usernum, t_password, t_name, t_department_name, t_phonenum, t_office);
                    JOptionPane.showMessageDialog(null, "成功录入教师信息！");
                    List<Teacher> teacherlist = Teacher.getTeacher();
                    TableRefresh.refreshTeacherTable(teacherlist, t_table);
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "发生未知错误");
                e1.printStackTrace();
            }
        }

    }

    /**
     * 按选项搜索教师信息
     */
    private void btn_searchTeacherActionPerformed(ActionEvent e) {
        String selectstr = textField_14.getText();//输入的内容
        String comboxstr = comboBox_1.getSelectedItem().toString();//选择的搜索类型
        if (comboxstr.equals("按工号搜索")) {
            List<Teacher> teacherlist = Teacher.selectTeacherByT_usernum(selectstr);
            TableRefresh.refreshTeacherTable(teacherlist, t_table);
        } else if (comboxstr.equals("按姓名搜索")) {
            List<Teacher> teacherlist = Teacher.selectTeacherByt_name(selectstr);
            TableRefresh.refreshTeacherTable(teacherlist, t_table);
        } else if (comboxstr.equals("按系名搜索")) {
            List<Teacher> teacherlist = Teacher.selectTeacherByT_department_name(selectstr);
            TableRefresh.refreshTeacherTable(teacherlist, t_table);
        } else if (comboxstr.equals("按办公室搜索")) {
            List<Teacher> teacherlist = Teacher.selectTeacherByt_office(selectstr);
            TableRefresh.refreshTeacherTable(teacherlist, t_table);
        } else if (comboxstr.equals("整体模糊搜索")) {
            List<Teacher> teacherlist = Teacher.selectTeacher(selectstr);
            TableRefresh.refreshTeacherTable(teacherlist, t_table);
        }
    }

    /**
     * 删除选中教师的信息
     */
    private void btn_deleteTeacherActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) t_table.getModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        int idcolumn = dtm.findColumn("工号");
        for (int i = 0; i < t_table.getRowCount(); i++) {
            String getvalue = t_table.getValueAt(i, ifselectcolumn).toString();
            String t_usernum = t_table.getValueAt(i, idcolumn).toString();
            if (getvalue == "true") {
                Teacher.deleteTeacher(t_usernum);
                JOptionPane.showMessageDialog(null, "教师信息已删除！");
                List<Teacher> teacherlist = Teacher.getTeacher();
                TableRefresh.refreshTeacherTable(teacherlist, t_table);
            }
        }
    }

    /**
     * 修改选中学生的信息
     */
    private void btn_modifyTeachertActionPerformed(ActionEvent e) throws IOException {
        DefaultTableModel dtm = (DefaultTableModel) t_table.getModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        int t_usernumcolumn = dtm.findColumn("工号");
        int t_passwordcolumn = dtm.findColumn("密码");
        int t_namecolumn = dtm.findColumn("姓名");
        int t_department_namecolumn = dtm.findColumn("系名");
        int t_phonenumcolumn = dtm.findColumn("手机号");
        int t_office = dtm.findColumn("办公室");
        for (int i = 0; i < t_table.getRowCount(); i++) {
            String getvalue = t_table.getValueAt(i, ifselectcolumn).toString(); //判断是否选中    
            if (getvalue == "true") {
                Teacher newteacher = new Teacher();
                newteacher.t_usernum = t_table.getValueAt(i, t_usernumcolumn).toString();
                newteacher.t_password = t_table.getValueAt(i, t_passwordcolumn).toString();
                newteacher.t_department_name = t_table.getValueAt(i, t_department_namecolumn).toString();
                newteacher.t_phonenum = t_table.getValueAt(i, t_phonenumcolumn).toString();
                newteacher.t_office = t_table.getValueAt(i, t_office).toString();
                newteacher.t_name = t_table.getValueAt(i, t_namecolumn).toString();
                Teacher.m_modifyTeacher(newteacher);
                JOptionPane.showMessageDialog(null, "已全部修改");
                List<Teacher> teacherlist = Teacher.getTeacher();
                TableRefresh.refreshTeacherTable(teacherlist, t_table);
            }
        }
    }
    /*************************************工作人员信息管理消息响应函数*******************************************************/
    /**
     * 获得全部工作人员信息按钮的消息响应函数
     */
    private void btn_selectAllStaffActionPerformed(ActionEvent e) {
        List<Staff> stafflist = Staff.getStaff();
        TableRefresh.refreshStaffTable(stafflist, staff_table);
    }

    /**
     * 录入工作人员信息的消息响应函数
     */
    private void btn_AddStaffActionPerformed(ActionEvent e) {
        String staff_usernum = textField_15.getText();//账号（工号）
        String staff_password = textField_16.getText();//密码
        String staff_name = textField_17.getText();//姓名
        String staff_worktype = textField_18.getText();//工作类型
        String staff_phonenum = textField_19.getText();//手机号
        if (staff_usernum.equals("") || staff_password.equals("") || staff_name.equals("") || staff_worktype.equals(""))
            JOptionPane.showMessageDialog(null, "工号，密码，姓名，工作类型不能为空！");
        else {
            try {
                if (Staff.ifStaffexist(staff_usernum))
                    JOptionPane.showMessageDialog(null, "该工作人员信息已存在！");
                else {
                    Staff.addStaff(staff_usernum, staff_password, staff_name, staff_worktype, staff_phonenum);
                    JOptionPane.showMessageDialog(null, "成功录入工作人员信息！");
                    List<Staff> stafflist = Staff.getStaff();
                    TableRefresh.refreshStaffTable(stafflist, staff_table);
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "发生未知错误");
                e1.printStackTrace();
            }
        }

    }

    /**
     * 删除选中工作人员的信息
     */
    private void btn_deletestaffActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) staff_table.getModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        int idcolumn = dtm.findColumn("工号");
        for (int i = 0; i < staff_table.getRowCount(); i++) {
            String getvalue = staff_table.getValueAt(i, ifselectcolumn).toString();
            String staff_usernum = staff_table.getValueAt(i, idcolumn).toString();
            if (getvalue == "true") {
                Staff.deleteStaff(staff_usernum);
                JOptionPane.showMessageDialog(null, "工作人员信息已删除！");
                List<Staff> stafflist = Staff.getStaff();
                TableRefresh.refreshStaffTable(stafflist, staff_table);
            }
        }
    }

    /**
     * 搜索工作人员信息
     */
    private void btn_searchStaffActionPerformed(ActionEvent e) {
        String selectstr = textField_20.getText();//输入的内容
        List<Staff> stafflist = Staff.selectStafft(selectstr);
        TableRefresh.refreshStaffTable(stafflist, staff_table);
    }

    /**
     * 修改选中工作人员的信息
     */
    private void btn_modifyStaffActionPerformed(ActionEvent e) throws IOException {
        DefaultTableModel dtm = (DefaultTableModel) staff_table.getModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        int staff_usernumcolumn = dtm.findColumn("工号");
        int staff_passwordcolumn = dtm.findColumn("密码");
        int staff_namecolumn = dtm.findColumn("姓名");
        int staff_worktypecolumn = dtm.findColumn("工作类型");
        int staff_phonenumcolumn = dtm.findColumn("手机号");
        for (int i = 0; i < staff_table.getRowCount(); i++) {
            String getvalue = staff_table.getValueAt(i, ifselectcolumn).toString(); //判断是否选中    
            if (getvalue == "true") {
                Staff newstaff = new Staff();
                newstaff.staff_usernum = staff_table.getValueAt(i, staff_usernumcolumn).toString();
                newstaff.staff_password = staff_table.getValueAt(i, staff_passwordcolumn).toString();
                newstaff.staff_worktype = staff_table.getValueAt(i, staff_worktypecolumn).toString();
                newstaff.staff_phonenum = staff_table.getValueAt(i, staff_phonenumcolumn).toString();
                newstaff.staff_name = staff_table.getValueAt(i, staff_namecolumn).toString();
                Staff.modifyStaff(newstaff);
                JOptionPane.showMessageDialog(null, "已全部修改");
                List<Staff> stafflist = Staff.getStaff();
                TableRefresh.refreshStaffTable(stafflist, staff_table);
            }
        }
    }

    /**
     * 商店绑定
     */
    private void btn_store_BingdingActionPerformed(ActionEvent e) {
        int num = 0;//用来判断选中的账号数，账号数为一个时才能绑定
        DefaultTableModel dtm = (DefaultTableModel) staff_table.getModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        int idcolumn = dtm.findColumn("工号");
        String getvalue;
        String staff_usernum;
        for (int i = 0; i < staff_table.getRowCount(); i++) {
            getvalue = staff_table.getValueAt(i, ifselectcolumn).toString();
            if (getvalue == "true") {
                num++;
            }
        }
        if (num == 1) {
            for (int j = 0; j < staff_table.getRowCount(); j++) {
                getvalue = staff_table.getValueAt(j, ifselectcolumn).toString();
                staff_usernum = staff_table.getValueAt(j, idcolumn).toString();
                if (getvalue == "true") {
                    if (!Staff.ifstore_bindingexist(staff_usernum)) {//如果该账号没有进行过绑定
                        Store_bindingFrame window = new Store_bindingFrame(staff_usernum);
                        window.frame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "该账号已经绑定过商店");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "选中的账号过多，一次只能绑定一个账号");
        }
    }
    /*************************************商店绑定管理消息响应函数*******************************************************/
    /**
     * 获得全部商店绑定信息按钮的消息响应函数
     */
    private void btn_gettAllStore_bindingActionPerformed(ActionEvent e) {
        List<Store_binding> store_bindinglist = Store_binding.getAllStore_binding();
        TableRefresh.refreshStore_bindingTable(store_bindinglist, store_binding_table);
    }

    /**
     * 搜索商店绑定信息按钮的消息响应函数
     */
    private void btn_selectStore_bindingActionPerformed(ActionEvent e) {
        String str = textField_21.getText();
        List<Store_binding> store_bindinglist = Store_binding.selectStore_binding(str);
        TableRefresh.refreshStore_bindingTable(store_bindinglist, store_binding_table);
    }

    /**
     * 修改绑定的消息响应函数
     */
    private void btn_modifyStore_bindingActionPerformed(ActionEvent e) {
        int num = 0;//用来判断选中的账号数，账号数为一个时才能绑定
        DefaultTableModel dtm = (DefaultTableModel) store_binding_table.getModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        int idcolumn = dtm.findColumn("工号");
        int store_idcolumn = dtm.findColumn("商店号");
        String getvalue;
        String usernum;
        int store_id;
        for (int i = 0; i < store_binding_table.getRowCount(); i++) {
            getvalue = store_binding_table.getValueAt(i, ifselectcolumn).toString();
            if (getvalue == "true") {
                num++;
            }
        }
        if (num == 1) {
            for (int j = 0; j < store_binding_table.getRowCount(); j++) {
                getvalue = store_binding_table.getValueAt(j, ifselectcolumn).toString();
                usernum = store_binding_table.getValueAt(j, idcolumn).toString();
                store_id = Integer.valueOf(store_binding_table.getValueAt(j, store_idcolumn).toString());
                if (getvalue == "true") {
                    Store_binding.modifyStore_binding(store_id, usernum);
                    JOptionPane.showMessageDialog(null, "绑定已修改");
                    List<Store_binding> store_bindinglist = Store_binding.getAllStore_binding();
                    TableRefresh.refreshStore_bindingTable(store_bindinglist, store_binding_table);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "选中的账号过多，一次只能选择一个账号");
        }
    }

    /**
     * 解除绑定的消息响应函数
     */
    private void btn_deleteStore_bindingActionPerformed(ActionEvent e) {
        int num = 0;//用来判断选中的账号数，账号数为一个时才能绑定
        DefaultTableModel dtm = (DefaultTableModel) store_binding_table.getModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        int store_idcolumn = dtm.findColumn("商店号");
        String getvalue;
        int store_id;
        for (int i = 0; i < store_binding_table.getRowCount(); i++) {
            getvalue = store_binding_table.getValueAt(i, ifselectcolumn).toString();
            if (getvalue == "true") {
                num++;
            }
        }
        if (num == 1) {
            for (int j = 0; j < store_binding_table.getRowCount(); j++) {
                getvalue = store_binding_table.getValueAt(j, ifselectcolumn).toString();
                store_id = Integer.valueOf(store_binding_table.getValueAt(j, store_idcolumn).toString());
                if (getvalue == "true") {
                    Store_binding.deleteStore_binding(store_id);
                    JOptionPane.showMessageDialog(null, "绑定已解除");
                    List<Store_binding> store_bindinglist = Store_binding.getAllStore_binding();
                    TableRefresh.refreshStore_bindingTable(store_bindinglist, store_binding_table);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "选中的账号过多，一次选择个账号");
        }
    }
    /*************************************学费管理消息响应函数*******************************************************/
    /**
     * 录入学费信息的消息响应函数
     */
    private void btn_AddTuition_feeActionPerformed(ActionEvent e) {
        String year = comboBox_2.getSelectedItem().toString();
        String term = comboBox_3.getSelectedItem().toString();
        String s_usernum = textField_22.getText();
        if (year.equals("") || term.equals("") || s_usernum.equals("") || textField_23.getText().equals(""))
            JOptionPane.showMessageDialog(null, "输入不能为空！");
        else {
            try {
                double cost = Double.valueOf(textField_23.getText().toString());
                if (Tuition_fee.ifTuition_feeexist(year, term, s_usernum))
                    JOptionPane.showMessageDialog(null, "该学生此学期信息已录入，请勿重复录入");
                else {
                    Tuition_fee.addTuition_fee(year, term, s_usernum, cost);
                    JOptionPane.showMessageDialog(null, "成功录入学费信息！");
                    List<Tuition_fee> tuition_feelist = Tuition_fee.getTuition_fee();
                    TableRefresh.refreshTuition_feeTable(tuition_feelist, tuition_fee_table);
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "输入的格式错误！请重新输入");
            }
        }

    }

    /**
     * 获取全部学生学费信息
     */
    private void btn_getAllTuition_feeActionPerformed(ActionEvent e) {
        List<Tuition_fee> tuition_feelist = Tuition_fee.getTuition_fee();
        TableRefresh.refreshTuition_feeTable(tuition_feelist, tuition_fee_table);
    }

    /**
     * 搜索某学费信息
     */
    private void btn_selectTuition_feeActionPerformed(ActionEvent e) {
        String str = textField_24.getText();
        List<Tuition_fee> tuition_feelist = Tuition_fee.selectTuition_fee(str);
        TableRefresh.refreshTuition_feeTable(tuition_feelist, tuition_fee_table);
    }

    /**
     * 删除某学费信息
     */
    private void btn_deleteTuition_feeActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) tuition_fee_table.getModel();
        int ifselectcolumn = dtm.findColumn("是否选中");
        int yearcolumn = dtm.findColumn("年");
        int termcolumn = dtm.findColumn("学期");
        int s_usernumcolumn = dtm.findColumn("学号");
        for (int i = 0; i < tuition_fee_table.getRowCount(); i++) {
            String getvalue = tuition_fee_table.getValueAt(i, ifselectcolumn).toString();
            String s_usernum = tuition_fee_table.getValueAt(i, s_usernumcolumn).toString();
            String year = tuition_fee_table.getValueAt(i, yearcolumn).toString();
            String term = tuition_fee_table.getValueAt(i, termcolumn).toString();
            if (getvalue == "true") {
                Tuition_fee.deleteTuition_fee(year, term, s_usernum);
                JOptionPane.showMessageDialog(null, "已删除");
                List<Tuition_fee> tuition_feelist = Tuition_fee.getTuition_fee();
                TableRefresh.refreshTuition_feeTable(tuition_feelist, tuition_fee_table);
            }
        }
    }
}
