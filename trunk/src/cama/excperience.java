package excperience;
import java.io.*;
public class Main {
    public static void main(String[] args) {
    }
}

class Cama {
    private BufferedReader br;
    //Получение поля field
    //Получение size
    public void analyze(int num_xod) throws IOException {
        br = new BufferedReader(new FileReader("xod.txt"));
        int len = 3;
        String[][] field = new String[len][len];
        String[][] field1 = new String[len][len];
        String arr[] = new String[len];
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
        String bus[] = br.readLine().split(" ");
        String xod[] = br.readLine().split(" ");
        int dl = 0;
        for(int i=0;i<bus.length;i++){
            dl+=Integer.valueOf(bus[i]);
        }
        String choise[] = new String[dl];
       /* for(int i=0;i<dl;i++){
            for(int j=0;j<Integer.valueOf(bus[i]);j++){
                choise[j]
            }
        }*/
    }

    private boolean equalsFields(String[][] field, String[][] field1, int len) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (field[i][j].equals(field1[i][j])) {
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
}
