package tabletools;
import javax.swing.table.DefaultTableModel;
/**
 * �Զ�����
 * */
public class MyGoodsTableImageModel extends DefaultTableModel {
    private static final long serialVersionUID = 1L;
    public boolean isCellEditable(int row, int column) {
        if (column == 0 || column == 1||column == 4)
            return false;
        else
            return true;
    }
}