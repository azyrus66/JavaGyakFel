package azyrus66;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FeladatokComboBox implements ActionListener, PropertyChangeListener {
	public JPanel mainPane, feladatPane;
	private JComboBox<String> feladatokComboBox;
	private JLabel label;
	private JButton runButton;
	private JFormattedTextField input;
	private static String inputString, inputString2, inputString3;

	public FeladatokComboBox() {
		mainPane = new JPanel();
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
		mainPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		JPanel comboBox = new JPanel();
		comboBox.setLayout(new BoxLayout(comboBox, BoxLayout.PAGE_AXIS));

		String[] feladatok = new String[15];
		for (int i = 1; i <= 15; i++) {
			feladatok[i-1] = (i + ". feladat");
		}
		feladatokComboBox = new JComboBox<>(feladatok);
		feladatokComboBox.setPreferredSize(new Dimension(200, 40));
		feladatokComboBox.addActionListener(this);

		comboBox.add(feladatokComboBox, new BorderLayout());
		mainPane.add(comboBox);

		input = new JFormattedTextField();
		input.setPreferredSize(new Dimension(50, 10));
		input.addPropertyChangeListener(this);

		runButton = new JButton("Run");
		runButton.addActionListener(this);

		label = new JLabel("Label");

		feladatPane = new JPanel();
		feladatPane.setLayout(new BoxLayout(feladatPane, BoxLayout.PAGE_AXIS));
		feladatPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(""),
				BorderFactory.createEmptyBorder(5, 5,5,5)));
		feladatPane.add(input);
		feladatPane.add(label);
		feladatPane.add(runButton);

		mainPane.add(feladatPane);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Object source = actionEvent.getSource();
		if (source == feladatokComboBox) {
			JComboBox cb = (JComboBox) actionEvent.getSource();
			switch (cb.getSelectedIndex()) {
				case 0: {updateBorderText(StringFel.elsoNagybetuString); break;}
				case 1: {updateBorderText(StringFel.tukorString); break;}
				case 2: {updateBorderText(StringFel.nemBetuString); break;}
				case 3: {updateBorderText(StringFel.csillagNagybetuString); break;}
				case 4: {updateBorderText(StringFel.magMasVegString); break;}
				case 5: {updateBorderText(StringFel.anagrammaString); break;}
				case 6: {updateBorderText(StringFel.szoCsereString); break;}
				case 7: {updateBorderText(StringFel.angolAbcString); break;}
				case 8: {updateBorderText(StringFel.angolAbcHaromCiklusString); break;}
				case 9: {updateBorderText(StringFel.nHosszuSorString); break;}
				case 10: {updateBorderText(StringFel.strForditString); break;}
				case 11: {updateBorderText(StringFel.strTorolString); break;}
				case 12: {updateBorderText(StringFel.strNagybetuString); break;}
				case 13: {updateBorderText(StringFel.strKeresString); break;}
				case 14: {updateBorderText(StringFel.szoEgyesitString); break;}
			}
		}
		else if (source == runButton) {
			switch (feladatokComboBox.getSelectedIndex()) {
				case 0: {updateLabel(StringFel.elsoNagybetu(inputString)); break;}
				case 1: {updateLabel(StringFel.tukor(inputString) ? "Tükörszó!" : "Nem tükörszó!"); break;}
				case 2: {updateLabel(StringFel.nemBetu(inputString)); break;}
				case 3: {updateLabel(StringFel.csillagNagybetu(inputString)); break;}
				case 4: {updateLabel(StringFel.magMasVege(inputString)); break;}
				case 5: {updateLabel(StringFel.anagramma(inputString, inputString2) ? "Anagramma!" : "Nem anagramma!"); break;}
				case 6: {updateLabel(StringFel.szoCsere(inputString, inputString2, inputString3)); break;}
				case 7: {updateLabel(StringFel.angolAbc()); break;}
				case 8: {updateLabel(StringFel.angolAbcHaromCiklus()); break;}
				case 9: {updateLabel(StringFel.nHosszuSor(Integer.parseInt(inputString), inputString2)); break;}
				case 10: {updateLabel(StringFel.strFordit(inputString)); break;}
				case 11: {updateLabel(StringFel.strTorol(inputString)); break;}
				case 12: {updateLabel(StringFel.strNagybetu(inputString)); break;}
				case 13: {updateLabel(StringFel.strKeres(inputString, inputString2)); break;}
				case 14: {updateLabel(StringFel.szoEgyesit(inputString)); break;}

			}
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
		Object source = propertyChangeEvent.getSource();
		if (source == input) {
			inputString = input.getText().trim();
		}
	}

	private void updateLabel(String feladat) {
		label.setText(feladat);
	}

	private void updateBorderText(String text) {
		feladatPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(text),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	}
}
