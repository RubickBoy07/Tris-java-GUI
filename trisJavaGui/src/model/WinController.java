package model;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;

public class WinController {
    private int score1 = 0;
    private int score2 = 0;
    private int camp[][] = new int[3][3];
    private JButton btns[][];
    private JLabel sc1;
    private JLabel sc2;

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public WinController(JButton btns[][], JLabel sc1, JLabel sc2) {
        this.score1 = 0;
        this.score2 = 0;
        this.btns = btns;
        this.sc1 = sc1;
        this.sc2 = sc2;        

        for (int i = 0; i < this.camp.length; i++) {
            for (int j = 0; j < this.camp.length; j++) {
                this.camp[i][j] = 0;
            }
        }
    }

    public void setCell(int x, int y, int id) {
        if (id % 2 == 0) {
            this.camp[x][y] = 1;
        } else {
            this.camp[x][y] = -1;
        }
    }

    public void clean() {
        for (int i = 0; i < this.camp.length; i++) {
            for (int j = 0; j < this.camp.length; j++) {
                this.camp[i][j] = 0;
            }
        }
    }

    public int checkRows() {
        int r = -1;

        for (int i = 0; i < this.camp.length; i++) {
            for (int j = 0; j < this.camp.length; j++) {
                if (this.camp[i][0] == this.camp[i][1] && this.camp[i][1] == this.camp[i][2] && this.camp[i][0] != 0) {
                    r = i;
                }
            }
        }

        return r;
    }

    public int checkColumns() {
        int c = -1;

        for (int i = 0; i < this.camp.length; i++) {
            for (int j = 0; j < this.camp.length; j++) {
                if (this.camp[0][j] == this.camp[1][j] && this.camp[1][j] == this.camp[2][j] && this.camp[0][j] != 0) {
                    c = j;
                }
            }
        }

        return c;
    }

    public int checkDiag() {
        int d = -1;

        if (this.camp[0][0] == this.camp[1][1] && this.camp[1][1] == this.camp[2][2] && this.camp[0][0] != 0) {
            d = 0;
        } else if (this.camp[0][2] == this.camp[1][1] && this.camp[1][1] == this.camp[2][0] && this.camp[0][2] != 0) {
            d = 1;
        }

        return d;
    }

    public boolean checkFull() {
        boolean full = true;

        for (int i = 0; i < this.camp.length; i++) {
            for (int j = 0; j < this.camp.length; j++) {
                if (this.camp[i][j] == 0) {
                    full = false;
                }
            }
        }

        return full;
    }

    public int checkWin() {
        int winner = 0;

        if (checkRows() != -1) {
            for (int i = 0; i < this.camp.length; i++) {
                this.btns[checkRows()][i].setBackground(Color.GREEN);
            }

            if (this.camp[checkRows()][0] == 1) {
                winner = 1;
            } else {
                winner = -1;
            }
        } else if (checkColumns() != -1) {
            for (int i = 0; i < this.camp.length; i++) {
                this.btns[i][checkColumns()].setBackground(Color.GREEN);
            }

            if (this.camp[0][checkColumns()] == 1) {
                winner = 1;
            } else {
                winner = -1;
            }
        } else if (checkDiag() != -1) {
            if (checkDiag() == 0) {
                for (int i = 0; i < this.camp.length; i++) {
                    this.btns[i][i].setBackground(Color.GREEN);
                }

                if (this.camp[0][0] == 1) {
                    winner = 1;
                } else {
                    winner = -1;
                }
            } else if (checkDiag() == 1) {
                for (int i = 0; i < this.camp.length; i++) {
                    this.btns[i][this.camp.length - i - 1].setBackground(Color.GREEN);
                }

                if (this.camp[0][2] == 1) {
                    winner = 1;
                } else {
                    winner = -1;
                }
            }
        } else {
            if (checkFull() == true) {
                for (int i = 0; i < this.btns.length; i++) {
                    for (int j = 0; j < this.btns.length; j++) {
                        this.btns[i][j].setBackground(Color.YELLOW);
                    }
                }
            }

            winner = 0;
        }

        if(winner == 1) {
            score1++;

            this.sc1.setText(sc1.getText().substring(0, sc1.getText().length() - 1) + " " + score1);            
        } else  if(winner == -1) {
            score2++;

            this.sc2.setText(sc2.getText().substring(0, sc1.getText().length() - 1) + " " + score2);
        }

        return winner;
    }
}