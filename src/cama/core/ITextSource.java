package cama.core;
import java.io.*;
public interface ITextSource {
   String getStepText() throws IOException;
   void writeText(String s) throws IOException;
}
