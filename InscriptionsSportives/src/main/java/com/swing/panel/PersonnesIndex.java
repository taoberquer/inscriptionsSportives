package com.swing.panel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import com.hibernate.entity.Inscriptions;
import com.hibernate.entity.Personne;
import com.swing.jPanel.JPanelCreate;
import com.swing.jPanel.JPanelCreatePersonne;
import com.swing.jPanel.JPanelEdit;
import com.swing.jPanel.JPanelEditPersonne;
import com.tableModel.list.PersonneListTableModel;

public class PersonnesIndex extends IndexTemplate{
	
	private static final long serialVersionUID = 8058606645859099078L;

	public PersonnesIndex() {
		super();
	}
	
	public PersonnesIndex(JFrameTemplate parentJFrame) {
		super(parentJFrame);
	}
	
	protected void setTitle() {
		super.setTitle(super.title + " - Personnes");
	}

	@Override
	protected JTable getTableContent() {
		this.table = new JTable(new PersonneListTableModel(getListTable()));
		
		return this.table;
	}

	protected List<Personne> getListTable() {
		return new ArrayList<>(Inscriptions.getInscriptions().getPersonnes());
	}
	
	protected void update() {
		table.setModel(new PersonneListTableModel(getListTable()));
	}

	@Override
	protected void deleteSelectedRow(int index) {
		Personne personne = getListTable().get(table.getSelectedRow());
		personne.delete();	
	}

	@Override
	protected JPanelEdit getJPanelEdit() {
		Personne personne = getListTable().get(table.getSelectedRow());
		return new JPanelEditPersonne(personne);		
	}

	@Override
	protected JPanelCreate getJPanelCreate() {
		return new JPanelCreatePersonne();
	}

}
