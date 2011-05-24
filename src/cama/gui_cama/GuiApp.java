package cama.gui_cama;

import java.io.*;
import cama.core.IPlayer;
import cama.core.MPlayer;
import cama.core.Judge;
import cama.console_cama.Console;
import cama.core.Texts;

public class GuiApp {
    private IPlayer player1;
    private IPlayer player2;
    private Judge judge;
    private Console console;
    private int i;
    private boolean isSomebodyWon;

    public GuiApp(Judge judge, Console console, IPlayer pl1, IPlayer pl2){
        this.judge = judge;
        this.console = console;
        this.player1 = pl1;
        this.player2 = pl2;
    }

    public void run() {
        try {
            while (!isSomebodyWon) {
                if (i == 0) {
                    console.printDoStep(player1);
                    player1.doStep(true);
                    console.printField();
                    if (judge.checkIfSomeoneWon(true)) {
                        isSomebodyWon = true;
                    }
                    i = 1;
                } else {
                    console.printDoStep(player2);
                    player2.doStep(false);
                    console.printField();
                    if (judge.checkIfSomeoneWon(false) == true) {
                        isSomebodyWon = true;
                    }
                    i = 0;
                }
            }
        } catch (IOException e) {
            System.out.println(Texts.IOException);
        }

        try {
            judge.finish();
        } catch (IOException exc) {
            System.out.println(Texts.IOException);
        }
        
    }
}
