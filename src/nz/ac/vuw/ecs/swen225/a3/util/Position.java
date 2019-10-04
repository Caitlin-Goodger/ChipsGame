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
		assert this.x >= 0;

		return this.x;
	}

	/**
	 * Gets the y coordinate.
	 * 
	 * @return y
	 */
	public int getY() {
		assert this.y >= 0;

		return this.y;
	}

	/**
	 * Update the x and y positions.
	 * 
	 * @param xOffset
	 * @param yOffset
	 */
	public void updatePosition(int xOffset, int yOffset) {
		if (xOffset <= -1 && xOffset >= 1) {
			throw new IllegalArgumentException("Argument must be between -1 and 1.");
		}

		if (yOffset <= -1 && yOffset >= 1) {
			throw new IllegalArgumentException("Argument must be between -1 and 1.");
		}

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
