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
    if(maze.findChap() == null) {
      throw new RuntimeException("did not locate chap on map!");
    }
    this.chap = maze.findChap();
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
		  moveChap(direction, destination);
	  }
	  else if (destination instanceof Key) {
		  //pickup the key
		  chap.pickupItem(destination);
		  //remove key from map
		  maze.changeToFree(destination);
		  //move chap in direction
		  moveChap(direction, destination);
	  }
	  else if (destination instanceof LockedDoor) {
		  LockedDoor door = (LockedDoor)destination;
		  if(door.canUnlock(chap)) {
			  //change the key tile to free
			  maze.changeToFree(destination);
			  //move chap in direction
			  chap.updatePosition(direction);
			  //remove the used key from chap's inventory
			  //chap.removeItem(door.getColour(), "Key"); //removes key from inventory
		  }
		  else {
			  //do nothing
		  }
	  }
	  else if (destination instanceof Treasure) {
		  //remove treasure from map
		  maze.changeToFree(destination);
		  //move chap in direction
		  moveChap(direction, destination);
	  }
	  else if (destination instanceof InfoField) {
		  //move chap in direction
		  moveChap(direction, destination);
		  //displayInfo
		  //...........
	  }
	  else if (destination instanceof ExitLock) {
		  //check if there is still treasure to collect
		  if(maze.hasTreasureLeft()) {
			  //do nothing
		  }
		  else {
			  moveChap(direction, destination);
		  }
	  }
	  else if (destination instanceof Exit) {
		  
		  //LEVEL COMPLETED
		  
	  }
	  
	  
  }
  
  /*
   * *Only called by the above move class
   * Move chap in the given direction, and 
   * re-fresh the tile he WAS on by replaceing it with chap's current onTile, and
   * update onTile for chap
   * @param - the direction to move to
   */
  public void moveChap(char direction, Tile destinationTile) {
	  XYPos originalPos = chap.currentPosition;
	  
	  //move chap in direction
	  chap.updatePosition(direction);
	  //re-fresh the tile he WAS on by replaceing it with chap's current onTile
	  maze.setTile(originalPos, chap.getOnTile());
	  //update onTile for chap
	  chap.setOnTile(destinationTile);
	 
	 
  }
  
  

}