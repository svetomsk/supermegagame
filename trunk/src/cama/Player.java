package cama;
abstract class Player implements IPlayer {
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String value){
        name = value;
    }
}
