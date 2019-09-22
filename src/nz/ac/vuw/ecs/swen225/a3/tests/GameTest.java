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


public class GameTest {
	
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
	//Moving the chap tile on map
	@Test public void test42() {
		Tile chap = new Chap(5,5,5,5);
		chap.updatePosition('N');		
		assertEquals(6, chap.getYPosition());
	}
	
	@Test public void test43() {
		Tile chap = new Chap(5,5,5,5);
		chap.updatePosition('S');		
		assertEquals(4, chap.getYPosition());
	}
	
	@Test public void test44() {
		Tile chap = new Chap(5,5,5,5);
		chap.updatePosition('E');		
		assertEquals(6, chap.getXPosition());
	}
	
	@Test public void test45() {
		Tile chap = new Chap(5,5,5,5);
		chap.updatePosition('W');		
		assertEquals(4, chap.getXPosition());
	}
	
	@Test public void test46() {
		Tile chap = new Chap(5,5,5,5);		
		assertEquals(5, chap.getTilePosition().getX());
	}
	
	@Test public void test47() {
		Tile chap = new Chap(5,5,5,5);		
		assertEquals(5, chap.getTilePosition().getY());
	}
	
	@Test public void test48() {
		Tile chap = new Exit(5,5,5,5);		
		assertEquals(5, chap.getTilePosition().getX());
	}
	
	@Test public void test49() {
		Tile tile = new Exit(5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getY());
	}
	
	@Test public void test50() {
		Tile tile = new ExitLock(5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getX());
	}
	
	@Test public void test51() {
		Tile tile = new ExitLock(5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getY());
	}
	
	@Test public void test52() {
		Tile tile = new Free(5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getX());
	}
	
	@Test public void test53() {
		Tile tile = new Free(5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getY());
	}
	
	@Test public void test54() {
		Tile tile = new InfoField(null,5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getX());
	}
	
	@Test public void test55() {
		Tile tile = new InfoField(null,5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getY());
	}
	
	@Test public void test56() {
		Tile tile = new Key(null,5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getX());
	}
	
	@Test public void test57() {
		Tile tile = new Key(null,5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getY());
	}
	
	@Test public void test58() {
		Tile tile = new LockedDoor(null,5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getX());
	}
	
	@Test public void test59() {
		Tile tile = new LockedDoor(null,5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getY());
	}
	
	@Test public void test60() {
		Tile tile = new Treasure(5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getX());
	}
	
	@Test public void test61() {
		Tile tile = new Treasure(5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getY());
	}
	
	@Test public void test62() {
		Tile tile = new Wall(5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getX());
	}
	
	@Test public void test63() {
		Tile tile = new Wall(5,5,5,5);		
		assertEquals(5, tile.getTilePosition().getY());
	}
	
	@Test public void test64() {
		Tile chap = new Chap(5,5,5,5);		
		assertEquals(5, chap.getXPosition());
	}
	
	@Test public void test65() {
		Tile chap = new Chap(5,5,5,5);		
		assertEquals(5, chap.getYPosition());
	}
	
	@Test public void test66() {
		Tile tile = new Exit(5,5,5,5);		
		assertEquals(5, tile.getXPosition());
	}
	
	@Test public void test67() {
		Tile tile = new Exit(5,5,5,5);		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test68() {
		Tile tile = new ExitLock(5,5,5,5);		
		assertEquals(5, tile.getXPosition());
	}
	
	@Test public void test69() {
		Tile tile = new ExitLock(5,5,5,5);		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test70() {
		Tile tile = new Free(5,5,5,5);		
		assertEquals(5, tile.getXPosition());
	}
	
	@Test public void test71() {
		Tile tile = new Free(5,5,5,5);		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test72() {
		Tile tile = new InfoField(null,5,5,5,5);		
		assertEquals(5, tile.getXPosition());
	}
	
	@Test public void test73() {
		Tile tile = new InfoField(null,5,5,5,5);		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test74() {
		Tile tile = new Key(null,5,5,5,5);		
		assertEquals(5, tile.getXPosition());
	}
	
	@Test public void test75() {
		Tile tile = new Key(null,5,5,5,5);		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test76() {
		Tile tile = new LockedDoor(null,5,5,5,5);		
		assertEquals(5, tile.getXPosition());
	}
	
	@Test public void test77() {
		Tile tile = new LockedDoor(null,5,5,5,5);		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test78() {
		Tile tile = new Treasure(5,5,5,5);		
		assertEquals(5, tile.getXPosition());
	}
	
	@Test public void test79() {
		Tile tile = new Treasure(5,5,5,5);		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test80() {
		Tile tile = new Wall(5,5,5,5);		
		assertEquals(5, tile.getXPosition());
	}
	
	@Test public void test81() {
		Tile tile = new Wall(5,5,5,5);		
		assertEquals(5, tile.getYPosition());
	}
	
}
