package cama;
import java.io.*;
public class Model extends Player{
    private Konsol ks2;  
    Model(Konsol ks_from_main) {
        ks2 = ks_from_main;
    }

    public void xod(boolean isWhite){
        int numb = 0, n_left, n_right, n_straight;
        if(isWhite==true){ //white
        one:     for(int i=0;i<ks2.SIZE;i++){
                for(int j=0;j<ks2.SIZE;j++){
                    numb = ks2.getCh(i, j);
                    if (numb == Texts.W){
                        if(j!=0||j!=ks2.SIZE-1){
                            n_left = ks2.getCh(i+1, j-1);
                            n_right = ks2.getCh(i+1, j+1);
                            n_straight = ks2.getCh(i+1, j);
                                if(n_left == Texts.B){
                                    try{
                                        ks2.rewrite(i, j, Texts.E);
                                        ks2.rewrite(i+1, j-1, Texts.W);
                                        ks2.getField();
                                    }
                                    catch(IOException one){
                                        System.out.println(Texts.IOException);
                                        System.exit(0);
                                    }
                                    break one;
                                }
                                else if(n_right == Texts.B){
                                    try{
                                        ks2.rewrite(i, j, Texts.E);
                                        ks2.rewrite(i+1, j+1, Texts.W);
                                        ks2.getField();
                                    }
                                    catch(IOException one){
                                        System.out.println(Texts.IOException);
                                        System.exit(0);
                                    }
                                        break one;
                               }else{
                                    if(n_straight == Texts.E){
                                        try{
                                            ks2.rewrite(i, j, Texts.E);
                                            ks2.rewrite(i+1, j, Texts.W);
                                            ks2.getField();
                                        }
                                        catch(IOException one){
                                            System.out.println(Texts.IOException);
                                            System.exit(0);
                                        }
                                        break one;
                                    }
                               }
                    }
                }
            }
        }
        }else{ //black)
        one:     for(int i=0;i<ks2.SIZE;i++){
                    for(int j=0;j<ks2.SIZE;j++){
                        numb = ks2.getCh(i, j);
                        if (numb == Texts.W){
                            if(j!=0||j!=ks2.SIZE-1){
                                n_left = ks2.getCh(i+1, j-1);
                                n_right = ks2.getCh(i+1, j+1);
                                n_straight = ks2.getCh(i+1, j);
                                    if(n_left == Texts.B){
                                        try{
                                            ks2.rewrite(i, j, Texts.E);
                                            ks2.rewrite(i+1, j-1, Texts.W);
                                            ks2.getField();
                                        }
                                        catch(IOException one){
                                            System.out.println(Texts.IOException);
                                            System.exit(0);
                                        }
                                        break one;
                                    }
                                    else if(n_right == Texts.B){
                                        try{
                                            ks2.rewrite(i, j, Texts.E);
                                            ks2.rewrite(i+1, j+1, Texts.W);
                                            ks2.getField();
                                        }
                                        catch(IOException one){
                                            System.out.println(Texts.IOException);
                                            System.exit(0);
                                        }
                                        break one;
                                    }else{
                                        if(n_straight == Texts.E){
                                            try{
                                                ks2.rewrite(i, j, Texts.E);
                                                ks2.rewrite(i+1, j, Texts.W);
                                                ks2.getField();
                                            }
                                            catch(IOException one){
                                                System.out.println(Texts.IOException);
                                                System.exit(0);
                                            }
                                            break one;
                                        }
                                    }
                        }
                    }
                }
            }
        }
    }
}
