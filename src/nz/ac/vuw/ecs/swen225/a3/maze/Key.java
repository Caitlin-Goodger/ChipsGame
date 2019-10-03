package nz.ac.vuw.ecs.swen225.a3.maze;

import java.awt.image.BufferedImage;

import nz.ac.vuw.ecs.swen225.a3.util.XYPos;

/**
 * 
 * @author Caitlin
 *
 */
public class Key implements Tile {
	private String colour;
	private boolean isSolid = false; // check if player can walkThrought
	private XYPos currentPosition; // keeps track of tiles position within a grid

	/**
	 * Constructor for the Key class. 
	 * @param aColour = colour of the key. 
	 * @param xGrid = x co-ordinate in of the tile on the grid.
	 * @param yGrid = y co-ordinate in of the tile on the grid.
	 * @param xScreen = x co-ordinate in of the tile on the screen.
	 * @param yScreen = y co-ordinate in of the tile on the screen.
	 */
	public Key(String aColour, int xGrid, int yGrid) {
		colour = aColour;
		currentPosition = new XYPos(xGrid, yGrid);
	}
	
	/**
	 * Set of the colour of the key. 
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
	 * @return boolean
	 */
	public String getColour() {
		return colour;
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
	
	/*
	 * re-set the XYPos
	 */
	@Override
	public void resetPosition(XYPos pos) {
		this.currentPosition = pos;
		
	}
}