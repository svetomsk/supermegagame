package cama;
import java.io.*;
class Game
{
    static public void main(String[]args) throws IOException
    {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter now = new BufferedWriter(new FileWriter("now.txt"));
        String[]nowstr ={"o o o","▫ ▫ ▫","• • •"};
        for(int i =0; i < 3; i++){
            now.write(nowstr[i]+"\r\n");
        }
        now.close();
        HP h1 = new HP();
        HP h2 = new HP();
        Konsol ks = new Konsol();
        ks.start();       
        w.write(Texts.NAME);
        w.flush();        
        String s[] = r.readLine().split(" ");
        if(s.length!=2){
            while(s.length!=2){
                w.write(Texts.TRY);
                w.flush();
                s = r.readLine().split(" ");
            }
        }
        if(s.length==2){
            h1.name = s[0];
            h2.name = s[1];
        }
        w.write("\r\n");     
        int i = 0;
        for(;;){
            if(i == 0){
                ks.who(h1);
                h1.xod(true);
                ks.readField("now.txt");
                ks.check(true);
                i = 1;
            }else{
                ks.who(h2); 
                h2.xod(false);
                ks.readField("now.txt");
                ks.check(false);
                i = 0;
            }
        }
    }
}

