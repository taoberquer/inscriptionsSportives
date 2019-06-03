package com.tableModel.list;

import java.util.List;

import com.hibernate.entity.Equipe;

public class EquipeListTableModel extends ListTableModel{

	private static final long serialVersionUID = -4167894326762035661L;
	
	protected List<Equipe> list;
	protected String[] columnName = {"Nom", "Nombre personne"};
	
	protected EquipeListTableModel() {}
	
	public EquipeListTableModel(List<Equipe> passedList) {
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
	        case 1 : return list.get(rowIndex).getMembres().size();
	    }
	    return null;
	}
}
