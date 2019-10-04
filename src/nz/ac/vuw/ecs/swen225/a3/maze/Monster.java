package nz.ac.vuw.ecs.swen225.a3.maze;

import java.util.ArrayList;
import java.util.Random;

import nz.ac.vuw.ecs.swen225.a3.maze.game.Game;
import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.persistence.Maze;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

/**
 * Monster class is responsible for the position and
 * movement of the monsters.
 */
public class Monster implements Tile {
	private Position currentPosition;
	private Tile onTile;

	/**
	 * Constructor for the monster.
	 * 
	 * @param xGrid
	 * @param yGrid
	 */
	public Monster(int xGrid, int yGrid) {
		this.currentPosition = new Position(xGrid, yGrid);
		this.onTile = new Free(xGrid, yGrid);
	}

	/**
	 * Moves the monster in a random direction that is free.
	 * 
	 * @param game
	 */
	public void move(Game game) {
		if (game == null) {
			throw new IllegalArgumentException("Argument must be a Game.");
		}

		ArrayList<Tile> freeTiles = new ArrayList<Tile>();

		Maze maze = game.getMaze();

		int x = this.currentPosition.getX();
		int y = this.currentPosition.getY();

		// Adds tiles that are free to the array.
		if (maze.getTile(y, x - 1) instanceof Free
				&& maze.getTile(y, x - 1).toString().equals("F")) {
			freeTiles.add(maze.getTile(y, x - 1));
		} else {
			freeTiles.add(null);
		}
		if (maze.getTile(y, x + 1) instanceof Free
				&& maze.getTile(y, x + 1).toString().equals("F")) {
			freeTiles.add(maze.getTile(y, x + 1));
		} else {
			freeTiles.add(null);
		}
		if (maze.getTile(y - 1, x) instanceof Free
				&& maze.getTile(y - 1, x).toString().equals("F")) {
			freeTiles.add(maze.getTile(y - 1, x));
		} else {
			freeTiles.add(null);
		}
		if (maze.getTile(y + 1, x) instanceof Free
				&& maze.getTile(y + 1, x).toString().equals("F")) {
			freeTiles.add(maze.getTile(y + 1, x));
		} else {
			freeTiles.add(null);
		}

		int randomDirection = new Random().nextInt(4);
		Tile moveTo = freeTiles.get(randomDirection);

		while (moveTo == null) {
			randomDirection = new Random().nextInt(4);
			moveTo = freeTiles.get(randomDirection);
		}

		char direction = 'D';

		switch (randomDirection) {
		case 0:
			direction = 'W';

			break;
		case 1:
			direction = 'E';

			break;
		case 2:
			direction = 'S';

			break;
		default:
			direction = 'N';
		}

		Position original = new Position(currentPosition.getX(), currentPosition.getY());
		boolean positionUpdated = updatePosition(direction);
		Position destination = currentPosition;
		maze.setTile(original, onTile);
		maze.setTile(destination, this);
		boolean onTileUpdated = setOnTile(moveTo);

		assert direction != 'D' && positionUpdated && onTileUpdated;
	}

	/**
	 * Set the onTile of the monster.
	 * 
	 * @param tile
	 * @return
	 */
	private boolean setOnTile(Tile tile) {
		if (tile == null) {
			throw new IllegalArgumentException("Argument must be a Tile.");
		}

		this.onTile = tile;

		assert this.onTile != null;

		if (this.onTile == tile) {
			return true;
		}

		return false;
	}

	/**
	 * Update the position of the monster.
	 * 
	 * @param direction
	 * @return
	 */
	public boolean updatePosition(Character direction) {
		if (direction == null) {
			throw new IllegalArgumentException("Argument must be a Character.");
		}

		if (direction == 'N') {
			this.currentPosition.updatePosition(0, 1);
		} else if (direction == 'S') {
			this.currentPosition.updatePosition(0, -1);
		} else if (direction == 'E') {
			this.currentPosition.updatePosition(1, 0);
		} else if (direction == 'W') {
			this.currentPosition.updatePosition(-1, 0);
		}

		// Make sure direction was set, if so then current position
		// of monster will be updated.
		assert direction == 'N' || direction == 'S' || direction == 'E' || direction == 'W';

		if (direction == 'N' || direction == 'S' || direction == 'E' || direction == 'W') {
			return true;
		}

		return false;
	}

	/**
	 * Get the path of the image.
	 */
	@Override
	public String getImagePath() {
		return "resources/CC14.png";
	}

	/**
	 * Get the y-coordinate of the monster.
	 */
	@Override
	public int getYPosition() {
		assert this.currentPosition != null;

		return this.currentPosition.getY();
	}

	/**
	 * Get the x co-ordinate of the tile on the grid.
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
		return "M";
	}
}
