/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUES.DashBaordEmployer;

import MODELS.Employe;
import MODELS.Table.EmployeeTable;
import java.sql.ResultSet;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author hamza
 */
public class Reclamations extends javax.swing.JPanel implements ListSelectionListener {

    /**
     * Creates new form Reclamations
     */
    public Reclamations() {
        initComponents();
        afficher();
        ListSelectionModel selectionModel = reclamations.getSelectionModel();
        selectionModel.addListSelectionListener(this);

    }

    public void afficher() {
        ResultSet res;
        res = Employe.getReclamation();
        EmployeeTable employeModel = new EmployeeTable(res);
        reclamations.setModel(employeModel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        reclamations = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 204));

        reclamations.setBackground(new java.awt.Color(255, 255, 255));
        reclamations.setForeground(new java.awt.Color(0, 0, 0));
        reclamations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        reclamations.setGridColor(new java.awt.Color(255, 255, 255));
        reclamations.setRowHeight(32);
        reclamations.setSelectionBackground(new java.awt.Color(255, 255, 255));
        reclamations.setSelectionForeground(new java.awt.Color(1, 1, 1));
        reclamations.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        reclamations.setShowHorizontalLines(false);
        reclamations.setShowVerticalLines(false);
        jScrollPane1.setViewportView(reclamations);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reclamations;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (event.getSource() == reclamations.getSelectionModel() && event.getValueIsAdjusting()) {
            EmployeeTable model = (EmployeeTable) reclamations.getModel();
            String id = model.getValueAt(reclamations.getSelectedRow(), 0).toString();
            String owner = model.getValueAt(reclamations.getSelectedRow(), 1).toString();
            String objet = model.getValueAt(reclamations.getSelectedRow(), 2).toString();
            String description = model.getValueAt(reclamations.getSelectedRow(), 3).toString();
            String date = model.getValueAt(reclamations.getSelectedRow(), 5).toString();
            new Reclamation(id, owner, objet, description, date).setVisible(true);
        }
    }
}
