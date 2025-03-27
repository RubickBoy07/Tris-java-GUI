package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.PlayfieldListener;
import control.UndoListener;
import model.WinController;

public class Game extends JPanel {
    public Game(MainFrame window, Home home) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JLabel title = new JLabel("Play!");

        JPanel playingField = new JPanel();
        JButton btns[][] = new JButton[3][3];

        JPanel sideBt = new JPanel();
        JLabel scoreTtl = new JLabel("Punteggio");
        JLabel sc1 = new JLabel("Giocatore 1: ");
        JLabel sc2 = new JLabel("Giocatore 2: ");
        JButton reset = new JButton("Reset");
        JButton back = new JButton("");
        ImageIcon backArrow = new ImageIcon("src/images/backArrow.png");

        title.setFont(new Font("Arial", Font.BOLD, 100));
        title.setForeground(Color.YELLOW);
        title.setHorizontalAlignment(JLabel.CENTER);

        playingField.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        playingField.setBackground(Color.getColor(getName()));

        WinController winController = new WinController(btns, sc1, sc2);

        PlayfieldListener playfieldListener = new PlayfieldListener(winController);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                btns[r][c] = new JButton("");
                btns[r][c].setPreferredSize(new Dimension(100, 100));
                btns[r][c].setBackground(Color.DARK_GRAY);
                btns[r][c].addActionListener(playfieldListener);
                btns[r][c].putClientProperty("row", r);
                btns[r][c].putClientProperty("col", c);

                gbc.gridx = c;
                gbc.gridy = r;
                gbc.fill = GridBagConstraints.NONE;
                gbc.weightx = 0;
                gbc.weighty = 0;
                gbc.insets = new Insets(10, 10, 10, 10);

                playingField.add(btns[r][c], gbc);
            }
        }

        UndoListener undoListener = new UndoListener(btns, playfieldListener, home, window, winController, sc1, sc2);

        sideBt.setLayout(new GridBagLayout());
        GridBagConstraints sideGbc = new GridBagConstraints();
        sideBt.setBackground(Color.getColor(getName()));
        sideBt.setPreferredSize(new Dimension(300, 10));
        sideBt.setAlignmentX(Component.RIGHT_ALIGNMENT);

        scoreTtl.setFont(new Font("Arial", Font.BOLD, 30));
        scoreTtl.setForeground(Color.BLUE);
        scoreTtl.setHorizontalAlignment(JLabel.LEFT);

        sc1.setForeground(Color.WHITE);
        sc1.setFont(new Font("Arial", Font.BOLD, 20));
        sc1.setHorizontalAlignment(JLabel.LEFT);

        sc2.setForeground(Color.WHITE);
        sc2.setFont(new Font("Arial", Font.BOLD, 20));
        sc2.setHorizontalAlignment(JLabel.LEFT);

        reset.setBackground(Color.MAGENTA);
        reset.setForeground(Color.WHITE);
        reset.setFont(new Font("Arial", Font.BOLD, 30));
        reset.addActionListener(undoListener);

        Dimension backSize = new Dimension(10, 10);
        back.setBackground(Color.MAGENTA);
        back.setIcon(backArrow);
        back.setPreferredSize(backSize);
        back.setMinimumSize(backSize);
        back.addActionListener(undoListener);
        back.setMaximumSize(backSize);

        sideGbc.gridx = 0;
        sideGbc.gridy = 0;
        sideGbc.gridwidth = 2;
        sideGbc.gridheight = 1;
        sideGbc.weightx = 1.0;
        sideGbc.weighty = 0.0;
        sideGbc.fill = GridBagConstraints.BOTH;
        sideGbc.anchor = GridBagConstraints.NORTHWEST;
        sideGbc.insets = new Insets(0, 0, 10, 0);
        sideBt.add(scoreTtl, sideGbc);

        sideGbc.gridx = 0;
        sideGbc.gridy = 1;
        sideGbc.gridwidth = 1;
        sideGbc.gridheight = 1;
        sideGbc.weightx = 0.0;
        sideGbc.weighty = 0.0;
        sideGbc.fill = GridBagConstraints.BOTH;
        sideGbc.anchor = GridBagConstraints.EAST;
        sideGbc.insets = new Insets(10, 0, 10, 5);
        sideBt.add(sc1, sideGbc);

        sideGbc.gridx = 0;
        sideGbc.gridy = 2;
        sideGbc.weightx = 0.0;
        sideGbc.weighty = 0.0;
        sideGbc.fill = GridBagConstraints.BOTH;
        sideGbc.anchor = GridBagConstraints.NORTHEAST;
        sideGbc.insets = new Insets(10, 0, 10, 5);
        sideBt.add(sc2, sideGbc);

        sideGbc.gridx = 0;
        sideGbc.gridy = 3;
        sideGbc.weightx = 0.0;
        sideGbc.weighty = 0.0;
        sideGbc.fill = GridBagConstraints.BOTH;
        sideGbc.anchor = GridBagConstraints.EAST;
        sideGbc.insets = new Insets(0, 0, 0, 0);
        sideBt.add(reset, sideGbc);

        sideGbc.gridx = 1;
        sideGbc.gridy = 3;
        sideGbc.gridwidth = 1;
        sideGbc.gridheight = 1;
        sideGbc.weightx = 0.0;
        sideGbc.weighty = 0.0;
        sideGbc.fill = GridBagConstraints.BOTH;
        sideGbc.anchor = GridBagConstraints.CENTER;
        sideGbc.insets = new Insets(0, 20, 0, 100);
        sideBt.add(back, sideGbc);

        JPanel cleanPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Dimension cleanSize = new Dimension(100, 50);
        JButton clean = new JButton("Pulisci");
        clean.addActionListener(undoListener);
        clean.setBackground(Color.CYAN);
        clean.setForeground(Color.BLACK);
        clean.setPreferredSize(cleanSize);
        clean.setFont(new Font("Arial", Font.BOLD, 20));
        cleanPanel.add(clean);
        cleanPanel.setBackground(Color.getColor(getName()));
        

        add(title, BorderLayout.PAGE_START);
        add(playingField, BorderLayout.CENTER);
        add(sideBt, BorderLayout.EAST);
        add(cleanPanel, BorderLayout.SOUTH);
    }
}
