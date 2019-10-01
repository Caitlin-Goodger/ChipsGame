package nz.ac.vuw.ecs.swen225.a3.application;

import javax.swing.SwingUtilities;

import nz.ac.vuw.ecs.swen225.a3.maze.Game;
import nz.ac.vuw.ecs.swen225.a3.maze.Maze;


/**
 * Main class of the game. Where the game is run from. 
 * @author Caitlin
 */
public class Main {
	private static Game game = new Game(new Maze(32, 32, "level-1"));
	
	/**
	 * Main method. Where game is run from. 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainFrame(game);
			}
		});
	}

}