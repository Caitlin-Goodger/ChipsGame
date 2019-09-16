
package nz.ac.vuw.ecs.swen225.a3.render;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import nz.ac.vuw.ecs.swen225.a3.*;
import nz.ac.vuw.ecs.swen225.a3.persistence.Map;

/**
 * Displays the map onto frame.
 */
public class Renderer {
    private MapPanel mp;
    private Map map;
    
    /**
     * Constructor.
     * 
     * @param mp 
     * @param map 
     */
    public Renderer(MapPanel mp, Map map) {
	this.mp = mp;
	this.map = map;
    }
    
    /**
     * Displays the game.
     */
    public void draw() {
	String[][] mapLayout = map.getMap();
	
	int width = mapLayout[0].length;
	int height = mapLayout.length;
	
	for(int x = 0; x < width; x++) {
	    for(int y = 0; y< height; y++) {
		JPanel square = new JPanel();
		square.setPreferredSize(new Dimension(20, 20));
		square.setBackground(Color.BLACK);
		square.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		mp.getDisplayPanel().add(square);
	    }
	}
    }
}
