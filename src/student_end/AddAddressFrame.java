package student_end;
import data.*;
import javax.swing.*;
import Login.LoginFrame;
import control_packet.FrameChange;
import control_packet.TableRefresh;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class AddAddressFrame {

    public JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnNewRadioButton_1;
    /**
     * Launch the application.
     */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addaddressframe window = new Addaddressframe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/

    /**
     * Create the application.
     */
    public AddAddressFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("新增联系人");
        frame.setBounds(100, 100, 435, 314);
        frame.getContentPane().setLayout(null);
        FrameChange.setCenter(frame);//居中显示
        
        JLabel lblNewLabel = new JLabel("联系人:");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel.setBounds(10, 22, 63, 36);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(83, 30, 143, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("地址：");
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_1.setBounds(10, 82, 75, 15);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(82, 79, 221, 21);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("性别:");
        lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_2.setBounds(10, 164, 58, 26);
        frame.getContentPane().add(lblNewLabel_2);

        rdbtnNewRadioButton = new JRadioButton("先生");
        //rdbtnNewRadioButton.setIcon(new ImageIcon("src/images/男士.png"));
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_1.setSelected(false);
            }
        });
        rdbtnNewRadioButton.setFont(new Font("宋体", Font.BOLD, 14));
        rdbtnNewRadioButton.setBounds(80, 166, 65, 23);
        frame.getContentPane().add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_1 = new JRadioButton("女士");
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
            }
        });
        rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.BOLD, 14));
        rdbtnNewRadioButton_1.setBounds(150, 166, 61, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_1);

        JLabel lblNewLabel_3 = new JLabel("联系电话");
        lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_3.setBounds(10, 122, 90, 21);
        frame.getContentPane().add(lblNewLabel_3);

        textField_2 = new JTextField();
        textField_2.setBounds(83, 122, 128, 21);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JButton btnNewButton = new JButton("确定");
        btnNewButton.setIcon(new ImageIcon("src/images/提交.png"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//确认按钮
            	btn_addaddressActionPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton.setBounds(129, 213, 97, 23);
        frame.getContentPane().add(btnNewButton);
    }
    /********************************消息响应函数**********************************/
    /**
     * 新增收货信息
     * */
    private void btn_addaddressActionPerformed(ActionEvent e) {
    	 String usernum = LoginFrame.usernum;
         String contact = textField.getText();
         String address = textField_1.getText();
         String phonenum = textField_2.getText();
         String sex = "";
         if (rdbtnNewRadioButton.isSelected())
             sex = "先生";
         else sex = "女士";
         Receiveaddress newaddress = new Receiveaddress();
         newaddress.usernum = usernum;
         newaddress.contact = contact;
         newaddress.address = address;
         newaddress.phonenum = phonenum;
         newaddress.sex = sex;
         if (contact.equals("") || address.equals("") || phonenum.equals("") || sex.equals(""))
             JOptionPane.showMessageDialog(null, "输入项不能为空", "提示:", JOptionPane.PLAIN_MESSAGE);
         else {
             Receiveaddress.addReceiveAddress(newaddress);
             JOptionPane.showMessageDialog(null, "添加成功", "提示:", JOptionPane.PLAIN_MESSAGE);
             frame.setVisible(false);
             List<Receiveaddress> list = Receiveaddress.getReceiveAddress(LoginFrame.usernum);
       	  	 TableRefresh.refreshReceiveAddressTable(list, MyReceivingInformationFrame.table);
            
         }
    	
    }
}