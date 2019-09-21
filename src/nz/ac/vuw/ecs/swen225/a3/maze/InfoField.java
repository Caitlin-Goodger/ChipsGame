package nz.ac.vuw.ecs.swen225.a3.maze;

/*PLEASE DO NOT EDIT THIS CODE*/

/*This code was generated using the UMPLE 1.29.1.4648.92f3aa193 modeling language!*/

import java.awt.image.BufferedImage;

// line 54 "model.ump"
// line 142 "model.ump"
public class InfoField implements Tile {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// InfoField Attributes
	private String text;
	boolean isSolid = true; // check if player can walkThrought
	XYPos currentPosition; // keeps track of tiles position within a grid
	XYPos currentPositionOnScreen; // keeps track of a tiles position on screen
	BufferedImage imageToDisplay; // the image for the tokken
	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	public InfoField(String aText, int xGrid, int yGrid, int xScreen, int yScreen) {
		text = aText;
		currentPosition = new XYPos(xGrid, yGrid);
		currentPositionOnScreen = new XYPos(xScreen, yScreen);
	}

	// ------------------------
	// INTERFACE
	// ------------------------

	public boolean setText(String aText) {
		boolean wasSet = false;
		text = aText;
		wasSet = true;
		return wasSet;
	}

	public String getText() {
		return text;
	}

	public void delete() {
	}

	@Override
	public void updatePosition(char direction) {
		if (direction == 'N') {
			currentPositionOnScreen.updatePos(0, 1);
		} else if (direction == 'S') {
			currentPositionOnScreen.updatePos(0, -1);
		} else if (direction == 'E') {
			currentPositionOnScreen.updatePos(1, 0);
		} else if (direction == 'W') {
			currentPositionOnScreen.updatePos(-1, 0);
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
		return false;
	}

	@Override
	public String getImagePath() {
		return null;
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
		return "Info Field";
	}
}