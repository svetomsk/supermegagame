package cama;
import java.io.*;
class konsol {
    private BufferedWriter kw;
    private BufferedReader kr;
    private String[][] field= new String[3][3];
    public boolean b;
    public void start()throws IOException{
        kr = new BufferedReader(new FileReader("kwtext.txt"));
        kw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i <4; i++){
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
        }else if(player.b = false){
            kw.write(player.name + " goes: \r\n");
            b = true;
            kw.flush();
        }
    }
    public void rewrite(int i, int g, String s)throws IOException{
        kw = new BufferedWriter(new FileWriter("now.txt"));
        field[i][g]  = s;
        for(int f = 0;f<3;f++){
            for(int t =0;t<3;t++){
                kw.write(field[f][t]+" ");
            }
            kw.write("\r\n");
        }
        kw.close();
    }
}
