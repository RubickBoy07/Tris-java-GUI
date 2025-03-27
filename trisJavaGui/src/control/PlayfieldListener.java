package control;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.WinController;

public class PlayfieldListener implements ActionListener {
    private ImageIcon cross = new ImageIcon("src/images/cross.png");
    private Image crossResize = cross.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    private ImageIcon crossResized = new ImageIcon(crossResize);
    private ImageIcon circle = new ImageIcon("src/images/circle.png");
    private Image circleResize = circle.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    private ImageIcon circleResized = new ImageIcon(circleResize);
    private int i = 0;
    private WinController winController;

    public PlayfieldListener(WinController winController) {
        this.winController = winController;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() instanceof JButton) {
            if (((JButton) e.getSource()).getIcon() == null) {
                if (i % 2 == 0) {
                    ((JButton) e.getSource()).setIcon(crossResized);
                } else {
                    ((JButton) e.getSource()).setIcon(circleResized);
                }

                i++;

                this.winController.setCell((int)((JButton)e.getSource()).getClientProperty("row"), (int)((JButton)e.getSource()).getClientProperty("col") , i);
                this.winController.checkWin();
            }
        }
    }

}
