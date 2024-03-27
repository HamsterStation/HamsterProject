package kcb;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class KCBdata implements TableModel {
	private String[] tableTitle = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	private String[][] lessons = new String[8][7];
	
	public KCBdata() {
		for(int i = 0;i<lessons.length;i++) {
			for(int j = 0;j<lessons[i].length;j++) {
				lessons[i][j]=" ";
			}
		}
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return tableTitle[columnIndex];
	}
 
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return lessons[rowIndex][columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		lessons[rowIndex][columnIndex] = (String)aValue; 

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
