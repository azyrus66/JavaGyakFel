package azyrus66;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FeladatokComboBox implements ActionListener, PropertyChangeListener {
	public JPanel mainPane, feladatPane;
	private JLabel label;
	private JTextField input;
	private static String inputString;

	public FeladatokComboBox() {
		mainPane = new JPanel();
		mainPane.setLayout(new GridLayout(2, 1, 1, 1));
		mainPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		String[] feladatok = new String[15];
		for (int i = 1; i <= 15; i++) {
			feladatok[i-1] = (i + ". feladat");
		}
		JComboBox<String> feladatokComboBox = new JComboBox<>(feladatok);
		feladatokComboBox.setForeground(Color.DARK_GRAY);
		feladatokComboBox.setPreferredSize(new Dimension(400, -1));
		feladatokComboBox.addActionListener(this);
		mainPane.add(feladatokComboBox);

		input = new JTextField();
		input.setColumns(10);
		input.addPropertyChangeListener(this);

		label = new JLabel("Label");

		feladatPane = new JPanel();
		feladatPane.setLayout(new BoxLayout(feladatPane, BoxLayout.PAGE_AXIS));
		feladatPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(""),
				BorderFactory.createEmptyBorder(5,5,5,5)));
		feladatPane.add(input);
		feladatPane.add(label);

		mainPane.add(feladatPane);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JComboBox cb = (JComboBox)actionEvent.getSource();
		switch (cb.getSelectedIndex()) {
			case 0: {updateBorderText(StringFel.elsoNagybetuString); break;}
			case 1: {updateBorderText(StringFel.tukorString); break;}
			case 2: {updateBorderText(StringFel.nemBetuString); break;}
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
		Object source = propertyChangeEvent.getSource();
		if (source == input) {
			inputString = input.getText();
		}
	}

	protected void updateLabel(String feladat) {
		label.setText(feladat);
	}

	protected void updateBorderText(String text) {
		feladatPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(text),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	}
}
