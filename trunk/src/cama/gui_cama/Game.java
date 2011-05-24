package cama.gui_cama;

import cama.core.MPlayer;
import cama.core.IPlayer;
import cama.core.Judge;
import cama.core.Texts;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Game implements ActionListener {

    private int number;
    private JRadioButton jrbwhite;
    private JRadioButton jrbblack;
    private JFrame jfrm;
    private JTextField tf1;
    private JTextField tf2;
    private JLabel jlab1;
    private JLabel jlab2;
    private JLabel jlab3;
    private JLabel jlab4;
    private JLabel helplab;
    private JLabel field1;
    private JLabel field2;
    private JLabel field3;
    private JButton doStep;
    private boolean isFirst;
    static public JTextField coord;
    static public String s1 = null;
    static public String s2 = null;
    static public JLabel ErLab1;
    static public boolean isWhite;
    static public String space = "                         ";
    private String[][] ar;
    Judge ks = new Judge();
    IPlayer player1;
    IPlayer player2;

    Game() {
        jfrm = new JFrame("Игра \"Пешки 3х3\"");
        jfrm.setLayout(new FlowLayout());
        jfrm.setBounds(500, 300, 400, 150);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JMenuBar jmb = new JMenuBar();
        JMenu jmFile = new JMenu("Файл");
        JMenu jmHelp = new JMenu("Справка");
        JMenu jmNewGame = new JMenu("Новая игра");
        JMenuItem jmiExit = new JMenuItem("Выход");
        JMenuItem jmiHP = new JMenuItem("Два игрока");
        JMenuItem jmiMP = new JMenuItem("Игра с компьютером");
        JMenuItem jmi2MP = new JMenuItem("Рубилище двух компьютеров");

        JMenuItem jmiRules = new JMenuItem("Правила");

        jmFile.add(jmNewGame);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
        jmNewGame.add(jmiHP);
        jmNewGame.add(jmiMP);
        jmNewGame.add(jmi2MP);
        jmHelp.add(jmiRules);
        jmb.add(jmFile);
        jmb.add(jmHelp);

        jmiExit.addActionListener(this);
        jmiRules.addActionListener(this);
        jmiHP.addActionListener(this);
        jmiMP.addActionListener(this);
        jmi2MP.addActionListener(this);
        /*Менюшка*/

        jlab1 = new JLabel();
        jlab1.setText("<html>Добро пожаловать в игру \"Пешки 3х3\"");
        JButton MP = new JButton("Игра с компьютером за белых");
        MP.addActionListener(this);

        jfrm.add(jlab1);
        jfrm.add(MP);
        jfrm.setJMenuBar(jmb);
        jfrm.setVisible(true);
    }
    private void HP2Frame() {
        jfrm.setVisible(false);
        JFrame frm = new JFrame("Два игрока");
        frm.setLayout(new FlowLayout());
        frm.setBounds(500, 300, 175, 215);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlab2 = new JLabel("Первый игрок: ");
        jlab3 = new JLabel("Второй игрок");
        ErLab1 = new JLabel("");
        JButton butt = new JButton("Старт");
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);

        frm.add(jlab2);
        frm.add(tf1);
        frm.add(jlab3);
        frm.add(tf2);

        butt.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if (tf1.getText().equals("") || tf2.getText().equals("")) {
                    ErLab1.setText("<html>Вы не ввели имена!<br>" + "Попробуйте еще раз!");
                } else {
                    player1.setName(tf1.getText());
                    player2.setName(tf2.getText());
                    StartGame(tf1.getText(), tf2.getText());
                    //app.run();
                }
            }
        });
        tf1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if (tf1.getText().equals("") || tf2.getText().equals("")) {
                    ErLab1.setText("<html>Вы не ввели имена!<br>" + "Попробуйте еще раз!");
                } else {
                    player1.setName(tf1.getText());
                    player2.setName(tf2.getText());
                    StartGame(tf1.getText(), tf2.getText());
                    //app.run();
                }
            }
        });
        tf2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if (tf1.getText().equals("") || tf2.getText().equals("")) {
                    ErLab1.setText("<html>Вы не ввели имена!<br>" + "Попробуйте еще раз!");
                } else {
                    player1.setName(tf1.getText());
                    player2.setName(tf2.getText());
                    StartGame(tf1.getText(), tf2.getText());
                    //app.run();
                }
            }
        });


        frm.add(butt);
        frm.add(ErLab1);
        frm.setVisible(true);
    }
    private void MPFrame() {
        jfrm.setVisible(false);
        final JFrame frm = new JFrame("�?грок с CPU");
        frm.setLayout(new FlowLayout());
        frm.setBounds(500, 300, 190, 190);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlab1 = new JLabel("Введите ваше имя:");
        tf1 = new JTextField(10);
        ErLab1 = new JLabel();
        jrbwhite = new JRadioButton("Белые", true);
        jrbblack = new JRadioButton("Черные");
        ButtonGroup bg = new ButtonGroup();

        JButton jbtnStart = new JButton("Старт!");

        jbtnStart.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if (tf1.getText().equals("")) {
                    ErLab1.setText("<html>Вы не ввели имя!<br>" + "Попробуйте еще раз!");
                } else {
                    if (jrbwhite.isSelected()) {
                        player1 = new GHPlayer(ks);
                        player2 = new MPlayer(ks, true);
                        frm.setVisible(false);

                        player1.setName(tf1.getText());
                        player2.setName("CPU");

                        StartGame(tf1.getText(), "CPU");
                        //app.run();
                    } else {
                        player1 = new MPlayer(ks, true);
                        player2 = new GHPlayer(ks);
                        frm.setVisible(false);

                        player1.setName("CPU");
                        player2.setName(tf1.getText());

                        StartGame("CPU", tf1.getText());
                        //app.run();
                    }
                }
            }
        });
        tf1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if (tf1.getText().equals("")) {
                    ErLab1.setText("<html>Вы не ввели имя!<br>" + "Попробуйте еще раз!");
                } else {
                    if (jrbwhite.isSelected()) {
                        player1 = new GHPlayer(ks);
                        player2 = new MPlayer(ks, true);
                        frm.setVisible(false);
                        StartGame(tf1.getText(), "CPU");
                    } else {
                        player1 = new MPlayer(ks, true);
                        player2 = new GHPlayer(ks);
                        frm.setVisible(false);
                        StartGame("CPU", tf1.getText());
                    }
                }
            }
        });

        bg.add(jrbwhite);
        bg.add(jrbblack);

        frm.add(jlab1);
        frm.add(tf1);
        frm.add(jrbwhite);
        frm.add(jrbblack);
        frm.add(jbtnStart);
        frm.add(ErLab1);
        frm.setVisible(true);
    }
    private void showRules() {
        JFrame frm = new JFrame("Правила");
        frm.setLayout(new FlowLayout());
        frm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frm.setBounds(500, 300, 300, 240);
        JLabel lab = new JLabel();
        helplab = new JLabel();
        JButton example = new JButton("А можно пример?");
        JButton MPlayer = new JButton("А как играть с компьютером?");
        lab.setText(Texts.HTML_GREETING);

        example.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                helplab.setText("Конечно, a1-a2");
            }
        });
        MPlayer.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                helplab.setText("Файл->Новая игра->Игра с компьютером");
            }
        });


        frm.add(lab);
        frm.add(example);
        frm.add(MPlayer);
        frm.add(helplab);
        frm.setVisible(true);
    }





















    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Выход")) {
            System.exit(0);
        } else if (ae.getActionCommand().equals("Правила")) {
            showRules();
        } else if (ae.getActionCommand().equals("Рубилище двух компьютеров")) {
            player1 = new MPlayer(ks, true);
            player2 = new MPlayer(ks, true);
            jfrm.setVisible(false);

            StartGame("CPU1", "CPU2");
            //app.run();
        } else if (ae.getActionCommand().equals("Игра с компьютером")) {
            MPFrame();
        } else if (ae.getActionCommand().equals("Два игрока")) {
            player1 = new GHPlayer(ks);
            player2 = new GHPlayer(ks);
            HP2Frame();
        } else if (ae.getActionCommand().equals("Игра с компьютером за белых")) {
            player1 = new GHPlayer(ks);
            player2 = new MPlayer(ks, true);
            jfrm.setVisible(false);

            StartGame("Игрок 1", "CPU");
            //app.run();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new OldMain();
            }
        });
    }

















       private void StartGame(String s1, String s2) {
        isWhite = true;
        isFirst = true;
        ar = ks.getField();

        player1.setName(s1);
        player2.setName(s2);
        jfrm.setVisible(false);

        JFrame frm = new JFrame("�?гра");
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
        //  jlab3.setText("                 "+player1.getName()+" ходит:");
        jlab3.setText("                 " + player1.getName() + " ходит:                     ");



        jlab4.setText("                             a b c                           ");
        field1 = new JLabel();
        field1 = new JLabel(space + "1 " + ar[0][0] + " " + ar[0][1] + " " + ar[0][2] + space);
        field2 = new JLabel(space + "2 " + ar[1][0] + " " + ar[1][1] + " " + ar[1][2] + space);
        field3 = new JLabel(space + " 3 " + ar[2][0] + " " + ar[2][1] + " " + ar[2][2] + space);

        coord = new JTextField(3);
        ErLab1 = new JLabel("");
        JLabel space1 = new JLabel("                       ");
        JLabel space2 = new JLabel("                       ");
        doStep = new JButton("Хожу!");

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
        if (player1.isModulePlayer()) {
            doGame();
        }
    }



    private void doGame() {
        if (isWhite) {
            try {
                player1.doStep(true);
            } catch (Throwable exc) {
                System.out.println("FATAL ERROR!");
            }
            if (ks.checkIfSomeoneWon(true)) {
                System.out.println("win!");
                updateField();
                ErLab1.setText("            " + player1.getName() + " выиграл!      ");
                coord.setText("");
                doStep.setEnabled(false);
                coord.setEnabled(false);
            } else {
                if (isWhite == false) {
                    updateField();
                    jlab3.setText("                 " + player2.getName() + " ходит:                     ");
                    if (player2.isModulePlayer()) {
                        doGame();
                    }
                } else {
                    System.out.println("ошибка!");
                }
                coord.setText("");
            }
        } else {
            try {
                player2.doStep(true);
            } catch (Throwable exc) {
                System.out.println("FATAL ERROR!");
            }
            if (ks.checkIfSomeoneWon(false)) {
                updateField();
                ErLab1.setText("             " + player2.getName() + " выиграл!      ");
                coord.setText("");
                doStep.setEnabled(false);
                coord.setEnabled(false);
            } else {
                if (isWhite) {
                    updateField();
                    jlab3.setText("                 " + player1.getName() + " ходит:                     ");
                    if (player1.isModulePlayer()) {
                        doGame();
                    }
                } else {
                    System.out.println("ошибка!");
                }
                coord.setText("");
            }
        }
    }

    private void updateField() {
        ar = ks.getField();
        field1.setText(space + "1 " + ar[0][0] + " " + ar[0][1] + " " + ar[0][2] + space);
        field2.setText(space + "2 " + ar[1][0] + " " + ar[1][1] + " " + ar[1][2] + space);
        field3.setText(space + " 3 " + ar[2][0] + " " + ar[2][1] + " " + ar[2][2] + space);
    }
}
