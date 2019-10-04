package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Key class is responsible for keeping the position of the
 * key.
 */
public class Key implements Tile {
	private String colour;
	private Position currentPosition;

	/**
	 * Constructor for the key.
	 * 
	 * @param colour
	 * @param xGrid
	 * @param yGrid
	 */
	public Key(String colour, int xGrid, int yGrid) {
		this.colour = colour;
		this.currentPosition = new Position(xGrid, yGrid);
	}

	/**
	 * Sets the colour of the key.
	 * 
	 * @param colour
	 */
	public void setColour(String colour) {
		assert colour != null;

		this.colour = colour;
	}

	/**
	 * Gets the colour of the key.
	 * 
	 * @return colour
	 */
	public String getColour() {
		assert this.colour != null;

		return this.colour;
	}

	/**
	 * Get the path of the image.
	 */
	@Override
	public String getImagePath() {
		return "resources/CC12.png";
	}

	/**
	 * Get the y-coordinate of the key.
	 */
	@Override
	public int getYPosition() {
		assert this.currentPosition != null;

		return this.currentPosition.getY();
	}

	/**
	 * Get the x-coordinate of the key.
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
		return "K";
	}
}