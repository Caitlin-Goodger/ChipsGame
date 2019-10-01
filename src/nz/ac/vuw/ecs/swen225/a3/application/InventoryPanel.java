package nz.ac.vuw.ecs.swen225.a3.application;

import java.awt.Color;
import java.awt.Dimension;
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
import nz.ac.vuw.ecs.swen225.a3.maze.Key;
import nz.ac.vuw.ecs.swen225.a3.maze.LockedDoor;
import nz.ac.vuw.ecs.swen225.a3.render.Renderer;

/**
 * Inventory panel that holds the objects collected by the
 * player.
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
	 * @param game = Game that this is for. 
	 */
	public InventoryPanel(Game game) {
		setPreferredSize(new Dimension(getWidth(), 40));

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
		Renderer ren = new Renderer();

		int itemsAdded = 0;

		Map<String, String> inventory = game.getChap().returnInventory();

		for (String item : inventory.keySet()) {
			String path = null;

			if (item.equals("yellow") || item.equals("blue") || item.equals("red") || item.equals("green")) {
				path = "resources/CC12.png";
			}
			
			if(path!= null) {
				ImageIcon icon = new ImageIcon(new File(path).getPath());
				Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	
				// change color of key image to match color value of key being displayed
				switch (item) {
				case "red":
					scaledImage = ren.mergeImages(path, 3, Color.RED).getScaledInstance(50, 50,
							Image.SCALE_SMOOTH);
					break;
				case "yellow":
					scaledImage = ren.mergeImages(path, 3, Color.YELLOW).getScaledInstance(50, 50,
							Image.SCALE_SMOOTH);
					break;
				case "green":
					scaledImage = ren.mergeImages(path, 3, Color.GREEN).getScaledInstance(50, 50,
							Image.SCALE_SMOOTH);
					break;
				default:
					scaledImage = ren.mergeImages(path, 3, Color.BLUE).getScaledInstance(50, 50,
							Image.SCALE_SMOOTH);
				}
	
				JLabel img = new JLabel(new ImageIcon(scaledImage));
	
				add(img);
	
				itemsAdded++;
			}
		}

		for (int x = itemsAdded; x < 8; x++) {
			String path = "resources/CC13.png";

			ImageIcon icon = new ImageIcon(new File(path).getPath());
			Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

			JLabel img = new JLabel(new ImageIcon(scaledImage));

			add(img);
		}
	}
}
