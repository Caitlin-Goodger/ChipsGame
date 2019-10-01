package nz.ac.vuw.ecs.swen225.a3.application;


/**
 * Class for the GUI. 
 * @author Caitlin
 */
public class GUI
{

  private MainFrame frame;


  /**
   * Constructor for the GUI class. 
   * @param aFrame = main frame of GUI. 
   */
  public GUI(MainFrame aFrame)
  {
    if (!setFrame(aFrame))
    {
      throw new RuntimeException("Unable to create GUI due to aFrame. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  /**
   * Get the main frame of the GUI. 
   * @return MainFrame. 
   */
  public MainFrame getFrame()
  {
    return frame;
  }
  
  
  /**
   * Set the main frame of the GUI. 
   * @param aNewFrame = new frame to set. 
   * @return boolean. 
   */
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

  /**
   * Delete the frame by setting to null. 
   */
public void delete()
  {
    frame = null;
  }

}