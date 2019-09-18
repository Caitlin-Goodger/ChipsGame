package nz.ac.vuw.ecs.swen225.a3.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import nz.ac.vuw.ecs.swen225.a3.maze.Chap;
import nz.ac.vuw.ecs.swen225.a3.maze.Exit;
import nz.ac.vuw.ecs.swen225.a3.maze.ExitLock;
import nz.ac.vuw.ecs.swen225.a3.maze.Free;
import nz.ac.vuw.ecs.swen225.a3.maze.InfoField;
import nz.ac.vuw.ecs.swen225.a3.maze.Key;
import nz.ac.vuw.ecs.swen225.a3.maze.LockedDoor;
import nz.ac.vuw.ecs.swen225.a3.maze.Tile;
import nz.ac.vuw.ecs.swen225.a3.maze.Treasure;
import nz.ac.vuw.ecs.swen225.a3.maze.Wall;
import nz.ac.vuw.ecs.swen225.a3.maze.XYPos;
import org.junit.Test;
//import swen225.*;


public class CluedoTest {
	
	@Test public void test01() {
		assertEquals(1,1);
	}

	// testing xy position. Adding to it
	@Test public void test02() {
		XYPos pos = new XYPos(5,5);
		pos.updatePos(2,0);
		assertEquals(7,pos.getX());
	}

	@Test public void test03() {
		XYPos pos = new XYPos(5,5);
		pos.updatePos(0,3);
		assertEquals(8,pos.getY());
	}
	// testing xy position minusing from it
	@Test public void test04() {
		XYPos pos = new XYPos(5,5);
		pos.updatePos(-2,0);
		assertEquals(3,pos.getX());
	}

	@Test public void test05() {
		XYPos pos = new XYPos(5,5);
		pos.updatePos(0,-3);
		assertEquals(2,pos.getY());
	}
	//Testing updating tile position on screen
	//Wall
	@Test public void test06() {
		Tile wall = new Wall(5,5,5,5);
		wall.updatePosition('N');		
		assertEquals(6, wall.getYPositionOnScreen());
	}
	
	@Test public void test07() {
		Tile wall = new Wall(5,5,5,5);
		wall.updatePosition('S');		
		assertEquals(4, wall.getYPositionOnScreen());
	}
	
	@Test public void test08() {
		Tile wall = new Wall(5,5,5,5);
		wall.updatePosition('E');		
		assertEquals(6, wall.getXPositionOnScreen());
	}
	
	@Test public void test09() {
		Tile wall = new Wall(5,5,5,5);
		wall.updatePosition('W');		
		assertEquals(4, wall.getXPositionOnScreen());
	}
	//Exit
	@Test public void test10() {
		Tile exit = new Exit(5,5,5,5);
		exit.updatePosition('N');		
		assertEquals(6, exit.getYPositionOnScreen());
	}
	
	@Test public void test11() {
		Tile exit = new Exit(5,5,5,5);
		exit.updatePosition('S');		
		assertEquals(4, exit.getYPositionOnScreen());
	}
	
	@Test public void test12() {
		Tile exit = new Exit(5,5,5,5);
		exit.updatePosition('E');		
		assertEquals(6, exit.getXPositionOnScreen());
	}
	
	@Test public void test13() {
		Tile exit = new Exit(5,5,5,5);
		exit.updatePosition('W');		
		assertEquals(4, exit.getXPositionOnScreen());
	}
	//ExitLock
	@Test public void test14() {
		Tile exitLock = new ExitLock(5,5,5,5);
		exitLock.updatePosition('N');		
		assertEquals(6, exitLock.getYPositionOnScreen());
	}
	
	@Test public void test15() {
		Tile exitLock = new ExitLock(5,5,5,5);
		exitLock.updatePosition('S');		
		assertEquals(4, exitLock.getYPositionOnScreen());
	}
	
	@Test public void test16() {
		Tile exitLock = new ExitLock(5,5,5,5);
		exitLock.updatePosition('E');		
		assertEquals(6, exitLock.getXPositionOnScreen());
	}
	
	@Test public void test17() {
		Tile exitLock = new ExitLock(5,5,5,5);
		exitLock.updatePosition('W');		
		assertEquals(4, exitLock.getXPositionOnScreen());
	}
	//Free
	@Test public void test18() {
		Tile free = new Free(5,5,5,5);
		free.updatePosition('N');		
		assertEquals(6, free.getYPositionOnScreen());
	}
	
	@Test public void test19() {
		Tile free = new Free(5,5,5,5);
		free.updatePosition('S');		
		assertEquals(4, free.getYPositionOnScreen());
	}
	
