package nz.ac.vuw.ecs.swen225.a3.application;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Inventory panel that holds the objects collected by the player.
 */
public class InventoryPanel extends JPanel {
	private GridLayout gl;

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the inventory panel.
	 */
	public InventoryPanel() {
		Border innerBorder = BorderFactory.createTitledBorder("Inventory");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		gl = new GridLayout(2, 4);

		setLayout(gl);

		drawInventory();
	}

	/**
	 * For display purposes only. Draws 4x2 tiles to screen.
	 */
	private void drawInventory() {
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
