package nz.ac.vuw.ecs.swen225.a3.maze;

import java.awt.image.BufferedImage;

public interface Tile {

    boolean isSolid = false; // check if player can walkThrought
    XYPos currentPosition = null; // keeps track of tiles position within a grid
    XYPos currentPositionOnScreen = null; // keeps track of a tiles position on screen
    BufferedImage imageToDisplay = null; // the image for the token


    /**
       the char that are used to indicated direction are shown bellow
       Direction   char
       North         N
       South         S
       East          E
       West          W
       also note updatePosition will do nothing on Chap because the world moves
       around him not he moves around the world
     */
    public void updatePosition(char direction);

    /**
     *  Used to load the images bassed off the file path note using bufferedImage
     */
    public void loadImage();

    /**
     * used to get the tiles positions
     * @return
     */
    public XYPos getTilePosition();

    /**
     * used to get the onscreen position
     * @return
     */
    public XYPos getCurrentPositionOnScreen();
    
    /**
     * used for testing and just get Y position
     * @return
     */
    public int getYPositionOnScreen();

    /**
     * used for testing and just get X position
     * @return
     */
    public int getXPositionOnScreen();
    
    /**
     *  check to see if the player can walk through this tile
     *  true means they cannot walk here
     *  false means they can
     */
    public boolean isObjectSolid();

    /**
     *  returns the image so it can be rendered
     * @return
     */
    public String getImagePath();

    /**
     * used for testing and just get X position on map
     * @return
     */
	public int getXPosition();

	/**
	 * used for testing and just get Y position on map
	 */
	public int getYPosition();

}