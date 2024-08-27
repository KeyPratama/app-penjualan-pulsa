package com.partials;
import javax.swing.JCheckBox;


public class cCheckbox extends JCheckBox{

    public cCheckbox(String text, String value, int x, int y, int width){
        super(text);
        setBounds(x, y, width, 20);
        setFont(cFonts.RADIO_BUTTON_FONT);
        setForeground(cColor.Red);
        setBackground(cColor.White);
        setHorizontalAlignment(JCheckBox.CENTER);
        setVerticalAlignment(JCheckBox.CENTER);
        setActionCommand(value);
    }
}
