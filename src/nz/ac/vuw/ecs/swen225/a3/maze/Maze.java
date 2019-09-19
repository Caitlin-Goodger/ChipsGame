package nz.ac.vuw.ecs.swen225.a3.maze;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4648.92f3aa193 modeling language!*/


import java.util.*;

// line 28 "model.ump"
// line 117 "model.ump"
public class Maze
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Maze Associations
  private Tile tiles[][];

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Maze()
  {
    tiles = new Tile[0][0];
  }
  
  
  public Tile[][] getTiles() {
	  return tiles;
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
		  destination = tiles[y-1][x];
		  break;
	  case'E':
		  destination = tiles[y][x+1];
		  break;
	  case'S':
		  destination = tiles[y+1][x];
		  break;
	  default://W
		  destination = tiles[y][x-1];
		  break;
	  }
	  
	  return destination;
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