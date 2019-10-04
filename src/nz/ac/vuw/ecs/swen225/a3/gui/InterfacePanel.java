package nz.ac.vuw.ecs.swen225.a3.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * Interface panel holds the information of the game such as
 * level, time and chips left.
 */
public class InterfacePanel extends JPanel {
	private JLabel levelLabel;
	private JLabel timeLabel;
	private JLabel chipsLeftLabel;

	/**
	 * Text field for the level.
	 */
	public JTextField levelField;
	private JTextField timeField;
	/**
	 * Text field for the chips left.
	 */
	public JTextField chipsLeftField;

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the interface panel.
	 */
	public InterfacePanel() {
		setPreferredSize(new Dimension(250, getHeight()));

		levelLabel = new JLabel("LEVEL");
		timeLabel = new JLabel("TIME");
		chipsLeftLabel = new JLabel("CHIPS LEFT");

		levelField = new JTextField("0", 5);
		timeField = new JTextField("0", 5);
		chipsLeftField = new JTextField("0", 5);

		Border innerBorder = BorderFactory.createTitledBorder("Information");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		// LEVEL.
		add(levelLabel, gc);

		gc.gridy++;

		levelField.setHorizontalAlignment(SwingConstants.RIGHT);
		levelField.setEnabled(false);

		gc.anchor = GridBagConstraints.PAGE_START;

		add(levelField, gc);

		// TIME.
		gc.gridy++;

		gc.anchor = GridBagConstraints.CENTER;

		add(timeLabel, gc);

		gc.gridy++;

		timeField.setHorizontalAlignment(SwingConstants.RIGHT);
		timeField.setEnabled(false);

		gc.anchor = GridBagConstraints.PAGE_START;

		add(timeField, gc);

		// CHIPS LEFT.
		gc.gridy++;

		gc.anchor = GridBagConstraints.CENTER;

		add(chipsLeftLabel, gc);

		gc.gridy++;

		chipsLeftField.setHorizontalAlignment(SwingConstants.RIGHT);
		chipsLeftField.setEnabled(false);

		gc.anchor = GridBagConstraints.PAGE_START;

		add(chipsLeftField, gc);
	}

	/**
	 * Sets the time displayed.
	 * 
	 * @param time
	 */
	public void setTime(int time) {
		if (time < 0) {
			throw new IllegalArgumentException("Argument must be greater than 0.");
		}

		this.timeField.setText(Integer.toString(time));
	}
}
