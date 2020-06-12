package tabletools;

import javax.swing.table.DefaultTableModel;

public class MyStore_bindingTableModel extends DefaultTableModel {
    private static final long serialVersionUID = 2L;
    public boolean isCellEditable(int row, int column) {
        if (column == 0 || column==4)
            return true;
        else
            return false;
    }
}