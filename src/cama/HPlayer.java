package cama;
import java.io.*;
class HPlayer extends Player
{
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public boolean b;
    private Konsol ks1;

    HPlayer(Konsol ks_from_main) {
        ks1 = ks_from_main;
    }
    
    public void xod(boolean isWhite){
        Boolean ok = false;
        String s = "";

        while(ok!=true){
            try{
            s = br.readLine();
            }
            catch(IOException one){
                System.out.println(Texts.IOException);
                System.exit(0);
            }
            if(s.equals("exit")) System.exit(0);
            if(s.equals("GK")){System.out.println("Поздравляем господин Кудык!!!! Вы выиграли!!"); System.exit(0);}

            String s1[],s2[],s3[];
            int x1,x2,y1,y2;
            x1=x2=y1=y2=0;
            try{
            s1 = s.split("-");
            s2 = s1[0].split("");
            s3 = s1[1].split("");
            y1 = make_y(s2[1]);
            y2 = make_y(s3[1]);
            x1 = make_x(s2[2]);
            x2 = make_x(s3[2]);
            }
            catch(ArrayIndexOutOfBoundsException e){
                try{
                    bw.write(Texts.Er_TEXT);
                    bw.flush();
                    continue;
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
            }
            catch(NumberFormatException er){
                try{
                    bw.write(Texts.Er_TEXT);
                    bw.flush();
                    continue;
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
            }

            if(x1<3 && x2<3 && y1<3 && y2<3 && x1>=0 && x2>=0 && y1>=0 && y2>=0){
                    int cell = ks1.getCh(x1, y1);
                    int cellch = ks1.getCh(x2, y2);
                    if(isWhite == true){
                        if(cell==Texts.E){
                            try{
                            bw.write(Texts.EMPTY);
                            bw.flush();
                            }
                            catch(IOException one){
                                System.out.println(Texts.IOException);
                                System.exit(0);
                            }
                        }else if(cell==Texts.W){
                            if(cellch==Texts.W){
                                try{
                                    bw.write(Texts.YOUR_CELL);
                                    bw.flush();
                                }
                                catch(IOException one){
                                    System.out.println(Texts.IOException);
                                    System.exit(0);
                                }
                            }else if(cellch==Texts.B){
                                if((x2-x1==1&&y2-y1==1)||(x2-x1==1&&y1-y2==1)){
                                    try{
                                        ks1.rewrite(x2, y2, Texts.W);
                                        ks1.rewrite(x1, y1, Texts.E);
                                        ks1.getField();
                                    }
                                    catch(IOException one){
                                        System.out.println(Texts.IOException);
                                        System.exit(0);
                                    }
                                    ok = true;
                                }else{
                                    try{
                                        bw.write(Texts.Er_Xod);
                                        bw.flush();
                                    }
                                    catch(IOException one){
                                        System.out.println(Texts.IOException);
                                        System.exit(0);
                                    }
                                }
                            }else if(cellch==Texts.E){
                                if(x2-x1==1&&y2-y1==0){
                                    try{
                                        ks1.rewrite(x2, y2, Texts.W);
                                        ks1.rewrite(x1, y1, Texts.E);
                                        ks1.getField();
                                    }
                                    catch(IOException one){
                                        System.out.println(Texts.IOException);
                                        System.exit(0);
                                    }
                                    ok = true;
                                }else{
                                    try{
                                        bw.write(Texts.Er_Xod);
                                        bw.flush();
                                    }
                                    catch(IOException one){
                                        System.out.println(Texts.IOException);
                                        System.exit(0);
                                    }

                                }
                            }
                        }else if(cell==Texts.B){
                            try{
                                bw.write(Texts.NOT_YOUR_CELL);
                                bw.flush();
                            }
                            catch(IOException one){
                                System.out.println(Texts.IOException);
                                System.exit(0);
                            }
                        }
                    }else{
                         if(cell==Texts.E){
                             try{
                                bw.write(Texts.EMPTY);
                                bw.flush();
                             }
                             catch(IOException one){
                                System.out.println(Texts.IOException);
                                System.exit(0);
                            }
                         }else if(cell==Texts.B){
                             if(cellch==Texts.B){
                                 try{
                                    bw.write(Texts.YOUR_CELL);
                                    bw.flush();
                                 }
                                 catch(IOException one){
                                    System.out.println(Texts.IOException);
                                    System.exit(0);
                                 }
                              }else if(cellch==Texts.W){
                                 if((x2-x1==-1&&y2-y1==-1)||(x2-x1==-1&&y1-y2==-1)){
                                    try{
                                        ks1.rewrite(x2, y2, Texts.B);
                                        ks1.rewrite(x1, y1, Texts.E);
                                        ks1.getField();
                                    }
                                    catch(IOException one){
                                        System.out.println(Texts.IOException);
                                        System.exit(0);
                                    }
                                    ok = true;
                                 }else{
                                    try{
                                        bw.write(Texts.Er_Xod);
                                        bw.flush();
                                    }
                                    catch(IOException one){
                                        System.out.println(Texts.IOException);
                                        System.exit(0);
                                    }
                                 }
                              }else if(cellch==Texts.E){
                                 if(x2-x1==-1&&y2-y1==0){
                                    try{
                                        ks1.rewrite(x2, y2, Texts.B);
                                        ks1.rewrite(x1, y1, Texts.E);
                                        ks1.getField();
                                    }
                                    catch(IOException one){
                                        System.out.println(Texts.IOException);
                                        System.exit(0);
                                    }
                                    ok = true;
                                 }else{
                                    try{
                                    bw.write(Texts.Er_Xod);
                                    bw.flush();
                                    }
                                    catch(IOException one){
                                        System.out.println(Texts.IOException);
                                        System.exit(0);
                                    }
                                 }
                              }
                          }else if(cell==Texts.W){
                              try{
                                   bw.write(Texts.NOT_YOUR_CELL);
                                   bw.flush();
                              }
                              catch(IOException one){
                                System.out.println(Texts.IOException);
                                System.exit(0);
                              }
                         }
                }
            }else{
                try{
                bw.write(Texts.OUT_OF_BOUNDS);
                bw.flush();
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
            }
        }
        
    }  
    private int make_y(String m){
        int y=0;
        if(m.equals("a"))     y = 0;
        if(m.equals("b"))     y = 1;
        if(m.equals("c"))     y = 2;
        return y;
    }
    private int make_x(String m){
        return Integer.valueOf(m)-1;
    }
}
