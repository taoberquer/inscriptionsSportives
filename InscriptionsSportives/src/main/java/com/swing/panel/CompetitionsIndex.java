package com.swing.panel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;

import com.hibernate.entity.Competition;
import com.hibernate.entity.Inscriptions;
import com.swing.jPanel.JPanelCreate;
import com.swing.jPanel.JPanelCreateCompetition;
import com.swing.jPanel.JPanelEdit;
import com.swing.jPanel.JPanelEditCompetition;
import com.tableModel.list.CompetitionListTableModel;

public class CompetitionsIndex extends IndexTemplate {

	private static final long serialVersionUID = 3922912440270483462L;
	
	protected String activeMenulLabel = "Competitions";

	public CompetitionsIndex() {
		super();
	}
	
	public CompetitionsIndex(JFrameTemplate parentJFrame) {
		super(parentJFrame);
	}
	
	protected void setTitle() {
		super.setTitle(super.title + " - Competitions");
	}

	@Override
	protected JTable getTableContent() {
		this.table = new JTable(new CompetitionListTableModel(getListTable()));
		
		return this.table;
	}

	protected List<Competition> getListTable() {
		if (isConected() && !isAdmin()) {
			return new ArrayList<Competition>(connectedUser.getCompetitions());			
		}
		
		return new ArrayList<>(Inscriptions.getInscriptions().getCompetitions());
	}
	
	protected void update() {
		table.setModel(new CompetitionListTableModel(getListTable()));
	}

	@Override
	protected void deleteSelectedRow(int index) {
		Competition competition = getListTable().get(table.getSelectedRow());
		competition.delete();	
	}

	@Override
	protected JPanelEdit getJPanelEdit() {
		Competition competition = getListTable().get(table.getSelectedRow());
		return new JPanelEditCompetition(competition);		
	}

	@Override
	protected JPanelCreate getJPanelCreate() {
		return new JPanelCreateCompetition();
	}
	

}
