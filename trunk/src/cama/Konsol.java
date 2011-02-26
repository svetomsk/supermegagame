package cama;
import java.io.*;
class Konsol {
    private BufferedWriter kw;
    private BufferedReader kr;
    private int SIZE = 3;
    private int[][] field = new int [SIZE][SIZE];
    private boolean b;
    public void start()throws IOException{
        kw = new BufferedWriter(new OutputStreamWriter(System.out));
        start_field();
        kw.write(Texts.GREETING);
        kw.write("  a b c\r\n"+
                 "1 o o o\r\n"+
                 "2 ▫ ▫ ▫\r\n"+
                 "3 • • •\r\n"+
                 "Пример: a1-a2");
        kw.flush();
    }
    public void getField() throws IOException{
        kw = new BufferedWriter(new OutputStreamWriter(System.out));
        kw.write("  a b c\r\n");
        for(int i=0;i<SIZE;i++){
            kw.write((i+1)+" ");
            for(int j=0;j<SIZE;j++){
                if(field[i][j]==Texts.W){
                    kw.write(Texts.Wh+" ");
                }else if(field[i][j]==Texts.B){
                    kw.write(Texts.Bl+" ");
                }else{
                    kw.write(Texts.Em+" ");
                }
            }
            kw.write("\r\n");
        }
            kw.flush();
    }
    public int getCh(int i, int g){
        return field[i][g];
    }
    public void who(HP player)throws IOException{
        kw = new BufferedWriter(new OutputStreamWriter(System.out));
        kw.write(Texts.DO_STEP(player.name));
        kw.flush();
    }
    public void rewrite(int i, int g, int s)throws IOException{
        field[i][g] = s;
    }
    public void check(boolean cb)throws IOException{
        badpos();
        non_chekers();
        last_number();
        pat(cb);
    }
    private int wh_q(){
        int count=0;
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(field[i][j]==Texts.W) count++;
            }
        }
        return count;
    }
    private int bl_q(){
        int count=0;
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(field[i][j]==Texts.B) count++;
            }
        }
        return count;
    }
    private void badpos (){
        int count=0;
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(field[i][j]!=Texts.E) count++;
            }
        }
        if (count==2){
            System.out.println("White win!");
            System.exit(0);
        }
    }
    private void non_chekers(){
        b = true;
            for(int i=0; i<SIZE;i++){
                for(int g=0;g<SIZE;g++){
                    if(field[i][g]==Texts.W) b = false;
                }
            }
            if(b == true){
                System.out.println(Texts.BlWin);
                System.exit(0);
            }
            b = true;
            for(int i = 0; i < SIZE; i++){
                for(int g = 0; g < SIZE; g++){
                    if(field[i][g]==Texts.B) b = false;
                }
            }
            if(b == true){
                System.out.println(Texts.WhWin);
                System.exit(0);                             
            }
    }
    private void last_number(){
         b = true;                                       
            for(int i = 0 ; i < SIZE; i++){
                if(field[0][i]==Texts.B) b = false;
            }
            if(b == false){
                System.out.println(Texts.BlWin);
                System.exit(0);
            }
            b = true;
            for(int i=0; i<SIZE; i++){
                if(field[2][i]==Texts.W) b = false;
            }
            if(b == false){
                System.out.println(Texts.WhWin);
                System.exit(0);                                 
            }
    }
    private void pat(boolean cb){
        b = false;
            boolean wh[] = new boolean[SIZE];
            boolean bl[] = new boolean[SIZE];
            for(int i=0 ; i<SIZE ;i++){
                wh[i] = true;
                bl[i] = true;
            }
            int iw = 0;
            int ib = 0;
            if(field[0][0]==Texts.W){
                if(field[1][1]!=Texts.B&&field[1][0]!=Texts.W){
                    wh[iw]=false;
                    iw++;
                }
            }
            if(field[0][1]==Texts.W){
                if(field[1][0]!=Texts.B&&field[1][1]!=Texts.E&&field[1][2]!=Texts.B){
                    wh[iw]= false;
                    iw++;
                }
            }
            if(field[0][2]==Texts.W){
                if(field[1][1]!=Texts.B&&field[1][2]!=Texts.E){
                    wh[iw]=false;
                    iw++;
                }
            }
            if(field[1][0]==Texts.W){
                if(field[2][0]!=Texts.E&&field[2][1]!=Texts.B){
                    wh[iw]=false;
                    iw++;
                }
            }else if (field[1][0]==Texts.B){
                if(field[0][0]!=Texts.E&&field[0][1]!=Texts.W){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[1][1]==Texts.W){
                if(field[2][0]!=Texts.B&&field[2][2]!=Texts.B&&field[2][1]!=Texts.E){
                    wh[iw]=false;
                    iw++;
                }
            }else if(field[1][1]==Texts.B){
                if(field[0][0]!=Texts.W&&field[0][2]!=Texts.W&&field[0][1]!=Texts.E){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[1][2]==Texts.W){
                if(field[2][2]!=Texts.E&&field[2][1]!=Texts.B){
                    wh[iw]=false;
                    iw++;
                }
            }else if(field[1][2]==Texts.B){
                if(field[0][2]!=Texts.E&&field[0][1]!=Texts.W){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[2][0]==Texts.B){
                if(field[1][0]!=Texts.E&&field[1][1]!=Texts.W){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[2][1]==Texts.B){
                if(field[1][0]!=Texts.W&&field[1][2]!=Texts.W&&field[1][1]!=Texts.E){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[2][2]==Texts.B){
                if(field[1][1]!=Texts.W&&field[1][2]!=Texts.E){
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
    private void start_field(){
        field[0][0]=field[0][1]=field[0][2]=Texts.W;
        field[1][0]=field[1][1]=field[1][2]=Texts.E;
        field[2][0]=field[2][1]=field[2][2]=Texts.B;
    }
    public void show_field()throws IOException{
        kw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                kw.write(field[i][j]+" ");
                kw.flush();
            }
        }
    }
}