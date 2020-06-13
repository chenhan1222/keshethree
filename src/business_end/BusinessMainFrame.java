package business_end;

import Login.LoginFrame;
import control_packet.FrameChange;
import control_packet.ImageDemo;
import control_packet.ImageUtil;
import control_packet.TableRefresh;
import data.Goods;
import data.Store;
import data.Userorder;
import tabletools.MyGoodsTableImageModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Timer;
import java.util.*;
public class BusinessMainFrame {
    public JFrame businessframe;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JComboBox<String> comboBox ;

    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private String DEFAULT_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";//日期格式
    private String time;
    private int ONE_SECOND = 1000;
    private int store_id ;

    /**
     * Create the application.
     */
    public BusinessMainFrame() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BusinessMainFrame window = new BusinessMainFrame();
                    window.businessframe.setVisible(true);
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
        store_id= LoginFrame.store_id;
        businessframe = new JFrame();
        businessframe.setBounds(100, 100, 1073, 763);
        businessframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        businessframe.setLocationRelativeTo(null);
        businessframe.getContentPane().setLayout(null);

        MyGoodsTableImageModel dtm = new  MyGoodsTableImageModel();
        table = new JTable(dtm);
        table.setFont(new Font("宋体", Font.BOLD, 15));

        RowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(dtm);
        table.setRowSorter(rowSorter);// 给 表格 设置 行排序器
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(1023, 512);
        scrollPane.setLocation(10, 174);

        businessframe.getContentPane().add(scrollPane, BorderLayout.CENTER);
        List<Goods> goodslist = Goods.getgoods(store_id);
        TableRefresh.refreshStore_GoodsTable(goodslist, table);

        JButton btnNewButton = new JButton("全部菜品");
        btnNewButton.setIcon(new ImageIcon("src/images/浏览.png"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    //全部商品
                btn_getAllGoodsActionPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton.setBounds(10, 10, 127, 25);
        businessframe.getContentPane().add(btnNewButton);

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.ITALIC, 16));
        textField.setText("输入品类或者名称");
        textField.setBounds(147, 10, 153, 25);
        businessframe.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton_1 = new JButton("搜索");
        btnNewButton_1.setIcon(new ImageIcon("src/images/搜索.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {        //搜索功能
                btn_selectGoodsActionPerformed(e) ;
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_1.setBounds(330, 10, 127, 25);
        businessframe.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("修改商品信息");
        btnNewButton_2.setIcon(new ImageIcon("src/images/修改.png"));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//修改商品属性，商品号不可修改
                btn_modifyGoodsActionPerformed(e);
            }
        });
        btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_2.setBounds(330, 61, 161, 25);
        businessframe.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_4 = new JButton("修改信息");
        btnNewButton_4.setIcon(new ImageIcon("src/images/修改.png"));
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_modifyStoreActionPerformed(e);
            }
        });
        btnNewButton_4.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_4.setBounds(162, 61, 128, 25);
        businessframe.getContentPane().add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("今日销售");
        btnNewButton_5.setIcon(new ImageIcon("src/images/钱.png"));
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_todaySaleActionPerformed(e);
            }
        });
        btnNewButton_5.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_5.setBounds(10, 61, 127, 25);
        businessframe.getContentPane().add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("订单管理");
        btnNewButton_6.setIcon(new ImageIcon("src/images/订单管理.png"));
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_orderManageActionPerformed(e);
            }
        });
        btnNewButton_6.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_6.setBounds(10, 112, 127, 25);
        businessframe.getContentPane().add(btnNewButton_6);

        JButton btnNewButton_8 = new JButton("用户评论");
        btnNewButton_8.setIcon(new ImageIcon("src/images/查看评论.png"));
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StoreReplyframe window = new  StoreReplyframe ();
                window.frame.setVisible(true);
                FrameChange.setCenter(window.frame);
            }
        });
        btnNewButton_8.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_8.setBounds(162, 112, 127, 25);
        businessframe.getContentPane().add(btnNewButton_8);

        JLabel lblNewLabel_3 = new JLabel("我的评分");//我的评分：
        lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel_3.setBounds(740, 91, 142, 36);
        businessframe.getContentPane().add(lblNewLabel_3);

        java.text.DecimalFormat   df=new   java.text.DecimalFormat("#.##");
        JLabel lblNewLabel_4 = new JLabel(String.valueOf(df.format(Store.getGrade(store_id))));
        //JLabel lblNewLabel_4 = new JLabel("5");
        lblNewLabel_4.setForeground(new Color(255, 51, 0));
        lblNewLabel_4.setBackground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 60));
        lblNewLabel_4.setBounds(902, 75, 114, 77);
        businessframe.getContentPane().add(lblNewLabel_4);


        lblNewLabel_5 = new JLabel();//动态时钟显示
        lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 20));
        lblNewLabel_5.setBounds(708, 6, 309, 30);
        businessframe.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_7 = new JLabel("上传图片预览");//上传图片预览
        lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 16));
        lblNewLabel_7.setBounds(570, 10, 114, 25);
        businessframe.getContentPane().add(lblNewLabel_7);

        JButton btnNewButton_3 = new JButton("删除商品");//删除商品
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_deleteGoodsActionPerformed( e);
            }
        });
        btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 16));
        btnNewButton_3.setBounds(330, 112, 127, 25);
        businessframe.getContentPane().add(btnNewButton_3);

        lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setBounds(580, 45, 100, 100);
        businessframe.getContentPane().add(lblNewLabel_6);

        JMenuBar menuBar = new JMenuBar();
        businessframe.setJMenuBar(menuBar);

        JLabel lblNewLabel = new JLabel("请输入商品名");//请输入商品名：
        menuBar.add(lblNewLabel);
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));

        textField_1 = new JTextField();
        menuBar.add(textField_1);
        textField_1.setFont(new Font("宋体", Font.BOLD, 14));
        textField_1.setColumns(30);

        JLabel lblNewLabel_1 = new JLabel("请选择品类：");
        menuBar.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));

        comboBox = new JComboBox<String>();
        comboBox.setMaximumRowCount(15);
        menuBar.add(comboBox);
        comboBox.setFont(new Font("宋体", Font.BOLD, 14));
        comboBox.setEditable(true);
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[]{"主食", "热菜", "凉菜", "饮料", "青菜", "肉食", "小料", "套餐"}));

        JLabel lblNewLabel_2 = new JLabel("请输入价格：");
        menuBar.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));

        textField_2 = new JTextField();
        menuBar.add(textField_2);
        textField_2.setFont(new Font("宋体", Font.BOLD, 14));
        textField_2.setColumns(30);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("上传图片");//上传图片
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_addImgActionPerformed(e);
            }
        });
        mntmNewMenuItem_1.setFont(new Font("宋体", Font.BOLD, 14));
        menuBar.add(mntmNewMenuItem_1);
        //添加商品按钮
        JMenuItem mntmNewMenuItem = new JMenuItem(" \u6DFB\u52A0\u5546\u54C1         ");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_addGoodsActionPerformed(e);
            }
        });
        mntmNewMenuItem.setFont(new Font("宋体", Font.BOLD, 14));
        menuBar.add(mntmNewMenuItem);
        Timer tmr = new Timer();
        tmr.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), ONE_SECOND);
    }
