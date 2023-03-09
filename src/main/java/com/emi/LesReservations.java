package com.emi;
import java.awt.Color;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author pc
 */


public class LesReservations extends javax.swing.JFrame {
	/**
     * Creates new form NewJFrame
     */
	String user;
	Home back;

    
	

    /**
     * Creates new form Evaluer
     */
	public LesReservations() {
		this(null);
    }
	
    public LesReservations(Home home) {
        back=home;
    	initComponents();
    }


    private void initComponents() {

        tfyftfy = new javax.swing.JPanel();
        jLabel3 = new JLabel();
        jLabel2 = new JLabel();
        jLabel4 = new JLabel();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(0, 153, 0));
        setLocation(new java.awt.Point(170, 70));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(990, 620));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfyftfy.setBackground(new Color(51, 153, 255));
        tfyftfy.setName("");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Les Reservations");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("<");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 45)); // NOI18N
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        getContentPane().add(tfyftfy, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 740, 500));
        tfyftfy.setBackground(new Color(20,150,50, 255));
        
        JScrollPane scrollPane = new JScrollPane();
        
        GroupLayout gl_tfyftfy = new GroupLayout(tfyftfy);
        gl_tfyftfy.setHorizontalGroup(
        	gl_tfyftfy.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_tfyftfy.createSequentialGroup()
        			.addGap(10)
        			.addComponent(jLabel2)
        			.addGap(99)
        			.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
        			.addGap(130)
        			.addComponent(jLabel4)
        			.addContainerGap(13, Short.MAX_VALUE))
        		.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        gl_tfyftfy.setVerticalGroup(
        	gl_tfyftfy.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_tfyftfy.createSequentialGroup()
        			.addGroup(gl_tfyftfy.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_tfyftfy.createSequentialGroup()
        					.addGap(10)
        					.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_tfyftfy.createSequentialGroup()
        					.addGap(10)
        					.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
        			.addGap(66))
        );
        
        table = new JTable();
        scrollPane.setViewportView(table);
        if (back.GetLog()==3)
        	Terrain.reservations(table);
        if (back.GetLog()==2)
        	Terrain.res(back.getMail(), table);
        tfyftfy.setLayout(gl_tfyftfy);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/foot.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 575));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, -310, 1250, 950));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
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
            java.util.logging.Logger.getLogger(LesReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LesReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LesReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LesReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LesReservations().setVisible(true);
            }
        });
    }
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private javax.swing.JPanel tfyftfy;
    private JTable table;
}
