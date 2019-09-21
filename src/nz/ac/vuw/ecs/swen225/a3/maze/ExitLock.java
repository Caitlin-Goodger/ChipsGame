package nz.ac.vuw.ecs.swen225.a3.maze;

/*PLEASE DO NOT EDIT THIS CODE*/

/*This code was generated using the UMPLE 1.29.1.4648.92f3aa193 modeling language!*/

import java.awt.image.BufferedImage;

// line 63 "model.ump"
// line 152 "model.ump"
public class ExitLock implements Tile {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------
	boolean isSolid = true; // check if player can walkThrought
	XYPos currentPosition; // keeps track of tiles position within a grid
	XYPos currentPositionOnScreen; // keeps track of a tiles position on screen
	BufferedImage imageToDisplay; // the image for the tokken

	boolean unlocked;
	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	public ExitLock(int xGrid, int yGrid, int xScreen, int yScreen) {
		currentPosition = new XYPos(xGrid, yGrid);
		currentPositionOnScreen = new XYPos(xScreen, yScreen);
		unlocked = false;
	}

	// ------------------------
	// INTERFACE
	// ------------------------

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
		return isSolid;
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
		return "Exit Lock";
	}
}