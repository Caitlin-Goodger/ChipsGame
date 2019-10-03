package nz.ac.vuw.ecs.swen225.a3.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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
 * Map class used for reading and saving to files.
 * 
 * @author Caitlin
 *
 */
public class FileReader {

	/**
	 * Constructor for the Map class.
	 */
	public FileReader() {

	}

	/**
	 * Read in the level json file. Levels are stored as a 2D
	 * array of integers.
	 * 
	 * @param maze      = Maze to set to.
	 * @param levelName = level to read in from file.
	 * @param filename  = file name that level is stored in.
	 * @return boolean.
	 */
	public boolean read(Maze maze, String levelName, String filename) {
		try {
			int keyColor = 0;
			int doorColor = 0;
			int infoID = 0;
			InputStream input = new FileInputStream(filename);
			JsonReader reader = Json.createReader(input);
			JsonObject obj = reader.readObject();
			JsonObject level = obj.getJsonObject(levelName);
			// JsonObject level = obj.getJsonObject("level-2");
			int width = level.getInt("width");
			int height = level.getInt("height");
			int time = level.getInt("time");
			JsonArray jTiles = level.getJsonArray("tiles");
			Tile[][] tiles = new Tile[width][height];
			maze.setRow(height);
			maze.setCol(width);
			maze.setTime(time);
			for (int i = 0; i < width; i++) {
				JsonArray array = jTiles.getJsonArray(i);
				for (int j = 0; j < height; j++) {
					int value = array.getInt(j);
					Tile tile;
					switch (value) {
					case 0:
						tile = new Free(j, i);
						break;

					case 1:
						tile = new Wall(j, i);
						break;

					case 2:
						tile = new Chap(j, i);
						break;

					case 3:
						tile = new Exit(j, i);
						break;

					case 4:
						tile = new ExitLock(j, i);
						break;
					case 5:
						tile = new Monster(j, i);
						Monster m = (Monster) tile;
						maze.addToMonsters(m);
						break;

					case 7:
						if (infoID == 0) {
							tile = new InfoField("<html>" + "Welcome to Chip's Challenge! <br>"
									+ "Collect the correct key colours <br>"
									+ "to unlock the doors and <br>" + "collect all the treasure!"
									+ "<html>", j, i);
							break;
						}

					case 8:
						tile = new Treasure(j, i);
						break;

					case 9:
						tile = new Key("red", j, i);
						break;

					case 10:
						tile = new Key("blue", j, i);
						break;

					case 11:
						tile = new Key("green", j, i);
						break;

					case 12:
						tile = new Key("yellow", j, i);
						break;

					case 13:
						tile = new LockedDoor("red", j, i);
						break;

					case 14:
						tile = new LockedDoor("blue", j, i);
						break;

					case 15:
						tile = new LockedDoor("green", j, i);
						break;

					case 16:
						tile = new LockedDoor("yellow", j, i);
						break;

					default:
						tile = new Free(j, i);
						break;
					}

					tiles[i][j] = tile;
				}
				maze.setTiles(tiles);
			}
		} catch (FileNotFoundException e) {
			throw new Error("File not found.", e);
		}

		// Return true if file successfully read.
		return true;
	}
}
