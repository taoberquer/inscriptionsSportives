package com.swing.jPanel;

import javax.swing.JPanel;

public abstract class JPanelCreate extends JPanel {

	private static final long serialVersionUID = 8187367571949624824L;
	
	protected abstract void setView();
	
	protected abstract void add();
	
	protected abstract void cancel();
	
	protected abstract void setEventListeners();

}
