package nz.ac.vuw.ecs.swen225.a3.maze;

import java.util.ArrayList;
import java.util.Random;

import nz.ac.vuw.ecs.swen225.a3.persistence.Maze;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Monster Tile. Is an implementation of the tile class.
 * 
 * @author Caitlin
 */
public class Monster implements Tile {
	private boolean isSolid = true; // check if player can walkThrought
	private Position currentPosition; // keeps track of tiles position within a grid
	private Tile onTile;

	/**
	 * Constructor for the exit tile.
	 * 
	 * @param xGrid   = x co-ordinate in of the tile on the
	 *                grid.
	 * @param yGrid   = y co-ordinate in of the tile on the
	 *                grid.
	 * @param xScreen = x co-ordinate in of the tile on the
	 *                screen.
	 * @param yScreen = y co-ordinate in of the tile on the
	 *                screen.
	 */
	public Monster(int xGrid, int yGrid) {
		currentPosition = new Position(xGrid, yGrid);
		onTile = new Free(xGrid, yGrid);
	}

	/**
	 * Move the monster in a random free direction.
	 */
	public void move(Game g) {
		Maze m = g.getMaze();
		ArrayList<Tile> freeTiles = new ArrayList();
		int x = currentPosition.getX();
		int y = currentPosition.getY();
		if (m.getTile(y, x - 1) instanceof Free && m.getTile(y, x - 1).toString().equals("F")) {
			freeTiles.add(m.getTile(y, x - 1));
		} else {
			freeTiles.add(null);
		}
		if (m.getTile(y, x + 1) instanceof Free && m.getTile(y, x + 1).toString().equals("F")) {
			freeTiles.add(m.getTile(y, x + 1));
		} else {
			freeTiles.add(null);
		}
		if (m.getTile(y - 1, x) instanceof Free && m.getTile(y - 1, x).toString().equals("F")) {
			freeTiles.add(m.getTile(y - 1, x));
		} else {
			freeTiles.add(null);
		}
		if (m.getTile(y + 1, x) instanceof Free && m.getTile(y + 1, x).toString().equals("F")) {
			freeTiles.add(m.getTile(y + 1, x));
		} else {
			freeTiles.add(null);
		}
		Random r = new Random();
		int directionN = r.nextInt(4);
		Tile moveTo = freeTiles.get(directionN);
		while (moveTo == null) {
			r = new Random();
			directionN = r.nextInt(4);
			moveTo = freeTiles.get(directionN);
		}
		char direction = 'D';

		if (directionN == 0) {
			direction = 'W';
		} else if (directionN == 1) {
			direction = 'E';
		} else if (directionN == 2) {
			direction = 'S';
		} else {
			direction = 'N';
		}

		Position original = new Position(currentPosition.getX(), currentPosition.getY());
		updatePosition(direction);
		Position destination = currentPosition;
		m.setTile(original, onTile);
		m.setTile(destination, this);
		setOnTile(moveTo);

	}

	private void setOnTile(Tile moveTo) {
		onTile = moveTo;
	}

	/**
	 * Update the position that the tile is in.
	 * 
	 * @param direction = direction.
	 */
	public void updatePosition(char direction) {
		if (direction == 'N') {
			currentPosition.updatePosition(0, 1);
		} else if (direction == 'S') {
			currentPosition.updatePosition(0, -1);
		} else if (direction == 'E') {
			currentPosition.updatePosition(1, 0);
		} else if (direction == 'W') {
			currentPosition.updatePosition(-1, 0);
		}
	}

	/**
	 * Get the path of the image.
	 */
	@Override
	public String getImagePath() {
		return "resources/CC14.png";
	}

	/**
	 * Get the y co-ordinate of the tile on the grid.
	 */
	@Override
	public int getYPosition() {
		return currentPosition.getY();
	}

	/**
	 * Get the x co-ordinate of the tile on the grid.
	 */
	@Override
	public int getXPosition() {
		return currentPosition.getX();
	}

	/**
	 * To String Method.
	 */
	@Override
	public String toString() {
		return "M";
	}
}
