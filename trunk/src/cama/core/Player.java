package cama.core;
abstract public class Player implements IPlayer {
    private String name;
    private boolean isMPlayer;
	
    public String getName(){
        return name;
    }
    public void setName(String value){
        name = value;
    }
    public boolean isModulePlayer(){
        return isMPlayer;
    }

	protected void setModulePlayer(boolean value){
		isMPlayer = value;
	}
}
