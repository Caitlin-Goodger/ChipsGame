package nz.ac.vuw.ecs.swen225.a3.maze;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * Monster Tile. Is an implementation of the tile class. 
 * @author Caitlin
 */
public class Monster implements Tile {

	boolean isSolid = true; // check if player can walkThrought
	XYPos currentPosition; // keeps track of tiles position within a grid
	XYPos currentPositionOnScreen; // keeps track of a tiles position on screen
	BufferedImage imageToDisplay; // the image for the token
	private Tile onTile;
	
	/**
	 * Constructor for the exit tile. 
	 * @param xGrid = x co-ordinate in of the tile on the grid.
	 * @param yGrid = y co-ordinate in of the tile on the grid.
	 * @param xScreen = x co-ordinate in of the tile on the screen.
	 * @param yScreen = y co-ordinate in of the tile on the screen.
	 */
	public Monster(int xGrid, int yGrid, int xScreen, int yScreen) {
		currentPosition = new XYPos(xGrid, yGrid);
		currentPositionOnScreen = new XYPos(xScreen, yScreen);
		onTile = new Free(xGrid, yGrid, xScreen, yScreen);
	}
	
	/**
	 * Move the monster in a random free direction. 
	 */
	public void move(Game g) {
		Maze m = g.getMaze();
		ArrayList<Tile> freeTiles = new ArrayList();
		int x = currentPosition.getX();
		int y = currentPosition.getY();
		if(!m.getTile(x-1, y).isObjectSolid()) {
			freeTiles.add(m.getTile(x-1, y));
		}if(!m.getTile(x+1, y).isObjectSolid()) {
			freeTiles.add(m.getTile(x+1, y));
		}if(!m.getTile(x, y-1).isObjectSolid()) {
			freeTiles.add(m.getTile(x, y-1));
		}if(!m.getTile(x, y+1).isObjectSolid()) {
			freeTiles.add(m.getTile(x, y+1));
		}
		int directionN = 1 + (int) (Math.random() * (freeTiles.size()-1)+1);
		Tile moveTo = freeTiles.get(directionN);
		
		char direction = 'D';
		
		if(directionN==1) {
			direction = 'W';
		} else if (directionN==2) {
			direction = 'E';
		} else if (directionN==3) {
			direction = 'N';
		} else {
			direction = 'S';
		}
		
		XYPos original = currentPosition;
		updatePosition(direction);
		XYPos destination = currentPosition;
		m.setTile(original,onTile);
		m.setTile(destination,this);
		setOnTile(moveTo);
		
		
		
//		XYPos originalPos = new XYPos(chap.getXPosition(), chap.getYPosition());
//		// move chap in direction
//		chap.updatePosition(direction);
//		XYPos destinationPos = chap.currentPosition;
//		maze.setTile(originalPos, chap.getOnTile());
//		maze.setTile(destinationPos, chap);
//		// update onTile for chap
//		chap.setOnTile(destinationTile);

	}

	private void setOnTile(Tile moveTo) {
		onTile = moveTo;
	}

	/**
	 * Update the position that the tile is in.
	 * @param direction = direction. 
	 */
	@Override
	public void updatePosition(char direction) {
		if (direction == 'N') {
			currentPosition.updatePos(0, 1);
		} else if (direction == 'S') {
			currentPosition.updatePos(0, -1);
		} else if (direction == 'E') {
			currentPosition.updatePos(1, 0);
		} else if (direction == 'W') {
			currentPosition.updatePos(-1, 0);
		}
		currentPositionOnScreen = currentPosition;
	}

	/**
	 * Load the image of the tile. 
	 */
	@Override
	public boolean loadImage() {
		return true;
	}

	/**
	 * Get the current position of the tile on the grid. 
	 */
	@Override
	public XYPos getTilePosition() {
		return currentPosition;
	}

	/**
	 * Get the current position of the tile on the screen. 
	 */
	@Override
	public XYPos getCurrentPositionOnScreen() {
		return currentPositionOnScreen;
	}

	/**
	 * Check whether the object is solid. 
	 */
	@Override
	public boolean isObjectSolid() {
		return isSolid;
	}

	/**
	 * Get the path of the image. 
	 */
	@Override
	public String getImagePath() {
		return "resources/CC14.png";
	}

	/**
	 * Get the y co-ordinate of the tile on the screen. 
	 */
	@Override
	public int getYPositionOnScreen() {
		return currentPositionOnScreen.getY();
	}

	/**
	 * Get the x co-ordinate of the tile on the screen. 
	 */
	@Override
	public int getXPositionOnScreen() {
		return currentPositionOnScreen.getX();
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
	
	/**
	 * re-set the XYPos
	 */
	@Override
	public void resetPosition(XYPos pos) {
		this.currentPosition = pos;
		
	}
}
