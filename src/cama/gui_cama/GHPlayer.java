package cama.gui_cama;

import cama.core.ITextSource;
import cama.core.Judge;
import cama.core.Player;
import cama.core.Texts;
import cama.core.Step;
import java.io.*;

class GHPlayer extends Player {

    public boolean b;
    private Judge judge;
    private Step step;
    GHPlayer(Judge ks_from_main, ITextSource value) {
        judge = ks_from_main;
        setModulePlayer(false);
        textSource = value;
   }
//    public void OLDdoStep(boolean isWhite){
//        /*if (s.equals("GK")) {  //  <- доработать!!!!
//            System.out.println("Texts.CHEAT1");
//            System.exit(0);
//        }*/
//
//        String s = OldMain.coord.getText();
//
//        int x1, x2, y1, y2;
//        String[] s1, s2, s3;
//        x1 = x2 = y1 = y2 = -1;
//        try {
//            s1 = s.split("-");
//            s2 = s1[0].split("");
//            s3 = s1[1].split("");
//            y1 = makeX(s2[1]);
//            y2 = makeX(s3[1]);
//            x1 = makeY(s2[2]);
//            x2 = makeY(s3[2]);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            OldMain.ErLab1.setText(Texts.ER_TEXT);
//        } catch (NumberFormatException er) {
//            OldMain.ErLab1.setText(Texts.ER_TEXT);
//        }
//
//            int cell = judge.getCell(x1, y1);
//            int cellch = judge.getCell(x2, y2);
//            if(isWhite){
//                if(cell == judge.W && cellch ==judge.B){
//                    if ((x2 - x1 == 1 && y2 - y1 == 1) || (x2 - x1 == 1 && y1 - y2 == 1)) {
//                        setIsWhite();
//                        OldMain.ErLab1.setText("");
//                        makeStep(y1, x1, y2, x2, !isWhite);
//                    }else{
//                        System.out.println("here 1");
//                        OldMain.ErLab1.setText(Texts.ER_STEP_LN);
//                    }
//                }else if(cell == judge.W && cellch ==judge.E){
//                    if (x2 - x1 == 1 && y2 - y1 == 0) {
//                            setIsWhite();
//                            OldMain.ErLab1.setText("");
//                            makeStep(y1, x1, y2, x2, !isWhite);
//                    }else{
//                        System.out.println("here 2");
//                        OldMain.ErLab1.setText(Texts.ER_STEP_LN);
//                    }
//                }else{
//                    System.out.println("here 3");
//                    System.out.println(cell+" "+cellch);
//                    OldMain.ErLab1.setText(Texts.ER_STEP_LN);
//                }
//            }else{
//                if(cell == judge.B && cellch == judge.W){
//                    if ((x2 - x1 == -1 && y2 - y1 == -1) || (x2 - x1 == -1 && y1 - y2 == -1)) {
//                        setIsWhite();
//                        OldMain.ErLab1.setText("");
//                        makeStep(y1, x1, y2, x2, !isWhite);
//                    } else {
//                        System.out.println("here 4");
//                          OldMain.ErLab1.setText(Texts.ER_STEP_LN);
//                    }
//                }else if(cell == judge.B && cellch == judge.E){
//                    if (x2 - x1 == -1 && y2 - y1 == 0) {
//                        setIsWhite();
//                        OldMain.ErLab1.setText("");
//                        makeStep(y1, x1, y2, x2, !isWhite);
//                    } else {
//                        System.out.println("here 5");
//                        OldMain.ErLab1.setText(Texts.ER_STEP_LN);
//                    }
//                } else {
//                    System.out.println("here 6");
//                    OldMain.ErLab1.setText(Texts.ER_STEP_LN);
//                }
//            }
//    }
//
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
//    private void setIsWhite(){
//        if(OldMain.isWhite){
//            OldMain.isWhite = false;
//        }else{
//            OldMain.isWhite = true;
//        }
//    }
//    private void makeStep(int col1, int row1, int col2, int row2, boolean isWhite){
//        step = new Step(col1, row1, col2, row2);
//        judge.handleStep(step, isWhite);
//    }


    /***************************************************/

    private ITextSource textSource;
    
    public void doStep(boolean isWhite){
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
            textSource.writeText(Texts.ER_TEXT);
            return null;
        }

        ar[0] = x1;
        ar[1] = x2;
        ar[2] = y1;
        ar[3] = y2;

        return ar;
    }

    private boolean applyStep(int[] ar, boolean isWhite){
        step = new Step(ar[2], ar[0], ar[3], ar[1]);
        if(judge.isStepCorrect(step, isWhite)){
            judge.handleStep(step, isWhite);
            return true;
        }
        textSource.writeText(Texts.ER_STEP_LN);
        return false;
    }
}