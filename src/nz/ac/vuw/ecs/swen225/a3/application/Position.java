package nz.ac.vuw.ecs.swen225.a3.application;

/**
 * Position class is responsible for storing the X and Y coordinates.
 */
public class Position {
  private int posX;
  private int posY;

  /**
   * Constructor for the position.
   * 
   * @param x = the x position relative to maze
   * @param y = the y position relative to maze
   */
  public Position(int x, int y) {
    this.posX = x;
    this.posY = y;
  }

  /**
   * Gets the x coordinate.
   * 
   * @return x
   */
  public int getX() {
    assert this.posX >= 0;

    return this.posX;
  }

  /**
   * Gets the y coordinate.
   * 
   * @return y
   */
  public int getY() {
    assert this.posY >= 0;

    return this.posY;
  }

  /**
   * Update the x and y positions.
   * 
   * @param x = the amount you want to move x
   * @param y = the amount you want to move y
   */
  public void updatePosition(int x, int y) {
    if (x > 1 || x < -1) {
      throw new IllegalArgumentException("Argument must be between -1 and 1.");
    }

    if (y > 1 || x < -1) {
      throw new IllegalArgumentException("Argument must be between -1 and 1.");
    }

    this.posX += x;
    this.posY += y;
  }

  /**
   * Converts the position into a string, used for debugging.
   */
  @Override
  public String toString() {
    return "(" + this.posX + ", " + this.posY + ")";
  }
  
  /**
   * Equals method. 
   * @return if this position is identical to another
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Position) {
      Position p1 = (Position) o;
      return p1.getX() == this.posX && p1.getY() == this.posY;
    }
    return false;
  }
  
  /**
   * Hash code method for position.
   */
  public int hashCode() {
    assert false : "hashCode not designed";
    return 42; // any arbitrary constant will do
  }

  
}
