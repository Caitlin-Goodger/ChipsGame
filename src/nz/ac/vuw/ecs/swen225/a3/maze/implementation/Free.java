package nz.ac.vuw.ecs.swen225.a3.maze.implementation;

import nz.ac.vuw.ecs.swen225.a3.maze.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Free class is responsible for keeping the position of the tiles a player can
 * move on.
 */
public class Free implements Tile {
  private Position currentPosition;

  /**
   * Constructor for the free tiles.
   * 
   * @param x = x position relative to maze
   * @param y = y position relative to maze
   */
  public Free(int x, int y) {
    this.currentPosition = new Position(x, y);
  }

  /**
   * Get the path of the image.
   */
  @Override
  public String getImagePath() {
    return "resources/CC2.png";
  }

  /**
   * Get the y-coordinate of the free tile.
   */
  @Override
  public int getYPosition() {
    assert this.currentPosition != null;

    return this.currentPosition.getY();
  }

  /**
   * Get the x-coordinate of the free tile.
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
    return "F";
  }

  @Override
  public int getValue() {
    return 0;
  }
}