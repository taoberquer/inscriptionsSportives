package com.swing.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Home extends JFrameTemplate {

	private static final long serialVersionUID = -2350059206384737088L;
	JTextField jTextLogin = new JTextField();
	JTextField jTextPassword = new JPasswordField();
	
	JLabel jLabelSave = new JLabel("Se connecter");

	public Home() {
		super();
		setView();
	}
	
	public Home(JFrameTemplate parentJFrame) {
		super(parentJFrame);
		if (!isConected()) {
			setView();
		}
	}
	
	protected void setView() {
		setBackground(new Color(207, 157, 73));
		setLayout(new BorderLayout(0,0));
		
		JPanel jPanelCenter = new JPanel();
		jPanelCenter.setBackground(new Color(207, 157, 73));
		add(jPanelCenter, BorderLayout.CENTER);
		
		JLabel jLabelLogin = new JLabel("Nom d'utilisateur :");
		jLabelLogin.setBorder(new EmptyBorder(0, 0, 10, 0));
		jLabelLogin.setForeground(Color.WHITE);
		jLabelLogin.setFont(new Font("Roboto", Font.PLAIN, 20));
		jPanelCenter.add(jLabelLogin);
	
		jTextLogin.setPreferredSize(new Dimension(10, 30));
		jTextLogin.setToolTipText("Login");
		jTextLogin.setHorizontalAlignment(SwingConstants.LEFT);
		jTextLogin.setColumns(20);
		jPanelCenter.add(jTextLogin);
		
		JLabel jLabelPassword = new JLabel("Mot de passe :");
		jLabelPassword.setBorder(new EmptyBorder(0, 0, 10, 0));
		jLabelPassword.setForeground(Color.WHITE);
		jLabelPassword.setFont(new Font("Roboto", Font.PLAIN, 20));
		jPanelCenter.add(jLabelPassword);
	
		jTextPassword.setPreferredSize(new Dimension(10, 30));
		jTextPassword.setToolTipText("Password");
		jTextPassword.setHorizontalAlignment(SwingConstants.LEFT);
		jTextPassword.setColumns(20);
		jPanelCenter.add(jTextPassword);
	
			
		
		JPanel jPanelButton = new JPanel();
		jPanelButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		jPanelButton.setBackground(new Color(0, 0, 0, 0));
		add(jPanelButton, BorderLayout.SOUTH);
		
		jLabelSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jLabelSave.setOpaque(true);
		jLabelSave.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelSave.setForeground(Color.WHITE);
		jLabelSave.setBorder(new EmptyBorder(10, 25, 10, 25));
		jLabelSave.setBackground(new Color(46, 204, 113));
		jLabelSave.setAlignmentX(0.5f);
		jPanelButton.add(jLabelSave);
		
		setEvenListener();
		
	}
	
	protected void setEvenListener() {
		Color color = jLabelSave.getForeground();
		
		jLabelSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jLabelSave.setForeground(new Color(0, 0, 0, 170).darker());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jLabelSave.setForeground(color);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				connect();
			}
		});
	}

	protected void connect() {
		if (jTextLogin.getText().equals("admin") && jTextPassword.getText().equals("admin")) {
			connected = true;
			Home home = new Home(this);
			home.setVisible(true);
			dispose();
			
		}
	}
	
	protected void setTitle() {
		super.setTitle(super.title + " - Acceuil");
	}

}
