package nz.ac.vuw.ecs.swen225.a3.maze.implementation;

import nz.ac.vuw.ecs.swen225.a3.maze.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * InfoField class is responsible for keeping the position of the info field and
 * storing the information.
 */
public class InfoField implements Tile {
  private static int id = -1;

  private String text;
  private Position currentPosition;

  /**
   * Constructor for the info field.
   * 
   * @param text = the text you want in the info field
   * @param x    = x position relative to maze
   * @param y    = y position relative to maze
   */
  public InfoField(String text, int x, int y) {
    InfoField.id++;

    this.text = text;
    this.currentPosition = new Position(x, y);
  }

  /**
   * Sets the text in the info field.
   * 
   * @param text = the text you wanna set the info field to
   */
  public void setInfoFieldText(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Argument must be a String.");
    }

    this.text = text;

    assert this.text != null;
  }

  /**
   * Gets the text in the info field.
   * 
   * @return text
   */
  public String getInfoFieldText() {
    assert this.text != null;

    return this.text;
  }

  /**
   * Returns the id of the info field.
   * 
   * @return id
   */
  public int getID() {
    assert InfoField.id != -1;

    return InfoField.id;
  }

  /**
   * Get the path of the image.
   */
  @Override
  public String getImagePath() {
    return "resources/CC8.png";
  }

  /**
   * Get the y-coordinate of the info field.
   */
  @Override
  public int getYPosition() {
    assert this.currentPosition != null;

    return this.currentPosition.getY();
  }

  /**
   * Get the x-coordinate of the info field.
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
    return "I";
  }

  @Override
  public int getValue() {
    return 7;
  }
}