package cama.gui_cama;
import cama.core.IPlayer;
import cama.core.Judge;
import cama.core.Texts;

public class Gui {
    Judge judge;
    private int SIZE;
    String[][] field;

    public Gui(Judge jd_from_main){
        judge = jd_from_main;
        SIZE = judge.getSize();
    }

    public String showDoStep(IPlayer player){
        //return "                 " + player.getName() + " ходит:                     ";
        return "         "  ;
    }

    public String updateField(){
        return "";
    }

}
