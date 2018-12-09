package azyrus66;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {
	private JFrame frame;
	private GuiFeladatok guiFeladatok;
	private GuiGMap guiGMap;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem feladatokItem, gMapItem;

	public Gui() {
		frame = new JFrame("Frame");
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(350, 500));
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setBackground(new Color(0x3B3E40));
		menuBar.setPreferredSize(new Dimension(200, 20));

		fileMenu = new JMenu("File");
		fileMenu.setForeground(Color.WHITE);

		feladatokItem = new JMenuItem("Feladatok");
		feladatokItem.setOpaque(true);
		feladatokItem.setBackground(Color.LIGHT_GRAY);
		feladatokItem.addActionListener(this);

		gMapItem = new JMenuItem("Térkép");
		gMapItem.setOpaque(true);
		gMapItem.setBackground(Color.LIGHT_GRAY);
		gMapItem.addActionListener(this);

		fileMenu.add(feladatokItem);
		fileMenu.add(gMapItem);

		menuBar.add(fileMenu);

		frame.setJMenuBar(menuBar);

		guiFeladatok = new GuiFeladatok();
		guiFeladatok.mainPane.setOpaque(true);
		frame.setContentPane(guiFeladatok.mainPane);

		guiGMap = new GuiGMap();
		guiGMap.mainPane.setOpaque(true);


		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Object source = actionEvent.getSource();

		if (source == feladatokItem) {
			frame.setContentPane(guiFeladatok.mainPane);
			frame.repaint();
			guiFeladatok.mainPane.updateUI();
		}
		if (source == gMapItem) {
			frame.setContentPane(guiGMap.mainPane);
			frame.repaint();
			guiGMap.mainPane.updateUI();
		}
	}
}