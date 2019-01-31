/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUES.AUTH.Registre;

import MODELS.Account;
import MODELS.Client;
import MODELS.Img;
import MODELS.MailBoxLayer;
import MODELS.SendEmail;
import VUES.AUTH.State;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author hamza
 */
public class RegistreStep3 extends javax.swing.JPanel {

    Account am = new Account();

    /**
     * Creates new form RegistreStep3
     */
    public RegistreStep3() {
        initComponents();
        setFields();
    }

    private void setFields() {
        email.setText(Client.getEmail());
        ville.setText(Client.getVille());
        address.setText(Client.getAdresse());
    }

    private String getDate() {
        if (datePicker.getDate() != null) {
            return (datePicker.getDate().getYear() + 1900) + "-" + (datePicker.getDate().getMonth() + 1) + "-" + datePicker.getDate().getDate();
        }
        return "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ville = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        create = new javax.swing.JButton();
        email = new javax.swing.JTextField();
        datePicker = new org.jdesktop.swingx.JXDatePicker();
        password = new javax.swing.JPasswordField();
        Conirmation = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        cinError = new javax.swing.JLabel();
        emailError = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        c1Path = new javax.swing.JTextField();
        c1 = new javax.swing.JButton();
        c2Path = new javax.swing.JTextField();
        c2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Email :");

        jLabel2.setText("Ville :");

        jLabel3.setText("Adresse : ");

        jLabel4.setText("Date de naissance :");

        create.setBackground(new java.awt.Color(4, 96, 96));
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setText("Créer");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        jLabel9.setText("Mot de passe :");

        jLabel10.setText("Confirmer le mot de passe:");

        error.setForeground(new java.awt.Color(222, 0, 0));

        cinError.setForeground(new java.awt.Color(222, 0, 0));

        emailError.setForeground(new java.awt.Color(222, 0, 0));

        jLabel5.setText("CIN 1:");

        jLabel7.setText("CIN 2:");

        c1.setBackground(new java.awt.Color(15, 122, 122));
        c1.setForeground(new java.awt.Color(255, 255, 255));
        c1.setText("choisir");
        c1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c1MouseClicked(evt);
            }
        });

        c2.setBackground(new java.awt.Color(15, 122, 122));
        c2.setForeground(new java.awt.Color(255, 255, 255));
        c2.setText("choisir");
        c2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password)
                    .addComponent(ville)
                    .addComponent(address)
                    .addComponent(datePicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(Conirmation)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(c2Path, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(c1Path, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c1)
                            .addComponent(c2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailError)
                    .addComponent(cinError)
                    .addComponent(error))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(cinError)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(emailError)
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Conirmation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(c1Path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c1))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(c2Path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c2))
                .addGap(16, 16, 16)
                .addComponent(error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(create)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void topFrameDispose() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.dispose();
    }
    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed

        String d = getDate();
        String email_ = email.getText();
        String ville_ = ville.getText();
        String address_ = address.getText();

        if (!email_.isEmpty() && !ville_.isEmpty() && !address_.isEmpty()) {

            Client.setVille(ville_);
            Client.setAdresse(address_);
            Client.setDate_naissance(d);
            //verification cin disponibilité
            cinError.setText("");
            //verification si l'email est valide réelement
            if (MailBoxLayer.checkSMTP(email_)) {
                emailError.setText("");
                Client.setEmail(email_);
                //verification que les mots de passes entrer sont egaux
                if (password.getText().equals(Conirmation.getText())) {
                    //verification si le mot de passe entrer contient que les chifres
                    if (password.getText().matches("[0-9]+")) {
                        Client.setPassword(password.getText());
                        long numAccount = Account.createAccount();
                        if (numAccount == -1) {
                            JOptionPane.showInputDialog("Error, lors de création du compte");
                        } else  Client.createClient((int) numAccount);
                        
                        try {
                            Img.store(c1Path.getText(), Client.getCin());
                            Img.store(c2Path.getText(), Client.getCin());
                        } catch (SQLException | IOException ex) {
                            Logger.getLogger(RegistreStep3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(this, "Votre compte a été crée avec success", "Success", JOptionPane.INFORMATION_MESSAGE);
                        topFrameDispose();
                        new SendEmail(Client.getCin(), "Creation d'un compte", "votre demande de Creer un compte e été envoyer avec succès\n"
                                + " nous allons vous contacter le plutot possible");
                    } else {
                        error.setText("Mot de pass doit contient que des chifres !!!");
                    }
                } else {
                    error.setText("Your password and confirmation password do not match");
                }
            } else { // si l'email n'est pas valide
                emailError.setText("email n'existe pas,entrer un email valide");
            }
        }
    }//GEN-LAST:event_createActionPerformed

    public String getPath() {
        JFileChooser chooser = new JFileChooser();
        //chooser.setCurrentDirectory(new java.io.File("."));
        //Setting Up The Filter
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        //Attaching Filter to JFileChooser object
        chooser.setFileFilter(imageFilter);
        chooser.setDialogTitle("Choisir CIN");

        //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            //System.out.println("getCurrentDirectory(): "+  chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
            return chooser.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }
    private void c1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseClicked
        // TODO add your handling code here:
        String path = getPath();
        try {
            c1Path.setText(path);
        } catch (Exception ex) {
            c1Path.setText("");
        }
    }//GEN-LAST:event_c1MouseClicked

    private void c2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c2MouseClicked
        // TODO add your handling code here:
        String path = getPath();
        try {
            c2Path.setText(path);
        } catch (Exception ex) {
            c2Path.setText("");
        }
    }//GEN-LAST:event_c2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Conirmation;
    private javax.swing.JTextField address;
    private javax.swing.JButton c1;
    private javax.swing.JTextField c1Path;
    private javax.swing.JButton c2;
    private javax.swing.JTextField c2Path;
    private javax.swing.JLabel cinError;
    private javax.swing.JButton create;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailError;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField ville;
    // End of variables declaration//GEN-END:variables
}
