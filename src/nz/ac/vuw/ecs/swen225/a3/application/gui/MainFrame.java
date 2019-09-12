package nz.ac.vuw.ecs.swen225.a3.application.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * MainFrame that will hold panels such as display and buttons.
 */
public class MainFrame extends JFrame {
    private MapPanel mp;
    
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     */
    public MainFrame() {
	/*
	 * Initializing the frame
	 */
	setSize(500, 500);
	setResizable(false);
	setLocationRelativeTo(null);
	setLayout(new BorderLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	/*
	 * Adds the panels
	 */
	mp = new MapPanel();
	add(mp, BorderLayout.WEST);
	
	setVisible(true);
    }
    
    /**
     * Returns the map panel.
     * 
     * @return mp
     */
    public MapPanel getMapPanel() {
	return this.mp;
    }
}
