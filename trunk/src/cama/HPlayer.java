package cama;
import java.io.*;
public class HPlayer extends Player
{
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public boolean b;
    private Konsol ks;

    public HPlayer(Konsol ks_from_main) {
        ks = ks_from_main;
    }
    
    public void doStep(boolean isWhite){
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
            if(s.equals("GK")){
                System.out.println("Texts.CHEAT1");
                System.exit(0);
            }


            String s1[],s2[],s3[];
            int x1,x2,y1,y2;
            x1=x2=y1=y2=0;
            try{
            s1 = s.split("-");
            s2 = s1[0].split("");
            s3 = s1[1].split("");
            y1 = makeY(s2[1]);
            y2 = makeY(s3[1]);
            x1 = makeX(s2[2]);
            x2 = makeX(s3[2]);
            }
            catch(ArrayIndexOutOfBoundsException e){
                try{
                    bw.write(Texts.ER_TEXT);
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
                    bw.write(Texts.ER_TEXT);
                    bw.flush();
                    continue;
                }
                catch(IOException one){
                    System.out.println(Texts.IOException);
                    System.exit(0);
                }
            }

            if(x1<ks.getSize() && x2<ks.getSize() && y1<ks.getSize() && y2<ks.getSize()
               && x1>=0 && x2>=0 && y1>=0 && y2>=0){
                    int cell = ks.getCh(x1, y1);
                    int cellch = ks.getCh(x2, y2);
                    if(isWhite == true){
                        if(cell==ks.E){
                            try{
                            bw.write(Texts.EMPTY_LN);
                            bw.flush();
                            }
                            catch(IOException one){
                                System.out.println(Texts.IOException);
                                System.exit(0);
                            }
                        }else if(cell==ks.W){
                            if(cellch==ks.W){
                                try{
                                    bw.write(Texts.YOUR_CELL);
                                    bw.flush();
                                }
                                catch(IOException one){
                                    System.out.println(Texts.IOException);
                                    System.exit(0);
                                }
                            }else if(cellch==ks.B){
                                if((x2-x1==1&&y2-y1==1)||(x2-x1==1&&y1-y2==1)){
                                    try{
                                        ks.rewrite(x2, y2, ks.W);
                                        ks.rewrite(x1, y1, ks.E);
                                        ks.printField();
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
                            }else if(cellch==ks.E){
                                if(x2-x1==1&&y2-y1==0){
                                    try{
                                        ks.rewrite(x2, y2, ks.W);
                                        ks.rewrite(x1, y1, ks.E);
                                        ks.printField();
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
                        }else if(cell==ks.B){
                            try{
                                bw.write(Texts.NOT_YOUR_CELL_LN);
                                bw.flush();
                            }
                            catch(IOException one){
                                System.out.println(Texts.IOException);
                                System.exit(0);
                            }
                        }
                    }else{
                         if(cell==ks.E){
                             try{
                                bw.write(Texts.EMPTY_LN);
                                bw.flush();
                             }
                             catch(IOException one){
                                System.out.println(Texts.IOException);
                                System.exit(0);
                            }
                         }else if(cell==ks.B){
                             if(cellch==ks.B){
                                 try{
                                    bw.write(Texts.YOUR_CELL);
                                    bw.flush();
                                 }
                                 catch(IOException one){
                                    System.out.println(Texts.IOException);
                                    System.exit(0);
                                 }
                              }else if(cellch==ks.W){
                                 if((x2-x1==-1&&y2-y1==-1)||(x2-x1==-1&&y1-y2==-1)){
                                    try{
                                        ks.rewrite(x2, y2, ks.B);
                                        ks.rewrite(x1, y1, ks.E);
                                        ks.printField();
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
                              }else if(cellch==ks.E){
                                 if(x2-x1==-1&&y2-y1==0){
                                    try{
                                        ks.rewrite(x2, y2, ks.B);
                                        ks.rewrite(x1, y1, ks.E);
                                        ks.printField();
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
                          }else if(cell==ks.W){
                              try{
                                   bw.write(Texts.NOT_YOUR_CELL_LN);
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
    private int makeY(String m){
        int y=0;
        if(m.equals("a"))     y = 0;
        if(m.equals("b"))     y = 1;
        if(m.equals("c"))     y = 2;
        return y;
    }
    private int makeX(String m){
        return Integer.valueOf(m)-1;
    }
    public void finish() throws IOException{
        bw.close();
        br.close();
    } // Надо привязать!!!
}
