package nz.ac.vuw.ecs.swen225.a3.maze;

import java.util.List;

import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Chap;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Exit;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.ExitLock;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Free;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.InfoField;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Key;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.LockedDoor;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Monster;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Treasure;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Wall;
import nz.ac.vuw.ecs.swen225.a3.util.Position;
import nz.ac.vuw.ecs.swen225.a3.util.TimeLimit;

/**
 * Game class. Where all the game logic is.
 * 
 * @author Caitlin
 *
 */
public class Game {
  private Maze maze;
  private Chap chap;

  private InfoField info;
  private boolean onField = false;

  private TimeLimit tl;

  /**
   * Constructor for the Game.
   * 
   * @param maze = maze for the game.
   */
  public Game(Maze maze) {
    this.maze = maze;

    if (!setMaze(maze)) {
      throw new RuntimeException(
          "Unable to create Game due to aMaze. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (this.maze.findChap() == null) {
      throw new RuntimeException("did not locate chap on map!");
    }

    this.chap = this.maze.findChap();
  }

  /**
   * Get the maze.
   * 
   * @return Maze.
   */
  public Maze getMaze() {
    return this.maze;
  }

  /**
   * Set the Maze.
   * 
   * @param maze = the maze you want to set
   * @return boolean.
   */
  public boolean setMaze(Maze maze) {
    boolean wasSet = false;
    if (maze != null) {
      this.maze = maze;
      wasSet = true;
    }
    return wasSet;
  }

  /**
   * Move all the monsters.
   */
  public void moveMonsters() {
    List<Monster> monsters = maze.getMonsters();

    for (int i = 0; i < monsters.size(); i++) {
      Monster m = monsters.get(i);
      m.move(this);
    }
  }

  /**
   * update chap's location in the given direction if its applicable.
   * 
   * @param direction - the desired direction to move in
   */
  public void move(char direction) {
    onField = false;

    Tile destination = maze.getNeighbouringTile(chap.getCurrentPosition(), direction);
    if (destination == null) {
      // do nothing
    } else if (destination instanceof Wall) {
      // do nothing
    } else if (destination instanceof Free) {
      moveChap(direction, destination);
    } else if (destination instanceof Key) {
      // pickup the key
      chap.pickupItem(destination);
      // remove key from map
      // maze.changeToFree(destination);
      // move chap in direction
      moveChap(direction, destination);
    } else if (destination instanceof LockedDoor) {
      LockedDoor door = (LockedDoor) destination;
      if (door.canUnlock(chap)) {
        // change the key tile to free
        // maze.changeToFree(destination);
        // move chap in direction
        moveChap(direction, destination);
        // remove the used key from chap's inventory
        // chap.removeItem(door.getColour(), "Key"); //removes key
        // from inventory
      } else {
        // do nothing
      }
    } else if (destination instanceof Treasure) {
      // remove treasure from map
      // maze.changeToFree(destination);
      // move chap in direction
      moveChap(direction, destination);
    } else if (destination instanceof InfoField) {
      info = (InfoField) this.getMaze().getTile(destination.getYPosition(),
          destination.getXPosition());

      onField = true;

      // move chap in direction
      moveChap(direction, destination);
      // displayInfo
      // ...........
    } else if (destination instanceof ExitLock) {
      // check if there is still treasure to collect
      if (maze.remainingTreasure() != 0) {
        // do nothing
      } else {
        moveChap(direction, destination);

      }
    } else if (destination instanceof Exit) {
      maze.getFileReader().save(maze);
      maze.getNextLevel();
      this.getChap().resetPlayer(this.getMaze());
      tl.setTime(maze.getTime()); // Set time at the moment, implement time for each level.
    }
  }

  /**
   * *Only called by the above move class Move chap in the given direction, and
   * re-fresh the tile he WAS on by replacing it with chap's current onTile, and
   * update onTile for chap.
   * 
   * @param direction       = direction to move.
   * @param destinationTile = tile to move to.
   */
  public void moveChap(Character direction, Tile destinationTile) {
    Position originalPos = new Position(chap.getXPosition(), chap.getYPosition());
    // move chap in direction
    chap.updatePosition(direction);
    Position destinationPos = chap.getCurrentPosition();
    maze.setTile(originalPos, chap.getOnTile());
    maze.setTile(destinationPos, chap);
    // update onTile for chap
    chap.setOnTile(destinationTile);

  }

  /**
   * Returns the chap.
   * 
   * @return chap
   */
  public Chap getChap() {
    return chap;
  }

  /**
   * Returns the info field.
   * 
   * @return info
   */
  public InfoField getInfoField() {
    return info;
  }

  /**
   * Returns if chap is on field.
   * 
   * @return onField
   */
  public boolean onField() {
    return onField;
  }

  /**
   * Sets the time limit in game.
   * 
   * @param tl = the time limit you want to set
   */
  public void setTimeLimit(TimeLimit tl) {
    this.tl = tl;
  }

  /**
   * Set where chap is by finding him. 
   */
  public void setChap() {
    this.chap = this.maze.findChap();
  }

 
}