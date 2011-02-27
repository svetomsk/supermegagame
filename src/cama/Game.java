package cama;
import java.io.*;
class Game
{
    static public void main(String[]args) throws IOException
    {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Konsol ks = new Konsol();
        IPlayer h1 = null;
        IPlayer h2 = null;
        String str="";
        ks.start();
        w.write("\r\n"+Texts.CHOISE);
        w.flush();
        while(!str.equals("1")&&!str.equals("2")){
            str = r.readLine();
            if(str.equals("1")){
                h1 = new HPlayer(ks);
                h2 = new MPlayer(ks);
            }else if(str.equals("2")){
                h1 = new HPlayer(ks);
                h2 = new HPlayer(ks);
            }else{
                w.write(Texts.TRY);
                w.flush();
            }
        }
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
            h1.setName(s[0]);
            h2.setName(s[1]);
        int i = 0;
        for(;;){
            if(i == 0){
                ks.who(h1);
                h1.xod(true);
                ks.check(true);
                i = 1;
            }else{
                ks.who(h2); 
                h2.xod(false);
                ks.check(false);
                i = 0;
            }
        }
    }
}

