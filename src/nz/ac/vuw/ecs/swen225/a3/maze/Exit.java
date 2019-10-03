package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Exit class is responsible for keeping the position of the
 * exit.
 */
public class Exit implements Tile {
	private Position currentPosition; // Keeps track of the exit.

	/**
	 * Constructor for the exit.
	 * 
	 * @param xGrid
	 * @param yGrid
	 */
	public Exit(int xGrid, int yGrid) {
		this.currentPosition = new Position(xGrid, yGrid);
	}

	/**
	 * Get the path of the image.
	 */
	@Override
	public String getImagePath() {
		return "resources/CC10.png";
	}

	/**
	 * Get the y-coordinate of the exit.
	 */
	@Override
	public int getYPosition() {
		assert this.currentPosition != null;

		return this.currentPosition.getY();
	}

	/**
	 * Get the x-coordinate of the exit.
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
		return "X";
	}
}