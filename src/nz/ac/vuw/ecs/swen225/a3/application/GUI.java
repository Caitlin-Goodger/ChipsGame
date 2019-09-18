package nz.ac.vuw.ecs.swen225.a3.application;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4648.92f3aa193 modeling language!*/



// line 6 "model.ump"
// line 87 "model.ump"
public class GUI
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GUI Associations
  private MainFrame frame;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GUI(MainFrame aFrame)
  {
    if (!setFrame(aFrame))
    {
      throw new RuntimeException("Unable to create GUI due to aFrame. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public MainFrame getFrame()
  {
    return frame;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setFrame(MainFrame aNewFrame)
  {
    boolean wasSet = false;
    if (aNewFrame != null)
    {
      frame = aNewFrame;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    frame = null;
  }

}