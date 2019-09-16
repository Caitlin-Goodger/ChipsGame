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

}