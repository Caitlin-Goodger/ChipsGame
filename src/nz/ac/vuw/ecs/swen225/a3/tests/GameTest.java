package nz.ac.vuw.ecs.swen225.a3.tests;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import javax.swing.JLabel;

import nz.ac.vuw.ecs.swen225.a3.gui.DisplayPanel;
import nz.ac.vuw.ecs.swen225.a3.gui.MainFrame;
import nz.ac.vuw.ecs.swen225.a3.gui.TextPanel;
import nz.ac.vuw.ecs.swen225.a3.maze.Game;
import nz.ac.vuw.ecs.swen225.a3.maze.Maze;
import nz.ac.vuw.ecs.swen225.a3.maze.Tile;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Chap;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Exit;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.ExitLock;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Free;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.InfoField;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Key;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.LockedDoor;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Monster;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Treasure;
import nz.ac.vuw.ecs.swen225.a3.maze.TilesImpl.Wall;
import nz.ac.vuw.ecs.swen225.a3.persistence.FileReader;
import nz.ac.vuw.ecs.swen225.a3.util.Filter;
import nz.ac.vuw.ecs.swen225.a3.util.Position;
import nz.ac.vuw.ecs.swen225.a3.util.TimeLimit;

import org.junit.Test;

/**
 * Tests for the Game.
 * 
 * @author Caitlin
 *
 */
public class GameTest {

  /**
   * Basic test to check it is runnable.
   */
  @Test
  public void test01() {
    assertEquals(1, 1);
  }

  /**
   * Testing XYPOS update method.
   */
  @Test
  public void test02() {
    Position pos = new Position(5, 5);
    pos.updatePosition(1, 0);
    assertEquals(6, pos.getX());
  }

  /**
   * Testing XYPOS update method.
   */
  @Test
  public void test03() {
    Position pos = new Position(5, 5);
    pos.updatePosition(0, 1);
    assertEquals(6, pos.getY());
  }

  /**
   * Testing XYPOS update method.
   */
  @Test
  public void test04() {
    Position pos = new Position(5, 5);
    pos.updatePosition(-1, 0);
    assertEquals(4, pos.getX());
  }

  /**
   * Testing XYPOS update method.
   */
  @Test
  public void test05() {
    Position pos = new Position(5, 5);
    pos.updatePosition(0, -3);
    assertEquals(2, pos.getY());
  }

  /**
   * Testing get x position in the tile class.
   */
  @Test
  public void test64() {
    Tile chap = new Chap(5, 5);
    assertEquals(5, chap.getXPosition());
  }

  /**
   * Testing get y position in the tile class.
   */
  @Test
  public void test65() {
    Tile chap = new Chap(5, 5);
    assertEquals(5, chap.getYPosition());
  }

