package com.swing.jPanel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class JPanelEdit extends JPanel {

	private static final long serialVersionUID = -1528806658119695975L;
	
	protected abstract void setView();
	
	protected abstract void update();
	
	protected abstract void cancel();
	
	protected abstract void setEventListeners();

}
