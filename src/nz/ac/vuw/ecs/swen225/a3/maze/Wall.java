package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Wall class is responsible for keeping the position of the wall.
 */
public class Wall implements Tile {
  private Position currentPosition;

  /**
   * Constructor for the wall.
   * 
   * @param x = x position relative to maze
   * @param y = y position relative to maze
   */
  public Wall(int x, int y) {
    this.currentPosition = new Position(x, y);
  }

  /**
   * Get the path of the image.
   */
  @Override
  public String getImagePath() {
    return "resources/CC1.png";
  }

  /**
   * Get the y-coordinate of the wall.
   */
  @Override
  public int getYPosition() {
    assert this.currentPosition != null;

    return this.currentPosition.getY();
  }

  /**
   * Get the x-coordinate of the treasure.
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
    return "W";
  }

  @Override
  public int getValue() {
    return 1;
  }
}