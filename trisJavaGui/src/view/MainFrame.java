package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Gui Java Tris");
        setSize(800, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon logo = new ImageIcon("src/images/logo.png");
        setIconImage(logo.getImage());

        add(new Home(this));

        setVisible(true);
    }
}
