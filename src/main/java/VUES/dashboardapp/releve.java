/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUES.dashboardapp;

import MODELS.Client;
import MODELS.Operation;
import MODELS.ReleveBancaire;
import com.itextpdf.text.DocumentException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class releve extends javax.swing.JPanel {

    String path;
    JFileChooser chooser;
    Date From;
    Date To;
    String from;
    String to;
    private int periode;
    private ReleveBancaire relv;
    private Operation operations;
    /**
     * Creates new form releve
     */
    public releve() {
        initComponents();
        this.txtPath.setOpaque(true);
        this.txtPath.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){
                ImageIcon img = new ImageIcon("releve.png");
                Image i = img.getImage();

                g.drawImage(i, 0, 0, this.getSize().width,this.getSize().height,this);
            }

        };
        txtPath = new javax.swing.JTextField();
        pdf = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        excel = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(2, 2, 2));

        txtPath.setBackground(new java.awt.Color(4, 96, 96));
        txtPath.setForeground(new java.awt.Color(51, 51, 51));
        txtPath.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPath.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPathActionPerformed(evt);
            }
        });

        pdf.setBackground(new java.awt.Color(4, 96, 96));
        pdf.setForeground(new java.awt.Color(255, 255, 255));
        pdf.setText("Enregistrer sous");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });

        excel.setBackground(new java.awt.Color(4, 96, 96));
        excel.setForeground(new java.awt.Color(255, 255, 255));
        excel.setText("Enregistrer sous");
        excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(pdf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(excel)
                .addGap(95, 95, 95))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(466, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        txtPath.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPathActionPerformed

    }//GEN-LAST:event_txtPathActionPerformed

    private boolean interval_isValid(){
            To = jXDatePicker1.getDate();
            From = jXDatePicker2.getDate();

            if(To != null && From != null){
                DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                from = oDateFormat.format(From);
                to = oDateFormat.format(To);
            
                if (To.after(From) || To.equals(From)) {
                    periode = (int) ((To.getTime() - From.getTime()) / (1000 * 60 * 60 * 24));
                    return true;
                }
            }
            JOptionPane.showMessageDialog(this, "Veuillez choisir un intervalle de date valide", "Date invalide", JOptionPane.ERROR_MESSAGE);
            return false;
            
    }
    
    private void prepareFile(){
            if (!SaveAs()) return;

            if(!interval_isValid()) return;

            relv = new ReleveBancaire();
            
            LocalDate date = LocalDate.now();
            
            this.path = this.path +" relevé du "+ date.getDayOfMonth() + "_" + date.getMonth() + "_" + date.getYear() + "_" + Client.getNom() + "_" + Client.getPrenom();
            
            operations = new Operation();
    }
    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
        // TODO add your handling code here:

       try{
            prepareFile();
            relv.GeneratePDF(path, Client.getNom() + " " + Client.getPrenom(), Client.getCin(), operations, periode, from, to);
            JOptionPane.showMessageDialog(this,"Votre relevé en format PDF a été généré avec Succes","Succes", JOptionPane.INFORMATION_MESSAGE);            
       } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Échec lors de l'écriture dans la base de données. Veuillez réessayer plus tard", "Echec de l'opération", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            System.out.println("error "+ex.getMessage());
        } 
    }//GEN-LAST:event_pdfActionPerformed

    private void excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelActionPerformed
        // TODO add your handling code here:
        try{
            prepareFile();
            relv.GenerateExcel(path, Client.getNom() + " " + Client.getPrenom(), Client.getCin(), operations, periode, from, to);
            JOptionPane.showMessageDialog(this,"Votre relevé en format PDF a été généré avec Succes","Succes", JOptionPane.INFORMATION_MESSAGE);                
        } catch (SQLException  ex) {
            JOptionPane.showMessageDialog(this, "Échec lors de l'écriture dans la base de données. "
                + "Une erreur s'est produite lors de l'écriture dans notre base de données. Veuillez réessayer plus tard", "Echec de l'envoie", JOptionPane.ERROR_MESSAGE);
        } catch ( Exception ex) {
            System.out.println("error "+ex.getMessage());
        }
    }//GEN-LAST:event_excelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton excel;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JButton pdf;
    private javax.swing.JTextField txtPath;
    // End of variables declaration//GEN-END:variables

    //Methode for opening frame where we can get path os save as 
    public boolean SaveAs() {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(path);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            //System.out.println("getCurrentDirectory(): "+  chooser.getCurrentDirectory());
            //System.out.println("getSelectedFile() : "+  chooser.getSelectedFile());
            try{
                this.setPath(chooser.getSelectedFile().toString() + "/");
                this.txtPath.setText(path);
                return true;
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this,"Veuillez choisir un emplacement de fichier valide","Emplacement invalide", JOptionPane.ERROR_MESSAGE);
                    return false;  
                } 
        }else{
            JOptionPane.showMessageDialog(this,"Veuillez choisir un emplacement de fichier valide","Emplacement invalide", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
