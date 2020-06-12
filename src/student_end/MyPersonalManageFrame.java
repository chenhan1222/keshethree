package student_end;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Login.LoginFrame;
import data.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyPersonalManageFrame {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPersonalManageFrame window = new MyPersonalManageFrame();
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
	public MyPersonalManageFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("个人信息管理");
		frame.getContentPane().setFont(new Font("宋体", Font.BOLD, 16));
		frame.setBounds(100, 100, 476, 443);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u516C\u5BD3\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(81, 71, 67, 21);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD, 14));
		textField.setBounds(158, 72, 151, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BBF\u820D\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(81, 114, 67, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.BOLD, 14));
		textField_1.setBounds(158, 115, 151, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u73ED\u7EA7\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_2.setBounds(81, 157, 67, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.BOLD, 14));
		textField_2.setBounds(158, 157, 151, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel(" \u59D3\u540D\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_3.setBounds(81, 200, 67, 21);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.BOLD, 14));
		textField_3.setBounds(158, 200, 151, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_4.setBounds(81, 243, 67, 21);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.BOLD, 14));
		textField_4.setBounds(158, 243, 151, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel(" \u6635\u79F0\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_5.setBounds(81, 286, 67, 21);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("宋体", Font.BOLD, 14));
		textField_5.setBounds(158, 286, 151, 21);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("重置");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_restartActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton.setBounds(94, 334, 93, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_modifyActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton_1.setBounds(239, 334, 93, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel(" 系名：");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_6.setBounds(81, 29, 67, 21);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_7.setBounds(158, 29, 151, 21);
		frame.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton_2 = new JButton("刷新");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_refreshActionPerformed(e);	
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton_2.setBounds(333, 20, 93, 30);
		frame.getContentPane().add(btnNewButton_2);
		Student student =Student.getStudent(LoginFrame.usernum);
		lblNewLabel_7.setText(student.s_department_name);
		textField.setText(student.s_apartment_num);
		textField_1.setText(student.s_dormitory_num);
		textField_2.setText(student.s_class_num);
		textField_3.setText(student.s_name);
		textField_4.setText(student.s_phonenum);
		textField_5.setText(student.s_nickname);	
	}
/*************************************消息响应函数********************************************/
	/**
	 * 重置
	 * */
	private void btn_restartActionPerformed(ActionEvent e) {
		 textField.setText("");
		 textField_1.setText("");
		 textField_2.setText("");
		 textField_3.setText("");
		 textField_4.setText("");
		 textField_5.setText("");
	 }
	/**
	 * 修改
	 * */
	private void btn_modifyActionPerformed(ActionEvent e) {		
    	String s_dormitory_num=textField_1.getText();//宿舍号
    	String s_apartment_num=textField.getText();//公寓号
    	String s_class_num=textField_2.getText();//班级号
    	String s_name=textField_3.getText();//姓名    	
    	String s_phonenum=textField_4.getText();//手机号
    	String s_nickname=textField_5.getText();//昵称 	 	
    	String s_usernum = LoginFrame.usernum;
    	Student.modifyStudent(s_usernum, s_apartment_num, s_dormitory_num, s_class_num, s_name, s_phonenum, s_nickname);
   	 	JOptionPane.showMessageDialog(null, "修改成功");
	 }
	private void btn_refreshActionPerformed(ActionEvent e) {		
		Student student =Student.getStudent(LoginFrame.usernum);
		lblNewLabel_7.setText(student.s_department_name);
		textField.setText(student.s_apartment_num);
		textField_1.setText(student.s_dormitory_num);
		textField_2.setText(student.s_class_num);
		textField_3.setText(student.s_name);
		textField_4.setText(student.s_phonenum);
		textField_5.setText(student.s_nickname);	
		}
	
}
