package nz.ac.vuw.ecs.swen225.a3.render;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Rules panel shows when the rules item is ticked. Displays the rules for the
 * game to the player.
 */
public class RulesPanel extends JPanel {
	private JLabel rules;

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

		rules = new JLabel();

		rules.setText("Play the game.");

		add(rules);

		setVisible(false);
	}
}
