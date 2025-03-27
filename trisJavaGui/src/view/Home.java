package view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.HomeListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

public class Home extends JPanel {
    public Home(MainFrame window) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JLabel title = new JLabel("Gui Java Tris");
        JPanel btns = new JPanel();
        JButton gioca = new JButton("Gioca");
        JButton esci = new JButton("Esci");
        Dimension btnSize = new Dimension(200, 100);
        HomeListener homeListener = new HomeListener(window, this);

        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Arial", Font.BOLD, 100));

        btns.setBackground(Color.getColor(getName()));
        btns.setLayout(new BoxLayout(btns, BoxLayout.Y_AXIS));
        btns.add(Box.createVerticalStrut(120));

        gioca.setBackground(Color.GREEN);
        gioca.setForeground(Color.BLACK);
        gioca.setFont(new Font("Arial", Font.BOLD, 50));
        gioca.setPreferredSize(btnSize);
        gioca.setMinimumSize(btnSize);
        gioca.setMaximumSize(btnSize);
        gioca.setAlignmentX(Component.CENTER_ALIGNMENT);
        gioca.addActionListener(homeListener);
        btns.add(gioca);

        btns.add(Box.createVerticalStrut(100));

        esci.setBackground(Color.RED);
        esci.setForeground(Color.BLACK);
        esci.setFont(new Font("Arial", Font.BOLD, 50));
        esci.setPreferredSize(btnSize);
        esci.setMinimumSize(btnSize);
        esci.setMaximumSize(btnSize);
        esci.setAlignmentX(Component.CENTER_ALIGNMENT);
        esci.addActionListener(homeListener);
        btns.add(esci);

        add(title, BorderLayout.PAGE_START);
        add(btns, BorderLayout.CENTER);
    }
}
