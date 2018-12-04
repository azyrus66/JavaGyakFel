package azyrus66;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        StringFel stringFel = new StringFel();
        MatekFel matekFel = new MatekFel();

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(() -> {
            Gui gui = new Gui();
            gui.setVisible(true);
        });

		//stringFel.StringFel();
        //matekFel.MatekFel();
    }
}
