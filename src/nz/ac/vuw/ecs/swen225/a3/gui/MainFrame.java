
package nz.ac.vuw.ecs.swen225.a3.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import nz.ac.vuw.ecs.swen225.a3.maze.Game;
import nz.ac.vuw.ecs.swen225.a3.maze.Maze;
import nz.ac.vuw.ecs.swen225.a3.persistence.FileReader;
import nz.ac.vuw.ecs.swen225.a3.util.Filter;

/**
 * MainFrame that will hold panels and menus that will be responsible for
 * displaying the game and holding buttons that allow interaction with the game.
 */
public class MainFrame extends JFrame {
  private DisplayPanel displayPanel;
  private InterfacePanel interfacePanel;
  private InventoryPanel inventoryPanel;
  private RulesPanel rulesPanel;

  private TextPanel textPanel;

  private JFileChooser fileChooser;
  private Filter filter;

  private Game game;

  private boolean paused = false;

  private boolean refreshing;

  // used for tracking states in game

  /**
   * Serial ID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor for main frame.
   * 
   * @param game = Game for this frame.
   */
  public MainFrame(Game game) {
    super("Chip's Challenge");

    this.game = game;

    this.addKeyListener(new KeyListener());

    // Initializing and defining parameters.
    setSize(500, 500);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    fileChooser = new JFileChooser();
    filter = new Filter();

    fileChooser.addChoosableFileFilter(filter);
    fileChooser.setFileFilter(filter);

    setLayout(new GridBagLayout());

    GridBagConstraints gc = new GridBagConstraints();

    gc.gridx = 0;
    gc.gridy = 0;
    gc.fill = GridBagConstraints.BOTH;

    // Add panels to main frame.
    setJMenuBar(createMenuBar());

    // DISPLAY.
    gc.weightx = 0.75;
    gc.weighty = 1;

    gc.gridwidth = 1;
    gc.gridheight = 2;

    displayPanel = new DisplayPanel(game);
    add(displayPanel, gc);

    // INTERFACE.
    gc.gridx++;

    gc.weightx = 0.25;
    gc.weighty = 0.75;

    gc.gridwidth = 1;
    gc.gridheight = 1;

    interfacePanel = new InterfacePanel();
    add(interfacePanel, gc);

    // INVENTORY.
    gc.gridy++;

    gc.weightx = 0.25;
    gc.weighty = 0.25;

    gc.gridwidth = 1;
    gc.gridheight = 1;

    inventoryPanel = new InventoryPanel(game);
    add(inventoryPanel, gc);

    rulesPanel = new RulesPanel();
    add(rulesPanel, gc);

    textPanel = new TextPanel();
    add(textPanel, gc);

    pack();
    setVisible(true);

    interfacePanel.chipsLeftField.setText(String.valueOf(displayPanel.totalChipsLeft));
    interfacePanel.levelField.setText(game.getMaze().getLevelName());
    refreshing = false;
  }

