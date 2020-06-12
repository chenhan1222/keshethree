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
        // DefautlCellEditor�д˹���������Ҫ����һ�������������ʹ�õ���ֱ��newһ�����ɡ�
        super(new JTextField());

        // ���õ�����μ���༭��
        this.setClickCountToStart(1);
        this.initButton(table);
    }

    private void initButton(JTable table) {
        this.button = new JButton("+");
        this.button.setFont(new Font("����", Font.BOLD, 4));
        //  button.setIcon(icon);
        // ���ð�ť�Ĵ�С��λ�á�
        this.button.setBounds(0, 0, 40, 5);
        // ImageIcon icon=new ImageIcon("icon/���.gif");
        // icon.setImage(icon.getImage().getScaledInstance(30,7,Image.SCALE_DEFAULT ));
        // this.button.setIcon(icon);
        // Ϊ��ť����¼�������ֻ�����ActionListner�¼���Mouse�¼���Ч��
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ����ȡ���༭���¼����������tableModel��setValue������
            	MyGoodsTableButtonEditor.this.fireEditingCanceled();

                // �������������������
                // ���Խ�table���룬ͨ��getSelectedRow,getSelectColumn������ȡ����ǰѡ����к��м����������ȡ�
                int i = table.getSelectedRow();//���ѡ����
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int column = model.findColumn("��������");
                int buynum = Integer.valueOf(table.getValueAt(i, column).toString());
                table.setValueAt(buynum + 1, i, column);
                //JOptionPane.showMessageDialog(null, "����û��ע���̵����Ƚ���ע�ᣡ", "��ʾ", JOptionPane.PLAIN_MESSAGE);
            }

        });

    }
    /**
     * ������д����ı༭����������һ��JPanel���󼴿ɣ�Ҳ����ֱ�ӷ���һ��Button���󣬵��������������������Ԫ��
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // ֻΪ��ť��ֵ���ɡ�Ҳ����������������
        this.button.setText(value == null ? "" : String.valueOf(value));

        return this.button;
    }
    /**
     * ��д�༭��Ԫ��ʱ��ȡ��ֵ���������д��������ܻ�Ϊ��ť���ô����ֵ��
     */
    @Override
    public Object getCellEditorValue() {
        return this.button.getText();
    }

    public boolean isCellEditable(int row, int column) {
        // ���а�ť�еĹ����������Ҫ����true��Ȼ��ť���ʱ���ᴥ���༭Ч����Ҳ�Ͳ��ᴥ���¼���
        if (column == 6) {
            return true;
        } else {
            return false;
        }
    }
}