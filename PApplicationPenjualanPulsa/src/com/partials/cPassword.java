package com.partials;

import javax.swing.JPasswordField;

public class cPassword extends JPasswordField {

     public cPassword(int x, int y, int width, boolean centerAlignment){
       
        super();
        setBounds(x,y,width,35);  //Set the position and size of the text field on the screen
        if(centerAlignment){
            setHorizontalAlignment(JPasswordField.CENTER);
           }
           setFont(cFonts.TEXT_FIELD_FONT);
           setForeground(cColor.Black);
           setBorder(new javax.swing.border.LineBorder(cColor.Blue, 1));
   
    }
}
