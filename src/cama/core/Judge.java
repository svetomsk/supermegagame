package cama.core;
import java.io.*;
public class Judge {

    private BufferedWriter kw;
    private int SIZE = 3;
    private int[][] field = new int[SIZE + 2][SIZE + 2]; //Сменил на рамку!!!
    private boolean b;
    public static final int W = 1;
    public static final int B = 2;
    public static final int E = 0;

    public Judge() {
        kw = new BufferedWriter(new OutputStreamWriter(System.out));
        startField();
    }



    //start
    public void start() throws IOException {
        startField();
        kw.write(Texts.GREETING);
        kw.write(Texts.START);
        kw.flush();
    }
    private void startField() {
        for (int j = 0; j < field.length; j++) {
            field[0][j] = -1;
            field[field.length - 1][j] = -1;
        }
        for (int i = 0; i < field.length; i++) {
            field[i][0] = -1;
            field[i][field.length - 1] = -1;
        }
        for (int i = 1; i < field.length - 1; i++) {
            for (int j = 1; j < field.length - 1; j++) {
                if (i == 1) {
                    field[i][j] = W;
                } else if (i == field.length - 2) {
                    field[i][j] = B;
                } else {
                    field[i][j] = E;
                }
            }
        }

    }

    //getSomething
    public int getCh(int i, int g) {
        return field[i + 1][g + 1];
    }
    public int getSize() {
        return SIZE;
    } 
    public String[][] getField() {
        String ar[][] = new String[SIZE][SIZE];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                if (getCh(i, j) == W) {
                    ar[i][j] = Texts.Wh;
                } else if (getCh(i, j) == B) {
                    ar[i][j] = Texts.Bl;
                } else {
                    ar[i][j] = Texts.Em;
                }

            }
        }
        return ar;
    }
    
    //проверка на корректность хода и выполнение хода
    public void handleStep(Step step, boolean isWhite) { // а зачем булеан??
        if (isStepCorrect(step, isWhite)) {
            int temp = field[step.row1 + 1][step.col1 + 1];
            field[step.row1 + 1][step.col1 + 1] = 0;
            field[step.row2 + 1][step.col2 + 1] = temp;
        }
    }
    public boolean isStepCorrect(Step st, boolean isWhite){
        int x1 = st.row1;
        int x2 = st.row2;
        int y1 = st.col1;
        int y2 = st.col2;

        int cell1;
        int cell2;

        try{
            cell1 = getCh(x1,y1);
            cell2 = getCh(x2,y2);
        }catch(ArrayIndexOutOfBoundsException e){
           return false;
        }
        

        if (isWhite) {
            if (cell1 == W && cell2 == B) {
                if ((x2 - x1 == 1 && y2 - y1 == 1) || (x2 - x1 == 1 && y1 - y2 == 1)) {
                    return true;
                }
                return false;
            } else if (cell1 == W && cell2 == E) {
                if (x2 - x1 == 1 && y2 - y1 == 0) {
                    return true;
                }
                return false;
            } else {
                return false;
            }
        }else{
            if(cell1 == B && cell2 == W){
                if ((x2 - x1 == -1 && y2 - y1 == -1) || (x2 - x1 == -1 && y1 - y2 == -1)) {
                    return true;
                }
                return false;
            }else if(cell1 == B && cell2 == E){
                if (x2 - x1 == -1 && y2 - y1 == 0) {
                    return true;
                }
                return false;
            } else {
                return false;
            }
        }

    }



    //проверка на выигрыш/проигрыш
    public boolean checkIfSomeoneWon(boolean cb) {
        if (isBadPosition()) {
            return true;
        }
        if (isNonChekers()) {
            return true;
        }
        if (isLastNumber()) {
            return true;
        }
        if (isStalemate(cb)) {
            return true;
        }
        return false;
    }
    private int WhQuantity() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i + 1][j + 1] == W) {
                    count++;
                }
            }
        }
        return count;
    } 
    private int BlQuantity() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i + 1][j + 1] == B) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isBadPosition() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i + 1][j + 1] != E) {
                    count++;
                }
            }
        }
        if (count == 2) {
            System.out.println(Texts.WhWin);
            return true;
        } else {
            return false;
        }
    }
    private boolean isNonChekers() {
        b = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i + 1][j + 1] == W) {
                    b = false;
                }
            }
        }
        if (b == true) {
            System.out.println(Texts.BlWin);
            System.exit(0);
        }
        b = true;
        for (int i = 0; i < SIZE; i++) {
            for (int g = 0; g < SIZE; g++) {
                if (field[i + 1][g + 1] == B) {
                    b = false;
                }
            }
        }
        if (b == true) {
            System.out.println(Texts.WhWin);
            return true;
        } else {
            return false;
        }
    }
    private boolean isLastNumber() {
        b = true;
        for (int i = 0; i < SIZE; i++) {
            if (field[0 + 1][i + 1] == B) {
                b = false;
            }
        }
        if (b == false) {
            System.out.println(Texts.BlWin);
            System.exit(0);
        }
        b = true;
        for (int i = 0; i < SIZE; i++) {
            if (field[2 + 1][i + 1] == W) {
                b = false;
            }
        }
        if (b == false) {
            System.out.println(Texts.WhWin);
            return true;
        } else {
            return false;
        }
    }
    private boolean isStalemate(boolean cb) {
        b = false;
        boolean wh[] = new boolean[SIZE];
        boolean bl[] = new boolean[SIZE];
        for (int i = 0; i < SIZE; i++) {
            wh[i] = true;
            bl[i] = true;
        }
        int iw = 0;
        int ib = 0;
        if (field[0 + 1][0 + 1] == W) {
            if (field[1 + 1][1 + 1] != B && field[1 + 1][0 + 1] != W) {
                wh[iw] = false;
                iw++;
            }
        }
        if (field[0 + 1][1 + 1] == W) {
            if (field[1 + 1][0 + 1] != B && field[1 + 1][1 + 1] != E && field[1 + 1][2 + 1] != B) {
                wh[iw] = false;
                iw++;
            }
        }
        if (field[0 + 1][2 + 1] == W) {
            if (field[1 + 1][1 + 1] != B && field[1 + 1][2 + 1] != E) {
                wh[iw] = false;
                iw++;
            }
        }
        if (field[1 + 1][0 + 1] == W) {
            if (field[2 + 1][0 + 1] != E && field[2 + 1][1 + 1] != B) {
                wh[iw] = false;
                iw++;
            }
        } else if (field[1 + 1][0 + 1] == B) {
            if (field[0 + 1][0 + 1] != E && field[0 + 1][1 + 1] != W) {
                bl[ib] = false;
                ib++;
            }
        }
        if (field[1 + 1][1 + 1] == W) {
            if (field[2 + 1][0 + 1] != B && field[2 + 1][2 + 1] != B && field[2 + 1][1 + 1] != E) {
                wh[iw] = false;
                iw++;
            }
        } else if (field[1 + 1][1 + 1] == B) {
            if (field[0 + 1][0 + 1] != W && field[0 + 1][2 + 1] != W && field[0 + 1][1 + 1] != E) {
                bl[ib] = false;
                ib++;
            }
        }
        if (field[1 + 1][2 + 1] == W) {
            if (field[2 + 1][2 + 1] != E && field[2 + 1][1 + 1] != B) {
                wh[iw] = false;
                iw++;
            }
        } else if (field[1 + 1][2 + 1] == B) {
            if (field[0 + 1][2 + 1] != E && field[0 + 1][1 + 1] != W) {
                bl[ib] = false;
                ib++;
            }
        }
        if (field[2 + 1][0 + 1] == B) {
            if (field[1 + 1][0 + 1] != E && field[1 + 1][1 + 1] != W) {
                bl[ib] = false;
                ib++;
            }
        }
        if (field[2 + 1][1 + 1] == B) {
            if (field[1 + 1][0 + 1] != W && field[1 + 1][2 + 1] != W && field[1 + 1][1 + 1] != E) {
                bl[ib] = false;
                ib++;
            }
        }
        if (field[2 + 1][2 + 1] == B) {
            if (field[1 + 1][1 + 1] != W && field[1 + 1][2 + 1] != E) {
                bl[ib] = false;
                ib++;
            }
        }
        if (cb == false) {
            b = false;
            for (int i = 0; i < WhQuantity(); i++) {
                if (wh[i] != false) {
                    b = true;
                }
            }
            if (b == false) {
                System.out.println(Texts.BlWin);
                return true;
            } else {
                return false;
            }
        } else {
            b = false;
            for (int i = 0; i < BlQuantity(); i++) {
                if (bl[i] != false) {
                    b = true;
                }
            }
            if (b == false) {
                System.out.println(Texts.WhWin);
                return true;
            } else {
                return false;
            }
        }
    }

    public void finish() throws IOException {
        kw.close();
    }
}