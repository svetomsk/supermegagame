package cama.console_cama;

import java.io.*;
import cama.core.Judge;
import cama.core.IPlayer;
import cama.core.Console;

public class ConsoleApp {
    private IPlayer pl1;
    private IPlayer pl2;
    private Judge judge;
    private Console console;
    private int i;
    private boolean isSomebodyWon;
    
    public ConsoleApp(Judge judge, Console console, IPlayer pl1, IPlayer pl2){
        this.judge = judge;
        this.console = console;
        this.pl1 = pl1;
        this.pl2 = pl2;
        i = 0;
        isSomebodyWon = false;
    }

    public void run() throws IOException{
        try {
            while (!isSomebodyWon) {
                if (i == 0) {
                    console.printDoStep(pl1);
                    pl1.doStep(true);
                    console.printField();
                    if (judge.checkIfSomeoneWon(true)) {
                        isSomebodyWon = true;
                    }
                    i = 1;
                } else {
                    console.printDoStep(pl2);
                    pl2.doStep(false);
                    console.printField();
                    if (judge.checkIfSomeoneWon(false) == true) {
                        isSomebodyWon = true;
                    }
                    i = 0;
                }
            }
        } catch (IOException e) {
            System.out.println("FATAL ERROR!");
        }


        judge.finish();
    }

}
