package com.partials;


public class cRedButton extends cBlueButton {
    public cRedButton(String text, int x, int y, int width){
        super(text, x, y, width);
       setFont(cFonts.BUTTON_FONT);
       setBackground(cColor.Red);
       setForeground(cColor.White);
       setBorder(null);
}
}
