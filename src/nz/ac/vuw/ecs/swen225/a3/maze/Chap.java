package nz.ac.vuw.ecs.swen225.a3.maze;

import java.util.HashMap;
import java.util.Map;

import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.persistence.Maze;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Chap class is responsible for the position and movement
 * of the player.
 */
public class Chap implements Tile {
	private Position currentPosition; // Keeps track of player position.

	private int facingDirection = 6; // Sprite ID for direction player is facing.

	private Map<String, String> inventory;
	private Tile onTile;

	/**
	 * Constructor for Chap. Takes an initial position.
	 * 
	 * @param xGrid
	 * @param yGrid
	 */
	public Chap(int xGrid, int yGrid) {
		this.currentPosition = new Position(xGrid, yGrid);

		this.inventory = new HashMap<String, String>();
		this.onTile = new Free(xGrid, yGrid); // Will always be on free tile initially.
	}

	/**
	 * Checks whether the player has the correct coloured key
	 * for door.
	 * 
	 * @param door
	 * @return canUnlock
	 */
	public boolean canUnlock(LockedDoor door) {
		assert door != null; // Check door exists.

		boolean canUnlock = false;

		String doorColour = door.getColour();
		String key;

		// Checks if the matching coloured key exists in player's
		// inventory.
		if (inventory.containsKey(doorColour)) {
			key = inventory.get(doorColour);

			if (key.equalsIgnoreCase("Key")) {
				canUnlock = true;
			}
		}

		return canUnlock;
	}

	/**
	 * Called when player moves on an item. Adds item to
	 * inventory when called.
	 * 
	 * @param item
	 */
	public void pickupItem(Tile item) {
		assert item != null; // Check if item exists.

		if (item instanceof Key) {
			Key key = (Key) item;

			inventory.put(key.getColour(), "Key");
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
	 * @param tile
	 */
	public void setOnTile(Tile tile) {
		this.onTile = tile;
	}

	/**
	 * Update position of player.
	 * 
	 * @param direction
	 */
	public void updatePosition(char direction) {
		switch (direction) {
		case 'S':
			facingDirection = 6;
			currentPosition.updatePosition(0, 1);

			break;
		case 'E':
			facingDirection = 3;
			currentPosition.updatePosition(1, 0);

			break;
		case 'W':
			facingDirection = 4;
			currentPosition.updatePosition(-1, 0);

			break;
		default:
			facingDirection = 5;
			currentPosition.updatePosition(0, -1);

			break;
		}
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
	 * Resets the position of the player. Used when changing
	 * levels.
	 * 
	 * @param position
	 */
	public void resetPosition(Position position) {
		this.currentPosition = position;

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
	 * Takes the new level and gets the starting position of
	 * that new level, sets the onYile of the character to a
	 * free tile with parameters of starting position and resets
	 * inventory.
	 * 
	 * @param maze
	 */
	public void resetPlayer(Maze maze) {
		resetPosition(new Position(maze.getSpawn().getX(), maze.getSpawn().getY()));
		setOnTile(new Free(maze.getSpawn().getX(), maze.getSpawn().getY()));

		this.inventory.clear(); // Clears the player's inventory.
	}

	/**
	 * Returns the chap's current position.
	 * 
	 * @return currentPosition
	 */
	public Position getCurrentPosition() {
		return currentPosition;
	}

	/**
	 * Get the path to image.
	 */
	@Override
	public String getImagePath() {
		return "resources/CC" + facingDirection + ".png";
	}

	/**
	 * Get the y-coordinate of player.
	 */
	@Override
	public int getYPosition() {
		assert this.currentPosition != null;

		return this.currentPosition.getY();
	}

	/**
	 * Get the x-coordinate of player.
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
}