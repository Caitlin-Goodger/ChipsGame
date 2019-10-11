package nz.ac.vuw.ecs.swen225.a3.application;

import java.io.File;

import javax.swing.SwingUtilities;

import nz.ac.vuw.ecs.swen225.a3.gui.MainFrame;
import nz.ac.vuw.ecs.swen225.a3.maze.Game;
import nz.ac.vuw.ecs.swen225.a3.maze.Maze;
import nz.ac.vuw.ecs.swen225.a3.persistence.FileReader;

/**
 * Main class of the game. Where the game is run from.
 */
public class Main {
  private static FileReader fileReader;
  private static Maze maze;

  private static MainFrame mainFrame;
  private static Game game;

  private static TimeLimit timeLimit;

  /**
   * Main method. Where game is run from.
   * 
   * @param args = takes arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      @Override 
      public void run() {
        File f = new File("resources/recordFiles/");
        for (File f1 : f.listFiles()) {
          f1.delete();
        }
        fileReader = new FileReader("level-1");
        fileReader.read("levels.json");

        // Create a new maze passing in the parameters generated
        // from the file reader.
        maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
            fileReader.getTimeLimit(), fileReader.getMazeLayout());

        fileReader.loadInventory(maze, "levels.json");
        
        game = new Game(maze);

        mainFrame = new MainFrame(game);
        timeLimit = new TimeLimit(fileReader.getTimeLimit(), mainFrame);

        game.setTimeLimit(timeLimit);
      }
    });
  }

}