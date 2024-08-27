package com.views;
import com.template.*;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import java.awt.event.*;

// import javax.swing.table.DefaultTableModel;


import com.partials.*;
import com.program.model;


public class dashaboardCustomerView extends cDashboardFrame {
    
    // properti
    private Integer idCustomer = null;
   // Integer selectedID = null;
  
   // sidebar menu
  private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
  private cSidebarMenu menuBeliPulsa = new cSidebarMenu("Beli Pulsa", 70+50);
  private cSidebarMenu menuBeliPaket = new cSidebarMenu("Beli Paket", 70+50+50);
  private cSidebarMenu menuHistoryBeliPulsa = new cSidebarMenu("History Beli Pulsa", 70+50+50+50);
  private cSidebarMenu menuHistoryBeliPaket = new cSidebarMenu("History Beli Paket", 70+50+50+50+50);
  private cSidebarMenu menuAkun = new cSidebarMenu("Akun", 70+50+50+50+50+50);
  private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70+50+50+50+50+50+50);

  // components of beranda
  private cLabelInfo labelSisaPulsaBeranda = new cLabelInfo("Sisa Pulsa Anda", 25, 20);
  private cBigFont valueSisaPulsaBeranda = new cBigFont("0", 25, 60);
  private cLabelInfo labelSisaKuotaBeranda = new cLabelInfo("Sisa Kuota Anda", 25, 150);
  private cBigFont valueSisaKuotaBeranda = new cBigFont("0GB", 25, 190);

  // Beli Pulsa components
  private cLabelInfo labelSisaPulsaBeliPulsa = new cLabelInfo("Sisa Pulsa Anda", 25, 20);
  private cBigFont valueSisaPulsaBeliPulsa = new cBigFont("0", 25, 60);
  private cLabelInfo labelPilihanBeliPulsa = new cLabelInfo("Pilihan Beli Pulsa", 25, 150);
  private cRadioButton rd5k = new cRadioButton("5K", "5000", 25, 190, 72);
  private cRadioButton rd10k = new cRadioButton("10K", "10000", 102, 190, 72);
  private cRadioButton rd25k = new cRadioButton("25K", "25000", 179, 190, 72);
  private cRadioButton rd50k = new cRadioButton("50K", "50000", 256, 190, 72);
  private cRadioButton rd100k = new cRadioButton("100K", "100000", 333, 190, 72);
  private cBlueButton btnBeliPulsa = new cBlueButton("Beli Pulsa", 25, 220, 155);
  private ButtonGroup rdPilihaPulsa = new ButtonGroup();

  // beli paket components
  private cLabelInfo labelSisaKuotaBeliPaket = new cLabelInfo("Sisa Kuota Anda", 25, 20);
  private cBigFont valueSisaKuotaBeliPaket = new cBigFont("0GB", 25, 60);
  private cLabelInfo labelPilihanBeliPaket = new cLabelInfo("Pilihan Beli Paket Kuota", 25, 150);
 // private DefaultTableModel dmPaket;
  private cTable dataPaket;
  private cScrollPane spDataPaket;
  private cBlueButton btnBeliPaket = new cBlueButton("Beli Paket", 25, 390, 155);
  private cLabelInfo labelDeskripsiPaket = new cLabelInfo("DeskripsiPaket", 473, 190);
  private cTextArea valueDeskripsiPaket = new cTextArea("1000", 473, 231, false);

  // history beli pulsa components
  private cLabelInfo labelHistoryPulsa = new cLabelInfo("Semua Pembelian Pulsa Saya", 25, 20);
 // private DefaultTableModel dmHistoryPulsa;
  private cTable tblDataHistoryPulsa;
  private cScrollPane spDataHistoryPulsa;

  // history beli Paket components
  private cLabelInfo labelHistoryPaket = new cLabelInfo("Semua Pembelian Paket Saya", 25, 20);
 // private DefaultTableModel dmHistoryPaket;
  private cTable tblDataHistoryPaket;
  private cScrollPane spDataHistoryPaket;
  
  // akun customer components
  private cLabelInfo labelAkun = new cLabelInfo("Data Akun Saya", 25, 20);
  private cFormLabel labelNama = new cFormLabel("Nama", 25, 65, 360, false);
  private cTextField txtNama = new cTextField(25, 90, 360, false);
  private cErorLabel errorNama = new cErorLabel("nama tidak boleh kosong!", 25, 125, 360, false);
  private cFormLabel labelNoHp = new cFormLabel("No Hp", 25, 150, 360, false);
  private cFormLabel valueNoHp;
  private cFormLabel labelEmail = new cFormLabel("Email", 25, 202, 360, false);
  private cTextField txtEmail = new cTextField(25, 227, 360, false);
  private cErorLabel errorEmail = new cErorLabel("email tidak boleh valid!", 25, 262, 360, false);
  private cBlueButton btnUbahAkun = new cBlueButton("Ubah Data Akun", 25, 292, 155);

  // method resetSidebar
  private void resetSidebar()
  {
    try {
      setVisible(false);

      menuBeranda.setForeground(cColor.Gray);
      menuBeranda.setBackground(cColor.White);
      menuBeranda.setSidebarNonAktif();

      menuBeliPulsa.setSidebarNonAktif();
      menuBeliPulsa.setForeground(cColor.Gray);
      menuBeliPulsa.setBackground(cColor.White);

      menuBeliPaket.setSidebarNonAktif();
      menuBeliPaket.setForeground(cColor.Gray);
      menuBeliPaket.setBackground(cColor.White);

      menuHistoryBeliPulsa.setSidebarNonAktif();
      menuHistoryBeliPulsa.setForeground(cColor.Gray);
      menuHistoryBeliPulsa.setBackground(cColor.White);

      menuHistoryBeliPaket.setSidebarNonAktif();
      menuHistoryBeliPaket.setForeground(cColor.Gray);
      menuHistoryBeliPaket.setBackground(cColor.White);

      menuAkun.setSidebarNonAktif();
      menuAkun.setForeground(cColor.Gray);
      menuAkun.setBackground(cColor.White);
      
      menuLogout.setSidebarNonAktif();
    } catch (Exception e) {
      
    }
  }

  // method refresh content
  private void refreshContent()
  {
    try{
    
      roleText.setText("Customer | " + model.getDetailCustomer(idCustomer)[1].toString());
      content.removeAll();
    } catch(Exception e) {
    }
  }

  public dashaboardCustomerView( Integer id )
  {
    super("Dashboard Customer");
    idCustomer = id;
      Object[] customerDetails = model.getDetailCustomer(idCustomer);
        if (customerDetails[1] != null) {
            roleText.setText("Customer | " + customerDetails[1].toString());
        } else {
            roleText.setText("Customer | Unknown");
        }
    menuBeranda.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsBeranda();
      }
    });
    menuBeliPulsa.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsBeliPulsa();
      }
    });
    menuBeliPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsBeliPaket();
      }
    });
    menuHistoryBeliPulsa.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsHistoryBeliPulsa();
      }
    });
    menuHistoryBeliPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsHistoryBeliPaket();
      }
    });
    menuAkun.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsAkun();
      }
    });
    menuLogout.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Object[] options = { "YA", "BATAL" };
        int confirm = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
        null, options, options[0]);
        if(confirm == 0 ){
          idCustomer = null;
        // selectedID = null;
          com.program.Controller.showLoginCustomer();
        }
      }
    });
    // add component default
    sidebar.add(menuBeranda);
    sidebar.add(menuBeliPulsa);
    sidebar.add(menuBeliPaket);
    sidebar.add(menuHistoryBeliPulsa);
    sidebar.add(menuHistoryBeliPaket);
    sidebar.add(menuAkun);
    sidebar.add(menuLogout);

    rdPilihaPulsa.add(rd5k);
    rdPilihaPulsa.add(rd10k);
    rdPilihaPulsa.add(rd25k);
    rdPilihaPulsa.add(rd50k);
    rdPilihaPulsa.add(rd100k);

    initsBeranda();
  }

  private void initsBeranda()
  {
  // selectedID = null;
    resetSidebar();
    menuBeranda.setBackground(cColor.Blue);
    menuBeranda.setForeground(cColor.White);
    refreshContent();
    menuBeranda.setSidebarAktif();
    menuTitle.setText("Beranda");

    valueSisaPulsaBeranda.setText(model.getDetailPulsaKuotaCustomer(idCustomer)[0].toString());
    valueSisaKuotaBeranda.setText(model.getDetailPulsaKuotaCustomer(idCustomer)[1].toString() + "GB");

    content.add(labelSisaPulsaBeranda);
    content.add(valueSisaPulsaBeranda);
    content.add(labelSisaKuotaBeranda);
    content.add(valueSisaKuotaBeranda);
    setVisible(true);
  }

  private void initsBeliPulsa()
  {
  // selectedID = null;
  resetSidebar();
  menuBeliPulsa.setBackground(cColor.Blue);
  menuBeliPulsa.setForeground(cColor.White);
  refreshContent();
  menuBeliPulsa.setSidebarAktif();
  menuTitle.setText("Beli Pulsa");

    valueSisaPulsaBeliPulsa.setText("Rp"+ model.getDetailPulsaKuotaCustomer(idCustomer)[0].toString());

    rd5k.setSelected(true);

  // Mendapatkan semua listener yang ada pada btnBeliPulsa dan menghapusnya:
  ActionListener[] listeners = btnBeliPulsa.getActionListeners();
for (ActionListener listener : listeners) {
    btnBeliPulsa.removeActionListener(listener);
}
    

    btnBeliPulsa.addActionListener(new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent e)
      {
        int jumlahPulsa = Integer.valueOf(rdPilihaPulsa.getSelection().getActionCommand());
        if (model.TambahTransaksiPulsa(idCustomer, jumlahPulsa)) {
          JOptionPane.showMessageDialog(dashaboardCustomerView.this, "Pembelian Pulsa masih pending. Silahkan tunggu.", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
          initsHistoryBeliPulsa();
        }else{
          JOptionPane.showMessageDialog(dashaboardCustomerView.this, "Pembelian Pulsa gagal!", "Gagal", JOptionPane.WARNING_MESSAGE);
        }
    
    
    }
  });

    content.add(labelSisaPulsaBeliPulsa);
    content.add(valueSisaPulsaBeliPulsa);
    content.add(labelPilihanBeliPulsa);
    content.add(rd5k);
    content.add(rd10k);
    content.add(rd25k);
    content.add(rd50k);
    content.add(rd100k);
    content.add(btnBeliPulsa);
    setVisible(true);
  }
  private void initsBeliPaket()
  {
  // selectedID = null;
    resetSidebar();
    menuBeliPaket.setBackground(cColor.Blue);
    menuBeliPaket.setForeground(cColor.White);
    refreshContent();
    menuBeliPaket.setSidebarAktif();
    menuTitle.setText("Beli Paket");

    valueSisaKuotaBeliPaket.setText(model.getDetailPulsaKuotaCustomer(idCustomer)[1].toString() + "GB");
    dataPaket = new cTable(model.getPaketAktif());
    dataPaket.getColumnModel().getColumn(0).setMinWidth(0);
    dataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
    dataPaket.getColumnModel().getColumn(0).setWidth(0);

   ActionListener[] listeners = btnBeliPaket.getActionListeners();
   for (ActionListener listener : listeners) {
     btnBeliPaket.removeActionListener(listener);
   }


    dataPaket.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mousePressed(java.awt.event.MouseEvent e){
        int selectedIndex = dataPaket.getSelectedRow();
        int idCustomer = Integer.valueOf(dataPaket.getValueAt(selectedIndex, 0).toString());
        String deskripsiPaket = model.getDetailPaket(idCustomer)[2].toString();
        valueDeskripsiPaket.setText(deskripsiPaket);
      }
    });
    spDataPaket = new cScrollPane(dataPaket, 25, 190, 428, 190);
  // //  String textDeskripsiPaket = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam totam doloribus velit ipsa! Beatae tempore quod laborum porro optio aliquam voluptate commodi assumenda explicabo debitis accusamus obcaecati, quo nostrum esse!";
  //   valueDeskripsiPaket.setText(textDeskripsiPaket);

    // memberikan event ke button beli paket
    btnBeliPaket.addActionListener(new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent e)
      {
        int selectedIndex = dataPaket.getSelectedRow();
       // int idCustomer = Integer.valueOf(dataPaket.getValueAt(selectedIndex, 0).toString());
       // melakukan pengecekan apakah ada yang dipilih atau tidak
        if (selectedIndex == -1) {
          //kalau gak ada yang dipilih
          JOptionPane.showMessageDialog(dashaboardCustomerView.this, "Pilih paket terlebih dahulu!.", "Peringatan", JOptionPane.WARNING_MESSAGE);
          
        }else{
          // kalau ada yang dipilih
          int idPaket = Integer.valueOf(dataPaket.getValueAt( selectedIndex, 0).toString());
         if (model.getBeliPaket(idCustomer, idPaket)) {
          // kalau berhasil beli paket
          JOptionPane.showMessageDialog(dashaboardCustomerView.this, "Pembelian Paket Berhasil. Silahkan Tunggu!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
          initsHistoryBeliPaket();
         }else{
          // kalau tidak berhasil beli paket
          JOptionPane.showMessageDialog(dashaboardCustomerView.this, "Pembelian paket gagal!.", "Peringatan", JOptionPane.WARNING_MESSAGE);
         }
        }
      }
    });


    content.add(labelSisaKuotaBeliPaket);
    content.add(valueSisaKuotaBeliPaket);
    content.add(labelPilihanBeliPaket);
    content.add(spDataPaket);
    content.add(btnBeliPaket);
    content.add(labelDeskripsiPaket);
    content.add(valueDeskripsiPaket);
    setVisible(true);
  }
  
  private void initsHistoryBeliPulsa()
  {
  // selectedID = null;
    resetSidebar();
    menuHistoryBeliPulsa.setBackground(cColor.Blue);
    menuHistoryBeliPulsa.setForeground(cColor.White);
    refreshContent();
    menuHistoryBeliPulsa.setSidebarAktif();
    menuTitle.setText("Transaksi Pulsa Saya");
  
    tblDataHistoryPulsa = new cTable(model.getAllTransaksiPulsaByCustomer(idCustomer));

    spDataHistoryPulsa = new cScrollPane(tblDataHistoryPulsa, 25, 65, 740, 310);
    content.add(labelHistoryPulsa);
    content.add(spDataHistoryPulsa);
    setVisible(true);
  }

  private void initsHistoryBeliPaket()
  {
  // selectedID = null;
    resetSidebar();
    menuHistoryBeliPaket.setBackground(cColor.Blue);
    menuHistoryBeliPaket.setForeground(cColor.White);
    refreshContent();
    menuHistoryBeliPaket.setSidebarAktif();
    menuTitle.setText("Transaksi Paket Saya");
   
    tblDataHistoryPaket = new cTable(model.getAllTransaksiPaketByCustomer(idCustomer));

    spDataHistoryPaket = new cScrollPane(tblDataHistoryPaket, 25, 65, 924, 310);
    content.add(labelHistoryPaket);
    content.add(spDataHistoryPaket);
    setVisible(true);
  }

  private void initsAkun()
  {
    resetSidebar();
    menuAkun.setBackground(cColor.Blue);
    menuAkun.setForeground(cColor.White);
    refreshContent();
    menuAkun.setSidebarAktif();
    menuTitle.setText("Akun Saya");

    Object[] dataCustomer = model.getDetailCustomer(idCustomer);

    txtNama.setText(dataCustomer[1].toString());
    txtEmail.setText(dataCustomer[3].toString());

    valueNoHp = new cFormLabel(dataCustomer[2].toString(), 25, 174, 360, false);


    valueNoHp.setFont(com.partials.cFonts.RADIO_BUTTON_FONT);
    valueNoHp.setForeground(com.partials.cColor.Red);


    btnUbahAkun.addActionListener(new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae){
        
        if( txtNama.getText().trim().isEmpty() || ( !txtEmail.getText().trim().isEmpty() && !dataCustomer[3].toString().equalsIgnoreCase(txtEmail.getText()) && model.getCountCustomerByEmail(txtEmail.getText()) == 1 ) ){
          // kalo ada yang tidak memenuhi syarat

          dashaboardCustomerView.this.setVisible(false);
          
          if( txtNama.getText().trim().isEmpty() ) content.add(errorNama); else content.remove(errorNama);
          
          if( !txtEmail.getText().trim().isEmpty() && !dataCustomer[3].toString().equalsIgnoreCase(txtEmail.getText()) && model.getCountCustomerByEmail(txtEmail.getText()) == 1 ) content.add(errorEmail); else content.remove(errorEmail);
          
          dashaboardCustomerView.this.setVisible(true);

        }else{
          // kalau validasinya lolos
          String namaCustomer = txtNama.getText();
          String emailCustomer = txtEmail.getText();
          if( model.ubahProfilCustomer(idCustomer, namaCustomer, emailCustomer) ){
            // kalau berhasil diubah
            JOptionPane.showMessageDialog(dashaboardCustomerView.this, "Ubah Profil berhasil", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            initsAkun();
          }else{
            // kalau gagal ubah profil
            JOptionPane.showMessageDialog(dashaboardCustomerView.this, "Ubah profil gagal!", "Gagal", JOptionPane.WARNING_MESSAGE);
          }

        }

      }
    });

    content.add(labelAkun);
    content.add(labelNama);
    content.add(txtNama);
    // content.add(errorNama);
    content.add(labelNoHp);
    content.add(valueNoHp);
    content.add(labelEmail);
    content.add(txtEmail);
    // content.add(errorEmail);
    content.add(btnUbahAkun);
    setVisible(true);
  }
  
}
