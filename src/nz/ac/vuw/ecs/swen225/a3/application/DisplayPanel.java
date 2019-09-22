package nz.ac.vuw.ecs.swen225.a3.application;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import nz.ac.vuw.ecs.swen225.a3.maze.*;
import nz.ac.vuw.ecs.swen225.a3.render.Renderer;

/**
 * Display panel displays the board to the user.
 */
public class DisplayPanel extends JPanel {
	private GridLayout gl;
	public int totalChipsLeft;

	private Game game;
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the display panel.
	 */
	public DisplayPanel(Game game) {
		this.game = game;

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
	public void drawPanel() {
		totalChipsLeft = 0;
		Renderer ren = new Renderer();
		Tile[][] level = game.getMaze().getTiles();

		Chap chap = game.getMaze().findChap();
		XYPos chapLocation = chap.getTilePosition();

		// Minus 4 from Chap's location for each dimension to get starting
		// point.
		// chapLocation.getX() - 4
		// chapLocation.getY() - 4
		for (int x = 0; x < gl.getColumns(); x++) {
			for (int y = 0; y < gl.getRows(); y++) {
				String path;

				// Gets the correct image path.
				if (level[x][y].getImagePath() == null) {
					path = "resources/CC2.png";
				} else {
					path = level[x][y].getImagePath();
				}

				ImageIcon icon = new ImageIcon(new File(path).getPath());
				Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

				// used to change the color of the key and lock also able to place them on
				// backgrounds
				if (level[x][y] instanceof Key) {
					scaledImage = ren.mergeImages(path, 1, Color.RED).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
				} else if (level[x][y] instanceof LockedDoor) {
					scaledImage = ren.mergeImages(path, 2, Color.RED).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
				}

				if(level[x][y] instanceof Treasure) totalChipsLeft++;

				JLabel img = new JLabel(new ImageIcon(scaledImage));

				add(img);
			}
		}
	}
}
