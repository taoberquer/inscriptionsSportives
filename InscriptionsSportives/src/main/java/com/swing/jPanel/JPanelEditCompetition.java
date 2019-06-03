package com.swing.jPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.hibernate.entity.Competition;

public class JPanelEditCompetition extends JPanelEdit {

	private static final long serialVersionUID = 2934491980669872718L;
	
	Competition competition;
	
	JTextField jTextName = new JTextField();
	JTextField jTextDay = new JTextField();
	JTextField jTextMonth = new JTextField();
	JTextField jTextYear = new JTextField();
	
	JCheckBox jCheckBoxEquipe = new JCheckBox("En équipe");
	
	JLabel jLabelSave = new JLabel("Save");
	JLabel jLabelCancel = new JLabel("Cancel");
	
	public JPanelEditCompetition(Competition passedCompetition) {
		competition = passedCompetition;
		
		jTextName.setText(competition.getNom());
		jTextDay.setText(Integer.toString(competition.getDateCloture().getDayOfMonth()));
		jTextMonth.setText(Integer.toString(competition.getDateCloture().getMonthValue()));
		jTextYear.setText(Integer.toString(competition.getDateCloture().getYear()));
		
		jCheckBoxEquipe.setSelected(competition.estEnEquipe());
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
		
		JLabel jLabelName = new JLabel("Nom de la competition");
		jLabelName.setBorder(new EmptyBorder(0, 0, 10, 0));
		jLabelName.setForeground(Color.WHITE);
		jLabelName.setFont(new Font("Roboto", Font.PLAIN, 20));
		jPanelCenter.add(jLabelName);

		jTextName.setPreferredSize(new Dimension(10, 30));
		jTextName.setToolTipText("Nom");
		jTextName.setHorizontalAlignment(SwingConstants.LEFT);
		jTextName.setColumns(20);
		jPanelCenter.add(jTextName);

		JPanel containerInfoInputPanelBottom = new JPanel();
		containerInfoInputPanelBottom.setBorder(new EmptyBorder(0, 10, 0, 20));
		containerInfoInputPanelBottom.setBackground(new Color(0, 0, 0, 0));
		jPanelCenter.add(containerInfoInputPanelBottom);
		containerInfoInputPanelBottom.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel jLabelDate = new JLabel("Date de fin");
		jLabelDate.setAlignmentX(Component.CENTER_ALIGNMENT);
		jLabelDate.setForeground(Color.WHITE);
		jLabelDate.setFont(new Font("Roboto", Font.PLAIN, 20));
		jLabelDate.setBorder(new EmptyBorder(0, 0, 10, 0));
		containerInfoInputPanelBottom.add(jLabelDate);
		
		JPanel jPanelDate = new JPanel();
		jPanelDate.setBorder(new EmptyBorder(0, 0, 0, 0));
		jPanelDate.setBackground(new Color(0, 0, 0, 0));
		jPanelCenter.add(jPanelDate);
		jPanelDate.setLayout(new BoxLayout(jPanelDate, BoxLayout.X_AXIS));

		jTextDay.setToolTipText("Jour");
		jTextDay.setPreferredSize(new Dimension(0, 30));
		jTextDay.setHorizontalAlignment(SwingConstants.LEFT);
		jTextDay.setColumns(5);
		jPanelDate.add(jTextDay);

		jPanelDate.add(Box.createHorizontalStrut(20));

		jTextMonth.setToolTipText("Mois");
		jTextMonth.setPreferredSize(new Dimension(0, 30));
		jTextMonth.setHorizontalAlignment(SwingConstants.LEFT);
		jTextMonth.setColumns(5);
		jPanelDate.add(jTextMonth);

		jPanelDate.add(Box.createHorizontalStrut(20));

		jTextYear.setToolTipText("Année");
		jTextYear.setPreferredSize(new Dimension(0, 30));
		jTextYear.setHorizontalAlignment(SwingConstants.LEFT);
		jTextYear.setColumns(5);
		jPanelDate.add(jTextYear);		
		
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

		jCheckBoxEquipe.setEnabled(false);;
		jPanelCenter.add(jCheckBoxEquipe);		
	}

	@Override
	protected void update() {
		String name = jTextName.getText();
		LocalDate dateFin = LocalDate.of(
				Integer.parseInt(jTextYear.getText()),
				Integer.parseInt(jTextMonth.getText()), 
				Integer.parseInt(jTextDay.getText())
		);
		
		if (competition.getDateCloture().isBefore(dateFin)) {
			competition.setDateCloture(dateFin);			
		}
		
		competition.setNom(name);

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
