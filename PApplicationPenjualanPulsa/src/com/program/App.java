package com.program;
import com.views.startView;


  public class App {

    public static void main(String[] args) {
     //   Controller.showDashboardAdmin(true);
   
     startView auth = new startView();
     auth.initsLoginCustomer();
     auth.setVisible(true);
    }
}