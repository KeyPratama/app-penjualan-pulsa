package com.partials;
import javax.swing.JButton;

public class cBlueButton extends JButton {
  
    public cBlueButton(String text, int x, int y, int width){
        super();
       setText(text);
       setBounds(x, y, width, 35);
       setFont(cFonts.BUTTON_FONT);
       setBackground(cColor.Blue);
       setForeground(cColor.White);
       setBorder(null);
    }

}
