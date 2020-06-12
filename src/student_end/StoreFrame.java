package student_end;
import data.*;
import Login.LoginFrame;
import control_packet.FrameChange;
import control_packet.TableRefresh;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class StoreFrame {
    public static List<Order_goods> ordergoodslist;//��¼�����е���Ʒ��ź�����
    public JFrame frame;
    private JTable table;
    private JTextField textField001;
    private int store_id;
    private String usernum;
    private JButton btnNewButton_002;
    /**
     * Create the application.
     */
    public StoreFrame() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StoreFrame window = new StoreFrame();
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
        usernum = LoginFrame.usernum;
        store_id = CustomerFrame.store_id;
        
        frame = new JFrame();
        frame.setTitle("��ӭ����" + Store.getStoreName(store_id));//���ñ���
        frame.setBounds(100, 100, 970, 760);
        frame.getContentPane().setLayout(null);

        table = new JTable();
        table.setFont(new Font("����", Font.BOLD, 12));
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        table.setRowHeight(100);
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(718, 500);
        scrollPane.setLocation(10, 180);
        frame.getContentPane().add(scrollPane);

        JLabel lblNewLabel001 = new JLabel("\u8F93\u5165\u5546\u54C1\u540D\uFF1A");
        lblNewLabel001.setFont(new Font("����", Font.BOLD, 16));
        lblNewLabel001.setBounds(10, 51, 97, 19);
        frame.getContentPane().add(lblNewLabel001);

        textField001 = new JTextField();
        textField001.setFont(new Font("����", Font.BOLD, 14));
        textField001.setBounds(150, 50, 138, 21);
        frame.getContentPane().add(textField001);
        textField001.setColumns(10);

        JButton btnNewButton005 = new JButton("����");
        btnNewButton005.setIcon(new ImageIcon("src/images/����.png"));
        btnNewButton005.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    //������Ʒ
            	btn_selectGoodsActionPerformed(e);
            }
        });
        btnNewButton005.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton005.setBounds(335, 49, 111, 25);
        frame.getContentPane().add(btnNewButton005);

        JButton btnNewButton_001 = new JButton("�����Ʒ");
        btnNewButton_001.setIcon(new ImageIcon("src/images/���.png"));
        btnNewButton_001.addActionListener(new ActionListener() {            //��ȡȫ����Ʒ
            public void actionPerformed(ActionEvent e) {
            	btn_getAllGoodsActionPerformed(e);
            }
        });
        btnNewButton_001.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_001.setBounds(10, 18, 111, 25);
        frame.getContentPane().add(btnNewButton_001);

        JButton btnNewButton_100 = new JButton("���빺�ﳵ");
        btnNewButton_100.setIcon(new ImageIcon("src/images/���.png"));
        btnNewButton_100.addActionListener(new ActionListener() {            //���빺�ﳵ��ť
            public void actionPerformed(ActionEvent e) {
            	btn_AddGoodsIntoShoppintlistActionPerformed(e);
            }
        });
        btnNewButton_100.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_100.setBounds(756, 321, 136, 27);
        frame.getContentPane().add(btnNewButton_100);

        btnNewButton_002 = new JButton("");
        if (Student.ifFollow(usernum, store_id))  //�ж��Ƿ����ĳ���̣�������Ӧ��ͼ��
            btnNewButton_002.setIcon(new ImageIcon("src/images/��ע.png"));
        else
            btnNewButton_002.setIcon(new ImageIcon("src/images/δ��ע.png"));
        btnNewButton_002.addActionListener(new ActionListener() {            //��ӹ��ĵĵ���
            public void actionPerformed(ActionEvent e) {
            	btn_addFollowStoreActionPerformed(e);
            }
        });

        btnNewButton_002.setContentAreaFilled(false);
        btnNewButton_002.setFocusPainted(false);
        btnNewButton_002.setBounds(756, 28, 75, 54);
        frame.getContentPane().add(btnNewButton_002);

        JLabel lblNewLabel111 = new JLabel("���棺");
        lblNewLabel111.setFont(new Font("����", Font.BOLD, 16));
        lblNewLabel111.setBounds(33, 108, 58, 19);
        frame.getContentPane().add(lblNewLabel111);

        JButton btnNewButton = new JButton("����");
        btnNewButton.setIcon(new ImageIcon("src/images/����.png"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             //���㰴ť
            	btn_payActionPerformed( e);
            }
        });
        btnNewButton.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton.setBounds(756, 495, 136, 27);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("������");
        btnNewButton_1.setIcon(new ImageIcon("src/images/���ﳵ.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//���ﳵ��ť
              TableRefresh.refreshShoppinListTable(usernum, store_id, table);
            }
        });
        btnNewButton_1.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_1.setBounds(154, 18, 111, 25);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("�ӹ��ﳵɾ��");
        btnNewButton_2.setIcon(new ImageIcon("src/images/�ӹ��ﳵɾ��.png"));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            //�ӹ�������ɾ��
            	btn_deleteGoodsFromShoppintlistActionPerformed(e);
            }
        });
        btnNewButton_2.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_2.setBounds(756, 405, 136, 27);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("��ϵ�̼�");//��ϵ�绰
        btnNewButton_3.setIcon(new ImageIcon("src/images/��ϵ�̼�.png"));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Store.getStorePhone(store_id), "�̼���ϵ�绰:", JOptionPane.PLAIN_MESSAGE);
            }
        });
        btnNewButton_3.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_3.setBounds(309, 18, 111, 25);
        frame.getContentPane().add(btnNewButton_3);

        JTextArea textArea100 = new JTextArea(Store.getNotice(store_id));
        textArea100.setForeground(Color.RED);
        textArea100.setRows(5);
        textArea100.setLineWrap(true);
        textArea100.setFont(new Font("����", Font.BOLD, 16));
        textArea100.setBackground(Color.WHITE);
        textArea100.setBounds(101, 80, 415, 90);
        frame.getContentPane().add(textArea100);

        JButton btnNewButton_4 = new JButton("�鿴����");
        btnNewButton_4.setIcon(new ImageIcon("src/images/�鿴����.png"));
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	btn_lookreviewActionPerformed(e);
            }
        });
        btnNewButton_4.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_4.setBounds(449, 18, 111, 25);
        frame.getContentPane().add(btnNewButton_4);
    }