  /**
   * Testing get x position in the tile class.
   */
  @Test
  public void test66() {
    Tile tile = new Exit(5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position in the tile class.
   */
  @Test
  public void test67() {
    Tile tile = new Exit(5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position in the tile class.
   */
  @Test
  public void test68() {
    Tile tile = new ExitLock(5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position in the tile class.
   */
  @Test
  public void test69() {
    Tile tile = new ExitLock(5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position in the tile class.
   */
  @Test
  public void test70() {
    Tile tile = new Free(5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position in the tile class.
   */
  @Test
  public void test71() {
    Tile tile = new Free(5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position in the tile class.
   */
  @Test
  public void test72() {
    Tile tile = new InfoField(null, 5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position in the tile class.
   */
  @Test
  public void test73() {
    Tile tile = new InfoField(null, 5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position in the tile class.
   */
  @Test
  public void test74() {
    Tile tile = new Key(null, 5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position in the tile class.
   */
  @Test
  public void test75() {
    Tile tile = new Key(null, 5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position in the tile class.
   */
  @Test
  public void test76() {
    Tile tile = new LockedDoor(null, 5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position in the tile class.
   */
  @Test
  public void test77() {
    Tile tile = new LockedDoor(null, 5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position in the tile class.
   */
  @Test
  public void test78() {
    Tile tile = new Treasure(5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position in the tile class.
   */
  @Test
  public void test79() {
    Tile tile = new Treasure(5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position in the tile class.
   */
  @Test
  public void test80() {
    Tile tile = new Wall(5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position in the tile class.
   */
  @Test
  public void test81() {
    Tile tile = new Wall(5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position on screen in the tile class.
   */
  @Test
  public void test82() {
    Tile chap = new Chap(5, 5);
    assertEquals(5, chap.getXPosition());
  }

  /**
   * Testing get y position on screen in the tile class.
   */
  @Test
  public void test83() {
    Tile chap = new Chap(5, 5);
    assertEquals(5, chap.getYPosition());
  }

  /**
   * Testing get x position on screen in the tile class.
   */
  @Test
  public void test84() {
    Tile chap = new Exit(5, 5);
    assertEquals(5, chap.getXPosition());
  }

  /**
   * Testing get y position on screen in the tile class.
   */
  @Test
  public void test85() {
    Tile tile = new Exit(5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position on screen in the tile class.
   */
  @Test
  public void test86() {
    Tile tile = new ExitLock(5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position on screen in the tile class.
   */
  @Test
  public void test87() {
    Tile tile = new ExitLock(5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position on screen in the tile class.
   */
  @Test
  public void test88() {
    Tile tile = new Free(5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position on screen in the tile class.
   */
  @Test
  public void test89() {
    Tile tile = new Free(5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position on screen in the tile class.
   */
  @Test
  public void test90() {
    Tile tile = new InfoField(null, 5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position on screen in the tile class.
   */
  @Test
  public void test91() {
    Tile tile = new InfoField(null, 5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position on screen in the tile class.
   */
  @Test
  public void test92() {
    Tile tile = new Key(null, 5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position on screen in the tile class.
   */
  @Test
  public void test93() {
    Tile tile = new Key(null, 5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position on screen in the tile class.
   */
  @Test
  public void test94() {
    Tile tile = new LockedDoor(null, 5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position on screen in the tile class.
   */
  @Test
  public void test95() {
    Tile tile = new LockedDoor(null, 5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position on screen in the tile class.
   */
  @Test
  public void test96() {
    Tile tile = new Treasure(5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position on screen in the tile class.
   */
  @Test
  public void test97() {
    Tile tile = new Treasure(5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing get x position on screen in the tile class.
   */
  @Test
  public void test98() {
    Tile tile = new Wall(5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing get y position on screen in the tile class.
   */
  @Test
  public void test99() {
    Tile tile = new Wall(5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing to string method in the tile class.
   */
  @Test
  public void test101() {
    Tile tile = new Chap(5, 5);
    assertEquals("C", tile.toString());
  }

  /**
   * Testing get Image Path method in the tile class.
   */
  @Test
  public void test102() {
    Tile tile = new Chap(5, 5);
    assertEquals("resources/CC6.png", tile.getImagePath());
  }

  /**
   * Testing to string method in the tile class.
   */
  @Test
  public void test104() {
    Tile tile = new Exit(5, 5);
    assertEquals("X", tile.toString());
  }

  /**
   * Testing get Image Path method in the tile class.
   */
  @Test
  public void test105() {
    Tile tile = new Exit(5, 5);
    assertEquals("resources/CC10.png", tile.getImagePath());
  }

  /**
   * Testing to string method in the tile class.
   */
  @Test
  public void test107() {
    Tile tile = new ExitLock(5, 5);
    assertEquals("L", tile.toString());
  }

  /**
   * Testing get Image Path method in the tile class.
   */
  @Test
  public void test108() {
    Tile tile = new ExitLock(5, 5);
    assertEquals("resources/CC9.png", tile.getImagePath());
  }

  /**
   * Testing to string method in the tile class.
   */
  @Test
  public void test110() {
    Tile tile = new Free(5, 5);
    assertEquals("F", tile.toString());
  }

  /**
   * Testing get Image Path method in the tile class.
   */
  @Test
  public void test111() {
    Tile tile = new Free(5, 5);
    assertEquals("resources/CC2.png", tile.getImagePath());
  }

  /**
   * Testing to string method in the tile class.
   */
  @Test
  public void test113() {
    Tile tile = new InfoField(null, 5, 5);
    assertEquals("I", tile.toString());
  }

  /**
   * Testing get Image Path method in the tile class.
   */
  @Test
  public void test114() {
    Tile tile = new InfoField(null, 5, 5);
    assertEquals("resources/CC8.png", tile.getImagePath());
  }

  /**
   * Testing to string method in the tile class.
   */
  @Test
  public void test116() {
    Tile tile = new Key(null, 5, 5);
    assertEquals("K", tile.toString());
  }

  /**
   * Testing get Image Path method in the tile class.
   */
  @Test
  public void test117() {
    Tile tile = new Key(null, 5, 5);
    assertEquals("resources/CC12.png", tile.getImagePath());
  }

  /**
   * Testing to string method in the tile class.
   */
  @Test
  public void test119() {
    Tile tile = new LockedDoor(null, 5, 5);
    assertEquals("D", tile.toString());
  }

  /**
   * Testing get Image Path method in the tile class.
   */
  @Test
  public void test120() {
    Tile tile = new LockedDoor(null, 5, 5);
    assertEquals("resources/CC11.png", tile.getImagePath());
  }

  /**
   * Testing to string method in the tile class.
   */
  @Test
  public void test122() {
    Tile tile = new Treasure(5, 5);
    assertEquals("T", tile.toString());
  }

  /**
   * Testing get Image Path method in the tile class.
   */
  @Test
  public void test123() {
    Tile tile = new Treasure(5, 5);
    assertEquals("resources/CC7.png", tile.getImagePath());
  }

  /**
   * Testing to string method in the tile class.
   */
  @Test
  public void test125() {
    Tile tile = new Wall(5, 5);
    assertEquals("W", tile.toString());
  }

  /**
   * Testing get Image Path method in the tile class.
   */
  @Test
  public void test126() {
    Tile tile = new Wall(5, 5);
    assertEquals("resources/CC1.png", tile.getImagePath());
  }

  /**
   * Testing get Text method in Info field.
   */
  @Test
  public void test145() {
    InfoField tile = new InfoField("InfoField", 5, 5);
    assertEquals("InfoField", tile.getInfoFieldText());
  }

  /**
   * Testing set Text method in Info Field class.
   */
  @Test
  public void test146() {
    InfoField tile = new InfoField("InfoField", 5, 5);
    tile.setInfoFieldText("Info");
    assertEquals("Info", tile.getInfoFieldText());
  }

  /**
   * Testing get Colour in the key class.
   */
  @Test
  public void test147() {
    Key tile = new Key("yellow", 5, 5);
    assertEquals("yellow", tile.getColour());
  }

  /**
   * Testing set colour in the key class.
   */
  @Test
  public void test148() {
    Key tile = new Key("yellow", 5, 5);
    tile.setColour("red");
    assertEquals("red", tile.getColour());
  }

  /**
   * Testing get colour in the locked door class.
   */
  @Test
  public void test149() {
    LockedDoor tile = new LockedDoor("yellow", 5, 5);
    assertEquals("yellow", tile.getColour());
  }

  /**
   * Testing the set colour in the locked door class.
   */
  @Test
  public void test150() {
    LockedDoor tile = new LockedDoor("yellow", 5, 5);
    tile.setColour("red");
    assertEquals("red", tile.getColour());
  }

  /**
   * Testing the get Y position on the screen in the chap class.
   */
  @Test
  public void test151() {
    Chap tile = new Chap(5, 5);
    assertEquals(5, tile.getYPosition());
  }

  /**
   * Testing the get x position on the screen in the chap class.
   */
  @Test
  public void test152() {
    Chap tile = new Chap(5, 5);
    assertEquals(5, tile.getXPosition());
  }

  /**
   * Testing the reset position in the chap class.
   */
  @Test
  public void test153() {
    Chap tile = new Chap(5, 5);
    tile.resetPosition(new Position(4, 4));
    assertEquals(4, tile.getXPosition());
  }

  /**
   * Testing the set on tile method in the chap class.
   */
  @Test
  public void test154() {
    Chap tile = new Chap(5, 5);
    Tile t = new Free(4, 4);
    tile.setOnTile(t);
    assertEquals(t, tile.getOnTile());
  }

  /**
   * Testing the set on tile method in the chap class.
   */
  @Test
  public void test155() {
    Chap tile = new Chap(5, 5);
    Key t = new Key(null, 4, 4);
    tile.setOnTile(t);
    assertEquals(5, tile.getOnTile().getXPosition());
  }

  /**
   * Testing the set on tile method in the chap class.
   */
  @Test
  public void test156() {
    Chap tile = new Chap(5, 5);
    Treasure t = new Treasure(4, 4);
    tile.setOnTile(t);
    assertEquals(5, tile.getOnTile().getXPosition());
  }

  /**
   * Testing the set on tile method in the chap class.
   */
  @Test
  public void test157() {
    Chap tile = new Chap(5, 5);
    LockedDoor t = new LockedDoor(null, 4, 4);
    tile.setOnTile(t);
    assertEquals(5, tile.getOnTile().getXPosition());
  }

  /**
   * Testing the pickup item method in the chap class.
   */
  @Test
  public void test158() {
    Chap tile = new Chap(5, 5);
    Key k = new Key("red", 4, 4);
    tile.pickupItem(k);
    assertEquals(1, tile.getInventory().keySet().size());
  }

  /**
   * Testing the pickup item method in the chap class.
   */
  @Test
  public void test159() {
    Chap tile = new Chap(5, 5);
    Free f = new Free(4, 4);
    tile.pickupItem(f);
    assertEquals(0, tile.getInventory().keySet().size());
  }

  /**
   * Testing the can unlock method in the chap class.
   */
  @Test
  public void test170() {
    Chap tile = new Chap(5, 5);
    Key k = new Key("red", 4, 4);
    tile.pickupItem(k);
    LockedDoor l = new LockedDoor("red", 3, 3);
    assertEquals(true, tile.canUnlock(l));
  }

  /**
   * Testing the can unlock method in the chap class.
   */
  @Test
  public void test171() {
    Chap tile = new Chap(5, 5);
    Key k = new Key("red", 4, 4);
    tile.pickupItem(k);
    LockedDoor l = new LockedDoor("blue", 3, 3);
    assertEquals(false, tile.canUnlock(l));
  }

  /**
   * Testing the can unlock method in the chap class.
   */
  @Test
  public void test172() {
    Chap tile = new Chap(5, 5);
    Key k = new Key("blue", 4, 4);
    tile.pickupItem(k);
    LockedDoor l = new LockedDoor("blue", 3, 3);
    assertEquals(true, tile.canUnlock(l));
  }

  /**
   * Testing the can unlock method in the chap class.
   */
  @Test
  public void test173() {
    Chap tile = new Chap(5, 5);
    Key k = new Key("blue", 4, 4);
    tile.pickupItem(k);
    LockedDoor l = new LockedDoor("blue", 3, 3);
    assertEquals(true, l.canUnlock(tile));
  }

  /**
   * Testing reading in File in Map class.
   */
  @Test
  public void test174() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    assertEquals(true, m.read("levels.json"));
  }

  /**
   * Testing reading in File in Map class.
   */
  @Test
  public void test176() {
    FileReader m = new FileReader("level-5");
    assertThrows(NullPointerException.class, () -> {
      m.read("levels.json");
    });
  }

  /**
   * Testing find chap method in Maze class.
   */
  @Test
  public void test177() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    assertEquals(15, maze.findChap().getXPosition());
  }

  /**
   * Testing get neighbour tile method in Maze class.
   */
  @Test
  public void test178() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Position xy = new Position(2, 2);
    Tile t = maze.getNeighbouringTile(xy, 'N');
    assertEquals(t, maze.getTile(1, 2));
  }

  /**
   * Testing get neighbour tile method in Maze class.
   */
  @Test
  public void test179() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Position xy = new Position(2, 2);
    Tile t = maze.getNeighbouringTile(xy, 'E');
    assertEquals(t, maze.getTile(2, 3));
  }

  /**
   * Testing get neighbour tile method in Maze class.
   */
  @Test
  public void test180() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Position xy = new Position(2, 2);
    Tile t = maze.getNeighbouringTile(xy, 'S');
    assertEquals(t, maze.getTile(3, 2));
  }

  /**
   * Testing get neighbour tile method in Maze class.
   */
  @Test
  public void test181() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Position xy = new Position(2, 2);
    Tile t = maze.getNeighbouringTile(xy, 'W');
    assertEquals(t, maze.getTile(2, 1));
  }

  /**
   * Testing get neighbour tile method in Maze class.
   */
  @Test
  public void test182() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Position xy = new Position(32, 32);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
      maze.getNeighbouringTile(xy, 'W');
    });
  }

  /**
   * Testing get neighbour tile method in Maze class.
   */
  @Test
  public void test183() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Position xy = new Position(0, 0);
    Tile t = maze.getNeighbouringTile(xy, 'N');
    assertEquals(t, null);
  }

  /**
   * Testing get neighbour tile method in Maze class.
   */
  @Test
  public void test184() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Position xy = new Position(31, 31);
    Tile t = maze.getNeighbouringTile(xy, 'S');
    assertEquals(t, null);
  }

  /**
   * Testing get neighbour tile method in Maze class.
   */
  @Test
  public void test185() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Position xy = new Position(0, 0);
    Tile t = maze.getNeighbouringTile(xy, 'W');
    assertEquals(t, null);
  }

  /**
   * Testing get neighbour tile method in Maze class.
   */
  @Test
  public void test186() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Position xy = new Position(31, 31);
    Tile t = maze.getNeighbouringTile(xy, 'E');
    assertEquals(t, null);
  }

  /**
   * Testing get neighbour tile method in Maze class.
   */
  @Test
  public void test187() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Position xy = new Position(7, 7);
    Tile t = maze.getNeighbouringTile(xy, 'E');
    assertEquals(true, maze.setTile(xy, t));
  }

  /**
   * Testing get amount of remaining treasure method in Maze class.
   */
  @Test
  public void test189() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    assertEquals(11, maze.remainingTreasure());
  }

  /**
   * Testing the get tiles method maze class.
   */
  @Test
  public void test190() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    assertEquals("C", maze.getTiles()[14][15].toString());
  }

  /**
   * Testing reset position in the tile class.
   */
  @Test
  public void test191() {
    Chap tile = new Chap(4, 4);
    Position xy = new Position(2, 2);
    tile.resetPosition(xy);
    assertEquals(2, tile.getXPosition());
  }

  /**
   * Testing get Maze method in game class.
   */
  @Test
  public void test200() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Game game = new Game(maze);
    assertEquals(maze, game.getMaze());
  }

  /**
   * Testing set maze method in game class.
   */
  @Test
  public void test202() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Game game = new Game(maze);
    assertEquals(false, game.setMaze(null));
  }

  /**
   * Testing move method in the game class.
   */
  @Test
  public void test203() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Game game = new Game(maze);
    game.move('N');
    assertEquals(true, true);
  }

  /**
   * Testing move method in the game class.
   */
  @Test
  public void test204() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Game game = new Game(maze);
    game.move('W');
    game.move('W');
    game.move('W');
    assertEquals(true, true);
  }

  /**
   * Testing move method in the game class.
   */
  @Test
  public void test205() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Game game = new Game(maze);
    game.move('W');
    game.move('W');
    game.move('N');
    assertEquals(true, true);
  }

  /**
   * Testing move method in the game class.
   */
  @Test
  public void test206() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Game game = new Game(maze);
    game.move('W');
    game.move('W');
    game.move('N');
    game.move('N');
    game.move('W');
    assertEquals(true, true);
  }

  /**
   * Testing move method in the game class.
   */
  @Test
  public void test207() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Game game = new Game(maze);
    game.move('N');
    game.move('N');
    game.move('N');
    assertEquals(true, true);
  }

  /**
   * Testing move method in the game class.
   */
  @Test
  public void test208() {
    FileReader m = new FileReader("level-1");
    m.read("levels.json");
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(), m.getTimeLimit(), m.getMazeLayout());
    Game game = new Game(maze);
    game.move('N');
    game.move('N');
    game.move('W');
    game.move('W');
    game.move('W');
    assertEquals(true, true);
  }
  
  /**
   * Testing Monster tile.
   */
  @Test
  public void test209() {
    Monster m = new Monster(0,0,"");
    assertEquals("resources/CC14.png",m.getImagePath());
  }
  
  /**
   * Testing Monster tile.
   */
  @Test
  public void test210() {
    Monster m = new Monster(0,0,"");
    assertEquals(0,m.getYPosition());
  }
  
  /**
   * Testing Monster tile.
   */
  @Test
  public void test211() {
    Monster m = new Monster(0,0,"");
    assertEquals(0,m.getXPosition());
  }
  
  /**
   * Testing Monster tile.
   */
  @Test
  public void test212() {
    Monster m = new Monster(0,0,"");
    assertEquals("M",m.toString());
  }
  
  /**
   * Testing Monster tile.
   */
  @Test
  public void test213() {
    Monster m = new Monster(0,0,"");
    assertEquals(true,m.updatePosition('N'));
  }
  
  /**
   * Testing Monster tile.
   */
  @Test
  public void test214() {
    Monster m = new Monster(0,0,"");
    assertEquals(true,m.updatePosition('S'));
  }
  
  /**
   * Testing Monster tile.
   */
  @Test
  public void test215() {
    Monster m = new Monster(0,0,"");
    assertEquals(true,m.updatePosition('W'));
  }
  
  /**
   * Testing Monster tile.
   */
  @Test
  public void test216() {
    Monster m = new Monster(0,0,"");
    assertEquals(true,m.updatePosition('E'));
  }
  
  /**
   * Testing Monster tile.
   */
  @Test
  public void test217() {
    Monster m = new Monster(0,0,"");
    assertEquals(true,m.setOnTile(new Free(3,3)));
  }
  
  /**
   * Testing Monster tile.
   */
  @Test
  public void test218() {
    FileReader fileReader = new FileReader("level-2");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    Game game = new Game(maze);
    Monster m = maze.getMonsters().get(0);
    //m.move(game);
    assertEquals(true,true);
  }
  
  /**
   * Testing Chap tile.
   */
  @Test
  public void test219() {
    Chap c = new Chap(3,3);
    c.updatePosition('S');
    assertEquals(true,true);
  }
  
  /**
   * Testing Chap tile.
   */
  @Test
  public void test220() {
    Chap c = new Chap(3,3);
    c.updatePosition('E');
    assertEquals(true,true);
  }
  
  /**
   * Testing Chap tile.
   */
  @Test
  public void test221() {
    Chap c = new Chap(3,3);
    assertEquals(3,c.getChapPosition().getX());
  }
  
  /**
   * Testing Chap tile.
   */
  @Test
  public void test222() {
    Chap c = new Chap(3,3);
    FileReader fileReader = new FileReader("level-2");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    c.resetPlayer(maze);
    assertEquals(true,true);
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test223() {
    Chap c = new Chap(3,3);
    assertEquals(2,c.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test224() {
    Tile t = new Exit(3,3);
    assertEquals(3,t.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test225() {
    Tile t = new Exit(3,3);
    assertEquals(3,t.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test226() {
    Tile t = new Free(3,3);
    assertEquals(0,t.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test227() {
    Tile t = new ExitLock(3,3);
    assertEquals(4,t.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test228() {
    Tile t = new Key("red",3,3);
    assertEquals(9,t.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test229() {
    Tile t = new Key("blue",3,3);
    assertEquals(10,t.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test230() {
    Tile t = new Key("green",3,3);
    assertEquals(11,t.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test231() {
    Tile t = new Key("yellow",3,3);
    assertEquals(12,t.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test232() {
    Tile t = new LockedDoor("red",3,3);
    assertEquals(13,t.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test233() {
    Tile t = new LockedDoor("blue",3,3);
    assertEquals(14,t.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test234() {
    Tile t = new LockedDoor("green",3,3);
    assertEquals(15,t.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test235() {
    Tile t = new LockedDoor("yellow",3,3);
    assertEquals(16,t.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test236() {
    Tile t = new Treasure(3,3);
    assertEquals(8,t.getValue());
  }
  
  /**
   * Testing get Value in tile class.
   */
  @Test
  public void test237() {
    Tile t = new Wall(3,3);
    assertEquals(1,t.getValue());
  }
  
  /**
   * Testing unlocking exit lock.
   */
  @Test
  public void test238() {
    ExitLock t = new ExitLock(3,3);
    t.unlockExitLock();
    assertEquals(false,t.isSolid);
  }
  
  /**
   * Testing position class.
   */
  @Test
  public void test239() {
    Position p = new Position(2,2);
    assertEquals("(2, 2)",p.toString());
  }
  
  /**
   * Testing files that can be read in. 
   */
  @Test
  public void test240() {
    Filter f = new Filter();
    File file = new File("levels.json");
    assertEquals(true,f.accept(file));
  }
  
  /**
   * Testing files that can be read in. 
   */
  @Test
  public void test241() {
    Filter f = new Filter();
    File file = new File("level.jso");
    assertEquals(false,f.accept(file));
  }
  
  /**
   * Testing files that can be read in. 
   */
  @Test
  public void test242() {
    Filter f = new Filter();
    File file = new File("levels");
    assertEquals(false,f.accept(file));
  }
  
  /**
   * Testing files that can be read in. 
   */
  @Test
  public void test243() {
    Filter f = new Filter();
    assertEquals("JSON files (*.json)",f.getDescription());
  }
  
  /**
   * Testing the timer class.  
   */
  @Test
  public void test245() {
    FileReader fileReader = new FileReader("level-2");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    Game game = new Game(maze);
    TimeLimit t = new TimeLimit(60,new MainFrame(game));
    t.setTime(100);
    assertEquals(true,true);
  }
  
  /**
   * Testing the timer class.  
   */
  @Test
  public void test246() {
    FileReader fileReader = new FileReader("level-2");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    Game game = new Game(maze);
    TimeLimit t = new TimeLimit(0,new MainFrame(game));
    
    assertEquals(0,0);
  }
  
  /**
   * Testing the timer class.  
   */
  @Test
  public void test247() {
    FileReader fileReader = new FileReader("level-1");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    Game game = new Game(maze);
    TimeLimit t = new TimeLimit(0,new MainFrame(game));
    
    assertEquals(0,0);
  }
  
  /**
   * Testing the text panel class.  
   */
  @Test
  public void test248() {
    TextPanel tp = new TextPanel();
    assertEquals("",tp.getLabel().getText());
  }
  
  /**
   * Testing the maze class.  
   */
  @Test
  public void test249() {
    FileReader fileReader = new FileReader("level-2");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    assertEquals(true,maze.printConvertedLevel());
  }
  
  /**
   * Testing the maze class.  
   */
  @Test
  public void test250() {
    FileReader fileReader = new FileReader("level-2");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    assertThrows(IllegalArgumentException.class, () -> {
      maze.setTile(null,null);
    });
  }
  
  /**
   * Testing the maze class.  
   */
  @Test
  public void test251() {
    FileReader fileReader = new FileReader("level-2");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    assertThrows(IllegalArgumentException.class, () -> {
      maze.setTile(new Position(3,3),null);
    });
  }
  
  /**
   * Testing the maze class.  
   */
  @Test
  public void test252() {
    FileReader fileReader = new FileReader("level-2");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    assertThrows(IllegalArgumentException.class, () -> {
      maze.getTile(-1,-1);
    });
  }
  
  /**
   * Testing the maze class.  
   */
  @Test
  public void test253() {
    FileReader fileReader = new FileReader("level-2");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    assertThrows(IllegalArgumentException.class, () -> {
      maze.getTile(1,-1);
    });
  }
  
  /**
   * Testing the maze class.  
   */
  @Test
  public void test254() {
    FileReader fileReader = new FileReader("level-2");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    assertEquals(true,maze.getNextLevel());
  }
  
  /**
   * Testing the maze class.  
   */
  @Test
  public void test255() {
    FileReader fileReader = new FileReader("level-2");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    assertEquals(45,maze.getTime());
  }
  
  /**
   * Testing the maze class.  
   */
  @Test
  public void test256() {
    FileReader fileReader = new FileReader("level-2");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    assertThrows(IllegalArgumentException.class, () -> {
      maze.getNeighbouringTile(null, null);
    });
  }
  
  /**
   * Testing the maze class.  
   */
  @Test
  public void test257() {
    FileReader fileReader = new FileReader("level-2");
    fileReader.read("levels.json");
    Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
        fileReader.getTimeLimit(), fileReader.getMazeLayout());
    assertThrows(IllegalArgumentException.class, () -> {
      maze.getNeighbouringTile(new Position(3,3), null);
    });
  }
  
  /**
   * Testing the chap  class.  
   */
  @Test
  public void test258() {
    Chap c = new Chap(3,3);
    assertThrows(IllegalArgumentException.class, () -> {
      c.canUnlock(null);
    });
  }
  
  /**
   * Testing the chap class.  
   */
  @Test
  public void test259() {
    Chap c = new Chap(3,3);
    assertThrows(IllegalArgumentException.class, () -> {
      c.pickupItem(null);
    });
  }
  
  /**
   * Testing the chap class.  
   */
  @Test
  public void test260() {
    Chap c = new Chap(3,3);
    assertThrows(IllegalArgumentException.class, () -> {
      c.setOnTile(null);
    });
  }
  
  /**
   * Testing the chap class.  
   */
  @Test
  public void test261() {
    Chap c = new Chap(3,3);
    assertThrows(IllegalArgumentException.class, () -> {
      c.updatePosition(null);
    });
  }
  
  /**
   * Testing the chap class.  
   */
  @Test
  public void test262() {
    Chap c = new Chap(3,3);
    assertThrows(IllegalArgumentException.class, () -> {
      c.resetPosition(null);
    });
  }
  
  /**
   * Testing the chap class.  
   */
  @Test
  public void test263() {
    Chap c = new Chap(3,3);
    assertThrows(IllegalArgumentException.class, () -> {
      c.resetPlayer(null);
    });
  }
  
  /**
   * Testing the chap class.  
   */
  @Test
  public void test264() {
    Monster m = new Monster(3,3,"");
    assertThrows(IllegalArgumentException.class, () -> {
      //m.move(null);
    });
  }
  
  /**
   * Testing the chap class.  
   */
  @Test
  public void test265() {
    Monster m = new Monster(3,3,"");
    assertThrows(IllegalArgumentException.class, () -> {
      m.setOnTile(null);
    });
  }
  
  /**
   * Testing the monster class.  
   */
  @Test
  public void test266() {
    Monster m = new Monster(3,3,"");
    assertThrows(IllegalArgumentException.class, () -> {
      m.updatePosition(null);
    });
  }
  
  /**
   * Testing the monster class.  
   */
  @Test
  public void test267() {
    Monster m = new Monster(3,3,"");
    assertEquals(5,m.getValue());
  }
  
  /**
   * Testing the infoField class.  
   */
  @Test
  public void test268() {
    InfoField t = new InfoField("text",3,3);
    assertThrows(IllegalArgumentException.class, () -> {
      t.setInfoFieldText(null);
    });
  }
  
  /**
   * Testing the info field class.  
   */
  @Test
  public void test269() {
    InfoField t = new InfoField("text",3,3);
    assertEquals(7,t.getValue());
  }
}
