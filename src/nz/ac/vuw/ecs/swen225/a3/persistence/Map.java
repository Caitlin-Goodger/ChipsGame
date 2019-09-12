package nz.ac.vuw.ecs.swen225.a3.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Map {

	public void read() {
		String line;
		BufferedReader input;
		
		try {
			input = new BufferedReader(new FileReader(new File(Map.class.getResource("level1.txt").getFile())));
			
			for(line = input.readLine(); line != null; line = input.readLine()) {
				String[] tokens = line.split(" ");
				
				for(String token :tokens) {
					System.out.print(token + " ");
				}

				System.out.println();
			}
			
			input.close();
		} catch (IOException e) {
			throw new Error(e);
		}
	}
}
