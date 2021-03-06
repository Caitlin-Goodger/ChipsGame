package nz.ac.vuw.ecs.swen225.a3.gui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Inventory panel that holds the objects collected by the player.
 */
public class TextPanel extends JPanel {

  private JLabel text;

  /**
   * Serial ID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor for the text panel.
   */
  public TextPanel() {
    setPreferredSize(new Dimension(getWidth(), 40));

    Border innerBorder = BorderFactory.createTitledBorder("Text");
    Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

    text = new JLabel();

    add(text);
  }

  /**
   * Gets the label in text panel.
   * 
   * @return text
   */
  public JLabel getLabel() {
    assert this.text != null;

    return this.text;
  }
}
