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
	
}
