package com.swing.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.swing.jPanel.JPanelCreate;
import com.swing.jPanel.JPanelEdit;

public abstract class IndexTemplate extends JFrameTemplate {

	private static final long serialVersionUID = -7818304814342522482L;

	JTable table;
	JLayeredPane jLayeredPane;
	JPanel jPanelCreate, jPanelEdit;
	JLabel jLabelAddButton, jLabelUpdateButton, jLabelDeleteButton;

	public IndexTemplate() {
		super();
	}
	
	public IndexTemplate(JFrameTemplate parentJFrame) {
		super(parentJFrame);
	}
	
	@Override
	protected JPanel getContainerPanel() {
		//Container principale
		JPanel jPanelContainer = super.getContainerPanel();
		jPanelContainer.setAlignmentY(1.0f);
		jPanelContainer.setBorder(new EmptyBorder(20, 0, 20, 0));
		jPanelContainer.setFocusable(false);
		jPanelContainer.setLayout(new GridLayout(0, 2, 0, 0));
		
		//Container de guauche
		JPanel jPanelLeftContainer = new JPanel();
		jPanelLeftContainer.setBorder(new EmptyBorder(0, 20, 0, 20));
		jPanelLeftContainer.setBackground(new Color(207, 157, 73));
		jPanelLeftContainer.setLayout(new BorderLayout(0, 0));
		jPanelContainer.add(jPanelLeftContainer);

		//Container de droite
		JPanel jPanelRightContainer = new JPanel();
		jPanelRightContainer.setBorder(new EmptyBorder(0, 0, 0, 20));
		jPanelRightContainer.setBackground(new Color(207, 157, 73));
		jPanelRightContainer.setLayout(new BorderLayout(0, 0));
		jPanelContainer.add(jPanelRightContainer);

		//Container contenant le tableau
		JPanel containerTablePanel = new JPanel();
		containerTablePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		containerTablePanel.setBackground(Color.decode("#356691"));
		containerTablePanel.setLayout(new BoxLayout(containerTablePanel, BoxLayout.X_AXIS));
		jPanelLeftContainer.add(containerTablePanel);

		JPanel containerTablePanelContent = new JPanel();
		containerTablePanelContent.setLayout(new BorderLayout());
		containerTablePanelContent.setBackground(new Color(255, 255, 255, 0));
		containerTablePanel.add(containerTablePanelContent);
		JTable tableContainer = getTableContent();		
		containerTablePanelContent.add( getTableComponent(tableContainer), BorderLayout.CENTER );	

		//JPanel changeant
		jLayeredPane = new JLayeredPane();
		jLayeredPane.setBorder(new EmptyBorder(0, 10, 50, 10));
		jLayeredPane.setBackground(Color.decode("#356691"));
		jLayeredPane.setLayout(new GridLayout(0, 1, 0, 0));
		jPanelRightContainer.add(jLayeredPane, BorderLayout.CENTER);
		
		JPanel jPanelButton = new JPanel();
		jPanelButton.setBackground(new Color(250, 211, 144));
		jPanelRightContainer.add(jPanelButton, BorderLayout.SOUTH);
		
		this.setActionButtons(jPanelButton);


		return jPanelContainer;
	}
	
	protected void setUpCreateView() {
		switchView(getJPanelCreate());
	}
	
	protected void setUpEditView() {
		switchView(getJPanelEdit());
	}
	
	protected abstract JPanelEdit getJPanelEdit();
	
	protected abstract JPanelCreate getJPanelCreate();
	
	protected void switchView(JPanel jPanel) {
		jLayeredPane.removeAll();
		jLayeredPane.add(jPanel);
		jLayeredPane.repaint();
		jLayeredPane.revalidate();
	}
	
	
	protected void setActionButtons(JPanel jPanel) {
		jLabelAddButton = new JLabel("Ajouter");
		this.setButtonLabel(jLabelAddButton, new Color(11, 197, 39));
		if (isConected() && isAdmin()) {
			jPanel.add(this.jLabelAddButton);
		}

		jLabelUpdateButton = new JLabel("Modifier");
		this.setButtonLabel(this.jLabelUpdateButton, new Color(42, 48, 240));
		if (isConected() && isAdmin()) {
			jPanel.add(this.jLabelUpdateButton);
		}

		jLabelDeleteButton = new JLabel("Supprimer");
		this.setButtonLabel(this.jLabelDeleteButton, new Color(217, 20, 65));
		if (isConected() && isAdmin()) {
			jPanel.add(this.jLabelDeleteButton);	
		}
	}
	
	protected void setButtonLabel(JLabel jLabel, Color color) {
		jLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jLabel.setOpaque(true);
		jLabel.setBorder(new EmptyBorder(10, 25, 10, 25));
		jLabel.setBackground(color);
		jLabel.setForeground(Color.WHITE);
	}
	
	@Override
	protected void setEventListeners() {
		super.setEventListeners();
		
		setLabelEventListerner(this.jLabelAddButton);
		setLabelEventListerner(this.jLabelUpdateButton);
		setLabelEventListerner(this.jLabelDeleteButton);
		
		jLabelAddButton.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setUpCreateView();
			}
		});
		
		jLabelUpdateButton.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() >= 0) {
					setUpEditView();
				}
			}
		});
		
		jLabelDeleteButton.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() >= 0) {
					deleteSelectedRow(table.getSelectedRow());
					update();
				}
			}
		});
	}
	
	protected void setLabelEventListerner(JLabel jLabel) {
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
	
    public Component getTableComponent(Component containerTable){
        JScrollPane tablePane = new JScrollPane( containerTable );
        return tablePane;
    }
	
	protected abstract JTable getTableContent();
	
	protected abstract void update();
	
	protected abstract void deleteSelectedRow(int index);
}
