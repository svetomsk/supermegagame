package cama;
import java.io.*;
public class fixing {
    private BufferedWriter bw;

    public void fix(int[][] ar, int x_num) throws IOException {
        int count = 0;
        bw = new BufferedWriter(new FileWriter("xod.txt", true));
        bw.write("################\r\n");
        bw.write("" + x_num+"\r\n");

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                bw.write("" + ar[i][j]);
            }
            bw.write("\n");
        }

        
        for (int i = 0; i < ar.length; i++){            //суммирование всех возможных ходов
            for (int j = 0; j < ar.length; j++){
                if (ar[i][j] == Texts.B){
                    count += ability(ar[i-1][j-1],ar[i-1][j+1],ar[i-1][j],i ,j ,ar.length);//Надо будет сделать массив с рамкой!!!!!!
                }
            }
        }
        int[] bus = new int [count];
        for(int i = 0; i< bus.length;i++){
            bus[i]=7;
            bw.write(bus[i]+" ");
        }
    }

    private int ability(int left, int right, int straight, int i, int j, int length) {
        int count = 0;
        if (j == 0) {
            if (straight == Texts.E) {
                count++;
            }
            if (right == Texts.W) {
                count++;
            }
        }else if(j ==length-1){
            if(left == Texts.W){
                count++;
            }
            if(straight == Texts.E){
                count++;
            }
        }else{
            if(left == Texts.W){
                count++;
            }
            if(straight == Texts.E){
                count++;
            }
            if(right == Texts.W){
                count++;
            }
        }
        return count;
    }
}
