package com.partials;
import javax.swing.JTextArea;

public class cTextArea extends JTextArea  {

    public cTextArea(boolean editable){
        super();
        this.setFont(cFonts.TEXT_FIELD_FONT);
        this.setBackground(cColor.White);
        if (editable) {
            this.setForeground(cColor.Black);
        }else{
            this.setForeground(cColor.Red);
            this.setEditable(false);
        }
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
    }

    public cTextArea (String text, int x, int y, boolean editable)
    {
      this(editable);
      setBounds(x, y, 360, 200);
    }

}
