package com.tableModel.list;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public abstract class ListTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 6255482222267671100L;

	public ListTableModel () {
		
	}

    @Override
    public Class<?> getColumnClass(int index) {
    	return String.class; 
	}

    @Override
    public boolean isCellEditable(int rowIndex, int index) {
    	return false;
	}

    @Override
    public abstract Object getValueAt(int rowIndex, int index);

    @Override
    public void setValueAt(Object aValue, int rowIndex, int index) { }

    @Override
    public void addTableModelListener(TableModelListener l) { }

    @Override
    public void removeTableModelListener(TableModelListener l) { }
}
