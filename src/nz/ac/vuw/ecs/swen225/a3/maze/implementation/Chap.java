package nz.ac.vuw.ecs.swen225.a3.maze.implementation;

import java.util.HashMap;
import java.util.Map;

import nz.ac.vuw.ecs.swen225.a3.maze.Maze;
import nz.ac.vuw.ecs.swen225.a3.maze.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Chap class is responsible for the position and movement of the player.
 */
public class Chap implements Tile {
  private Position currentPosition; // Keeps track of player position.

  private int facingDirection = 6; // Sprite ID for direction player is facing.

  private Map<String, String> inventory;
  private Tile onTile;

  /**
   * Constructor for Chap. Takes an initial position.
   * 
   * @param x = x position relative to maze
   * @param y = y position relative to maze
   */
  public Chap(int x, int y) {
    this.currentPosition = new Position(x, y);

    this.inventory = new HashMap<String, String>();
    this.onTile = new Free(x, y); // Will always be on free tile initially.
  }

  /**
   * Checks whether the player has the correct coloured key for door.
   * 
   * @param door = the door you want to check can be unlocked
   * @return canUnlock
   */
  public boolean canUnlock(LockedDoor door) {
    if (door == null) {
      throw new IllegalArgumentException("Argument must be a LockedDoor.");
    }

    boolean canUnlock = false;

    String doorColour = door.getColour();
    String key;

    // Checks if the matching coloured key exists in player's
    // inventory.
    if (inventory.containsKey(doorColour)) {
      key = inventory.get(doorColour);

      if (key.equalsIgnoreCase("Key")) {
        canUnlock = true;

        assert canUnlock == true;
      }
    }

    return canUnlock;
  }

  /**
   * Called when player moves on an item. Adds item to inventory when called.
   * 
   * @param item = the item you want to pickup
   */
  public void pickupItem(Tile item) {
    if (item == null) {
      throw new IllegalArgumentException("Argument must be a Tile.");
    }

    if (item instanceof Key) {
      Key key = (Key) item;

      inventory.put(key.getColour(), "Key");

      assert inventory.containsKey(key.getColour()); // Check key actually was added.
    }
  }

  /**
   * Get the tile the player is currently on.
   * 
   * @return onTile
   */
  public Tile getOnTile() {
    assert this.onTile != null; // Make sure onTile is not null.

    if (this.onTile instanceof Key || this.onTile instanceof Treasure
        || this.onTile instanceof LockedDoor) {
      return new Free(currentPosition.getX(), currentPosition.getY());
    }

    return this.onTile;
  }

  /**
   * Updates the onTile.
   * 
   * @param tile = the tile you want to change onTile to
   * @return true if onTile is set
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
   * Update position of player.
   * 
   * @param direction = the direction you want the player to move
   */
  public void updatePosition(Character direction) {
    if (direction == null) {
      throw new IllegalArgumentException("Argument must be a Character.");
    }

    switch (direction) {
      case 'S':
        this.facingDirection = 6;
        this.currentPosition.updatePosition(0, 1);
  
        break;
      case 'E':
        this.facingDirection = 3;
        this.currentPosition.updatePosition(1, 0);
  
        break;
      case 'W':
        this.facingDirection = 4;
        this.currentPosition.updatePosition(-1, 0);
  
        break;
      default:
        this.facingDirection = 5;
        this.currentPosition.updatePosition(0, -1);
  
        break;
    }

    assert this.facingDirection == 6 || this.facingDirection == 3
        || this.facingDirection == 4 | this.facingDirection == 5;
  }

  /**
   * Returns the position of the player.
   * 
   * @return currentPosition
   */
  public Position getChapPosition() {
    assert this.currentPosition != null;

    return this.currentPosition;
  }

  /**
   * Resets the position of the player. Used when changing levels.
   * 
   * @param position = the position you want to reset the player to
   * @return true if positions are reset
   */
  public boolean resetPosition(Position position) {
    if (position == null) {
      throw new IllegalArgumentException("Argument must be a Position.");
    }

    this.currentPosition = position;

    assert this.currentPosition != null;

    if (this.currentPosition == position) {
      return true;
    }

    return false;
  }

  /**
   * Gets the player's inventory.
   * 
   * @return inventory
   */
  public Map<String, String> getInventory() {
    assert this.inventory != null; // Makes sure the inventory exists.

    return this.inventory;
  }

  /**
   * Takes the new maze and gets the starting position of that new maze, sets the
   * onTile of the character to a free tile with parameters of starting position
   * and resets inventory.
   * 
   * @param maze = the maze you want to change
   */
  public void resetPlayer(Maze maze) {
    if (maze == null) {
      throw new IllegalArgumentException("Argument must be a Maze.");
    }

    boolean positionReset = resetPosition(
        new Position(maze.getSpawn().getX(), maze.getSpawn().getY()));
    boolean onTileReset = setOnTile(new Free(maze.getSpawn().getX(), maze.getSpawn().getY()));

    this.inventory.clear(); // Clears the player's inventory.

    assert positionReset && onTileReset && inventory.size() == 0; // Checks reset.
  }

  /**
   * Returns the chap's current position.
   * 
   * @return currentPosition
   */
  public Position getCurrentPosition() {
    assert this.currentPosition != null;

    return this.currentPosition;
  }

  /**
   * Get the path to image.
   */
  @Override
  public String getImagePath() {
    return "resources/CC" + facingDirection + ".png";
  }

  /**
   * Get the y-coordinate of the player.
   */
  @Override
  public int getYPosition() {
    assert this.currentPosition != null;

    return this.currentPosition.getY();
  }

  /**
   * Get the x-coordinate of the player.
   */
  @Override
  public int getXPosition() {
    assert this.currentPosition != null;

    return currentPosition.getX();
  }

  /**
   * Turns the tile into a string. Used for debugging.
   */
  @Override
  public String toString() {
    return "C";
  }

  @Override
  public int getValue() {
    return 2;
  }
}