package com.views;
import com.template.cDashboardFrame;
import com.partials.*;
import javax.swing.JOptionPane;
// javax.swing.*;
import java.awt.event.*;

// import javax.swing.table.DefaultTableModel;
import com.program.*;

public class dashboardMitraView extends cDashboardFrame {

 // properti
  Integer  idMitra = null; //default
  //Integer selectedID = null;

 // sidebar menu
 private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
 private cSidebarMenu menuInfoSaldo = new cSidebarMenu("Info Saldo", 70+50);
 private cSidebarMenu menuRequestPulsa = new cSidebarMenu("Request Pulsa", 70+50+50);
 private cSidebarMenu menuTransaksiSaya = new cSidebarMenu("Transaksi Saya", 70+50+50+50);
 private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70+50+50+50+50);

 // components of beranda
 private cLabelInfo labelSisaSaldoBeranda = new cLabelInfo("Sisa Saldo Anda", 25, 20);
 private cBigFont valueSisaSaldoBeranda = new cBigFont("0", 25, 60);
 private cLabelInfo labelPelayananBeranda = new cLabelInfo("Pelayanan Pulsa Customer", 25, 150);
 private cBigFont valuePelayananBeranda = new cBigFont("", 25, 190);
 private cLabelInfo labelRequestPulsaBeranda = new cLabelInfo("Request Pulsa Customer Saat Ini", 25, 280);
 private cBigFont valueRequestPulsaBeranda = new cBigFont("", 25, 320);

 
 // components of InfoSaldo
 private cLabelInfo labelSisaSaldoInfoSaldo = new cLabelInfo("Sisa Saldo Anda", 25, 20);
 private cBigFont valueSisaSaldoInfoSaldo = new cBigFont("0", 25, 60);
 private cLabelInfo labelRequestSaldoInfoSaldo = new cLabelInfo("Data Request", 25, 150);
 // private DefaultTableModel dmRequestSaldo;
 private cTable tblDataRequestSaldo;
 private cScrollPane spDataRequestSaldo;
 private cLabelInfo labelDoRequestSaldoInfoSaldo = new cLabelInfo("Request Saldo", 490, 20);
 private cErorLabel errorDoRequestSaldoInfoSaldo = new cErorLabel("tidak bisa melakukan request jika saldo masih diatas 100K", 490, 60, 400, false);
 private cBlueButton btnRequestSaldo = new cBlueButton("Request", 490, 90, 155);
 
 
 // components of RequestPulsa
 private cLabelInfo labelDataRequestPulsa = new cLabelInfo("Sisa Saldo Anda", 25, 20);
 //private DefaultTableModel dmRequestPulsa;
 private cTable tblDataRequestPulsa;
 private cScrollPane spDataRequestPulsa;
 private cBlueButton btnIsiPulsa = new cBlueButton("Isi Pulsa", 25, 280, 155);
 

 // components of Transaksi Saya
 private cLabelInfo labelDataTransaksiSaya = new cLabelInfo("Data Pelayanan Pulsa Berhasil Anda", 25, 20);
