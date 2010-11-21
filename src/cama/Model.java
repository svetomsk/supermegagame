package wearegoingdown;
import java.io.*;
class Model_new{
    public boolean check(Cell from, Cell to){
        boolean check = true;
        int fst= from.color;
        int sec = to.color;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(from.color == 2 || to.color == 2){
            check = false;
        }else if(from.color == to.color){
            check = false;
        }else{
            if(from.color == 0){
                if(to.color == 2){
                    check = false;
                }else if(to.color == 0){
                    check = false;
                }else if(to.color == 1){
                    
                }
            }
        }
        return check;
    }
}
