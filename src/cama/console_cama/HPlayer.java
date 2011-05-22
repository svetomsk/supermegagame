package cama.console_cama;

import cama.core.ITextSource;
import java.io.*;
import cama.core.Player;
import cama.core.Texts;
import cama.core.Judge;
import cama.core.Step;

public class HPlayer extends Player
{
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public boolean b;
    private Judge judge;
    private Step step;

    public HPlayer(Judge ks_from_main) {
        judge = ks_from_main;
    }

    public void doStep(boolean isWhite) {
        step = null;
        try {
            step = getStepFromKeyboard(isWhite);
        } catch (IOException e) {
            System.out.println("InputOutputException!! TOTAL FAIL!!!");
            System.exit(1);
        }

        judge.handleStep(step, isWhite);
    }
    private Step getStepFromKeyboard(boolean isWhite) throws IOException{
        Step st = null;
        while (st == null){
          String str = br.readLine();
          st = parseStr(str);


          if(st == null){
              bw.write(Texts.ER_TEXT);
              bw.flush();
              continue;
          }

          if(!judge.isStepCorrect(st, isWhite)){
              st = null;
              bw.write(Texts.ER_STEP_LN);
              bw.flush();
          }
       }
       return st;
    }
    private Step parseStr(String s){
        Step st = null;

        if(s.equals("exit")){
            System.exit(0);
        }

        if (s.equals("GK")) {
            System.out.println("Texts.CHEAT1");
            System.exit(0);
        }


        String s1[], s2[], s3[];
        int x1, x2, y1, y2;
        x1 = x2 = y1 = y2 = 0;
        try {
            s1 = s.split("-");
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
                System.exit(0);
            }
        }

        st = new Step(y1, x1, y2, x2);
        return st;
    }

    private int makeX(String m){
        int y=0;
        if(m.equals("a"))     y = 0;
        if(m.equals("b"))     y = 1;
        if(m.equals("c"))     y = 2;
        return y;
    }
    private int makeY(String m){
        return Integer.valueOf(m)-1;
    }

    /*************************************/
    private ITextSource textSource;

    public void setTextSource(ITextSource value){
        textSource = value;
    }

    public void NEWDoStep(boolean isWhite) {
        Boolean isOk = false;
        while (!isOk) {
            String text = textSource.getStepText(); //Получаем строку с ходом игрока: a1-a2;
            int[] ar = validateText(text);
            if(ar!=null){
                isOk = applyStep(ar, isWhite);
            }
        }
    }

    private int[] validateText(String text){
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

    private boolean applyStep(int[] ar, boolean isWhite){
        step = new Step(ar[2], ar[0], ar[3], ar[1]);
        if(judge.isStepCorrect(step, isWhite)){
            judge.handleStep(step, isWhite);
            return true;
        }
        return false;
    }
}