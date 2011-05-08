package cama;
import java.io.*;
import cama.core.Judge;

public class fixing {
    private BufferedWriter bw;
    private BufferedReader br;
    Judge ks;
   fixing(Judge ks_from_main) throws IOException {
        ks = ks_from_main;
        br = new BufferedReader(new FileReader("xod.txt"));
    }
    public void fix(int[][] ar, int x_num) throws IOException { //нужно получить обработанный массив
        int count = 0;
        bw = new BufferedWriter(new FileWriter("xod.txt", true));
        bw.write("################\r\n");
        bw.write("" + x_num + "\r\n");

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                bw.write("" + ar[i + 1][j + 1]);
            }
            bw.write("\r\n");
        }

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                if (ar[i + 1][j + 1] == ks.B) {
                    count += HodQuantity(ar[i][j], ar[i][j + 2], ar[i][j + 1]);
                }
            }
        }

        int[] businki = new int[count];
        String[] xod = new String[count];
        for (int i = 0; i < businki.length; i++) {
            businki[i] = 7;
            bw.write(businki[i] + " ");
        }
        bw.write("\r\n");


        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                if (ar[i + 1][j + 1] == ks.B) {
                    xod = setHod(xod, i + 1, j + 1, ar[i][j], ar[i][j + 2], ar[i][j + 1]);
                }
            }
        }

        for (int i = 0; i < xod.length; i++) {
            bw.write(xod[i] + " ");
        }
        bw.write("\r\n");
        bw.close();
    }
    public int check(int hod_num) throws IOException {
        int[][] ar = new int[ks.getSize()][ks.getSize()];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                ar[i][j] = ks.getCh(i, j);
            }
        }
        for (int i =0;;i++) {
            br.readLine();
            try{
                if(br.readLine().equals(""+hod_num)){
                    if(checking(ar)){
                        return i;
                    }
                }
            }
            catch(NullPointerException e){
                return -1;
            }
            br.readLine(); br.readLine();
        }
    }

    private boolean checking(int ar[][]) throws IOException {
        int count = 0;
        String s = "";
        for (int i = 0; i < ks.getSize(); i++) {
            for (int j = 0; j < ks.getSize(); j++) {
                s += ar[i][j];
            }
            if (br.readLine().equals(s)) {
                count++;
            }
        }
        if (count == ks.getSize()) {
            return true;
        }
        return false;
    }
    private int HodQuantity(int left, int right, int straight) {
        int count = 0;
        if (straight == ks.E) {
            count++;
        }
        if (right == ks.W) {
            count++;
        }
        if (left == ks.W) {
            count++;
        }
        return count;
    }
    private String[] setHod(String[] xod, int i, int j, int left, int right, int straight) {
        int count = 0;
        if (straight == ks.E) {
            while (xod[count] != null) {
                count++;
            }
            xod[count] = (i - 1) + "" + (j - 1) + "-" + (i - 2) + "" + (j - 1);
        }
        if (right == ks.W) {
            while (xod[count] != null) {
                count++;
            }
            xod[count] = (i - 1) + "" + (j - 1) + "-" + (i - 2) + (j);
        }
        if (left == ks.W) {
            while (xod[count] != null) {
                count++;
            }
            xod[count] = (i - 1) + "" + (j - 1) + "-" + (i - 2) + (j - 2);
        }
        return xod;
    }
}
