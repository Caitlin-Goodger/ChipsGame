package nz.ac.vuw.ecs.swen225.a3.maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.json.JsonValue;

import nz.ac.vuw.ecs.swen225.a3.application.Position;
import nz.ac.vuw.ecs.swen225.a3.maze.implementation.Chap;
import nz.ac.vuw.ecs.swen225.a3.maze.implementation.Monster;
import nz.ac.vuw.ecs.swen225.a3.maze.implementation.Treasure;
import nz.ac.vuw.ecs.swen225.a3.persistence.FileReader;

/**
 * Maze class is responsible for holding the current maze and it's parameters.
 */
public class Maze {
  private int currentLevel;
  private final int numberOfLevels = 2;

  private ArrayList<String> levels = new ArrayList<String>();

  private FileReader fileReader;

  private Tile[][] mazeLayout;
  private int width;
  private int height;
  private String levelName;
  private int timeLimit;
  private int moveCounter = 0;

  // Monster array.
  private List<Monster> monsters = new ArrayList<Monster>();

  /**
   * Constructor for Maze.
   * 
   * @param fileReader = the file reader
   * @param width      = the width of the maze
   * @param height     = the height of the maze
   * @param timeLimit  = the time limit of the maze
   * @param mapLayout  = the map layout of the maze
   */
  public Maze(FileReader fileReader, int width, int height, int timeLimit, Tile[][] mapLayout) {
    this.currentLevel = 1;

    this.fileReader = fileReader;

    this.levelName = fileReader.getLevelName();
    this.monsters = fileReader.getMonsters();

    this.width = width;
    this.height = height;
    this.timeLimit = timeLimit;
    this.mazeLayout = mapLayout;
    

    // Adds the levels, for loop so we don't have to write 100 lines for 100 levels
    for (int i = 1; i <= numberOfLevels; i++) {
      levels.add("level-" + i);
    }
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
   * Method for debugging, prints the converted level to see if it looks correct.
   * 
   * @return boolean
   */
  public boolean printConvertedLevel() {
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
    return true;
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
        }
      }
    }

    return chap;
  }

  /**
   * Gets the neighbouring tile.
   * 
   * @param origin    = the original position
   * @param direction = the direction you are checking
   * @return the destination of neighbouring tile
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
   * @param position = the position you want to set
   * @param tile     = the tile you want to set the position to
   * @return true if tile is set
   */
  public boolean setTile(Position position, Tile tile) {
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

    return true;
  }

  /**
   * Gets a tile on maze.
   * 
   * @param x = the x position of tile relative to maze
   * @param y = the y position of tile relative to maze
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

        if (target instanceof Treasure) {
          count++;
        }
      }
    }

    assert count >= 0;

    return count;
  }

  /**
   * Gets the next level.
   * 
   * @return boolean
   */
  public boolean getNextLevel() {
    // Gets the next level in array.
    if (this.currentLevel < levels.size()) {
      this.currentLevel++;
    }

    fileReader = new FileReader(levels.get(this.currentLevel - 1));
    fileReader.read("levels.json");

    this.width = fileReader.getWidth();
    this.height = fileReader.getHeight();
    this.timeLimit = fileReader.getTimeLimit();
    this.mazeLayout = fileReader.getMazeLayout();

    assert this.width >= 0 && this.height >= 0 && this.timeLimit >= 0 && this.mazeLayout != null;

    this.levelName = fileReader.getLevelName();
    this.monsters = fileReader.getMonsters();

    assert this.levelName != null && this.monsters != null;
    return true;
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

  /**
   * Get the fileReader of this maze.
   * 
   * @return FileReader
   */
  public FileReader getFileReader() {
    return fileReader;
  }

  /**
   * Gets Chap character.
   * 
   * @return chap
   */
  public Chap getChap() {
    return findChap();
  }

  /**
   * Set the tiles. 
   * @param mazeLayout2 = maze to set. 
   */
  public void setTiles(Tile[][] mazeLayout2) {
    // TODO Auto-generated method stub
    mazeLayout = mazeLayout2;
  }
  
  /**
   * Get the move counter.
   * @return int
   */
  public int getMoveCounter() {
    return moveCounter;
  }

  /**
   * Record the state of the current board.
   */
  public void record() {
    fileReader.saveRecord(this, moveCounter);
    moveCounter++;
  }
}