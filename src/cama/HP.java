package cama;
import java.io.*;
class HP{
    private BufferedWriter bw;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public boolean b;
    String n = new String();
    Konsol ks1 = new Konsol();
    String name;
    String s ;
    public void xod(boolean bol)throws IOException{
        String ok = "error";
        while(!ok.equals("yes")){
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int x1, y1, x2, y2;
            x1 = x2 = y1 = y2 = 0;
            s = br.readLine();
            if(s.equals("exit")) System.exit(1);
            String[]s1 = s.split("-");
            String[]s2 = s1[0].split("");
            String[]s3 = s1[1].split("");
            if(s2[1].equals("a")) y1 = 0;
            if(s2[1].equals("b")) y1 = 1;
            if(s2[1].equals("c")) y1 = 2;
            if(s3[1].equals("a")) y2 = 0;
            if(s3[1].equals("b")) y2 = 1;
            if(s3[1].equals("c")) y2 = 2;
            x1 = Integer.valueOf(s2[2]) - 1;
            x2 = Integer.valueOf(s3[2]) - 1;
            ks1.readField("now.txt");
            if(x1<3&&x2<3&&y1<3&&y2<3){
                if(x1>=0&&x2>=0&&y1>=0&&y2>=0){
                    String cell = ks1.getCh(x1, y1);
                    String cellch = ks1.getCh(x2, y2);
                    if(bol == true){
                        if(cell.equals("E")){
                            bw.write("It is impossible to move empty cells\r\n");
                            bw.flush();
                            ok = "error";
                        }else if(cell.equals("W")){
                            if(cellch.equals("W")){
                                bw.write("It is your cell!\r\n"+
                                   "Try again!\r\n");
                                bw.flush();
                                ok = "error";
                            }else if(cellch.equals("B")){
                                if((x2-x1==1&&y2-y1==1)||(x2-x1==1&&y1-y2==1)){
                                    ks1.rewrite(x2, y2, "W");
                                    ks1.rewrite(x1, y1, "E");
                                    ks1.getField();
                                    ok = "yes";
                                }else{
                                    bw.write("ERROR\r\n");
                                    bw.flush();
                                    ok = "error";
                                }
                            }else if(cellch.equals("E")){
                                if(x2-x1==1&&y2-y1==0){
                                    ks1.rewrite(x2, y2, "W");
                                    ks1.rewrite(x1, y1, "E");
                                    ks1.getField();
                                    ok = "yes";
                                }else{
                                    bw.write("ERROR\r\n");
                                    bw.flush();
                                    ok = "error";
                                }
                            }
                        }else if(cell.equals("B")){
                                  bw.write("It is not your cell!\r\n"+
                                       "Try again!\r\n");
                                   bw.flush();
                                   ok = "error";
                        }
                    }else if(bol == false){
                         if(cell.equals("E")){
                             bw.write("It is impossible to move empty cells\r\n");
                             bw.flush();
                             ok = "error";
                         }else if(cell.equals("B")){
                             if(cellch.equals("B")){
                                bw.write("It is your cell\r\n"+
                                  "Try again!\r\n");
                                bw.flush();
                                ok = "error";
                              }else if(cellch.equals("W")){
                                 if((x2-x1==-1&&y2-y1==-1)||(x2-x1==-1&&y1-y2==-1)){
                                    ks1.rewrite(x2, y2, "B");
                                    ks1.rewrite(x1, y1, "E");
                                    ks1.getField();
                                    ok = "yes";
                                 }else{
                                    bw.write("ERROR\r\n");
                                    bw.flush();
                                    ok = "error";
                                 }
                              }else if(cellch.equals("E")){
                                 if(x2-x1==-1&&y2-y1==0){
                                    ks1.rewrite(x2, y2, "B");
                                    ks1.rewrite(x1, y1, "E");
                                    ks1.getField();
                                    ok = "yes";
                                 }else{
                                    bw.write("ERROR\r\n");
                                    bw.flush();
                                    ok = "error";
                                 }
                              }
                          }else if(cell.equals("W")){
                                   bw.write("Its not your cell!\r\n"+
                                   "Try again!\r\n");
                                   bw.flush();
                                   ok = "error";
                         }
                    }
                }
            }
        }
        
    }  
}
