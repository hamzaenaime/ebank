/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUES.DashBaordEmployer;

import MODELS.Employe;
import MODELS.Table.EmployeeTable;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author hamza
 */
public class Demandes extends javax.swing.JPanel implements ListSelectionListener {

    /**
     * Creates new form Demandes
     */
    public Demandes() {
        initComponents();
        afficher();
        ListSelectionModel selectionModel = demandes.getSelectionModel();
        selectionModel.addListSelectionListener(this);

    }

    public void afficher() {
        ResultSet res;
        res = Employe.getDemandes();
        demandes.removeAll();
        EmployeeTable employeModel = new EmployeeTable(res);
        demandes.setModel(employeModel);

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
        demandes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(1, 1, 1));

        demandes.setBackground(new java.awt.Color(255, 255, 255));
        demandes.setForeground(new java.awt.Color(1, 1, 1));
        demandes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        demandes.setGridColor(new java.awt.Color(255, 255, 255));
        demandes.setInheritsPopupMenu(true);
        demandes.setRowHeight(32);
        demandes.setRowMargin(4);
        demandes.setSelectionBackground(new java.awt.Color(255, 255, 255));
        demandes.setSelectionForeground(new java.awt.Color(1, 1, 1));
        demandes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        demandes.setShowHorizontalLines(false);
        demandes.setShowVerticalLines(false);
        demandes.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(demandes);

        jButton1.setBackground(new java.awt.Color(14, 110, 193));
        jButton1.setForeground(new java.awt.Color(2, 2, 2));
        jButton1.setText("Actualiser");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        afficher();
    }//GEN-LAST:event_jButton1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable demandes;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (event.getSource() == demandes.getSelectionModel() && event.getValueIsAdjusting()) {
            try {
                EmployeeTable model = (EmployeeTable) demandes.getModel();
                String numcompte = model.getValueAt(demandes.getSelectedRow(), 0).toString();
                String cin = model.getValueAt(demandes.getSelectedRow(), 1).toString();
                String nom = model.getValueAt(demandes.getSelectedRow(), 2).toString();
                String prenom = model.getValueAt(demandes.getSelectedRow(), 3).toString();
                String date_nais = model.getValueAt(demandes.getSelectedRow(), 4).toString();
                String address = model.getValueAt(demandes.getSelectedRow(), 5).toString();
                String ville = model.getValueAt(demandes.getSelectedRow(), 6).toString();
                String tel = model.getValueAt(demandes.getSelectedRow(), 7).toString();
                String email = model.getValueAt(demandes.getSelectedRow(), 8).toString();
                String date_creation = model.getValueAt(demandes.getSelectedRow(), 9).toString();
                new DemandeInfos(numcompte, cin, nom, prenom, email, tel, ville, address, date_nais, date_creation).setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Demandes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Demandes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
