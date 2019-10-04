package nz.ac.vuw.ecs.swen225.a3.render;

import java.awt.Color;
import java.awt.Image;
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
   * Merge two images together with a colour tint.
   * 
   * @param toAddOnTop = image to put on the top.
   * @param addToWall  = boolean. True is a wall and false is free.
   * @param tintColor  = colour tint to add.
   * @return Image.
   */
  public Image mergeImages(String toAddOnTop, int addToWall, Color tintColor) {
    // creates the image
    Image returnImage;
    Color col;
    Color holdColor;
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

    returnImage = toAdd;

    return returnImage;
  }

}
