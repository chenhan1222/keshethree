package tabletools;

import javax.swing.table.DefaultTableModel;

/**
 * 自定义收获信息表
 * */
public class MyReceiveAddressTableModel  extends DefaultTableModel {
    private static final long serialVersionUID = 2L;
    public boolean isCellEditable(int row, int column) {
        if (column == 0)
            return false;
        else
            return true;
    }
}