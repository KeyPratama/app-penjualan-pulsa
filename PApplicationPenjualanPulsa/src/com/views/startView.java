package com.views;
import com.template.cStartFrame;

import javax.swing.JOptionPane;

import com.partials.*;
import com.program.Controller;
import com.program.model;


public class startView extends cStartFrame {

    // instansiasi untuk login customer
    private cFormLabel labelNoHpLoginCustomer = new cFormLabel("Nomor Hp", 0, 84, 450, true);
    private cTextField txtNoHPLoginCustomer   = new cTextField(65, 114, 320, true);
    private cErorLabel eErrorNoHPLoginCustomer = new cErorLabel("No HP kosong/salah!!", 0, 149, 450, true);
    private cFormLabel labelPassword = new cFormLabel("Password", 0, 183, 450, true);
    private cPassword txtPassword  = new cPassword(65, 213, 320, true);
    private cErorLabel eErrorPassword = new cErorLabel("Password kosong/salah!!", 0, 248, 450, true);
    private cBlueButton btnLoginCustomer  = new cBlueButton("LOGIN", 65, 282 ,320);
    private cLinkStart toLoginMitraLoginCustomer = new cLinkStart("Sudah punya akun mitra?", 322);
    private cLinkStart toDaftarMitraLoginCustomer = new cLinkStart("Daftar sebagai mitra", 342);
    private cLinkStart toDaftarCustomerLoginCustomer = new cLinkStart("Belum punya akun customer?", 362);
    private cLinkStart toLoginAdminLoginCustomer = new cLinkStart("Login admin", 382);

    // instansiasi/komponen untuk daftar login customer
    private cFormLabel labelNamaDaftarCustomer = new cFormLabel("Nama", 0, 84, 450, true);
    private cTextField txtNamaDaftarCustomer   = new cTextField(65, 114, 320, true);
    private cErorLabel eErrorNamaDaftarCustomer = new cErorLabel("Nama kosong/salah!!", 0, 149, 450, true);
    private cFormLabel labelNoHpDaftarCustomer = new cFormLabel("Nomor Hp", 0, 183, 450, true);
    private cTextField txtNoHpDaftarCustomer   = new cTextField(65, 213, 320, true);
    private cErorLabel eErrorNoHpDaftarCustomer = new cErorLabel("No HP kosong/salah!!", 0, 248, 450, true);
    private cFormLabel labelPasswordDaftarCustomer = new cFormLabel("Password", 0, 282, 450, true);
    private cPassword txtPasswordDaftarCustomer  = new cPassword(65, 312, 320, true);
    private cErorLabel eErrorPasswordDaftarCustomer = new cErorLabel("Password kosong/salah!!", 0, 347, 450, true);
    private cBlueButton btnDaftarCustomer  = new cBlueButton("LOGIN", 65, 381 ,320);
    private cLinkStart toLoginMitraDaftarCustomer = new cLinkStart("Sudah punya akun mitra?", 421);
    private cLinkStart toDaftarMitraDaftarCustomer = new cLinkStart("Daftar sebagai mitra", 441);
    private cLinkStart toLoginCustomerDaftarCustomer = new cLinkStart("Belum punya akun customer?", 461);
    private cLinkStart toLoginAdminDaftarCustomer = new cLinkStart("Login admin", 481);

    // komponen untuk login mitra
    private cFormLabel labelEmailLoginMitra = new cFormLabel("Email", 0, 84, 450, true);
    private cTextField txtEmailLoginMitra   = new cTextField(65, 114, 320, true);
    private cErorLabel eErrorEmailLoginMitra = new cErorLabel("Email kosong/salah!!", 0, 149, 450, true);
    private cFormLabel labelPasswordLoginMitra = new cFormLabel("Password", 0, 183, 450, true);
    private cPassword txtPassworLoginMitra  = new cPassword(65, 213, 320, true);
    private cErorLabel eErrorPasswordLoginMitra = new cErorLabel("Password kosong/salah!!", 0, 248, 450, true);
    private cBlueButton btnLoginMitra  = new cBlueButton("LOGIN", 65, 282 ,320);
    private cLinkStart toDaftarMitraLoginMitra = new cLinkStart("Belum punya akun mitra?", 322);
    private cLinkStart toDaftarCustomerLoginMitra = new cLinkStart("Daftar sebagai customer", 342);
    private cLinkStart toLoginCustomerLoginMitra = new cLinkStart("Belum punya akun customer?", 362);
    private cLinkStart toLoginAdminLoginMitra = new cLinkStart("Login admin", 382);

