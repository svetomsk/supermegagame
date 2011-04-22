package gui_cama;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Main implements ActionListener{
    private JFrame jfrm;

    private JTextField tf1;
    private JTextField tf2;

    private JLabel jlab1;
    private JLabel jlab2;
    private JLabel jlab3;
    private JLabel jlab4;
    private JLabel field1;
    private JLabel field2;
    private JLabel field3;
    private JLabel ErLab2;

    public JTextField coord;
    public JLabel ErLab1;

    private String[][] ar;
    private int n;
    private boolean isWhite;
    String space = "                         ";

    Konsol ks;
    HPlayer p1;
    HPlayer p2;
    Main(){
        jfrm = new JFrame("Frame");
        jfrm.setLayout(new FlowLayout());
        jfrm.setBounds(500, 300, 175, 250);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlab1 = new JLabel("Игра \"Пешки 3х3\"");
        jlab2 = new JLabel("Первый игрок: ");
        jlab3 = new JLabel("Второй игрок");
        ErLab1 = new JLabel("");
        ErLab2 = new JLabel("");
        JButton butt = new JButton ("Старт");
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);

        jfrm.add(jlab1);
        jfrm.add(jlab2);
        jfrm.add(tf1);
        jfrm.add(jlab3);
        jfrm.add(tf2);

        butt.addActionListener(this);
        tf1.addActionListener(this);
        tf2.addActionListener(this);


        jfrm.add(butt);
        jfrm.add(ErLab1);
        jfrm.add(ErLab2);
        jfrm.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(tf1.getText().equals("") || tf2.getText().equals("")){
            ErLab1.setText("Вы не ввели имена!");
            ErLab2.setText("Попробуйте еще раз!");
        }else{
            StartGame(tf1.getText(), tf2.getText());
        }
    }


    private void StartGame(String s1, String s2){
        ks = new Konsol();
        p1 = new HPlayer(ks);
        p2 = new HPlayer(ks);
        isWhite = true;
        ar = ks.getField();
        
        p1.setName(s1);
        p2.setName(s2);
        jfrm.setVisible(false);

        JFrame frm = new JFrame("Игра");
        frm.setLayout(new FlowLayout());
        frm.setBounds(500, 300, 205, 250);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlab4 = new JLabel();
        jlab1.setText("Белые: "+p1.getName());
        jlab2.setText("Черные: "+p2.getName());
        jlab3.setText("                 "+p1.getName()+" ходит:                     ");
        jlab4.setText("                             a b c                           ");
        field1 = new JLabel(space+"1 "+ar[0][0]+" "+ar[0][1]+" "+ar[0][2]+space);
        field2 = new JLabel(space+"2 "+ar[1][0]+" "+ar[1][1]+" "+ar[1][2]+space);
        field3 = new JLabel(space+" 3 "+ar[2][0]+" "+ar[2][1]+" "+ar[2][2]+space);
        coord = new JTextField(3);
        ErLab1 = new JLabel("");
        JLabel space1 = new JLabel("                       ");
        JLabel space2 = new JLabel("                       ");
        JButton doStep = new JButton("Хожу!");

        doStep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                doGame();
            }
        });
        coord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                doGame();
            }
        });

        frm.add(jlab1);
        frm.add(jlab2);
        frm.add(jlab3);
        frm.add(jlab4);
        frm.add(field1);
        frm.add(field2);
        frm.add(field3);
        frm.add(space1);
        frm.add(coord);
        frm.add(space2);
        frm.add(doStep);
        frm.add(ErLab1);



        frm.setVisible(true);
    }
    private void doGame(){
        if(isWhite){
            n = p1.doStep(true, coord.getText());
            if(isAllRight(n)){
                if(ks.check(true)){
                    updateField();
                    ErLab1.setText(p1.getName()+" выиграл!");
                }else{
                    updateField();
                    jlab3.setText("                 "+p2.getName()+" ходит:                     ");
                    isWhite = false;
                }
            }else{
                System.out.println("Ошибка! Доработать!!!!!");
            }
            coord.setText("");
        }else{
            p2.doStep(false, coord.getText());
            if(isAllRight(n)){
                if(ks.check(false)){
                    updateField();
                    ErLab1.setText(p2.getName()+" выиграл!");
                }else{
                    updateField();
                    jlab3.setText("                 "+p1.getName()+" ходит:                     ");
                    isWhite = true;
                }
            }else{
                System.out.println("Ошибка! Доработать!!!!!");
            }
            coord.setText("");
        }
    }
    private boolean isAllRight(int n){
        if(n==0){
            return true;
        }
        return false;
    }
    private void updateField(){
        ar = ks.getField();
        field1.setText(space+"1 "+ar[0][0]+" "+ar[0][1]+" "+ar[0][2]+space);
        field2.setText(space+"2 "+ar[1][0]+" "+ar[1][1]+" "+ar[1][2]+space);
        field3.setText(space+" 3 "+ar[2][0]+" "+ar[2][1]+" "+ar[2][2]+space);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}

