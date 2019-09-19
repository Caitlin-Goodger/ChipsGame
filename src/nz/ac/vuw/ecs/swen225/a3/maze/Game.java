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
   * update chap's location in the given direction if its applicable
   * @param direction - the desired direction to move in
   */
  public void move(char direction) {
	  Tile destination = maze.getNeighbouringTile(chap.currentPosition, direction);
	  if (destination instanceof Wall || destination == null) {
		  //do nothing
	  }
	  else if (destination instanceof Free) {
		  //move chap in direction
		  chap.updatePosition(direction);
	  }
	  
  }
  
  

}