package cama;
import java.io.*;
public class MPlayer extends Player{
    private Konsol ks2;
    private int n_left=0, n_right=0, n_straight=0, numb=0;
    MPlayer(Konsol ks_from_main) {
        ks2 = ks_from_main;
    }
    public void xod(boolean isWhite){
        boolean make_xod;
        if(isWhite==true){
        one:    for(int i=0;i<ks2.getSize();i++){
                    for(int j=0;j<ks2.getSize();j++){
                        numb = ks2.getCh(i, j);
                        if (numb == Texts.W){
                            if(j!=0&&j!=(ks2.getSize())-1){
                               make_xod=white_middle(i, j);
                                if (make_xod==true){
                                    break one;
                                }
                            }else{
                                make_xod=white_bok(i, j);
                                if(make_xod==true){
                                    break one;
                                }
                            }
                        }
                    }
                }
        }else{
        two:    for(int i=0;i<ks2.getSize();i++){
                    for(int j=0;j<ks2.getSize();j++){
                        numb = ks2.getCh(i, j);
                        if (numb == Texts.B){
                            if(j!=0&&j!=(ks2.getSize())-1){
                               make_xod=black_middle(i, j);
                                if (make_xod==true){
                                    break two;
                                }
                            }else{
                                make_xod=black_bok(i, j);
                                if(make_xod==true){
                                    break two;
                                }
                            }
                        }
                    }
                }
        }
    }
    private boolean white_middle(int i, int j){
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
            return true;
        }else if(n_right == Texts.B){
            try{
                ks2.rewrite(i, j, Texts.E);
                ks2.rewrite(i+1, j+1, Texts.W);
                ks2.getField();
            }
            catch(IOException one){
                System.out.println(Texts.IOException);
                System.exit(0);
            }
            return true;
        }else if(n_straight == Texts.E){
            try{
                ks2.rewrite(i, j, Texts.E);
                ks2.rewrite(i+1, j, Texts.W);
                ks2.getField();
            }
            catch(IOException one){
                System.out.println(Texts.IOException);
                System.exit(0);
            }
            return true;
        }else{
          return false;
        }
    }
    private boolean white_bok(int i, int j){
        if(j==0){
           n_right = ks2.getCh(i+1, j+1);
           n_straight = ks2.getCh(i+1, j);
           if(n_right==Texts.B){
               try{
                    ks2.rewrite(i, j, Texts.E);
                    ks2.rewrite(i+1, j-1, Texts.W);
                    ks2.getField();
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
                return true;
           }else if(n_straight==Texts.E){
               try{
                    ks2.rewrite(i, j, Texts.E);
                    ks2.rewrite(i+1, j, Texts.W);
                    ks2.getField();
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
                return true;
           }else{
               return false;
           }
        }else{
            n_left = ks2.getCh(i+1, j-1);
            n_straight = ks2.getCh(i+1, j);
            if(n_left==Texts.B){
                try{
                    ks2.rewrite(i, j, Texts.E);
                    ks2.rewrite(i+1, j-1, Texts.W);
                    ks2.getField();
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
                return true;
            }else if(n_straight == Texts.E){
                try{
                    ks2.rewrite(i, j, Texts.E);
                    ks2.rewrite(i+1, j, Texts.W);
                    ks2.getField();
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
                return true;
            }else{
                return false;
            }
        }
    }
    private boolean black_middle(int i, int j){
        System.out.println(i+" "+j);
      n_left = ks2.getCh(i-1, j-1);
      n_right = ks2.getCh(i-1, j+1);
      n_straight = ks2.getCh(i-1, j);
        if(n_left == Texts.W){
            try{
                ks2.rewrite(i, j, Texts.E);
                ks2.rewrite(i-1, j-1, Texts.B);
                ks2.getField();
            }
            catch(IOException one){
                System.out.println(Texts.IOException);
                System.exit(0);
            }
            return true;
        }else if(n_right == Texts.W){
            try{
                ks2.rewrite(i, j, Texts.E);
                ks2.rewrite(i-1, j-1, Texts.B);
                ks2.getField();
            }
            catch(IOException one){
                System.out.println(Texts.IOException);
                System.exit(0);
            }
            return true;
        }else if(n_straight == Texts.E){
            try{
                ks2.rewrite(i, j, Texts.E);
                ks2.rewrite(i-1, j, Texts.B);
                ks2.getField();
            }
            catch(IOException one){
                System.out.println(Texts.IOException);
                System.exit(0);
            }
            return true;
        }else{
          return false;
        }
    }
    private boolean black_bok(int i, int j){
        if(j==0){
           n_right = ks2.getCh(i-1, j+1);
           n_straight = ks2.getCh(i-1, j);
           if(n_right==Texts.W){
               try{
                    ks2.rewrite(i, j, Texts.E);
                    ks2.rewrite(i-1, j+1, Texts.B);
                    ks2.getField();
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
                return true;
           }else if(n_straight==Texts.E){
               try{
                    ks2.rewrite(i, j, Texts.E);
                    ks2.rewrite(i-1, j, Texts.W);
                    ks2.getField();
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
                return true;
           }else{
               return false;
           }
        }else{
            n_left = ks2.getCh(i-1, j-1);
            n_straight = ks2.getCh(i-1, j);
            if(n_left==Texts.W){
                try{
                    ks2.rewrite(i, j, Texts.E);
                    ks2.rewrite(i-1, j-1, Texts.B);
                    ks2.getField();
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
                return true;
            }else if(n_straight == Texts.E){
                try{
                    ks2.rewrite(i, j, Texts.E);
                    ks2.rewrite(i-1, j, Texts.B);
                    ks2.getField();
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
                return true;
            }else{
                return false;
            }
        }
    }
}
