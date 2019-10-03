package nz.ac.vuw.ecs.swen225.a3.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nz.ac.vuw.ecs.swen225.a3.maze.Chap;
import nz.ac.vuw.ecs.swen225.a3.maze.Monster;
import nz.ac.vuw.ecs.swen225.a3.maze.Tile;
import nz.ac.vuw.ecs.swen225.a3.maze.Treasure;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Class for the Maze of the game.
 * 
 * @author Caitlin
 *
 */
public class Maze {
	private ArrayList<String> levels = new ArrayList<String>();

	private FileReader fileReader;
	
	private Tile mazeLayout[][];
	private int width, height;
	private String levelName;
	private int timeLimit;

	// Monster array.
	private List<Monster> monsters = new ArrayList<Monster>();

	/**
	 * Constructor for Maze.
	 * 
	 * @param width
	 * @param height
	 * @param levelName
	 */
	public Maze(FileReader fileReader, int width, int height, int timeLimit, Tile[][] mapLayout) {
		this.fileReader = fileReader;
		
		this.levelName = fileReader.getLevelName();
		this.monsters = fileReader.getMonsters();
		
		this.width = width;
		this.height = height;
		this.timeLimit = timeLimit;
		this.mazeLayout = mapLayout;

		// Adds the levels.
		levels.add("level-1");
		levels.add("level-2");
		levels.add("level-3");
	}

	/**
	 * Get the 2D array of tile for this maze.
	 * 
	 * @return Tile[][]
	 */
	public Tile[][] getTiles() {
		return mazeLayout;
	}

	/**
	 * Method for debugging, prints the converted level to see
	 * if it looks correct.
	 */
	public void printConvertedLevel() {
		// Gets the width and height of the current level.
		int height = mazeLayout[0].length;
		int width = mazeLayout.length;

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				// Go to next line once end of line is reached.
				if (x == width - 1) {
					System.out.print(mazeLayout[y][x].toString() + " ");

					System.out.println();
				} else {
					System.out.print(mazeLayout[y][x].toString() + " ");
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
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				target = mazeLayout[row][col];
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
	public Tile getNeighbouringTile(Position origin, char direction) {
		int x = origin.getX();
		int y = origin.getY();
		Tile originTile = mazeLayout[y][x]; // row, col
		Tile destination;
		if (originTile == null)
			return null;

		// need to implement checks for going off the maze
		switch (direction) {
		case 'N':
			if (y - 1 < 0)
				return null;
			destination = mazeLayout[y - 1][x];
//			destination.resetPosition(new XYPos(x, y - 1));
			break;
		case 'E':
			if (x + 1 >= width)
				return null;
			destination = mazeLayout[y][x + 1];
//			destination.resetPosition(new XYPos(x + 1, y));
			break;
		case 'S':
			if (y + 1 >= height)
				return null;
			destination = mazeLayout[y + 1][x];
//			destination.resetPosition(new XYPos(x, y + 1));
			break;
		default:// W
			if (x - 1 < 0)
				return null;
			destination = mazeLayout[y][x - 1];
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
	public boolean setTile(Position pos, Tile tile) {
		int x = pos.getX();
		int y = pos.getY();
		mazeLayout[y][x] = tile;
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
		return mazeLayout[x][y];
	}

	/**
	 * @return - number of treasures remaining in this level
	 */
	public int remainingTreasure() {
		Tile target;
		int count = 0;
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				target = mazeLayout[row][col];
				if (target instanceof Treasure)
					count++;
			}
		}
		return count;
	}

	/**
	 * Set the 2D array of tiles.
	 * 
	 * @param tile
	 */
	public void setTiles(Tile[][] tile) {
		mazeLayout = tile;
	}

	/**
	 * Get the next level name.
	 * 
	 * @return String
	 */
	public void getNextLevel() {
		fileReader = new FileReader("level-2");
		fileReader.read();
		fileReader.createMaze();
		
		this.width = fileReader.getWidth();
		this.height = fileReader.getHeight();
		this.timeLimit = fileReader.getTimeLimit();
		this.mazeLayout = fileReader.getMazeLayout();
		
		this.levelName = fileReader.getLevelName();
		this.monsters = fileReader.getMonsters();
	}

	/**
	 * Set the height.
	 * 
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Set the width.
	 * 
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the XYPos for new map.
	 * 
	 * @return spawn
	 */
	public Position getStartingPos() {
		Position spawn = null;

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (mazeLayout[row][col] instanceof Chap) {
					spawn = new Position(col, row);
				}
			}
		}

		return spawn;
	}

	public List<Monster> getMonsters() {
		return Collections.unmodifiableList(this.monsters);
	}

	/**
	 * Sets the time of maze.
	 * 
	 * @param time
	 */
	public void setTime(int time) {
		this.timeLimit = time;
	}

	/**
	 * Gets the time of maze.
	 * 
	 * @return time
	 */
	public int getTime() {
		return timeLimit;
	}

	/**
	 * Gets the name of the level.
	 * 
	 * @return levelName
	 */
	public String getLevelName() {
		return levelName;
	}
}