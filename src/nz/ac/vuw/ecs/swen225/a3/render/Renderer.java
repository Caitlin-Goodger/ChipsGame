package nz.ac.vuw.ecs.swen225.a3.render;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Renderer {
    String wallPath = "resources/CC1.png";
    String floorPath = "resources/CC2.png";

    BufferedImage wall, floor;

    public Renderer() {
        // render the floor
        try { wall = (BufferedImage) ImageIO.read(new File(getClass().getClassLoader().getResource(wallPath).getFile())); }
        catch (IOException e) { e.printStackTrace(); }

        // render the wall
        try { floor = (BufferedImage) ImageIO.read(new File(getClass().getClassLoader().getResource(floorPath).getFile())); }
        catch (IOException e) { e.printStackTrace(); }

    }

    // used just for the basic key
    //addToWall is used to either add to the wall texture or to add the floor texture
    //true is wall
    //false is floor
    public Image mergeImages(String toAddOnTop, boolean addToWall) {
        // creates the image
        Image returnImage;
        BufferedImage toAdd = null;
        try { toAdd = (BufferedImage) ImageIO.read(new File(getClass().getClassLoader().getResource(toAddOnTop).getFile())); }
        catch (IOException e) { e.printStackTrace(); }

        //combine the images
        for (int i = 0; i < toAdd.getWidth(); i++){
            for (int u = 0; u < toAdd.getHeight(); u++){
                if (toAdd.getRGB(i,u) == 0 && addToWall)toAdd.setRGB(i,u,floor.getRGB(i,u));
                else if (toAdd.getRGB(i,u) == 0 && addToWall == false)toAdd.setRGB(i,u,wall.getRGB(i,u));
            }
        }

       returnImage  = toAdd;

        return returnImage;

    }

    // used if a key is needed to be colored
    public Image mergeImages(String toAddOnTop, boolean addToWall, Color tintColor) {
        // creates the image
        Image returnImage;
        Color col, holdColor;
        BufferedImage toAdd = null;


        try { toAdd = (BufferedImage) ImageIO.read(new File(getClass().getClassLoader().getResource(toAddOnTop).getFile())); }
        catch (IOException e) { e.printStackTrace(); }

        //combine the images
        for (int i = 0; i < toAdd.getWidth(); i++){
            for (int u = 0; u < toAdd.getHeight(); u++){
                if (toAdd.getRGB(i,u) == 0 && addToWall)toAdd.setRGB(i,u,floor.getRGB(i,u));
                else if (toAdd.getRGB(i,u) == 0 && addToWall == false)toAdd.setRGB(i,u,wall.getRGB(i,u));
                else if (toAdd.getRGB(i,u) == Color.black.getRGB()) toAdd.setRGB(i,u,Color.black.getRGB());
                else {
                    holdColor = new Color(toAdd.getRGB(i,u), true);

                    col = new Color(((holdColor.getRed() + tintColor.getRed()) / 2)
                            ,((holdColor.getGreen() + tintColor.getGreen()) / 2),
                            ((holdColor.getBlue() + tintColor.getBlue()) / 2));

                    toAdd.setRGB(i,u,col.getRGB());
                }
            }
        }

        returnImage  = toAdd;

        return returnImage;
    }



}
