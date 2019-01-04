/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUES.AUTHENTIFICATION;

import VUES.AUTHENTIFICATION.Registre.RegistreStep1;
import VUES.AUTHENTIFICATION.Registre.RegistreStep2;
import VUES.AUTHENTIFICATION.Registre.RegistreStep3;
import VUES.dashboardapp.*;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author hamza
 */
public class Login extends javax.swing.JFrame {

    RegistreStep1 registreStep1 = new RegistreStep1();
    RegistreStep2 registreStep2 = new RegistreStep2();
    RegistreStep3 registreStep3 = new RegistreStep3();
    int xx, xy;

    /**
     * Creates new form Home
     */
    public Login() {
        initComponents();
        container.setLayout(new FlowLayout());
        tostep3.disable();
        step3.disable();
        step2.disable();
        hideSteps();
        container.add(new Connecter());

    }

    private void hideSteps() {
        step1.hide();
        step2.hide();
        step3.hide();
        tostep2.hide();
        tostep3.hide();
    }

    private void showSteps() {
        step1.show();
        step2.show();
        step3.show();
        tostep2.show();
        tostep3.show();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Button2 = new javax.swing.JPanel();
        Indicator2 = new javax.swing.JPanel();
        passwordReset = new javax.swing.JLabel();
        connect = new javax.swing.JPanel();
        Indicator1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Button3 = new javax.swing.JPanel();
        Indicator3 = new javax.swing.JPanel();
        registre = new javax.swing.JLabel();
        Button4 = new javax.swing.JPanel();
        Indicator4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btn_close = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        step1 = new javax.swing.JLabel();
        step2 = new javax.swing.JLabel();
        step3 = new javax.swing.JLabel();
        tostep3 = new javax.swing.JLabel();
        tostep2 = new javax.swing.JLabel();
        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(252, 230, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Button2.setBackground(new java.awt.Color(252, 230, 252));
        Button2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button2MouseClicked(evt);
            }
        });

        Indicator2.setBackground(new java.awt.Color(204, 0, 204));
        Indicator2.setOpaque(false);

        javax.swing.GroupLayout Indicator2Layout = new javax.swing.GroupLayout(Indicator2);
        Indicator2.setLayout(Indicator2Layout);
        Indicator2Layout.setHorizontalGroup(
            Indicator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        Indicator2Layout.setVerticalGroup(
            Indicator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        passwordReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passwordReset.setForeground(new java.awt.Color(96, 83, 150));
        passwordReset.setText("Mot de passe oublier ?");

        javax.swing.GroupLayout Button2Layout = new javax.swing.GroupLayout(Button2);
        Button2.setLayout(Button2Layout);
        Button2Layout.setHorizontalGroup(
            Button2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button2Layout.createSequentialGroup()
                .addComponent(Indicator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordReset)
                .addGap(0, 83, Short.MAX_VALUE))
        );
        Button2Layout.setVerticalGroup(
            Button2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Indicator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Button2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(passwordReset, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(Button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 227, 232, 50));

        connect.setBackground(new java.awt.Color(205, 136, 205));
        connect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        connect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                connectMouseClicked(evt);
            }
        });

        Indicator1.setBackground(new java.awt.Color(204, 0, 204));

        javax.swing.GroupLayout Indicator1Layout = new javax.swing.GroupLayout(Indicator1);
        Indicator1.setLayout(Indicator1Layout);
        Indicator1Layout.setHorizontalGroup(
            Indicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        Indicator1Layout.setVerticalGroup(
            Indicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(96, 83, 150));
        jLabel1.setText("Se connecter");

        javax.swing.GroupLayout connectLayout = new javax.swing.GroupLayout(connect);
        connect.setLayout(connectLayout);
        connectLayout.setHorizontalGroup(
            connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectLayout.createSequentialGroup()
                .addComponent(Indicator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(0, 132, Short.MAX_VALUE))
        );
        connectLayout.setVerticalGroup(
            connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Indicator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, connectLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(connect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, 232, -1));

        Button3.setBackground(new java.awt.Color(252, 230, 252));
        Button3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button3MouseClicked(evt);
            }
        });

        Indicator3.setBackground(new java.awt.Color(204, 0, 204));
        Indicator3.setOpaque(false);

        javax.swing.GroupLayout Indicator3Layout = new javax.swing.GroupLayout(Indicator3);
        Indicator3.setLayout(Indicator3Layout);
        Indicator3Layout.setHorizontalGroup(
            Indicator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        Indicator3Layout.setVerticalGroup(
            Indicator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        registre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registre.setForeground(new java.awt.Color(96, 83, 150));
        registre.setText("Créer un Compte");

        javax.swing.GroupLayout Button3Layout = new javax.swing.GroupLayout(Button3);
        Button3.setLayout(Button3Layout);
        Button3Layout.setHorizontalGroup(
            Button3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button3Layout.createSequentialGroup()
                .addComponent(Indicator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registre)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        Button3Layout.setVerticalGroup(
            Button3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Indicator3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Button3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registre, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(Button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 277, 232, 50));

        Button4.setBackground(new java.awt.Color(252, 230, 252));
        Button4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button4MouseClicked(evt);
            }
        });

        Indicator4.setBackground(new java.awt.Color(204, 0, 204));
        Indicator4.setOpaque(false);

        javax.swing.GroupLayout Indicator4Layout = new javax.swing.GroupLayout(Indicator4);
        Indicator4.setLayout(Indicator4Layout);
        Indicator4Layout.setHorizontalGroup(
            Indicator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        Indicator4Layout.setVerticalGroup(
            Indicator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Button4Layout = new javax.swing.GroupLayout(Button4);
        Button4.setLayout(Button4Layout);
        Button4Layout.setHorizontalGroup(
            Button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button4Layout.createSequentialGroup()
                .addComponent(Indicator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 224, Short.MAX_VALUE))
        );
        Button4Layout.setVerticalGroup(
            Button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Indicator4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(Button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 331, 232, -1));
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 39, -1, -1));

        jPanel14.setBackground(new java.awt.Color(232, 201, 232));

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

        jPanel13.setBackground(new java.awt.Color(96, 83, 150));

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
        jLabel5.setForeground(new java.awt.Color(96, 83, 150));
        jLabel5.setText(" E-Bank");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 150, 37));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 580));

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));
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

        jPanel8.setBackground(new java.awt.Color(96, 83, 150));
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel6.setToolTipText("");

        step1.setText("Step 1");
        step1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                step1MouseClicked(evt);
            }
        });

        step2.setText("Step 2");
        step2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                step2MouseClicked(evt);
            }
        });
        step2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                step2KeyPressed(evt);
            }
        });

        step3.setText("Step 3");
        step3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                step3MouseClicked(evt);
            }
        });

        tostep3.setText(">>");
        tostep3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tostep3MouseClicked(evt);
            }
        });

        tostep2.setText(">>");
        tostep2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tostep2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(step1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(tostep2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(step2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(tostep3)
                .addGap(126, 126, 126)
                .addComponent(step3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(step1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(step2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(step3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tostep3)
                    .addComponent(tostep2))
                .addGap(59, 59, 59)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 170));

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        jPanel2.add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 730, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 750, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button3MouseClicked
        // TODO add your handling code here:
        showSteps();
        onClick(Button3);
        onLeaveClick(Button2);
        onLeaveClick(connect);
        onLeaveClick(Button4);

        //indicators
        Indicator1.setOpaque(false);
        Indicator2.setOpaque(false);
        Indicator3.setOpaque(true);
        Indicator4.setOpaque(false);

        show("Registre");
    }//GEN-LAST:event_Button3MouseClicked

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_closeMouseClicked

    private void Button4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button4MouseClicked
        // TODO add your handling code here:
        onClick(Button4);
        onLeaveClick(Button2);
        onLeaveClick(Button3);
        onLeaveClick(connect);
        //indicators
        Indicator1.setOpaque(false);
        Indicator2.setOpaque(false);
        Indicator3.setOpaque(false);
        Indicator4.setOpaque(true);

        container.removeAll();
        this.container.add(new home());
        this.container.revalidate();
        validate();

        show("task");

    }//GEN-LAST:event_Button4MouseClicked

    private void Button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button2MouseClicked
        // TODO add your handling code here:
        hideSteps();
        onClick(Button2);
        onLeaveClick(connect);
        onLeaveClick(Button3);
        onLeaveClick(Button4);
        //        this.actionPerformed(e);

        //indicators
        Indicator1.setOpaque(false);
        Indicator2.setOpaque(true);
        Indicator3.setOpaque(false);
        Indicator4.setOpaque(false);

        show("mail");

    }//GEN-LAST:event_Button2MouseClicked

    private void connectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_connectMouseClicked
        // TODO add your handling code here:
        hideSteps();
        onClick(connect);
        onLeaveClick(Button2);
        onLeaveClick(Button3);
        onLeaveClick(Button4);

        //indicators
        Indicator1.setOpaque(true);
        Indicator2.setOpaque(false);
        Indicator3.setOpaque(false);
        Indicator4.setOpaque(false);

        show("Connecter");

    }//GEN-LAST:event_connectMouseClicked

    private void step1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_step1MouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.add(registreStep1);
        this.container.revalidate();
        this.container.repaint();
    }//GEN-LAST:event_step1MouseClicked

    private void step2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_step2KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_step2KeyPressed

    private void step2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_step2MouseClicked
        // TODO add your handling code here:
        if (step2.isEnabled()) {
            container.removeAll();
            container.add(registreStep2);
            this.container.revalidate();
            this.container.repaint();
        }
    }//GEN-LAST:event_step2MouseClicked

    private void step3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_step3MouseClicked
        // TODO add your handling code here:
        if (step3.isEnabled()) {
            container.removeAll();
            container.add(registreStep3);
            this.container.revalidate();
            this.container.repaint();
        }

    }//GEN-LAST:event_step3MouseClicked

    private void tostep2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tostep2MouseClicked
        // TODO add your handling code here:
        //SendAnSMS()

        if (registreStep1.getInfos()) {
            labelShow("step2");
            labelShow("tostep3");
            container.removeAll();
            container.add(registreStep2);
            this.container.revalidate();
            this.container.repaint();
        }
    }//GEN-LAST:event_tostep2MouseClicked

    private void tostep3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tostep3MouseClicked

        // TODO add your handling code here:
        if (registreStep2.codeValid()) {
            labelShow("step3");
            container.removeAll();
            container.add(registreStep3);
            this.container.revalidate();
            this.container.repaint();
        }

    }//GEN-LAST:event_tostep3MouseClicked

    public void labelShow(String lable) {
        if (lable.equals("step2")) {
            step2.enable();
            step2.repaint();
            step2.revalidate();
        }
        if (lable.equals("tostep2")) {
            tostep2.enable();
            tostep2.repaint();
            tostep2.revalidate();
        }
        if (lable.equals("step3")) {
            step3.enable();
            step3.repaint();
            step3.revalidate();
        }
        if (lable.equals("tostep3")) {
            tostep3.enable();
            tostep3.repaint();
            tostep3.revalidate();
        }
    }

    //bad idea
    private void onClick(JPanel panel) {
        panel.setBackground(new Color(205, 136, 205));

    }

    private void onLeaveClick(JPanel panel) {
        panel.setBackground(new Color(252, 230, 252));
    }

    public void show(String nom) {

        container.removeAll();
        javax.swing.JPanel panelToShow = new javax.swing.JPanel();

        if (nom.equals("Connecter")) {
            panelToShow = new home();
        }

        if (nom.equals("Registre")) {
            panelToShow = registreStep1;
        }
        if (nom.equals("RegistreStep2")) {
            panelToShow = registreStep2;
            System.out.println("from Login");
        }

        if (nom.equals("mail")) {
            panelToShow = new Virement();
        }

        if (nom.equals("task")) {
            panelToShow = new ResetPassword();
        }

        this.container.add(panelToShow);
        this.container.revalidate();
        //validate();
        this.container.repaint();

        //System.out.println(container.getSize());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Button2;
    private javax.swing.JPanel Button3;
    private javax.swing.JPanel Button4;
    private javax.swing.JPanel Indicator1;
    private javax.swing.JPanel Indicator2;
    private javax.swing.JPanel Indicator3;
    private javax.swing.JPanel Indicator4;
    private javax.swing.JLabel btn_close;
    private javax.swing.JPanel connect;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel passwordReset;
    private javax.swing.JLabel registre;
    private javax.swing.JLabel step1;
    private javax.swing.JLabel step2;
    private javax.swing.JLabel step3;
    private javax.swing.JLabel tostep2;
    private javax.swing.JLabel tostep3;
    // End of variables declaration//GEN-END:variables

}
