/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUES.DashBaordEmployer;

import DAO.Dao;
import MODELS.Employe;
import MODELS.Personne;
import VUES.AUTH.Login;
import VUES.DashBaordEmployer.Virement.Virement;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author KeepToo
 */
public class Accueil extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private Demandes demandes = new Demandes();
    private Reclamations reclamations = new Reclamations();
    private ChangePassword changePassword = new ChangePassword();
    private Coordonne coordonne = new Coordonne();
    private Virement virement = new Virement();

    public Accueil() {
        new Dao();
        if (Personne.isLogin()) {
            initComponents();
            container.setLayout(new FlowLayout());
            container.add(demandes);
            name.setText(Personne.getTitle() + " " + Employe.getPrenom() + " " + Employe.getNom());
            last_login.setText(Employe.getLast_login());
            // jLabel6.setVisible(false);
        } else {
            new Login().setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Button1 = new javax.swing.JPanel();
        Indicator1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Button3 = new javax.swing.JPanel();
        Indicator3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Button4 = new javax.swing.JPanel();
        Indicator4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Button5 = new javax.swing.JPanel();
        Indicator5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Button6 = new javax.swing.JPanel();
        Indicator6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btn_close = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        last_login = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(4, 96, 96));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Button1.setBackground(new java.awt.Color(0, 18, 18));
        Button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button1MouseClicked(evt);
            }
        });

        Indicator1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Indicator1Layout = new javax.swing.GroupLayout(Indicator1);
        Indicator1.setLayout(Indicator1Layout);
        Indicator1Layout.setHorizontalGroup(
            Indicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );
        Indicator1Layout.setVerticalGroup(
            Indicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Confirmer un Compte");

        javax.swing.GroupLayout Button1Layout = new javax.swing.GroupLayout(Button1);
        Button1.setLayout(Button1Layout);
        Button1Layout.setHorizontalGroup(
            Button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button1Layout.createSequentialGroup()
                .addComponent(Indicator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 78, Short.MAX_VALUE))
        );
        Button1Layout.setVerticalGroup(
            Button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Indicator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Button1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 232, 50));

        Button3.setBackground(new java.awt.Color(15, 122, 122));
        Button3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button3MouseClicked(evt);
            }
        });

        Indicator3.setBackground(new java.awt.Color(255, 255, 255));
        Indicator3.setOpaque(false);

        javax.swing.GroupLayout Indicator3Layout = new javax.swing.GroupLayout(Indicator3);
        Indicator3.setLayout(Indicator3Layout);
        Indicator3Layout.setHorizontalGroup(
            Indicator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        Indicator3Layout.setVerticalGroup(
            Indicator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Coordonnees Personnelles");

        javax.swing.GroupLayout Button3Layout = new javax.swing.GroupLayout(Button3);
        Button3.setLayout(Button3Layout);
        Button3Layout.setHorizontalGroup(
            Button3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button3Layout.createSequentialGroup()
                .addComponent(Indicator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Button3Layout.setVerticalGroup(
            Button3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Indicator3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(Button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 232, 50));

        Button4.setBackground(new java.awt.Color(15, 122, 122));
        Button4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button4MouseClicked(evt);
            }
        });

        Indicator4.setBackground(new java.awt.Color(255, 255, 255));
        Indicator4.setOpaque(false);

        javax.swing.GroupLayout Indicator4Layout = new javax.swing.GroupLayout(Indicator4);
        Indicator4.setLayout(Indicator4Layout);
        Indicator4Layout.setHorizontalGroup(
            Indicator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        Indicator4Layout.setVerticalGroup(
            Indicator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Changement Mot de Passe");

        javax.swing.GroupLayout Button4Layout = new javax.swing.GroupLayout(Button4);
        Button4.setLayout(Button4Layout);
        Button4Layout.setHorizontalGroup(
            Button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button4Layout.createSequentialGroup()
                .addComponent(Indicator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        Button4Layout.setVerticalGroup(
            Button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Indicator4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Button4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(Button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 232, 50));
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 39, -1, -1));

        jPanel14.setBackground(new java.awt.Color(0, 89, 102));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));

        jPanel13.setBackground(new java.awt.Color(1, 39, 39));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" E-Bank");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 150, 37));

        Button5.setBackground(new java.awt.Color(15, 122, 122));
        Button5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button5MouseClicked(evt);
            }
        });

        Indicator5.setBackground(new java.awt.Color(255, 255, 255));
        Indicator5.setOpaque(false);

        javax.swing.GroupLayout Indicator5Layout = new javax.swing.GroupLayout(Indicator5);
        Indicator5.setLayout(Indicator5Layout);
        Indicator5Layout.setHorizontalGroup(
            Indicator5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );
        Indicator5Layout.setVerticalGroup(
            Indicator5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Réclamations");

        javax.swing.GroupLayout Button5Layout = new javax.swing.GroupLayout(Button5);
        Button5.setLayout(Button5Layout);
        Button5Layout.setHorizontalGroup(
            Button5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button5Layout.createSequentialGroup()
                .addComponent(Indicator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(0, 129, Short.MAX_VALUE))
        );
        Button5Layout.setVerticalGroup(
            Button5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Indicator5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Button5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(Button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 232, 50));

        Button6.setBackground(new java.awt.Color(15, 122, 122));
        Button6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Button6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button6MouseClicked(evt);
            }
        });

        Indicator6.setBackground(new java.awt.Color(255, 255, 255));
        Indicator6.setOpaque(false);

        javax.swing.GroupLayout Indicator6Layout = new javax.swing.GroupLayout(Indicator6);
        Indicator6.setLayout(Indicator6Layout);
        Indicator6Layout.setHorizontalGroup(
            Indicator6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );
        Indicator6Layout.setVerticalGroup(
            Indicator6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Effectuer un Virement ");

        javax.swing.GroupLayout Button6Layout = new javax.swing.GroupLayout(Button6);
        Button6.setLayout(Button6Layout);
        Button6Layout.setHorizontalGroup(
            Button6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button6Layout.createSequentialGroup()
                .addComponent(Indicator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(0, 74, Short.MAX_VALUE))
        );
        Button6Layout.setVerticalGroup(
            Button6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Indicator6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Button6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(Button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 232, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 580));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setForeground(new java.awt.Color(255, 255, 204));

        jPanel8.setBackground(new java.awt.Color(8, 30, 30));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btn_close.setBackground(new java.awt.Color(96, 83, 150));
        btn_close.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("X");
        btn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Dernière connexion :");

        last_login.setForeground(new java.awt.Color(255, 255, 255));
        last_login.setText("jLabel12");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(78, 78, 78)
                .addComponent(last_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(339, 339, 339)
                .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(last_login)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(4, 96, 96));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 10));

        name.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name.setForeground(new java.awt.Color(8, 30, 30));
        name.setText("M.XXXX YYYYYY");
        jPanel4.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel3.setBackground(new java.awt.Color(253, 222, 249));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(4, 96, 96));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Abyssinica SIL", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Logout");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel9)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel6.setToolTipText("");

        jLabel10.setText("You are login as employer");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel6))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addGap(170, 170, 170)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel6)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel10))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 160));

        container.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 830, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        Personne.logout();
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void Button6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button6MouseClicked
        // TODO add your handling code here:
        onClick(Button6);
        onLeaveClick(Button3);
        onLeaveClick(Button4);
        onLeaveClick(Button5);
        onLeaveClick(Button1);

        // indicators
        Indicator6.setOpaque(true);
        Indicator3.setOpaque(false);
        Indicator4.setOpaque(false);
        Indicator5.setOpaque(false);
        Indicator1.setOpaque(false);

        show("virement");
    }//GEN-LAST:event_Button6MouseClicked

    private void Button1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_Button1MouseClicked
        // TODO add your handling code here:
        onClick(Button1);
        onLeaveClick(Button3);
        onLeaveClick(Button4);
        onLeaveClick(Button5);
        onLeaveClick(Button6);

        // indicators
        Indicator1.setOpaque(true);
        Indicator3.setOpaque(false);
        Indicator4.setOpaque(false);
        Indicator5.setOpaque(false);
        Indicator6.setOpaque(false);

        show("demandes");

    }// GEN-LAST:event_Button1MouseClicked

    private void Button3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_Button3MouseClicked
        // TODO add your handling code here:
        onClick(Button3);
        onLeaveClick(Button1);
        onLeaveClick(Button4);
        onLeaveClick(Button5);
        onLeaveClick(Button6);

        // indicators
        Indicator1.setOpaque(false);
        Indicator3.setOpaque(true);
        Indicator4.setOpaque(false);
        Indicator5.setOpaque(false);
        Indicator6.setOpaque(false);

        show("coordonne");
    }// GEN-LAST:event_Button3MouseClicked

    private void Button4MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_Button4MouseClicked
        // TODO add your handling code here:
        onClick(Button4);
        onLeaveClick(Button3);
        onLeaveClick(Button1);
        onLeaveClick(Button5);
        onLeaveClick(Button6);
        // indicators
        Indicator1.setOpaque(false);
        Indicator3.setOpaque(false);
        Indicator5.setOpaque(false);
        Indicator6.setOpaque(false);
        Indicator4.setOpaque(true);

        show("changePassword");
    }// GEN-LAST:event_Button4MouseClicked

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }// GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }// GEN-LAST:event_jPanel2MouseDragged

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
        jPanel5.setBackground(new Color(205, 136, 205));
        // jLabel6.setVisible(true);
    }// GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel3MouseExited
        // TODO add your handling code here:
        jPanel5.setBackground(new Color(253, 222, 249));
        // jLabel6.setVisible(false);
    }// GEN-LAST:event_jPanel3MouseExited

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
    }// GEN-LAST:event_jPanel3MouseClicked

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn_closeMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }// GEN-LAST:event_btn_closeMouseClicked

    private void Button5MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_Button5MouseClicked
        // TODO add your handling code here:
        onClick(Button5);
        onLeaveClick(Button4);
        onLeaveClick(Button3);
        onLeaveClick(Button1);
        onLeaveClick(Button6);

        // indicators
        Indicator1.setOpaque(false);
        Indicator3.setOpaque(false);
        Indicator4.setOpaque(false);
        Indicator6.setOpaque(false);
        Indicator5.setOpaque(true);

        show("reclamations");
    }// GEN-LAST:event_Button5MouseClicked

    int xx, xy;

    // bad idea
    private void onClick(JPanel panel) {
        panel.setBackground(new Color(0, 18, 18));

    }

    private void onLeaveClick(JPanel panel) {
        panel.setBackground(new Color(15, 122, 122));
    }

    private void show(String nom) {

        container.removeAll();
        javax.swing.JPanel panelToShow = new javax.swing.JPanel();

        if (nom.equals("demandes")) {
            panelToShow = new Demandes();
        }

        if (nom.equals("coordonne")) {
            panelToShow = coordonne;
        }

        if (nom.equals("changePassword")) {
            panelToShow = changePassword;
        }

        if (nom.equals("reclamations")) {
            panelToShow = new Reclamations();
        }
        if (nom.equals("virement")) {
            panelToShow = virement;
        }
        this.container.removeAll();
        this.container.add(panelToShow);
        this.container.revalidate();
        this.container.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Button1;
    private javax.swing.JPanel Button3;
    private javax.swing.JPanel Button4;
    private javax.swing.JPanel Button5;
    private javax.swing.JPanel Button6;
    private javax.swing.JPanel Indicator1;
    private javax.swing.JPanel Indicator3;
    private javax.swing.JPanel Indicator4;
    private javax.swing.JPanel Indicator5;
    private javax.swing.JPanel Indicator6;
    private javax.swing.JLabel btn_close;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel last_login;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables

}
