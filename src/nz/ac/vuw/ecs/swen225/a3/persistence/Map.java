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
import nz.ac.vuw.ecs.swen225.a3.maze.Maze;
import nz.ac.vuw.ecs.swen225.a3.maze.Tile;
import nz.ac.vuw.ecs.swen225.a3.maze.Treasure;
import nz.ac.vuw.ecs.swen225.a3.maze.Wall;

public class Map {

	/**
	 * Constructor for the Map class.
	 */
	public Map() {

	}

	/**
	 * Read in the json file. Levels are stored as a 2D array of
	 * ints.
	 */
	public boolean readFile(Maze maze, String levelName, String filename) {
		try {
			int keyColor = 0;
			int doorColor = 0;
			int infoID = 0;
			InputStream input = new FileInputStream(filename);
			JsonReader reader = Json.createReader(input);
			JsonObject obj = reader.readObject();
			JsonObject level = obj.getJsonObject(levelName);
			int width = level.getInt("width");
			int height = level.getInt("height");
			JsonArray jTiles = level.getJsonArray("tiles");
			Tile[][] tiles = new Tile[width][height];
			maze.setRow(height);
			maze.setCol(width);
			for (int i = 0; i < width; i++) {
				JsonArray array = jTiles.getJsonArray(i);
				for (int j = 0; j < height; j++) {
					int value = array.getInt(j);
					Tile tile;
					switch (value) {
					case 0:
//						tile = new Free(i, j, i, j);
						tile = new Free(j, i, j, i);
						break;
					case 1:
//						tile = new Wall(i, j, i, j);
						tile = new Wall(j, i, j, i);
						break;
					case 2:
//						tile = new Chap(i, j, i, j);
						tile = new Chap(j, i, j, i);
						break;
					case 3:
//						tile = new Exit(i, j, i, j);
						tile = new Exit(j, i, j, i);
						break;
					case 4:
//						tile = new ExitLock(i, j, i, j);
						tile = new ExitLock(j, i, j, i);
						break;
					case 5:
						if (keyColor == 0) {
//							tile = new Key("yellow", i, j, i, j);
							tile = new Key("yellow", j, i, j, i);
							keyColor++;
							break;
						} else if (keyColor == 1) {
//							tile = new Key("blue", i, j, i, j);
							tile = new Key("blue", j, i, j, i);
							keyColor--;
							break;
						}
					case 6:
						if (doorColor == 0) {
//							tile = new LockedDoor("yellow", i, j, i, j);
							doorColor++;
							tile = new LockedDoor("yellow", j, i, j, i);
							break;
						} else if (doorColor == 1) {
//							tile = new LockedDoor("blue", i, j, i, j);
							doorColor--;
							tile = new LockedDoor("blue", j, i, j, i);
							break;
						}
					case 7:
						// tile = new InfoField("Info Field",i, j, i, j);\
						if (infoID == 0) {
							tile = new InfoField(
									"<html>" +
									"Welcome to Chip's Challenge! <br>" +
									"Collect the correct key colours <br>" +
									"to unlock the doors and <br>" +
									"collect all the treasure!" +
									"<html>",
									j, i, j, i);
							break;
						}
					default:
//						tile = new Treasure(i, j, i, j);
						tile = new Treasure(j, i, j, i);
					}

					tiles[i][j] = tile;
				}
				maze.setTiles(tiles);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}

//	public static void main(String[] args) {
//		Map m = new Map();
//		//m.readFile();
//	}
}
