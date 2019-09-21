package nz.ac.vuw.ecs.swen225.a3.persistence;

import nz.ac.vuw.ecs.swen225.a3.maze.Chap;
import nz.ac.vuw.ecs.swen225.a3.maze.Exit;
import nz.ac.vuw.ecs.swen225.a3.maze.ExitLock;
import nz.ac.vuw.ecs.swen225.a3.maze.Free;
import nz.ac.vuw.ecs.swen225.a3.maze.InfoField;
import nz.ac.vuw.ecs.swen225.a3.maze.Key;
import nz.ac.vuw.ecs.swen225.a3.maze.LockedDoor;
import nz.ac.vuw.ecs.swen225.a3.maze.Tile;
import nz.ac.vuw.ecs.swen225.a3.maze.Treasure;
import nz.ac.vuw.ecs.swen225.a3.maze.Wall;

/**
 * Level class that holds information about the current level.
 */
public class Level {
	// Debug: a test map
	private int[][] levelAsInt = new int[][] { 
			{ 0, 8, 0, 1, 3, 1, 0, 8, 0 }, 
			{ 1, 1, 6, 1, 4, 1, 6, 1, 1 },
			{ 0, 6, 0, 0, 0, 0, 0, 1, 0 }, 
			{ 0, 1, 5, 0, 7, 0, 5, 1, 0 }, 
			{ 1, 1, 8, 0, 2, 0, 8, 1, 1 },
			{ 0, 1, 0, 0, 0, 0, 5, 1, 0 }, 
			{ 0, 6, 0, 0, 8, 0, 0, 6, 0 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 1, 0, 0, 1, 0, 0, 1, 0 } 
	};

	private Tile[][] levelAsTile = new Tile[levelAsInt[0].length][levelAsInt.length];

	/**
	 * Empty constructor for level.
	 */
	public Level() {
	}

	/**
	 * Converts the level with tiles as ID into a level with tiles as tile objects.
	 */
	public Tile[][] convertLevel() {
		// Gets the width and height of the current level.
		int width = levelAsInt[0].length;
		int height = levelAsInt.length;

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int tileID = levelAsInt[x][y];

				// Generic tile, given specificity in switch statement depending on id.
				Tile tile;

				switch (tileID) {
				case 0:
					tile = new Free(x, y, x, y);
					break;
				case 1:
					tile = new Wall(x, y, x, y);
					break;
				case 2:
					tile = new Chap(x, y, x, y);
					break;
				case 3:
					tile = new Exit(x, y, x, y);
					break;
				case 4:
					tile = new ExitLock(x, y, x, y);
					break;
				case 5:
					// Replace null with key colour.
					tile = new Key(null, x, y, x, y);
					break;
				case 6:
					// Replace null with locked door colour.
					tile = new LockedDoor(null, x, y, x, y);
					break;
				case 7:
					// Replace null with info field desc.
					tile = new InfoField(null, x, y, x, y);
					break;
				default:
					tile = new Treasure(x, y, x, y);
				}

				levelAsTile[x][y] = tile;
			}
		}

		return levelAsTile;
	}

	/**
	 * Method for debugging, prints the converted level to see if it looks correct.
	 */
	private void printConvertedLevel() {
		// Gets the width and height of the current level.
		int height = levelAsTile[0].length;
		int width = levelAsTile.length;

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				// Go to next line once end of line is reached.
				if (x == width - 1) {
					System.out.print(levelAsTile[y][x].toString() + " ");

					System.out.println();
				} else {
					System.out.print(levelAsTile[y][x].toString() + " ");
				}
			}
		}
	}
}
