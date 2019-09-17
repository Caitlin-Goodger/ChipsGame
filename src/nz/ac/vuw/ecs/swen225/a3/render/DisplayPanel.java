package nz.ac.vuw.ecs.swen225.a3.render;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Display panel displays the board to the user.
 */
public class DisplayPanel extends JPanel {
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the display panel.
	 */
	public DisplayPanel() {
		Border innerBorder = BorderFactory.createTitledBorder("Display");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridLayout(9, 9));

		drawPanel();
	}

	/**
	 * For display purposes only. Draws 9x9 tiles to screen.
	 */
	private void drawPanel() {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				JPanel square = new JPanel();
				square.setBackground(Color.WHITE);
				square.setBorder(BorderFactory.createLineBorder(Color.GRAY));

				add(square);
			}
		}
	}
}
