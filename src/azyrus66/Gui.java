package azyrus66;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {
	private JFrame frame;
	private GuiFeladatok guiFeladatok;
	private JMenuBar menuBar;
	private JMenu fileMenu, viewMenu, designSubMenu, feladatokSubMenu;
	private JMenuItem gMapItem, designSystemItem, designJavaItem, designNimbusItem, feladatokStringItem, feladatokMatekItem;
	private static final Color DARK_GRAY = new Color(0x3B3E40);

	public Gui() {
		frame = new JFrame(Main.guiBundle.getString("frame_Title"));
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(350, 500));
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setBackground(DARK_GRAY);
		menuBar.setPreferredSize(new Dimension(200, 20));

		fileMenu = new JMenu(Main.guiBundle.getString("menu_file"));
		fileMenu.setOpaque(true);
		fileMenu.setBackground(DARK_GRAY);
		fileMenu.setForeground(Color.WHITE);

		feladatokSubMenu = new JMenu(Main.guiBundle.getString("subMenu_tasks"));
		feladatokSubMenu.setOpaque(true);
		feladatokSubMenu.setBackground(DARK_GRAY);
		feladatokSubMenu.setForeground(Color.WHITE);

		feladatokStringItem = new JMenuItem(Main.guiBundle.getString("item_tasks_string"));
		paintComponent(feladatokStringItem, DARK_GRAY, Color.WHITE);
		feladatokStringItem.addActionListener(this);
		feladatokSubMenu.add(feladatokStringItem);

		feladatokMatekItem = new JMenuItem(Main.guiBundle.getString("item_tasks_math"));
		paintComponent(feladatokMatekItem, DARK_GRAY, Color.WHITE);
		feladatokMatekItem.addActionListener(this);
		feladatokSubMenu.add(feladatokMatekItem);

		fileMenu.add(feladatokSubMenu);

		menuBar.add(fileMenu);

		viewMenu = new JMenu(Main.guiBundle.getString("menu_view"));
		viewMenu.setOpaque(true);
		viewMenu.setBackground(DARK_GRAY);
		viewMenu.setForeground(Color.WHITE);

		designSubMenu = new JMenu(Main.guiBundle.getString("subMenu_design"));
		designSubMenu.setOpaque(true);
		designSubMenu.setBackground(DARK_GRAY);
		designSubMenu.setForeground(Color.WHITE);

		designSystemItem = new JMenuItem(Main.guiBundle.getString("item_design_system"));
		paintComponent(designSystemItem, DARK_GRAY, Color.WHITE);
		designSystemItem.addActionListener(this);
		designSubMenu.add(designSystemItem);

		designJavaItem = new JMenuItem(Main.guiBundle.getString("item_design_java"));
		paintComponent(designJavaItem, DARK_GRAY, Color.WHITE);
		designJavaItem.addActionListener(this);
		designSubMenu.add(designJavaItem);

		designNimbusItem = new JMenuItem(Main.guiBundle.getString("item_design_nimbus"));
		paintComponent(designNimbusItem, DARK_GRAY, Color.WHITE);
		designNimbusItem.addActionListener(this);
		designSubMenu.add(designNimbusItem);

		viewMenu.add(designSubMenu);
		menuBar.add(viewMenu);

		frame.setJMenuBar(menuBar);

		guiFeladatok = new GuiFeladatok();
		guiFeladatok.mainPane.setOpaque(true);
		frame.setContentPane(guiFeladatok.mainPane);

		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Object source = actionEvent.getSource();

		if (source == feladatokStringItem) {
			frame.setContentPane(guiFeladatok.mainPane);
			frame.repaint();
			guiFeladatok.mainPane.updateUI();
		}
		if (source == designSystemItem) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
				e.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(frame);
		}
		if (source == designJavaItem) {
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(frame);
		}
		if (source == designNimbusItem) {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(frame);
		}
	}

	private void paintComponent(JComponent name, Color bground, Color fground) {
		name.setOpaque(true);
		name.setBackground(bground);
		name.setForeground(fground);
	}
}