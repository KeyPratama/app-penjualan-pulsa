package com.partials;
import javax.swing.JRadioButton;


public class cRadioButton extends JRadioButton{

    public cRadioButton(String text, String value, int x, int y, int width) {
        super(text);
        setBounds(x, y, width, 20);
        setFont(cFonts.RADIO_BUTTON_FONT);
        setForeground(cColor.Red);
        setBackground(cColor.White);
        setHorizontalAlignment(JRadioButton.CENTER);
        setVerticalAlignment(JRadioButton.CENTER);
        setActionCommand(value);
        
    }
}
