
package nz.ac.vuw.ecs.swen225.a3.render;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for main frame.
	 */
	public MainFrame() {
		// Initializing and defining parameters.
		setMinimumSize(new Dimension(500, 500));
		setSize(500, 500);
		setResizable(true);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add panels to main frame.
		setJMenuBar(createMenuBar());

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
