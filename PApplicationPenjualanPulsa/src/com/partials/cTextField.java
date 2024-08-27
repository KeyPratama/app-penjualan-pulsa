package com.partials;

import javax.swing.JTextField;
public class cTextField extends JTextField{

    public cTextField(int x, int y, int width, boolean centerAlignment){
       
        super();
        setBounds(x,y,width,35);  //Set the position and size of the text field on the screen
        if(centerAlignment){
            setHorizontalAlignment(JTextField.CENTER);
           }
           setFont(cFonts.TEXT_FIELD_FONT);
           setForeground(cColor.Black);
           setBorder(new javax.swing.border.LineBorder(cColor.Blue, 1));
   
    }

}
