package nz.ac.vuw.ecs.swen225.a3.maze;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4648.92f3aa193 modeling language!*/



// line 54 "model.ump"
// line 142 "model.ump"
public class InfoField implements Tile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //InfoField Attributes
  private String text;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public InfoField(String aText)
  {
    text = aText;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setText(String aText)
  {
    boolean wasSet = false;
    text = aText;
    wasSet = true;
    return wasSet;
  }

  public String getText()
  {
    return text;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "text" + ":" + getText()+ "]";
  }
}