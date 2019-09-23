package nz.ac.vuw.ecs.swen225.a3.application;

import javax.swing.SwingUtilities;

import nz.ac.vuw.ecs.swen225.a3.maze.Game;
import nz.ac.vuw.ecs.swen225.a3.maze.Maze;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4648.92f3aa193 modeling language!*/

// line 17 "model.ump"
// line 102 "model.ump"
public class Main {
	private static Game game = new Game(new Maze(17, 17, "level-1"));
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainFrame(game);
			}
		});
	}

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	public Main() {
	}

	// ------------------------
	// INTERFACE
	// ------------------------

	public void delete() {
	}
}