import javax.swing.*;
import java.awt.*;

public class Frame {

    public Frame() {
        Panel panel = new Panel();
        JFrame frame = new JFrame("Bee Movie");
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}