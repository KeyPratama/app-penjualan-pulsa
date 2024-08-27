package com.partials;
import javax.swing.JTable;

public class cTable extends JTable {

    public cTable(javax.swing.table.TableModel dm){
      super(dm);
      
      setFont(cFonts.TEXT_FIELD_FONT);
      getTableHeader().setFont(cFonts.HEADER_TABLE_FONT);
      getTableHeader().setBackground(cColor.Ungu);
      getTableHeader().setForeground(cColor.White);
      setRowHeight(30);
      getTableHeader().setReorderingAllowed(false);
      setShowVerticalLines(false);
      setShowHorizontalLines(false);
      setSelectionMode( javax.swing.ListSelectionModel.SINGLE_SELECTION);  // Allow only one row to be selected at a time.
      setDragEnabled(true);

    }
    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }
}
