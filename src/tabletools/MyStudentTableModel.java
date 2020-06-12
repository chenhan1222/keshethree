package tabletools;

import javax.swing.table.DefaultTableModel;

public class MyStudentTableModel extends DefaultTableModel {
    private static final long serialVersionUID = 2L;
    public boolean isCellEditable(int row, int column) {
        if (column == 0)
            return false;
        else
            return true;
    }
}