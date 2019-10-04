package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Wall class is responsible for keeping the position of the
 * walls.
 */
public class Wall implements Tile {
	private Position currentPosition;

	/**
	 * Constructor for the walls.
	 * 
	 * @param xGrid
	 * @param yGrid
	 */
	public Wall(int xGrid, int yGrid) {
		this.currentPosition = new Position(xGrid, yGrid);
	}

	/**
	 * Get the path of the image.
	 */
	@Override
	public String getImagePath() {
		return "resources/CC1.png";
	}

	/**
	 * Get the y-coordinate of the wall.
	 */
	@Override
	public int getYPosition() {
		assert this.currentPosition != null;

		return this.currentPosition.getY();
	}

	/**
	 * Get the x-coordinate of the treasure.
	 */
	@Override
	public int getXPosition() {
		assert this.currentPosition != null;

		return this.currentPosition.getX();
	}

	/**
	 * Turns the tile into a string. Used for debugging.
	 */
	@Override
	public String toString() {
		return "W";
	}
}