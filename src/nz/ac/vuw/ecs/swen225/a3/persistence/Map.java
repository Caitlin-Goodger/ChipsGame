package nz.ac.vuw.ecs.swen225.a3.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Holds information for the map.
 */
public class Map {
    String path;

    // Debug : test map layout
    String[][] map = new String[][] { 
	{ "x", "o", "o", "x" }, 
	{ "o", "x", "x", "o" } 
    };

    /**
     * Constructor
     * 
     * @param path
     */
    public Map(String path) {
	this.path = path;
    }

    /**
     * Reads a text file and converts/stores in a 2D array.
     */
    public void read() {
	String line;
	BufferedReader input;

	try {
	    input = new BufferedReader(new FileReader(new File(Map.class.getResource(path + ".txt").getFile())));

	    for (line = input.readLine(); line != null; line = input.readLine()) {
		String[] tokens = line.split(" ");

		// Debug : prints the tokens
//		for (String token : tokens) {
//		    System.out.print(token + " ");
//		}
//		
//		System.out.println();
	    }

	    input.close();
	} catch (IOException e) {
	    throw new Error(e);
	}
    }

    /**
     * Returns the map array.
     * 
     * @return map
     */
    public String[][] getMap() {
	return this.map;
    }
}
