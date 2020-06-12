package student_end;
import Login.*;
import javax.swing.*;
import data.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import student_end.StoreFrame;
public class PayFrame {
    public JFrame frame;
    public JTextArea textArea_1;
    public JComboBox<String> comboBox;
    public static String ordernum;
    public static String status="";
    public int store_id;
    /**
     * Create the application.
     */
    public PayFrame() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PayFrame window = new PayFrame();
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
        store_id = CustomerFrame.store_id;
        frame = new JFrame();
        frame.setTitle("\u63D0\u4EA4\u8BA2\u5355");
        frame.setBounds(100, 100, 462, 429);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("选择收货地址");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel.setBounds(10, 29, 98, 37);
        frame.getContentPane().add(lblNewLabel);
        comboBox = new JComboBox<String>();
        comboBox.setFont(new Font("宋体", Font.BOLD, 11));
        comboBox.setBounds(112, 37, 267, 23);
        List<Receiveaddress> addresslist = Receiveaddress.getReceiveAddress(LoginFrame.usernum);
        String[] items = new String[addresslist.size()];
        for (int i = 0; i < addresslist.size(); i++) {
            items[i] = addresslist.get(i).contact + addresslist.get(i).sex + "  " + addresslist.get(i).phonenum + "  " + addresslist.get(i).address;
        }
        comboBox.setModel(new DefaultComboBoxModel<String>(items));
        frame.getContentPane().add(comboBox);

        double sumprice = 0;//总价
        String text = "";//获得购物清单
        for (int i = 0; i < StoreFrame.ordergoodslist.size(); i++) {
            String goodsname = Goods.getGoodsName(StoreFrame.ordergoodslist.get(i).store_id, StoreFrame.ordergoodslist.get(i).goods_id);
            String price = String.valueOf(Goods.getGoodsPrice(StoreFrame.ordergoodslist.get(i).store_id, StoreFrame.ordergoodslist.get(i).goods_id));
            String buynum = String.valueOf(StoreFrame.ordergoodslist.get(i).buynum);
            text = text + goodsname + "     " + price + "     " + "X" + buynum + "\n";
            sumprice += Double.valueOf(price) * Integer.valueOf(buynum);
        }
        JTextArea textArea = new JTextArea(text);
        textArea.setFont(new Font("宋体", Font.BOLD, 14));
        textArea.setWrapStyleWord(true);
        textArea.setRows(10);
        //textArea.setBounds(145, 75, 253, 155);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(115, 75, 240, 145);
        frame.getContentPane().add(scrollPane);

        JLabel lblNewLabel_1 = new JLabel("购买清单：");
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_1.setBounds(10, 136, 70, 23);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("\u5171\u8BA1:");
        lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_2.setBounds(112, 230, 43, 23);
        frame.getContentPane().add(lblNewLabel_2);


        JLabel lblNewLabel_3 = new JLabel(String.valueOf(sumprice) + "元");//总价的标签

        lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_3.setBounds(159, 232, 78, 19);
        frame.getContentPane().add(lblNewLabel_3);

        textArea_1 = new JTextArea();
        textArea_1.setFont(new Font("宋体", Font.BOLD, 14));
        textArea_1.setLineWrap(true);
        textArea_1.setWrapStyleWord(true);
        textArea_1.setBounds(76, 260, 267, 37);
        frame.getContentPane().add(textArea_1);

        JButton btnNewButton = new JButton("提交");//提交按钮
        btnNewButton.setIcon(new ImageIcon("src/images/提交.png"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            
            	btn_commitActionPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton.setBounds(112, 321, 93, 25);
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_4 = new JLabel("备注：");
        lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_4.setBounds(10, 270, 54, 15);
        frame.getContentPane().add(lblNewLabel_4);
    }
    /**************************消息响应函数***************************/
    /**
     * 提交订单
     * */
    private void btn_commitActionPerformed(ActionEvent e) {
    	double total_price=0;
    	for(int i=0;i<StoreFrame.ordergoodslist.size();i++)//获取商品总价格
    		total_price+=StoreFrame.ordergoodslist.get(i).buynum*Goods.getGoodsPrice(StoreFrame.ordergoodslist.get(i).store_id, StoreFrame.ordergoodslist.get(i).goods_id);
    	Userorder userorder = new Userorder();
        ordernum = Userorder.makeOrdernum();//生成订单号
        Order_goods.addorder_goods(ordernum, StoreFrame.ordergoodslist);//添加进入order_goods
        String buytime = Userorder.makeBuytime();//生成下单时间
        String note = textArea_1.getText();
        String orderstatus = "等待用户支付";
        String str;
        str = comboBox.getSelectedItem().toString();
        String[] ss = str.split("  ");
        userorder.setOrdernum(ordernum);
        userorder.setContact(ss[0]);
        userorder.setAddress(ss[2]);
        userorder.setPhonenum(ss[1]);
        userorder.setBuytime(buytime);
        userorder.setNote(note);
        userorder.setOrderstatus(orderstatus);
        userorder.setStore_id(store_id);
        userorder.setUsernum(LoginFrame.usernum);           
        userorder.setTotal_price(total_price);      
        Userorder.addUserorder(userorder);//添加订单
        String total_pricestr=String.valueOf(total_price);//获取总价格
        Store.updateSalesNum(store_id);//更改商店订单数
        String url="http://47.95.200.90:8080/se_wm?";
        String finalurl=url+"ordernum="+ordernum+"&total_price="+total_pricestr;
        Desktop desktop = Desktop.getDesktop();
		try {
			desktop.browse(new URI(finalurl));
		} catch (IOException | URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    frame.dispose();
    }
}

 