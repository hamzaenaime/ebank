/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS.Table;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nafar
 */
public class EmployeeTable extends AbstractTableModel {

    private int NbreLignes = 0;
    private int Nbcolonnes;
    private String[] columnNames;
    private ArrayList<Vector<String>> MesLignes = new ArrayList<Vector<String>>();

    public EmployeeTable(ResultSet Res) {
        try {
            ResultSetMetaData rsmd = Res.getMetaData();
            Nbcolonnes = rsmd.getColumnCount();
            columnNames = new String[Nbcolonnes];
            //set the header of table that contain table attribute
            for (int i = 0; i < Nbcolonnes; i++) {
                columnNames[i] = rsmd.getColumnLabel(i + 1);
            }
            //set the content of table
            Vector<String> Ligne;
            while (Res.next()) {
                Ligne = new Vector<String>();
                for (int i = 0; i < Nbcolonnes; i++) {
                    Ligne.add(Res.getObject(i + 1).toString());
                }
                MesLignes.add(Ligne);
                NbreLignes++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(OperationTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int getRowCount() {
        return NbreLignes;
    }

    @Override
    public int getColumnCount() {
        return Nbcolonnes;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return MesLignes.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /*@Override
     public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        return col >= 3;
    }*/
}
