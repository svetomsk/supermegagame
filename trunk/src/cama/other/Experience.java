package cama.other;
import java.io.*;
import java.util.Random;
import cama.core.Judge;

class Excp {
    private Judge ks;
    private BufferedReader br;
    private BufferedWriter bw;
    Excp(Judge ks_from_main) throws IOException {
        ks = ks_from_main;
        br = new BufferedReader(new FileReader("xod.txt"));
    }  
    public void analyze(int num_xod) throws IOException {
        int[][] ar = setArray();
        if(checkFields(num_xod, ar)>0){
        }else{
            //fixField(ks.getFullField(), num_xod);
        }
    }
    private int[][] setArray(){
        int[][] ar = new int[ks.getSize()][ks.getSize()];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                ar[i][j] = ks.getCh(i, j);
            }
        }
        return ar;
    }
    private int checkFields(int hod_num, int ar[][]) throws IOException {
        for (int i = 0;; i++) {
            br.readLine();
            try {
                if (br.readLine().equals("" + hod_num)) {
                    if (equalsFields(ar)) {
                        return i;
                    }
                }else{
                    for(int j = 0; j<ks.getSize();j++){
                        br.readLine();
                    }
                }
            } catch (NullPointerException e) {
                return -1;
            }
            br.readLine();
            br.readLine();
        }
    } //проверить
    private boolean equalsFields(int ar[][]) throws IOException {
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
    private void fixField(int[][] ar, int x_num) throws IOException {
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


    private int[][] makeHod(int [][]ar){
        return ar;
    }




















    private int[] setArrayBus(String s, String ar[]) {
        ar = s.split(" ");
        int bus[] = new int[ar.length];
        System.arraycopy(ar, 0, bus, 0, ar.length);
        return bus;
    }

    private String[] setArrayXod(String s, String[] ar) {
        ar = s.split(" ");
        String xod[] = new String[ar.length];
        System.arraycopy(ar, 0, xod, 0, ar.length);
        return xod;
    }
}
