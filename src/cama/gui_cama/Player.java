package gui_cama;
abstract class Player implements IPlayer {
    private String name;
    public boolean isMPlayer;
    public String getName(){
        return name;
    }
    public void setName(String value){
        name = value;
    }
    public boolean isModulePlayer(){
        return isMPlayer;
    }
}
