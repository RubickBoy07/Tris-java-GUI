package view;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Gui Java Tris");
        setSize(800, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        URL logoRes = getClass().getResource("/images/logo.png");
        ImageIcon logo = new ImageIcon(logoRes);
        setIconImage(logo.getImage());

        add(new Home(this));

        setVisible(true);
    }
}
