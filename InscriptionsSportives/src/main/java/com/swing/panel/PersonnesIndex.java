package com.swing.panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PersonnesIndex extends JFrameTemplate{
	
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

}
