package com.swing.panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class JFrameTemplate extends JFrame {
	
	private static final long serialVersionUID = 3810875946998611120L;
	
	private JPanel contentPane;
	protected String title = "Inscriptions Sportives";
	protected String activeMenulLabel;
	protected JLabel Personnes = new JLabel("Personnes");
	protected JLabel Equipes = new JLabel("Equipes");
	protected JLabel Competitions = new JLabel("Competitions");

	public JFrameTemplate(JFrameTemplate parentJFrame) {
		this.launchWithParent(parentJFrame);
	}

	public JFrameTemplate() {
		this.launch();
	}
	
	protected void launch() {
		this.setConfig();
		
//		Ajout du JPanel Header
		contentPane.add(this.getHeaderPanel(), BorderLayout.NORTH);

//		Ajout du JPanel Container
		contentPane.add(this.getContainerPanel(), BorderLayout.CENTER);
		
//		Ajout du JPanel Footer
		contentPane.add(this.getFooterPanel(), BorderLayout.SOUTH);
		
		this.setEventListeners();
	}
	
	protected void launchWithParent(JFrameTemplate parentJFrame) {
		this.launch();
		setLocationRelativeTo(parentJFrame);
	}

	protected void setConfig() {
		this.setTitle();
		setMinimumSize(new Dimension(852, 567));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));		
	}
	
	protected abstract void setTitle();
	
	protected JPanel getHeaderPanel() {
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(250, 211, 144));	
		headerPanel.add(this.setMenuLabel(this.Personnes));
		headerPanel.add(this.setMenuLabel(this.Equipes));
		headerPanel.add(this.setMenuLabel(this.Competitions));
		
		return headerPanel;
	}
	
	protected JPanel getContainerPanel() {
		JPanel containerPanel = new JPanel();
		containerPanel.setBackground(new Color(207, 157, 73));
		
		return containerPanel;
	}
	
	protected JPanel getFooterPanel() {
		JPanel footerPanel = new JPanel();
		footerPanel.setBackground(new Color(250, 211, 144));	
		footerPanel.setLayout(new BorderLayout(0, 0));
		footerPanel.add(this.getFooterLabel("Inscriptions Sportives"), BorderLayout.WEST);
		
		return footerPanel;
	}
	
	protected JLabel setMenuLabel(JLabel menuLabel) {
		menuLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
		menuLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuLabel.setForeground(new Color(0, 0, 0, 100));
		menuLabel.setFont(new Font("Roboto", Font.PLAIN, 25));
		
		if (menuLabel.getText().equals(this.activeMenulLabel)) {
			menuLabel.setForeground(new Color(0, 0, 0, 170));
		}
		
		return menuLabel;
	}
	
	protected JLabel getFooterLabel(String footerLabelName) {
		JLabel jLabel = new JLabel(footerLabelName);
		jLabel.setBorder(new EmptyBorder(5, 10, 5, 0));
		
		return jLabel;
	}
	
	protected void setEventListeners() {
		JFrameTemplate actualClass = this;
		
		this.setLabelEventListerner(this.Personnes);
		this.Personnes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PersonnesIndex className = new PersonnesIndex(actualClass);
				className.setVisible(true);
				dispose();
			}
		});
		this.setLabelEventListerner(this.Equipes);
		this.Equipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EquipesIndex className = new EquipesIndex(actualClass);
				className.setVisible(true);
				dispose();
			}
		});
		this.setLabelEventListerner(this.Competitions);
		this.Competitions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CompetitionsIndex className = new CompetitionsIndex(actualClass);
				className.setVisible(true);
				dispose();
			}
		});
	}
	
	protected void setLabelEventListerner(JLabel jLabel) {
		Color color = jLabel.getForeground();
		
		jLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jLabel.setForeground(new Color(0, 0, 0, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jLabel.setForeground(color);
			}
		});
	}

}
