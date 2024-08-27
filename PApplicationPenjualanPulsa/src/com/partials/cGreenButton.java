package com.partials;

public class cGreenButton extends cBlueButton {
    public cGreenButton(String text, int x, int y, int width){
        super(text, x, y, width);
       setFont(cFonts.BUTTON_FONT);
       setBackground(cColor.Green);
       setForeground(cColor.White);
       setBorder(null);
}
}
