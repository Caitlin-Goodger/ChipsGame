package nz.ac.vuw.ecs.swen225.a3.maze;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

// line 71 "model.ump"
// line 162 "model.ump"
public class Chap implements Tile {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------
	boolean isSolid = false;
	XYPos currentPosition; // keeps track of tiles position within a grid
	XYPos currentPositionOnScreen; // keeps track of a tiles position on screen
	BufferedImage imageToDisplay; // the image for the tokken

	private Map<String, String> inventory;
	private Tile onTile; //chap initially starts on a "free" tile
	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	public Chap(int xGrid, int yGrid, int xScreen, int yScreen) {
		currentPosition = new XYPos(xGrid, yGrid);
		currentPositionOnScreen = new XYPos(xScreen, yScreen);
		inventory = new HashMap<String, String>();
		onTile = new Free(xGrid, yGrid, xScreen, yScreen);
	}

	// ------------------------
	// INTERFACE
	// ------------------------

	public void delete() {
	}

	/*
	 * given a locked door, see if chap can unlock it
	 * 
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

	/*
	 * pick up an item from the maze and add to chap's inventory
	 * 
	 * @param - the Tile with a pickup-able item
	 */
	public void pickupItem(Tile item) {
		if (item instanceof Key) {
			Key key = (Key) item;
			inventory.put(key.getColour(), "Key");
		}

		// can add more item Tile types later i.e. ice skaters

	}

	/*
	 * remove an item from the inventory after it is used i.e. a key
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
	
	/*
	 * 
	 */
	public Tile getOnTile() {
		return this.onTile;
	}
	
	/*
	 * Update the tile that Chap is standing on after moving
	 */
	public void setOnTile(Tile tile) {
		
	}

	@Override
	// Being world moves around Chap, chaps position changes on map but not screen
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

	@Override
	public void loadImage() {

	}

	@Override
	public XYPos getTilePosition() {
		return currentPosition;
	}

	@Override
	public XYPos getCurrentPositionOnScreen() {
		return currentPositionOnScreen;
	}

	@Override
	public boolean isObjectSolid() {
		return isSolid;
	}

	@Override
	public String getImagePath() {
		return "src\\nz\\ac\\vuw\\ecs\\swen225\\a3\\IMG\\CC6.png";
	}

	@Override
	public int getYPositionOnScreen() {
		return currentPositionOnScreen.getY();
	}

	@Override
	public int getXPositionOnScreen() {
		return currentPositionOnScreen.getX();
	}

	@Override
	public int getYPosition() {
		return currentPosition.getY();
	}

	@Override
	public int getXPosition() {
		return currentPosition.getX();
	}

	@Override
	public String toString() {
		return "Chap";
	}
}