package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * InfoField tile. Is an implementation of the Tile class.
 * 
 * @author Caitlin
 *
 */
public class InfoField implements Tile {
	private String text;
	private boolean isSolid = false; // check if player can walkThrought
	private Position currentPosition; // keeps track of tiles position within a grid

	/**
	 * Constructor for the info field tile.
	 * 
	 * @param aText   = text for the info field.
	 * @param xGrid   = x co-ordinate in of the tile on the
	 *                grid.
	 * @param yGrid   = y co-ordinate in of the tile on the
	 *                grid.
	 * @param xScreen = x co-ordinate in of the tile on the
	 *                screen.
	 * @param yScreen = y co-ordinate in of the tile on the
	 *                screen.
	 */
	public InfoField(String aText, int xGrid, int yGrid) {
		text = aText;
		currentPosition = new Position(xGrid, yGrid);
	}

	/**
	 * Set the text of the info Field.
	 * 
	 * @param aText
	 * @return boolean.
	 */
	public boolean setText(String aText) {
		boolean wasSet = false;
		text = aText;
		wasSet = true;
		return wasSet;
	}

	/**
	 * Get the text of the info field.
	 * 
	 * @return String.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Update the position that the tile is in.
	 * 
	 * @param direction = direction.
	 */
	@Override
	public void updatePosition(char direction) {
		if (direction == 'N') {
			currentPosition.updatePosition(0, 1);
		} else if (direction == 'S') {
			currentPosition.updatePosition(0, -1);
		} else if (direction == 'E') {
			currentPosition.updatePosition(1, 0);
		} else if (direction == 'W') {
			currentPosition.updatePosition(-1, 0);
		}
	}

	/**
	 * Get the current position of the tile on the grid.
	 */
	@Override
	public Position getTilePosition() {
		return currentPosition;
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
		return "resources/CC8.png";
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
		return "I";
	}

	/*
	 * re-set the XYPos
	 */
	@Override
	public void resetPosition(Position pos) {
		this.currentPosition = pos;

	}
}