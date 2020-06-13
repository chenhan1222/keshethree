package teacher_end;

import com.eltima.components.ui.DatePicker;
import control_packet.TableRefresh;
import data.Bespoke;
import data.Teacher;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Timer;
import java.util.*;

public class TeacherFrame {
    public JFrame teacherframe;
    private JTable table_001;
    private JTextField textField001;
    private String time;
    private String DEFAULT_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";//���ڸ�ʽ
    private int ONE_SECOND = 1000;
    DatePicker datepick;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;

    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JButton btnNewButton_5;
    private JButton btnNewButton_6;
    private JButton btnNewButton_7;
    private JButton btnNewButton_8;
    private JButton btnNewButton_9;
    private JButton btnNewButton_10;
    private JButton btnNewButton_11;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TeacherFrame window = new TeacherFrame();
                    window.teacherframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TeacherFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */


    final static DatePicker getDatePicker() {
        DatePicker datepick;
        String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
        Date date = new Date();
        Font font = new Font("Times New Roman", Font.BOLD, 14);
        Dimension dimension = new Dimension(177, 24);
        int[] hilightDays = {1, 3, 5, 7};
        int[] disableDays = {4, 6, 5, 9};
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
        datepick.setLocation(104, 74);
        datepick.setBounds(130, 74, 138, 21);
        //����һ���·�����Ҫ������ʾ������
        datepick.setHightlightdays(hilightDays, Color.red);
        //����һ���·��в���Ҫ�����ӣ��ʻ�ɫ��ʾ
        datepick.setDisableddays(disableDays);
        //���ù���
        datepick.setLocale(Locale.CHINA);
        //����ʱ�����ɼ�
        datepick.setTimePanleVisible(true);
        return datepick;
    }

    /*******************************************��ʦ�˽��沼��*************************************************/

