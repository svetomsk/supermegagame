package cama.gui_cama;

import cama.core.Judge;
import cama.core.Player;
import cama.core.Texts;

class GHPlayer extends Player {

    public boolean b;
    private Judge ks;
    GHPlayer(Judge ks_from_main) {
        ks = ks_from_main;
		setModulePlayer(false);
   }
    public void doStep(boolean isWhite) {
        


        /*if (s.equals("GK")) {  //  <- доработать!!!!
            System.out.println("Texts.CHEAT1");
            System.exit(0);
        }*/

        String s = Main.coord.getText();
//        String[] s1 = Main.s1.split("");
//        String[] s2 = Main.s2.split("");

//        int x1 = Integer.valueOf(s1[1]);
//        int y1 = Integer.valueOf(s1[2]);
//        int x2 = Integer.valueOf(s2[1]);
//        int y2 = Integer.valueOf(s2[2]);



        int x1, x2, y1, y2;
        String[] s1, s2, s3;
        x1 = x2 = y1 = y2 = -1;
        try {
            s1 = s.split("-");
            s2 = s1[0].split("");
            s3 = s1[1].split("");
            y1 = makeY(s2[1]);
            y2 = makeY(s3[1]);
            x1 = makeX(s2[2]);
            x2 = makeX(s3[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            Main.ErLab1.setText(Texts.ER_TEXT);
        } catch (NumberFormatException er) {
            Main.ErLab1.setText(Texts.ER_TEXT);
        }



        //if (x1 < ks.getSize() && x2 < ks.getSize() && y1 < ks.getSize() && y2 < ks.getSize()
        //        && x1 >= 0 && x2 >= 0 && y1 >= 0 && y2 >= 0) {

            int cell = ks.getCh(x1, y1);
            int cellch = ks.getCh(x2, y2);
            if(isWhite){
                if(cell == ks.W && cellch ==ks.B){
                    if ((x2 - x1 == 1 && y2 - y1 == 1) || (x2 - x1 == 1 && y1 - y2 == 1)) {
                        ks.rewrite(x2, y2, ks.W);
                        ks.rewrite(x1, y1, ks.E);
                        setIsWhite();
                        Main.ErLab1.setText("");
                    }else{
                        System.out.println("here 1");
                        Main.ErLab1.setText(Texts.ER_STEP);
                    }
                }else if(cell == ks.W && cellch ==ks.E){
                    if (x2 - x1 == 1 && y2 - y1 == 0) {
                            ks.rewrite(x2, y2, ks.W);
                            ks.rewrite(x1, y1, ks.E);
                            setIsWhite();
                            Main.ErLab1.setText("");
                    }else{
                        System.out.println("here 2");
                        Main.ErLab1.setText(Texts.ER_STEP);
                    }
                }else{
                    System.out.println("here 3");
                    System.out.println(cell+" "+cellch);
                    Main.ErLab1.setText(Texts.ER_STEP);
                }
            }else{
                if(cell == ks.B && cellch == ks.W){
                    if ((x2 - x1 == -1 && y2 - y1 == -1) || (x2 - x1 == -1 && y1 - y2 == -1)) {
                        ks.rewrite(x2, y2, ks.B);
                        ks.rewrite(x1, y1, ks.E);
                        setIsWhite();
                        Main.ErLab1.setText("");
                    } else {
                        System.out.println("here 4");
                          Main.ErLab1.setText(Texts.ER_STEP);
                    }
                }else if(cell == ks.B && cellch == ks.E){
                    if (x2 - x1 == -1 && y2 - y1 == 0) {
                        ks.rewrite(x2, y2, ks.B);
                        ks.rewrite(x1, y1, ks.E);
                        setIsWhite();
                        Main.ErLab1.setText("");
                    } else {
                        System.out.println("here 5");
                        Main.ErLab1.setText(Texts.ER_STEP);
                    }
                } else {
                    System.out.println("here 6");
                    Main.ErLab1.setText(Texts.ER_STEP);
                }
            }
    }

    private int makeY(String m) {
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
    private int makeX(String m) {
        return Integer.valueOf(m) - 1;
    }
    private void setIsWhite(){
        if(Main.isWhite){
            Main.isWhite = false;
        }else{
            Main.isWhite = true;
        }
    }
}
