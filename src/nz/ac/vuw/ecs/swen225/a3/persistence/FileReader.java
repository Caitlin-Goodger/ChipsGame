package nz.ac.vuw.ecs.swen225.a3.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import nz.ac.vuw.ecs.swen225.a3.maze.Chap;
import nz.ac.vuw.ecs.swen225.a3.maze.Exit;
import nz.ac.vuw.ecs.swen225.a3.maze.ExitLock;
import nz.ac.vuw.ecs.swen225.a3.maze.Free;
import nz.ac.vuw.ecs.swen225.a3.maze.InfoField;
import nz.ac.vuw.ecs.swen225.a3.maze.Key;
import nz.ac.vuw.ecs.swen225.a3.maze.LockedDoor;
import nz.ac.vuw.ecs.swen225.a3.maze.Monster;
import nz.ac.vuw.ecs.swen225.a3.maze.Tile;
import nz.ac.vuw.ecs.swen225.a3.maze.Treasure;
import nz.ac.vuw.ecs.swen225.a3.maze.Wall;

/**
 * FileReader class is responsible for reading in a file to
 * get a maze's parameters and then create the maze.
 *
 */
public class FileReader {
	// Variables for constructor.
	private String levelName;
	private String fileName;

	// Variables that will be read in.
	private int width, height;
	private int timeLimit;
	private Tile[][] mazeLayout;

	// Variables for monsters.
	private List<Monster> monsters = new ArrayList<Monster>();
	
	// Variables for reader.
	private InputStream input;
	private JsonReader reader;
	private JsonObject obj;
	private JsonObject level;

	/**
	 * Constructor for the Map class.
	 */
	public FileReader(String levelName) {
		this.levelName = levelName;

		// This never changes, so I decided to hard code.
		this.fileName = "levels.json";
	}

	/**
	 * Reads the file and gets the width, height and time limit.
	 */
	public void read() {
		try {
			input = new FileInputStream(fileName);
			reader = Json.createReader(input);
			obj = reader.readObject();
			level = obj.getJsonObject(levelName);

			// Holds the parameters of the maze read.
			width = level.getInt("width");
			height = level.getInt("height");
			timeLimit = level.getInt("time");
			mazeLayout = new Tile[width][height];
		} catch (FileNotFoundException e) {
			throw new Error("File not found.", e);
		}
	}

	/**
	 * Creates the maze.
	 */
	public void createMaze() {
		int keyColor = 0;
		int doorColor = 0;
		int infoFieldID = 0;

		JsonArray jsonArray = level.getJsonArray("tiles");

		for (int col = 0; col < width; col++) {
			JsonArray array = jsonArray.getJsonArray(col);

			for (int row = 0; row < height; row++) {
				Tile tile;

				switch (array.getInt(row)) {
				case 0:
					tile = new Free(row, col);
					break;
				case 1:
					tile = new Wall(row, col);
					break;
				case 2:
					tile = new Chap(row, col);
					break;
				case 3:
					tile = new Exit(row, col);
					break;
				case 4:
					tile = new ExitLock(row, col);
					break;
				case 5:
					tile = new Monster(row, col);
					Monster m = (Monster) tile;
					addMonster(m);
					break;
				case 7:
					if (infoFieldID == 0) {
						tile = new InfoField("<html>" + "Welcome to Chip's Challenge! <br>"
								+ "Collect the correct key colours <br>"
								+ "to unlock the doors and <br>" + "collect all the treasure!"
								+ "<html>", row, col);
						break;
					}
				case 8:
					tile = new Treasure(row, col);
					break;
				case 9:
					tile = new Key("red", row, col);
					break;
				case 10:
					tile = new Key("blue", row, col);
					break;
				case 11:
					tile = new Key("green", row, col);
					break;
				case 12:
					tile = new Key("yellow", row, col);
					break;
				case 13:
					tile = new LockedDoor("red", row, col);
					break;
				case 14:
					tile = new LockedDoor("blue", row, col);
					break;
				case 15:
					tile = new LockedDoor("green", row, col);
					break;
				case 16:
					tile = new LockedDoor("yellow", row, col);
					break;
				default:
					tile = new Free(row, col);
					break;
				}

				mazeLayout[col][row] = tile;
			}
		}
	}

	/**
	 * Return the width of read maze.
	 * 
	 * @return width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Return the height of read maze.
	 * 
	 * @return height
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Return the time limit of read maze.
	 * 
	 * @return timeLimit
	 */
	public int getTimeLimit() {
		return this.timeLimit;
	}

	/**
	 * Returns the layout of the maze.
	 * 
	 * @return mazeLayout
	 */
	public Tile[][] getMazeLayout() {
		return this.mazeLayout;
	}
	
	/**
	 * Return the name of level.
	 * 
	 * @return levelName
	 */
	public String getLevelName() {
		return this.levelName;
	}
	
	/**
	 * Returns the array of monsters.
	 * 
	 * @param monster
	 * @return 
	 */
	public List<Monster> getMonsters() {
		return Collections.unmodifiableList(this.monsters);
	}
	
	/**
	 * Add monster.
	 * 
	 * @param monster
	 */
	private void addMonster(Monster monster) {
		this.monsters.add(monster);
	}
}
