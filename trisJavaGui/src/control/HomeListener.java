package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.Game;
import view.Home;
import view.MainFrame;

public class HomeListener implements ActionListener {
    private MainFrame window;
    private Game game;
    private Home home;

    public HomeListener(MainFrame window, Home home) {
        this.window = window;
        this.home = home;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() instanceof JButton) {
            if(((JButton)e.getSource()).getText().equalsIgnoreCase("esci")) {
                System.exit(0);
            } else {
                this.game = new Game(window, home);
                window.remove(window.getContentPane().getComponent(0));
                window.add(game);
                window.revalidate();
                window.repaint();
            }
        }    
    }
    
}
