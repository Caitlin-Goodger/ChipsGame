package nz.ac.vuw.ecs.swen225.a3.maze;

import nz.ac.vuw.ecs.swen225.a3.persistence.Level;

// line 28 "model.ump"
// line 117 "model.ump"
public class Maze
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Maze Associations
  private Tile tiles[][];
  private int rows;
  private int cols;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Maze(int rows, int cols)
  {
    tiles = new Tile[rows][cols];
    this.rows = rows;
    this.cols = cols;
  }
  
  
  public Tile[][] getTiles() {
	  System.out.println(tiles);
	  return tiles;
  }
  
  public void setTiles() {
	  tiles = new Level().convertLevel();
  }
  
  /*
   * locate and return chap tile from the maps
   */
  public Chap findChap() {
	  Tile target;
	  Chap chap = null;
	  for(int row = 0; row<rows; row++) {
		  for(int col = 0; col<cols; col++) {
			  target = tiles[row][col];
			  if(target instanceof Chap) {
				  chap = (Chap)target;
			  }
		  }
	  }
	  return chap;
  }
  
  /*
   * Get the neighbouring tile from a given position and direction
   * @param origin - original position
   * @param direction - the direction to look in
   * @return - the corresponding neighbouring tile if there is one, or null
   */
  public Tile getNeighbouringTile(XYPos origin, char direction) {
	  int x = origin.getX();
	  int y = origin.getY();
	  Tile originTile = tiles[y][x]; //row, col
	  Tile destination;
	  if(originTile == null) return null;
	  
	  //need to implement checks for going off the maze
	  switch(direction) {
	  case'N':
		  if(y-1 < 0) return null;
		  destination = tiles[y-1][x];
		  break;
	  case'E':
		  if(x+1 >= cols) return null;
		  destination = tiles[y][x+1];
		  break;
	  case'S':
		  if(y+1 >= rows) return null;
		  destination = tiles[y+1][x];
		  break;
	  default://W
		  if(x-1 < 0) return null;
		  destination = tiles[y][x-1];
		  break;
	  }
	  
	  return destination;
  }
  
  /*
   * set a tile on the maze
   */
  public void setTile(XYPos pos, Tile tile) {
	  int x = pos.getX();
	  int y = pos.getY();
	  tiles[y][x] = tile;
  }
  
  /*
   * Change a tile on the maze to a free tile
   * @param origin - the tile to be changed
   */
  public void changeToFree(Tile origin) {
	  int x = origin.getXPosition();
	  int y = origin.getYPosition();
	  int xs = origin.getXPositionOnScreen();
	  int ys = origin.getYPositionOnScreen();
	  tiles[y][x] = new Free(x,y,xs,ys);
  }
  
  /*
   * @return - true if there are still treasure left to collect in the Maze
   */
  public boolean hasTreasureLeft() {
	  Tile target;
	  for(int row = 0; row<rows; row++) {
		  for(int col = 0; col<cols; col++) {
			  target = tiles[row][col];
			  if(target instanceof Treasure) return false;
		  }
	  }
	  return true;
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
//  public Tile getTile(int index)
//  {
//    Tile aTile = tiles.get(index);
//    return aTile;
//  }
//
//  public List<Tile> getTiles()
//  {
//    List<Tile> newTiles = Collections.unmodifiableList(tiles);
//    return newTiles;
//  }
//
//  public int numberOfTiles()
//  {
//    int number = tiles.size();
//    return number;
//  }
//
//  public boolean hasTiles()
//  {
//    boolean has = tiles.size() > 0;
//    return has;
//  }
//
//  public int indexOfTile(Tile aTile)
//  {
//    int index = tiles.indexOf(aTile);
//    return index;
//  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTiles()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
//  public boolean addTile(Tile aTile)
//  {
//    boolean wasAdded = false;
//    if (tiles.contains(aTile)) { return false; }
//    tiles.add(aTile);
//    wasAdded = true;
//    return wasAdded;
//  }
//
//  public boolean removeTile(Tile aTile)
//  {
//    boolean wasRemoved = false;
//    if (tiles.contains(aTile))
//    {
//      tiles.remove(aTile);
//      wasRemoved = true;
//    }
//    return wasRemoved;
//  }
//  /* Code from template association_AddIndexControlFunctions */
//  public boolean addTileAt(Tile aTile, int index)
//  {  
//    boolean wasAdded = false;
//    if(addTile(aTile))
//    {
//      if(index < 0 ) { index = 0; }
//      if(index > numberOfTiles()) { index = numberOfTiles() - 1; }
//      tiles.remove(aTile);
//      tiles.add(index, aTile);
//      wasAdded = true;
//    }
//    return wasAdded;
//  }
//
//  public boolean addOrMoveTileAt(Tile aTile, int index)
//  {
//    boolean wasAdded = false;
//    if(tiles.contains(aTile))
//    {
//      if(index < 0 ) { index = 0; }
//      if(index > numberOfTiles()) { index = numberOfTiles() - 1; }
//      tiles.remove(aTile);
//      tiles.add(index, aTile);
//      wasAdded = true;
//    } 
//    else 
//    {
//      wasAdded = addTileAt(aTile, index);
//    }
//    return wasAdded;
//  }
//
//  public void delete()
//  {
//    tiles.clear();
//  }

}