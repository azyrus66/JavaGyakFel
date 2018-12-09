package azyrus66;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GuiFeladatok implements ActionListener, PropertyChangeListener {
	JPanel mainPane;
	private JPanel feladatPane, inputPane, comboBoxPane, outputPane;
	private JComboBox<String> feladatokComboBox;
	private TitledBorder titledBorder;
	private JTextArea label;
	private JButton runButton;
	private JFormattedTextField input, input2, input3;
	private static String inputString, inputString2, inputString3;

	public GuiFeladatok() {
		mainPane = new JPanel();
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
		mainPane.setBackground(Color.DARK_GRAY);
		mainPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		comboBoxPane = new JPanel();
		comboBoxPane.setLayout(new BoxLayout(comboBoxPane, BoxLayout.PAGE_AXIS));
		comboBoxPane.setBackground(Color.DARK_GRAY);

		String[] feladatok = new String[16];
		feladatok[0] = "Válaszd ki a feladatot!";
		for (int i = 1; i <= 15; i++) {
			feladatok[i] = (i + ". feladat");
		}
		feladatokComboBox = new JComboBox<>(feladatok);
		feladatokComboBox.setBackground(Color.LIGHT_GRAY);
		feladatokComboBox.setMaximumSize(new Dimension(400, 40));
		feladatokComboBox.setMinimumSize(new Dimension(200, 40));
		feladatokComboBox.addActionListener(this);

		comboBoxPane.add(feladatokComboBox);

		feladatPane = new JPanel();
		feladatPane.setLayout(new BoxLayout(feladatPane, BoxLayout.PAGE_AXIS));
		feladatPane.setMaximumSize(new Dimension(400, 400));
		feladatPane.setBackground(Color.DARK_GRAY);
		titledBorder = BorderFactory.createTitledBorder("");
		titledBorder.setTitleColor(Color.WHITE);
		feladatPane.setBorder(BorderFactory.createCompoundBorder(titledBorder, BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		inputPane = new JPanel();
		inputPane.setLayout(new BoxLayout(inputPane, BoxLayout.PAGE_AXIS));
		inputPane.setMaximumSize(new Dimension(400, 130));
		inputPane.setMinimumSize(new Dimension(200, 130));
		inputPane.setBackground(Color.DARK_GRAY);

		input = new JFormattedTextField();
		input.setEditable(false);
		input.addPropertyChangeListener(this);

		input2 = new JFormattedTextField();
		input2.setEditable(false);
		input2.addPropertyChangeListener(this);

		input3 = new JFormattedTextField();
		input3.setEditable(false);
		input3.addPropertyChangeListener(this);

		inputPane.add(input);
		inputPane.add(input2);
		inputPane.add(input3);

		outputPane = new JPanel();
		outputPane.setLayout(new BorderLayout());
		outputPane.setMaximumSize(new Dimension(400, feladatPane.getMaximumSize().height));
		outputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		outputPane.setBackground(Color.LIGHT_GRAY);

		runButton = new JButton("Run");
		runButton.setContentAreaFilled(true);
		runButton.addActionListener(this);

		label = new JTextArea();
		label.setLineWrap(true);
		label.setEditable(false);
		label.setAutoscrolls(true);
		label.setBackground(Color.LIGHT_GRAY);

		outputPane.add(label, BorderLayout.PAGE_START);
		outputPane.add(Box.createRigidArea(new Dimension(0, 5)));
		outputPane.add(runButton, BorderLayout.PAGE_END);


		feladatPane.add(inputPane);
		feladatPane.add(Box.createRigidArea(new Dimension(0, 5)));
		feladatPane.add(outputPane);


		mainPane.add(comboBoxPane);
		mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
		mainPane.add(feladatPane);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Object source = actionEvent.getSource();
		if (source == feladatokComboBox) {
			JComboBox cb = (JComboBox) actionEvent.getSource();
			switch (cb.getSelectedIndex()) {
				case 1: {updateBorderText(StringFel.elsoNagybetuString); setEditable(1); break;}
				case 2: {updateBorderText(StringFel.tukorString); setEditable(1); break;}
				case 3: {updateBorderText(StringFel.nemBetuString); setEditable(1); break;}
				case 4: {updateBorderText(StringFel.csillagNagybetuString); setEditable(1); break;}
				case 5: {updateBorderText(StringFel.magMasVegString); setEditable(1); break;}
				case 6: {updateBorderText(StringFel.anagrammaString); setEditable(2); break;}
				case 7: {updateBorderText(StringFel.szoCsereString); setEditable(3); break;}
				case 8: {updateBorderText(StringFel.angolAbcString); setEditable(0); break;}
				case 9: {updateBorderText(StringFel.angolAbcHaromCiklusString); setEditable(0); break;}
				case 10: {updateBorderText(StringFel.nHosszuSorString); setEditable(2); break;}
				case 11: {updateBorderText(StringFel.strForditString); setEditable(1); break;}
				case 12: {updateBorderText(StringFel.strTorolString); setEditable(1); break;}
				case 13: {updateBorderText(StringFel.strNagybetuString); setEditable(1); break;}
				case 14: {updateBorderText(StringFel.strKeresString); setEditable(2); break;}
				case 15: {updateBorderText(StringFel.szoEgyesitString); setEditable(1); break;}
			}
		}
		if (source == runButton) {
			if (!inputString.isEmpty()) {
				switch (feladatokComboBox.getSelectedIndex()) {
					case 1: {updateLabel(StringFel.elsoNagybetu(inputString)); break;}
					case 2: {updateLabel(StringFel.tukor(inputString) ? "Tükörszó!" : "Nem tükörszó!"); break;}
					case 3: {updateLabel(StringFel.nemBetu(inputString)); break;}
					case 4: {updateLabel(StringFel.csillagNagybetu(inputString)); break;}
					case 5: {updateLabel(StringFel.magMasVege(inputString)); break;}
					case 11: {updateLabel(StringFel.strFordit(inputString)); break;}
					case 12: {updateLabel(StringFel.strTorol(inputString)); break;}
					case 13: {updateLabel(StringFel.strNagybetu(inputString)); break;}
					case 15: {updateLabel(StringFel.szoEgyesit(inputString)); break;}
				}
			}

			if (!inputString.isEmpty() && !inputString2.isEmpty()) {
				switch (feladatokComboBox.getSelectedIndex()) {
					case 6: {updateLabel(StringFel.anagramma(inputString, inputString2) ? "Anagramma!" : "Nem anagramma!"); break;}
					case 10: {updateLabel(StringFel.nHosszuSor(Integer.parseInt(inputString), inputString2)); break;}
					case 14: {updateLabel(StringFel.strKeres(inputString, inputString2)); break;}
				}
			}

			if (!inputString.isEmpty() && !inputString2.isEmpty() && !inputString3.isEmpty() && feladatokComboBox.getSelectedIndex() == 7) {
				updateLabel(StringFel.szoCsere(inputString, inputString2, inputString3));
			}

			switch (feladatokComboBox.getSelectedIndex()) {
				case 8: {updateLabel(StringFel.angolAbc()); break;}
				case 9: {updateLabel(StringFel.angolAbcHaromCiklus()); break;}
			}

			if ((input.isEditable() && inputString.isEmpty()) ||
					(input2.isEditable() && inputString2.isEmpty()) || (input3.isEditable() && inputString3.isEmpty())) {
				JOptionPane.showMessageDialog(mainPane, "Nem lehet üres!");
			}
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
		Object source = propertyChangeEvent.getSource();
		if (source == input) {
			inputString = input.getText().trim();
		}
		if (source == input2) {
			inputString2 = input2.getText().trim();
		}
		if (source == input3) {
			inputString3 = input3.getText().trim();
		}
	}

	private void updateLabel(String feladat) {
		label.setText(feladat);
	}

	private void updateBorderText(String text) {
		titledBorder.setTitle(text);
		feladatPane.updateUI();
	}

	private void setEditable(int numOfFields) {
		switch (numOfFields) {
			case 0: {
				input.setEditable(false);
				input2.setEditable(false);
				input3.setEditable(false);
				break;
			}
			case 1: {
				input.setEditable(true);
				input2.setEditable(false);
				input3.setEditable(false);
				break;
			}
			case 2: {
				input.setEditable(true);
				input2.setEditable(true);
				input3.setEditable(false);
				break;
			}
			case 3: {
				input.setEditable(true);
				input2.setEditable(true);
				input3.setEditable(true);
				break;
			}
		}
		if (!input.isEditable()) input.setText(null);
		if (!input2.isEditable()) input2.setText(null);
		if (!input3.isEditable()) input3.setText(null);
	}
}
