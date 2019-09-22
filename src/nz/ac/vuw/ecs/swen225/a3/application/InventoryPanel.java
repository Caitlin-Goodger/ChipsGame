package nz.ac.vuw.ecs.swen225.a3.application;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import nz.ac.vuw.ecs.swen225.a3.maze.Game;

/**
 * Inventory panel that holds the objects collected by the player.
 */
public class InventoryPanel extends JPanel {
	private GridLayout gl;

	private Game game;
	
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the inventory panel.
	 */
	public InventoryPanel(Game game) {
		this.game = game;
		
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
	public void drawInventory() {
		int itemsAdded = 0;

		Map<String, String> inventory = game.getChap().returnInventory();

		for (String item : inventory.keySet()) {
			String path = null;
			
			if (item.equals("yellow")) {
				path = "resources/CC12.png";
			}

			ImageIcon icon = new ImageIcon(new File(path).getPath());
			Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

			JLabel img = new JLabel(new ImageIcon(scaledImage));

			add(img);

			itemsAdded++;
		}

		for (int x = itemsAdded; x < 8; x++) {
			String path = "resources/CC2.png";

			ImageIcon icon = new ImageIcon(new File(path).getPath());
			Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

			JLabel img = new JLabel(new ImageIcon(scaledImage));

			add(img);
		}
	}
}
