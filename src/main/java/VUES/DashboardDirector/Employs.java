/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUES.DashboardDirector;

import MODELS.Director;
import MODELS.Table.EmployeeTable;
import java.sql.ResultSet;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author hamza
 */
public class Employs extends javax.swing.JPanel implements ListSelectionListener {

    /**
     * Creates new form Employees
     */
    public Employs() {
        initComponents();
        afficher();
        ListSelectionModel selectionModel = employees.getSelectionModel();
        selectionModel.addListSelectionListener(this);
    }

    public void afficher() {
        ResultSet res;
        res = Director.getEmployees();
        EmployeeTable employeModel = new EmployeeTable(res);
        employees.setModel(employeModel);

    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (event.getSource() == employees.getSelectionModel() && event.getValueIsAdjusting()) {
            EmployeeTable model = (EmployeeTable) employees.getModel();
            String id = model.getValueAt(employees.getSelectedRow(), 0).toString();
            String owner = model.getValueAt(employees.getSelectedRow(), 1).toString();
            String objet = model.getValueAt(employees.getSelectedRow(), 2).toString();
            String description = model.getValueAt(employees.getSelectedRow(), 3).toString();
            String date = model.getValueAt(employees.getSelectedRow(), 5).toString();
            new VUES.DashboardDirector.ReclamationInfos(id, owner, objet, description, date).setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        employees = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(2, 2, 2));

        employees.setBackground(new java.awt.Color(255, 255, 255));
        employees.setForeground(new java.awt.Color(2, 2, 2));
        employees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        employees.setRowHeight(32);
        employees.setSelectionBackground(new java.awt.Color(255, 255, 255));
        employees.setSelectionForeground(new java.awt.Color(2, 2, 2));
        employees.setShowHorizontalLines(false);
        employees.setShowVerticalLines(false);
        jScrollPane1.setViewportView(employees);

        jButton2.setBackground(new java.awt.Color(4, 96, 96));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Nouveau Employe");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton2MouseClicked
        // ajouter employee
        new NewEmployee().setVisible(true);
    }// GEN-LAST:event_jButton2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable employees;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
