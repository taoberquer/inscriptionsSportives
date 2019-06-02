package com.swing.panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CompetitionsIndex extends JFrameTemplate {

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

}
