package cama.console_cama;

import java.io.*;
import cama.core.ITextSource;
import cama.core.Texts;

public class ConsoleTextSource implements ITextSource {

    BufferedReader br;
    BufferedWriter bw;

    ConsoleTextSource(BufferedWriter bw, BufferedReader br) {
        this.bw = bw;
        this.br = br;
    }

    public String getStepText() {
        try {
            return br.readLine();
        } catch (IOException exc) {
            System.out.println(Texts.IOException);
            return null;
        }
        
    }

    public void writeText(String s){
        try{
            bw.write(s);
            bw.flush();
        } catch(IOException exc){
            System.out.println(Texts.IOException);
        }
        
    }
}
