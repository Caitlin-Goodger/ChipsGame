package nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl;

import nz.ac.vuw.ecs.swen225.a3.maze.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * LockedDoor class is responsible for keeping the position of the locked door.
 */
public class LockedDoor implements Tile {
  private String colour;
  private boolean isSolid = true;
  private Position currentPosition;

  /**
   * Constructor for the locked door.
   * 
   * @param colour = the colour of the door
   * @param x      = x position relative to maze
   * @param y      = y position relative to maze
   */
  public LockedDoor(String colour, int x, int y) {
    this.colour = colour;
    this.currentPosition = new Position(x, y);
  }

  /**
   * Sets the colour of the locked door.
   * 
   * @param colour = the colour you want to set the door to
   */
  public void setColour(String colour) {
    if (colour == null) {
      throw new IllegalArgumentException("Argument must be a String.");
    }

    this.colour = colour;

    assert this.colour != null;
  }

  /**
   * Gets the colour of the locked door.
   * 
   * @return colour
   */
  public String getColour() {
    assert this.colour != null;

    return this.colour;
  }

  /**
   * Checks if the player can unlock the door.
   * 
   * @param chap = checks if player can unlock
   * @return whether or not door can be unlocked
   */
  public boolean canUnlock(Chap chap) {
    if (chap == null) {
      throw new IllegalArgumentException("Argument must be a Chap.");
    }

    return chap.canUnlock(this);
  }

  /**
   * Get the path of the image.
   */
  @Override
  public String getImagePath() {
    return this.isSolid == true ? "resources/CC11.png" : "resources/CC2.png";
  }

  /**
   * Get the y-coordinate of the locked door.
   */
  @Override
  public int getYPosition() {
    assert this.currentPosition != null;

    return this.currentPosition.getY();
  }

  /**
   * Get the x-coordinate of the locked door.
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
    return "D";
  }

  @Override
  public int getValue() {
    if (colour.equals("red")) {
      return 13;
    } else if (colour.equals("blue")) {
      return 14;
    } else if (colour.equals("green")) {
      return 15;
    } else {
      return 16;
    }
  }
}