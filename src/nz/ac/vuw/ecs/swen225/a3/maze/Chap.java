package nz.ac.vuw.ecs.swen225.a3.maze;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Chap implements Tile {

	boolean isSolid = false;
	XYPos currentPosition; // keeps track of tiles position within a grid
	XYPos currentPositionOnScreen; // keeps track of a tiles position on screen
	BufferedImage imageToDisplay; // the image for the token

	private Map<String, String> inventory;
	private Tile onTile; 
	
	/**
	 * Constructor for the Chap tile. 
	 * @param xGrid = x co-ordinate in of the tile on the grid.
	 * @param yGrid = y co-ordinate in of the tile on the grid.
	 * @param xScreen = x co-ordinate in of the tile on the screen.
	 * @param yScreen = y co-ordinate in of the tile on the screen.
	 */
	public Chap(int xGrid, int yGrid, int xScreen, int yScreen) {
		currentPosition = new XYPos(xGrid, yGrid);
		currentPositionOnScreen = new XYPos(xScreen, yScreen);
		inventory = new HashMap<String, String>();
		onTile = new Free(xGrid, yGrid, xScreen, yScreen);
	}


	/**
	 * Given a locked door, see if chap can unlock it
	 * @param - the door to be unlocked
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
	 * Pick up an item from the maze and add to chap's inventory.
	 * @param - the Tile with a pickup-able item
	 */
	public void pickupItem(Tile item) {
		if (item instanceof Key) {
			Key key = (Key) item;
			inventory.put(key.getColour(), "Key");
		}
		// can add more item Tile types later i.e. ice skaters
	}

	/**
	 * Remove an item from the inventory.
	 * @param colour = colour of the item.
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
	 * Get the tile that chap is on.
	 * @return Tile. 
	 */
	public Tile getOnTile() {
		return this.onTile;
	}
	
	/**
	 * Update the tile that Chap is on.
	 * @param tile = tile to move Chap to. 
	 */
	public void setOnTile(Tile tile) {
		onTile = tile;
	}

	/**
	 * Update the position that the tile is in.
	 * @param direction = direction. 
	 */
	@Override
	public void updatePosition(char direction) {
		if (direction == 'N') {
			currentPosition.updatePos(0, 1);
		} else if (direction == 'S') {
			currentPosition.updatePos(0, -1);
		} else if (direction == 'E') {
			currentPosition.updatePos(1, 0);
		} else if (direction == 'W') {
			currentPosition.updatePos(-1, 0);
		}
	}

	/**
	 * Load the image of the tile. 
	 */
	@Override
	public void loadImage() {

	}

	/**
	 * Get the current position of the tile on the grid. 
	 */
	@Override
	public XYPos getTilePosition() {
		return currentPosition;
	}

	/**
	 * Get the current position of the tile on the screen. 
	 */
	@Override
	public XYPos getCurrentPositionOnScreen() {
		return currentPositionOnScreen;
	}

	/**
	 * Check whether the object is solid. 
	 */
	@Override
	public boolean isObjectSolid() {
		return isSolid;
	}

	/**
	 * Get the path of the image. 
	 */
	@Override
	public String getImagePath() {
		return "src\\nz\\ac\\vuw\\ecs\\swen225\\a3\\IMG\\CC6.png";
	}

	/**
	 * Get the y co-ordinate of the tile on the screen. 
	 */
	@Override
	public int getYPositionOnScreen() {
		return currentPositionOnScreen.getY();
	}

	/**
	 * Get the x co-ordinate of the tile on the screen. 
	 */
	@Override
	public int getXPositionOnScreen() {
		return currentPositionOnScreen.getX();
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
}