package cama;
import java.io.*;
class Konsol {
    private BufferedWriter kw;
    private BufferedReader kr;
    private String[][] field = new String [3][3];
    public boolean b;
    public void start()throws IOException{
        kr = new BufferedReader(new FileReader("kwtext.txt"));
        kw = new BufferedWriter(new OutputStreamWriter(System.out));
        kw.write(Texts.GREETING);
        for(int i = 0; i <5; i++){
            kw.write(kr.readLine()+"\r\n");
        }
        kw.flush();
        kr.close();
    }
    public void getField() throws IOException{
        kw = new BufferedWriter(new OutputStreamWriter(System.out));
        kr  = new BufferedReader(new FileReader("now.txt"));
        kw.write("  a b c\r\n");
        for(int i =0;i<3;i++){
            kw.write((i+1)+" ");
            String[]k = kr.readLine().split(" ");
            for(int g = 0;g<3;g++){
                kw.write(k[g]+" ");
                field[i][g] = k[g];
            }
            kw.write("\r\n");
            kw.flush();
        }
    }
    public String getCh(int i, int g){
        return field[i][g];
    }
    public void who(HP player)throws IOException{
        kw = new BufferedWriter(new OutputStreamWriter(System.out));
        kw.write(Texts.DO_STEP(player.name));
        kw.flush();
    }
    public void readField(String fname)throws IOException{
        kr = new BufferedReader(new FileReader(fname));
        for(int i = 0; i < 3; i++){
            String str[] = kr.readLine().split(" ");
            System.arraycopy(str, 0, field[i], 0, 3);
        }
    }
    public void rewrite(int i, int g, String s)throws IOException{
        kw = new BufferedWriter(new FileWriter("now.txt"));
        field[i][g]  = s;
        for(int f = 0;f<3;f++){
            for(int t =0;t<3;t++){
                kw.write(field[f][t]+" ");
                kw.flush();
            }
            kw.write("\r\n");
            kw.flush();
        }        
    }
    public void check(boolean cb)throws IOException{
        badpos();
        non_chekers();
        last_number();
        pat(cb);
    }
    private int wh_q(){
        int count =0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(field[i][j].equals("o")) count++;
            }
        }
        return count;
    }
    private int bl_q(){
        int count =0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(field[i][j].equals("•")) count++;
            }
        }
        return count;
    }
    private void badpos (){
        int count=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(!field[i][j].equals("▫")) count++;
            }
        }
        if (count==2){
            System.out.println("White win!");
            System.exit(0);
        }
    }
    private void non_chekers(){
        b = true;
            for(int i = 0; i < 3; i++){                     
                for(int g = 0; g < 3; g++){
                    if(field[i][g].equals("o")) b = false;
                }
            }
            if(b == true){
                System.out.println(Texts.BlWin);
                System.exit(0);
            }
            b = true;
            for(int i = 0; i < 3; i++){
                for(int g = 0; g < 3; g++){
                    if(field[i][g].equals("•")) b = false;
                }
            }
            if(b == true){
                System.out.println(Texts.WhWin);
                System.exit(0);                             
            }
    }
    private void last_number(){
         b = true;                                       
            for(int i = 0 ; i < 3; i++){
                if(field[0][i].equals("•")) b = false;
            }
            if(b == false){
                System.out.println(Texts.BlWin);
                System.exit(0);
            }
            b = true;
            for(int i=0; i<3; i++){
                if(field[2][i].equals("o")) b = false;
            }
            if(b == false){
                System.out.println(Texts.WhWin);
                System.exit(0);                                 
            }
    }
    private void pat(boolean cb){
        b = false;
            boolean wh[] = new boolean[3];
            boolean bl[] = new boolean[3];
            for(int i=0 ; i<3 ;i++){
                wh[i] = true;
                bl[i] = true;
            }
            int iw = 0;
            int ib = 0;
            if(field[0][0].equals("o")){
                if(!field[1][1].equals("•")&&!field[1][0].equals("▫")){
                    wh[iw]=false;
                    iw++;
                }
            }
            if(field[0][1].equals("o")){
                if(!field[1][0].equals("•")&&!field[1][1].equals("▫")&&!field[1][2].equals("•")){
                    wh[iw]= false;
                    iw++;
                }
            }
            if(field[0][2].equals("o")){
                if(!field[1][1].equals("•")&&!field[1][2].equals("▫")){
                    wh[iw]=false;
                    iw++;
                }
            }
            if(field[1][0].equals("o")){
                if(!field[2][0].equals("▫")&&!field[2][1].equals("•")){
                    wh[iw]=false;
                    iw++;
                }
            }else if (field[1][0].equals("•")){
                if(!field[0][0].equals("▫")&&!field[0][1].equals("o")){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[1][1].equals("o")){
                if(!field[2][0].equals("•")&&!field[2][2].equals("•")&&!field[2][1].equals("▫")){
                    wh[iw]=false;
                    iw++;
                }
            }else if(field[1][1].equals("•")){
                if(!field[0][0].equals("o")&&!field[0][2].equals("o")&&!field[0][1].equals("▫")){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[1][2].equals("o")){
                if(!field[2][2].equals("▫")&&!field[2][1].equals("•")){
                    wh[iw]=false;
                    iw++;
                }
            }else if(field[1][2].equals("•")){
                if(!field[0][2].equals("▫")&&!field[0][1].equals("o")){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[2][0].equals("•")){
                if(!field[1][0].equals("▫")&&!field[1][1].equals("o")){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[2][1].equals("•")){
                if(!field[1][0].equals("o")&&!field[1][2].equals("o")&&field[1][1].equals("▫")){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[2][2].equals("•")){
                if(!field[1][1].equals("o")&&!field[1][2].equals("▫")){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(cb == false){
                b=false;
                for(int i = 0; i<wh_q();i++){
                    if(wh[i]!=false){
                        b = true;
                    }
                }
                if(b == false){
                    System.out.println(Texts.BlWin);
                    System.exit(0);
                }
            }else{
                b=false;
                for(int i = 0; i<bl_q();i++){
                    if(bl[i]!=false){
                        b = true;
                    }
                }
                if(b == false){
                    System.out.println(Texts.WhWin);
                    System.exit(0);
                }
            }
    }
}