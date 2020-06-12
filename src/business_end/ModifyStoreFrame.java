package business_end;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Login.LoginFrame;
import data.Store;

public class ModifyStoreFrame {

	public JFrame frame;
	private JTextField textField213;
	private JTextField textField_106;
	private JTextField textField_278;
	private JTextArea textArea006;
	private int store_id ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyStoreFrame window = new ModifyStoreFrame();
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
	public ModifyStoreFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 store_id = LoginFrame.store_id; 
		 frame = new JFrame();
         frame.setTitle("\u4FEE\u6539\u5546\u5E97\u4FE1\u606F");//�޸��̵���Ϣ
         frame.setBounds(100, 100, 500, 405);
         frame.setLocationRelativeTo(null);
         frame.getContentPane().setLayout(null);

         JLabel lblNewLabel04 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");//��ϵ�绰��
         lblNewLabel04.setFont(new Font("����", Font.BOLD, 16));
         lblNewLabel04.setBounds(10, 118, 85, 29);
         frame.getContentPane().add(lblNewLabel04);

         JLabel lblNewLabel_106 = new JLabel("\u5730\u5740\uFF1A");//��ַ��
         lblNewLabel_106.setFont(new Font("����", Font.BOLD, 16));
         lblNewLabel_106.setBounds(10, 77, 85, 19);
         frame.getContentPane().add(lblNewLabel_106);

         JLabel lblNewLabel_212 = new JLabel("\u5546\u5E97\u540D\uFF1A");  //�̵�����ǩ
         lblNewLabel_212.setFont(new Font("����", Font.BOLD, 16));
         lblNewLabel_212.setBounds(10, 28, 98, 19);
         frame.getContentPane().add(lblNewLabel_212);

         JButton btnNewButton003 = new JButton("�ύ");//�ύ
         btnNewButton003.addActionListener(new ActionListener() {//�޸��̵����Ϣ
             public void actionPerformed(ActionEvent e) {
            	 btn_modifyStoreActionPerformed(e);
             }
         });
         btnNewButton003.setFont(new Font("����", Font.BOLD, 16));
         btnNewButton003.setBounds(103, 312, 97, 29);
         frame.getContentPane().add(btnNewButton003);

         textField213 = new JTextField(Store.getStoreName(store_id));//��ȡ�û���
         textField213.setFont(new Font("����", Font.BOLD, 16));
         textField213.setBounds(103, 28, 188, 21);
         frame.getContentPane().add(textField213);
         textField213.setColumns(10);

         textField_106 = new JTextField(Store.getAddress(store_id));//��ȡ��ַ
         textField_106.setFont(new Font("����", Font.BOLD, 16));
         textField_106.setBounds(105, 77, 186, 21);
         frame.getContentPane().add(textField_106);
         textField_106.setColumns(10);

         textField_278 = new JTextField(Store.getStorePhone(store_id));
         textField_278.setFont(new Font("����", Font.BOLD, 16));
         textField_278.setBounds(105, 123, 148, 21);
         frame.getContentPane().add(textField_278);
         textField_278.setColumns(10);

         JLabel lblNewLabel_333 = new JLabel("\u516C\u544A\uFF1A");//���棺
         lblNewLabel_333.setFont(new Font("����", Font.BOLD, 16));
         lblNewLabel_333.setBounds(10, 170, 58, 19);
         frame.getContentPane().add(lblNewLabel_333);

         textArea006 = new JTextArea();
         textArea006.setFont(new Font("����", Font.BOLD, 16));
         textArea006.setWrapStyleWord(true);
         textArea006.setLineWrap(true);
         textArea006.setBounds(103, 174, 346, 117);
         frame.getContentPane().add(textArea006);
	}
	/**
	 * �޸��̵���Ϣ
	 * */
	 private void btn_modifyStoreActionPerformed(ActionEvent e) {
		 try {
             String newname = textField213.getText();
             String storephone = textField_278.getText();
             String address = textField_106.getText();
             String newnotice = textArea006.getText();
             Store.updateName(store_id, newname);
             Store.updateAddress(store_id, address);
             Store.updateNotice(store_id, newnotice);
             Store.updatePhoneNum(store_id, storephone);
             JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
         } catch (Exception e2) {
             JOptionPane.showMessageDialog(null, "���ʧ�ܣ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
         }
	 }
}
