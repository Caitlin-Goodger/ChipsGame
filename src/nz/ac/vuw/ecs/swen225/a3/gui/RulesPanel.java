package nz.ac.vuw.ecs.swen225.a3.gui;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Rules panel shows when the rules item is ticked. Displays the rules for the
 * game to the player.
 */
public class RulesPanel extends JPanel {
	private JLabel text;

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

		text = new JLabel();

		text.setText(
				  "<html>" 
				+ "Your player can move forwards, backwards, left and right. <br>"
				+ "The goal of the game is to reach the exit while avoiding all obstacles. <br>"
				+ "Collect keys to unlock doors,  avoid traps and push blocks. <br>" 
				+ "<br>" 
				+ "Good luck! <br>"
				+ "</html>");

		add(text);

		setVisible(false);
	}
}
