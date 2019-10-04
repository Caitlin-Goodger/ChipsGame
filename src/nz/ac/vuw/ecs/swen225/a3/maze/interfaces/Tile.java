package nz.ac.vuw.ecs.swen225.a3.maze.interfaces;

import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Interface for all the tiles, all classes that extend this
 * interface must implement these variables and methods.
 */
public interface Tile {

	/**
	 * Used to check if the tile is solid.
	 */
	boolean isSolid = false;

	/**
	 * Holds the position of the tile in the maze.
	 */
	Position currentPosition = null;

	/**
	 * Returns the image to be displayed.
	 * 
	 * @return String
	 */
	public String getImagePath();

	/**
	 * Used for testing and gets X position on maze.
	 * 
	 * @return int
	 */
	public int getXPosition();

	/**
	 * Used for testing and gets Y position on maze.
	 * 
	 * @return int
	 */
	public int getYPosition();
}