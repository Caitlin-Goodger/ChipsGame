package nz.ac.vuw.ecs.swen225.a3.maze;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4648.92f3aa193 modeling language!*/
import java.util.List;
import java.awt.image.BufferedImage;

// line 71 "model.ump"
// line 162 "model.ump"
public class Chap implements Tile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------
  boolean isSolid = false;
  XYPos currentPosition; // keeps track of tiles position within a grid
  XYPos currentPositionOnScreen; // keeps track of a tiles position on screen
  BufferedImage imageToDisplay; // the image for the tokken
  
  private List<String>inventory;
  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Chap(int xGrid, int yGrid, int xScreen, int yScreen){
	  currentPosition = new XYPos(xGrid,yGrid);
	  currentPositionOnScreen = new XYPos(xScreen,yScreen);
	  inventory = new ArrayList<String>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  public void pickupItem(Tile item) {
	  if(item instanceof Key) {
		  Key key = (Key) item;
		  inventory.add(key.getColour()+"Key");
	  }
	  
	  //can add more item Tile types later i.e. ice skaters
	  
  }

  @Override
  //Being world moves around Chap, chaps position changes on map but not screen
  public void updatePosition(char direction) {
	  if (direction == 'N') {
		  currentPosition.updatePos(0, 1);		  
	  } 
	  else if (direction == 'S') {
		  currentPosition.updatePos(0, -1);
	  }
	  else if (direction == 'E') {
		  currentPosition.updatePos(1,0);
	  }
	  else if (direction == 'W') {
		  currentPosition.updatePos(-1,0);
	  }
  }

  @Override
  public void loadImage() {

  }

  @Override
  public XYPos getTilePosition() {
    return currentPosition;
  }

  @Override
  public XYPos getCurrentPositionOnScreen() {
    return currentPositionOnScreen;
  }

  @Override
  public boolean isObjectSolid() {
    return isSolid;
  }

  @Override
  public BufferedImage getImageToDisplay() {
    return null;
  }

@Override
public int getYPositionOnScreen() {
	return currentPositionOnScreen.getY();
}

@Override
public int getXPositionOnScreen() {
	return currentPositionOnScreen.getX();
}

@Override
public int getYPosition() {
	return currentPosition.getY();
}

@Override
public int getXPosition() {
	return currentPosition.getX();
}

}