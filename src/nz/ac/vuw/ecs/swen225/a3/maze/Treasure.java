package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Treasure class is responsible for keeping the position of
 * the treasure.
 */
public class Treasure implements Tile {
	private Position currentPosition;

	/**
	 * Constructor for the treasure.
	 * 
	 * @param xGrid
	 * @param yGrid
	 */
	public Treasure(int xGrid, int yGrid) {
		this.currentPosition = new Position(xGrid, yGrid);
	}

	/**
	 * Get the path of the image.
	 */
	@Override
	public String getImagePath() {
		return "resources/CC7.png";
	}

	/**
	 * Get the y-coordinate of the treasure.
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
		return "T";
	}
}