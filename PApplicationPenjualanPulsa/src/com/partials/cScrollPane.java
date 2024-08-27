package com.partials;
import javax.swing.JScrollPane;

public class cScrollPane extends JScrollPane {

    public cScrollPane(java.awt.Component view, int x, int y, int width, int height) 
    {
        super(view);
        setBounds(x, y, width, height);
        setBackground(cColor.White);
        setBorder(new javax.swing.border.LineBorder(cColor.Blue, 1));


    }
}
