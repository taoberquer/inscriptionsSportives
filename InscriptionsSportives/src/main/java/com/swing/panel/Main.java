package com.swing.panel;

import java.awt.EventQueue;

import com.hibernate.entity.Inscriptions;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscriptions.getInscriptions().getCompetitions();
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