/*******************************************消息响应函数********************************************/
    /**
     * 获取全部商品
     * */
    private void btn_getAllGoodsActionPerformed(ActionEvent e) {
        List<Goods> goodslist = Goods.getgoods(store_id);
        TableRefresh.refreshStore_GoodsTable(goodslist, table);
    }
    /**
     * 搜索商品
     * */
    private void btn_selectGoodsActionPerformed(ActionEvent e) {
        String Str = textField.getText();
        List<Goods> goodslist = Goods.getgoods(store_id, Str, Str);
        TableRefresh.refreshStore_GoodsTable(goodslist, table);
    }
    /**
     * 添加商品
     * */
    private void btn_addGoodsActionPerformed(ActionEvent e) {
        try {
            String name = textField_1.getText();
            String type = comboBox.getSelectedItem().toString();
            double price = Double.valueOf(textField_2.getText());
            Image image=((ImageIcon) lblNewLabel_6.getIcon()).getImage();
            File outputfile = new File("D:\\java图标store.jpg");//存储商家上传的图片
            if (!outputfile.exists() && !outputfile.isDirectory()) {
                System.out.println("文件夹路径不存在，创建路径:");
                outputfile.mkdirs();
            } else {
                System.out.println("文件夹路径存在:");
            }
            ImageIO.write(ImageDemo.toBufferedImage(image), "jpg", outputfile);
            FileInputStream in = ImageUtil.readImage("D:\\java图标store.jpg");

            if (name.length() == 0 || type.length() == 0 ||textField_2.getText().length()==0)
                JOptionPane.showMessageDialog(null, "输入不能为空！");
            else {
                Store.addGoods(store_id, name, type, price,in);
                JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.PLAIN_MESSAGE);
                List<Goods> goodslist = Goods.getgoods(store_id);
                TableRefresh.refreshStore_GoodsTable(goodslist, table);
            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "添加失败,输入格式错误！", "提示", JOptionPane.PLAIN_MESSAGE);
        }
        textField_1.setText("");
        textField_2.setText("");
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[]{"主食", "热菜", "凉菜", "饮料", "青菜", "肉食", "小料", "套餐"}));
    }
    /**
     * 删除商品
     * */
    private void btn_deleteGoodsActionPerformed(ActionEvent e) {
        MyGoodsTableImageModel dtm=(MyGoodsTableImageModel)table.getModel();
        int ifselectcolumn = dtm.findColumn("是否选中");//获得对应列号
        int goods_idcolumn=dtm.findColumn("编号");//获得对应列号
        for (int i = 0; i < table.getRowCount(); i++) {
            int goods_id = Integer.valueOf(table.getValueAt(i, goods_idcolumn).toString());
            String value = table.getValueAt(i, ifselectcolumn).toString();//读取你获取行号的某一列的值（也就是字段）
            if (value == "true") {
                Store.DeleteyGoods(store_id, goods_id);
            }
        }
        List<Goods> goodslist = Goods.getgoods(store_id);
        TableRefresh.refreshStore_GoodsTable(goodslist, table);
    }
    /**
     * 修改商品信息
     * */
    private void btn_modifyGoodsActionPerformed(ActionEvent e) {
        MyGoodsTableImageModel dtm=(MyGoodsTableImageModel)table.getModel();
        int ifselectcolumn = dtm.findColumn("是否选中");//获得对应列号
        int goods_idcolumn=dtm.findColumn("编号");//获得对应列号
        int goods_namecolumn=dtm.findColumn("名称");//获得对应列号
        int typecolumn=dtm.findColumn("种类");
        int pricecolunm=dtm.findColumn("价格");
        int salesnumcolumn=dtm.findColumn("销售量");
        for (int i = 0; i < table.getRowCount(); i++) {
            int goods_id = Integer.valueOf(table.getValueAt(i, goods_idcolumn).toString());
            String goodsname = table.getValueAt(i, goods_namecolumn).toString();
            String type = table.getValueAt(i, typecolumn).toString();
            double price = Double.valueOf(table.getValueAt(i, pricecolunm).toString());
            int salesnum = Integer.valueOf(table.getValueAt(i, salesnumcolumn).toString());
            String value = table.getValueAt(i, ifselectcolumn).toString();//读取你获取行号的某一列的值（也就是字段）
            if (value == "true") {
                Goods newgoods = new Goods();
                newgoods.goods_id = goods_id;
                newgoods.name = goodsname;
                newgoods.type = type;
                newgoods.price = price;
                newgoods.salesnum = salesnum;
                Store.modifyGoods(store_id, goods_id, newgoods);
            }
        }
    }
    /**
     * 今日销售
     * */
    private void btn_todaySaleActionPerformed(ActionEvent e) {
        String Lable1 = "今日订单数(单)：";
        String Lable2 = "今日已完成订单数(单)：";
        String Lable3 = "今日收入(元)：";
        int dayordersalenum = Userorder.getDayAllOrderSaleNum(store_id);
        int dayfinishordersalenum = Userorder.getDayFinishOrderSaleNum(store_id);
        double dayincome = Userorder.getDayIncome(store_id);
        String Lable4 = Lable1 + String.valueOf(dayordersalenum) + "\n";
        String Lable5 = Lable2 + String.valueOf(dayfinishordersalenum) + "\n";
        String Lable6 = Lable3 + String.valueOf(dayincome);
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.BOLD, 16)));//设置字体
        JOptionPane.showMessageDialog(null, Lable4 + Lable5 + Lable6, "今日营业情况：", JOptionPane.PLAIN_MESSAGE);
    }
    /**
     * 修改商店信息
     * */
    private void btn_modifyStoreActionPerformed(ActionEvent e) {
        ModifyStoreFrame window=new ModifyStoreFrame();
        FrameChange.setCenter(window.frame);
        window.frame.setVisible(true);

    }
    /**
     * 订单管理模块
     * */
    private void btn_orderManageActionPerformed(ActionEvent e) {
        StoreorderFrame window = new StoreorderFrame();
        window.frame.setVisible(true);
        FrameChange.setCenter(window.frame);
    }
    /**
     * 本地上传图片
     * */
    private void btn_addImgActionPerformed(ActionEvent e) {

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
            //int x=91,y=10;
            int width = 100, height = 100;
            ImageIcon image = new ImageIcon(f.getPath());
            image.setImage(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
            lblNewLabel_6.setIcon(image);
        } catch (Exception e2) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "添加图片失败！");
            return;
        }

    }
    protected class JLabelTimerTask extends TimerTask {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(
                DEFAULT_TIME_FORMAT);

        @Override
        public void run() {
            time = dateFormatter.format(Calendar.getInstance().getTime());
            lblNewLabel_5.setText(time);
        }
    }
}


