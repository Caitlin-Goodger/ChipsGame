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
import nz.ac.vuw.ecs.swen225.a3.maze.Treasure;
import nz.ac.vuw.ecs.swen225.a3.maze.Wall;
import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;

/**
 * FileReader class is responsible for reading in a file to get a maze's
 * parameters and then creating the maze.
 */
public class FileReader {
  // Variables for constructor.
  private String levelName;
  private String fileName;

  // Variables that will be read in.
  private int width;
  private int height;
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
   * Constructor for the file reader.
   * 
   * @param levelName = the name of the level
   */
  public FileReader(String levelName) {
    this.levelName = levelName;

    // This never changes, so I decided to hard code.
    this.fileName = "levels.json";
  }

  /**
   * Reads the file and gets the width, height and time limit.
   * 
   * @return true if successfully read
   */
  public boolean read() {
    try {
      this.input = new FileInputStream(fileName);
      this.reader = Json.createReader(input);
      this.obj = reader.readObject();
      this.level = obj.getJsonObject(levelName);

      // Holds the parameters of the maze read.
      this.width = level.getInt("width");
      this.height = level.getInt("height");
      this.timeLimit = level.getInt("time");
      this.mazeLayout = new Tile[width][height];

      assert this.width != -1 && this.height != -1 && this.timeLimit != -1
          && this.mazeLayout != null;

      boolean mazeCreated = createMazeLayout();

      assert mazeCreated;

      return true;
    } catch (FileNotFoundException e) {
      throw new Error("File not found.", e);
    }
  }

  /**
   * Creates the maze layout.
   */
  private boolean createMazeLayout() {
    JsonArray jsonArray = level.getJsonArray("tiles");

    if (jsonArray == null) {
      throw new NullPointerException("Array does not exist.");
    }

    for (int col = 0; col < width; col++) {
      JsonArray array = jsonArray.getJsonArray(col);

      if (array == null) {
        throw new NullPointerException("Array does not exist.");
      }

      for (int row = 0; row < height; row++) {
        Tile tile = null;

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
            tile = new InfoField("null", row, col);
  
            InfoField infoField = (InfoField) tile;
            String text = null;
  
            // ID is static therefore each info field id will be unique.
            // Allows for unique messages.
            switch (infoField.getID()) {
              case 0:
                text = "Welcome player!";
    
                break;
              case 1:
                text = "You have reached the second level!";
    
                break;
              default:
                text = "Please add message.";
            }
  
            infoField.setInfoFieldText(text);

          assert infoField.getInfoFieldText().equals(text);

            break;
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
        }

        assert tile != null;

        this.mazeLayout[col][row] = tile;

        assert this.mazeLayout[col][row] == tile; // Ensure tile set.
      }
    }

    // Make sure the maze is not null and has the correct width
    // and height after it has been created.
    assert this.mazeLayout != null && this.mazeLayout[0].length == this.width
        && this.mazeLayout.length == this.height;

    if (this.mazeLayout != null && this.mazeLayout[0].length == this.width
        && this.mazeLayout.length == this.height) {
      return true;
    }

    return false;
  }

  /**
   * Return the width of read maze.
   * 
   * @return width
   */
  public int getWidth() {
    assert this.width != -1;

    return this.width;
  }

  /**
   * Return the height of read maze.
   * 
   * @return height
   */
  public int getHeight() {
    assert this.height != -1;

    return this.height;
  }

  /**
   * Return the time limit of read maze.
   * 
   * @return timeLimit
   */
  public int getTimeLimit() {
    assert this.timeLimit != -1;

    return this.timeLimit;
  }

  /**
   * Returns the layout of the maze.
   * 
   * @return mazeLayout
   */
  public Tile[][] getMazeLayout() {
    assert this.mazeLayout != null;

    return this.mazeLayout;
  }

  /**
   * Return the name of level.
   * 
   * @return levelName
   */
  public String getLevelName() {
    assert this.levelName != null;

    return this.levelName;
  }

  /**
   * Returns the array of monsters.
   * 
   * @return monsters
   */
  public List<Monster> getMonsters() {
    assert this.monsters != null;

    return Collections.unmodifiableList(this.monsters);
  }

  /**
   * Add monster.
   * 
   * @param monster = the monster you want to add
   */
  private void addMonster(Monster monster) {
    if (monster == null) {
      throw new IllegalArgumentException("Argument must be a Monster.");
    }

    this.monsters.add(monster);

    assert this.monsters.contains(monster);
  }
}
