package nz.ac.vuw.ecs.swen225.a3.maze.implementation;

import nz.ac.vuw.ecs.swen225.a3.application.Position;
import nz.ac.vuw.ecs.swen225.a3.maze.Tile;

/**
 * Treasure class is responsible for keeping the position of the treasure.
 */
public class Treasure implements Tile {
  private Position currentPosition;

  /**
   * Constructor for the treasure.
   * 
   * @param x = x position relative to maze
   * @param y = y position relative to maze
   */
  public Treasure(int x, int y) {
    this.currentPosition = new Position(x, y);
  }

  /**
   * Get the path of the image.
   */
  @Override
  public String getImagePath() {
    return "resources/CC7.png";
  }

  /**
   * Get the y-coordinate of the treasure.
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
    return "T";
  }

  @Override
  public int getValue() {
    return 8;
  }
}