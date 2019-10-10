package nz.ac.vuw.ecs.swen225.a3.maze.implementation;

import nz.ac.vuw.ecs.swen225.a3.application.Position;
import nz.ac.vuw.ecs.swen225.a3.maze.Tile;

/**
 * Key class is responsible for keeping the position of the key.
 */
public class Key implements Tile {
  private String colour;
  private Position currentPosition;

  /**
   * Constructor for the key.
   * 
   * @param colour = the colour of the key
   * @param x      = x position relative to maze
   * @param y      = y position relative to maze
   */
  public Key(String colour, int x, int y) {
    this.colour = colour;
    this.currentPosition = new Position(x, y);
  }

  /**
   * Sets the colour of the key.
   * 
   * @param colour = the colour you want to set the key to
   */
  public void setColour(String colour) {
    if (colour == null) {
      throw new IllegalArgumentException("Argument must be a String.");
    }

    this.colour = colour;

    assert this.colour != null;
  }

  /**
   * Gets the colour of the key.
   * 
   * @return colour
   */
  public String getColour() {
    assert this.colour != null;

    return this.colour;
  }

  /**
   * Get the path of the image.
   */
  @Override
  public String getImagePath() {
    return "resources/CC12.png";
  }

  /**
   * Get the y-coordinate of the key.
   */
  @Override
  public int getYPosition() {
    assert this.currentPosition != null;

    return this.currentPosition.getY();
  }

  /**
   * Get the x-coordinate of the key.
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
    return "K";
  }

  @Override
  public int getValue() {
    if (colour.equals("red")) {
      return 9;
    } else if (colour.equals("blue")) {
      return 10;
    } else if (colour.equals("green")) {
      return 11;
    } else {
      return 12;
    }
  }
}