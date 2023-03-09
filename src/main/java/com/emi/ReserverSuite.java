package com.emi;
import java.awt.Color;
import java.awt.Desktop;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author pc
 */


public class ReserverSuite extends javax.swing.JFrame {
	private JLabel reserve;
	/**
     * Creates new form NewJFrame
     */
   private Reserver back1;
   
   
	
	public ReserverSuite() {
        initComponents();
    }


    public ReserverSuite(Reserver home) {
    	back1 = home;
        initComponents();
    }

    private void initComponents() {
    
        tfyftfy = new javax.swing.JPanel();
        jLabel3 = new JLabel();
        jButton1 = new javax.swing.JButton();
        String email = back1.getMail();
        jButton1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int[] selectedRows = table1.getSelectedRows();
        		Object value = table1.getValueAt(selectedRows[0], 0);
        		Object value1 = table1.getValueAt(selectedRows[0], 5);
        		Object value2 = table1.getValueAt(selectedRows[0], 2);
        		String adress = value2.toString();
        		String nomTer=value.toString();
        		String prix=value1.toString();
        		String customerName = Terrain.user(email);
        		String Ville=back1.GetVille();
        		int hr=back1.GetHeure();
        		String date=back1.GetDate();
        		int min=Terrain.minute(nomTer, Ville);

        	    // Créez le document PDF en utilisant la bibliothèque de création de PDF
        	    // et ajoutez les informations du reçu
        	    Document pdf = new Document();
        	    try {
        	      long millis = System.currentTimeMillis();
        	      PdfWriter.getInstance(pdf, new FileOutputStream("recu.pdf"));
        	      pdf.open();
        	      pdf.add(new Paragraph("Reçu Numero   : " + millis));
        	      pdf.add(new Paragraph("Reçu pour     : " + customerName));
        	      pdf.add(new Paragraph("Montant       : " + prix+" MAD"));
        	      pdf.add(new Paragraph("Terrain       : " + nomTer));
        	      pdf.add(new Paragraph("Ville         : " + Ville));
        	      pdf.add(new Paragraph("Heure         : " + hr+":"+min));
        	      pdf.add(new Paragraph("Adress        : " + adress));
        	      pdf.add(new Paragraph("Date de Match : " + date));
        	      Terrain.reserver(nomTer,email,date,hr,Ville,millis);
        	      pdf.close();
        	      File inputFile = new File("recu.pdf");
        	      Desktop desktop = Desktop.getDesktop();

        	      // open the PDF file
        	      try {
        	        desktop.open(inputFile);
        	      } catch (IOException e1) {
        	        // handle the exception
        	        e1.printStackTrace();
        	      }
        	    } catch (Exception ex) {
        	      ex.printStackTrace();
        	    }
        	    back1.setVisible(true);
        	    dispose();
        	}
        });
        nomTr = new javax.swing.JTextField();
        jLabel2 = new JLabel();
        jLabel4 = new JLabel();
        jLabel1 = new JLabel();
        reserve = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(0, 153, 0));
        setLocation(new java.awt.Point(170, 70));
        setUndecorated(true);
        setPreferredSize(new Dimension(990, 620));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfyftfy.setBackground(new Color(51, 153, 255));
        tfyftfy.setName("");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reserver un terrain");
        
        reserve.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reserve.setForeground(new Color(0, 255, 10));
        reserve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reserve.setText("Vous Avez Reserve Le Terrain");
        reserve.setVisible(false);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new Color(25, 118, 211));
        jButton1.setText("RESERVER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        
        table1 = new JTable();
        Terrain.Available(back1.GetVille(),back1.GetHeure(),back1.GetDate(),table1);

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
        			.addComponent(jLabel4))
        		.addGroup(gl_tfyftfy.createSequentialGroup()
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 740, GroupLayout.PREFERRED_SIZE)
        			.addGap(4)
        			.addComponent(reserve, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_tfyftfy.createSequentialGroup()
        			.addGap(210)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
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
        			.addGroup(gl_tfyftfy.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_tfyftfy.createSequentialGroup()
        					.addGap(37)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE))
        				.addComponent(reserve, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
        			.addGap(6)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        );
        
        scrollPane.setViewportView(table1);
        
        tfyftfy.setLayout(gl_tfyftfy);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/foot.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new Dimension(800, 575));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, -310, 1250, 950));

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

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
            java.util.logging.Logger.getLogger(ReserverSuite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReserverSuite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReserverSuite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReserverSuite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReserverSuite().setVisible(true);
            }
        });
    }

	private javax.swing.JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private javax.swing.JTextField nomTr;
    private javax.swing.JPanel tfyftfy;
    public JTable table1;
}
