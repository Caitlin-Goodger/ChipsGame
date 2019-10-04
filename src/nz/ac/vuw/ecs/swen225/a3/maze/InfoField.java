package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * InfoField class is responsible for keeping the position
 * of the info field and storing the information.
 */
public class InfoField implements Tile {
	private static int id = -1;

	private String text;
	private Position currentPosition;

	/**
	 * Constructor for the info field.
	 * 
	 * @param text
	 * @param xGrid
	 * @param yGrid
	 */
	public InfoField(String text, int xGrid, int yGrid) {
		InfoField.id++;

		this.text = text;
		this.currentPosition = new Position(xGrid, yGrid);
	}

	/**
	 * Sets the text in the info field.
	 * 
	 * @param text
	 */
	public void setInfoFieldText(String text) {
		if (text == null) {
			throw new IllegalArgumentException("Argument must be a String.");
		}

		this.text = text;

		assert this.text != null;
	}

	/**
	 * Gets the text in the info field.
	 * 
	 * @return text
	 */
	public String getInfoFieldText() {
		assert this.text != null;

		return this.text;
	}

	/**
	 * Returns the id of the info field.
	 * 
	 * @return id
	 */
	public int getID() {
		assert InfoField.id != -1;

		return InfoField.id;
	}

	/**
	 * Get the path of the image.
	 */
	@Override
	public String getImagePath() {
		return "resources/CC8.png";
	}

	/**
	 * Get the y-coordinate of the info field.
	 */
	@Override
	public int getYPosition() {
		assert this.currentPosition != null;

		return this.currentPosition.getY();
	}

	/**
	 * Get the x-coordinate of the info field.
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
		return "I";
	}
}