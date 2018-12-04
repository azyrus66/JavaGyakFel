package azyrus66;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
	private JPanel mainPanel;
	private JComboBox feladatokComboBox;
	private JButton runButton;

	public Gui() {
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUp();

		runButton.addActionListener(actionEvent -> {

		});

	}

	private void setUp() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(10, 10, 10, 10));
		mainPanel.setForeground(new Color(-12828863));
		add(mainPanel);

		feladatokComboBox = new JComboBox();
		feladatokComboBox.setForeground(new Color(-12828863));
		final DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
		defaultComboBoxModel.addElement("1. fealdat");
		defaultComboBoxModel.addElement("2. feladat");
		defaultComboBoxModel.addElement("3. feladat");
		feladatokComboBox.setModel(defaultComboBoxModel);
		mainPanel.add(feladatokComboBox, new GridLayout(1, 1, 1, 1));

		runButton = new JButton();
		runButton.setForeground(new Color(-12828863));
		runButton.setText("Run");
		mainPanel.add(runButton, new GridLayout(1, 1, 1, 1));
	}
}