package nz.ac.vuw.ecs.swen225.a3.render;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Renderer class. Used to render the GUI.
 * 
 * @author Caitlin
 *
 */
public class Renderer {
  private String wallPath = "resources/CC1.png";
  private String floorPath = "resources/CC2.png";
  private String inventortPath = "resources/CC13.png";

  private BufferedImage wall;
  private BufferedImage floor;
  private BufferedImage inv;

  /**
   * Constructor for the Rendered Class.
   */
  public Renderer() {
    // render the floor
    try {
      wall = (BufferedImage) ImageIO.read(new File(wallPath));
    } catch (IOException e) {
      e.printStackTrace();
    }

    // render the wall
    try {
      floor = (BufferedImage) ImageIO.read(new File(floorPath));
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      inv = (BufferedImage) ImageIO.read(new File(inventortPath));
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * Merge two images together.
   * 
   * @param toAddOnTop = image to put on the top.
   * @param addToWall  = boolean. True is a wall and false is free.
   * @return Image.
   */
  public Image mergeImages(String toAddOnTop, boolean addToWall) {
    // creates the image
    Image returnImage;
    BufferedImage toAdd = null;
    try {
      toAdd = (BufferedImage) ImageIO.read(new File(toAddOnTop));
    } catch (IOException e) {
      e.printStackTrace();
    }

    // combine the images
    if (toAdd != null) {
      for (int i = 0; i < toAdd.getWidth(); i++) {
        for (int u = 0; u < toAdd.getHeight(); u++) {
          if (toAdd.getRGB(i, u) == 0 && addToWall) {
            toAdd.setRGB(i, u, floor.getRGB(i, u));
          } else if (toAdd.getRGB(i, u) == 0 && addToWall == false) {
            toAdd.setRGB(i, u, wall.getRGB(i, u));
          }
        }
      }
    }
    returnImage = toAdd;

    return returnImage;

  }

  /**
   * Merge two images together with a color tint.
   * 
   * @param toAddOnTop = image to put on the top.
   * @param addToWall  = boolean. True is a wall and false is free.
   * @param tintColor  = color tint to add.
   * @param grayScale  = creates the greyscale affect for pausing the game
   * @return Image.
   */
  public Image mergeImages(String toAddOnTop, int addToWall, Color tintColor, boolean grayScale) {
    // creates the image
    Image returnImage;
    Color col;
    Color holdColor;
    BufferedImage toAdd = null;
    BufferedImage hold = null;


    try {
      toAdd = (BufferedImage) ImageIO.read(new File(toAddOnTop));
      hold = new BufferedImage(toAdd.getHeight(),  toAdd.getWidth(), BufferedImage.TYPE_BYTE_GRAY);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
    
    // combine the images
    if (toAdd != null) {
      for (int i = 0; i < toAdd.getWidth(); i++) {
        for (int u = 0; u < toAdd.getHeight(); u++) {
          // added the basic backgrounds
          if (toAdd.getRGB(i, u) == 0 && addToWall == 1) {
            toAdd.setRGB(i, u, floor.getRGB(i, u));
          } else if (toAdd.getRGB(i, u) == 0 && addToWall == 2) {
            toAdd.setRGB(i, u, wall.getRGB(i, u));
          } else if (toAdd.getRGB(i, u) == 0 && addToWall == 3) {
            toAdd.setRGB(i, u, inv.getRGB(i, u));
          } else if (toAdd.getRGB(i, u) == Color.black.getRGB()) {
            toAdd.setRGB(i, u, Color.black.getRGB());
          } else {
            holdColor = new Color(toAdd.getRGB(i, u), true);

            col = new Color(((holdColor.getRed() + tintColor.getRed()) / 2),
                ((holdColor.getGreen() + tintColor.getGreen()) / 2),
                ((holdColor.getBlue() + tintColor.getBlue()) / 2));

            toAdd.setRGB(i, u, col.getRGB());
          }
        } 
      }
    }

    // needed for the pause conversations
    if (grayScale == false) {
      for (int i = 0; i < toAdd.getHeight(); i++) {
        for (int j = 0; j < toAdd.getWidth(); j++) {
          hold.setRGB(i,j,toAdd.getRGB(i,j));
        }
      }
      toAdd = hold;
    }

    returnImage = toAdd;

    return returnImage;
  }

  /**
   * greyScale screen when paused. 
   * 
   * @param image = to be gray scaled
   * @return Image
   */
  public Image greyScale(String image) {
    Image returnValue;
    BufferedImage toRot = null;
    BufferedImage hold = null;

    try {
      toRot = (BufferedImage) ImageIO.read(new File(image));
      hold = new BufferedImage(toRot.getHeight(), toRot.getWidth(), BufferedImage.TYPE_BYTE_GRAY);

      for (int i = 0; i < toRot.getHeight(); i++) {
        for (int j = 0; j < toRot.getWidth(); j++) {
          hold.setRGB(i,j,toRot.getRGB(i,j));
        }
      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }

    returnValue = hold;
    return returnValue;

  }



  /**
   * Rotate images by 90. 
   *
   * @param toRotate = image to rotate
   * @param totalRorations  = how many times the image will be rotated by 90degrees
   * @param bufferZone = color tint to add.
   * @param greyScale = if image needs to be gray scaled
   * @return Image.
   */
  public Image rotateImage(String toRotate, int totalRorations, int bufferZone, boolean greyScale){
    BufferedImage toRot = null;
    BufferedImage rotated = null;
    Image returnImage;

    try {
      toRot = (BufferedImage) ImageIO.read(new File(toRotate));
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (toRot != null || totalRorations == 0) {
      for (int r = 0; r < totalRorations; r++) {
        if (greyScale) {
          rotated = new BufferedImage(toRot.getHeight(), toRot.getWidth(),
              BufferedImage.TYPE_INT_RGB);
        } else {
          rotated = new BufferedImage(toRot.getHeight(), toRot.getWidth(),
              BufferedImage.TYPE_BYTE_GRAY);
        }

        for (int i = 0; i < toRot.getHeight(); i++) {
          for (int j = 0; j < toRot.getWidth(); j++) {
            if ((i < bufferZone) || (i > toRot.getHeight() - bufferZone)
                      || (j < bufferZone) || (j > toRot.getWidth() - bufferZone)) {
              rotated.setRGB(i,j,toRot.getRGB(i, j));
            } else {
              rotated.setRGB(i,j,toRot.getRGB((toRot.getWidth() - 1 - j),i));
            }

          }
        }
        toRot = rotated;
      }
    }

    if (rotated == null) {
      rotated = toRot;
    }
    returnImage = rotated;
    return returnImage;
  }


}
