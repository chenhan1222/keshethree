package student_end;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Login.LoginFrame;
import control_packet.TableRefresh;
import data.Staff;
import data.Store;
import data.Tuition_fee;
import management_end.Store_bindingFrame;
import tabletools.MyTuition_feeTableModel;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.awt.event.ActionEvent;

public class MyTuition_feeFrame {
	public JFrame frame;
	private JTable table;
	private String s_usernum;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyTuition_feeFrame window = new MyTuition_feeFrame();
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
	public MyTuition_feeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		s_usernum=LoginFrame.usernum;
		frame = new JFrame();
		frame.setTitle("�ҵ�ѧ��");
		frame.setBounds(100, 100, 790, 544);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("ȫ����¼");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_getAllTuition_feeActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 14));
		btnNewButton.setBounds(26, 45, 93, 30);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("\u5E74\u4EFD:");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel.setBounds(188, 19, 54, 20);
		frame.getContentPane().add(lblNewLabel);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"ȫ��", "2020", "2021", "2020", "2019", "2018", "2017", "2016", "2015"}));
		comboBox.setSelectedIndex(0);
		comboBox.setFont(new Font("����", Font.BOLD, 14));
		comboBox.setBounds(144, 49, 122, 23);
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("ѧ�ڣ�");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel_1.setBounds(333, 19, 46, 20);
		frame.getContentPane().add(lblNewLabel_1);

		comboBox_1 =new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"\u5168\u90E8", "\u6625\u5B63\u5B66\u671F", "\u79CB\u5B63\u5B66\u671F"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setFont(new Font("����", Font.BOLD, 14));
		comboBox_1.setBounds(295, 49, 122, 23);
		frame.getContentPane().add(comboBox_1);

		comboBox_2 = new JComboBox<String>();
		comboBox_2.setFont(new Font("����", Font.BOLD, 14));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"\u5168\u90E8", "\u672A\u4ED8\u6B3E", "\u5DF2\u4ED8\u6B3E"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(441, 49, 114, 23);
		frame.getContentPane().add(comboBox_2);

		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_selectTuition_feeActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 14));
		btnNewButton_1.setBounds(574, 45, 99, 30);
		frame.getContentPane().add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 85, 674, 357);
		frame.getContentPane().add(scrollPane);

		table = new JTable(new MyTuition_feeTableModel());
		scrollPane.setViewportView(table);

		JButton btnNewButton_2 = new JButton("�ɷ�");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_payTuition_feeActionPerformed( e);
			}
		});
		btnNewButton_2.setFont(new Font("����", Font.BOLD, 14));
		btnNewButton_2.setBounds(324, 452, 93, 30);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_4 = new JButton("ˢ��");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_getAllTuition_feeActionPerformed(e);
			}
		});
		btnNewButton_4.setFont(new Font("����", Font.BOLD, 14));
		btnNewButton_4.setBounds(681, 45, 83, 30);
		frame.getContentPane().add(btnNewButton_4);

		JLabel lblNewLabel_2 = new JLabel("\u652F\u4ED8\u72B6\u6001");
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel_2.setBounds(462, 19, 69, 20);
		frame.getContentPane().add(lblNewLabel_2);
	}
/****************************************��Ϣ��Ӧ����*************************************/
	/**
	 * ��ȡȫ��ѧ����Ϣ
	 * */
	private void btn_getAllTuition_feeActionPerformed(ActionEvent e) {
		List<Tuition_fee>tuition_feelist = Tuition_fee.getTuition_fee(s_usernum);
		TableRefresh.refreshTuition_feeTable(tuition_feelist, table);
	}
	/**
	 * ����ĳѧ����Ϣ
	 * */
	private void btn_selectTuition_feeActionPerformed(ActionEvent e) {
		String year= comboBox.getSelectedItem().toString();
		String term=comboBox_1.getSelectedItem().toString();
		String paystatus=comboBox_2.getSelectedItem().toString();
		//System.out.println(year+","+term+","+paystatus);
		List<Tuition_fee>tuition_feelist = Tuition_fee.getTuition_fee(s_usernum, year, term, paystatus);
		TableRefresh.refreshTuition_feeTable(tuition_feelist, table);
	}
	/**
	 * �ɷ�
	 * */
	private void btn_payTuition_feeActionPerformed(ActionEvent e) {
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		int num=0;
		String getvalue;
		String year;
		String term;
		double cost;
		int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
		int yearcolumn = dtm.findColumn("��");
		int termcolumn = dtm.findColumn("ѧ��");
		int costcolumn = dtm.findColumn("���");
		for (int i = 0; i < table.getRowCount(); i++) {
			getvalue = table.getValueAt(i, ifselectcolumn).toString();
			if (getvalue == "true") {
				num++;
			}
			if(num>1)
				break;
		}
		if(num==1) {
			for (int j = 0; j < table.getRowCount(); j++) {
				getvalue = table.getValueAt(j, ifselectcolumn).toString();
				if (getvalue == "true") {
					year=table.getValueAt(j, yearcolumn).toString();
					term=table.getValueAt(j, termcolumn).toString();
					cost=Double.valueOf(table.getValueAt(j, costcolumn).toString());
					if(Tuition_fee.getPayStatus(year, term, s_usernum).equals("δ����")){//������˺�û�н��й���
						//�ڴ˴�֧����ҳ
						String url="http://47.95.200.90:8080/se_xf?";
						String finalurl=url+"s_usernum="+LoginFrame.usernum+"&year="+year+"&term="+term+"&cost="+cost;
						Desktop desktop = Desktop.getDesktop();
						try {
							desktop.browse(new URI(finalurl));
						} catch (IOException | URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "��ѧ���Ѹ���,���ظ����");
					}
					break;
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "ѡ�й��࣬��һ��ѡ��һ��ѧ�ڽ��нɷѣ�");
		}

	}
}
