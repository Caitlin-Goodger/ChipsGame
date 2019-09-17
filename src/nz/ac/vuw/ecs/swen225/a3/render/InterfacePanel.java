package nz.ac.vuw.ecs.swen225.a3.render;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class InterfacePanel extends JPanel {
	private JLabel levelLabel;
	private JLabel timeLabel;
	private JLabel chipsLeftLabel;
	
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	public InterfacePanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		levelLabel = new JLabel("LEVEL");
		timeLabel = new JLabel("TIME");
		chipsLeftLabel = new JLabel("CHIPS LEFT");
		
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
		
		
	}
}
