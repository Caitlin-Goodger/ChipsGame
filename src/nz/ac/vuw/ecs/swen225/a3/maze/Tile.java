package nz.ac.vuw.ecs.swen225.a3.maze;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4648.92f3aa193 modeling language!*/

import java.awt.image.BufferedImage;

// line 32 "model.ump"
public interface Tile {

    // interface variable
    boolean isSolid = false; // check if player can walkThrought
    XYPos currentPosition = null; // keeps track of tiles position within a grid
    XYPos currentPositionOnScreen = null; // keeps track of a tiles position on screen
    BufferedImage imageToDisplay = null; // the image for the tokken


    /*
       the char that are used to indicated direction are showen bellow
       Direction   char
       North         N
       South         S
       East          E
       West          W
       also note updatePosition will do nothing on Chap because the world moves
       around him not he moves around the world
     */
    public void updatePosition(char direction);

    // used to load the images bassed off the file path note using bufferedImage
    public void loadImage();

    //used to get the tiles positions
    public XYPos getTilePosition();

    //used to get the onscreen position
    public XYPos getCurrentPositionOnScreen();
    
    //used for testing and just get Y position
    public int getYPositionOnScreen();

  //used for testing and just get X position
    public int getXPositionOnScreen();
    
    /* check to see if the player can walk thorught this area
       true means they cannot walk here
       false means they can
     */
    public boolean isObjectSolid();

    // returns the image so it can be rendered
    public BufferedImage getImageToDisplay();

  //used for testing and just get X position on map
	public int getXPosition();

	//used for testing and just get Y position on map
	public int getYPosition();

}