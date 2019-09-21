package nz.ac.vuw.ecs.swen225.a3.render;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Renderer {
    String wallPath = "src\\nz\\ac\\vuw\\ecs\\swen225\\a3\\IMG\\CC1.png";
    String floorPath = "src\\nz\\ac\\vuw\\ecs\\swen225\\a3\\IMG\\CC2.png";

    BufferedImage wall, floor;

    public Renderer() {
        // render the floor
        try { wall = (BufferedImage) ImageIO.read(new File(new File(wallPath).getAbsolutePath())); }
        catch (IOException e) { e.printStackTrace(); }

        // render the wall
        try { floor = (BufferedImage) ImageIO.read(new File(new File(floorPath).getAbsolutePath())); }
        catch (IOException e) { e.printStackTrace(); }

    }

    //addToWall is used to either add to the wall texture or to add the floor texture
    //true is wall
    //false is floor
    public Image mergeImages(String toAddOnTop, boolean addToWall) {
        // creates the image
        BufferedImage toAdd = null;
        try { toAdd = (BufferedImage) ImageIO.read(new File(new File(toAddOnTop).getAbsolutePath())); }
        catch (IOException e) { e.printStackTrace(); }

        //combine the images
        for (int i = 0; i < toAdd.getWidth(); i++){
            for (int u = 0; u < toAdd.getHeight(); u++){
                if (toAdd.getRGB(i,u) == 0 && addToWall)toAdd.setRGB(i,u,floor.getRGB(i,u));
                else if (toAdd.getRGB(i,u) == 0 && addToWall == false)toAdd.setRGB(i,u,wall.getRGB(i,u));
            }
        }

        Image returnImage  = toAdd;

        return returnImage;

    }

}
