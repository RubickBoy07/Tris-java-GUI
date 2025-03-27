package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import model.WinController;
import view.Home;
import view.MainFrame;

public class UndoListener implements ActionListener {
    private JButton[][] btns;
    private PlayfieldListener playfieldListener;
    private Home home;
    private MainFrame window;
    private WinController winController;
    private JLabel sc1;
    private JLabel sc2;

    public UndoListener(JButton[][] btns, PlayfieldListener playfieldListener, Home home, MainFrame window, WinController winController, JLabel sc1, JLabel sc2) {
        this.btns = btns;
        this.home = home;
        this.window = window;
        this.playfieldListener = playfieldListener;
        this.winController = winController;
        this.sc1 = sc1;
        this.sc2 = sc2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() instanceof JButton) {
            if (((JButton) e.getSource()).getText().equalsIgnoreCase("pulisci")) {
                for (int i = 0; i < btns.length; i++) {
                    for (int j = 0; j < btns[i].length; j++) {
                        btns[i][j].setIcon(null);
                        btns[i][j].setBackground(Color.DARK_GRAY);
                        btns[i][j].setDisabledIcon(null);
                        btns[i][j].setEnabled(true);
                    }
                }

                playfieldListener.setI(0);
                winController.clean();
            } else if (((JButton) e.getSource()).getText().equalsIgnoreCase("reset")) {
                for (int i = 0; i < btns.length; i++) {
                    for (int j = 0; j < btns[i].length; j++) {
                        btns[i][j].setIcon(null);
                        btns[i][j].setBackground(Color.DARK_GRAY);
                        btns[i][j].setDisabledIcon(null);
                        btns[i][j].setEnabled(true);
                    }
                }

                winController.clean();
                winController.setScore1(0);
                winController.setScore2(0);
                this.sc1.setText(this.sc1.getText().substring(0, this.sc1.getText().indexOf(":") + 1) + " 0");
                this.sc2.setText(this.sc2.getText().substring(0, this.sc2.getText().indexOf(":") + 1) + " 0");
                playfieldListener.setI(0);
            } else {
                window.remove(window.getContentPane().getComponent(0));
                window.add(home);
                window.revalidate();
                window.repaint();
            }
        }
    }

}
