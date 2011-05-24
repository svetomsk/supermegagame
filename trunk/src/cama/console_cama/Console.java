package cama.console_cama;
import cama.core.IPlayer;
import cama.core.Judge;
import cama.core.Texts;
import java.io.*;

public class Console {
    private BufferedWriter kw;
    Judge jd;
    int SIZE;
    String[][] field;

    public Console(Judge jd_from_main){
        kw = new BufferedWriter(new OutputStreamWriter(System.out));
        jd = jd_from_main;
        SIZE = jd.getSize();
    }
    
    public void printDoStep(IPlayer player) throws IOException {
        kw.write(Texts.DO_STEP(player.getName()));
        kw.flush();
    }

    public void printField() throws IOException {
        field = jd.getField();
        kw.write("  a b c\r\n");
        for (int i = 0; i < SIZE; i++) {
            kw.write((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                kw.write(field[i][j]+" ");
            }
            kw.write("\r\n");
        }
        kw.flush();
    }
}
