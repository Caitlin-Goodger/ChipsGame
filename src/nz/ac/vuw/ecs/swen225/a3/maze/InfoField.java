package nz.ac.vuw.ecs.swen225.a3.maze;

import java.awt.image.BufferedImage;

import nz.ac.vuw.ecs.swen225.a3.util.XYPos;

/**
 * InfoField tile. Is an implementation of the Tile class. 
 * @author Caitlin
 *
 */
public class InfoField implements Tile {

	private String text;
	boolean isSolid = false; // check if player can walkThrought
	XYPos currentPosition; // keeps track of tiles position within a grid
	XYPos currentPositionOnScreen; // keeps track of a tiles position on screen
	BufferedImage imageToDisplay; // the image for the token

	/**
	 * Constructor for the info field tile. 
	 * @param aText = text for the info field. 
	 * @param xGrid = x co-ordinate in of the tile on the grid.
	 * @param yGrid = y co-ordinate in of the tile on the grid.
	 * @param xScreen = x co-ordinate in of the tile on the screen.
	 * @param yScreen = y co-ordinate in of the tile on the screen.
	 */
	public InfoField(String aText, int xGrid, int yGrid, int xScreen, int yScreen) {
		text = aText;
		currentPosition = new XYPos(xGrid, yGrid);
		currentPositionOnScreen = new XYPos(xScreen, yScreen);
	}

	/**
	 * Set the text of the info Field. 
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
	 * @return String.
	 */
	public String getText() {
		return text;
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
		currentPositionOnScreen = currentPosition;

	}

	/**
	 * Load the image of the tile. 
	 */
	@Override
	public boolean loadImage() {
		return true;
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
		return "resources/CC8.png";
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
		return "I";
	}
	
	/*
	 * re-set the XYPos
	 */
	@Override
	public void resetPosition(XYPos pos) {
		this.currentPosition = pos;
		
	}
}