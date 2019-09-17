
package nz.ac.vuw.ecs.swen225.a3.render;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
    setMinimumSize(new Dimension(500, 500));
	setSize(500, 500);
	setResizable(true);
	setLocationRelativeTo(null);
	setLayout(new BorderLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	/*
	 * Adds the panels
	 */
	setJMenuBar(createMenuBar());
	
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
    
    /**
     * Creates the menu bar.
     * 
     * @return JMenuBar : Returns the menu bar created
     */
    private JMenuBar createMenuBar() {
    	JMenuBar menuBar = new JMenuBar();
    
    	// GAME MENU
    	
    	JMenu gameMenu = new JMenu("Game");
    	
    	JMenuItem loadItem = new JMenuItem("Load");
    	JMenuItem saveItem = new JMenuItem("Save");
    	JMenuItem exitItem = new JMenuItem("Exit");
    	
    	gameMenu.add(loadItem);
    	gameMenu.add(saveItem);
    	gameMenu.addSeparator();
    	gameMenu.add(exitItem);
    	
    	// OPTIONS MENU
    	
    	JMenu optionMenu = new JMenu("Options");
    	
    	// LEVEL MENU
    	
    	JMenu levelMenu = new JMenu("Level");
    	
    	// HELP MENU
    	
    	JMenu helpMenu = new JMenu("Help");
    	
    	menuBar.add(gameMenu);
    	menuBar.add(optionMenu);
    	menuBar.add(levelMenu);
    	menuBar.add(helpMenu);
    	
    	return menuBar;
    }
}
