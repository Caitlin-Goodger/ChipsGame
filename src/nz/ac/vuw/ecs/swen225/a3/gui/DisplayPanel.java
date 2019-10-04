package nz.ac.vuw.ecs.swen225.a3.gui;

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
import nz.ac.vuw.ecs.swen225.a3.maze.game.Game;
import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.render.Renderer;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Display panel displays the board to the user.
 */
public class DisplayPanel extends JPanel {
	private GridLayout gl;
	/**
	 * Total number of chips left in the maze. 
	 */
	public int totalChipsLeft;

	private Game game;
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the display panel.
	 * @param game = Game to display. 
	 */
	public DisplayPanel(Game game) {
		this.game = game;
		this.totalChipsLeft = game.getMaze().remainingTreasure();
		
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
		Renderer ren = new Renderer();
		Tile[][] level = game.getMaze().getTiles();

		ExitLock exit;
		Chap chap = game.getMaze().findChap();
		Position chapLocation = chap.getChapPosition();

		// Minus 4 from Chap's location for each dimension to get
		// starting
		// point.
		// chapLocation.getX() - 4
		// chapLocation.getY() - 4
		for (int y = chapLocation.getY() - 4; y < chapLocation.getY() - 4 + gl.getColumns(); y++) {
			for (int x = chapLocation.getX() - 4; x < chapLocation.getX() - 4 + gl.getRows(); x++) {
				if (totalChipsLeft == 0 && level[y][x] instanceof ExitLock) {
					exit = (ExitLock) level[y][x];
					exit.unlockExitLock();
					level[y][x] = exit;
				}
				
				String path;

				// Gets the correct image path.
				if (level[y][x].getImagePath() == null) {
					path = "resources/CC2.png";
				} else {
					path = level[y][x].getImagePath();
				}

				ImageIcon icon = new ImageIcon(new File(path).getPath());
				Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

				// used to change the color of the key and lock also able to
				// place them on
				// backgrounds
				if (level[y][x] instanceof Key) {
					Key key = (Key) level[y][x];

					switch (key.getColour()) {
					case "red":
						scaledImage = ren.mergeImages(path, 1, Color.RED).getScaledInstance(50, 50,
								Image.SCALE_SMOOTH);
						break;
					case "yellow":
						scaledImage = ren.mergeImages(path, 1, Color.YELLOW).getScaledInstance(50,
								50, Image.SCALE_SMOOTH);
						break;
					case "green":
						scaledImage = ren.mergeImages(path, 1, Color.GREEN).getScaledInstance(50,
								50, Image.SCALE_SMOOTH);
						break;
					default:
						scaledImage = ren.mergeImages(path, 1, Color.BLUE).getScaledInstance(50, 50,
								Image.SCALE_SMOOTH);
					}
				} else if (level[y][x] instanceof LockedDoor) {
					LockedDoor lockedDoor = (LockedDoor) level[y][x];

					switch (lockedDoor.getColour()) {
					case "red":
						scaledImage = ren.mergeImages(path, 2, Color.RED).getScaledInstance(50, 50,
								Image.SCALE_SMOOTH);
						break;
					case "yellow":
						scaledImage = ren.mergeImages(path, 2, Color.YELLOW).getScaledInstance(50,
								50, Image.SCALE_SMOOTH);
						break;
					case "green":
						scaledImage = ren.mergeImages(path, 2, Color.GREEN).getScaledInstance(50,
								50, Image.SCALE_SMOOTH);
						break;
					default:
						scaledImage = ren.mergeImages(path, 2, Color.BLUE).getScaledInstance(50, 50,
								Image.SCALE_SMOOTH);
					}
				}

				JLabel img = new JLabel(new ImageIcon(scaledImage));

				add(img);
			}
		}
	}

	/**
	 * Sets total chips left.
	 * 
	 * @param i = chips to set. 
	 */
	public void setTotalChips(int i) {
		totalChipsLeft = i;
	}
}
