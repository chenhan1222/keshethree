package student_end;
import data.*;
import Login.LoginFrame;
import control_packet.FrameChange;
import control_packet.TableRefresh;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class CustomerFrame {
    public static int store_id;//������¼ѡ�е��̵��
    public JFrame customerframe;
    //private JTable table_001;
    private JTable table;
    private JTextField textField;

    /**
     * Create the application.
     */
    public CustomerFrame() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerFrame window = new CustomerFrame();
                    window.customerframe.setVisible(true);
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
        customerframe = new JFrame();
        customerframe.getContentPane().setFont(new Font("����", Font.BOLD, 16));
        customerframe.setBounds(100, 100, 942, 558);
        customerframe.getContentPane().setLayout(null);
        FrameChange.setCenter(customerframe);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(704, 363);
        scrollPane.setLocation(10, 58);
        customerframe.getContentPane().add(scrollPane);
        List<Store>stores=Store.getstores();
        TableRefresh.refreshStoresTable(stores, table);

        JButton btnNewButton_1 = new JButton("����");
        btnNewButton_1.setIcon(new ImageIcon("src/images/����.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 btn_enterStoreActionPerformed(e);      
            }
        });
        btnNewButton_1.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_1.setBounds(738, 234, 100, 30);
        customerframe.getContentPane().add(btnNewButton_1);

        JMenuBar menuBar = new JMenuBar();
        customerframe.setJMenuBar(menuBar);
        JLabel lblNewLabel = new JLabel("�������̼���:");
        menuBar.add(lblNewLabel);
        lblNewLabel.setFont(new Font("����", Font.BOLD, 16));

        textField = new JTextField();
        menuBar.add(textField);
        textField.setFont(new Font("����", Font.BOLD, 16));
        textField.setColumns(10);
        
                JMenuItem mntmNewMenuItem_2 = new JMenuItem("������Search��");
                mntmNewMenuItem_2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	btn_searchStoreActionPerformed( e);
                    }
                });
                mntmNewMenuItem_2.setFont(new Font("����", Font.BOLD, 16));
                menuBar.add(mntmNewMenuItem_2);
        

        JMenu mnNewMenu = new JMenu("����Sort��");
        mnNewMenu.setBounds(10, 0, 100, 100);
        menuBar.add(mnNewMenu);
        mnNewMenu.setFont(new Font("����", Font.BOLD, 16));

        JMenuItem mntmNewMenuItem = new JMenuItem("����������");
        mntmNewMenuItem.setFont(new Font("����", Font.BOLD, 16));
        mntmNewMenuItem.addActionListener(new ActionListener() {//����������
            public void actionPerformed(ActionEvent e) {
            	TableRefresh.refreshStoresTable(Store.sqlSortByGrade(), table);
            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("������������");
        mntmNewMenuItem_1.setFont(new Font("����", Font.BOLD, 16));
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    //������������
            	TableRefresh.refreshStoresTable(Store.sqlSortByMonthsale(), table);
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenu mnNewMenu_1 = new JMenu("�û�����Manage��");
        mnNewMenu_1.setFont(new Font("����", Font.BOLD, 16));
        menuBar.add(mnNewMenu_1);


        JMenuItem mntmNewMenuItem_4 = new JMenuItem("�ҵ��ջ���Ϣ");
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	btn_myReceiveActionPerformed(e);

            }
        });
        mntmNewMenuItem_4.setFont(new Font("����", Font.BOLD, 16));
        mnNewMenu_1.add(mntmNewMenuItem_4);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("�ҵĹ�ע");
        mnNewMenu_1.add(mntmNewMenuItem_3);
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//�ҵĹ�ע
            	btn_myFollowStoreActionPerformed(e);
            }
        });
        mntmNewMenuItem_3.setFont(new Font("\u5B8B\u4F53", mntmNewMenuItem_3.getFont().getStyle() | Font.BOLD, mntmNewMenuItem_3.getFont().getSize() + 4));

        JMenuItem menuItem = new JMenuItem("�ҵĶ���");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//�ҵĶ���
            	btn_myOrderActionPerformed(e);
            }
        });
        menuItem.setFont(new Font("����", Font.BOLD, 16));
        mnNewMenu_1.add(menuItem);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("ˢ�£�Refresh��");
        mntmNewMenuItem_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//ˢ��          	 
                  TableRefresh.refreshStoresTable(Store.getstores(), table);
            }
        });
        mntmNewMenuItem_5.setFont(new Font("����", Font.BOLD, 16));
        menuBar.add(mntmNewMenuItem_5);
    }
    /********************************��Ϣ��Ӧ����**********************************/
    /**
     * ����ĳ�̵�
     * */
    private void btn_enterStoreActionPerformed(ActionEvent e) {
    	DefaultTableModel dtm=(DefaultTableModel) table.getModel();	
    	int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
    	int store_idcolumn= dtm.findColumn("���");
    	for (int i = 0; i < table.getRowCount(); i++) {
              String value = table.getValueAt(i, ifselectcolumn).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
              int store_id = Integer.valueOf(table.getValueAt(i, store_idcolumn).toString());
              if (value == "true") {
                  CustomerFrame.store_id = store_id;
                  //����ѡ���̵��Ĵ���
                  StoreFrame window = new StoreFrame();
                  window.frame.setVisible(true);
                  FrameChange.setCenter(window.frame);
              }
          }	
    }
    /**
     * �����̵�
     * */
    private void btn_searchStoreActionPerformed(ActionEvent e) {
    	String storename = textField.getText();
        List<Store> stores = Store.getstores(storename);
        TableRefresh.refreshStoresTable(stores, table);
    }
    /**
     * �ҹ�ע���̵�
     * */
    private void btn_myFollowStoreActionPerformed(ActionEvent e) {
    	 List<Store> stores = Student.getYourFollwStores(LoginFrame.usernum);     
        TableRefresh.refreshStoresTable(stores, table);
    }
    /**
     * �ҵĶ���
     * */
    private void btn_myOrderActionPerformed(ActionEvent e) {
    	MyOrderFrame window = new MyOrderFrame();
        window.frame.setVisible(true);
        FrameChange.setCenter(window.frame);
   }
    /**
     * �ҵ��ջ���Ϣ
     * */
    private void btn_myReceiveActionPerformed(ActionEvent e) {
    	  MyReceivingInformationFrame window = new MyReceivingInformationFrame();
          window.frame.setVisible(true);
          FrameChange.setCenter(window.frame);
   }
}