    private void initialize() {
        teacherframe = new JFrame();
        teacherframe.setTitle("��ʦ����ƽ̨");
        teacherframe.setBounds(100, 100, 970, 760);
        teacherframe.getContentPane().setLayout(null);


        table_001 = new JTable();
        table_001.setFont(new Font("����", Font.BOLD, 12));
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table_001.setDefaultRenderer(Object.class, r);
        table_001.setRowHeight(100);
        DefaultTableModel dtm = (DefaultTableModel) table_001.getModel();
        JScrollPane scrollPane = new JScrollPane(table_001);
        scrollPane.setSize(733, 430);
        scrollPane.setLocation(10, 210);
        teacherframe.getContentPane().add(scrollPane);

        btnNewButton_1 = new JButton("�鿴�ѱ�ԤԼ�ճ�");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_checkBedoneActionPerformed(e);
            }
        });
        btnNewButton_1.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_1.setBounds(753, 430, 162, 27);
        teacherframe.getContentPane().add(btnNewButton_1);


        btnNewButton_2 = new JButton("�����ճ�");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_publishScheduleActionPerformed(e);
            }

        });
        btnNewButton_2.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_2.setBounds(115, 173, 111, 27);
        teacherframe.getContentPane().add(btnNewButton_2);

        btnNewButton_3 = new JButton("�鿴�����ճ�");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_checkRequestActionPerformed(e);
            }
        });
        btnNewButton_3.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_3.setBounds(753, 315, 162, 27);
        teacherframe.getContentPane().add(btnNewButton_3);

        lblNewLabel_1 = new JLabel();
        lblNewLabel_1.setFont(new Font("����", Font.BOLD, 20));
        lblNewLabel_1.setBounds(618, 31, 309, 30);
        teacherframe.getContentPane().add(lblNewLabel_1);
        Timer tmr = new Timer();
        tmr.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), ONE_SECOND);

        textField001 = new JTextField();
        textField001.setFont(new Font("����", Font.BOLD, 14));
        textField001.setBounds(130, 10, 138, 21);
        teacherframe.getContentPane().add(textField001);
        textField001.setColumns(10);

        lblNewLabel_2 = new JLabel("����������������");
        lblNewLabel_2.setBounds(10, 11, 120, 20);
        teacherframe.getContentPane().add(lblNewLabel_2);

        textField = new JTextField();
        textField.setFont(new Font("����", Font.BOLD, 14));
        textField.setColumns(10);
        textField.setBounds(130, 40, 138, 21);
        teacherframe.getContentPane().add(textField);

        lblNewLabel_3 = new JLabel("���������Ĺ���");//���������Ĺ���
        lblNewLabel_3.setBounds(10, 41, 120, 20);
        teacherframe.getContentPane().add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("���������ʱ�䣺");
        lblNewLabel_4.setBounds(10, 77, 120, 20);
        teacherframe.getContentPane().add(lblNewLabel_4);

        datepick = getDatePicker();
        teacherframe.getContentPane().add(datepick);

        lblNewLabel_5 = new JLabel("��������ɵص㣺");//��������ɵص㣺
        lblNewLabel_5.setBounds(10, 104, 120, 20);
        teacherframe.getContentPane().add(lblNewLabel_5);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("����", Font.BOLD, 14));
        textField_1.setColumns(10);
        textField_1.setBounds(130, 100, 138, 21);
        teacherframe.getContentPane().add(textField_1);

        lblNewLabel_6 = new JLabel("�������ճ�״̬��");//�������ճ�״̬��
        lblNewLabel_6.setBounds(10, 130, 120, 20);
        teacherframe.getContentPane().add(lblNewLabel_6);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("����", Font.BOLD, 14));
        textField_2.setColumns(10);
        textField_2.setBounds(130, 126, 138, 21);
        teacherframe.getContentPane().add(textField_2);

        lblNewLabel_7 = new JLabel("��ǰʱ��:");//��ǰʱ�䣺
        lblNewLabel_7.setFont(new Font("����", Font.PLAIN, 14));
        lblNewLabel_7.setBounds(538, 34, 70, 27);
        teacherframe.getContentPane().add(lblNewLabel_7);

        btnNewButton_8 = new JButton("ͬ������");//ͬ������
        btnNewButton_8.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_acceptRequestActionPerformed(e);
            }
        });
        btnNewButton_8.setBounds(70, 663, 101, 27);
        teacherframe.getContentPane().add(btnNewButton_8);

        btnNewButton_4 = new JButton("�ܾ�����");//�ܾ�����
        btnNewButton_4.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_4.setBounds(235, 663, 138, 27);
        teacherframe.getContentPane().add(btnNewButton_4);
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_refuseRequestActionPerformed(e);
            }
        });

        btnNewButton_5 = new JButton("ԤԼ���");//ԤԼ���
        btnNewButton_5.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_5.setBounds(605, 663, 101, 27);
        teacherframe.getContentPane().add(btnNewButton_5);
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_finishRequestActionPerformed(e);
            }
        });

        btnNewButton_6 = new JButton("ȡ��ԤԼ");//ȡ��ԤԼ
        btnNewButton_6.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_6.setBounds(435, 663, 101, 27);
        teacherframe.getContentPane().add(btnNewButton_6);
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_cancelRequestActionPerformed(e);
            }
        });

        btnNewButton_7 = new JButton("�޸��ճ̰���");//�޸��ճ̰���
        btnNewButton_7.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_7.setBounds(753, 542, 162, 27);
        teacherframe.getContentPane().add(btnNewButton_7);
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_modifyRequestActionPerformed(e);
            }
        });

        btnNewButton_9 = new JButton("�鿴������Ϣ");//�鿴������Ϣ
        btnNewButton_9.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_9.setBounds(538, 100, 132, 27);
        teacherframe.getContentPane().add(btnNewButton_9);
        btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_checkTeacherMessageActionPerformed(e);
            }
        });

        btnNewButton_10 = new JButton("�޸ĸ�����Ϣ");//�޸ĸ�����Ϣ
        btnNewButton_10.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_10.setBounds(538, 152, 132, 27);
        teacherframe.getContentPane().add(btnNewButton_10);
        btnNewButton_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_modifyTeacherActionPerformed(e);
            }
        });

        btnNewButton_11 = new JButton("�ϴ�ͷ��");//�ϴ�ͷ��
        btnNewButton_11.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_11.setBounds(715, 100, 132, 27);
        teacherframe.getContentPane().add(btnNewButton_11);
        btnNewButton_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_upPictureActionPerformed(e);
            }
        });

        lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setBounds(827, 152, 100, 100);
        teacherframe.getContentPane().add(lblNewLabel_8);

        lblNewLabel_9 = new JLabel("ͼ��Ԥ����");//ͼ��Ԥ����
        lblNewLabel_9.setFont(new Font("����", Font.PLAIN, 14));
        lblNewLabel_9.setBounds(736, 152, 70, 27);
        teacherframe.getContentPane().add(lblNewLabel_9);
        btnNewButton_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_modifyTeacherActionPerformed(e);
            }
        });
    }

    protected class JLabelTimerTask extends TimerTask {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(
                DEFAULT_TIME_FORMAT);

        @Override
        public void run() {
            time = dateFormatter.format(Calendar.getInstance().getTime());
            lblNewLabel_1.setText(time);
        }
    }
    /*************************************��ʦ����Ϣ��Ӧ����*******************************************************/
    /**
     * �鿴��ѧ��ԤԼ���ճ���Ϣ��Ӧ����
     */
    private void btn_checkBedoneActionPerformed(ActionEvent e) {
        String selectstr = textField001.getText();//������ʦ����
        List<Bespoke> bespokelist = Bespoke.selectBespokeByqa_status(selectstr);//��ȡ��ǰ��ʦ�ѱ�ԤԼ���ճ�
        TableRefresh.refreshTeacherBespokeTable(bespokelist, table_001);
    }

    /**
     * ����ԤԼ�ճ̵���Ϣ��Ӧ����
     */
    private void btn_publishScheduleActionPerformed(ActionEvent e) {
        String t_name = textField001.getText();
        String t_usernum = textField.getText();
        String qa_time = datepick.getText();
        String qa_address = textField_1.getText();
        String qa_status = textField_2.getText();
        if (t_name.equals("") || qa_address.equals("") || qa_time.equals("") || qa_status.equals(""))
            JOptionPane.showMessageDialog(null, "����Ϊ�գ�");
        else {
            Bespoke.addBespoke(t_usernum, t_name, qa_time, qa_address, qa_status);
            JOptionPane.showMessageDialog(null, "�����ɹ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
            List<Bespoke> bespokelist = Bespoke.getTeacherBespoke(t_usernum);
            TableRefresh.refreshTeacherBespokeTable(bespokelist, table_001);
        }
    }

    /**
     * �鿴ѧ��������ճ���Ϣ��Ӧ����
     */
    private void btn_checkRequestActionPerformed(ActionEvent e) {
        String selectstr = textField001.getText();//������ʦ����
        List<Bespoke> bespokelist = Bespoke.selectBespokeBeRequest(selectstr);//��ȡ��ǰ��ʦ�ѱ�ԤԼ���ճ�
        TableRefresh.refreshTeacherBespokeTable(bespokelist, table_001);
    }

    /**
     * ͬ��ѧ���������Ϣ��Ӧ����
     */
    private void btn_acceptRequestActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) table_001.getModel();
        String newbespokestatus = "��ԤԼ";
        int valuecolumn = dtm.findColumn("�Ƿ�ѡ��");
        int bespokenumcolumn = dtm.findColumn("ԤԼ��");
        int bespokestatuscolumn = dtm.findColumn("ԤԼ״̬");
        for (int i = 0; i < table_001.getRowCount(); i++) {
            String getvalue = table_001.getValueAt(i, valuecolumn).toString();
            String bespokenum = table_001.getValueAt(i, bespokenumcolumn).toString();
            String bespokestatus = table_001.getValueAt(i, bespokestatuscolumn).toString();
            if (getvalue == "true") {
                if (bespokestatus.equals("������")) {
                    Bespoke.changeBespokestatus(bespokenum, newbespokestatus);
                    JOptionPane.showMessageDialog(null, "�ճ̰��ųɹ���");
                    String selectstr = textField001.getText();
                    List<Bespoke> bespokeList = Bespoke.selectBespokeByqa_status(selectstr);
                    TableRefresh.refreshTeacherBespokeTable(bespokeList, table_001);
                }
            }
        }
    }

    /**
     * �ܾ�ѧ���������Ϣ��Ӧ����
     */
    private void btn_refuseRequestActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) table_001.getModel();
        String newbespokestatus = "�Ѿܾ�";
        int valuecolumn = dtm.findColumn("�Ƿ�ѡ��");
        int bespokenumcolumn = dtm.findColumn("ԤԼ��");
        int bespokestatuscolumn = dtm.findColumn("ԤԼ״̬");
        for (int i = 0; i < table_001.getRowCount(); i++) {
            String getvalue = table_001.getValueAt(i, valuecolumn).toString();
            String bespokenum = table_001.getValueAt(i, bespokenumcolumn).toString();
            String bespokestatus = table_001.getValueAt(i, bespokestatuscolumn).toString();
            if (getvalue == "true") {
                if (bespokestatus.equals("������")) {
                    Bespoke.changeBespokestatus(bespokenum, newbespokestatus);
                    JOptionPane.showMessageDialog(null, "�ճ̰��ųɹ���");
                    String selectstr = textField001.getText();
                    List<Bespoke> bespokeList = Bespoke.selectBespokeByqa_status(selectstr);
                    TableRefresh.refreshTeacherBespokeTable(bespokeList, table_001);
                }
            }
        }
    }

    /**
     * ȡ���ճ̵���Ϣ��Ӧ����
     */
    private void btn_cancelRequestActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) table_001.getModel();
        String newbespokestatus = "��ȡ��";
        int valuecolumn = dtm.findColumn("�Ƿ�ѡ��");
        int bespokenumcolumn = dtm.findColumn("ԤԼ��");
        int bespokestatuscolumn = dtm.findColumn("ԤԼ״̬");
        for (int i = 0; i < table_001.getRowCount(); i++) {
            String getvalue = table_001.getValueAt(i, valuecolumn).toString();
            String bespokenum = table_001.getValueAt(i, bespokenumcolumn).toString();
            String bespokestatus = table_001.getValueAt(i, bespokestatuscolumn).toString();
            if (getvalue == "true") {
                if (bespokestatus.equals("��ԤԼ")) {
                    Bespoke.changeBespokestatus(bespokenum, newbespokestatus);
                    JOptionPane.showMessageDialog(null, "�ճ�ȡ���ɹ���");
                    String selectstr = textField001.getText();
                    List<Bespoke> bespokeList = Bespoke.selectBespokeByqa_status(selectstr);
                    TableRefresh.refreshTeacherBespokeTable(bespokeList, table_001);
                }
            }
        }
    }

    /**
     * ����ճ̵���Ϣ��Ӧ����
     */
    private void btn_finishRequestActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) table_001.getModel();
        String newbespokestatus = "�����";
        int valuecolumn = dtm.findColumn("�Ƿ�ѡ��");
        int bespokenumcolumn = dtm.findColumn("ԤԼ��");
        int bespokestatuscolumn = dtm.findColumn("ԤԼ״̬");
        for (int i = 0; i < table_001.getRowCount(); i++) {
            String getvalue = table_001.getValueAt(i, valuecolumn).toString();
            String bespokenum = table_001.getValueAt(i, bespokenumcolumn).toString();
            String bespokestatus = table_001.getValueAt(i, bespokestatuscolumn).toString();
            if (getvalue == "true") {
                if (bespokestatus.equals("��ԤԼ")) {
                    Bespoke.changeBespokestatus(bespokenum, newbespokestatus);
                    JOptionPane.showMessageDialog(null, "������ɣ�");
                    String selectstr = textField001.getText();
                    List<Bespoke> bespokeList = Bespoke.selectBespokeByqa_status(selectstr);
                    TableRefresh.refreshTeacherBespokeTable(bespokeList, table_001);
                }
            }
        }
    }

    /**
     * �޸��ճ̵���Ϣ��Ӧ����
     */
    private void btn_modifyRequestActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) table_001.getModel();
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        int bespoke_idcolumn = dtm.findColumn("ԤԼ��");
        int bespoke_addresscolumn = dtm.findColumn("���ɵص�");
        int bespoke_timecolumn = dtm.findColumn("����ʱ��");
        for (int i = 0; i < table_001.getRowCount(); i++) {
            String value = table_001.getValueAt(i, ifselectcolumn).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ
            if (value == "true") {
                Bespoke newbespoke = new Bespoke();
                newbespoke.qa_id = table_001.getValueAt(i, bespoke_idcolumn).toString();
                newbespoke.qa_time = table_001.getValueAt(i, bespoke_timecolumn).toString();
                newbespoke.qa_address = table_001.getValueAt(i, bespoke_addresscolumn).toString();
                String selectstr = textField001.getText();
                Bespoke.modifyBespoke(newbespoke);
                JOptionPane.showMessageDialog(null, "�޸���ɣ�");
                List<Bespoke> bespokeList = Bespoke.selectBespokeByqa_status(selectstr);
                TableRefresh.refreshTeacherBespokeTable(bespokeList, table_001);
            }
        }
    }

    /**
     * ��ʦ�鿴������Ϣ����Ϣ��Ӧ����
     */
    private void btn_checkTeacherMessageActionPerformed(ActionEvent e) {
        String selectstr = textField.getText();
        List<Teacher> teacherlist = Teacher.selectTeacherByT_usernum(selectstr);//��ȡ��ǰ��ʦ��Ϣ
        TableRefresh.refreshTeacherTable(teacherlist, table_001);
    }

    /**
     * �޸��ճ̵���Ϣ��Ӧ����
     */
    private void btn_modifyTeacherActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) table_001.getModel();
        int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
        int teacher_idcolumn = dtm.findColumn("����");
        int teacher_passwordcolumn = dtm.findColumn("����");
        int teacher_namecolumn = dtm.findColumn("����");
        int teacher_departmentcolumn = dtm.findColumn("ϵ��");
        int teacher_phonenumcolumn = dtm.findColumn("�ֻ���");
        int teacher_addresscolumn = dtm.findColumn("�칫��");
        int teacher_emailcolumn = dtm.findColumn("����");
        for (int i = 0; i < table_001.getRowCount(); i++) {
            String value = table_001.getValueAt(i, ifselectcolumn).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ
            if (value == "true") {
                Teacher newteacher = new Teacher();
                newteacher.t_usernum = table_001.getValueAt(i, teacher_idcolumn).toString();
                newteacher.t_password = table_001.getValueAt(i, teacher_passwordcolumn).toString();
                newteacher.t_name = table_001.getValueAt(i, teacher_namecolumn).toString();
                newteacher.t_department_name = table_001.getValueAt(i, teacher_departmentcolumn).toString();
                newteacher.t_phonenum = table_001.getValueAt(i, teacher_phonenumcolumn).toString();
                newteacher.t_office = table_001.getValueAt(i, teacher_addresscolumn).toString();
                newteacher.t_email = table_001.getValueAt(i, teacher_emailcolumn).toString();
                String selectstr = textField.getText();
                try {
                    Teacher.t_modifyTeacher(newteacher);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "�޸���ɣ�");
                List<Teacher> teacherlist = Teacher.selectTeacherByT_usernum(selectstr);
                TableRefresh.refreshTeacherTable(teacherlist, table_001);
            }
        }
    }

    /**
     * ��ʦ�ϴ�ͷ�����Ϣ��Ӧ����
     */
    private void btn_upPictureActionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpeg,gif,bmp,png", "jpg", "gif", "png", "gif");
        fileChooser.setFileFilter(filter);
        try {
            fileChooser.showOpenDialog(null);

        } catch (HeadlessException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        }
        try {
            File f = fileChooser.getSelectedFile();
            int width = 100, height = 100;
            ImageIcon image = new ImageIcon(f.getPath());
            image.setImage(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
            lblNewLabel_8.setIcon(image);
        } catch (Exception e2) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "���ͼƬʧ�ܣ�");
            return;
        }

    }
}
