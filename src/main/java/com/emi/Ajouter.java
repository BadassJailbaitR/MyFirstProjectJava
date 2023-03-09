package com.emi;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class Ajouter extends javax.swing.JFrame {
	private Home back;
	
	public Ajouter() {
        this(null);
    }

    /**
     * Creates new form Evaluer
     */
    public Ajouter(Home home) {
    	back = home;
        initComponents();
    }

   
    private void initComponents() {

        tfyftfy = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nomTr = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        heureM = new javax.swing.JSpinner();
        villTr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setLocation(new java.awt.Point(170, 70));
        setMinimumSize(new java.awt.Dimension(990, 620));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfyftfy.setBackground(new java.awt.Color(51, 153, 255));
        tfyftfy.setForeground(new java.awt.Color(255, 255, 255));
        tfyftfy.setName(""); // NOI18N
        tfyftfy.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Prix par heure (en DH)");
        jLabel5.setMinimumSize(new java.awt.Dimension(60, 20));
        tfyftfy.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 180, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ajouter un terrain");
        tfyftfy.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 420, 41));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nom de terrain");
        jLabel8.setMinimumSize(new java.awt.Dimension(60, 20));
        tfyftfy.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 290, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 118, 211));
        jButton1.setText("Ajouter");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        tfyftfy.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 341, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ville");
        jLabel6.setMinimumSize(new java.awt.Dimension(60, 20));
        tfyftfy.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 280, 30));

        nomTr.setBackground(new java.awt.Color(51, 153, 255));
        nomTr.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomTr.setForeground(new java.awt.Color(255, 255, 255));
        nomTr.setBorder(null);
        nomTr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomTrActionPerformed(evt);
            }
        });
        tfyftfy.add(nomTr, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 300, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Heure d'ouverture");
        jLabel7.setMinimumSize(new java.awt.Dimension(60, 20));
        tfyftfy.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 140, 40));

        heureM.setModel(new javax.swing.SpinnerNumberModel(12, 0, 23, 1));
        heureM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfyftfy.add(heureM, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 80, 30));

        villTr.setBackground(new java.awt.Color(51, 153, 255));
        villTr.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        villTr.setForeground(new java.awt.Color(255, 255, 255));
        villTr.setToolTipText("");
        villTr.setBorder(null);
        villTr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                villTrActionPerformed(evt);
            }
        });
        tfyftfy.add(villTr, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 300, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        tfyftfy.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 60));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 45)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        tfyftfy.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, 40));

        jTextField1.setBackground(new java.awt.Color(51, 153, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        tfyftfy.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 300, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Adresse de terrain");
        tfyftfy.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 150, 30));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("__________________________________________");
        tfyftfy.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 310, 20));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("__________________________________________");
        tfyftfy.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 300, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("__________________________________________");
        tfyftfy.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 310, -1));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSpinner1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tfyftfy.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 80, 30));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(30, 0, 59, 1));
        jSpinner2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfyftfy.add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 70, 30));

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(30, 0, 59, 1));
        jSpinner3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfyftfy.add(jSpinner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 70, 30));

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(12, 0, 23, 1));
        jSpinner4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfyftfy.add(jSpinner4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 80, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Heure de ferméture");
        jLabel13.setMinimumSize(new java.awt.Dimension(60, 20));
        tfyftfy.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 180, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText(":");
        tfyftfy.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 20, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText(":");
        tfyftfy.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 10, 40));

        getContentPane().add(tfyftfy, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 850, 540));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/foot.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, -10, 1290, 630));

        pack();
        System.out.println(back.GetLog());
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int hrf = (int)jSpinner4.getValue();
        int minf = (int)jSpinner2.getValue();
        int hro = (int)heureM.getValue();
        int mino = (int)jSpinner3.getValue();
        int prix = (int)jSpinner1.getValue();
        int c = 1;
        String ville= villTr.getText();
        String adress=jTextField1.getText();
        String nomTer = nomTr.getText();
        String Heuref=Integer.toString(hrf)+":"+Integer.toString(minf);
        String Heureo=Integer.toString(hro)+":"+Integer.toString(mino);
        if(back.GetLog()==2)
        	c=Terrain.ajouter1(ville,nomTer,Heuref,Heureo,prix,adress,back.getMail());
        if (back.GetLog()==3)
        	c=Terrain.ajouter(ville,nomTer,Heuref,Heureo,prix,adress,back.getMail());
        if (c==0)
        {
    		JOptionPane.showMessageDialog(null, "Vous Avez Ajoute Le Terrain...");
        }
        else
        {
    		JOptionPane.showMessageDialog(null, "Ce Terrain Est Deja Existe Entrez Un Autre Terrain...");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nomTrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomTrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomTrActionPerformed

    private void villTrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_villTrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_villTrActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
            System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
    	if(this!=null)
    		back.jComboBox1.setSelectedIndex(-1);
    		back.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ajouter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner heureM;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField nomTr;
    private javax.swing.JPanel tfyftfy;
    private javax.swing.JTextField villTr;
    // End of variables declaration//GEN-END:variables
}
