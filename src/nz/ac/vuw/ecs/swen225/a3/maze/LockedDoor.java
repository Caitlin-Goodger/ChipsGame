package nz.ac.vuw.ecs.swen225.a3.maze;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4648.92f3aa193 modeling language!*/



// line 49 "model.ump"
// line 137 "model.ump"
public class LockedDoor implements Tile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LockedDoor Attributes
  private String colour;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LockedDoor(String aColour)
  {
    colour = aColour;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setColour(String aColour)
  {
    boolean wasSet = false;
    colour = aColour;
    wasSet = true;
    return wasSet;
  }

  public String getColour()
  {
    return colour;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "colour" + ":" + getColour()+ "]";
  }
}