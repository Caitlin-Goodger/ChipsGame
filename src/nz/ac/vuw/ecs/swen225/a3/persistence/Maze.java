package nz.ac.vuw.ecs.swen225.a3.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nz.ac.vuw.ecs.swen225.a3.maze.Chap;
import nz.ac.vuw.ecs.swen225.a3.maze.Monster;
import nz.ac.vuw.ecs.swen225.a3.maze.Treasure;
import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Maze class is responsible for holding the current maze
 * and it's parameters.
 */
public class Maze {
	private static int currentLevel;

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
	 * @param fileReader
	 * @param width
	 * @param height
	 * @param timeLimit
	 * @param mapLayout
	 */
	public Maze(FileReader fileReader, int width, int height, int timeLimit, Tile[][] mapLayout) {
		Maze.currentLevel = 1;

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
	}

	/**
	 * Get the 2D array of tiles for this maze.
	 * 
	 * @return Tile[][]
	 */
	public Tile[][] getTiles() {
		assert this.mazeLayout != null;

		return this.mazeLayout;
	}

	/**
	 * Method for debugging, prints the converted level to see
	 * if it looks correct.
	 */
	public void printConvertedLevel() {
		for (int row = 0; row < this.height; row++) {
			for (int col = 0; col < this.width; col++) {
				// Go to next line once end of line is reached.
				if (col == this.width - 1) {
					System.out.print(this.mazeLayout[row][col].toString() + " ");

					System.out.println();
				} else {
					System.out.print(this.mazeLayout[row][col].toString() + " ");
				}
			}
		}
	}

	/**
	 * Find Chap in the maze.
	 * 
	 * @return chap
	 */
	public Chap findChap() {
		Tile target = null;
		Chap chap = null;

		for (int row = 0; row < this.height; row++) {
			for (int col = 0; col < this.width; col++) {
				target = mazeLayout[row][col];

				if (target instanceof Chap) {
					chap = (Chap) target;

					assert chap == target;
				}
			}
		}

		return chap;
	}

	/**
	 * Gets the neighbouring tile.
	 * 
	 * @param origin
	 * @param direction
	 * @return
	 */
	public Tile getNeighbouringTile(Position origin, Character direction) {
		if (origin == null) {
			throw new IllegalArgumentException("Argument must be a Position.");
		}

		if (direction == null) {
			throw new IllegalArgumentException("Argument must be a Character.");
		}

		int col = origin.getX();
		int row = origin.getY();

		Tile originTile = mazeLayout[row][col];
		Tile destination;

		if (originTile == null) {
			return null;
		}

		switch (direction) {
		case 'N':
			if (row - 1 < 0) {
				return null;
			}

			destination = mazeLayout[row - 1][col];

			break;
		case 'E':
			if (col + 1 >= width) {
				return null;
			}

			destination = mazeLayout[row][col + 1];

			break;
		case 'S':
			if (row + 1 >= height) {
				return null;
			}

			destination = mazeLayout[row + 1][col];

			break;
		default: // W
			if (col - 1 < 0) {
				return null;
			}

			destination = mazeLayout[row][col - 1];
		}

		assert destination != null;

		return destination;
	}

	/**
	 * Sets a tile on the maze.
	 * 
	 * @param position
	 * @param tile
	 */
	public void setTile(Position position, Tile tile) {
		if (position == null) {
			throw new IllegalArgumentException("Argument must be a Position.");
		}

		if (tile == null) {
			throw new IllegalArgumentException("Argument must be a Tile.");
		}

		int x = position.getX();
		int y = position.getY();

		this.mazeLayout[y][x] = tile;

		assert this.mazeLayout[y][x] == tile;
	}

	/**
	 * Gets a tile on maze.
	 * 
	 * @param x
	 * @param y
	 * @return mazeLayout
	 */
	public Tile getTile(int x, int y) {
		if (x < 0) {
			throw new IllegalArgumentException("Argument must be greater than 0.");
		}

		if (y < 0) {
			throw new IllegalArgumentException("Argument must be greater than 0.");
		}

		assert this.mazeLayout[x][y] != null;

		return this.mazeLayout[x][y];
	}

	/**
	 * Gets the number of treasure remaining.
	 * 
	 * @return count
	 */
	public int remainingTreasure() {
		Tile target;
		int count = 0;

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				target = mazeLayout[row][col];

				assert target != null;

				if (target instanceof Treasure)
					count++;
			}
		}

		assert count >= 0;

		return count;
	}

	/**
	 * Gets the next level.
	 */
	public void getNextLevel() {
		// Gets the next level in array.
		if (Maze.currentLevel < levels.size()) {
			Maze.currentLevel++;
		}

		fileReader = new FileReader(levels.get(Maze.currentLevel - 1));
		fileReader.read();

		this.width = fileReader.getWidth();
		this.height = fileReader.getHeight();
		this.timeLimit = fileReader.getTimeLimit();
		this.mazeLayout = fileReader.getMazeLayout();

		assert this.width >= 0 && this.height >= 0 && this.timeLimit >= 0
				&& this.mazeLayout != null;

		this.levelName = fileReader.getLevelName();
		this.monsters = fileReader.getMonsters();

		assert this.levelName != null && this.monsters != null;
	}

	/**
	 * Gets the position chap will spawn on the new maze.
	 * 
	 * @return spawn
	 */
	public Position getSpawn() {
		Position spawn = null;

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (mazeLayout[row][col] instanceof Chap) {
					spawn = new Position(col, row);
				}
			}
		}

		assert spawn != null;

		return spawn;
	}

	/**
	 * Gets the list of monsters.
	 * 
	 * @return monsters
	 */
	public List<Monster> getMonsters() {
		assert this.monsters != null;

		return Collections.unmodifiableList(this.monsters);
	}

	/**
	 * Gets the time of maze.
	 * 
	 * @return timeLimit
	 */
	public int getTime() {
		assert this.timeLimit >= 0;

		return this.timeLimit;
	}

	/**
	 * Gets the name of the level.
	 * 
	 * @return levelName
	 */
	public String getLevelName() {
		assert this.levelName != null;

		return this.levelName;
	}
}