/********************************��Ϣ��Ӧ����**********************************/
    /**
     * ���ȫ����Ʒ
     * */
    private void btn_getAllGoodsActionPerformed(ActionEvent e) {
    	  List<Goods> goodslist = Goods.getgoods(store_id);
    	  TableRefresh.refreshStudent_GoodsTable(goodslist, table);
    }  
    /**
     * ������Ʒ
     * */
    private void btn_selectGoodsActionPerformed(ActionEvent e) {
    	String Str = textField001.getText();
        List<Goods> goodslist = Goods.getgoods(store_id, Str, Str);
        TableRefresh.refreshStudent_GoodsTable(goodslist, table);
    }
    /**
     * �鿴����
     * */
    private void btn_lookreviewActionPerformed(ActionEvent e) {
    	UserRemarkFrame window = new UserRemarkFrame();
        window.frame.setVisible(true);
        FrameChange.setCenter(window.frame);
    }  
    /**
     * �����Ʒ���빺�ﳵ
     * */
    private void btn_AddGoodsIntoShoppintlistActionPerformed(ActionEvent e) {
     	DefaultTableModel dtm=( DefaultTableModel)table.getModel();	 
     	int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
     	int idcolumn = dtm.findColumn("���");
     	int buynumcolumn = dtm.findColumn("��������");
    	for (int i = 0; i < table.getRowCount(); i++) {
         	String getvalue = table.getValueAt(i, ifselectcolumn).toString(); 	
         	int goods_id = Integer.valueOf(table.getValueAt(i, idcolumn).toString());
             int buynum = Integer.valueOf(table.getValueAt(i, buynumcolumn).toString());
             if (getvalue.equals("true"))
                 Shoppinglist.addShoppinglist(usernum, store_id, goods_id, buynum);
         }
    }  
    /**
     * �ӹ��ﳵ��ɾ����Ʒ
     * */
    private void btn_deleteGoodsFromShoppintlistActionPerformed(ActionEvent e) {
     	DefaultTableModel dtm=( DefaultTableModel)table.getModel();	 
    	int ifselectcolumn = dtm.findColumn("�Ƿ�ѡ��");
     	int idcolumn = dtm.findColumn("���");      
     	for (int i = 0; i < table.getRowCount(); i++) {       	
         	String getvalue = table.getValueAt(i, ifselectcolumn).toString();
             int goods_id = Integer.valueOf(table.getValueAt(i, idcolumn).toString());
             if (getvalue == "true")
                 Shoppinglist.deleteFromShoppinglist(usernum, store_id, goods_id);
         }
         TableRefresh.refreshShoppinListTable(usernum, store_id, table);
    }  
    /**
     * ����
     * */
    private void btn_payActionPerformed(ActionEvent e) {
    	 ordergoodslist = new ArrayList<Order_goods>();
         DefaultTableModel model = (DefaultTableModel) table.getModel();
         int sfxzcolumn = model.findColumn("�Ƿ�ѡ��");//��ñ������Ƿ�ѡ�е���
         int gmslcolumn = model.findColumn("��������");//��ñ����ǹ�����������
         for (int i = 0; i < table.getRowCount(); i++) {
             String value = table.getValueAt(i, sfxzcolumn).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
             int goods_id = Integer.valueOf(table.getValueAt(i, 0).toString());
             int buynum = Integer.valueOf(table.getValueAt(i, gmslcolumn).toString());
             if (value.equals("true")) {
                 Order_goods order_goods = new Order_goods();
                 order_goods.store_id = store_id;
                 order_goods.goods_id = goods_id;
                 order_goods.buynum = buynum;
                 ordergoodslist.add(order_goods);
               
             }
         }
         PayFrame window = new PayFrame();
         window.frame.setVisible(true);
         FrameChange.setCenter(window.frame);
    }  
    /**
     * ��ӹ��ĵĵ���
     * */
    private void btn_addFollowStoreActionPerformed(ActionEvent e) {
    	 if (!Student.ifFollow(usernum, store_id)) {
         	Student.addUserfollow(usernum, store_id);
             btnNewButton_002.setIcon(new ImageIcon("src/images/��ע.png"));
         } else {
         	Student.deleteUserfollow(usernum, store_id);
             btnNewButton_002.setIcon(new ImageIcon("src/images/δ��ע.png"));
         }
    }
}
