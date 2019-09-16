package nz.ac.vuw.ecs.swen225.a3.render;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Displays the map.
 */
public class MapPanel extends JPanel {
    private JPanel displayPanel;
    
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     */
    public MapPanel() {
	displayPanel = new JPanel();
	displayPanel.setLayout(new GridLayout(2, 4));
	
	add(displayPanel);
    }
    
    /**
     * Returns the display panel.
     * 
     * @return displayPanel
     */
    public JPanel getDisplayPanel() {
	return this.displayPanel;
    }
}
