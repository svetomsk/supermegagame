package wearegoingdown;
import java.io.*;
class Game_new{
    static public void main(String[]args) throws IOException {
    BufferedWriter gw = new BufferedWriter (new OutputStreamWriter (System.out));
    BufferedReader gr = new BufferedReader (new InputStreamReader (System.in));
    gw.write ("Hello! Enter your names:");
    String names = gr.readLine();
    String[] str = names.split(" ");
    gw.write ("\n"+str[0]+" goes");
    }
}
