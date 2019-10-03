package nz.ac.vuw.ecs.swen225.a3.maze;

import java.awt.image.BufferedImage;

import nz.ac.vuw.ecs.swen225.a3.util.XYPos;

/**
 * Locked Door tile. Is an implementation of the tile class. 
 * @author Caitlin
 *
 */
public class LockedDoor implements Tile {

	private String colour;
	boolean isSolid = true; // check if player can walkThrought
	XYPos currentPosition; // keeps track of tiles position within a grid
	BufferedImage imageToDisplay; // the image for the token

	/**
	 * Constructor for the LockedDoor class. 
	 * @param aColour = colour of the lock. 
	 * @param xGrid = x co-ordinate in of the tile on the grid.
	 * @param yGrid = y co-ordinate in of the tile on the grid.
	 * @param xScreen = x co-ordinate in of the tile on the screen.
	 * @param yScreen = y co-ordinate in of the tile on the screen.
	 */
	public LockedDoor(String aColour, int xGrid, int yGrid) {
		colour = aColour;
		currentPosition = new XYPos(xGrid, yGrid);
	}

	/**
	 * Set the colour of the lock.
	 * @param aColour = colour to set. 
	 * @return boolean. 
	 */
	public boolean setColour(String aColour) {
		boolean wasSet = false;
		colour = aColour;
		wasSet = true;
		return wasSet;
	}

	/**
	 * Get the colour of the lock. 
	 * @return String. 
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * Check to see if the chap can unlock this door. 
	 * @param chap = Chap tile trying to unlock the door. 
	 * @return - whether chap can unlock this door
	 */
	public boolean canUnlock(Chap chap) {
		return chap.canUnlock(this);
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
	 * Get the current position of the tile on the grid. 
	 */
	@Override
	public XYPos getTilePosition() {
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

		return isSolid == true ? "resources/CC11.png" :"resources/CC2.png" ;
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
		return "D";
	}
	
	/*
	 * re-set the XYPos
	 */
	@Override
	public void resetPosition(XYPos pos) {
		this.currentPosition = pos;
		
	}
}