package cama.gui_cama;

import cama.core.ITextSource;
import javax.swing.*;
import java.awt.event.*;

public class GuiTextSource implements ITextSource {
    
    String s;

    public GuiTextSource(JButton doStep, final JTextField coord){
        
        doStep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s = coord.getText();
            }
        });
        coord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s = coord.getText();
            }
        });

        s = null;
    }

    public String getStepText(){
        if(s==null){
            getStepText();
        }
        
        return s;
    }

    public void writeText(String s) {
        GuiApp.ErLab1.setText(s);
    }

}