    // instansiasi/komponen untuk daftar login mitra
    private cFormLabel labelNamaDaftarMitra= new cFormLabel("Nama", 0, 84, 450, true);
    private cTextField txtNamaDaftarMitra  = new cTextField(65, 114, 320, true);
    private cErorLabel eErrorNamaDaftarMitra= new cErorLabel("Nama kosong/salah!!", 0, 149, 450, true);
    private cFormLabel labelEmailDaftarMitra= new cFormLabel("Email", 0, 183, 450, true);
    private cTextField txtEmailDaftarMitra  = new cTextField(65, 213, 320, true);
    private cErorLabel eErrorEmailDaftarMitra= new cErorLabel("Email kosong/salah!!", 0, 248, 450, true);
    private cFormLabel labelPasswordDaftarMitra= new cFormLabel("Password", 0, 282, 450, true);
    private cPassword txtPasswordDaftarMitra = new cPassword(65, 312, 320, true);
    private cErorLabel eErrorPasswordDaftarMitra= new cErorLabel("Password kosong/salah!!", 0, 347, 450, true);
    private cBlueButton btnDaftarMitra = new cBlueButton("DAFTAR", 65, 381 ,320);
    private cLinkStart toLoginMitraDaftarMitra= new cLinkStart("Sudah punya akun mitra?", 421);
    private cLinkStart toDaftarMitraDaftarMitra= new cLinkStart("Daftar sebagai customer", 441);
    private cLinkStart toLoginCustomerDaftarMitra= new cLinkStart("Belum punya akun customer?", 461);
    private cLinkStart toLoginAdminDaftarMitra= new cLinkStart("Login admin", 481);



    // instansiasi untuk login Admin
    private cFormLabel labelUsernameLoginAdmin = new cFormLabel("Username", 0, 84, 450, true);
    private cTextField txtUsernameLoginAdmin   = new cTextField(65, 114, 320, true);
    private cErorLabel eErrorUsernameLoginAdmin = new cErorLabel("Username kosong/salah!!", 0, 149, 450, true);
    private cFormLabel labelPasswordLoginAdmin = new cFormLabel("Password", 0, 183, 450, true);
    private cPassword txtPasswordLoginAdmin  = new cPassword(65, 213, 320, true);
    private cErorLabel eErrorPasswordLoginAdmin = new cErorLabel("Password kosong/salah!!", 0, 248, 450, true);
    private cBlueButton btnLoginAdmin  = new cBlueButton("LOGIN", 65, 282 ,320);
    private cLinkStart toDaftarMitraLoginAdmin = new cLinkStart("Belum punya akun mitra", 322);
    private cLinkStart toLoginMitraLoginAdmin = new cLinkStart("Sudah punya akun mitra?", 342);
    private cLinkStart toDaftarCustomerLoginAdmin = new cLinkStart("Daftar Sebagai akun Customer", 362);
    private cLinkStart toLoginCustomerLoginAdmin = new cLinkStart("Sudah punya akun Customer?", 382);

