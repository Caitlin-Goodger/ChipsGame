package nz.ac.vuw.ecs.swen225.a3.maze;

import java.util.HashMap;
import java.util.Map;

import nz.ac.vuw.ecs.swen225.a3.persistence.Maze;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Chap tile. It is a implementation of Tile.
 * 
 * @author Caitlin
 *
 */
public class Chap implements Tile {
	private boolean isSolid = false;
	private Position currentPosition; // keeps track of tiles position within a grid

	private int facing = 6;
	private Map<String, String> inventory;
	private Tile onTile;

	/**
	 * Constructor for the Chap tile.
	 * 
	 * @param xGrid   = x co-ordinate in of the tile on the
	 *                grid.
	 * @param yGrid   = y co-ordinate in of the tile on the
	 *                grid.
	 * @param xScreen = x co-ordinate in of the tile on the
	 *                screen.
	 * @param yScreen = y co-ordinate in of the tile on the
	 *                screen.
	 */
	public Chap(int xGrid, int yGrid) {
		currentPosition = new Position(xGrid, yGrid);
		inventory = new HashMap<String, String>();
		onTile = new Free(xGrid, yGrid);
	}

	/**
	 * Given a locked door, see if chap can unlock it
	 * 
	 * @param door = door to be unlcoked.
	 * @return boolean.
	 */
	public boolean canUnlock(LockedDoor door) {
		String colour = door.getColour();
		String itemType;
		if (inventory.containsKey(colour)) {
			itemType = inventory.get(colour);
			if (itemType.equalsIgnoreCase("Key")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Pick up an item from the maze and add to chap's
	 * inventory.
	 * 
	 * @param item = the Tile with a pickup-able item.
	 */
	public void pickupItem(Tile item) {
		if (item instanceof Key) {
			Key key = (Key) item;
			System.out.println("Picked up a " + key.getColour() + "key!");
			inventory.put(key.getColour(), "Key");
		}
		// can add more item Tile types later i.e. ice skaters
	}

	/**
	 * Remove an item from the inventory.
	 * 
	 * @param colour   = colour of the item.
	 * @param itemType = type of the item.
	 */
	public void removeItem(String colour, String itemType) {
		if (inventory.containsKey(colour)) {
			itemType = inventory.get(colour);
			if (itemType.equalsIgnoreCase("Key")) {
				inventory.remove(colour);
			}

			// can check for multiple type items in the future
		}

	}

	/**
	 * Get the current inventory of the game.
	 * 
	 * @return Map<String,String>.
	 */
	public Map<String, String> getInventory() {
		return inventory;
	}

	/**
	 * Get the tile that chap is on.
	 * 
	 * @return Tile.
	 */
	public Tile getOnTile() {
		if (this.onTile instanceof Key || this.onTile instanceof Treasure
				|| this.onTile instanceof LockedDoor) {
			return new Free(currentPosition.getX(), currentPosition.getY());
		}
		return this.onTile;
	}

	/**
	 * Update the tile that Chap is on.
	 * 
	 * @param tile = tile to move Chap to.
	 */
	public void setOnTile(Tile tile) {
		onTile = tile;
	}

	/**
	 * Update the position that the tile is in.
	 * 
	 * @param direction = direction.
	 */
	public void updatePosition(char direction) {
		if (direction == 'N') {
			facing = 5;
			currentPosition.updatePosition(0, -1);
		} else if (direction == 'S') {
			facing = 6;
			currentPosition.updatePosition(0, 1);
		} else if (direction == 'E') {
			facing = 3;
			currentPosition.updatePosition(1, 0);
		} else if (direction == 'W') {
			facing = 4;
			currentPosition.updatePosition(-1, 0);
		}
	}

	/**
	 * Get the current position of the tile on the grid.
	 */
	public Position getTilePosition() {
		return currentPosition;
	}

	/**
	 * Get the path of the image.
	 */
	@Override
	public String getImagePath() {

		return "resources/CC" + facing + ".png";
	}

	/**
	 * Get the y co-ordinate of the tile on the grid.
	 */
	@Override
	public int getYPosition() {
		return currentPosition.getY();
	}

	/**
	 * Get the x co-ordinate of the tile on the grid.
	 */
	@Override
	public int getXPosition() {
		return currentPosition.getX();
	}

	/**
	 * To String Method.
	 */
	@Override
	public String toString() {
		return "C";
	}

	/*
	 * re-set the XYPos
	 */
	public void resetPosition(Position pos) {
		this.currentPosition = pos;

	}

	/**
	 * Returns the inventory.
	 * 
	 * @return level
	 */
	public Map<String, String> returnInventory() {
		return inventory;
	}

	/**
	 * Resets the chaps inventory/
	 */
	private void resetInventory() {
		inventory.clear();
	}

	/**
	 * Takes the new level and gets the starting position of
	 * that new level, sets the onYile of the character to a
	 * free tile with parameters of starting position and resets
	 * inventory.
	 * 
	 * @param m
	 */
	public void resetPlayer(Maze m) {
		resetPosition(new Position(m.getSpawn().getX(), m.getSpawn().getY()));
		setOnTile(new Free(m.getSpawn().getX(), m.getSpawn().getY()));
		resetInventory();
	}

	/**
	 * Returns the chap's current position.
	 * 
	 * @return currentPosition
	 */
	public Position getCurrentPosition() {
		return currentPosition;
	}
}