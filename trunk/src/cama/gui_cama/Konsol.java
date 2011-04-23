package gui_cama;
class Konsol {
    Konsol(){
        startField();
    }
    private int SIZE = 3;
    private int[][] field = new int [SIZE+2][SIZE+2]; //Сменил на рамку!!!
    private boolean b;

    public int W = 1;
    public int B = 2;
    public int E = 0;

    public String[][] getField(){
        String ar[][] = new String[SIZE][SIZE];
        for(int i=0;i<ar.length;i++){
            for(int j=0;j<ar.length;j++){
                if(getCh(i,j)==W){
                    ar[i][j]=Texts.Wh;
                }else if(getCh(i,j)==B){
                    ar[i][j]=Texts.Bl;
                }else{
                    ar[i][j]=Texts.Em;
                }
                
            }
        }
        return ar;
    }
    public int[][] getFullField(){
        return field;
    }
    public int getCh(int i, int g){
        return field[i+1][g+1];
    }
    public void rewrite(int i, int g, int s){
        field[i+1][g+1] = s;
    }
    public boolean check(boolean isWhite){
        if(isBadPosition()){
            return true;
        }
        if(isNonChekers()){
            return true;
        }
        if(isLastNumber()){
            return true;
        }
        if(isStalemate(isWhite)){
            return true;
        }
        return false;
    }
    public int getSize(){
        return SIZE;
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

    }
    private int WhQuantity(){
        int count=0;
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(field[i+1][j+1]==W) count++;
            }
        }
        return count;
    }
    private int BlQuantity(){
        int count=0;
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(field[i+1][j+1]==B) count++;
            }
        }
        return count;
    }
    private boolean isBadPosition (){
        int count=0;
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(field[i+1][j+1]!=E) count++;
            }
        }
        if (count==2){
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
                return true;
            }
            b = true;
            for(int i = 0; i < SIZE; i++){
                for(int g = 0; g < SIZE; g++){
                    if(field[i+1][g+1]==B) b = false;
                }
            }
            if(b == true){
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
                return true;
            }
            b = true;
            for(int i=0; i<SIZE; i++){
                if(field[2+1][i+1]==W) b = false;
            }
            if(b == false){
                return true;
            }else{
                return false;
            }
    }
    private boolean isStalemate (boolean isWhite){
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
            if(isWhite == false){
                b=false;
                for(int i = 0; i<WhQuantity();i++){
                    if(wh[i]!=false){
                        b = true;
                    }
                }
                if(b == false){
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
                    return true;
                }else{
                    return false;
                }
            }
    }
}