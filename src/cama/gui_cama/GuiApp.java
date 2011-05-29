package cama.gui_cama;

import java.io.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import cama.core.IPlayer;
import cama.core.MPlayer;
import cama.core.Judge;
import cama.core.Texts;

public class GuiApp {
    
    private IPlayer player1;
    private IPlayer player2;
    private Judge judge;
    private Gui gui;

    private boolean isSomebodyWon;
    static public boolean isWhite;
    static public boolean isFirst;
    private String ar[][];
    private JLabel jlab1;
    private JLabel jlab2;
    private JLabel jlab3;
    private JLabel jlab4;
    private JLabel field1;
    private JLabel field2;
    private JLabel field3;
    static public String space = "                         ";
    
    static public JLabel ErLab1;
    static public JTextField coord;
    static public JButton doStep;

    public GuiApp(Judge judge, IPlayer pl1, IPlayer pl2, JButton doStep, JLabel ErLab1, JTextField coord) {
        this.judge = judge;
        this.player1 = pl1;
        this.player2 = pl2;
        isSomebodyWon = false;
        gui = new Gui(judge);

        GuiApp.doStep = doStep;
        GuiApp.ErLab1 = ErLab1;
        GuiApp.coord = coord;
    }

    public void run() {
        StartGame();
        doGame();
    }

    private void StartGame() {
        isWhite = true;
        isFirst = true;
        ar = judge.getField();


        JFrame frm = new JFrame("Игра");
        frm.setLayout(new FlowLayout());
        frm.setBounds(500, 300, 200, 330);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setResizable(false);

        jlab1 = new JLabel();
        jlab2 = new JLabel();
        jlab3 = new JLabel();
        jlab4 = new JLabel();

        jlab1.setText("Белые: " + player1.getName());
        jlab2.setText("Черные: " + player2.getName());
        //jlab3.setText("                 " + player1.getName() + " ходит:                     ");


        jlab4.setText("                             a b c                           ");
        field1 = new JLabel();
        field1 = new JLabel(space + "1 " + ar[0][0] + " " + ar[0][1] + " " + ar[0][2] + space);
        field2 = new JLabel(space + "2 " + ar[1][0] + " " + ar[1][1] + " " + ar[1][2] + space);
        field3 = new JLabel(space + " 3 " + ar[2][0] + " " + ar[2][1] + " " + ar[2][2] + space);

        //coord = new JTextField(3);
        ErLab1 = new JLabel("");
        JLabel space1 = new JLabel("                       ");
        JLabel space2 = new JLabel("                       ");
        //doStep = new JButton("Хожу!");

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

    private void doGame() {
        int i = 0;
        while (!isSomebodyWon) {
            if (i == 0) {
                jlab3.setText(gui.showDoStep(player1));
                //jlab3.setText(player1.getName());
                player1.doStep(true);
                gui.updateField();
                if (judge.checkIfSomeoneWon(true)) {
                    isSomebodyWon = true;
                }
                i = 1;
            } else {
                jlab3.setText(gui.showDoStep(player2));
                //jlab3.setText(player2.getName());
                player2.doStep(true);
                gui.updateField();
                if (judge.checkIfSomeoneWon(true)) {
                    isSomebodyWon = true;
                }
                i = 0;
            }
        }
    }

    private void updateField() {
        ar = judge.getField();
        field1.setText(space + "1 " + ar[0][0] + " " + ar[0][1] + " " + ar[0][2] + space);
        field2.setText(space + "2 " + ar[1][0] + " " + ar[1][1] + " " + ar[1][2] + space);
        field3.setText(space + " 3 " + ar[2][0] + " " + ar[2][1] + " " + ar[2][2] + space);
    }
}
