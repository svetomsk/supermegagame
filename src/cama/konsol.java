package cama;
import java.io.*;
class konsol {
    private BufferedWriter kw;
    private BufferedReader kr;
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
                kw.flush();
            }
            kw.write("\r\n");
            kw.flush();
        }
        kw.close();
    }
}
