package nz.ac.vuw.ecs.swen225.a3.application;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Rules panel shows when the rules item is ticked. Displays the rules for the
 * game to the player.
 */
public class RulesPanel extends JPanel {
	private JLabel lineOne;
	private JLabel lineTwo;

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the rules panel.
	 */
	public RulesPanel() {
		Border innerBorder = BorderFactory.createTitledBorder("Rules");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		lineOne = new JLabel();
		lineTwo = new JLabel();

		lineOne.setText("Your player can move forward, backwards, left and right.");
		lineTwo.setText("The goal of the game is to reach the exit while avoiding all obstacles.");

		add(lineOne);
		add(lineTwo);

		setVisible(false);
	}
}
