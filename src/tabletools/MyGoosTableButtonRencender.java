package tabletools;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyGoosTableButtonRencender implements TableCellRenderer {
    private JButton button;
    public MyGoosTableButtonRencender() {
        this.initButton();
        // 添加按钮。
    }
    private void initButton() {
        this.button = new JButton("+");
        // 设置按钮的大小及位置。
        this.button.setBounds(0, 0, 40, 5);
        ;
        this.button.setFont(new Font("宋体", Font.BOLD, 4));
        // 在渲染器里边添加按钮的事件是不会触发的
        // this.button.addActionListener(new ActionListener()
        // {
        //
        // public void actionPerformed(ActionEvent e)
        // {
        // // TODO Auto-generated method stub
        // }
        // });
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
                                                   int column) {
        // 只为按钮赋值即可。也可以作其它操作，如绘背景等。
        this.button.setText(value == null ? "" : String.valueOf(value));
        return this.button;
    }
}