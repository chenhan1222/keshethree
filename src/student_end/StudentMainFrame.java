package student_end;

import java.awt.EventQueue;

import javax.swing.*;

import control_packet.FrameChange;
import teacher_end.StudentSchedule;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentMainFrame {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMainFrame window = new StudentMainFrame();
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
	public StudentMainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5B66\u751F\u4E3B\u754C\u9762");//学生主界面
		frame.setBounds(100, 100, 524, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("src/images/信息管理.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyPersonalManageFrame window = new MyPersonalManageFrame();
				FrameChange.setCenter(window.frame);
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(117, 82, 104, 42);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setIcon(new ImageIcon("src/images/订餐.png"));

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFrame window=new CustomerFrame();
				FrameChange.setCenter(window.customerframe);
				window.customerframe.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(347, 82, 104, 42);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton();//前往预约
		btnNewButton_2.setIcon(new ImageIcon("src/images/预约.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentSchedule window=new StudentSchedule();
				FrameChange.setCenter(window.studentschedule);
				window.studentschedule.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(117, 247, 104, 42);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.setIcon(new ImageIcon("src/images/缴费.png"));

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyTuition_feeFrame window=new MyTuition_feeFrame();
				FrameChange.setCenter(window.frame);
				window.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(347, 247, 104, 42);
		frame.getContentPane().add(btnNewButton_3);

		JLabel lblNewLabel = new JLabel("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel.setBounds(23, 92, 104, 20);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u6821\u56ED\u8BA2\u9910\uFF1A");//校园订餐：
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_1.setBounds(275, 92, 83, 20);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u7B54\u7591\u9884\u7EA6:");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_2.setBounds(34, 259, 93, 20);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u5B66\u8D39\u7F34\u7EB3\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_3.setBounds(275, 259, 93, 20);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
