package com.tableModel.list;

import java.util.List;

import com.hibernate.entity.Competition;


public class CompetitionListTableModel extends ListTableModel{

	private static final long serialVersionUID = 2819014560017359300L;
	
	protected List<Competition> list;
	protected String[] columnName = {"Nom", "Date de cloture"};
	
	protected CompetitionListTableModel() {}
	
	public CompetitionListTableModel(List<Competition> passedList) {
		this.list = passedList;
	}

	@Override
    public int getRowCount() { 
		return list.size(); 
	}
	
    @Override
    public int getColumnCount() { 
    	return columnName.length;
    }

    @Override
    public String getColumnName(int index) {
    	if (columnName.length > index) {
    		return columnName[index];
    	}

        return null;
    }

	@Override
	public Object getValueAt(int rowIndex, int index) {
        switch (index) {
	        case 0 : return list.get(rowIndex).getNom();
	        case 1 : return list.get(rowIndex).getDateCloture().toString();
	    }
	    return null;
	}
}
