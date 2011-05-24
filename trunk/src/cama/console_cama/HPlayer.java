package cama.console_cama;

import cama.core.ITextSource;
import java.io.*;
import cama.core.Player;
import cama.core.Texts;
import cama.core.Judge;
import cama.core.Step;

public class HPlayer extends Player{
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public boolean b;
    private Judge judge;
    private Step step;
    private ITextSource textSource;

    public HPlayer(Judge ks_from_main, ITextSource value) {
        judge = ks_from_main;
        textSource = value;
    }

    public void doStep(boolean isWhite) throws IOException{
        Boolean isOk = false;
        while (!isOk) {
            String text = textSource.getStepText();
            int[] ar = validateText(text);
            if(ar!=null){
                isOk = applyStep(ar, isWhite);
            }
        }
    }
    private int[] validateText(String text){

        if (text.equals("exit")) {
            System.exit(0);
        }

        if (text.equals("GK")) {
            System.out.println("Texts.CHEAT1");
            System.exit(0);
        }

        int[] ar = new int[4];
        String s1[], s2[], s3[];
        int x1, x2, y1, y2;
        x1 = x2 = y1 = y2 = 0;
        try {
            s1 = text.split("-");
            s2 = s1[0].split("");
            s3 = s1[1].split("");
            y1 = makeX(s2[1]);
            y2 = makeX(s3[1]);
            x1 = makeY(s2[2]);
            x2 = makeY(s3[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            try {
                bw.write(Texts.ER_TEXT);
                bw.flush();
                return null;
            } catch (IOException one) {
                System.out.println(Texts.IOException);
                return null;
            }
        }

        ar[0]=x1;
        ar[1]=x2;
        ar[2]=y1;
        ar[3]=y2;

        return ar;
    }
    private boolean applyStep(int[] ar, boolean isWhite) throws IOException{
        step = new Step(ar[2], ar[0], ar[3], ar[1]);
        if(judge.isStepCorrect(step, isWhite)){
            judge.handleStep(step, isWhite);
            return true;
        }
        textSource.writeText(Texts.ER_STEP_LN);
        return false;
    }

    private int makeX(String m) {
        int y = 0;
        if (m.equals("a")) {
            y = 0;
        }
        if (m.equals("b")) {
            y = 1;
        }
        if (m.equals("c")) {
            y = 2;
        }
        return y;
    }
    private int makeY(String m) {
        return Integer.valueOf(m) - 1;
    }
}