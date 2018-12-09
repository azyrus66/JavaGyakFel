package azyrus66;

import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

	private static Locale huLocale = new Locale("hu");
	static ResourceBundle guiBundle = ResourceBundle.getBundle("azyrus66.gui", huLocale);

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        SwingUtilities.invokeLater(() -> {
            Gui gui = new Gui();
        });
    }
}
