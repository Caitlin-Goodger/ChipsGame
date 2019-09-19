package nz.ac.vuw.ecs.swen225.a3.maze;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4648.92f3aa193 modeling language!*/



// line 25 "model.ump"
// line 112 "model.ump"
public class Game
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Game Associations
  private Maze maze;
  private Tile[][] map;
  private Chap chap;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game(Maze aMaze)
  {
    if (!setMaze(aMaze))
    {
      throw new RuntimeException("Unable to create Game due to aMaze. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    map = maze.getTiles();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Maze getMaze()
  {
    return maze;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setMaze(Maze aNewMaze)
  {
    boolean wasSet = false;
    if (aNewMaze != null)
    {
      maze = aNewMaze;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    maze = null;
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
	  Tile originTile = map[y][x]; //row, col
	  Tile destination;
	  if(originTile == null) return null;
	  
	  //need to implement checks for going off the maze
	  switch(direction) {
	  case'N':
		  destination = map[y-1][x];
		  break;
	  case'E':
		  destination = map[y][x+1];
		  break;
	  case'S':
		  destination = map[y+1][x];
		  break;
	  default://W
		  destination = map[y][x-1];
		  break;
	  }
	  
	  return destination;
  }
  
  

}