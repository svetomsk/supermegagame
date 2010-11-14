package cama;
import java.io.*;
class Game
{
    static public void main(String[]args) throws IOException
    {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter now = new BufferedWriter(new FileWriter("now.txt"));
        String[]nowstr ={"W W W","E E E","B B B"};
        for(int i =0; i < 3; i++){
            now.write(nowstr[i]+"\r\n");
        }
        now.close();
        HP h1 = new HP();
        HP h2 = new HP();
        Konsol ks = new Konsol();
        ks.start();       
        w.write("\r\n"+"Enter your names: ");
        w.flush();        
        h1.b = true;
        h2.b = false;
        String s[] = r.readLine().split(" ");
        if(s.length!=2){
            while(s.length!=2){
                w.write("Try again!\r\n");
                w.flush();
                s = r.readLine().split(" ");
            }
        }
        if(s.length==2){
            h1.name = s[0];
            h2.name = s[1];
        }
        w.write("\r\n");
        String online = "none";        
        int i = 0;
        while(!online.equals("exit")){           
            if(!online.equals("exit")){
                if(i == 0){
                    ks.who(h1);                    
                    h1.xod(true);
                    ks.readField("now.txt");
                    ks.check(true);
                    i = 1;
                }else if(i == 1){
                    ks.who(h2); 
                    h2.xod(false);
                    ks.readField("now.txt");
                    ks.check(false);
                    i = 0;
                }
            }else{                
                System.exit(1);
            }
        }
        w.close();
    }
}
