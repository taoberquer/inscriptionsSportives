package com.swing.panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Home extends JFrameTemplate {

	private static final long serialVersionUID = -2350059206384737088L;

	public Home() {
		super();
	}
	
	public Home(JFrameTemplate parentJFrame) {
		super(parentJFrame);
	}
	
	protected void setTitle() {
		super.setTitle(super.title + " - Acceuil");
	}

}
