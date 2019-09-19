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
	  else if (destination instanceof Key) {
		  //move chap in direction
		  chap.updatePosition(direction);
		  //pickup the key
		  chap.pickupItem(destination);
		  //change the key tile to free
		  maze.changeToFree(destination);
	  }
	  else if (destination instanceof LockedDoor) {
		  LockedDoor door = (LockedDoor)destination;
		  if(door.canUnlock(chap)) {
			  //change the key tile to free
			  maze.changeToFree(destination);
			  //move chap in direction
			  chap.updatePosition(direction);
		  }
		  else {
			  //do nothing
		  }
	  }
	  else if (destination instanceof Treasure) {
		  //remove treasure from map
		  maze.changeToFree(destination);
		  //move chap in direction
		  chap.updatePosition(direction);
	  }
	  else if (destination instanceof InfoField) {
		  //move chap in direction
		  chap.updatePosition(direction);
		  //displayInfo
		  //...........
	  }
	  else if (destination instanceof ExitLock) {
		  //check if there is still treasure to collect
		  if(maze.hasTreasureLeft()) {
			  //do nothing
		  }
		  else {
			  //change ExitLock to free
			  maze.changeToFree(destination);
			  //move chap in direction
			  chap.updatePosition(direction);
		  }
	  }
	  else if (destination instanceof Exit) {
		  
		  //LEVEL COMPLETED
		  
	  }
	  
	  
  }
  
  

}