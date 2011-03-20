package cama;
import java.io.*;
import java.util.Random;
class Excp {
    private Konsol ks;
    Excp(Konsol ks_from_main) {
        ks = ks_from_main;
    }
    private BufferedReader br;
    private int len = ks.getSize();
    private int field[][] = ks.field();
    int [][] field1 = new int[len][len];
    public void analyze(int num_xod) throws IOException {
        br = new BufferedReader(new FileReader("xod.txt"));
        for(int i=0;i<7;i++){               //прогон курсора до нужного места
            br.readLine();
        }
        Random r = new Random();
        String arr[] = new String[len];
        String ar[] = null;
        int dl=0;
        
        while (true) {                                          //Нахождение нужного поля
            if (br.readLine().equals("" + num_xod)) {
                for (int i = 0; i < len; i++) {
                    arr = br.readLine().split(" ");
                    System.arraycopy(arr, 0, field1[i], 0, len);
                }
                if (equalsFields(field, field1, len)) {
                    break;
                }
            }else{
                for (int i=0; i<len+3;i++) {
                    br.readLine();
                }
            }
        }
        
        int[] bus = setArrayBus(br.readLine(), ar);
        String [] xod = setArrayXod(br.readLine(), ar);
        for(int i=0;i<ar.length;i++){   
            dl+=bus[i];
        }
        int choise[] = new int [dl];
        int count = 0;
        for(int i=0;i<bus.length;i++){
            for(int j=0;j<bus[i];j++){
                choise[count]=i;
                count++;
            }
        }
        int ind = r.nextInt(dl);//!!! ВАЖНО dl или dl-1?? !!!
        String[] hod = xod[ind].split("-");
        
    }

    private boolean equalsFields(int[][] field, int[][] field1, int len) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (field[i][j]==field1[i][j]) {
                    count++;
                }
            }
            if (i == len - 1) {
                if (count == len * len) {
                    return true;
                }
            }
        }
        return false;
    }
    private int[] setArrayBus(String s, String ar[]){
        ar = s.split(" ");
        int bus[] = new int [ar.length];
        System.arraycopy(ar, 0, bus, 0, ar.length);
        return bus;
    }
    private String[] setArrayXod(String s, String[] ar){
        ar = s.split(" ");
        String xod[] = new String [ar.length];
        System.arraycopy(ar, 0, xod, 0, ar.length);
        return xod;
    }
}
