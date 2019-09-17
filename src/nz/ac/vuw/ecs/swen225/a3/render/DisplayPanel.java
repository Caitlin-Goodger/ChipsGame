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
	private GridLayout gl;

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

		gl = new GridLayout(9, 9);

		setLayout(gl);

		drawPanel();
	}

	/**
	 * For display purposes only. Draws 9x9 tiles to screen.
	 */
	private void drawPanel() {
		for (int x = 0; x < gl.getColumns(); x++) {
			for (int y = 0; y < gl.getRows(); y++) {
				JPanel square = new JPanel();

				square.setBackground(Color.WHITE);
				square.setBorder(BorderFactory.createEtchedBorder());

				add(square);
			}
		}
	}
}
