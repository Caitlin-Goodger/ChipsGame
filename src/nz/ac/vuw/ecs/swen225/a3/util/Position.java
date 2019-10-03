package nz.ac.vuw.ecs.swen225.a3.util;

/**
 * Position class is responsible for storing the X and Y
 * coordinates.
 */
public class Position {
	private int x, y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the x coordinate.
	 * 
	 * @return x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Gets the y coordinate.
	 * 
	 * @return y
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Update the x and y positions.
	 * 
	 * @param xOffset
	 * @param yOffset
	 */
	public void updatePosition(int xOffset, int yOffset) {
		this.x += xOffset;
		this.y += yOffset;
	}

	/**
	 * Converts the position into a string, used for debugging.
	 */
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}
