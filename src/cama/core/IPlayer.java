package cama.core;
import java.io.*;

public interface IPlayer {
    public void doStep(boolean isWhite);
    public String getName();
    public void setName(String value);
    public boolean isModulePlayer();
}
