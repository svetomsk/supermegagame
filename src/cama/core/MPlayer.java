package cama.core;

import cama.gui_cama.OldMain;
import java.util.Random;
import java.io.*;

public class MPlayer extends Player {

    private Judge judge;
    private Step step;
    private int n_left = 0, n_right = 0, n_straight = 0;
    boolean isGuiGame;

    public MPlayer(Judge ks_from_main, boolean isGui) {
        judge = ks_from_main;
        setModulePlayer(true);
        this.isGuiGame = isGuiGame;
    }

    public void doStep(boolean isWhite) {
        Random r = new Random();
        int count = 0, x, y;
        String[] coord = new String[judge.getSize()], ar = new String[2];
        if (isWhite == true) {
            for (int i = 0; i < judge.getSize(); i++) {
                for (int j = 0; j < judge.getSize(); j++) {
                    if (judge.getCell(i, j) == judge.W) {
                        coord[count] = i + " " + j;
                        count++;
                    }
                }
            }

            for (;;) {
                ar = coord[r.nextInt(count)].split(" ");
                x = Integer.valueOf(ar[0]);
                y = Integer.valueOf(ar[1]);

                if (doStepWhite(x, y)) {
                    break;
                }

            }
        } else {
            for (int i = 0; i < judge.getSize(); i++) {
                for (int j = 0; j < judge.getSize(); j++) {
                    if (judge.getCell(i, j) == judge.B) {
                        coord[count] = i + " " + j;
                        count++;
                    }
                }
            }
            for (;;) {
                ar = coord[r.nextInt(count)].split(" ");
                x = Integer.valueOf(ar[0]);
                y = Integer.valueOf(ar[1]);

                if (doStepBlack(x, y)) {
                    break;
                }
            }
        }
    }

    private boolean doStepWhite(int i, int j) {
        n_left = judge.getCell(i + 1, j - 1);
        n_right = judge.getCell(i + 1, j + 1);
        n_straight = judge.getCell(i + 1, j);

        if (n_left == judge.B) {
            doStep(i, j, i + 1, j - 1, true);
            if (isGuiGame) {
                //setIsWhite();
            }
            return true;
        } else if (n_right == judge.B) {
            doStep(i, j, i + 1, j + 1, true);
            if (isGuiGame) {
                //setIsWhite();
            }
            return true;
        } else if (n_straight == judge.E) {
            doStep(i, j, i + 1, j, true);
            if (isGuiGame) {
                //setIsWhite();
            }
            return true;
        } else {
            return false;
        }
    }
    private boolean doStepBlack(int i, int j) {
        n_left = judge.getCell(i - 1, j - 1);
        n_right = judge.getCell(i - 1, j + 1);
        n_straight = judge.getCell(i - 1, j);
        if (n_left == judge.W) {
            doStep(i, j, i - 1, j - 1, false);
            if (isGuiGame) {
                //setIsWhite();
            }
            return true;
        } else if (n_right == judge.W) {
            doStep(i, j, i - 1, j + 1, false);
            if (isGuiGame) {
                //setIsWhite();
            }
            return true;
        } else if (n_straight == judge.E) {
            doStep(i, j, i - 1, j, false);

            if (isGuiGame) {
                //setIsWhite();
            }
            return true;
        } else {
            return false;
        }
    }

    private void doStep(int x, int y, int x1, int y1, boolean isWhite) {
        step = new Step(y, x, y1, x1);
        judge.handleStep(step, isWhite);
    }

//    private void setIsWhite() {
//        if (OldMain.isWhite) {
//            OldMain.isWhite = false;
//        } else {
//            OldMain.isWhite = true;
//        }
//    }
}
