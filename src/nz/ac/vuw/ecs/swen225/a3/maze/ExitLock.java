package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * ExitLock class is responsible for keeping the position of the exit lock.
 */
public class ExitLock implements Tile {
  private boolean isSolid = true; // Checks if player can walk through exit lock.
  private Position currentPosition;

  /**
   * Constructor for the exit lock.
   * 
   * @param x = x position relative to maze
   * @param y = y position relative to maze
   */
  public ExitLock(int x, int y) {
    this.currentPosition = new Position(x, y);
  }

  /**
   * Sets the exit lock to un-solid when unlocked.
   */
  public void unlockExitLock() {
    this.isSolid = false;

    assert this.isSolid == false;
  }

  /**
   * Get the path of the image.
   */
  @Override
  public String getImagePath() {
    return this.isSolid ? "resources/CC9.png" : "resources/CC15.png";
  }

  /**
   * Get the y-coordinate of the exit lock.
   */
  @Override
  public int getYPosition() {
    assert this.currentPosition != null;

    return this.currentPosition.getY();
  }

  /**
   * Get the x-coordinate of the exit lock.
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
    return "L";
  }

  @Override
  public int getValue() {
    return 4;
  }
}