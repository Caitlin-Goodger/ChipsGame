package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.persistence.Map;

public class Maze {

	private Tile tiles[][];
	private int rows;
	private int cols;

	public Maze(int rows, int cols) {
		tiles = new Tile[rows][cols];
		this.rows = rows;
		this.cols = cols;
		
		new Map().readFile(this,"level-1");
	}

	public Tile[][] getTiles() {
		return tiles;
	}


	/**
	 * Method for debugging, prints the converted level to see if it looks correct.
	 */
	public void printConvertedLevel() {
		// Gets the width and height of the current level.
		int height = tiles[0].length;
		int width = tiles.length;

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				// Go to next line once end of line is reached.
				if (x == width - 1) {
					System.out.print(tiles[y][x].toString() + " ");

					System.out.println();
				} else {
					System.out.print(tiles[y][x].toString() + " ");
				}
			}
		}
	}
	
	/*
	 * locate and return chap tile from the maps
	 */
	public Chap findChap() {
		Tile target;
		Chap chap = null;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				target = tiles[row][col];
				if (target instanceof Chap) {
					chap = (Chap) target;
				}
			}
		}
		return chap;
	}

	/*
	 * Get the neighbouring tile from a given position and direction
	 * 
	 * @param origin - original position
	 * 
	 * @param direction - the direction to look in
	 * 
	 * @return - the corresponding neighbouring tile if there is one, or null
	 */
	public Tile getNeighbouringTile(XYPos origin, char direction) {
		int x = origin.getX();
		int y = origin.getY();
		Tile originTile = tiles[x][y]; // row, col
		Tile destination;
		if (originTile == null)
			return null;

		 //need to implement checks for going off the maze
		switch (direction) {
		case 'N':
			if (y - 1 < 0)
				return null;
			destination = tiles[y - 1][x];
			break;
		case 'E':
			if (x + 1 >= cols)
				return null;
			destination = tiles[y][x + 1];
			break;
		case 'S':
			if (y + 1 >= rows)
				return null;
			destination = tiles[y + 1][x];
			break;
		default:// W
			if (x - 1 < 0)
				return null;
			destination = tiles[y][x - 1];
			break;
		}
		
//		case 'N':
//			if (y - 1 < 0)
//				return null;
//			destination = tiles[x][y - 1];
//			break;
//		case 'E':
//			if (x + 1 >= cols)
//				return null;
//			destination = tiles[x + 1][y];
//			break;
//		case 'S':
//			if (y + 1 >= rows)
//				return null;
//			destination = tiles[x][y + 1];
//			break;
//		default:// W
//			if (x - 1 < 0)
//				return null;
//			destination = tiles[x - 1][y];
//			break;
//		}
		
		System.out.printf("original pos:%s\n", origin.toString());
		System.out.printf("originTile pos:x:%d, y:%d\n", originTile.getXPosition(), originTile.getYPosition());
		System.out.printf("looking for neighbouring tile in direction %c, it is %s\n",direction, destination.toString());
		System.out.printf("destination pos:x:%d, y:%d\n", destination.getXPosition(), destination.getYPosition());
		return destination;
	}

	/*
	 * set a tile on the maze
	 */
	public void setTile(XYPos pos, Tile tile) {
		int x = pos.getX();
		int y = pos.getY();
		tiles[y][x] = tile;
		System.out.printf("Setting tile at %s to %s--\n", pos.toString(), tile.toString());
	}

	/*
	 * Change a tile on the maze to a free tile
	 * 
	 * @param origin - the tile to be changed
	 */
	public void changeToFree(Tile target) {
		int x = target.getXPosition();
		int y = target.getYPosition();
		int xs = target.getXPositionOnScreen();
		int ys = target.getYPositionOnScreen();
		tiles[x][y] = new Free(x, y, xs, ys);
		System.out.printf("Setting tile at x:%d y:%d to FREE", x,y);
		
	}

	/*
	 * @return - number of treasures remaining in this level
	 */
	public int remainingTreasure() {
		Tile target;
		int count = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				target = tiles[row][col];
				if (target instanceof Treasure)
					count++;
			}
		}
		return count;
	}

	/**
	 * Set the 2D array of tiles. 
	 * @param tiles2
	 */
	public void setTiles(Tile[][] tiles2) {
		tiles = tiles2;
	}

}