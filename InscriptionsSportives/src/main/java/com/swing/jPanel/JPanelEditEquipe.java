package com.swing.jPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.hibernate.entity.Equipe;
import com.hibernate.entity.Inscriptions;

public class JPanelEditEquipe extends JPanelEdit {

	private static final long serialVersionUID = -4738336875439730910L;

	JTextField jTextName = new JTextField();
	
	JLabel jLabelSave = new JLabel("Save");
	JLabel jLabelCancel = new JLabel("Cancel");
	
	Equipe equipe;

	/**
	 * Create the panel.
	 */
	public JPanelEditEquipe(Equipe passedEquipe) {
		equipe = passedEquipe;
		jTextName.setText(equipe.getNom());
		
		setView();
		setEventListeners();
	}

	@Override
	protected void setView() {
		setBorder(new EmptyBorder(0, 10, 50, 10));
		setBackground(new Color(207, 157, 73));
		setLayout(new BorderLayout(0,0));
		
		JPanel jPanelCenter = new JPanel();
		jPanelCenter.setBackground(new Color(207, 157, 73));
		add(jPanelCenter, BorderLayout.CENTER);
		
		JLabel jLabelName = new JLabel("Nom de l'equipe");
		jLabelName.setBorder(new EmptyBorder(0, 0, 10, 0));
		jLabelName.setForeground(Color.WHITE);
		jLabelName.setFont(new Font("Roboto", Font.PLAIN, 20));
		jPanelCenter.add(jLabelName);

		jTextName.setPreferredSize(new Dimension(10, 30));
		jTextName.setToolTipText("Nom");
		jTextName.setHorizontalAlignment(SwingConstants.LEFT);
		jTextName.setColumns(20);
		jPanelCenter.add(jTextName);

			
		
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

		jPanelButton.add(Box.createHorizontalStrut(20));

		jLabelCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jLabelCancel.setOpaque(true);
		jLabelCancel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelCancel.setForeground(Color.WHITE);
		jLabelCancel.setBorder(new EmptyBorder(10, 25, 10, 25));
		jLabelCancel.setBackground(new Color(231, 76, 60));
		jLabelCancel.setAlignmentX(0.5f);
		jPanelButton.add(jLabelCancel);	
	}

	@Override
	protected void update() {
		equipe.setNom(jTextName.getText());
		setVisible(false);
		
	}

	@Override
	protected void cancel() {
		setVisible(false);
		
	}

	@Override
	protected void setEventListeners() {
		setEventListener(jLabelSave);
		jLabelSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update();
			}
		});
		setEventListener(jLabelCancel);
		jLabelCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cancel();
			}
		});
		
	}
	
	protected void setEventListener(JLabel jLabel) {
		Color color = jLabel.getForeground();
		
		jLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jLabel.setForeground(new Color(0, 0, 0, 170).darker());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jLabel.setForeground(color);
			}
		});
	}

}
