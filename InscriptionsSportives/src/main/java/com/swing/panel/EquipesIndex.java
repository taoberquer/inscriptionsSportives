package com.swing.panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EquipesIndex extends JFrameTemplate {

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
}
