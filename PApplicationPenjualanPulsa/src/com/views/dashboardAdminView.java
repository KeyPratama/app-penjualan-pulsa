package com.views;
import com.template.cDashboardFrame;
import com.partials.*;
import com.program.model;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
// import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;

class Filter{
  static String filter = "semua";
  static String keyword = "";
  static DefaultTableModel search(){
    DefaultTableModel tm = new DefaultTableModel();
    if (filter.equalsIgnoreCase("semua")) {
     // memanggil dan menggantikan tm dengan return dari getSearchAllPaket
      tm = model.getSearchAllTransaksiPaket(keyword);
    }else if(filter.equalsIgnoreCase("aktif")){
     tm = model.getSearcPaketAktif(keyword);
    }else if(filter.equalsIgnoreCase("tidak aktif")){
     tm = model.getSearchPaketNonAktif(keyword);
    }
    return tm;
  }
}

public class dashboardAdminView extends cDashboardFrame{

  public boolean statusLogin = false;
  public Integer idSelected = null;

  // sidebar menu
  private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
  private cSidebarMenu menuDataMitra = new cSidebarMenu("Data Mitra", 70+50);
  private cSidebarMenu menuDataCustomer = new cSidebarMenu("Data Customer", 70+50+50);
  private cSidebarMenu menuDataPaket = new cSidebarMenu("Data Paket", 70+50+50+50);
  private cSidebarMenu menuRequestSaldo = new cSidebarMenu("Request Saldo", 70+50+50+50+50);
  private cSidebarMenu menuCalonMitra = new cSidebarMenu("Calon Mitra", 70+50+50+50+50+50);
  private cSidebarMenu menuTransaksiPulsa = new cSidebarMenu("Transaksi Pulsa", 70+50+50+50+50+50+50);
  private cSidebarMenu menuTransaksiPaket = new cSidebarMenu("Transaksi Paket", 70+50+50+50+50+50+50+50);
  private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70+50+50+50+50+50+50+50+50);

