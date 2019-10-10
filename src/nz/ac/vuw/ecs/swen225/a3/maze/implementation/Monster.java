package nz.ac.vuw.ecs.swen225.a3.maze.implementation;

import nz.ac.vuw.ecs.swen225.a3.application.Position;
import nz.ac.vuw.ecs.swen225.a3.maze.Tile;

/**
 * Monster class is responsible for the position and movement of the monsters.
 */
public class Monster implements Tile {
  private Position currentPosition;
  private Tile onTile;
  private String monsterPattern;
  private int currentPattern;
  private Character direction;

  /**
   * Constructor for the monster.
   * 
   * @param x  = x position relative to maze
   * @param y  = y position relative to maze
   * @param mp = monster pattern
   */
  public Monster(int x, int y, String mp) {
    this.currentPosition = new Position(x, y);
    this.onTile = new Free(x, y);
    this.monsterPattern = mp;
    currentPattern = 0;
    direction = 'N';
  }

  /**
   * Move monster accordingly to the pattern.
   */
  public void move() {
     direction = monsterPattern.charAt(currentPattern);
    updatePosition(direction);
    currentPattern++;
    if (currentPattern >= monsterPattern.length()) {
      currentPattern = 0;
    }
  }

  /**
   * Set the onTile of the monster.
   * 
   * @param tile = the tile you want onTile to
   * @return boolean
   */
  public boolean setOnTile(Tile tile) {
    if (tile == null) {
      throw new IllegalArgumentException("Argument must be a Tile.");
    }

    this.onTile = tile;

    assert this.onTile != null;

    if (this.onTile == tile) {
      return true;
    }

    return false;
  }

  /**
   * Update the position of the monster.
   * 
   * @param direction = direction you want the monster to go
   * @return true if position updated
   */
  public boolean updatePosition(Character direction) {
    if (direction == null) {
      throw new IllegalArgumentException("Argument must be a Character.");
    }

    if (direction == 'N') {
      this.currentPosition.updatePosition(0, 1);
    } else if (direction == 'S') {
      this.currentPosition.updatePosition(0, -1);
    } else if (direction == 'E') {
      this.currentPosition.updatePosition(1, 0);
    } else if (direction == 'W') {
      this.currentPosition.updatePosition(-1, 0);
    }

    // Make sure direction was set, if so then current position
    // of monster will be updated.
    assert direction == 'N' || direction == 'S' || direction == 'E' || direction == 'W';

    return true;
  }

  /**
   * Get the current Direction
   * @return 
   * Returns direction character is facing
   */
  public Character getDirection() {
    return direction;
  }
 
  /**
   * Get the path of the image.
   */
  @Override
  public String getImagePath() {
    return "resources/CC14.png";
  }

  /**
   * Get the y-coordinate of the monster.
   */
  @Override
  public int getYPosition() {
    assert this.currentPosition != null;

    return this.currentPosition.getY();
  }

  /**
   * Get the x co-ordinate of the tile on the grid.
   */
  @Override
  public int getXPosition() {
    assert this.currentPosition != null;

    return this.currentPosition.getX();
  }

  /**
   * Turns the tile into a string. Used for debugging.
   */
  @Override
  public String toString() {
    return "M";
  }

  @Override
  public int getValue() {
    return 5;
  }

  /**
   * Returns the current position.
   * 
   * @return currentPosition
   */
  public Position getCurrentPosition() {
    return currentPosition;
  }
}
