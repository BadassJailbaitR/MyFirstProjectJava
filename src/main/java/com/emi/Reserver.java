package com.emi;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author pc
 */


public class Reserver extends javax.swing.JFrame {
	

	String dateMatch;
	int heure ;
	String email;
   private Home back1;
   String Ville;
	private JTable table;
	
	public Reserver() {
        this(null);
    }

    /**
     * Creates new form Evaluer
     */
    public Reserver(Home home) {
    	back1 = home;
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	email=back1.getMail();
        tfyftfy = new javax.swing.JPanel();
        jLabel5 = new JLabel();
        jLabel3 = new JLabel();
        jButton1 = new javax.swing.JButton();
        dateM = new com.toedter.calendar.JDateChooser();
        jLabel6 = new JLabel();
        nomTr = new javax.swing.JTextField();
        jLabel7 = new JLabel();
        heureM = new javax.swing.JSpinner();
        villTr = new javax.swing.JTextField();
        jLabel2 = new JLabel();
        jLabel4 = new JLabel();
        jLabel1 = new JLabel();
        table = new JTable();
        

        dateM.getJCalendar().setMinSelectableDate(new Date());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(0, 153, 0));
        setLocation(new java.awt.Point(170, 70));
        setUndecorated(true);
        setPreferredSize(new Dimension(990, 620));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfyftfy.setBackground(new Color(51, 153, 255));
        tfyftfy.setName("");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new Color(199, 226, 255));
        jLabel5.setText("Heure du d??but de match");
        jLabel5.setMinimumSize(new Dimension(60, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reserver un terrain");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new Color(25, 118, 211));
        jButton1.setText("RECHERCHER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        dateM.setBackground(new Color(153, 153, 153));
        dateM.setForeground(new Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new Color(199, 226, 255));
        jLabel6.setText("Ville");
        jLabel6.setMinimumSize(new Dimension(60, 20));
        
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new Color(199, 226, 255));
        jLabel7.setText("Jour de match");
        jLabel7.setMinimumSize(new Dimension(60, 20));

        heureM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        heureM.setModel(new javax.swing.SpinnerNumberModel(12, 0, 23, 1));

        villTr.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        villTr.setToolTipText("");
        villTr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                villTrActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("<");
        jLabel2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 45)); // NOI18N
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        getContentPane().add(tfyftfy, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 740, 500));
        tfyftfy.setBackground(new Color(20,150,50, 255));
        GroupLayout gl_tfyftfy = new GroupLayout(tfyftfy);
        gl_tfyftfy.setHorizontalGroup(
        	gl_tfyftfy.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_tfyftfy.createSequentialGroup()
        			.addGroup(gl_tfyftfy.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_tfyftfy.createSequentialGroup()
        					.addGap(10)
        					.addComponent(jLabel2)
        					.addGap(99)
        					.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
        					.addGap(130)
        					.addComponent(jLabel4))
        				.addGroup(gl_tfyftfy.createSequentialGroup()
        					.addGap(210)
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_tfyftfy.createSequentialGroup()
        					.addGap(40)
        					.addGroup(gl_tfyftfy.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
        						.addComponent(villTr, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
        					.addGap(80)
        					.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        					.addGap(20)
        					.addComponent(dateM, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_tfyftfy.createSequentialGroup()
        					.addGap(132)
        					.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
        					.addGap(29)
        					.addComponent(heureM, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(13, Short.MAX_VALUE))
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
        			.addGap(90)
        			.addGroup(gl_tfyftfy.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_tfyftfy.createSequentialGroup()
        					.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addComponent(villTr, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_tfyftfy.createSequentialGroup()
        					.addGap(20)
        					.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_tfyftfy.createSequentialGroup()
        					.addGap(30)
        					.addComponent(dateM, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        			.addGap(51)
        			.addGroup(gl_tfyftfy.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(heureM, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGap(150)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        );
        tfyftfy.setLayout(gl_tfyftfy);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/foot.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new Dimension(800, 575));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, -310, 1250, 950));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	registerUser();
	}
	private void registerUser() {
		Ville = villTr.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dateMatch = sdf.format(dateM.getDate());
		heure = (int)heureM.getValue();
    	int c;
    	if(!(Ville.isEmpty() && dateMatch.isEmpty()))
	    {
	    		ReserverSuite r = new ReserverSuite(this);
        		back1.jComboBox1.setSelectedIndex(-1);
	    		r.setVisible(true);
	    		this.dispose();
	    }
	}
    	//GEN-LAST:event_jButton1ActionPerformed

    private void villTrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_villTrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_villTrActionPerformed

    private void jLabel4MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
    	if(this!=null)
    		back1.setVisible(true);
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
            java.util.logging.Logger.getLogger(Reserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reserver().setVisible(true);
            }
        });
    }
    public String GetVille()
    {
    	return Ville;
    }
    public String GetDate()
    {
    	return dateMatch;
    }
    public int GetHeure()
    {
    	return heure;
    }
    public String getMail()
    {
    	return email;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateM;
    private javax.swing.JSpinner heureM;
    private javax.swing.JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private javax.swing.JTextField nomTr;
    private javax.swing.JPanel tfyftfy;
    private javax.swing.JTextField villTr;
    // End of variables declaration//GEN-END:variables
}
