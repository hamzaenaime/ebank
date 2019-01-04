/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUES.AUTH.Registre;

import MODELS.AccountManagement;
import VUES.State;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author hamza
 */
public class RegistreStep3 extends javax.swing.JPanel {

    AccountManagement am = new AccountManagement();

    /**
     * Creates new form RegistreStep3
     */
    public RegistreStep3() {
        initComponents();
        setFields();
        setComobox();
    }

    private void setComobox() {
        for (int i = 1950; i < 2018; i++) {
            year.addItem(Integer.toString(i));
        }
        for (int i = 1; i < 32; i++) {
            day.addItem(Integer.toString(i));
        }
    }

    private void setFields() {
        cin.setText(State.getCin());
        email.setText(State.getEmail());
        ville.setText(State.getVille());
        address.setText(State.getAdresse());
        profession.setText(State.getProfession());
    }

    private void getInfos() {
        int d = Integer.parseInt(day.getSelectedItem().toString());
        String m = month.getSelectedItem().toString();
        int y = Integer.parseInt(year.getSelectedItem().toString());
        State.setCin(cin.getText());
        State.setEmail(email.getText());
        State.setVille(ville.getText());
        State.setAdresse(address.getText());
        State.setDate_naissance(new Date(y - 1900, DaytoNum(m) - 1, d));
        State.setProfession(profession.getText());
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
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        profession = new javax.swing.JTextField();
        day = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox<>();
        year = new javax.swing.JComboBox<>();
        cin = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        email = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        ville.setBackground(new java.awt.Color(255, 255, 255));

        address.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(96, 83, 150));
        jLabel1.setText("Email :");

        jLabel2.setForeground(new java.awt.Color(96, 83, 150));
        jLabel2.setText("Ville :");

        jLabel3.setForeground(new java.awt.Color(96, 83, 150));
        jLabel3.setText("Adresse : ");

        jLabel8.setForeground(new java.awt.Color(96, 83, 150));
        jLabel8.setText("Profession : ");

        jLabel4.setForeground(new java.awt.Color(96, 83, 150));
        jLabel4.setText("Date de naissance :");

        profession.setBackground(new java.awt.Color(255, 255, 255));

        day.setBackground(new java.awt.Color(255, 255, 255));
        day.setForeground(new java.awt.Color(96, 83, 150));

        jLabel6.setForeground(new java.awt.Color(96, 83, 150));
        jLabel6.setText("CIN : ");

        month.setBackground(new java.awt.Color(255, 255, 255));
        month.setForeground(new java.awt.Color(96, 83, 150));
        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "décembre" }));

        year.setBackground(new java.awt.Color(255, 255, 255));
        year.setForeground(new java.awt.Color(96, 83, 150));

        cin.setBackground(new java.awt.Color(255, 255, 255));
        cin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cinActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(96, 83, 150));
        jButton1.setText("Créer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        email.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cin)
                            .addComponent(email)
                            .addComponent(ville)
                            .addComponent(address)
                            .addComponent(profession))
                        .addGap(167, 167, 167))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(profession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jButton1)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cinActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (cin.getText().length() != 0 && email.getText().length() != 0 && ville.getText().length() != 0 && address.getText().length() != 0 && profession.getText().length() != 0) {
            int d = Integer.parseInt(day.getSelectedItem().toString());
            String m = month.getSelectedItem().toString();
            int y = Integer.parseInt(year.getSelectedItem().toString());

            State.setCin(cin.getText());
            State.setEmail(email.getText());
            State.setVille(ville.getText());
            State.setAdresse(address.getText());
            State.setDate_naissance(new Date(y - 1900, DaytoNum(m) - 1, d));
            State.setProfession(profession.getText());
            if (am.cinExist(cin.getText())) {
                JOptionPane.showMessageDialog(this, "Cin deja existe  !!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int code = (int) (Math.random() * 10000);
                State.setPassword("" + code);
                am.createAccount(State.getCin(), State.getNom(), State.getPrenom(), State.getDate_naissance(), State.getAdresse(), State.getVille(), State.getTel(), State.getEmail(), State.getPassword(), State.getProfession());
                JOptionPane.showMessageDialog(this, "compte creeer !!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "verifier que vous avez remplir tous les champs correctement!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public int DaytoNum(String day) {
        if (day == "janvier") {
            return 1;
        } else if (day == "février") {
            return 2;
        } else if (day == "mars") {
            return 3;
        } else if (day == "avril") {
            return 4;
        } else if (day == "mai") {
            return 5;
        } else if (day == "juin") {
            return 6;
        } else if (day == "juillet") {
            return 7;
        } else if (day == "août") {
            return 8;
        } else if (day == "septembre") {
            return 9;
        } else if (day == "octobre") {
            return 10;
        } else if (day == "novembre") {
            return 11;
        } else if (day == "décembre") {
            return 12;
        } else {
            System.err.println("something wrong with the month's comobox");
        }
        return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField cin;
    private javax.swing.JComboBox<String> day;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JTextField profession;
    private javax.swing.JTextField ville;
    private javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables
}
