package cama;
import java.io.*;
import java.util.Random;
public class MPlayer extends Player{
    private Konsol ks;
    private int n_left=0, n_right=0, n_straight=0, numb=0;
    MPlayer(Konsol ks_from_main) {
        ks = ks_from_main;
    }
    public void xod(boolean isWhite){
        Random r =new Random();
        int count = 0, num, x, y;
        String[] coord = new String [ks.getSize()], ar=new String[2];
        boolean make_xod;
        if(isWhite==true){
            for(int i=0;i<ks.getSize();i++){
                for(int j=0;j<ks.getSize();j++){
                   numb = ks.getCh(i, j);
                   if(numb==ks.W){
                      coord[count]=i+" "+j;
                      count++;
                   }
                }
            }
   one:     for(;;){
                num = r.nextInt(count);
                ar = coord[num].split(" ");
                x = Integer.valueOf(ar[0]);
                y = Integer.valueOf(ar[1]);
                if(y!=0&&y!=(ks.getSize())-1){
                    make_xod = white_middle(x,y);
                    if(make_xod==true){
                        break one;
                    }
                }else{
                    make_xod=white_bok(x, y);
                    if(make_xod==true){
                        break one;
                    }
                }

            }
        }else{
            for(int i=0;i<ks.getSize();i++){
                for(int j=0;j<ks.getSize();j++){
                    numb = ks.getCh(i, j);
                    if(numb==ks.B){
                        coord[count]=i+" "+j;
                        count++;
                   }
                }
            }
     two:   for(;;){
                num = r.nextInt(count);
                ar = coord[num].split(" ");
                x = Integer.valueOf(ar[0]);
                y = Integer.valueOf(ar[1]);
                if(y!=0&&y!=(ks.getSize())-1){
                    make_xod = black_middle(x,y);
                    if(make_xod==true){
                        break two;
                    }
                }else{
                    make_xod=black_bok(x, y);
                    if(make_xod==true){
                        break two;
                    }
                }

            }
        }
    }
    private boolean white_middle(int i, int j){
      n_left = ks.getCh(i+1, j-1);
      n_right = ks.getCh(i+1, j+1);
      n_straight = ks.getCh(i+1, j);

      if(n_left==ks.B&&n_right==ks.B&&n_straight==ks.E);
        if(n_left == ks.B){
            try{
                ks.rewrite(i, j, ks.E);
                ks.rewrite(i+1, j-1, ks.W);
                ks.printField();
            }
            catch(IOException one){
                System.out.println(Texts.IOException);
                System.exit(0);
            }
            return true;
        }else if(n_right == ks.B){
            try{
                ks.rewrite(i, j, ks.E);
                ks.rewrite(i+1, j+1, ks.W);
                ks.printField();
            }
            catch(IOException one){
                System.out.println(Texts.IOException);
                System.exit(0);
            }
            return true;
        }else if(n_straight == ks.E){
            try{
                ks.rewrite(i, j, ks.E);
                ks.rewrite(i+1, j, ks.W);
                ks.printField();
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
        Random r =new Random();
        int n;
        if(j==0){
           n_right = ks.getCh(i+1, j+1);
           n_straight = ks.getCh(i+1, j);
           if(n_right==ks.B&&n_straight==ks.E){
               n=r.nextInt(2);
               if(n==0){
                   n_step(i,j,i+1,j,ks.W);//straight
               }else{
                   n_step(i,j,i+1,j+1,ks.W);//right
               }
               return true;
           }else if(n_right==ks.B){
              n_step(i,j,i+1,j+1,ks.W);
              return true;
           }else if(n_straight==ks.E){
               n_step(i,j,i+1,j,ks.W);
               return true;
           }else{
               return false;
           }
        }else{
            n_left = ks.getCh(i+1, j-1);
            n_straight = ks.getCh(i+1, j);
            if(n_left==ks.B&&n_straight==ks.E){
               n=r.nextInt(2);
               if(n==0){
                   n_step(i,j,i+1,j,ks.W);//straight
               }else{
                   n_step(i,j,i+1,j-1,ks.W);//left
               }
               return true;
            }else if(n_straight==ks.E){
                n_step(i,j,i+1,j,ks.W);
                return true;
            }else if(n_left==ks.B){
                n_step(i,j,i+1,j-1,ks.W);
                return true;
            }else{
                return false;
            }
        }
    }
    private boolean black_middle(int i, int j){
        System.out.println(i+" "+j);
      n_left = ks.getCh(i-1, j-1);
      n_right = ks.getCh(i-1, j+1);
      n_straight = ks.getCh(i-1, j);
        if(n_left == ks.W){
            try{
                ks.rewrite(i, j, ks.E);
                ks.rewrite(i-1, j-1, ks.B);
                ks.printField();
            }
            catch(IOException one){
                System.out.println(Texts.IOException);
                System.exit(0);
            }
            return true;
        }else if(n_right == ks.W){
            try{
                ks.rewrite(i, j, ks.E);
                ks.rewrite(i-1, j-1, ks.B);
                ks.printField();
            }
            catch(IOException one){
                System.out.println(Texts.IOException);
                System.exit(0);
            }
            return true;
        }else if(n_straight == ks.E){
            try{
                ks.rewrite(i, j, ks.E);
                ks.rewrite(i-1, j, ks.B);
                ks.printField();
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
           n_right = ks.getCh(i-1, j+1);
           n_straight = ks.getCh(i-1, j);
           if(n_right==ks.W){
               try{
                    ks.rewrite(i, j, ks.E);
                    ks.rewrite(i-1, j+1, ks.B);
                    ks.printField();
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
                return true;
           }else if(n_straight==ks.E){
               try{
                    ks.rewrite(i, j, ks.E);
                    ks.rewrite(i-1, j, ks.B);
                    ks.printField();
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
            n_left = ks.getCh(i-1, j-1);
            n_straight = ks.getCh(i-1, j);
            if(n_left == ks.W){
                try{
                    ks.rewrite(i, j, ks.E);
                    ks.rewrite(i-1, j-1, ks.B);
                    ks.printField();
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
                return true;
            }else if(n_straight == ks.E){
                try{
                    ks.rewrite(i, j, ks.E);
                    ks.rewrite(i-1, j, ks.B);
                    ks.printField();
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
    private void n_step (int x, int y, int x1, int y1, int cell){
        try{
                    ks.rewrite(x, y, ks.E);
                    ks.rewrite(x1, y1, cell);
                    ks.printField();
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
    }
}
