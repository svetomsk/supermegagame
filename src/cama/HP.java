package cama;
import java.io.*;
class HP{
    private BufferedWriter bw;
    private BufferedReader br;
    public boolean b;
    String n = new String();
    konsol ks1 = new konsol();
    String name;
    public void xod(String s)throws IOException{
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x1, y1, x2, y2;
        x1 = x2 = y1 = y2 = 0;
        String[]s1 = s.split("-");
        String[]s2 = s1[0].split("");
        String[]s3 = s1[1].split("");
        if(s2[1].equals("a")) y1 = 0;
        if(s2[1].equals("b")) y1 = 1;
        if(s2[1].equals("c")) y1 = 2;
        if(s3[1].equals("a")) y2 = 0;
        if(s3[1].equals("b")) y2 = 1;
        if(s3[1].equals("c")) y2 = 2;
        System.out.println(s2[2]+" "+s3[2]);
        x1 = Integer.valueOf(s2[2]) - 1;
        x2 = Integer.valueOf(s3[2]) - 1;       
        String cell = ks1.getCh(x1, y1);        
        String cellch = "none";
        if(cell.equals("E")){
            bw.write("It is impossible to move empty cells");
            bw.flush();
        }else if(cell.equals("W")){
            String cell1 = ks1.getCh(x2, y2);
            if((x2-x1)==1||(y2-y1)==1&&(y2-y1)!=0){
                if(cell1.equals("E")){
                    cellch = cell;
                    cell = cell1;
                    cell1 = cellch;
                    ks1.rewrite(x1, y1, cell1);
                    ks1.rewrite(y2, y2, cell);
                }else if(cell1.equals("B")){
                    if((x2 -x1)!=0&&(y2 - y1)!=1){
                        cell = "E";
                        ks1.rewrite(x1, y1, cell);
                        cell1 = "W";
                        ks1.rewrite(x2, y2, cell1);
                    }
                }
            }else{
                bw.write("It is impossible to move this cell. YO!");
                bw.flush();
            }
        }
    }
}