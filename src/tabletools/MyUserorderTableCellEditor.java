package tabletools;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import data.Goods;
import data.Order_goods;
public class MyUserorderTableCellEditor extends AbstractCellEditor implements TableCellEditor {
	private static final long serialVersionUID = 1L;
	public List<JComboBox<String>> jboxlist;
	int row;
	public MyUserorderTableCellEditor(JTable table) {
	jboxlist = new ArrayList<JComboBox<String>>();
	int Row = table.getRowCount();
	for (int i = 0; i < Row; i++) {
	    String text = "";
	    String ordernum = table.getValueAt(i, 0).toString();
	    List<Order_goods> ordergoodslist = Order_goods.getOrder_GoodsList(ordernum);
	    int listsize = ordergoodslist.size();
	    String items[] = new String[listsize];
	    for (int j = 0; j < listsize; j++) {
	        String goodsname = Goods.getGoodsName(ordergoodslist.get(j).store_id, ordergoodslist.get(j).goods_id);
	        String price = String.valueOf(Goods.getGoodsPrice(ordergoodslist.get(j).store_id, ordergoodslist.get(j).goods_id));
	        String buynum = String.valueOf(ordergoodslist.get(j).buynum);
	        text = goodsname + " " + price + " " + "X" + buynum;
	        items[j] = text;
	    }
	    JComboBox<String> jbox = new JComboBox<String>(items);
	    jbox.setPreferredSize(new Dimension(200, 25));
	    jbox.setSelectedIndex(0);
	    jboxlist.add(jbox);
	}
	}
	
	@Override
	public boolean isCellEditable(EventObject anEvent) {
		return true;
	}
	
	public void showSave() {
	for (int i = 0; i < jboxlist.size(); i++)
	    jboxlist.get(i).setVisible(true);
	}
	
	public Object getCellEditorValue() {
		String v1 = jboxlist.get(row).getSelectedItem().toString();
		return v1;
	}
	
	public Component getTableCellEditorComponent(JTable table, Object value,boolean isSelected, int row, int column) {
		return this.jboxlist.get(row);
	}
	}
