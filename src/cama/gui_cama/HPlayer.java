package gui_cama;
class HPlayer extends Player {
    public boolean b;
    private Konsol ks;
    Main ob;
    HPlayer(Konsol ks_from_main) {
        ks = ks_from_main;
        ob = new Main();
    }
    public int doStep(boolean isWhite, String s) {
        Boolean ok = false;
   //     while(ok!=true){
   //     String s = ob.coord.getText();
            if (s.equals("GK")) {
                System.out.println("Texts.CHEAT1");
                System.exit(0);
            }


            String s1[], s2[], s3[];
            int x1, x2, y1, y2;
            x1 = x2 = y1 = y2 = 0;
            try {
                s1 = s.split("-");
                s2 = s1[0].split("");
                s3 = s1[1].split("");
                y1 = makeY(s2[1]);
                y2 = makeY(s3[1]);
                x1 = makeX(s2[2]);
                x2 = makeX(s3[2]);
            } catch (ArrayIndexOutOfBoundsException e) {
                return 1;
            } catch (NumberFormatException er) {
                return 1;
            }


            if (x1 < ks.getSize() && x2 < ks.getSize() && y1 < ks.getSize() && y2 < ks.getSize()
                    && x1 >= 0 && x2 >= 0 && y1 >= 0 && y2 >= 0) {
                int cell = ks.getCh(x1, y1);
                int cellch = ks.getCh(x2, y2);
                if (isWhite == true) {
                    if (cell == ks.E) {
                        return 2;
                    } else if (cell == ks.W) {
                        if (cellch == ks.W) {
                            return 3;
                        } else if (cellch == ks.B) {
                            if ((x2 - x1 == 1 && y2 - y1 == 1) || (x2 - x1 == 1 && y1 - y2 == 1)) {
                                ks.rewrite(x2, y2, ks.W);
                                ks.rewrite(x1, y1, ks.E);
                                return 0;
                            } else {
                                return 4;
                            }
                        } else {
                            if (x2 - x1 == 1 && y2 - y1 == 0) {
                                ks.rewrite(x2, y2, ks.W);
                                ks.rewrite(x1, y1, ks.E);
                                return 0;
                            } else {
                                return 4;
                            }
                        }
                    } else {
                        return 5;
                    }
                } else {
                    if (cell == ks.E) {
                        return 6;
                    } else if (cell == ks.B) {
                        if (cellch == ks.B) {
                            return 3;
                        } else if (cellch == ks.W) {
                            if ((x2 - x1 == -1 && y2 - y1 == -1) || (x2 - x1 == -1 && y1 - y2 == -1)) {
                                ks.rewrite(x2, y2, ks.B);
                                ks.rewrite(x1, y1, ks.E);
                                return 0;
                            } else {
                                return 4;
                            }
                        } else {
                            if (x2 - x1 == -1 && y2 - y1 == 0) {
                                ks.rewrite(x2, y2, ks.B);
                                ks.rewrite(x1, y1, ks.E);
                                return 0;
                            } else {
                                return 4;
                            }
                        }
                    } else {
                        return 5;
                    }
                }
            } else {
                return 7;
            }
//        }

    }
    private int makeY(String m) {
        int y = 0;
        if (m.equals("a")) {
            y = 0;
        }
        if (m.equals("b")) {
            y = 1;
        }
        if (m.equals("c")) {
            y = 2;
        }
        return y;
    }
    private int makeX(String m) {
        return Integer.valueOf(m) - 1;
    }
}
