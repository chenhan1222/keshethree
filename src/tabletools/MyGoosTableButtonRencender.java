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
        // ��Ӱ�ť��
    }
    private void initButton() {
        this.button = new JButton("+");
        // ���ð�ť�Ĵ�С��λ�á�
        this.button.setBounds(0, 0, 40, 5);
        ;
        this.button.setFont(new Font("����", Font.BOLD, 4));
        // ����Ⱦ�������Ӱ�ť���¼��ǲ��ᴥ����
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
        // ֻΪ��ť��ֵ���ɡ�Ҳ������������������汳���ȡ�
        this.button.setText(value == null ? "" : String.valueOf(value));
        return this.button;
    }
}