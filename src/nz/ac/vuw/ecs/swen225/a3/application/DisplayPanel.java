package nz.ac.vuw.ecs.swen225.a3.application;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import nz.ac.vuw.ecs.swen225.a3.maze.Free;
import nz.ac.vuw.ecs.swen225.a3.maze.InfoField;
import nz.ac.vuw.ecs.swen225.a3.maze.Key;
import nz.ac.vuw.ecs.swen225.a3.maze.Tile;
import nz.ac.vuw.ecs.swen225.a3.maze.Wall;
import nz.ac.vuw.ecs.swen225.a3.persistence.Level;

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
		Tile[][] level = new Level().convertLevel();

		for (int x = 0; x < gl.getColumns(); x++) {
			for (int y = 0; y < gl.getRows(); y++) {
				JPanel square = new JPanel();

				// Setting a default path to free as others not implemented yet.
				String path = "src\\nz\\ac\\vuw\\ecs\\swen225\\a3\\IMG\\CC2.png";

				// Gets the correct image path.
				if (level[x][y] instanceof Free || level[x][y] instanceof Wall || level[x][y] instanceof InfoField
						|| level[x][y] instanceof Key) {
					path = level[x][y].getImagePath();
				}

				JLabel img = new JLabel(new ImageIcon(new File(path).getAbsolutePath()));

				square.add(img);
				square.setBorder(BorderFactory.createEtchedBorder());

				add(square);

			}
		}
	}
}