  /**
   * Creates the menu bar.
   * 
   * @return JMenuBar : Returns the menu bar created.
   */
  private JMenuBar createMenuBar() {
    final JMenuBar menuBar = new JMenuBar();

    // GAME MENU.
    final JMenu gameMenu = new JMenu("Game");

    JMenuItem loadItem = new JMenuItem("Load");
    JMenuItem saveItem = new JMenuItem("Save");
    JMenuItem exitItem = new JMenuItem("Exit");

    // Add action listener to load a saved game
    loadItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        FileReader fileReader = game.getMaze().getFileReader();
        fileReader.read("savedLevel.json");
        Maze maze = new Maze(fileReader, fileReader.getWidth(), fileReader.getHeight(),
            fileReader.getTimeLimit(), fileReader.getMazeLayout());
        game.setMaze(maze);
        game.setChap();
        displayPanel.setTotalChips(game.getMaze().remainingTreasure());

        inventoryPanel.setVisible(!game.onField());
        textPanel.setVisible(game.onField());

        interfacePanel.chipsLeftField.setText(String.valueOf(displayPanel.totalChipsLeft));
        interfacePanel.levelField.setText(game.getMaze().getLevelName());

        displayPanel.removeAll();
        displayPanel.drawPanel();

        displayPanel.revalidate();
        displayPanel.repaint();

        inventoryPanel.removeAll();
        inventoryPanel.drawInventory();

        inventoryPanel.revalidate();
        inventoryPanel.repaint();
        JOptionPane.showMessageDialog(MainFrame.this, "Saved Game has been loaded");
      }
    });

    // Add action listener to save a current game
    saveItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        game.getMaze().getFileReader().save(game.getMaze());
        JOptionPane.showMessageDialog(MainFrame.this, "Game has been saved");
      }
    });

    // Add action listener to exit game
    exitItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent ev) {
        int action = JOptionPane.showConfirmDialog(MainFrame.this,
            "Do you really want to exit the game?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

        if (action == JOptionPane.OK_OPTION) {
          System.exit(0);
        }
      }
    });

    gameMenu.add(loadItem);
    gameMenu.add(saveItem);
    gameMenu.addSeparator();
    gameMenu.add(exitItem);

    // OPTIONS MENU.
    JMenu optionsMenu = new JMenu("Options");

    JMenuItem resumeItem = new JMenuItem("Resume");
    JMenuItem pauseItem = new JMenuItem("Pause");
    
    pauseItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent ev) {
        paused = true;
        }
      });

    optionsMenu.add(resumeItem);
    optionsMenu.add(pauseItem);

    // LEVEL MENU.
    JMenu levelMenu = new JMenu("Level");

    JMenuItem resetItem = new JMenuItem("Reset");

    levelMenu.add(resetItem);

    // HELP MENU.
    JMenu helpMenu = new JMenu("Help");

    JCheckBoxMenuItem rulesItem = new JCheckBoxMenuItem("Rules");

    /*
     * Add action listener to the rules item. When rules is ticked, hides the game
     * and displays the rules.
     */
    rulesItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();

        displayPanel.setVisible(!menuItem.isSelected());
        interfacePanel.setVisible(!menuItem.isSelected());
        inventoryPanel.setVisible(!menuItem.isSelected());

        rulesPanel.setVisible(menuItem.isSelected());

        paused = menuItem.isSelected();
      }
    });

    helpMenu.add(rulesItem);

    // Adding to menu bar.
    menuBar.add(gameMenu);
    menuBar.add(optionsMenu);
    menuBar.add(levelMenu);
    menuBar.add(helpMenu);

    // Setting mnemonics.
    gameMenu.setMnemonic(KeyEvent.VK_G);
    optionsMenu.setMnemonic(KeyEvent.VK_O);
    levelMenu.setMnemonic(KeyEvent.VK_L);
    helpMenu.setMnemonic(KeyEvent.VK_H);

    // Setting accelerators.
    exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    resumeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
    pauseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
    loadItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
    resetItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));

    return menuBar;
  }

  /**
   * Listens for key press and executes the relevant method.
   */
  class KeyListener extends KeyAdapter {
    public void keyPressed(KeyEvent evt) {
      if (game.isFinished() == true) {
        // Debug : Checks game is finished
        System.out.println("Game is finished!");
      } else if (!paused) {
        // Movement.
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_W) {
          game.move('N');
          // game.moveMonsters();
        }

        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_S) {
          game.move('S');
          // game.moveMonsters();
        }

        if (evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_A) {
          game.move('W');
          // game.moveMonsters();
        }

        if (evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_D) {
          game.move('E');
          // game.moveMonsters();
        }

        // Other.
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
          System.out.println("Space was pressed");
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
          System.out.println("ESC was pressed");
        }

        refreshDisplay();

      } else {
        // Debug : checks game is paused in rules
        System.out.println("Game is paused");
      }
    }

  }

  /**
   * Re-render the display screen.
   */
  public void refreshDisplay() {

    if (refreshing == true) {
      try {
        Thread.sleep(50);
        // System.out.println("CLASHChap");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // while(refreshing==false) {
    refreshing = true;

    // Only get the label of InfoField if standing on one, need
    // otherwise error from
    // grabbing nothing.
    if (game.onField()) {
      textPanel.getLabel().setText(game.getInfoField().getInfoFieldText());
    }

    // Update the total number of chips every move.
    displayPanel.setTotalChips(game.getMaze().remainingTreasure());

    inventoryPanel.setVisible(!game.onField());
    textPanel.setVisible(game.onField());

    interfacePanel.chipsLeftField.setText(String.valueOf(displayPanel.totalChipsLeft));
    interfacePanel.levelField.setText(game.getMaze().getLevelName());

    // displayPanel.removeAll();
    displayPanel.drawPanel();

    displayPanel.revalidate();
    displayPanel.repaint();

    inventoryPanel.removeAll();
    inventoryPanel.drawInventory();

    inventoryPanel.revalidate();
    inventoryPanel.repaint();
    // }
    refreshing = false;

  }

  /**
   * Refresh the board only.
   */
  public void refreshBoard() {
    if (refreshing == true) {
      try {
        // System.out.println("CLASH");
        Thread.sleep(80);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // while(refreshing==false) {
    refreshing = true;
    // displayPanel.removeAll();
    displayPanel.drawPanel();

    displayPanel.revalidate();
    displayPanel.repaint();
    // }
    refreshing = false;
  }

  /**
   * Returns the interface panel.
   * 
   * @return interfacePanel
   */
  public InterfacePanel getInterfacePanel() {
    assert this.interfacePanel != null;

    return this.interfacePanel;
  }

  /**
   * Returns the game.
   * 
   * @return the game that is currently contained
   */
  public Game getGame() {
    return this.game;
  }
}
