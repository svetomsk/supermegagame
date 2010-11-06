package cama;
import java.io.*;
class Game
{
    static public void main(String[]args) throws IOException
    {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Konsol ks = new Konsol();
        ks.start();        
        w.write("\r\n"+"Enter your names: ");
        w.flush();
        String[]s = r.readLine().split(" ");
        w.close();
    }
}
