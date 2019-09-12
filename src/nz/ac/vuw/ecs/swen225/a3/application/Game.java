package nz.ac.vuw.ecs.swen225.a3.application;

import nz.ac.vuw.ecs.swen225.a3.application.gui.MainFrame;
import nz.ac.vuw.ecs.swen225.a3.persistence.Map;
import nz.ac.vuw.ecs.swen225.a3.render.Renderer;

/**
 * The game.
 */
public class Game {
    private MainFrame mf;
    private Map currentMap;
    private Renderer r;
    
    /**
     * Constructor.
     */
    public Game() {
	mf = new MainFrame();
	currentMap = new Map("level1");
	r = new Renderer(mf.getMapPanel(), currentMap);
	
	run();
    }
    
    /**
     * Runs the game.
     */
    public void run() {
	currentMap.read();
	r.draw();
    }
}
