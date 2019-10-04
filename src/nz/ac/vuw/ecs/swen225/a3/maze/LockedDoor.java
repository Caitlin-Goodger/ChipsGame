package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * LockedDoor class is responsible for keeping the position
 * of the locked door.
 */
public class LockedDoor implements Tile {
	private String colour;
	private boolean isSolid = true;
	private Position currentPosition;

	/**
	 * Constructor for the locked door.
	 * 
	 * @param colour
	 * @param xGrid
	 * @param yGrid
	 */
	public LockedDoor(String colour, int xGrid, int yGrid) {
		this.colour = colour;
		this.currentPosition = new Position(xGrid, yGrid);
	}

	/**
	 * Sets the colour of the locked door.
	 * 
	 * @param colour
	 */
	public void setColour(String colour) {
		if (colour == null) {
			throw new IllegalArgumentException("Argument must be a String.");
		}

		this.colour = colour;

		assert this.colour != null;
	}

	/**
	 * Gets the colour of the locked door.
	 * 
	 * @return colour
	 */
	public String getColour() {
		assert this.colour != null;

		return this.colour;
	}

	/**
	 * Checks if the player can unlock the door.
	 * 
	 * @param chap
	 * @return
	 */
	public boolean canUnlock(Chap chap) {
		if (chap == null) {
			throw new IllegalArgumentException("Argument must be a Chap.");
		}

		return chap.canUnlock(this);
	}

	/**
	 * Get the path of the image.
	 */
	@Override
	public String getImagePath() {
		return this.isSolid == true ? "resources/CC11.png" : "resources/CC2.png";
	}

	/**
	 * Get the y-coordinate of the locked door.
	 */
	@Override
	public int getYPosition() {
		assert this.currentPosition != null;

		return this.currentPosition.getY();
	}

	/**
	 * Get the x-coordinate of the locked door.
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
		return "D";
	}
}