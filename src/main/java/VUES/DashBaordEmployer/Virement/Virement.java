/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUES.DashBaordEmployer.Virement;

import MODELS.Account;
import MODELS.EmployeeOperation;
import MODELS.Personne;
import javax.swing.JOptionPane;

/**
 *
 * @author hamza
 */
public class Virement extends javax.swing.JPanel {

    /**
     * Creates new form Virement
     */
    public Virement() {
        initComponents();
        err1.setText("");
        err2.setText("");
        err3.setText("");
        err4.setText("");
        err5.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        valider = new javax.swing.JButton();
        cin = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        numcompte = new javax.swing.JTextField();
        montant = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        err1 = new javax.swing.JLabel();
        err2 = new javax.swing.JLabel();
        err3 = new javax.swing.JLabel();
        err4 = new javax.swing.JLabel();
        err5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(2, 2, 2));

        jLabel1.setForeground(new java.awt.Color(2, 2, 2));
        jLabel1.setText("CIN :");

        jLabel2.setForeground(new java.awt.Color(2, 2, 2));
        jLabel2.setText("Nom :");

        jLabel3.setForeground(new java.awt.Color(2, 2, 2));
        jLabel3.setText("Prenom :");

        jLabel5.setForeground(new java.awt.Color(2, 2, 2));
        jLabel5.setText("Numero de compte :");

        jLabel6.setForeground(new java.awt.Color(2, 2, 2));
        jLabel6.setText("Montant :");

        valider.setBackground(new java.awt.Color(255, 255, 255));
        valider.setForeground(new java.awt.Color(2, 2, 2));
        valider.setText("Valider");
        valider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                validerMouseClicked(evt);
            }
        });

        cin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cinFocusLost(evt);
            }
        });

        prenom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prenomFocusLost(evt);
            }
        });

        numcompte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numcompteFocusLost(evt);
            }
        });
        numcompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numcompteActionPerformed(evt);
            }
        });

        montant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                montantFocusLost(evt);
            }
        });

        nom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomFocusLost(evt);
            }
        });

        err1.setForeground(new java.awt.Color(222, 2, 2));

        err2.setForeground(new java.awt.Color(222, 2, 2));

        err3.setForeground(new java.awt.Color(222, 2, 2));

        err4.setForeground(new java.awt.Color(222, 2, 2));

        err5.setForeground(new java.awt.Color(222, 2, 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(err1)
                            .addComponent(err2)
                            .addComponent(err3)
                            .addComponent(err5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numcompte, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(291, 291, 291))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(err4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jSeparator1)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(463, Short.MAX_VALUE)
                .addComponent(valider)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nom)
                    .addComponent(cin)
                    .addComponent(prenom))
                .addGap(292, 292, 292))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(numcompte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(err1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(err2)
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14)
                        .addComponent(err3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(valider))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(err4)
                                .addGap(45, 45, 45)
                                .addComponent(err5)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 61, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private Boolean allFieldsSet() {
        if (    !numcompte.getText().isEmpty() 
                && Account.AccountActive(numcompte.getText())
                && !montant.getText().isEmpty()
                && Integer.parseInt(montant.getText()) >= 0
                && cin.getText().length() != 0
                && nom.getText().length() != 0
                && prenom.getText().length() != 0) {
            return true;
        }
        return false;
    }

    private void validerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_validerMouseClicked
        // TODO add your handling code here:
        if (allFieldsSet()) {
            String message = "Numero de Compte : " + numcompte.getText();
            message += "\ntitulaire de compte  : " + EmployeeOperation.getTitulaire(numcompte.getText());
            message += "\nMontant : " + montant.getText();
            message += "\n\n\n Confirmer ?\n";
            int input = JOptionPane.showConfirmDialog(this, message, "Virement Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            //0 ok , 2 cancel
            if (input == 0) {
                //ajouter operation
                EmployeeOperation.createEmployerOperation(
                        Integer.parseInt(numcompte.getText()),
                        "virement",
                        Personne.getCin(),
                        cin.getText(),
                        nom.getText(),
                        prenom.getText(),
                        Float.parseFloat(montant.getText()));
                JOptionPane.showMessageDialog(this, "virement effectuer");
            } else {
                //nothing
                JOptionPane.showMessageDialog(this, "Transaction Annuler");
            }
        } else {
            JOptionPane.showMessageDialog(this, "verifier que vous entrer tous les informations correctement ");
        }
    }//GEN-LAST:event_validerMouseClicked

    private void numcompteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numcompteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numcompteActionPerformed

    private void numcompteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numcompteFocusLost
        // TODO add your handling code here:
        if (numcompte.getText().isEmpty()){
        err1.setText("* Champ obligatoire !");
        }
        else{
            System.err.println("hh");
                if (!Account.AccountActive(numcompte.getText())) {
                        err1.setText("numero de compte invalide!");
                }  else {
                        err1.setText("");
                }
        }
        

    }//GEN-LAST:event_numcompteFocusLost

    private void montantFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_montantFocusLost
        // TODO add your handling code here:
        if (montant.getText().isEmpty()){
            err2.setText("* Champ obligatoire !");
        }
        else {
            if (Integer.parseInt(montant.getText()) < 0) {
            err2.setText("montant doit etre positive non nul !");
            } else {
            err2.setText("");
            }
        }
        
    }//GEN-LAST:event_montantFocusLost

    private void cinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cinFocusLost
        // TODO add your handling code here:
        if (cin.getText().length() == 0) {
            err3.setText("* Champs Obligatoire!");
        } else {
            err3.setText("");
        }
    }//GEN-LAST:event_cinFocusLost

    private void nomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomFocusLost
        // TODO add your handling code here:
        if (nom.getText().length() == 0) {
            err4.setText("* Champs Obligatoire!");
        } else {
            err4.setText("");
        }
    }//GEN-LAST:event_nomFocusLost

    private void prenomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prenomFocusLost
        // TODO add your handling code here:
        if (prenom.getText().length() == 0) {
            err5.setText("* Champs Obligatoire!");
        } else {
            err5.setText("");
        }
    }//GEN-LAST:event_prenomFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cin;
    private javax.swing.JLabel err1;
    private javax.swing.JLabel err2;
    private javax.swing.JLabel err3;
    private javax.swing.JLabel err4;
    private javax.swing.JLabel err5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField montant;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField numcompte;
    private javax.swing.JTextField prenom;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
