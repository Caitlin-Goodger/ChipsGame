
package nz.ac.vuw.ecs.swen225.a3.render;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * MainFrame that will hold panels and menus that will be responsible for
 * displaying the game and holding buttons that allow interaction with the game.
 */
public class MainFrame extends JFrame {
	private DisplayPanel displayPanel;
	private InterfacePanel interfacePanel;
	private InventoryPanel inventoryPanel;

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for main frame.
	 */
	public MainFrame() {
		// Initializing and defining parameters.
		setTitle("Chip's Challenge");
		setMinimumSize(new Dimension(650, 500));
		setSize(600, 500);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.BOTH;

		// Add panels to main frame.
		setJMenuBar(createMenuBar());

		// DISPLAY.

		gc.weightx = 0.75;
		gc.weighty = 1;

		gc.gridwidth = 1;
		gc.gridheight = 2;

		displayPanel = new DisplayPanel();
		add(displayPanel, gc);

		// INTERFACE.

		gc.gridx++;

		gc.weightx = 0.25;
		gc.weighty = 0.75;

		gc.gridwidth = 1;
		gc.gridheight = 1;

		interfacePanel = new InterfacePanel();
		add(interfacePanel, gc);

		// INVENTORY.

		gc.gridy++;

		gc.weightx = 0.25;
		gc.weighty = 0.25;

		gc.gridwidth = 1;
		gc.gridheight = 1;

		inventoryPanel = new InventoryPanel();
		add(inventoryPanel, gc);

		pack();
		setVisible(true);
	}

	/**
	 * Creates the menu bar.
	 * 
	 * @return JMenuBar : Returns the menu bar created.
	 */
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		// GAME MENU.

		JMenu gameMenu = new JMenu("Game");

		JMenuItem loadItem = new JMenuItem("Load");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem exitItem = new JMenuItem("Exit");

		gameMenu.add(loadItem);
		gameMenu.add(saveItem);
		gameMenu.addSeparator();
		gameMenu.add(exitItem);

		// OPTIONS MENU.

		JMenu optionsMenu = new JMenu("Options");

		JMenuItem pauseItem = new JMenuItem("Pause");
		JMenuItem resumeItem = new JMenuItem("Resume");

		optionsMenu.add(pauseItem);
		optionsMenu.add(resumeItem);

		// LEVEL MENU.

		JMenu levelMenu = new JMenu("Level");

		JMenuItem resetItem = new JMenuItem("Reset");

		levelMenu.add(resetItem);

		// HELP MENU.

		JMenu helpMenu = new JMenu("Help");

		JMenuItem rulesItem = new JMenuItem("Rules");

		helpMenu.add(rulesItem);

		// Adding to menu bar.

		menuBar.add(gameMenu);
		menuBar.add(optionsMenu);
		menuBar.add(levelMenu);
		menuBar.add(helpMenu);

		// Setting mnemonics.

		gameMenu.setMnemonic(KeyEvent.VK_G);
		optionsMenu.setMnemonic(KeyEvent.VK_O);
		levelMenu.setMnemonic(KeyEvent.VK_L);
		helpMenu.setMnemonic(KeyEvent.VK_H);

		// Setting accelerators.

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		resumeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		loadItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		resetItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));

		// Add action listener to exit game
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit the game?",
						"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});

		return menuBar;
	}
}