    public startView(){
        super();
        // implement for link frame login Customer
        toLoginMitraLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showLoginMitra(); 
            }

        });

        toDaftarMitraLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showDaftarMitra();
            }

        });

        toDaftarCustomerLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showDaftarCustomer();
            }

        });

        toLoginAdminLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showLoginAdmin();
            }

        });


         // implement for link frame Daftar Customer
         toLoginMitraDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showLoginMitra();
            }

        });

        toDaftarMitraDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showDaftarMitra();
            }

        });

        toLoginCustomerDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showLoginCustomer();
            }

        });

        toLoginAdminDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent  e) {
                // Logika saat mouse ditekan
                Controller.showLoginAdmin();
            }

        });


         // implement for link frame login mitra
         toDaftarMitraLoginMitra.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showDaftarMitra();
            }

        });

        toDaftarCustomerLoginMitra.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showDaftarCustomer();
            }

        });

        toLoginCustomerLoginMitra.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showLoginCustomer();
            }

        });

        toLoginAdminLoginMitra.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showLoginAdmin();
            }

        });

         // implement for link frame Daftar Mitra
         toLoginMitraDaftarMitra.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showLoginMitra();
            }

        });

        toDaftarMitraDaftarMitra.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showDaftarMitra();
            }

        });

        toLoginCustomerDaftarMitra.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showLoginCustomer();
            }

        });

        toLoginAdminDaftarMitra.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showLoginAdmin();
            }

        });


         // implement for link frame login admin
         toDaftarMitraLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showDaftarMitra();
            }

        });

        toLoginMitraLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showLoginMitra();
            }

        });

        toDaftarCustomerLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showDaftarCustomer();
            }

        });

        toLoginCustomerLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Logika saat mouse ditekan
                Controller.showLoginCustomer();
            }

        });


    }

    public void initsLoginCustomer(){
        setTitle("Login Customer");
        card.removeAll();
        titleLabel.setText("Login Customer");
        card.add(titleLabel);

 
        btnLoginCustomer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e){
               if(txtNoHPLoginCustomer.getText().equalsIgnoreCase("") || String.valueOf(txtPassword.getPassword()).equalsIgnoreCase("")){
                Controller.showLoginCustomer();
                if (txtNoHPLoginCustomer.getText().equalsIgnoreCase("")) {
                    card.add(eErrorNoHPLoginCustomer);
                }
                if (String.valueOf(txtPassword.getPassword()).equalsIgnoreCase("")) {
                    card.add(eErrorPassword);
                }
               }
            }
        });

         //add semua komponen di login customer
        card.add(labelNoHpLoginCustomer);
        card.add(txtNoHPLoginCustomer);
       // card.add(eErrorNoHPLoginCustomer);
        card.add(labelPassword);
        card.add(txtPassword);
       // card.add(eErrorPassword);
        card.add(btnLoginCustomer);
        card.add(toDaftarCustomerLoginCustomer);
        card.add(toLoginMitraLoginCustomer);
        card.add(toDaftarMitraLoginCustomer);
        card.add(toLoginAdminLoginCustomer);

    }

        

        public void initsDaftarCustomer(){
            setTitle("Daftar Customer");
            card.removeAll();
            titleLabel.setText("Daftarkan Customer");
            card.add(titleLabel);
        
            btnDaftarCustomer.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e){
                    String nama = txtNamaDaftarCustomer.getText();
                    String noHp = txtNoHpDaftarCustomer.getText();
                    String password = String.valueOf(txtPasswordDaftarCustomer.getPassword());
        
                    if(nama.isEmpty() || noHp.isEmpty() || password.isEmpty()) {
                        Controller.showDaftarCustomer();
                        if (nama.isEmpty()) {
                            card.add(eErrorNamaDaftarCustomer);
                        }
                        if (noHp.isEmpty()) {
                            card.add(eErrorNoHpDaftarCustomer);
                        }
                        if (password.isEmpty()) {
                            card.add(eErrorPasswordDaftarCustomer);
                        }
                    }
                }
            });
        
            card.add(labelNamaDaftarCustomer);
            card.add(txtNamaDaftarCustomer);
            card.add(labelNoHpDaftarCustomer);
            card.add(txtNoHpDaftarCustomer);
            card.add(labelPasswordDaftarCustomer);
            card.add(txtPasswordDaftarCustomer);
            card.add(btnDaftarCustomer);
            card.add(toLoginAdminDaftarCustomer);
            card.add(toLoginMitraDaftarCustomer);
            card.add(toDaftarMitraDaftarCustomer);
            card.add(toLoginCustomerDaftarCustomer);
            card.add(toLoginAdminDaftarCustomer);
        }
        

    public void initsLoginMitra(){
        this.setTitle("Login Mitra");
        card.removeAll();
        titleLabel.setText("Login Mitra");

        card.add(titleLabel);

        btnLoginMitra.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e){
               if( txtEmailLoginMitra.getText().equalsIgnoreCase("")|| String.valueOf(txtPassworLoginMitra.getPassword()).equalsIgnoreCase("")){
                Controller.showLoginMitra();
                if (txtEmailLoginMitra.getText().equalsIgnoreCase("")) {
                    card.add(eErrorEmailLoginMitra);
                }
                if (String.valueOf(txtPassworLoginMitra.getPassword()).equalsIgnoreCase("")) {
                    card.add(eErrorPasswordLoginMitra);
                }
               }
            }
        });

        btnLoginMitra.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae){
               
                String email = txtEmailLoginMitra.getText();
                String password = String.valueOf(txtPassworLoginMitra.getPassword());
                
                if(email.equalsIgnoreCase("")||email.isEmpty() ||  password.equalsIgnoreCase("")|| password.isEmpty()) {
                    startView.this.setVisible(false);
                    // masuk validasi
                    if (email.equalsIgnoreCase("")||email.isEmpty()){
                        card.add(eErrorEmailLoginMitra);
                    }else{
                        card.remove(eErrorEmailLoginMitra);
                    }
                    if (password.equalsIgnoreCase("")|| password.isEmpty()) card.add(eErrorPasswordLoginMitra); else card.remove(eErrorPasswordLoginMitra);
                    
              startView.this.setVisible(true);
            }else{
                // lolos validasi
               if (model.verifyAkunMitra(email, password)) {
                // jika berhasil login
                Controller.showDashboardMitra(Integer.valueOf(model.getDetailMitraByEmail(email)[0].toString()));
                startView.this.setVisible(false);
               } else{
                // jika gagal login
                JOptionPane.showMessageDialog(startView.this, "Silahkan periksa email dan password! ", "Eror", JOptionPane.ERROR_MESSAGE);
               }
            }
        }
    });

        card.add(labelEmailLoginMitra);
        card.add(txtEmailLoginMitra);
        // card.add(eErrorEmailLoginMitra);
        card.add(labelPasswordLoginMitra);
        card.add(txtPassworLoginMitra);
        // card.add(eErrorPasswordLoginMitra);
        card.add(btnLoginMitra);
        card.add(toDaftarMitraLoginMitra);
        card.add(toDaftarCustomerLoginMitra);
        card.add(toLoginCustomerLoginMitra);
        card.add(toLoginAdminLoginMitra );

    }

    public void initsDaftarMitra(){
  
        setTitle("Daftar Mitra");
        card.removeAll();
        titleLabel.setText("Daftarkan Mitra");

        //add semua komponen di daftar Mitra
        card.add(titleLabel);

        // masih eror

        btnDaftarMitra.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e){
                String nama = txtNamaDaftarMitra.getText();
                String email = txtEmailDaftarMitra.getText();
                String password = String.valueOf(txtPasswordDaftarMitra.getPassword());
    
                if(nama.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Controller.showDaftarMitra();
                    if (nama.isEmpty()) {
                        card.add(eErrorNamaDaftarMitra);
                    }
                    if (email.isEmpty()) {
                        card.add(eErrorEmailDaftarMitra);
                    }
                    if (password.isEmpty()) {
                        card.add(eErrorPasswordDaftarMitra);
                    }
                }
            }
        });

        btnDaftarMitra.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae){
               
                String nama = txtNamaDaftarMitra.getText();
                String email = txtEmailDaftarMitra.getText();
                String password = String.valueOf(txtPasswordDaftarMitra.getPassword());
                
                if(nama.equalsIgnoreCase("")||nama.isEmpty() ||  email.equalsIgnoreCase("")||email.isEmpty() ||  password.equalsIgnoreCase("")|| password.isEmpty()) {
                    startView.this.setVisible(false);
                    // masuk validasi
                    if (nama.equalsIgnoreCase("")||nama.isEmpty()){
                        card.add(eErrorNamaDaftarMitra);
                    }else{
                        card.remove(eErrorNamaDaftarMitra);
                    }
                    if (email.equalsIgnoreCase("")||email.isEmpty()){
                        card.add(eErrorEmailDaftarMitra);
                    }else{
                        card.remove(eErrorEmailDaftarMitra);
        }
        if (password.equalsIgnoreCase("")||password.isEmpty()) {
            card.add(eErrorPasswordDaftarMitra); 
        }else{
             card.remove(eErrorPasswordDaftarMitra);
        }
        startView.this.setVisible(true);
        }else{
             // lolos validasi
             //cek apakah email sudah terdaftar atau belum
             if (model.verifyEmailMitra(email)) {
                // jika berarti email belum terdaftar
            if (model.daftarMitra(nama, email, password)) {
                // jika berhasil daftar
                JOptionPane.showMessageDialog(startView.this, "Daftar berhasil! Silahkan login! ", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                initsLoginMitra();
             } else{
                // jika gagal daftar
                JOptionPane.showMessageDialog(startView.this, "Daftar gagal! ", "Eror", JOptionPane.ERROR_MESSAGE);
 
            }
            }else{
                // jika email sudah terdaftar
                JOptionPane.showMessageDialog(startView.this, "Email sudah terdaftar! ", "Eror", JOptionPane.ERROR_MESSAGE);
            }
        }
            }
        });



        card.add(labelNamaDaftarMitra);
        card.add(txtNamaDaftarMitra);
        card.add(eErrorNamaDaftarMitra);
        card.add(labelEmailDaftarMitra);
        card.add(txtEmailDaftarMitra);
        card.add(eErrorEmailDaftarMitra);
        card.add(labelPasswordDaftarMitra);
        card.add(txtPasswordDaftarMitra);
        card.add(eErrorPasswordDaftarMitra);
        card.add(btnDaftarMitra);
        card.add(toLoginAdminDaftarMitra);
        card.add(toLoginMitraDaftarMitra);
        card.add(toDaftarMitraDaftarMitra);
        card.add(toLoginMitraDaftarMitra);
        card.add(toLoginCustomerDaftarMitra);
        card.add(toLoginAdminLoginMitra );
    }

    public void initsLoginAdmin(){
        setTitle("Login Admin");
        card.removeAll();
        titleLabel.setText("Login Admin");

        //add semua komponen di login Admin
        card.add(titleLabel);



        btnLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e){
               if( txtUsernameLoginAdmin.getText().equalsIgnoreCase("") || String.valueOf(txtPasswordLoginAdmin.getPassword()).equalsIgnoreCase("")){
                Controller.showLoginAdmin();
                if (txtUsernameLoginAdmin.getText().equalsIgnoreCase("")) {
                    card.add(eErrorUsernameLoginAdmin);
                }
                if (String.valueOf(txtPasswordLoginAdmin.getPassword()).equalsIgnoreCase("")) {
                    card.add(eErrorPasswordLoginAdmin);
                }
               }
            }
        });

        btnLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e){
            
                String userName = txtUsernameLoginAdmin.getText();
                String password = String.valueOf(txtPasswordLoginAdmin.getPassword());
                
               if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin123")){
                // jika login berhasil
                Controller.showDashboardAdmin(true);
              //  JOptionPane.showMessageDialog(startView.this, "Login berhasil", "Login", JOptionPane.INFORMATION_MESSAGE);
                startView.this.setVisible(false);
              }else{
            // jika login gagal
            JOptionPane.showMessageDialog(startView.this, "Silahkan perikasa username dan password", "Login", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
        
        card.add(labelUsernameLoginAdmin);
        card.add(txtUsernameLoginAdmin);
       // card.add(eErrorUsernameLoginAdmin);
        card.add(labelPasswordLoginAdmin);
        card.add(txtPasswordLoginAdmin);
       // card.add(eErrorPassword);
        card.add(btnLoginAdmin);
        card.add(toDaftarMitraLoginAdmin);
        card.add(toLoginMitraLoginAdmin);
        card.add(toDaftarCustomerLoginAdmin);
        card.add(toLoginCustomerLoginAdmin);

    }


}
