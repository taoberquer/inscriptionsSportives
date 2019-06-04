package com.tableModel.list;

import java.util.List;

import com.hibernate.entity.Personne;

public class PersonneListTableModel extends ListTableModel {
	
	private static final long serialVersionUID = -8622839069400977036L;
	
	protected List<Personne> list;
	protected String[] columnName = {"Nom", "Prenom", "Email"};
	
	protected PersonneListTableModel() {}
	
	public PersonneListTableModel(List<Personne> passedList) {
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
	        case 1 : return list.get(rowIndex).getPrenom();
	        case 2 : return list.get(rowIndex).getMail();
	    }
	    return null;
	}
}
