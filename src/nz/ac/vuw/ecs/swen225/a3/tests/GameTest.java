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
		assertEquals(4, chap.getYPosition());
	}
	
	@Test public void test43() {
		Tile chap = new Chap(5,5,5,5);
		chap.updatePosition('S');		
		assertEquals(6, chap.getYPosition());
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
	
	@Test public void test82() {
		Tile chap = new Chap(5,5,5,5);		
		assertEquals(5, chap.getCurrentPositionOnScreen().getX());
	}
	
	@Test public void test83() {
		Tile chap = new Chap(5,5,5,5);		
		assertEquals(5, chap.getCurrentPositionOnScreen().getY());
	}
	
	@Test public void test84() {
		Tile chap = new Exit(5,5,5,5);		
		assertEquals(5, chap.getCurrentPositionOnScreen().getX());
	}
	
	@Test public void test85() {
		Tile tile = new Exit(5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getY());
	}
	
	@Test public void test86() {
		Tile tile = new ExitLock(5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getX());
	}
	
	@Test public void test87() {
		Tile tile = new ExitLock(5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getY());
	}
	
	@Test public void test88() {
		Tile tile = new Free(5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getX());
	}
	
	@Test public void test89() {
		Tile tile = new Free(5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getY());
	}
	
	@Test public void test90() {
		Tile tile = new InfoField(null,5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getX());
	}
	
	@Test public void test91() {
		Tile tile = new InfoField(null,5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getY());
	}
	
	@Test public void test92() {
		Tile tile = new Key(null,5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getX());
	}
	
	@Test public void test93() {
		Tile tile = new Key(null,5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getY());
	}
	
	@Test public void test94() {
		Tile tile = new LockedDoor(null,5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getX());
	}
	
	@Test public void test95() {
		Tile tile = new LockedDoor(null,5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getY());
	}
	
	@Test public void test96() {
		Tile tile = new Treasure(5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getX());
	}
	
	@Test public void test97() {
		Tile tile = new Treasure(5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getY());
	}
	
	@Test public void test98() {
		Tile tile = new Wall(5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getX());
	}
	
	@Test public void test99() {
		Tile tile = new Wall(5,5,5,5);		
		assertEquals(5, tile.getCurrentPositionOnScreen().getY());
	}
	
	@Test public void test100() {
		Tile tile = new Chap(5,5,5,5);		
		assertEquals(false, tile.isObjectSolid());
	}
	
	@Test public void test101() {
		Tile tile = new Chap(5,5,5,5);		
		assertEquals("C", tile.toString());
	}
	
	@Test public void test102() {
		Tile tile = new Chap(5,5,5,5);		
		assertEquals("resources/CC6.png", tile.getImagePath());
	}
	
	@Test public void test103() {
		Tile tile = new Exit(5,5,5,5);		
		assertEquals(true, tile.isObjectSolid());
	}
	
	@Test public void test104() {
		Tile tile = new Exit(5,5,5,5);		
		assertEquals("X", tile.toString());
	}
	
	@Test public void test105() {
		Tile tile = new Exit(5,5,5,5);		
		assertEquals("resources/CC10.png", tile.getImagePath());
	}
	
	@Test public void test106() {
		Tile tile = new ExitLock(5,5,5,5);		
		assertEquals(true, tile.isObjectSolid());
	}
	
	@Test public void test107() {
		Tile tile = new ExitLock(5,5,5,5);		
		assertEquals("L", tile.toString());
	}
	
	@Test public void test108() {
		Tile tile = new ExitLock(5,5,5,5);		
		assertEquals("resources/CC9.png", tile.getImagePath());
	}
	
	@Test public void test109() {
		Tile tile = new Free(5,5,5,5);		
		assertEquals(false, tile.isObjectSolid());
	}
	
	@Test public void test110() {
		Tile tile = new Free(5,5,5,5);		
		assertEquals("F", tile.toString());
	}
	
	@Test public void test111() {
		Tile tile = new Free(5,5,5,5);		
		assertEquals("resources/CC2.png", tile.getImagePath());
	}
	
	@Test public void test112() {
		Tile tile = new InfoField(null,5,5,5,5);		
		assertEquals(false, tile.isObjectSolid());
	}
	
	@Test public void test113() {
		Tile tile = new InfoField(null,5,5,5,5);		
		assertEquals("I", tile.toString());
	}
	
	@Test public void test114() {
		Tile tile = new InfoField(null,5,5,5,5);		
		assertEquals("resources/CC8.png", tile.getImagePath());
	}
	
	@Test public void test115() {
		Tile tile = new Key(null,5,5,5,5);		
		assertEquals(false, tile.isObjectSolid());
	}
	
	@Test public void test116() {
		Tile tile = new Key(null,5,5,5,5);		
		assertEquals("K", tile.toString());
	}
	
	@Test public void test117() {
		Tile tile = new Key(null,5,5,5,5);		
		assertEquals("resources/CC12.png", tile.getImagePath());
	}
	
	@Test public void test118() {
		Tile tile = new LockedDoor(null,5,5,5,5);		
		assertEquals(true, tile.isObjectSolid());
	}
	
	@Test public void test119() {
		Tile tile = new LockedDoor(null,5,5,5,5);		
		assertEquals("D", tile.toString());
	}
	
	@Test public void test120() {
		Tile tile = new LockedDoor(null,5,5,5,5);		
		assertEquals("resources/CC11.png", tile.getImagePath());
	}
	
	@Test public void test121() {
		Tile tile = new Treasure(5,5,5,5);		
		assertEquals(false, tile.isObjectSolid());
	}
	
	@Test public void test122() {
		Tile tile = new Treasure(5,5,5,5);		
		assertEquals("T", tile.toString());
	}
	
	@Test public void test123() {
		Tile tile = new Treasure(5,5,5,5);		
		assertEquals("resources/CC7.png", tile.getImagePath());
	}
	
	@Test public void test124() {
		Tile tile = new Wall(5,5,5,5);		
		assertEquals(true, tile.isObjectSolid());
	}
	
	@Test public void test125() {
		Tile tile = new Wall(5,5,5,5);		
		assertEquals("W", tile.toString());
	}
	
	@Test public void test126() {
		Tile tile = new Wall(5,5,5,5);		
		assertEquals("resources/CC1.png", tile.getImagePath());
	}
	
	@Test public void test127() {
		Tile tile = new Chap(5,5,5,5);
		tile.updatePosition('D');		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test128() {
		Tile tile = new Exit(5,5,5,5);
		tile.updatePosition('D');		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test129() {
		Tile tile = new ExitLock(5,5,5,5);
		tile.updatePosition('D');		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test130() {
		Tile tile = new Free(5,5,5,5);
		tile.updatePosition('D');		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test131() {
		Tile tile = new InfoField(null,5,5,5,5);
		tile.updatePosition('D');		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test132() {
		Tile tile = new Key(null,5,5,5,5);
		tile.updatePosition('D');		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test133() {
		Tile tile = new LockedDoor(null,5,5,5,5);
		tile.updatePosition('D');		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test134() {
		Tile tile = new Treasure(5,5,5,5);
		tile.updatePosition('D');		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test135() {
		Tile tile = new Wall(5,5,5,5);
		tile.updatePosition('D');		
		assertEquals(5, tile.getYPosition());
	}
	
	@Test public void test136() {
		Tile tile = new Chap(5,5,5,5);	
		assertEquals(true, tile.loadImage());
	}
	
	@Test public void test137() {
		Tile tile = new Exit(5,5,5,5);	
		assertEquals(true, tile.loadImage());
	}
	
	@Test public void test138() {
		Tile tile = new ExitLock(5,5,5,5);	
		assertEquals(true, tile.loadImage());
	}
	
	@Test public void test139() {
		Tile tile = new Free(5,5,5,5);	
		assertEquals(true, tile.loadImage());
	}
	
	@Test public void test140() {
		Tile tile = new InfoField(null,5,5,5,5);	
		assertEquals(true, tile.loadImage());
	}
	
	@Test public void test141() {
		Tile tile = new Key(null,5,5,5,5);	
		assertEquals(true, tile.loadImage());
	}
	
	@Test public void test142() {
		Tile tile = new LockedDoor(null,5,5,5,5);	
		assertEquals(true, tile.loadImage());
	}
	
	@Test public void test143() {
		Tile tile = new Treasure(5,5,5,5);	
		assertEquals(true, tile.loadImage());
	}
	
	@Test public void test144() {
		Tile tile = new Wall(5,5,5,5);	
		assertEquals(true, tile.loadImage());
	}
}
