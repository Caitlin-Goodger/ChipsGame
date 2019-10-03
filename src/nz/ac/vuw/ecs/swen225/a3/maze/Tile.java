package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Interface for all the tiles.
 */
public interface Tile {

	/**
	 * Check if the tile is solid.
	 */
	boolean isSolid = false;
	/**
	 * Position of the tile in the maze
	 */
	Position currentPosition = null;

	/**
	 * returns the image so it can be rendered
	 * 
	 * @return String
	 */
	public String getImagePath();

	/**
	 * used for testing and just get X position on map
	 * 
	 * @return int.
	 */
	public int getXPosition();

	/**
	 * used for testing and just get Y position on map
	 * 
	 * @return int.
	 */
	public int getYPosition();

}