package com.swing.panel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import com.hibernate.entity.Equipe;
import com.hibernate.entity.Inscriptions;
import com.swing.jPanel.JPanelCreate;
import com.swing.jPanel.JPanelCreateEquipe;
import com.swing.jPanel.JPanelEdit;
import com.swing.jPanel.JPanelEditEquipe;
import com.tableModel.list.EquipeListTableModel;

public class EquipesIndex extends IndexTemplate {

	private static final long serialVersionUID = -5224176235056597162L;
	
	protected String activeMenulLabel = "Equipes";

	public EquipesIndex() {
		super();
	}
	
	public EquipesIndex(JFrameTemplate parentJFrame) {
		super(parentJFrame);
	}

	protected void setTitle() {
		super.setTitle(super.title + " - Equipes");
	}

	@Override
	protected JTable getTableContent() {
		this.table = new JTable(new EquipeListTableModel(getListTable()));
		
		return this.table;
	}

	protected List<Equipe> getListTable() {
		return new ArrayList<>(Inscriptions.getInscriptions().getEquipes());
	}
	
	protected void update() {
		table.setModel(new EquipeListTableModel(getListTable()));
	}

	@Override
	protected void deleteSelectedRow(int index) {
		Equipe equipe = getListTable().get(table.getSelectedRow());
		equipe.delete();	
	}

	@Override
	protected JPanelEdit getJPanelEdit() {
		Equipe equipe = getListTable().get(table.getSelectedRow());
		return new JPanelEditEquipe(equipe);		
	}

	@Override
	protected JPanelCreate getJPanelCreate() {
		return new JPanelCreateEquipe();
	}
}