	@Test public void test20() {
		Tile free = new Free(5,5,5,5);
		free.updatePosition('E');		
		assertEquals(6, free.getXPositionOnScreen());
	}
	
	@Test public void test21() {
		Tile free = new Free(5,5,5,5);
		free.updatePosition('W');		
		assertEquals(4, free.getXPositionOnScreen());
	}
	//InfoField
	@Test public void test22() {
		Tile infoField = new InfoField("Hey",5,5,5,5);
		infoField.updatePosition('N');		
		assertEquals(6, infoField.getYPositionOnScreen());
	}
	
	@Test public void test23() {
		Tile infoField = new InfoField("Hey",5,5,5,5);
		infoField.updatePosition('S');		
		assertEquals(4, infoField.getYPositionOnScreen());
	}
	
	@Test public void test24() {
		Tile infoField = new InfoField("Hey",5,5,5,5);
		infoField.updatePosition('E');		
		assertEquals(6, infoField.getXPositionOnScreen());
	}
	
	@Test public void test25() {
		Tile infoField = new InfoField("Hey",5,5,5,5);
		infoField.updatePosition('W');		
		assertEquals(4, infoField.getXPositionOnScreen());
	}
	//Key
	@Test public void test26() {
		Tile key = new Key("Hey",5,5,5,5);
		key.updatePosition('N');		
		assertEquals(6, key.getYPositionOnScreen());
	}
	
	@Test public void test27() {
		Tile key = new Key("Hey",5,5,5,5);
		key.updatePosition('S');		
		assertEquals(4, key.getYPositionOnScreen());
	}
	
	@Test public void test28() {
		Tile key = new Key("Hey",5,5,5,5);
		key.updatePosition('E');		
		assertEquals(6, key.getXPositionOnScreen());
	}
	
	@Test public void test29() {
		Tile key = new Key("Hey",5,5,5,5);
		key.updatePosition('W');		
		assertEquals(4, key.getXPositionOnScreen());
	}
	//LockedDoor
	@Test public void test30() {
		Tile lockedDoor = new LockedDoor("Hey",5,5,5,5);
		lockedDoor.updatePosition('N');		
		assertEquals(6, lockedDoor.getYPositionOnScreen());
	}
	
	@Test public void test31() {
		Tile lockedDoor = new LockedDoor("Hey",5,5,5,5);
		lockedDoor.updatePosition('S');		
		assertEquals(4, lockedDoor.getYPositionOnScreen());
	}
	
	@Test public void test32() {
		Tile lockedDoor = new LockedDoor("Hey",5,5,5,5);
		lockedDoor.updatePosition('E');		
		assertEquals(6, lockedDoor.getXPositionOnScreen());
	}
	
	@Test public void test33() {
		Tile lockedDoor = new LockedDoor("Hey",5,5,5,5);
		lockedDoor.updatePosition('W');		
		assertEquals(4, lockedDoor.getXPositionOnScreen());
	}
	//Treasure
	@Test public void test34() {
		Tile treasure = new Treasure(5,5,5,5);
		treasure.updatePosition('N');		
		assertEquals(6, treasure.getYPositionOnScreen());
	}
	
	@Test public void test35() {
		Tile treasure = new Treasure(5,5,5,5);
		treasure.updatePosition('S');		
		assertEquals(4, treasure.getYPositionOnScreen());
	}
	
	@Test public void test36() {
		Tile treasure = new Treasure(5,5,5,5);
		treasure.updatePosition('E');		
		assertEquals(6, treasure.getXPositionOnScreen());
	}
	
	@Test public void test37() {
		Tile treasure = new Treasure(5,5,5,5);
		treasure.updatePosition('W');		
		assertEquals(4, treasure.getXPositionOnScreen());
	}
	//Wall
	@Test public void test38() {
		Tile wall = new Wall(5,5,5,5);
		wall.updatePosition('N');		
		assertEquals(6, wall.getYPositionOnScreen());
	}
	
	@Test public void test39() {
		Tile wall = new Wall(5,5,5,5);
		wall.updatePosition('S');		
		assertEquals(4, wall.getYPositionOnScreen());
	}
	
	@Test public void test40() {
		Tile wall = new Wall(5,5,5,5);
		wall.updatePosition('E');		
		assertEquals(6, wall.getXPositionOnScreen());
	}
	
	@Test public void test41() {
		Tile wall = new Wall(5,5,5,5);
		wall.updatePosition('W');		
		assertEquals(4, wall.getXPositionOnScreen());
	}
}
