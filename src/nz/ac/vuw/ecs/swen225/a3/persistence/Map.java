package nz.ac.vuw.ecs.swen225.a3.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.*;
import javax.json.JsonReader;
import javax.json.stream.JsonParser;
import javax.swing.SwingUtilities;


import nz.ac.vuw.ecs.swen225.a3.application.MainFrame;

public class Map {

	public Map() {
		
	}
	
	public void readFile() {
		try {
			InputStream input = new FileInputStream("levels.json");
			JsonReader reader = Json.createReader(input);
			JsonObject obj = reader.readObject();
			//System.out.println(obj);
			JsonArray level = obj.getJsonArray("level-1");
			System.out.println(level);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Map m = new Map();
		m.readFile();
	}
}
