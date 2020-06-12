package management_end;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.Store;
public class Store_bindingFrame {
    public JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextArea textArea006;

    /**
     * Create the application.
     */
    public Store_bindingFrame(String usernum) {
        initialize(usernum);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Store_bindingFrame window = new Store_bindingFrame("1235");
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
    private void initialize(String usernum) {
        frame = new JFrame();
        frame.setTitle("商店绑定");
        frame.setBounds(100, 100, 478, 478);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("商店名：");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel.setBounds(23, 61, 80, 29);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(102, 65, 143, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("商店地址");
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_1.setBounds(23, 120, 80, 21);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(101, 120, 144, 21);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("电话：");
        lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_2.setBounds(23, 180, 70, 21);
        frame.getContentPane().add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds(101, 180, 143, 21);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("公告：");
        lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_3.setBounds(23, 238, 54, 15);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("店主账号：");
        lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_4.setBounds(23, 10, 93, 31);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel(usernum);
        lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_5.setBounds(138, 10, 174, 31);
        frame.getContentPane().add(lblNewLabel_5);


        textArea006 = new JTextArea();
        textArea006.setFont(new Font("宋体", Font.BOLD, 14));
        textArea006.setWrapStyleWord(true);
        textArea006.setLineWrap(true);
        textArea006.setBounds(102, 238, 276, 98);
        frame.getContentPane().add(textArea006);

        JButton btnNewButton_1 = new JButton("绑定");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//绑定商店              
                    String storename = textField.getText();
                    String address = textField_1.getText();
                    String storephone = textField_2.getText();
                    String notice = textArea006.getText();
                    Store.addStore(usernum, storename, notice, address, storephone);
                    JOptionPane.showMessageDialog(null, "绑定成功！", "提示", JOptionPane.PLAIN_MESSAGE);
                    frame.setVisible(false);
                  
         
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton_1.setBounds(179, 375, 93, 23);
        frame.getContentPane().add(btnNewButton_1);
    }
}
