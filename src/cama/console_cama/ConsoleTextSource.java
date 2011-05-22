package cama.console_cama;

import java.io.*;
import cama.core.ITextSource;

public class ConsoleTextSource implements ITextSource {

    BufferedReader br;
    BufferedWriter bw;

    ConsoleTextSource(BufferedWriter bw, BufferedReader br) {
        this.bw = bw;
        this.br = br;
    }

    public String getStepText() throws IOException {
        return br.readLine();
    }
}
