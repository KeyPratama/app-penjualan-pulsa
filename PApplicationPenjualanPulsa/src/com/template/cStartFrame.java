package com.template;
import javax.swing.*;
import com.partials.cColor;
import com.partials.cFonts;
import com.partials.cLinkKeluar;
// import com.partials.cFormLabel;
// import com.partials.cTextField;
// import com.partials.cTextPassword;
// import com.partials.cErorLabel;
// // import com.partials.cLinkStart;
// import com.partials.cBlueButton;
public class cStartFrame extends JFrame {

    public JPanel bg = new JPanel();
    public JPanel card = new JPanel();
    public cLinkKeluar linkKeluar = new cLinkKeluar(1168);
    public JLabel titleLabel = new JLabel("Login Admin");
    // public cFormLabel labelUsername = new cFormLabel("Username",0, 84, 450, true);
    // public cTextField txtUsername = new cTextField(65, 114, 320, true);
    // public cErorLabel txtErorLabel1 = new cErorLabel("Username kosong/salah!!", 0, 149, 450, true );
    // public cFormLabel labelPassword = new cFormLabel("Password", 0, 170, 450, true);
    // public cTextPassword txtPassword = new cTextPassword(65, 200, 320, true);
    // public cErorLabel txtErorLabel2 = new cErorLabel("Password kosong/salah!!", 0, 235, 450, true );
    // public cLinkStart Link1 = new cLinkStart("menuju kemana?", 300 );
    // public cBlueButton btnSubmit = new cBlueButton("Login", 65, 270, 320);
    // public cErorLabel txtLupaPassword = new cErorLabel("Lupa Password/Username?", 0, 315, 450, true);
   
    public cStartFrame(){
        super();
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(false);
        setDefaultCloseOperation(cStartFrame.EXIT_ON_CLOSE);
     
        // setting backgroud
        bg.setBackground(cColor.Blue);
        bg.setBounds(0,0, 1280, 720);
        bg.setLayout(null);

        // setting card
        card.setBackground(cColor.White90);
        card.setBounds(415, 75, 450, 520 );
        card.setLayout(null);

        // setting label
        titleLabel.setFont(cFonts.TITLE_START_FONT);
        titleLabel.setForeground(cColor.Black);
        titleLabel.setBounds(0, 30, 450, 40);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);

        
        //tambahkan semua method item
        card.add(titleLabel);
      //   card.add(labelUsername);
      //   card.add(txtUsername);
      //   card.add(txtErorLabel1);
      //   card.add(labelPassword);
      //   card.add(txtPassword);
      //   card.add(txtErorLabel2);
      //   card.add(txtLupaPassword);
      // //  card.add(Link1);
      //   card.add(btnSubmit);
        bg.add(linkKeluar);
        bg.add(card);
        add(bg);
    }

    public cStartFrame(String title){
          this();
          setTitle(title);
    }

}