// private DefaultTableModel dmTransaksiSaya;
 private cTable tblDataTransaksiSaya;
 private cScrollPane spDataTransaksiSaya;



 // method resetSidebar
 private void resetSidebar()
 {
   try {
     setVisible(false);

     menuBeranda.setForeground(cColor.Gray);
     menuBeranda.setBackground(cColor.White);
     menuBeranda.setSidebarNonAktif();

     menuInfoSaldo.setForeground(cColor.Gray);
     menuInfoSaldo.setBackground(cColor.White);
     menuInfoSaldo.setSidebarNonAktif();

     menuRequestPulsa.setForeground(cColor.Gray);
     menuRequestPulsa.setBackground(cColor.White);
     menuRequestPulsa.setSidebarNonAktif();

     menuTransaksiSaya.setForeground(cColor.Gray);
     menuTransaksiSaya.setBackground(cColor.White);
     menuTransaksiSaya.setSidebarNonAktif();
     
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

 public dashboardMitraView( Integer id )
 {
   super("Dashboard Mitra");
   this.idMitra = id;
   roleText.setText("Mitra | " + model.getDetailMitra(idMitra)[1].toString());
   menuBeranda.addMouseListener( new java.awt.event.MouseAdapter(){
     @Override
     public void mouseClicked(java.awt.event.MouseEvent me)
     {
       initsBeranda();
     }
   });
   menuInfoSaldo.addMouseListener( new java.awt.event.MouseAdapter(){
     @Override
     public void mouseClicked(java.awt.event.MouseEvent me)
     {
       initsInfoSaldo();
     }
   });
   menuRequestPulsa.addMouseListener( new java.awt.event.MouseAdapter(){
     @Override
     public void mouseClicked(java.awt.event.MouseEvent me)
     {
       initsRequestPulsa();
     }
   });
   menuTransaksiSaya.addMouseListener( new java.awt.event.MouseAdapter(){
     @Override
     public void mouseClicked(java.awt.event.MouseEvent me)
     {
       initsTransaksiSaya();
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
         idMitra = null;
         // selectedID = null;
         com.program.Controller.showLoginMitra();
       }
     }
   });

   if (model.getDetailMitra(idMitra)[3].toString().equalsIgnoreCase("1")) {
    // add component default
   sidebar.add(menuBeranda);
   sidebar.add(menuInfoSaldo);
   sidebar.add(menuRequestPulsa);
   sidebar.add(menuTransaksiSaya);
   sidebar.add(menuLogout);
   } else {
    sidebar.add(menuBeranda);
    menuLogout.setLocation(menuLogout.getLocation().x, menuBeranda.getLocation().y + 50);
    sidebar.add(menuLogout);
   }
   

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

   if (model.getDetailMitra(idMitra)[3].toString().equalsIgnoreCase("1")) {
    
    valueSisaSaldoBeranda.setText( String.valueOf( model.getDetailSaldoMitra(idMitra) ) );
    valuePelayananBeranda.setText(String.valueOf(model.getCountDoneTransaksiPulsaMitra(idMitra)));
    valueRequestPulsaBeranda.setText(String.valueOf(model.getCountPendingTransaksiPulsa()));
   
 
    content.add(labelSisaSaldoBeranda);
    content.add(valueSisaSaldoBeranda);
    content.add(labelPelayananBeranda);
    content.add(valuePelayananBeranda);
    content.add(labelRequestPulsaBeranda);
    content.add(valueRequestPulsaBeranda);
    setVisible(true);

   } else {
    labelSisaSaldoBeranda.setText("Anda belum terverifikasi! silahkan tunggu respon dari admin.");
    labelSisaSaldoBeranda.setSize(labelSisaSaldoBeranda.getWidth() + 300, labelSisaSaldoBeranda.getHeight());
   
   }

   content.add(labelSisaSaldoBeranda);
   setVisible(true);
 }
 
 private void initsInfoSaldo() {
  // selectedID = null;
  resetSidebar();
  menuInfoSaldo.setBackground(cColor.Blue);
  menuInfoSaldo.setForeground(cColor.White);
  refreshContent();
  menuInfoSaldo.setSidebarAktif();
  menuTitle.setText("Informasi Saldo");
 
  valueSisaSaldoInfoSaldo.setText(String.valueOf(model.getDetailSaldoMitra(idMitra)));

  tblDataRequestSaldo = new cTable(model.getAllTransaksiSaldoByMitra(idMitra));

  spDataRequestSaldo = new cScrollPane(tblDataRequestSaldo, 25, 190, 400, 220);

  if (model.getDetailSaldoMitra(idMitra) <= 100000) {
      if (!content.isAncestorOf(btnRequestSaldo)) {
          content.add(btnRequestSaldo);
      }
  } else {
      if (content.isAncestorOf(btnRequestSaldo)) {
          content.remove(btnRequestSaldo);
      }
  }

  // Mendapatkan semua listener yang ada pada btnRequestSaldo dan menghapusnya:
  ActionListener[] listeners = btnRequestSaldo.getActionListeners();
for (ActionListener listener : listeners) {
    btnRequestSaldo.removeActionListener(listener);
}


  btnRequestSaldo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
          // cek apakah request saldo berhasil atau tidak
          if (model.requestSaldoMitra(idMitra)) {
              // kalau berhasil
              JOptionPane.showMessageDialog(dashboardMitraView.this, "Request saldo berhasil!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
              initsInfoSaldo(); 
          } else {
              // kalau tidak
              JOptionPane.showMessageDialog(dashboardMitraView.this, "Request saldo gagal!", "Gagal", JOptionPane.ERROR_MESSAGE);
          }
      }
      
  }
  );

  content.add(labelSisaSaldoInfoSaldo);
  content.add(valueSisaSaldoInfoSaldo);
  content.add(labelRequestSaldoInfoSaldo);
  content.add(spDataRequestSaldo);
  content.add(labelDoRequestSaldoInfoSaldo);
  content.add(btnRequestSaldo);
  content.add(errorDoRequestSaldoInfoSaldo);
  setVisible(true);
}

 private void initsRequestPulsa() {
  // selectedID = null;
  resetSidebar();
  menuRequestPulsa.setBackground(cColor.Blue);
  menuRequestPulsa.setForeground(cColor.White);
  refreshContent();
  menuRequestPulsa.setSidebarAktif();
  menuTitle.setText("Request Pulsa Customer");

  // Inisialisasi tabel dengan data pending transaksi pulsa
  tblDataRequestPulsa = new cTable(model.getPendingTransaksiPulsa());
  // Sembunyikan kolom pertama
  tblDataRequestPulsa.getColumnModel().getColumn(0).setMinWidth(0);
  tblDataRequestPulsa.getColumnModel().getColumn(0).setWidth(0);
  tblDataRequestPulsa.getColumnModel().getColumn(0).setMaxWidth(0);
  // Sembunyikan kolom kedua
  tblDataRequestPulsa.getColumnModel().getColumn(1).setMinWidth(0);
  tblDataRequestPulsa.getColumnModel().getColumn(1).setWidth(0);
  tblDataRequestPulsa.getColumnModel().getColumn(1).setMaxWidth(0);
  spDataRequestPulsa = new cScrollPane(tblDataRequestPulsa, 25, 76, 800, 190);

  // Mendapatkan semua listener yang ada pada btnRequestSaldo dan menghapusnya:
  ActionListener[] listeners = btnIsiPulsa.getActionListeners();
for (ActionListener listener : listeners) {
    btnIsiPulsa.removeActionListener(listener);
}

  // Tambahkan event listener untuk tombol isi pulsa
  btnIsiPulsa.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
         // System.out.println("Button clicked"); // Logging untuk debugging

          int selectedIndex = tblDataRequestPulsa.getSelectedRow();

          // Cek apakah ada baris yang dipilih
          if (selectedIndex == -1) {
              // Jika tidak ada baris yang dipilih
              JOptionPane.showMessageDialog(dashboardMitraView.this, "Pilih data terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
          } else {
              // Jika ada baris yang dipilih
              int jumlahPulsa = Integer.parseInt(tblDataRequestPulsa.getValueAt(selectedIndex, 4).toString());

              // Cek apakah saldo mitra mencukupi
              if (model.getDetailSaldoMitra(idMitra) <= jumlahPulsa + 1000) {
                  // Jika saldo tidak mencukupi
                  JOptionPane.showMessageDialog(dashboardMitraView.this, "Saldo anda tidak mencukupi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
              } else {
                  // Jika saldo mencukupi

                  // Tangkap idTransaksiPulsa
                  int idTransaksiPulsa = Integer.valueOf(tblDataRequestPulsa.getValueAt(selectedIndex, 0).toString());

                  // Validasi pengisian pulsa
                  if (model.isiPulsaCustomer(idTransaksiPulsa, idMitra)) {
                      // Jika berhasil
                      JOptionPane.showMessageDialog(dashboardMitraView.this, "Isi pulsa berhasil.", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                      initsTransaksiSaya();
                  } else {
                      // Jika gagal
                      JOptionPane.showMessageDialog(dashboardMitraView.this, "Isi pulsa gagal!", "Gagal", JOptionPane.ERROR_MESSAGE);
                  }
              }
          }
      }
  });

  // Tambahkan komponen ke konten
  content.add(labelDataRequestPulsa);
  content.add(spDataRequestPulsa);
  content.add(btnIsiPulsa);
  setVisible(true);
}


 private void initsTransaksiSaya()
 {
 // selectedID = null;
   resetSidebar();
   menuTransaksiSaya.setBackground(cColor.Blue);
   menuTransaksiSaya.setForeground(cColor.White);
   refreshContent();
   menuTransaksiSaya.setSidebarAktif();
   menuTitle.setText("Transaksi Pulsa Anda");
  

   tblDataTransaksiSaya = new cTable(model.getDoneTransaksiPulsaByMitra(idMitra));
   spDataTransaksiSaya = new cScrollPane(tblDataTransaksiSaya, 25, 76, 740, 310);
   content.add(labelDataTransaksiSaya);
   content.add(spDataTransaksiSaya);
   setVisible(true);
 }

 
}