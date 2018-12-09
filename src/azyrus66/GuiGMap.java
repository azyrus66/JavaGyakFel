package azyrus66;

import javax.swing.*;
import java.awt.*;

public class GuiGMap {

    JPanel mainPane;
    private JButton button;

    public GuiGMap() {
        mainPane = new JPanel();
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
        mainPane.setBackground(Color.DARK_GRAY);
        mainPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        button = new JButton("test");

        mainPane.add(button);
    }
}
