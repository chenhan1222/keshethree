package tabletools;

import javax.swing.table.DefaultTableModel;

public class MyTuition_feeTableModel  extends DefaultTableModel {
    private static final long serialVersionUID = 2L;
    public boolean isCellEditable(int row, int column) {
        if(column==5)  
        	return true;
        else
        	return false;
    }
}