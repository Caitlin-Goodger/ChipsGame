package nz.ac.vuw.ecs.swen225.a3.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;

import org.junit.Test;

import nz.ac.vuw.ecs.swen225.a3.maze.Chap;
import nz.ac.vuw.ecs.swen225.a3.maze.Exit;
import nz.ac.vuw.ecs.swen225.a3.maze.ExitLock;
import nz.ac.vuw.ecs.swen225.a3.maze.Free;
import nz.ac.vuw.ecs.swen225.a3.maze.InfoField;
import nz.ac.vuw.ecs.swen225.a3.maze.Key;
import nz.ac.vuw.ecs.swen225.a3.maze.LockedDoor;
import nz.ac.vuw.ecs.swen225.a3.maze.Treasure;
import nz.ac.vuw.ecs.swen225.a3.maze.Wall;
import nz.ac.vuw.ecs.swen225.a3.maze.interfaces.Tile;
import nz.ac.vuw.ecs.swen225.a3.persistence.FileReader;
import nz.ac.vuw.ecs.swen225.a3.persistence.Maze;
import nz.ac.vuw.ecs.swen225.a3.util.Position;

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

  // /**
  // * Testing XYPOS update method.
  // */
  // @Test
  // public void test02() {
  // Position pos = new Position(5, 5);
  // pos.updatePosition(2, 0);
  // assertEquals(7, pos.getX());
  // }

  // /**
  // * Testing XYPOS update method.
  // */
  // @Test
  // public void test03() {
  // Position pos = new Position(5, 5);
  // pos.updatePosition(0, 3);
  // assertEquals(8, pos.getY());
  // }

  /**
   * Testing XYPOS update method.
   */
  @Test
  public void test04() {
    Position pos = new Position(5, 5);
    pos.updatePosition(-2, 0);
    assertEquals(3, pos.getX());
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

  // /**
  // * Testing reading in File in Map class.
  // */
  // @Test
  // public void test174() {
  // FileReader m = new FileReader("level-1");
  // m.read();
  // assertEquals(true, m.read());
  // }

  // /**
  // * Testing reading in File in Map class.
  // */
  // @Test
  // public void test175() {
  // FileReader m = new FileReader("level-5");
  // m.read();
  // assertEquals(false, m.read());
  // }

  /**
   * Testing reading in File in Map class.
   */
  @Test
  public void test176() {
    FileReader m = new FileReader("level-1");
    assertThrows(FileNotFoundException.class, () -> {
      m.read();
    });
  }

  /**
   * Testing find chap method in Maze class.
   */
  @Test
  public void test177() {
    FileReader m = new FileReader("level-1");
    m.read();
    Maze maze = new Maze(m, m.getWidth(), m.getHeight(),
        m.getTimeLimit(), m.getMazeLayout());
    assertEquals(15, maze.findChap().getXPosition());
  }

//  /**
//   * Testing get neighbour tile method in Maze class.
//   */
//  @Test
//  public void test178() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Position xy = new Position(2, 2);
//    Tile t = maze.getNeighbouringTile(xy, 'N');
//    assertEquals(t, maze.getTile(1, 2));
//  }
//
//  /**
//   * Testing get neighbour tile method in Maze class.
//   */
//  @Test
//  public void test179() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Position xy = new Position(2, 2);
//    Tile t = maze.getNeighbouringTile(xy, 'E');
//    assertEquals(t, maze.getTile(2, 3));
//  }
//
//  /**
//   * Testing get neighbour tile method in Maze class.
//   */
//  @Test
//  public void test180() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Position xy = new Position(2, 2);
//    Tile t = maze.getNeighbouringTile(xy, 'S');
//    assertEquals(t, maze.getTile(3, 2));
//  }
//
//  /**
//   * Testing get neighbour tile method in Maze class.
//   */
//  @Test
//  public void test181() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Position xy = new Position(2, 2);
//    Tile t = maze.getNeighbouringTile(xy, 'W');
//    assertEquals(t, maze.getTile(2, 1));
//  }
//
//  /**
//   * Testing get neighbour tile method in Maze class.
//   */
//  @Test
//  public void test182() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Position xy = new Position(32, 32);
//    assertThrows(ArrayIndexOutOfBoundsException.class, () ->
//      {
//        maze.getNeighbouringTile(xy, 'W');
//      });
//  }
//
//  /**
//   * Testing get neighbour tile method in Maze class.
//   */
//  @Test
//  public void test183() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Position xy = new Position(0, 0);
//    Tile t = maze.getNeighbouringTile(xy, 'N');
//    assertEquals(t, null);
//  }
//
//  /**
//   * Testing get neighbour tile method in Maze class.
//   */
//  @Test
//  public void test184() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Position xy = new Position(31, 31);
//    Tile t = maze.getNeighbouringTile(xy, 'S');
//    assertEquals(t, null);
//  }
//
//  /**
//   * Testing get neighbour tile method in Maze class.
//   */
//  @Test
//  public void test185() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Position xy = new Position(0, 0);
//    Tile t = maze.getNeighbouringTile(xy, 'W');
//    assertEquals(t, null);
//  }
//
//  /**
//   * Testing get neighbour tile method in Maze class.
//   */
//  @Test
//  public void test186() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Position xy = new Position(31, 31);
//    Tile t = maze.getNeighbouringTile(xy, 'E');
//    assertEquals(t, null);
//  }
//
//  /**
//   * Testing get neighbour tile method in Maze class.
//   */
//  @Test
//  public void test187() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Position xy = new Position(7, 7);
//    Tile t = maze.getNeighbouringTile(xy, 'E');
//    assertEquals(true, maze.setTile(xy, t));
//  }
//
//  // Don't need these anymore
//
////	/**
////	 * Testing change to free method in Maze class.  
////	 */
////	@Test public void test188() {
////		Maze maze = new Maze(32,32,"level-1");
////		XYPos xy = new XYPos(7,7);
////		Tile t = maze.getNeighbouringTile(xy, 'E');
////		assertEquals(true,maze.changeToFree(t));
////	}
//
//  /**
//   * Testing get amount of remaining treasure method in Maze class.
//   */
//  @Test
//  public void test189() {
//    Maze maze = new Maze(32, 32, "level-1");
//    assertEquals(11, maze.remainingTreasure());
//  }
//
//  /**
//   * Testing the get tiles method maze class.
//   */
//  @Test
//  public void test190() {
//    Maze maze = new Maze(32, 32, "level-1");
//    assertEquals("C", maze.getTiles()[14][15].toString());
//  }
//
//  /**
//   * Testing reset position in the tile class.
//   */
//  @Test
//  public void test191() {
//    Chap tile = new Chap(4, 4);
//    Position xy = new Position(2, 2);
//    tile.resetPosition(xy);
//    assertEquals(2, tile.getXPosition());
//  }
//
//  /**
//   * Testing reset position in the tile class.
//   */
//  @Test
//  public void test192() {
//    Exit tile = new Exit(4, 4);
//    Position xy = new Position(2, 2);
//    tile.resetPosition(xy);
//    assertEquals(2, tile.getXPosition());
//  }
//
//  /**
//   * Testing reset position in the tile class.
//   */
//  @Test
//  public void test193() {
//    Tile tile = new ExitLock(4, 4);
//    Position xy = new Position(2, 2);
//    tile.resetPosition(xy);
//    assertEquals(2, tile.getXPosition());
//  }
//
//  /**
//   * Testing reset position in the tile class.
//   */
//  @Test
//  public void test194() {
//    Tile tile = new Free(4, 4);
//    Position xy = new Position(2, 2);
//    tile.resetPosition(xy);
//    assertEquals(2, tile.getXPosition());
//  }
//
//  /**
//   * Testing reset position in the tile class.
//   */
//  @Test
//  public void test195() {
//    Tile tile = new InfoField(null, 4, 4);
//    Position xy = new Position(2, 2);
//    tile.resetPosition(xy);
//    assertEquals(2, tile.getXPosition());
//  }
//
//  /**
//   * Testing reset position in the tile class.
//   */
//  @Test
//  public void test196() {
//    Tile tile = new Key(null, 4, 4);
//    Position xy = new Position(2, 2);
//    tile.resetPosition(xy);
//    assertEquals(2, tile.getXPosition());
//  }
//
//  /**
//   * Testing reset position in the tile class.
//   */
//  @Test
//  public void test197() {
//    Tile tile = new LockedDoor(null, 4, 4);
//    Position xy = new Position(2, 2);
//    tile.resetPosition(xy);
//    assertEquals(2, tile.getXPosition());
//  }
//
//  /**
//   * Testing reset position in the tile class.
//   */
//  @Test
//  public void test198() {
//    Tile tile = new Treasure(4, 4);
//    Position xy = new Position(2, 2);
//    tile.resetPosition(xy);
//    assertEquals(2, tile.getXPosition());
//  }
//
//  /**
//   * Testing reset position in the tile class.
//   */
//  @Test
//  public void test199() {
//    Wall tile = new Wall(4, 4);
//    Position xy = new Position(2, 2);
//    tile.resetPosition(xy);
//    assertEquals(2, tile.getXPosition());
//  }
//
//  /**
//   * Testing get Maze method in game class.
//   */
//  @Test
//  public void test200() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Game game = new Game(maze);
//    assertEquals(maze, game.getMaze());
//  }
//
//  /**
//   * Testing delete maze method in game class.
//   */
//  @Test
//  public void test201() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Game game = new Game(maze);
//    game.delete();
//    assertEquals(null, game.getMaze());
//  }
//
//  /**
//   * Testing set maze method in game class.
//   */
//  @Test
//  public void test202() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Game game = new Game(maze);
//    assertEquals(false, game.setMaze(null));
//  }
//
//  /**
//   * Testing move method in the game class.
//   */
//  @Test
//  public void test203() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Game game = new Game(maze);
//    game.move('N');
//    assertEquals(true, true);
//  }
//
//  /**
//   * Testing move method in the game class.
//   */
//  @Test
//  public void test204() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Game game = new Game(maze);
//    game.move('W');
//    game.move('W');
//    game.move('W');
//    assertEquals(true, true);
//  }
//
//  /**
//   * Testing move method in the game class.
//   */
//  @Test
//  public void test205() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Game game = new Game(maze);
//    game.move('W');
//    game.move('W');
//    game.move('N');
//    assertEquals(true, true);
//  }
//
//  /**
//   * Testing move method in the game class.
//   */
//  @Test
//  public void test206() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Game game = new Game(maze);
//    game.move('W');
//    game.move('W');
//    game.move('N');
//    game.move('N');
//    game.move('W');
//    assertEquals(true, true);
//  }
//
//  /**
//   * Testing move method in the game class.
//   */
//  @Test
//  public void test207() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Game game = new Game(maze);
//    game.move('N');
//    game.move('N');
//    game.move('N');
//    assertEquals(true, true);
//  }
//
//  /**
//   * Testing move method in the game class.
//   */
//  @Test
//  public void test208() {
//    Maze maze = new Maze(32, 32, "level-1");
//    Game game = new Game(maze);
//    game.move('N');
//    game.move('N');
//    game.move('W');
//    game.move('W');
//    game.move('W');
//    assertEquals(true, true);
//  }

}
