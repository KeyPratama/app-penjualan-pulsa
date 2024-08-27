package com.partials;

import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class cSidebarMenu extends JLabel{

    public java.awt.event.MouseAdapter sidebarAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            setBackground(cColor.Blue);
            setForeground(cColor.White);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            setBackground(cColor.Blue);
            setForeground(cColor.White);
        }
    };

    public java.awt.event.MouseAdapter sidebarNonAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            setBackground(cColor.Blue);
            setForeground(cColor.White);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            setBackground(cColor.White);
            setForeground(cColor.Gray);
        }
    };

    public cSidebarMenu(String text, int y){
        super();
        this.setText("     "+ text);
        this.setBounds(0,y,230,50); // x,
        this.setOpaque(true);
        this.setFont(cFonts.SIDEBAR_FONT);
        this.setForeground(cColor.Gray);
        this.setBackground(cColor.White);
    
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });
        setSidebarNonAktif();
    }

    public void setSidebarAktif(){
        try {
            removeMouseListener(sidebarNonAktif);
            addMouseListener(sidebarAktif);
        } catch (Exception e) {
            
        }
    }

    public void setSidebarNonAktif(){
        try  {
            removeMouseListener(sidebarAktif);
            addMouseListener(sidebarNonAktif);
        } catch (Exception e) {
            
        }
    }
}
