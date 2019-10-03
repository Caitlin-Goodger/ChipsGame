package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Wall tile. Is an implemenation of the tile class.
 * 
 * @author Caitlin
 *
 */
public class Wall implements Tile {
	private boolean isSolid = true; // check if player can walkThrought
	private Position currentPosition; // keeps track of tiles position within a grid

	/**
	 * Constructor for the Wall class.
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
	public Wall(int xGrid, int yGrid) {
		currentPosition = new Position(xGrid, yGrid);
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
		return "resources/CC1.png";
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
		return "W";
	}
}