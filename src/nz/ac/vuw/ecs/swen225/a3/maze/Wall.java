package nz.ac.vuw.ecs.swen225.a3.maze;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4648.92f3aa193 modeling language!*/


import java.awt.image.BufferedImage;

// line 36 "model.ump"
// line 122 "model.ump"
public class Wall implements Tile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Wall()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  @Override
  public void updatePosition(char direction) {

  }

  @Override
  public void loadImage() {

  }

  @Override
  public XYPos getTilePosition() {
    return null;
  }

  @Override
  public XYPos getCurrentPositionOnScreen() {
    return null;
  }

  @Override
  public boolean isObjectSolid() {
    return false;
  }

  @Override
  public BufferedImage getImageToDisplay() {
    return null;
  }
}