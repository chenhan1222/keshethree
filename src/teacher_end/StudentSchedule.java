package teacher_end;

import com.eltima.components.ui.DatePicker;
import control_packet.FrameChange;
import control_packet.TableRefresh;
import data.Bespoke;
import data.Teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StudentSchedule {
    public JFrame studentschedule;
    public static JTable table_001;
    private JTextField textField001;
    private JLabel lblNewLabel001;
    private JScrollPane scrollPane;
    public DefaultTableModel dtm;
    private DefaultTableCellRenderer r;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel lblNewLabel001_1_3;
    private JTextField textField_2;
    private JLabel lblNewLabel001_1_4;
    private JTextField textField_3;
    private JLabel lblNewLabel001_1_5;
    private JTextField textField_4;
    private DatePicker datepick;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentSchedule window = new StudentSchedule();
                    window.studentschedule.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public StudentSchedule() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */


    /*******************************************学生端答疑预约子模块界面布局*************************************************/

    private void initialize() {
        studentschedule = new JFrame();
        studentschedule.setTitle("答疑预约界面");
        studentschedule.setBounds(100, 100, 970, 760);
        studentschedule.getContentPane().setLayout(null);

        table_001 = new JTable();
        table_001.setFont(new Font("宋体", Font.BOLD, 12));
        r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table_001.setDefaultRenderer(Object.class, r);
        table_001.setRowHeight(100);
        dtm = (DefaultTableModel) table_001.getModel();
        scrollPane = new JScrollPane(table_001);
        scrollPane.setSize(604, 517);
        scrollPane.setLocation(10, 77);
        studentschedule.getContentPane().add(scrollPane);

        lblNewLabel001 = new JLabel("输入教师名：");//输入教师名：
        lblNewLabel001.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel001.setBounds(192, 22, 97, 19);
        studentschedule.getContentPane().add(lblNewLabel001);

        textField001 = new JTextField();
        textField001.setFont(new Font("宋体", Font.BOLD, 14));
        textField001.setBounds(332, 21, 138, 21);
        studentschedule.getContentPane().add(textField001);
        textField001.setColumns(10);

        btnNewButton_1 = new JButton("搜索");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_searchTeacherActionPerformed(e);
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton_1.setBounds(537, 20, 111, 25);
        studentschedule.getContentPane().add(btnNewButton_1);


        btnNewButton_2 = new JButton("\u67E5\u770B\u5DF2\u53D1\u5E03\u65E5\u7A0B");//查看已发布日程
        btnNewButton_2.addActionListener(new ActionListener() {//获取全部老师信息
            public void actionPerformed(ActionEvent e) {
                btn_checkTeacherActionPerformed(e);
            }
        });
        btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton_2.setBounds(10, 7, 145, 25);
        studentschedule.getContentPane().add(btnNewButton_2);

        btnNewButton_3 = new JButton("预约");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             //结算按钮
                btn_toBedoneActionPerformed(e);
            }
        });
        btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton_3.setBounds(153, 631, 136, 27);
        studentschedule.getContentPane().add(btnNewButton_3);

        btnNewButton_4 = new JButton("提交日程外申请");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_publishRequestActionPerformed(e);
            }
        });
        btnNewButton_4.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton_4.setBounds(697, 374, 136, 27);
        studentschedule.getContentPane().add(btnNewButton_4);

        JLabel lblNewLabel001_1 = new JLabel("\u9884\u7EA6\u6559\u5E08\u5DE5\u53F7\uFF1A");//预约教师工号：
        lblNewLabel001_1.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel001_1.setBounds(624, 77, 117, 19);
        studentschedule.getContentPane().add(lblNewLabel001_1);

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 14));
        textField.setColumns(10);
        textField.setBounds(751, 76, 138, 21);
        studentschedule.getContentPane().add(textField);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("宋体", Font.BOLD, 14));
        textField_1.setColumns(10);
        textField_1.setBounds(751, 116, 138, 21);
        studentschedule.getContentPane().add(textField_1);

        JLabel lblNewLabel001_1_1 = new JLabel("\u9884\u7EA6\u6559\u5E08\u59D3\u540D\uFF1A");//预约教师姓名：
        lblNewLabel001_1_1.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel001_1_1.setBounds(624, 120, 117, 19);
        studentschedule.getContentPane().add(lblNewLabel001_1_1);

        JLabel lblNewLabel001_1_2 = new JLabel("\u9884\u7EA6\u7B54\u7591\u65F6\u95F4\uFF1A");//预约答疑时间：
        lblNewLabel001_1_2.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel001_1_2.setBounds(624, 163, 117, 19);
        studentschedule.getContentPane().add(lblNewLabel001_1_2);

        lblNewLabel001_1_3 = new JLabel("\u9884\u7EA6\u7B54\u7591\u5730\u70B9\uFF1A");//预约答疑地点：
        lblNewLabel001_1_3.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel001_1_3.setBounds(624, 202, 117, 19);
        studentschedule.getContentPane().add(lblNewLabel001_1_3);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("宋体", Font.BOLD, 14));
        textField_2.setColumns(10);
        textField_2.setBounds(751, 202, 138, 21);
        studentschedule.getContentPane().add(textField_2);

        lblNewLabel001_1_4 = new JLabel("\u8F93\u5165\u9884\u7EA6\u539F\u56E0\uFF1A");//输入预约原因：
        lblNewLabel001_1_4.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel001_1_4.setBounds(624, 240, 117, 19);
        studentschedule.getContentPane().add(lblNewLabel001_1_4);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("宋体", Font.BOLD, 14));
        textField_3.setColumns(10);
        textField_3.setBounds(751, 240, 138, 21);
        studentschedule.getContentPane().add(textField_3);

        lblNewLabel001_1_5 = new JLabel("\u8F93\u5165\u4F60\u7684\u59D3\u540D\uFF1A");//输入你的姓名：
        lblNewLabel001_1_5.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel001_1_5.setBounds(624, 282, 117, 19);
        studentschedule.getContentPane().add(lblNewLabel001_1_5);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("宋体", Font.BOLD, 14));
        textField_4.setColumns(10);
        textField_4.setBounds(751, 282, 138, 21);
        studentschedule.getContentPane().add(textField_4);

        datepick = getDatePicker();
        studentschedule.getContentPane().add(datepick);

        JButton btnNewButton_4_1 = new JButton("查看我的申请");//查看我的申请
        btnNewButton_4_1.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton_4_1.setBounds(398, 631, 136, 27);
        studentschedule.getContentPane().add(btnNewButton_4_1);
        btnNewButton_4_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_chectMyBespokeActionPerformed(e);
            }
        });

        JButton btnNewButton_2_1 = new JButton("查看教师信息");//查看教师信息
        btnNewButton_2_1.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton_2_1.setBounds(10, 42, 145, 25);
        studentschedule.getContentPane().add(btnNewButton_2_1);
        btnNewButton_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_checkTeacherMessageActionPerformed(e);
            }
        });


    }

    private DatePicker getDatePicker() {
        DatePicker datepick;
        String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
        Date date = new Date();
        Font font = new Font("Times New Roman", Font.BOLD, 14);
        Dimension dimension = new Dimension(177, 24);
        int[] hilightDays = {1, 3, 5, 7};
        int[] disableDays = {4, 6, 5, 9};
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
        datepick.setLocation(104, 74);
        datepick.setBounds(751, 163, 138, 21);
        //设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        //设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disableDays);
        //设置国家
        datepick.setLocale(Locale.CHINA);
        //设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }
    /*************************************学生端消息响应函数*******************************************************/
    /**
     * 搜索老师信息消息响应函数
     */
    private void btn_searchTeacherActionPerformed(ActionEvent e) {
        String selectstr = textField001.getText();//输入老师姓名
        List<Bespoke> bespokelist = Bespoke.selectBespokeByt_name(selectstr);
        TableRefresh.refreshStudentBespokeTable(bespokelist, table_001);
    }

    /**
     * 浏览老师信息的消息响应函数
     */
    private void btn_checkTeacherMessageActionPerformed(ActionEvent e) {
        List<Teacher> teacherlist = Teacher.getTeacher();
        TableRefresh.refreshStudent_TeacherTable(teacherlist, table_001);
    }

    /**
     * 浏览老师已发布日程的消息响应函数
     */
    private void btn_checkTeacherActionPerformed(ActionEvent e) {
        List<Bespoke> bespokelist = Bespoke.getStudentBespoke();
        TableRefresh.refreshStudentBespokeTable(bespokelist, table_001);
    }

    /**
     * 预约老师已发布的日程消息响应函数
     */
    public void btn_toBedoneActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) table_001.getModel();
        String newbespokestatus = "已预约";
        int valuecolumn = dtm.findColumn("是否选中");
        int bespokenumcolumn = dtm.findColumn("预约号");
        int bespokestatuscolumn = dtm.findColumn("预约状态");
        for (int i = 0; i < table_001.getRowCount(); i++) {
            String getvalue = table_001.getValueAt(i, valuecolumn).toString();
            String bespokenum = table_001.getValueAt(i, bespokenumcolumn).toString();
            String bespokestatus = table_001.getValueAt(i, bespokestatuscolumn).toString();
            if (getvalue == "true") {
                if (bespokestatus.equals("待预约")) {
                    StudentMessageFrame window1 = new StudentMessageFrame(bespokenum);
                    FrameChange.setCenter(window1.studentmessageframe);
                    window1.studentmessageframe.setVisible(true);
                }
            }
        }
    }

    /**
     * 提交申请已发布日程外时间消息响应函数
     */
    private void btn_publishRequestActionPerformed(ActionEvent e) {
        String t_name = textField_1.getText();
        String t_usernum = textField.getText();
        String qa_time = datepick.getText();
        String qa_address = textField_2.getText();
        String qa_message = textField_3.getText();
        String s_name = textField_4.getText();
        if (t_name.equals("") || qa_address.equals("") || qa_time.equals("") || t_usernum.equals(""))
            JOptionPane.showMessageDialog(null, "不能为空！");
        else {
            Bespoke.addRequest(t_usernum, t_name, qa_time, qa_address, s_name, qa_message);
            JOptionPane.showMessageDialog(null, "发布成功！", "提示", JOptionPane.PLAIN_MESSAGE);
            List<Bespoke> bespokelist = Bespoke.getStudentBespoke();
            TableRefresh.refreshStudentBespokeTable(bespokelist, table_001);
        }
    }

    /**
     * 查看自己的预约消息响应函数
     */
    private void btn_chectMyBespokeActionPerformed(ActionEvent e) {
        String selectstr = textField_4.getText();
        List<Bespoke> bespokelist = Bespoke.checkMyBespoke(selectstr);
        TableRefresh.refreshStudentBespokeTable(bespokelist, table_001);
    }
}
