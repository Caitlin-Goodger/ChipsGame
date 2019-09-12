package nz.ac.vuw.ecs.swen225.a3.application;

import javax.swing.SwingUtilities;

import nz.ac.vuw.ecs.swen225.a3.persistence.Map;

/**
 * Runs the game.
 */
public class Main {

    /**
     * Creates new game.
     * 
     * @param args
     */
    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {

	    @Override
	    public void run() {
		new Game();
	    }
	});
    }
}
