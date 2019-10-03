package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * 
 * @author Caitlin
 *
 */
public class Key implements Tile {
	private String colour;
	private boolean isSolid = false; // check if player can walkThrought
	private Position currentPosition; // keeps track of tiles position within a grid

	/**
	 * Constructor for the Key class.
	 * 
	 * @param aColour = colour of the key.
	 * @param xGrid   = x co-ordinate in of the tile on the
	 *                grid.
	 * @param yGrid   = y co-ordinate in of the tile on the
	 *                grid.
	 * @param xScreen = x co-ordinate in of the tile on the
	 *                screen.
	 * @param yScreen = y co-ordinate in of the tile on the
	 *                screen.
	 */
	public Key(String aColour, int xGrid, int yGrid) {
		colour = aColour;
		currentPosition = new Position(xGrid, yGrid);
	}

	/**
	 * Set of the colour of the key.
	 * 
	 * @param aColour
	 * @return boolean
	 */
	public boolean setColour(String aColour) {
		boolean wasSet = false;
		colour = aColour;
		wasSet = true;
		return wasSet;
	}

	/**
	 * Get the colour of the key.
	 * 
	 * @return boolean
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * Get the path of the image.
	 */
	@Override
	public String getImagePath() {
		return "resources/CC12.png";
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
		return "K";
	}
}