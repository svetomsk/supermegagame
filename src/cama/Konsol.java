package cama;
import java.io.*;
class Konsol {
    Konsol(){
        kw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    private BufferedWriter kw;
    private int SIZE = 3;
    private int[][] field = new int [SIZE+2][SIZE+2]; //Сменил на рамку!!!
    private boolean b;

    public int W = 1;
    public int B = 2;
    public int E = 0;

    public void start()throws IOException{
        startField();
        kw.write(Texts.GREETING);
        kw.write(Texts.START);
        kw.flush();
    } //сделано!
    public void printField() throws IOException{
        kw.write("  a b c\r\n");
        for(int i=0;i<SIZE;i++){
            kw.write((i+1)+" ");
            for(int j=0;j<SIZE;j++){
                if(field[i+1][j+1]==W){
                    kw.write(Texts.Wh+" ");
                }else if(field[i+1][j+1]==B){
                    kw.write(Texts.Bl+" ");
                }else{
                    kw.write(Texts.Em+" ");
                }
            }
            kw.write("\r\n");
        }
            kw.flush();
    } //сделано!
    public int[][] getField(){
        return field;
    }
    public int getCh(int i, int g){
        return field[i+1][g+1];
    } //сделано!
    public void who(IPlayer player)throws IOException{
        kw.write(Texts.DO_STEP(player.getName()));
        kw.flush();
    } //сделано!
    public void rewrite(int i, int g, int s)throws IOException{
        field[i+1][g+1] = s;
    }//сделано!
    public boolean check(boolean cb)throws IOException{
        if(isBadPosition()){
            return true;
        }
        if(isNonChekers()){
            return true;
        }
        if(isLastNumber()){
            return true;
        }
        if(isStalemate(cb)){
            return true;
        }
        return false;
    } //сделано!!
    public int getSize(){
        return SIZE;
    } //сделано!!
    public void finish() throws IOException{
        kw.close();
    }
    private void startField(){
        for(int j = 0; j<field.length;j++){
            field[0][j]=-1;
            field[field.length-1][j]=-1;
        }
        for(int i = 0; i<field.length;i++){
            field[i][0] = -1;
            field[i][field.length-1]= -1;
        }
        for(int i = 1; i<field.length-1;i++){
            for(int j = 1; j<field.length-1;j++){
                if(i==1){
                    field[i][j]=W;
                }else if(i==field.length-2){
                    field[i][j]=B;
                }else{
                    field[i][j]=E;
                }
            }
        }

    } //сделано!
    private int WhQuantity(){
        int count=0;
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(field[i+1][j+1]==W) count++;
            }
        }
        return count;
    } //сделано!
    private int BlQuantity(){
        int count=0;
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(field[i+1][j+1]==B) count++;
            }
        }
        return count;
    } //сделано!
    private boolean isBadPosition (){
        int count=0;
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(field[i+1][j+1]!=E) count++;
            }
        }
        if (count==2){
            System.out.println(Texts.WhWin);
            return true;
        }else{
            return false;
        }
    }
    private boolean isNonChekers(){
        b = true;
            for(int i=0; i<SIZE;i++){
                for(int j=0;j<SIZE;j++){
                    if(field[i+1][j+1]==W) b = false;
                }
            }
            if(b == true){
                System.out.println(Texts.BlWin);
                System.exit(0);
            }
            b = true;
            for(int i = 0; i < SIZE; i++){
                for(int g = 0; g < SIZE; g++){
                    if(field[i+1][g+1]==B) b = false;
                }
            }
            if(b == true){
                System.out.println(Texts.WhWin);
                return true;
            }else{
                return false;
            }
    }
    private boolean isLastNumber(){
         b = true;                                       
            for(int i = 0 ; i < SIZE; i++){
                if(field[0+1][i+1]==B) b = false;
            }
            if(b == false){
                System.out.println(Texts.BlWin);
                System.exit(0);
            }
            b = true;
            for(int i=0; i<SIZE; i++){
                if(field[2+1][i+1]==W) b = false;
            }
            if(b == false){
                System.out.println(Texts.WhWin);
                return true;
            }else{
                return false;
            }
    }
    private boolean isStalemate (boolean cb){
        b = false;
            boolean wh[] = new boolean[SIZE];
            boolean bl[] = new boolean[SIZE];
            for(int i=0 ; i<SIZE ;i++){
                wh[i] = true;
                bl[i] = true;
            }
            int iw = 0;
            int ib = 0;
            if(field[0+1][0+1]==W){
                if(field[1+1][1+1]!=B&&field[1+1][0+1]!=W){
                    wh[iw]=false;
                    iw++;
                }
            }
            if(field[0+1][1+1]==W){
                if(field[1+1][0+1]!=B&&field[1+1][1+1]!=E&&field[1+1][2+1]!=B){
                    wh[iw]= false;
                    iw++;
                }
            }
            if(field[0+1][2+1]==W){
                if(field[1+1][1+1]!=B&&field[1+1][2+1]!=E){
                    wh[iw]=false;
                    iw++;
                }
            }
            if(field[1+1][0+1]==W){
                if(field[2+1][0+1]!=E&&field[2+1][1+1]!=B){
                    wh[iw]=false;
                    iw++;
                }
            }else if (field[1+1][0+1]==B){
                if(field[0+1][0+1]!=E&&field[0+1][1+1]!=W){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[1+1][1+1]==W){
                if(field[2+1][0+1]!=B&&field[2+1][2+1]!=B&&field[2+1][1+1]!=E){
                    wh[iw]=false;
                    iw++;
                }
            }else if(field[1+1][1+1]==B){
                if(field[0+1][0+1]!=W&&field[0+1][2+1]!=W&&field[0+1][1+1]!=E){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[1+1][2+1]==W){
                if(field[2+1][2+1]!=E&&field[2+1][1+1]!=B){
                    wh[iw]=false;
                    iw++;
                }
            }else if(field[1+1][2+1]==B){
                if(field[0+1][2+1]!=E&&field[0+1][1+1]!=W){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[2+1][0+1]==B){
                if(field[1+1][0+1]!=E&&field[1+1][1+1]!=W){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[2+1][1+1]==B){
                if(field[1+1][0+1]!=W&&field[1+1][2+1]!=W&&field[1+1][1+1]!=E){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[2+1][2+1]==B){
                if(field[1+1][1+1]!=W&&field[1+1][2+1]!=E){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(cb == false){
                b=false;
                for(int i = 0; i<WhQuantity();i++){
                    if(wh[i]!=false){
                        b = true;
                    }
                }
                if(b == false){
                    System.out.println(Texts.BlWin);
                    return true;
                }else{
                    return false;
                }
            }else{
                b=false;
                for(int i = 0; i<BlQuantity();i++){
                    if(bl[i]!=false){
                        b = true;
                    }
                }
                if(b == false){
                    System.out.println(Texts.WhWin);
                    return true;
                }else{
                    return false;
                }
            }
    }
}