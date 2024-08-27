package com.partials;
import javax.swing.JLabel;

public class cErorLabel extends JLabel {

    public cErorLabel(String text, int x, int y, int width, boolean centerAlignment){
        super();
        setText(text);
        setBounds(x, y, width, 20);
        if(centerAlignment){
         setHorizontalAlignment(JLabel.CENTER);
        }
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.ERROR_LABEL_FONT);
        setForeground(cColor.Red);

    }

}
