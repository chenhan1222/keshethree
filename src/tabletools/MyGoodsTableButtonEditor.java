package tabletools;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class MyGoodsTableButtonEditor extends DefaultCellEditor {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6546334664166791132L;
    private JButton button;
    public  MyGoodsTableButtonEditor(JTable table) {
        // DefautlCellEditor有此构造器，需要传入一个，但这个不会使用到，直接new一个即可。
        super(new JTextField());

        // 设置点击几次激活编辑。
        this.setClickCountToStart(1);
        this.initButton(table);
    }

    private void initButton(JTable table) {
        this.button = new JButton("+");
        this.button.setFont(new Font("宋体", Font.BOLD, 4));
        //  button.setIcon(icon);
        // 设置按钮的大小及位置。
        this.button.setBounds(0, 0, 40, 5);
        // ImageIcon icon=new ImageIcon("icon/添加.gif");
        // icon.setImage(icon.getImage().getScaledInstance(30,7,Image.SCALE_DEFAULT ));
        // this.button.setIcon(icon);
        // 为按钮添加事件。这里只能添加ActionListner事件，Mouse事件无效。
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 触发取消编辑的事件，不会调用tableModel的setValue方法。
            	MyGoodsTableButtonEditor.this.fireEditingCanceled();

                // 这里可以做其它操作。
                // 可以将table传入，通过getSelectedRow,getSelectColumn方法获取到当前选择的行和列及其它操作等。
                int i = table.getSelectedRow();//获得选中行
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int column = model.findColumn("购买数量");
                int buynum = Integer.valueOf(table.getValueAt(i, column).toString());
                table.setValueAt(buynum + 1, i, column);
                //JOptionPane.showMessageDialog(null, "您还没有注册商店请先进行注册！", "提示", JOptionPane.PLAIN_MESSAGE);
            }

        });

    }
    /**
     * 这里重写父类的编辑方法，返回一个JPanel对象即可（也可以直接返回一个Button对象，但是那样会填充满整个单元格）
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // 只为按钮赋值即可。也可以作其它操作。
        this.button.setText(value == null ? "" : String.valueOf(value));

        return this.button;
    }
    /**
     * 重写编辑单元格时获取的值。如果不重写，这里可能会为按钮设置错误的值。
     */
    @Override
    public Object getCellEditorValue() {
        return this.button.getText();
    }

    public boolean isCellEditable(int row, int column) {
        // 带有按钮列的功能这里必须要返回true不然按钮点击时不会触发编辑效果，也就不会触发事件。
        if (column == 6) {
            return true;
        } else {
            return false;
        }
    }
}