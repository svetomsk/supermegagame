package cama;
import java.io.*;
class Konsol {
    private BufferedWriter kw;
    private BufferedReader kr;
    private String[][] field= new String[3][3];
    public boolean b;
    public void start()throws IOException{
        kr = new BufferedReader(new FileReader("kwtext.txt"));
        kw = new BufferedWriter(new OutputStreamWriter(System.out));
        kw.write("Добро пожаловать в игру \"Пешки 3х3\"!\nДля того, чтобы сделать ход, выберите\nкоординаты пешки, поставьте тире\nи выберите координаты места, куда\nхотите поставить пешку. Удачи!\n");
        for(int i = 0; i <5; i++){
            kw.write(kr.readLine()+"\r\n");
            kw.flush();
        }        
        kr.close();
    }
    public void getField() throws IOException{
        kw = new BufferedWriter(new OutputStreamWriter(System.out));
        kr  = new BufferedReader(new FileReader("now.txt"));
        for(int i =0;i<3;i++){
            String[]k = kr.readLine().split(" ");
            for(int g = 0;g<3;g++){
                kw.write(k[g]+" ");
                field[i][g] = k[g];
                kw.flush();
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
        if(player.b = true){
            kw.write(player.name + " goes: \r\n");
            b = false;
            kw.flush();
        }else{
            kw.write(player.name + " goes: \r\n");
            b = true;
            kw.flush();
        }
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
        b = true;
        // ПРОВЕРКА НА НАЛИЧИЕ ПЕШЕК
            for(int i = 0; i < 3; i++){                     
                for(int g = 0; g < 3; g++){
                    if(field[i][g].equals("W")) b = false;
                }
            }
            if(b == true){
                kw.write("Black win!");
                kw.flush();
                System.exit(0);
            }
            b = true;
            for(int i = 0; i < 3; i++){
                for(int g = 0; g < 3; g++){
                    if(field[i][g].equals("B")) b = false;
                }
            }
            if(b == true){
                kw.write("While win!");
                kw.flush();
                System.exit(0);                             
            }
            //ПРОВЕРКА НА НАЛИЧИЕ ПЕШКИ В ПОСЛЕДНЕМ РЯДУ
            b = true;                                       
            for(int i = 0 ; i < 3; i++){
                if(field[0][i].equals("B")) b = false;                
            }
            if(b == false){
                kw.write("Black win!");
                kw.flush();
                System.exit(0);
            }
            b = true;
            for(int i=0; i<3; i++){
                if(field[2][i].equals("W")) b = false;
            }
            if(b == false){
                kw.write("White win!");
                kw.flush();
                System.exit(0);                                 
            }
            //ПРОВЕРКА НА ПАТ
            b = false;
            boolean wh[] = new boolean[6];
            boolean bl[] = new boolean[6];
            for(int i=0 ; i<6 ;i++){
                wh[i] = true;
                bl[i] = true;
            }
            int iw = 0;
            int ib = 0;
            if(field[0][0].equals("W")){
                if(!field[1][1].equals("B")&&!field[1][0].equals("E")){
                    wh[iw]=false;
                    iw++;
                }
            }
            if(field[0][1].equals("W")){
                if(!field[1][0].equals("B")&&!field[1][1].equals("E")&&!field[1][2].equals("B")){
                    wh[iw]= false;
                    iw++;
                }
            }
            if(field[0][2].equals("W")){
                if(!field[1][1].equals("B")&&!field[1][2].equals("E")){
                    wh[iw]=false;
                    iw++;
                }
            }
            if(field[1][0].equals("W")){
                if(!field[2][0].equals("E")&&!field[2][1].equals("B")){
                    wh[iw]=false;
                    iw++;
                }
            }else if (field[1][0].equals("B")){
                if(!field[0][0].equals("E")&&!field[0][1].equals("W")){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[1][1].equals("W")){
                if(!field[2][0].equals("B")&&!field[2][2].equals("B")&&!field[2][1].equals("E")){
                    wh[iw]=false;
                    iw++;
                }
            }else if(field[1][1].equals("B")){
                if(!field[0][0].equals("W")&&!field[0][2].equals("W")&&!field[0][1].equals("E")){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[1][2].equals("W")){
                if(!field[2][2].equals("E")&&!field[2][1].equals("B")){
                    wh[iw]=false;
                    iw++;
                }
            }else if(field[1][2].equals("B")){
                if(!field[0][2].equals("E")&&!field[0][1].equals("W")){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[2][0].equals("B")){
                if(!field[1][0].equals("E")&&!field[1][1].equals("W")){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[2][1].equals("B")){
                if(!field[1][0].equals("W")&&!field[1][2].equals("W")&&field[1][1].equals("E")){
                    bl[ib] = false;
                    ib++;
                }
            }
            if(field[2][2].equals("B")){
                if(!field[1][1].equals("W")&&!field[1][2].equals("E")){
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
                    kw.write("Black win!");
                    kw.flush();
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
                    kw.write("White win!");
                    kw.flush();
                    System.exit(0);
                }
            }


    }
    private int wh_q(){
        int count =0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(field[i][j].equals("W")) count++;
            }
        }
       // System.out.println("White: "+count);
        return count;
    }
    private int bl_q(){
        int count =0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(field[i][j].equals("B")) count++;
            }
        }
        //System.out.println("Black is: "+count);
        return count;
    }
    private void badpos (){
        int count=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(!field[i][j].equals("E")) count++;
            }
        }
        if (count==2){
            System.out.println("White win!");
            System.exit(0);
        }
    }
}