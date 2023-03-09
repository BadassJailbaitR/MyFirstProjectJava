package com.emi;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author pc
 */


public class MesReservations extends javax.swing.JFrame {
	/**
     * Creates new form NewJFrame
     */
	String user;
	String email;
	private JLabel mail;
	public void SetEmail(String email1)
	{
		mail.setText(email1);
		email=email1;
	}
    public void SetName(String email)
    {
    	if (!email.isEmpty())
    	{
	    	user=email;
    	}
    }
    Home back;
	

    /**
     * Creates new form Evaluer
     */
    public MesReservations() {
    	this(null);
    }
    
    public MesReservations(Home home) {
        back=home;
    	initComponents();
    }


    private void initComponents() {

        tfyftfy = new javax.swing.JPanel();
        jLabel3 = new JLabel();
        jLabel3.setBounds(150, 10, 420, 41);
        jLabel2 = new JLabel();
        jLabel2.setBounds(10, 0, 41, 60);
        jLabel4 = new JLabel();
        jLabel4.setBounds(700, 10, 27, 40);
        jLabel1 = new JLabel();
        mail = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(0, 153, 0));
        setLocation(new java.awt.Point(170, 70));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(990, 620));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfyftfy.setBackground(new Color(51, 153, 255));
        tfyftfy.setName("");

        jLabel3.setFont(new Font("Segoe UI", 0, 32)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mes Reservations\r\n");

        jLabel2.setFont(new Font("Segoe UI", 0, 60)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("<");
        jLabel2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel4.setFont(new Font("Segoe UI", 0, 45)); // NOI18N
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        getContentPane().add(tfyftfy, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 740, 500));
        tfyftfy.setBackground(new Color(20,150,50, 255));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 92, 740, 342);
        table = new JTable();
        scrollPane.setViewportView(table);
        
        System.out.println(back.getMail());
        
        Terrain.mesreservations(back.getMail(),table);
        tfyftfy.setLayout(null);
        tfyftfy.add(jLabel2);
        tfyftfy.add(jLabel3);
        tfyftfy.add(jLabel4);
        tfyftfy.add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("Annuler\r\n");
        lblNewLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lblNewLabel.setForeground(new Color(255, 40, 40));
        	}
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int[] selectedRows = table.getSelectedRows();
        		Object value = table.getValueAt(selectedRows[0], 4);
        		String no1 = value.toString();
        		long no = Long.parseLong(no1);
        		LocalDate date = LocalDate.now();
        		Object value1 = table.getValueAt(selectedRows[0],2);
        		String dat=value1.toString();
        		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        		LocalDate Date1 = LocalDate.parse(dat, formatter);
        		if (Date1.compareTo(date)>=2)
        		{
	        		Terrain.DeleteRes(no,back.getMail());
	        		back.jComboBox1.setSelectedIndex(-1);
	        		back.setVisible(true);
	        		dispose();
        		}
        		else
        		{
            		JOptionPane.showMessageDialog(null, "Vous ne pouvez pas annuler une reservation avant 2 jours du jour du match");
        		}
        	}
        });
        lblNewLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseExited(MouseEvent e) {
        		lblNewLabel.setForeground(new Color(0, 0, 0));
        	}
        });
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblNewLabel.setBounds(327, 457, 96, 32);
        tfyftfy.add(lblNewLabel);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/foot.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 575));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, -310, 1250, 950));
        getContentPane().add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(5000, 5000, 1250, 950));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
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
            java.util.logging.Logger.getLogger(MesReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MesReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MesReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MesReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MesReservations().setVisible(true);
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
