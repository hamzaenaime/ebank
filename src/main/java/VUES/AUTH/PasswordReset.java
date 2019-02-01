package VUES.AUTH;

import MODELS.Account;
import MODELS.Client;
import MODELS.Personne;
import MODELS.SendEmail;
import MODELS.SendSMS;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hamza
 */
public class PasswordReset extends javax.swing.JPanel {

    /**
     * Creates new form PasswordResetStep1
     */
    private final Client cl = new Client();
    private final Account am = new Account();

    public PasswordReset() {
        initComponents();
        telError.setForeground(new java.awt.Color(200, 0, 0));

    }

    private void sendAnSMS() {
        int code = (int) (Math.random() * 10000);
        State.setCheck(code);
        SendSMS sms = new SendSMS("+212" + tel.getText().substring(1, 10), "code de verification est : " + code);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        resend = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cin = new javax.swing.JTextField();
        tel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        checkcode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Valider = new javax.swing.JButton();
        resend1 = new javax.swing.JButton();
        resend2 = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        newPassword = new javax.swing.JPasswordField();
        confirmationNewPassword = new javax.swing.JPasswordField();
        telError = new javax.swing.JLabel();
        codeError = new javax.swing.JLabel();
        telError2 = new javax.swing.JLabel();

        jLabel4.setForeground(new java.awt.Color(96, 83, 150));
        jLabel4.setText("code de verification :");

        jTextField2.setForeground(new java.awt.Color(255, 255, 204));

        resend.setBackground(new java.awt.Color(255, 255, 255));
        resend.setForeground(new java.awt.Color(96, 83, 150));
        resend.setText("reenvoyer le code ");
        resend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resendMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 204));

        jLabel1.setText("CIN : ");

        jLabel2.setText("Téléphone : ");

        jLabel5.setText("code de verification :");

        jLabel6.setText("Confirmation :");

        jLabel7.setText("Nouveau Mot de Passe :");

        Valider.setBackground(new java.awt.Color(4, 96, 96));
        Valider.setForeground(new java.awt.Color(255, 255, 255));
        Valider.setText("Valider");
        Valider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Valider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ValiderMouseClicked(evt);
            }
        });

        resend1.setBackground(new java.awt.Color(255, 255, 255));
        resend1.setText("Envoyer moi un code");
        resend1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resend1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resend1MouseClicked(evt);
            }
        });

        resend2.setBackground(new java.awt.Color(255, 255, 255));
        resend2.setText("re");
        resend2.setContentAreaFilled(false);
        resend2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resend2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resend2MouseClicked(evt);
            }
        });

        error.setForeground(new java.awt.Color(222, 0, 0));

        newPassword.setForeground(new java.awt.Color(2, 2, 2));

        confirmationNewPassword.setForeground(new java.awt.Color(2, 2, 2));

        codeError.setForeground(new java.awt.Color(222, 0, 0));

        telError2.setForeground(new java.awt.Color(222, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cin)
                                    .addComponent(tel)
                                    .addComponent(checkcode, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(confirmationNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(resend1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resend2)
                                .addGap(50, 50, 50))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(telError2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(telError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codeError, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(Valider)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(telError, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telError2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resend1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resend2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkcode, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codeError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmationNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void resendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendMouseClicked
        // TODO add your handling code here:
        //sendAnSMS();
    }//GEN-LAST:event_resendMouseClicked

    private void sendMeCode() {
        if (cin.getText().length() != 0 && Personne.cinExist(cin.getText())) {
            if (tel.getText().length() == 10) {
                telError2.setText("");
                if (Personne.cinMatchTel(cin.getText(), tel.getText())) {
                    sendAnSMS();
                    telError.setText("");
                } else {
                    telError.setText("Numero de telephone est ne correspond pas à cette compte !!!");
                }
            } else {
                telError2.setText("n'est pas valide . longueur doit être égale à 10 chifres");
            }
        } else {
            telError.setText("cin n'est pas enregistrer dans aucun compte !!!");
        }
    }

    private void resend1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resend1MouseClicked
        // TODO add your handling code here:
        sendMeCode();
    }//GEN-LAST:event_resend1MouseClicked

    private void resend2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resend2MouseClicked
        // TODO add your handling code here:
        sendMeCode();
    }//GEN-LAST:event_resend2MouseClicked

    private void ValiderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ValiderMouseClicked
        // TODO add your handling code here:
        if (checkcode.getText().equals(State.getCheck() + "")) {
            codeError.setText("");
            if (newPassword.getText().equals(confirmationNewPassword.getText())) {
                if (newPassword.getText().matches("[0-9]+")) {
                    try {
                        error.setText("");
                        // Reset the password
                        Personne.passwordReset(cin.getText(), newPassword.getText());
                        //new SendEmail(Personne.getEmail(cin.getText()), "changement de mot de passe avec succès", "votre demande de changement de mot de passe a été approuvée avec succès\n"
                        //      + "votre nouveau mot de passe est: " + newPassword.getText());
                        javax.swing.JOptionPane.showMessageDialog(this, "Mot de passe Modifier !!!");

                        new SendEmail(Personne.getEmail(cin.getText()), "", Personne.getNomPrenom(cin.getText()), "", 4);
                    } catch (SQLException ex) {
                        Logger.getLogger(PasswordReset.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    error.setText("Mot de pass doit contient que des chifres !!!");
                }
            } else {
                error.setText("les mots de passes ne sont pas egaux !!");
            }
        } else {
            codeError.setText("Entrer le code verification de telephone !!!");
        }
    }//GEN-LAST:event_ValiderMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Valider;
    private javax.swing.JTextField checkcode;
    private javax.swing.JTextField cin;
    private javax.swing.JLabel codeError;
    private javax.swing.JPasswordField confirmationNewPassword;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPasswordField newPassword;
    private javax.swing.JButton resend;
    private javax.swing.JButton resend1;
    private javax.swing.JButton resend2;
    private javax.swing.JTextField tel;
    private javax.swing.JLabel telError;
    private javax.swing.JLabel telError2;
    // End of variables declaration//GEN-END:variables
}
