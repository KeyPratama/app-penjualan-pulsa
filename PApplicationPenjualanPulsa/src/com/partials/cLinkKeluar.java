package com.partials;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class cLinkKeluar extends JLabel {
 
    public cLinkKeluar(int x){
        super();
        setBounds(x, 0, 82, 70);
        setText("CLOSE");
        setFont(cFonts.LINK_EXIT_FONT);
        setForeground(cColor.White);
        addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {

            setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            
            }
        public void mouseExited(java.awt.event.MouseEvent e){
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        }
        public void mouseClicked(java.awt.event.MouseEvent e){
            Object[] options = { "YES", "CANCEL" }; // Array yang berisi pilihan yang akan ditampilkan dalam dialog
int konfirmasi = JOptionPane.showOptionDialog(
    null, // Komponen parent dari dialog (dalam hal ini, null berarti tidak ada parent)
    "Yakin ingin keluar aplikasi?", // Pesan yang ditampilkan dalam dialog
    "konfirmasi keluar", // Judul dialog
    JOptionPane.DEFAULT_OPTION, // Tipe default dari opsi dialog
    JOptionPane.QUESTION_MESSAGE, // Tipe ikon/pesan dari dialog
    null, // Icon yang akan ditampilkan dalam dialog (null berarti tidak ada icon)
    options, // Array pilihan yang akan ditampilkan
    options[0] // Pilihan default yang akan terpilih saat dialog pertama kali muncul
);

   if(konfirmasi == 0){
    System.exit(0);
   } 
        }
        });
    }
}
