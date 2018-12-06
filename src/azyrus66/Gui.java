package azyrus66;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
	private JFrame frame;
	private JMenuBar menuBar;

	public Gui() {
		frame = new JFrame("Frame");
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(600, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setBackground(new Color(0x3B3E40));
		menuBar.setPreferredSize(new Dimension(200, 20));
		frame.setJMenuBar(menuBar);

		FeladatokComboBox feladatokComboBox = new FeladatokComboBox();
		feladatokComboBox.mainPane.setOpaque(true);
		frame.setContentPane(feladatokComboBox.mainPane);


		frame.pack();
		frame.setVisible(true);

	}
}