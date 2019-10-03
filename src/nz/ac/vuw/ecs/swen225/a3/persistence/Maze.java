package nz.ac.vuw.ecs.swen225.a3.persistence;

import java.util.ArrayList;

import nz.ac.vuw.ecs.swen225.a3.maze.Chap;
import nz.ac.vuw.ecs.swen225.a3.maze.Free;
import nz.ac.vuw.ecs.swen225.a3.maze.Monster;
import nz.ac.vuw.ecs.swen225.a3.maze.Tile;
import nz.ac.vuw.ecs.swen225.a3.maze.Treasure;
import nz.ac.vuw.ecs.swen225.a3.util.XYPos;

/**
 * Class for the Maze of the game.
 * 
 * @author Caitlin
 *
 */
public class Maze {
	private Tile tiles[][];
	private int rows;
	private int cols;
	private ArrayList<String> levels = new ArrayList();

	private String level;
	private int time;
	private ArrayList<Monster> monsters = new ArrayList();

	/**
	 * Constructor for the maze class.
	 * 
	 * @param rows  = number of rows in the maze.
	 * @param cols  = number of columns in the maze.
	 * @param level = level that this maze is for.
	 */
	public Maze(int rows, int cols, String level) {
		tiles = new Tile[rows][cols];
		this.rows = rows;
		this.cols = cols;
		this.level = level;
		levels.add("level-1");
		levels.add("level-2");
		levels.add("level-3");
		levels.add("level-4");
		levels.add("level-5");
		new FileReader().read(this, level, "levels.json");
	}

	/**
	 * Get the 2D array of tile for this maze.
	 * 
	 * @return Tile[][]
	 */
	public Tile[][] getTiles() {
		return tiles;
	}

	/**
	 * Method for debugging, prints the converted level to see
	 * if it looks correct.
	 */
	public void printConvertedLevel() {
		// Gets the width and height of the current level.
		int height = tiles[0].length;
		int width = tiles.length;

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				// Go to next line once end of line is reached.
				if (x == width - 1) {
					System.out.print(tiles[y][x].toString() + " ");

					System.out.println();
				} else {
					System.out.print(tiles[y][x].toString() + " ");
				}
			}
		}
	}

	/**
	 * Find Chap in the maze.
	 * 
	 * @return Chap.
	 */
	public Chap findChap() {
		Tile target;
		Chap chap = null;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				target = tiles[row][col];
				if (target instanceof Chap) {
					chap = (Chap) target;
				}
			}
		}
		return chap;
	}

	/**
	 * Get the neighbouring tile from a given position and
	 * direction
	 * 
	 * @param origin    - original position
	 * 
	 * @param direction - the direction to look in
	 * 
	 * @return - the corresponding neighbouring tile if there is
	 *         one, or null
	 */
	public Tile getNeighbouringTile(XYPos origin, char direction) {
		int x = origin.getX();
		int y = origin.getY();
		Tile originTile = tiles[y][x]; // row, col
		Tile destination;
		if (originTile == null)
			return null;

		// need to implement checks for going off the maze
		switch (direction) {
		case 'N':
			if (y - 1 < 0)
				return null;
			destination = tiles[y - 1][x];
//			destination.resetPosition(new XYPos(x, y - 1));
			break;
		case 'E':
			if (x + 1 >= cols)
				return null;
			destination = tiles[y][x + 1];
//			destination.resetPosition(new XYPos(x + 1, y));
			break;
		case 'S':
			if (y + 1 >= rows)
				return null;
			destination = tiles[y + 1][x];
//			destination.resetPosition(new XYPos(x, y + 1));
			break;
		default:// W
			if (x - 1 < 0)
				return null;
			destination = tiles[y][x - 1];
//			destination.resetPosition(new XYPos(x - 1, y));
			break;
		}

		return destination;
	}

	/**
	 * set a tile on the maze
	 * 
	 * @param pos  = position to set the tile at.
	 * @param tile = Tile to set.
	 * @return boolean
	 */
	public boolean setTile(XYPos pos, Tile tile) {
		int x = pos.getX();
		int y = pos.getY();
		tiles[y][x] = tile;
		return true;
	}

	/**
	 * Get a tile on the maze
	 * 
	 * @param x = x value to get the tile at.
	 * @param y = y value to get the tile at.
	 * @return Tile.
	 */
	public Tile getTile(int x, int y) {
		return tiles[x][y];
	}

	/**
	 * Change a tile on the maze to a free tile
	 * 
	 * @param target = Tile to change to free.
	 * 
	 * @param origin - the tile to be changed
	 * @return boolean.
	 */
	public boolean changeToFree(Tile target) {
		int x = target.getXPosition();
		int y = target.getYPosition();
//		System.out.printf("Setting tile at x:%d y:%d which is %s to FREE\n", x, y, tiles[y][x].toString());
		tiles[y][x] = new Free(x, y);
		return true;
	}

	/**
	 * @return - number of treasures remaining in this level
	 */
	public int remainingTreasure() {
		Tile target;
		int count = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				target = tiles[row][col];
				if (target instanceof Treasure)
					count++;
			}
		}
		return count;
	}

	/**
	 * Set the 2D array of tiles.
	 * 
	 * @param tiles2
	 */
	public void setTiles(Tile[][] tiles2) {
		tiles = tiles2;
	}

	/**
	 * Returns the level the character is currently on.
	 * 
	 * @return level
	 */
	public String getLevel() {
		level = level.replaceAll("[^0-9]+", " ");

		return level;
	}

	/**
	 * Get the next level name.
	 * 
	 * @return String
	 */
	public String getNextLevel() {
		int index = 0;
		for (int i = 0; i < levels.size(); i++) {
			if (levels.get(i).equals(level)) {
				index = i;
			}
		}
		index++;
		level = levels.get(index);
		return level;
	}

	/**
	 * Set the number of rows.
	 * 
	 * @param height = rows to set.
	 */
	public void setRow(int height) {
		rows = height;
	}

	/**
	 * Set the number of columns
	 * 
	 * @param width = cols to set.
	 */
	public void setCol(int width) {
		cols = width;
	}

	/**
	 * Gets the XYPos for new map.
	 * 
	 * @return x
	 */
	public XYPos getStartingPos() {
		XYPos spawn = null;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (tiles[row][col] instanceof Chap) {
					spawn = new XYPos(col, row);
				}
			}
		}

		return spawn;
	}

	public ArrayList<Monster> getMonsters() {
		return monsters;
	}

	public void addToMonsters(Monster m) {
		monsters.add(m);
	}

	/**
	 * Sets the time of maze.
	 * 
	 * @param time
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * Gets the time of maze.
	 * 
	 * @return time
	 */
	public int getTime() {
		return time;
	}
}