// beranda components
private cLabelInfo labelJmlDataMitraBeranda = new cLabelInfo("Jumlah Data Mitra Terverifikasi", 25, 20);
private cBigFont valueJmlDataMitraBeranda = new cBigFont("0", 25, 60);
private cLabelInfo labelJmlDataCustomerBeranda = new cLabelInfo("Jumlah Data Customer Aktif", 25, 150);
private cBigFont valueJmlDataCustomerBeranda = new cBigFont("0", 25, 190);
private cLabelInfo labelJmlTransaksiPulsaBeranda = new cLabelInfo("Jumlah Transaksi Pulsa Berhasil", 25, 280);
private cBigFont valueJmlTransaksiPulsaBeranda = new cBigFont("0", 25, 320);
private cLabelInfo labelJmlTransaksiPaketBeranda = new cLabelInfo("Jumlah Transaksi Paket Berhasil", 495, 20);
private cBigFont valueJmlTransaksiPaketBeranda = new cBigFont("0", 495, 60);
private cLabelInfo labelJmlCalonMitraBeranda = new cLabelInfo("Jumlah Data Calon Mitra", 495, 150);
private cBigFont valueJmlCalonMitraBeranda = new cBigFont("0", 495, 190);
private cLabelInfo labelJmlRequestSaldoBeranda = new cLabelInfo("Jumlah Request Saldo Pending", 495, 280);
private cBigFont valueJmlRequestSaldoBeranda = new cBigFont("0", 495, 320);

  // DataMitra components
  private cLabelInfo labelDataMitra = new cLabelInfo("Data Mitra Terverifikasi", 25, 20);
  private cFormLabel labelCariDataMitra = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariDataMitra = new cTextField(83, 70, 350, false);
  private cTable tblDataDataMitra;
  private cScrollPane spDataDataMitra;
  private cRedButton btnHapusDataMitra = new cRedButton("Hapus", 25, 428, 110);
  
  // DataCustomer components
  private cLabelInfo labelDataCustomer = new cLabelInfo("Data Customer Aktif", 25, 20);
  private cFormLabel labelCariDataCustomer = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariDataCustomer = new cTextField(83, 70, 350, false);

  private cTable tblDataDataCustomer;
  private cScrollPane spDataDataCustomer;
  private cRedButton btnHapusDataCustomer = new cRedButton("Hapus", 25, 428, 110);

  // Data Paket components
  private cLabelInfo labelDataPaket = new cLabelInfo("Data Request Request Saldo Pending", 25, 20);
  private cFormLabel labelCariDataPaket = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariDataPaket = new cTextField(83, 70, 317, false);
  private cBlueButton btnTambahDataPaket = new cBlueButton("Tambah Paket", 418, 70, 162);
  private cRadioButton rdSemuaDataPaket = new cRadioButton("Semua", "all", 25, 115, 97);
  private cRadioButton rdAktifDataPaket = new cRadioButton("Aktif", "active", 132, 115, 72);
  private cRadioButton rdTidakAktifDataPaket = new cRadioButton("Tidak Aktif", "nonactive", 214, 115, 112);
  private ButtonGroup groupActionDataPaket = new ButtonGroup();
  private cTable tblDataDataPaket;
  private cScrollPane spDataDataPaket;
  private cGreenButton btnUbahDataPaket = new cGreenButton("Ubah", 25, 430, 92);
  private cLabelInfo labelDeskripsiPaketDataPaket = new cLabelInfo("Deskripsi Paket", 600, 145);
  private cTextArea valueDeskripsiPaketDataPaket = new cTextArea("", 600, 186, false);
  
  // TambahDataPaket components
  private cLabelInfo labelTambahDataPaket = new cLabelInfo("Isi form data paket dengan lengkap", 25, 20);
  private cFormLabel labelNamaPaketTambahDataPaket = new cFormLabel("Nama Paket", 25, 65, 550, false);
  private cTextField txtNamaPaketTambahDataPaket = new cTextField(25, 90, 550, false);
  private cErorLabel errorNamaPaketTambahDataPaket = new cErorLabel("nama paket tidak boleh kosong!", 25, 125, 550, false);
  private cFormLabel labelKuotaPaketTambahDataPaket = new cFormLabel("Kuota Paket", 25, 150, 550, false);
  private cTextField txtKuotaPaketTambahDataPaket = new cTextField(25, 175, 550, false);
  private cErorLabel errorKuotaPaketTambahDataPaket = new cErorLabel("kuota paket tidak boleh kosong!", 25, 210, 550, false);
  private cFormLabel labelHargaPaketTambahDataPaket = new cFormLabel("Harga Paket", 25, 235, 550, false);
  private cTextField txtHargaPaketTambahDataPaket = new cTextField(25, 260, 550, false);
  private cErorLabel errorHargaPaketTambahDataPaket = new cErorLabel("harga paket tidak boleh kosong!", 25, 295, 550, false);
  private cCheckbox chAktifTambahDataPaket = new cCheckbox("Aktifkan", "1", 25, 316, 100);
  private cBlueButton btnTambahPaketTambahDataPaket = new cBlueButton("Tambah", 25, 348, 110);
  private cRedButton btnBatalTambahDataPaket = new cRedButton("Batal", 155, 348, 110);
  private cFormLabel labelDeskripsiPaketTambahDataPaket = new cFormLabel("Deskripsi Paket", 595, 65, 370, false);
  private cTextArea txtDeskripsiPaketTambahDataPaket = new cTextArea(true);
  private cScrollPane spTxtDeskripsiPaketTambahDataPaket = new cScrollPane(txtDeskripsiPaketTambahDataPaket, 595, 90, 370, 205);
  private cErorLabel errorDeskripsiPaketTambahDataPaket = new cErorLabel("deskripsi paket tidak boleh kosong!", 595, 295, 370, false);

  // UbahDataPaket components
  private cLabelInfo labelUbahDataPaket = new cLabelInfo("Isi form data paket dengan lengkap", 25, 20);
  private cFormLabel labelNamaPaketUbahDataPaket = new cFormLabel("Nama Paket", 25, 65, 550, false);
  private cTextField txtNamaPaketUbahDataPaket = new cTextField(25, 90, 550, false);
  private cErorLabel errorNamaPaketUbahDataPaket = new cErorLabel("nama paket tidak boleh kosong!", 25, 125, 550, false);
  private cFormLabel labelKuotaPaketUbahDataPaket = new cFormLabel("Kuota Paket", 25, 150, 550, false);
  private cTextField txtKuotaPaketUbahDataPaket = new cTextField(25, 175, 550, false);
  private cErorLabel errorKuotaPaketUbahDataPaket = new cErorLabel("kuota paket tidak boleh kosong!", 25, 210, 550, false);
  private cFormLabel labelHargaPaketUbahDataPaket = new cFormLabel("Harga Paket", 25, 235, 550, false);
  private cTextField txtHargaPaketUbahDataPaket = new cTextField(25, 260, 550, false);
  private cErorLabel errorHargaPaketUbahDataPaket = new cErorLabel("harga paket tidak boleh kosong!", 25, 295, 550, false);
  private cCheckbox chAktifUbahDataPaket = new cCheckbox("Aktifkan", "1", 25, 316, 100);
  private cBlueButton btnUbahPaketUbahDataPaket = new cBlueButton("Ubah", 25, 348, 110);
  private cRedButton btnBatalUbahDataPaket = new cRedButton("Batal", 155, 348, 110);
  private cFormLabel labelDeskripsiPaketUbahDataPaket = new cFormLabel("Deskripsi Paket", 595, 65, 370, false);
  private cTextArea txtDeskripsiPaketUbahDataPaket = new cTextArea(true);
  private cScrollPane spTxtDeskripsiPaketUbahDataPaket = new cScrollPane(txtDeskripsiPaketUbahDataPaket, 595, 90, 370, 205);
  private cErorLabel errorDeskripsiPaketUbahDataPaket = new cErorLabel("deskripsi paket tidak boleh kosong!", 595, 295, 370, false);
  
  // RequestSaldo components
  private cLabelInfo labelRequestSaldo = new cLabelInfo("Data Request Request Saldo Pending", 25, 20);
  private cFormLabel labelCariRequestSaldo = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariRequestSaldo = new cTextField(83, 70, 317, false);
  private cBlueButton btnLihatBerhasilRequestSaldo = new cBlueButton("Lihat Berhasil", 418, 70, 162);
  private cTable tblDataRequestSaldo;
  private cScrollPane spDataRequestSaldo;
  private cGreenButton btnApproveRequestSaldo = new cGreenButton("Setujui", 25, 430, 110);
  
  // RequestSaldoDone components
  private cLabelInfo labelRequestSaldoDone = new cLabelInfo("Data Request Request Saldo Berhasil", 25, 20);
  private cFormLabel labelCariRequestSaldoDone = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariRequestSaldoDone = new cTextField(83, 70, 317, false);
  private cBlueButton btnLihatPendingRequestSaldoDone = new cBlueButton("Lihat Pending", 418, 70, 162);
  // private DefaultTableModel dmRequestSaldoDone;
  private cTable tblDataRequestSaldoDone;
  private cScrollPane spDataRequestSaldoDone;
  
  // CalonMitra components
  private cLabelInfo labelCalonMitra = new cLabelInfo("Data Request Calon Mitra", 25, 20);
  private cFormLabel labelCariCalonMitra = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariCalonMitra = new cTextField(83, 70, 350, false);
 // private DefaultTableModel dmCalonMitra;
  private cTable tblDataCalonMitra;
  private cScrollPane spDataCalonMitra;
  private cGreenButton btnApproveCalonMitra = new cGreenButton("Setujui", 25, 430, 110);
  
  // TransaksiPulsa components
  private cLabelInfo labelTransaksiPulsa = new cLabelInfo("Semua Data Transaksi Pulsa", 25, 20);
  private cFormLabel labelCariTransaksiPulsa = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariTransaksiPulsa = new cTextField(83, 70, 350, false);
 // private DefaultTableModel dmTransaksiPulsa;
  private cTable tblDataTransaksiPulsa;
  private cScrollPane spDataTransaksiPulsa;
  
  // TransaksiPaket components
  private cLabelInfo labelTransaksiPaket = new cLabelInfo("Semua Data Transaksi Paket", 25, 20);
  private cFormLabel labelCariTransaksiPaket = new cFormLabel("Cari", 25, 75, 55, false);
  private cTextField txtCariTransaksiPaket = new cTextField(83, 70, 350, false);

  private cTable tblDataTransaksiPaket;
  private cScrollPane spDataTransaksiPaket;



  // method resetSidebar
  private void resetSidebar()
  {
    try {
      setVisible(false);
      
      menuBeranda.setForeground(cColor.Gray);
      menuBeranda.setBackground(cColor.White);
      menuBeranda.setSidebarNonAktif();

      menuDataMitra.setForeground(cColor.Gray);
      menuDataMitra.setBackground(cColor.White);
      menuDataMitra.setSidebarNonAktif();

      menuDataCustomer.setForeground(cColor.Gray);
      menuDataCustomer.setBackground(cColor.White);
      menuDataCustomer.setSidebarNonAktif();

      menuDataPaket.setForeground(cColor.Gray);
      menuDataPaket.setBackground(cColor.White);
      menuDataPaket.setSidebarNonAktif();

      menuRequestSaldo.setForeground(cColor.Gray);
      menuRequestSaldo.setBackground(cColor.White);
      menuRequestSaldo.setSidebarNonAktif();

      menuCalonMitra.setForeground(cColor.Gray);
      menuCalonMitra.setBackground(cColor.White);
      menuCalonMitra.setSidebarNonAktif();

      menuTransaksiPulsa.setForeground(cColor.Gray);
      menuTransaksiPulsa.setBackground(cColor.White);
      menuTransaksiPulsa.setSidebarNonAktif();

      menuTransaksiPaket.setForeground(cColor.Gray);
      menuTransaksiPaket.setBackground(cColor.White);
      menuTransaksiPaket.setSidebarNonAktif();

      
      menuLogout.setSidebarNonAktif();
    } catch (Exception e) {
    
    }
  }

  // method refresh content
  private void refreshContent()
  {
    try{
      content.removeAll();
    } catch(Exception e) {
    }
  }

  public dashboardAdminView( boolean statusLogin )
  {
    super("Dashboard Admin");
    this.statusLogin = statusLogin;
    this.idSelected = null;
    roleText.setText("Admin");
    menuBeranda.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsBeranda();
      }
    });
    menuDataMitra.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsDataMitra();
      }
    });
    menuDataCustomer.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsDataCustomer();
      }
    });
    menuDataPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsDataPaket();
      }
    });
    menuRequestSaldo.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsRequestSaldo();
      }
    });
    menuCalonMitra.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsCalonMitra();
      }
    });
    menuTransaksiPulsa.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsTransaksiPulsa();
      }
    });
    menuTransaksiPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsTransaksiPaket();
      }
    });


    menuLogout.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsLogout();
      }
    });


    // add component default
    sidebar.add(menuBeranda);
    sidebar.add(menuDataMitra);
    sidebar.add(menuDataCustomer);
    sidebar.add(menuDataPaket);
    sidebar.add(menuRequestSaldo);
    sidebar.add(menuCalonMitra);
    sidebar.add(menuTransaksiPulsa);
    sidebar.add(menuTransaksiPaket);
    sidebar.add(menuLogout);

    initsBeranda();
  }

  private void initsBeranda()
  {
    idSelected = null;
    resetSidebar();
    menuBeranda.setBackground(cColor.Blue);
    menuBeranda.setForeground(cColor.White);
    refreshContent();
    menuBeranda.setSidebarAktif();
    menuTitle.setText("Beranda");

    valueJmlDataMitraBeranda.setText( String.valueOf( model.getCountMitraTerverifikasi()));
    valueJmlDataCustomerBeranda.setText(Integer.toString(model.getCountCustomer()));
    valueJmlTransaksiPulsaBeranda.setText(String.valueOf(model.getCountDoneTransaksiPulsa()));
    valueJmlTransaksiPaketBeranda.setText(String.valueOf(model.getCountDoneTransaksiPaket()));
    valueJmlCalonMitraBeranda.setText(String.valueOf(model.getCountMitraNonVerifikasi()));
    valueJmlRequestSaldoBeranda.setText(String.valueOf(model.getCountPendingTransaksiSaldo()));

    content.add(labelJmlDataMitraBeranda);
    content.add(valueJmlDataMitraBeranda);
    content.add(labelJmlDataCustomerBeranda);
    content.add(valueJmlDataCustomerBeranda);
    content.add(labelJmlTransaksiPulsaBeranda);
    content.add(valueJmlTransaksiPulsaBeranda);
    content.add(labelJmlTransaksiPaketBeranda);
    content.add(valueJmlTransaksiPaketBeranda);
    content.add(labelJmlCalonMitraBeranda);
    content.add(valueJmlCalonMitraBeranda);
    content.add(labelJmlRequestSaldoBeranda);
    content.add(valueJmlRequestSaldoBeranda);
    setVisible(true);
  }

  private void initsDataMitra()
  {
    idSelected = null;
    resetSidebar();
    menuDataMitra.setBackground(cColor.Blue);
    menuDataMitra.setForeground(cColor.White);
    refreshContent();
    menuDataMitra.setSidebarAktif();
    menuTitle.setText("Data Mitra");
    tblDataDataMitra = new cTable(model.getAllSaldoMitra());

    tblDataDataMitra.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(0).setWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(1).setWidth(0);
    
    spDataDataMitra = new cScrollPane(tblDataDataMitra, 25, 120, 670, 290);

    txtCariDataMitra.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        String keyword = txtCariDataMitra.getText();
        tblDataDataMitra.setModel(model.getSearchSaldoMitra(keyword));
        tblDataDataMitra.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(0).setWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataDataMitra.getColumnModel().getColumn(1).setWidth(0);
      }
    });


    btnHapusDataMitra.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       int selectedID = tblDataDataMitra.getSelectedRow();
       if (selectedID != -1) {
        // kalau ada dipilih
        int idMitra = Integer.valueOf(tblDataDataMitra.getValueAt(selectedID,1).toString());
       if (model.hapusMitra(idMitra)) {
         JOptionPane.showMessageDialog(null, "Data berhasil dihapus!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
         initsDataMitra();
        
       } else {
         JOptionPane.showMessageDialog(null, "Data gagal dihapus!", "Gagal", JOptionPane.ERROR_MESSAGE);
        
       }
      }  else {
        // kalau gak ada yang diseleksi
        JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
       }
    }
  });

    content.add(labelDataMitra);
    content.add(labelCariDataMitra);
    content.add(txtCariDataMitra);
    content.add(spDataDataMitra);
    content.add(btnHapusDataMitra);
    setVisible(true);
  }

  private void initsDataCustomer()
  {
    idSelected = null;
    resetSidebar();
    menuDataCustomer.setBackground(cColor.Blue);
    menuDataCustomer.setForeground(cColor.White);
    refreshContent();
    menuDataCustomer.setSidebarAktif();
    menuTitle.setText("Data Customer");

    tblDataDataCustomer = new cTable(model.getPulsaKuotaCustomer());
    tblDataDataCustomer.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataDataCustomer.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataDataCustomer.getColumnModel().getColumn(0).setWidth(0);
    tblDataDataCustomer.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataDataCustomer.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataDataCustomer.getColumnModel().getColumn(1).setWidth(0);

    spDataDataCustomer = new cScrollPane(tblDataDataCustomer, 25, 120, 670, 290);

    txtCariDataCustomer.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        String keyword = txtCariDataCustomer.getText();
        tblDataDataCustomer.setModel(model.getSearchPulsaKuotaCustomer(keyword));
        tblDataDataCustomer.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(0).setWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataDataCustomer.getColumnModel().getColumn(1).setWidth(0);
      }
    });


    btnHapusDataCustomer.addActionListener(new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
             int selectedID = tblDataDataCustomer.getSelectedRow();
             if (selectedID != -1) {
              // kalau ada dipilih
              int idCustomer = Integer.valueOf(tblDataDataCustomer.getValueAt(selectedID,1).toString());
             if (model.hapusCustomer(idCustomer)) {
               JOptionPane.showMessageDialog(null, "Data berhasil dihapus!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
               initsDataCustomer();
             } else {
               JOptionPane.showMessageDialog(null, "Data gagal dihapus!", "Gagal", JOptionPane.ERROR_MESSAGE);
             }
            }  else {
              // kalau gak ada yang diseleksi
              JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
             }
    }
    });

    content.add(labelDataCustomer);
    content.add(labelCariDataCustomer);
    content.add(txtCariDataCustomer);
    content.add(spDataDataCustomer);
    content.add(btnHapusDataCustomer);
    setVisible(true);
  }

  private void initsDataPaket()
  {
    idSelected = null;
    resetSidebar();
    menuDataPaket.setBackground(cColor.Blue);
    menuDataPaket.setForeground(cColor.White);
    refreshContent();
    menuDataPaket.setSidebarAktif();
    menuTitle.setText("Data Paket");

    

    tblDataDataPaket = new cTable(model.getAllPaket());
    tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);

    spDataDataPaket = new cScrollPane(tblDataDataPaket, 25, 175, 555, 250);

    txtCariDataPaket.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        Filter.keyword = txtCariDataPaket.getText();
     tblDataDataPaket.setModel(Filter.search());
     tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
     tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
     tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
      }
    });

    rdSemuaDataPaket.setSelected(true);
    groupActionDataPaket.add(rdSemuaDataPaket);
    groupActionDataPaket.add(rdAktifDataPaket);
    groupActionDataPaket.add(rdTidakAktifDataPaket);

    rdSemuaDataPaket.addMouseListener(new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent e){
        Filter.filter = "semua";
        tblDataDataPaket.setModel(Filter.search());
        tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
        valueDeskripsiPaketDataPaket.setText(null);
      }
    });

    rdAktifDataPaket.addMouseListener(new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent e){
        Filter.filter = "aktif";
        tblDataDataPaket.setModel(Filter.search());
        tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
        valueDeskripsiPaketDataPaket.setText(null);
      }
    });

    rdTidakAktifDataPaket.addMouseListener(new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent e){
        Filter.filter = "tidak aktif";
        tblDataDataPaket.setModel(Filter.search());
        tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
        valueDeskripsiPaketDataPaket.setText(null);
      }
    });

    tblDataDataPaket.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mousePressed(java.awt.event.MouseEvent e) {
        int selectedIndex = tblDataDataPaket.getSelectedRow();
        // int idPaket = Integer.valueOf(tblDataDataPaket.getValueAt(selectedIndex, 0).toString());    
       int idPaket = Integer.parseInt(tblDataDataPaket.getValueAt(selectedIndex, 0).toString());
       String deskripsiPaket = model.getDetailPaket(idPaket)[2].toString();
       valueDeskripsiPaketDataPaket.setText(deskripsiPaket);
  }
  });

    btnTambahDataPaket.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsTambahPaket();
      }
    });

    btnUbahDataPaket.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
      //  initsUbahPaket();
      Integer selectedIndex = tblDataDataPaket.getSelectedRow();
      // validasi kalau gak ada yang di seleksi
      if (selectedIndex == -1) {
        // ngapain kalau gak ada yang diseleksi
        JOptionPane.showMessageDialog(dashboardAdminView.this, "Pilih data paket yang mau diubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
       } else {
        int idPaket = Integer.valueOf(tblDataDataPaket.getValueAt(selectedIndex, 0).toString());
        initsUbahPaket(idPaket);
       }
      }

    });

    
    
    content.add(labelDataPaket);
    content.add(labelCariDataPaket);
    content.add(txtCariDataPaket);
    content.add(btnTambahDataPaket);
    content.add(rdSemuaDataPaket);
    content.add(rdAktifDataPaket);
    content.add(rdTidakAktifDataPaket);
    content.add(spDataDataPaket);
    content.add(btnUbahDataPaket);
    content.add(labelDeskripsiPaketDataPaket);
    content.add(valueDeskripsiPaketDataPaket);
    setVisible(true);
  }

  private void initsTambahPaket()
  {
    // setVisible(false);
    idSelected = null;
    resetSidebar();
    menuDataPaket.setBackground(cColor.Blue);
    menuDataPaket.setForeground(cColor.White);
    refreshContent();
    menuDataPaket.setSidebarAktif();
    menuTitle.setText("Tambah Data Paket");


    // ini adalah cara untuk set text jadi null
    txtNamaPaketTambahDataPaket.setText(null);
    txtKuotaPaketTambahDataPaket.setText(null);
    txtHargaPaketTambahDataPaket.setText(null);
    txtDeskripsiPaketTambahDataPaket.setText(null);
    chAktifTambahDataPaket.setSelected(false);

    btnBatalTambahDataPaket.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsDataPaket();
      }
    });

    btnTambahPaketTambahDataPaket.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae){   
        if(txtNamaPaketTambahDataPaket.getText().trim().isEmpty() || txtKuotaPaketTambahDataPaket.getText().trim().isEmpty() || txtHargaPaketTambahDataPaket.getText().trim().isEmpty() || txtDeskripsiPaketTambahDataPaket.getText().trim().isEmpty()){
          dashboardAdminView.this.setVisible(false);
          // spesifik ke txt nama paket
          if (txtNamaPaketTambahDataPaket.getText().trim().isEmpty()) {
            content.add(errorNamaPaketTambahDataPaket);
          }else{
            content.remove(errorNamaPaketTambahDataPaket);
          }

          // spesifik ke kuota
          if (txtKuotaPaketTambahDataPaket.getText().trim().isEmpty()) 
            content.add(errorKuotaPaketTambahDataPaket);
          else
            content.remove(errorKuotaPaketTambahDataPaket);
          
            // spesifik ke harga
            if (txtHargaPaketTambahDataPaket.getText().trim().isEmpty()) 
              content.add(errorHargaPaketTambahDataPaket);
            else
              content.remove(errorHargaPaketTambahDataPaket);

            // spesifikasi ke deskripsi

            if (txtDeskripsiPaketTambahDataPaket.getText().trim().isEmpty()) {
              content.add(errorNamaPaketTambahDataPaket);
            }else{
              content.remove(errorNamaPaketTambahDataPaket);
            }
            

        }else{
          // INSERT DATA
          String nama = txtNamaPaketTambahDataPaket.getText();
          Integer kuota = Integer.valueOf(txtKuotaPaketTambahDataPaket.getText());
          Integer harga = Integer.valueOf(txtHargaPaketTambahDataPaket.getText());
          String deskripsi = txtDeskripsiPaketTambahDataPaket.getText();
          String statusAktif = chAktifTambahDataPaket.isSelected() ?  chAktifTambahDataPaket.getActionCommand() : "0";

          // panggil method isertData

          if (model.insertData(nama, deskripsi, kuota, harga, statusAktif)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(dashboardAdminView.this, "Berhasil tambah data paket.", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            initsDataPaket();
          } else {
           // kalau gagagl
           JOptionPane.showMessageDialog(dashboardAdminView.this, "Gagal tambah data paket.", "Gagal", JOptionPane.ERROR_MESSAGE);
          }
        }

      }
    });
    content.add(labelTambahDataPaket);
    content.add(labelNamaPaketTambahDataPaket);
    content.add(txtNamaPaketTambahDataPaket);
    content.add(errorNamaPaketTambahDataPaket);
    content.add(labelKuotaPaketTambahDataPaket);
    content.add(txtKuotaPaketTambahDataPaket);
    content.add(errorKuotaPaketTambahDataPaket);
    content.add(labelHargaPaketTambahDataPaket);
    content.add(txtHargaPaketTambahDataPaket);
    content.add(errorHargaPaketTambahDataPaket);
    content.add(chAktifTambahDataPaket);
    content.add(btnTambahPaketTambahDataPaket);
    content.add(btnBatalTambahDataPaket);
    content.add(labelDeskripsiPaketTambahDataPaket);
    content.add(spTxtDeskripsiPaketTambahDataPaket);
    content.add(errorDeskripsiPaketTambahDataPaket);
    setVisible(true);
  }
  private void initsUbahPaket(int idPaket)
  {
    // setVisible(false);
    idSelected = null;
    resetSidebar();
    menuDataPaket.setBackground(cColor.Blue);
    menuDataPaket.setForeground(cColor.White);
    refreshContent();
    menuDataPaket.setSidebarAktif();
    menuTitle.setText("Ubah Data Paket");

    // ini adalah cara untuk set text jadi yang relevan

    Object[] detailPaket = model.getDetailPaket(idPaket);

    txtNamaPaketUbahDataPaket.setText(detailPaket[1].toString());
    txtKuotaPaketUbahDataPaket.setText(detailPaket[3].toString());
    txtHargaPaketUbahDataPaket.setText(detailPaket[4].toString());
    txtDeskripsiPaketUbahDataPaket.setText(detailPaket[2].toString());
    if (detailPaket[5].toString().equalsIgnoreCase("1")) {
      chAktifUbahDataPaket.setSelected(true);
    }else{
      chAktifUbahDataPaket.setSelected(false);
    }

    btnBatalUbahDataPaket.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsDataPaket();
      }
    });

    btnUbahPaketUbahDataPaket.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(java.awt.event.ActionEvent ae){   
          // pengecekan kalau fieldnya kosong
          if(txtNamaPaketUbahDataPaket.getText().trim().isEmpty() || txtKuotaPaketUbahDataPaket.getText().trim().isEmpty() || txtHargaPaketUbahDataPaket.getText().trim().isEmpty() || txtDeskripsiPaketUbahDataPaket.getText().trim().isEmpty()){
            dashboardAdminView.this.setVisible(false);

            // spesifik ke txt nama paket
            if (txtNamaPaketUbahDataPaket.getText().trim().isEmpty()) {
              content.add(errorNamaPaketUbahDataPaket);
            }else{
              content.remove(errorNamaPaketUbahDataPaket);
            }
  
            // spesifik ke kuota
            if (txtKuotaPaketUbahDataPaket.getText().trim().isEmpty()) 
              content.add(errorKuotaPaketUbahDataPaket);
            else
              content.remove(errorKuotaPaketUbahDataPaket);
            
              // spesifik ke harga
              if (txtHargaPaketUbahDataPaket.getText().trim().isEmpty()) 
                content.add(errorHargaPaketUbahDataPaket);
              else
                content.remove(errorHargaPaketUbahDataPaket);
  
              // spesifikasi ke deskripsi
  
              if (txtDeskripsiPaketUbahDataPaket.getText().trim().isEmpty()) {
                content.add(errorDeskripsiPaketUbahDataPaket);
              }else{
                content.remove(errorDeskripsiPaketUbahDataPaket);
              }

              dashboardAdminView.this.setVisible(true);
              
  
          }else{
            // INSERT DATA
            String nama = txtNamaPaketUbahDataPaket.getText();
            int kuota = Integer.valueOf(txtKuotaPaketUbahDataPaket.getText());
            int harga = Integer.valueOf(txtHargaPaketUbahDataPaket.getText());
            String deskripsi = txtDeskripsiPaketUbahDataPaket.getText();
            String statusAktif = chAktifUbahDataPaket.isSelected() ?  chAktifUbahDataPaket.getActionCommand() : "0";
  
            // panggil method ubah data paket
  
            if (model.updateData(idPaket, nama, deskripsi, kuota, harga, statusAktif)) {
              // kalau berhasil
              JOptionPane.showMessageDialog(dashboardAdminView.this, "Berhasil tambah data paket.", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
              initsDataPaket();
            } else {
             // kalau gagal
             JOptionPane.showMessageDialog(dashboardAdminView.this, "Gagal tambah data paket.", "Gagal", JOptionPane.ERROR_MESSAGE);
            }
          }
  
        }
      });

    content.add(labelUbahDataPaket);
    content.add(labelNamaPaketUbahDataPaket);
    content.add(txtNamaPaketUbahDataPaket);
   
    content.add(labelKuotaPaketUbahDataPaket);
    content.add(txtKuotaPaketUbahDataPaket);
   
    content.add(labelHargaPaketUbahDataPaket);
    content.add(txtHargaPaketUbahDataPaket);
   
    content.add(chAktifUbahDataPaket);
    content.add(btnUbahPaketUbahDataPaket);
    content.add(btnBatalUbahDataPaket);
    content.add(labelDeskripsiPaketUbahDataPaket);
    content.add(spTxtDeskripsiPaketUbahDataPaket);
   
    setVisible(true);
  }

  private void initsRequestSaldo()
  {
    idSelected = null;
    resetSidebar();
    menuRequestSaldo.setBackground(cColor.Blue);
    menuRequestSaldo.setForeground(cColor.White);
    refreshContent();
    menuRequestSaldo.setSidebarAktif();
    menuTitle.setText("Request Saldo Pending");
    
    tblDataRequestSaldo = new cTable(model.getPendingTransaksiSaldo());
    tblDataRequestSaldo.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataRequestSaldo.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataRequestSaldo.getColumnModel().getColumn(0).setWidth(0);

    spDataRequestSaldo = new cScrollPane(tblDataRequestSaldo, 25, 120, 555, 310);

    ActionListener[] listeners = txtCariRequestSaldo.getActionListeners();
    for (ActionListener listener : listeners) {
      txtCariRequestSaldo.removeActionListener(listener);
    }

    txtCariRequestSaldo.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed( java.awt.event.ActionEvent ae )
      {
        String keyword = txtCariRequestSaldo.getText();

        tblDataRequestSaldo.setModel(model.getSearchPendingTransaksiSaldo(keyword));

        tblDataRequestSaldo.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataRequestSaldo.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataRequestSaldo.getColumnModel().getColumn(0).setWidth(0);
      }
    } );

    ActionListener[] listeners2 = btnLihatBerhasilRequestSaldo.getActionListeners();
    for (ActionListener listener : listeners2) {
      btnLihatBerhasilRequestSaldo.removeActionListener(listener);
    }

    btnLihatBerhasilRequestSaldo.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsRequestSaldoDone();
      }
    });

    ActionListener[] listeners3 = btnApproveRequestSaldo.getActionListeners();
    for (ActionListener listener : listeners3) {
      btnApproveRequestSaldo.removeActionListener(listener);
    }

    btnApproveRequestSaldo.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed( java.awt.event.ActionEvent ae)
      {
        int selectedIndex = Integer.valueOf(tblDataRequestSaldo.getSelectedRow());

        // pengecekan apakah data ada yang dipilih atau tidak
        if( selectedIndex == -1){
          // tidak ada yang dipilih
          JOptionPane.showMessageDialog(dashboardAdminView.this, "Pilih data terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }else{
          // kalo ada yan dipilih
          int idRequestSaldo = Integer.valueOf( tblDataRequestSaldo.getValueAt(selectedIndex, 0).toString() );
          
          if( model.verifikasiRequestSaldo( idRequestSaldo ) ){
            JOptionPane.showMessageDialog(dashboardAdminView.this, "Request saldo berhasil disetujui.", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            initsRequestSaldoDone();
          }else{
            JOptionPane.showMessageDialog(dashboardAdminView.this, "Request saldo gagal disetujui!", "Gagal", JOptionPane.ERROR_MESSAGE);
          }
          
        }

      }
    });

    content.add(labelRequestSaldo);
    content.add(labelCariRequestSaldo);
    content.add(txtCariRequestSaldo);
    content.add(btnLihatBerhasilRequestSaldo);
    content.add(spDataRequestSaldo);
    content.add(btnApproveRequestSaldo);
    setVisible(true);
  }
  private void initsRequestSaldoDone()
  {
    // setVisible(false);
    idSelected = null;
    resetSidebar();
    menuRequestSaldo.setBackground(cColor.Blue);
    menuRequestSaldo.setForeground(cColor.White);
    refreshContent();
    menuRequestSaldo.setSidebarAktif();
    menuTitle.setText("Permintaan Saldo Berhasil");
   
    tblDataRequestSaldoDone = new cTable(model.getDoneTransaksiSaldo());
    tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataRequestSaldoDone.getColumnModel().getColumn(0).setWidth(0);

    spDataRequestSaldoDone = new cScrollPane(tblDataRequestSaldoDone, 25, 115, 555, 310);
    txtCariRequestSaldoDone.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        String keyword = txtCariRequestSaldoDone.getText();
       tblDataRequestSaldoDone.setModel(model.getSearchDoneTransaksiSaldo(keyword));
       tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMinWidth(0);
       tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMaxWidth(0);
       tblDataRequestSaldoDone.getColumnModel().getColumn(0).setWidth(0);
      }
    });


    btnLihatPendingRequestSaldoDone.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsRequestSaldo();
      }
    });

    content.add(labelRequestSaldoDone);
    content.add(labelCariRequestSaldoDone);
    content.add(txtCariRequestSaldoDone);
    content.add(btnLihatPendingRequestSaldoDone);
    content.add(spDataRequestSaldoDone);
    setVisible(true);
  }

  private void initsCalonMitra()
  {
    idSelected = null;
    resetSidebar();
    menuCalonMitra.setBackground(cColor.Blue);
    menuCalonMitra.setForeground(cColor.White);
    refreshContent();
    menuCalonMitra.setSidebarAktif();
    menuTitle.setText("Calon Mitra");
   
    tblDataCalonMitra = new cTable(model.getMitraNonVerifikasi());
    tblDataCalonMitra.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataCalonMitra.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataCalonMitra.getColumnModel().getColumn(0).setWidth(0);
   
    spDataCalonMitra = new cScrollPane(tblDataCalonMitra, 25, 115, 555, 310);

    txtCariCalonMitra.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        String keyword = txtCariCalonMitra.getText();
       tblDataCalonMitra.setModel(model.getSearchMitraNonVerifikasi(keyword));
       tblDataCalonMitra.getColumnModel().getColumn(0).setMinWidth(0);
       tblDataCalonMitra.getColumnModel().getColumn(0).setMaxWidth(0);
       tblDataCalonMitra.getColumnModel().getColumn(0).setWidth(0);
      }
    });

    ActionListener[] listeners = btnApproveCalonMitra.getActionListeners();
    for (ActionListener listener : listeners) {
      btnApproveCalonMitra.removeActionListener(listener);
    }

    btnApproveCalonMitra.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent e) {
      int selectedIndex = tblDataCalonMitra.getSelectedRow();

      if (selectedIndex == -1) {
        // jika tidak ada yang dipilih 
        JOptionPane.showMessageDialog(dashboardAdminView.this, "Pilih calon mitra yang ingin diapprove.", "Peringatan", JOptionPane.WARNING_MESSAGE);
      } else {
        //kalau ada yang dipilih
        int idMitra = Integer.parseInt(tblDataCalonMitra.getValueAt(selectedIndex, 0).toString());
        if (model.verifikasiMitra(idMitra)) {
          JOptionPane.showMessageDialog(dashboardAdminView.this, "Calon mitra berhasil diverifikasi!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
          initsDataMitra();
          
        } else {
          JOptionPane.showMessageDialog(dashboardAdminView.this, "Gagal verifikasi calon mitra!", "Gagal", JOptionPane.ERROR_MESSAGE);
          
        }
        
      }
  }
});

    content.add(labelCalonMitra);
    content.add(labelCariCalonMitra);
    content.add(txtCariCalonMitra);
    content.add(spDataCalonMitra);
    content.add(btnApproveCalonMitra);
    setVisible(true);
  }

  private void initsTransaksiPulsa()
  {
    idSelected = null;
    resetSidebar();
    menuTransaksiPulsa.setBackground(cColor.Blue);
    menuTransaksiPulsa.setForeground(cColor.White);
    refreshContent();
    menuTransaksiPulsa.setSidebarAktif();
    menuTitle.setText("Transaksi Pulsa");
    // String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
    // String[][] dataUser = {
    //   {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
    //   {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
    //   {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
    //   {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
    //   {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
    // };
   // dmTransaksiPulsa = new DefaultTableModel(dataUser, dataUserHeader);
    tblDataTransaksiPulsa = new cTable(model.getAllTransaksiPulsa());
    tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataTransaksiPulsa.getColumnModel().getColumn(0).setWidth(0);

    
    spDataTransaksiPulsa = new cScrollPane(tblDataTransaksiPulsa, 25, 120, 930, 310);

    txtCariTransaksiPulsa.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        String keyword = txtCariTransaksiPulsa.getText();
       tblDataTransaksiPulsa.setModel(model.getSearchAllTransaksiPulsa(keyword));
       tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMinWidth(0);
       tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMaxWidth(0);
       tblDataTransaksiPulsa.getColumnModel().getColumn(0).setWidth(0);
      }
    });

    content.add(labelTransaksiPulsa);
    content.add(labelCariTransaksiPulsa);
    content.add(txtCariTransaksiPulsa);
    content.add(spDataTransaksiPulsa);
    setVisible(true);
  }

  private void initsTransaksiPaket()
  {
    idSelected = null;
    resetSidebar();
    menuTransaksiPaket.setBackground(cColor.Blue);
    menuTransaksiPaket.setForeground(cColor.White);
    refreshContent();
    menuTransaksiPaket.setSidebarAktif();
    menuTitle.setText("Transaksi Paket");
    // String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
    // String[][] dataUser = {
    //   {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
    //   {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
    //   {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
    //   {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
    //   {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
    // };
    // dmTransaksiPaket = new DefaultTableModel(dataUser, dataUserHeader);

    tblDataTransaksiPaket = new cTable(model.getAllTransaksiPaket());
    tblDataTransaksiPaket.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataTransaksiPaket.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataTransaksiPaket.getColumnModel().getColumn(0).setWidth(0);


    spDataTransaksiPaket = new cScrollPane(tblDataTransaksiPaket, 25, 120, 930, 310);

    txtCariTransaksiPaket.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        String keyword = txtCariTransaksiPaket.getText();
     tblDataTransaksiPaket.setModel(model.getSearchAllTransaksiPaket(keyword));
     tblDataTransaksiPaket.getColumnModel().getColumn(0).setMinWidth(0);
     tblDataTransaksiPaket.getColumnModel().getColumn(0).setMaxWidth(0);
     tblDataTransaksiPaket.getColumnModel().getColumn(0).setWidth(0);
      }
    });

    content.add(labelTransaksiPaket);
    content.add(labelCariTransaksiPaket);
    content.add(txtCariTransaksiPaket);
    content.add(spDataTransaksiPaket);
    setVisible(true);
  }

  private void initsLogout()
  {
    Object[] options = { "YA", "BATAL" };
    int confirm = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout",
    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
    null, options, options[0]);
    if(confirm == 0 ){
      this.statusLogin = false;
      this.idSelected = null;
      com.program.Controller.showLoginAdmin();
    }
  }


  
}