package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.persistence.Map;

public class Game {

	private Maze maze;
	private Chap chap;

	private InfoField info;
	private boolean onField = false;

	/**
	 * Constructor for the Game
	 * 
	 * @param aMaze = maze for the game.
	 */
	public Game(Maze aMaze) {
		this.maze = aMaze;

		if (!setMaze(aMaze)) {
			throw new RuntimeException(
					"Unable to create Game due to aMaze. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
		}
		if (maze.findChap() == null) {
			throw new RuntimeException("did not locate chap on map!");
		}

		this.chap = maze.findChap();
	}

	/**
	 * Get the maze.
	 * 
	 * @return
	 */
	public Maze getMaze() {
		return maze;
	}

	/**
	 * Set the Maze.
	 * 
	 * @param aNewMaze
	 * @return
	 */
	public boolean setMaze(Maze aNewMaze) {
		boolean wasSet = false;
		if (aNewMaze != null) {
			maze = aNewMaze;
			wasSet = true;
		}
		return wasSet;
	}

	/**
	 * Delete the maze.
	 */
	public void delete() {
		maze = null;
	}

	/**
	 * update chap's location in the given direction if its applicable
	 * 
	 * @param direction - the desired direction to move in
	 */
	public void move(char direction) {
		onField = false;
		
		Tile destination = maze.getNeighbouringTile(chap.currentPosition, direction);
		if (destination == null) {
			// do nothing
		} else if (destination instanceof Wall) {
			// do nothing
		} else if (destination instanceof Free) {
			moveChap(direction, destination);
		} else if (destination instanceof Key) {
			// pickup the key
			chap.pickupItem(destination);
			// remove key from map
			// maze.changeToFree(destination);
			// move chap in direction
			moveChap(direction, destination);
		} else if (destination instanceof LockedDoor) {
			LockedDoor door = (LockedDoor) destination;
			if (door.canUnlock(chap)) {
				// change the key tile to free
				// maze.changeToFree(destination);
				// move chap in direction
				moveChap(direction, destination);
				// remove the used key from chap's inventory
				// chap.removeItem(door.getColour(), "Key"); //removes key from inventory
			} else {
				System.out.println("No Corresponding Key!");
				// do nothing
			}
		} else if (destination instanceof Treasure) {
			// remove treasure from map
			// maze.changeToFree(destination);
			// move chap in direction
			moveChap(direction, destination);
		} else if (destination instanceof InfoField) {
			info = (InfoField) this.getMaze().getTile(destination.getYPosition(), destination.getXPosition());
			
			onField = true;
			
			// move chap in direction
			moveChap(direction, destination);
			// displayInfo
			// ...........
		} else if (destination instanceof ExitLock) {
			// check if there is still treasure to collect
			if (maze.remainingTreasure() != 0) {
				// do nothing
			} else {
				moveChap(direction, destination);


			}
		} else if (destination instanceof Exit) {
			String level = maze.getNextLevel();
			System.out.println(level);
			new Map().readFile(maze,level,"levels.json");
			// LEVEL COMPLETED

		}

	}

	/**
	 * *Only called by the above move class Move chap in the given direction, and
	 * re-fresh the tile he WAS on by replaceing it with chap's current onTile, and
	 * update onTile for chap
	 * 
	 * @param - the direction to move to
	 */
	public void moveChap(char direction, Tile destinationTile) {
		XYPos originalPos = new XYPos(chap.getXPosition(), chap.getYPosition());
		// move chap in direction
		chap.updatePosition(direction);
		XYPos destinationPos = chap.currentPosition;
		// re-fresh the tile he WAS on by replaceing it with chap's current onTile
//		System.out.printf("setting original pos %s to chap's previous which is %s\n", originalPos.toString(),
//				chap.getOnTile().toString());
		maze.setTile(originalPos, chap.getOnTile());
		maze.setTile(destinationPos, chap);
		// update onTile for chap
		chap.setOnTile(destinationTile);

	}

	/**
	 * Returns the chap.
	 * 
	 * @return chap
	 */
	public Chap getChap() {
		return chap;
	}

	/**
	 * Returns the info field.
	 * 
	 * @return info
	 */
	public InfoField getInfoField() {
		return info;
	}

	/**
	 * Returns if chap is on field.
	 * 
	 * @return onField
	 */
	public boolean onField() {
		return onField;
	}
}