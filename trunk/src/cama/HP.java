package cama;
import java.io.*;
class HP{
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public boolean b;
    private Konsol ks1;
    HP(Konsol ks_from_main) {
        ks1 = ks_from_main;
    }
    String name, s;
    public void xod(boolean bol)throws IOException{
        Boolean ok = false;

        while(ok!=true){
            s = br.readLine();
            if(s.equals("exit")) System.exit(0);
            
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
                bw.write(Texts.Er_TEXT);
                bw.flush();
                continue;
            }
            catch(NumberFormatException er){
                bw.write(Texts.Er_TEXT);
                bw.flush();
                continue;
            }

            if(x1<3 && x2<3 && y1<3 && y2<3 && x1>=0 && x2>=0 && y1>=0 && y2>=0){
                    int cell = ks1.getCh(x1, y1);
                    int cellch = ks1.getCh(x2, y2);
                    if(bol == true){
                        if(cell==Texts.E){
                            bw.write(Texts.EMPTY);
                            bw.flush();
                        }else if(cell==Texts.W){
                            if(cellch==Texts.W){
                                bw.write(Texts.YOUR_CELL);
                                bw.flush();
                            }else if(cellch==Texts.B){
                                if((x2-x1==1&&y2-y1==1)||(x2-x1==1&&y1-y2==1)){
                                    ks1.rewrite(x2, y2, Texts.W);
                                    ks1.rewrite(x1, y1, Texts.E);
                                    ks1.getField();
                                    ok = true;
                                }else{
                                    bw.write(Texts.Er_Xod);
                                    bw.flush();
                                }
                            }else if(cellch==Texts.E){
                                if(x2-x1==1&&y2-y1==0){
                                    ks1.rewrite(x2, y2, Texts.W);
                                    ks1.rewrite(x1, y1, Texts.E);
                                    ks1.getField();
                                    ok = true;
                                }else{
                                    bw.write(Texts.Er_Xod);
                                    bw.flush();
                                }
                            }
                        }else if(cell==Texts.B){
                                  bw.write(Texts.NOT_YOUR_CELL);
                                   bw.flush();
                        }
                    }else{
                         if(cell==Texts.E){
                             bw.write(Texts.EMPTY);
                             bw.flush();
                         }else if(cell==Texts.B){
                             if(cellch==Texts.B){
                                bw.write(Texts.YOUR_CELL);
                                bw.flush();
                              }else if(cellch==Texts.W){
                                 if((x2-x1==-1&&y2-y1==-1)||(x2-x1==-1&&y1-y2==-1)){
                                    ks1.rewrite(x2, y2, Texts.B);
                                    ks1.rewrite(x1, y1, Texts.E);
                                    ks1.getField();
                                    ok = true;
                                 }else{
                                    bw.write(Texts.Er_Xod);
                                    bw.flush();
                                 }
                              }else if(cellch==Texts.E){
                                 if(x2-x1==-1&&y2-y1==0){
                                    ks1.rewrite(x2, y2, Texts.B);
                                    ks1.rewrite(x1, y1, Texts.E);
                                    ks1.getField();
                                    ok = true;
                                 }else{
                                    bw.write(Texts.Er_Xod);
                                    bw.flush();
                                 }
                              }
                          }else if(cell==Texts.W){
                                   bw.write(Texts.NOT_YOUR_CELL);
                                   bw.flush();
                         }
                }
            }else{
                bw.write(Texts.OUT_OF_BOUNDS);
                bw.flush();
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
