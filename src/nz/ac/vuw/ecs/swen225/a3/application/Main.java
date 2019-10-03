package nz.ac.vuw.ecs.swen225.a3.application;

import javax.swing.SwingUtilities;

import nz.ac.vuw.ecs.swen225.a3.gui.MainFrame;
import nz.ac.vuw.ecs.swen225.a3.maze.Game;
import nz.ac.vuw.ecs.swen225.a3.persistence.Maze;
import nz.ac.vuw.ecs.swen225.a3.util.TimeLimit;

/**
 * Main class of the game. Where the game is run from.
 * 
 * @author Caitlin
 */
public class Main {
	private static MainFrame mf;
	private static Game game;
	private static TimeLimit tl;

	/**
	 * Main method. Where game is run from.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				game = new Game(new Maze(32, 32, "level-1"));
				mf = new MainFrame(game);
				tl = new TimeLimit(60, mf);
				
				game.setTimeLimit(tl);
			}
		});
	}

}