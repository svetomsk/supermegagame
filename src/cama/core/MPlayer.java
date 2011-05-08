package cama.core;

import cama.core.Judge;
import cama.core.Player;
import cama.gui_cama.Main;
import java.util.Random;

public class MPlayer extends Player {

    private Judge ks;
    private int n_left = 0, n_right = 0, n_straight = 0;
    boolean isGuiGame;

    public MPlayer(Judge ks_from_main, boolean isGui) {
        ks = ks_from_main;
        setModulePlayer(true);
        this.isGuiGame = isGuiGame;
    }

    public void doStep(boolean isWhite) {
        Random r = new Random();
        int count = 0, x, y;
        String[] coord = new String[ks.getSize()], ar = new String[2];
        if (isWhite == true) {
            for (int i = 0; i < ks.getSize(); i++) {
                for (int j = 0; j < ks.getSize(); j++) {
                    if (ks.getCh(i, j) == ks.W) {
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
            for (int i = 0; i < ks.getSize(); i++) {
                for (int j = 0; j < ks.getSize(); j++) {
                    if (ks.getCh(i, j) == ks.B) {
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
        n_left = ks.getCh(i + 1, j - 1);
        n_right = ks.getCh(i + 1, j + 1);
        n_straight = ks.getCh(i + 1, j);

        if (n_left == ks.B) {
            doStep(i, j, i + 1, j - 1, ks.W);
            if (isGuiGame) {
                setIsWhite();
            }
            return true;
        } else if (n_right == ks.B) {
            doStep(i, j, i + 1, j + 1, ks.W);
            if (isGuiGame) {
                setIsWhite();
            }
            return true;
        } else if (n_straight == ks.E) {
            doStep(i, j, i + 1, j, ks.W);
            if (isGuiGame) {
                setIsWhite();
            }
            return true;
        } else {
            return false;
        }
    }
    private boolean doStepBlack(int i, int j) {
        n_left = ks.getCh(i - 1, j - 1);
        n_right = ks.getCh(i - 1, j + 1);
        n_straight = ks.getCh(i - 1, j);
        if (n_left == ks.W) {
            doStep(i, j, i - 1, j - 1, ks.B);
            if (isGuiGame) {
                setIsWhite();
            }
            return true;
        } else if (n_right == ks.W) {
            doStep(i, j, i - 1, j + 1, ks.B);
            if (isGuiGame) {
                setIsWhite();
            }
            return true;
        } else if (n_straight == ks.E) {
            doStep(i, j, i - 1, j, ks.B);
            if (isGuiGame) {
                setIsWhite();
            }
            return true;
        } else {
            return false;
        }
    }

    private void doStep(int x, int y, int x1, int y1, int cell) {
        ks.rewrite(x, y, ks.E);
        ks.rewrite(x1, y1, cell);
    }

    private void setIsWhite() {
        if (Main.isWhite) {
            Main.isWhite = false;
        } else {
            Main.isWhite = true;
        }
    }
}