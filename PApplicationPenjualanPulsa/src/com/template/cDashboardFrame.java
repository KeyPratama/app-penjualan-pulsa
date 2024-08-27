package com.template;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.partials.cColor;
import com.partials.cFonts;
import com.partials.cLinkKeluar;
// import com.partials.cLabelInfo;
// import com.partials.cBigFont;
// // import com.partials.cRadioButton;
// // import com.partials.cCheckbox;
// import com.partials.cSidebarMenu;
// import com.partials.cTextArea;
// import com.partials.cScrollPane;
// import com.partials.cTable;

public  class cDashboardFrame extends JFrame {

    public JPanel sidebar = new JPanel();
    public JPanel header = new JPanel();
    public JPanel main = new JPanel();
    public JPanel content = new JPanel();
    

    public JLabel appText = new JLabel("PulsaKu");
    public JLabel roleText = new JLabel("Role | Nama User");
    public JLabel menuTitle = new JLabel("Beranda");
    public JLabel copyrightText = new JLabel("Copyright 2024 RDP");

    private cLinkKeluar exitLink = new cLinkKeluar(938);

    // public cLabelInfo InfoPulsa = new cLabelInfo("Sisa pulsa anda", 25, 25);
    // public cBigFont valuePulsa = new cBigFont("15000", 25, 60);
    // //public cRadioButton rd1 = new cRadioButton("Pilihan 1", "pilihan1", 25, 150, 100);
    // //public cCheckbox cb1 = new cCheckbox("Checkbox 1", "checkbox1", 200, 150, 120);
    // public cSidebarMenu berandaMenu = new cSidebarMenu("Beranda", 70);
    // public cTextArea txtArea = new cTextArea(false);
    // public cScrollPane sp = new cScrollPane(txtArea, 25, 150, 300, 100);
    // public cTable tableUser;
    // public cScrollPane spTable;

    public cDashboardFrame(String title) {
        super(title);
        setSize(1280,720); // Size pada frame
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        setLocationRelativeTo(null);
        setLayout(null);

        sidebar.setBackground(cColor.White);
        sidebar.setBounds(0, 0, 230, 720);
        sidebar.setLayout(null);

        header.setBackground(cColor.Blue);
        header.setBounds(230, 0, 1050, 70);
        header.setLayout(null);

        main.setBackground(cColor.White_Gray);
        main.setBounds(230, 70, 1050, 650);
        main.setLayout(null);

        content.setBackground(cColor.White);
        content.setBounds(30, 70, 990, 470);
        content.setLayout(null);

        appText.setFont(cFonts.APP_FONT);
        appText.setBounds(0,0,230,70);
        appText.setHorizontalAlignment(JLabel.CENTER);
        appText.setVerticalAlignment(JLabel.CENTER);
        appText.setForeground(cColor.Blue);

 
        roleText.setFont(cFonts.ROLE_FONT);
        roleText.setBounds(30,0,400,70);
        roleText.setVerticalAlignment(JLabel.CENTER);
        roleText.setForeground(cColor.White);

        menuTitle.setFont(cFonts.MENU_TITLE_FONT);
        menuTitle.setBounds(30,10,600,50);
        menuTitle.setVerticalAlignment(JLabel.CENTER);
        menuTitle.setForeground(cColor.Black_Gray);

        copyrightText.setFont(cFonts.TEXT_FIELD_FONT);
        copyrightText.setBounds(0,560,1050,20);
        copyrightText.setHorizontalAlignment(JLabel.CENTER);
        copyrightText.setVerticalAlignment(JLabel.CENTER);
        copyrightText.setForeground(cColor.Gray);

        // txtArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, laborum.");

        //   // Data dan kolom untuk membuat tab;
        //   // Data dan kolom untuk membuat tab;
        //   String[] dataUserHeader = {"Nama","Username", "umur"};
        //   String[][] dataUser = {
        //       {"Ahmad Syaifullah", "ahmad_syf", "20"},
        //       {"Rizky Alfarizi",    "rizki_alfa",   "18"},
        //       {"Rizki Maulana", "rizki_mzl", "18"}
        //   };
        //  javax.swing.table.DefaultTableModel userTableModel = new javax.swing.table.DefaultTableModel(dataUser, dataUserHeader);

        //  tableUser = new cTable(userTableModel);
        //  spTable = new cScrollPane(tableUser, 25, 300, 500, 100);


    //     content.add(InfoPulsa);
    //     content.add(valuePulsa);
    //     content.add(sp);
    //     content.add(spTable);
    //   //  content.add(rd1);
    //  //   content.add(cb1);

       header.add(exitLink);
       sidebar.add(appText);
    //     sidebar.add(berandaMenu);
        header.add(roleText);
       

        main.add(content);
        main.add(menuTitle);
        main.add(copyrightText);
        add(sidebar);
        add(header);
        add(main);
        
    }

}