/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.emi;

import com.emi.Interfaces.RunnableScreen;

import javax.swing.JTextField;
import java.awt.Frame;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class forgetPass extends  JFrame implements RunnableScreen {

    /**
     * Creates new form login
     */
	String Email;
	private JPanel signuppanel;
	private JPanel panel;
	private JTextField email;
	private JLabel disable;
	private JLabel show;
	private JPanel jPanel1;
	private JLabel Cancel;
	private JLabel empty;
	private JLabel retur;
    public forgetPass() {
        initComponents();
		email.setBackground(new Color(0,0,0,1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel1.setBounds(93, 38, 340, 340);
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        jLabel2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
    	        System.exit(0);
        	}
        });
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        email = new JTextField();
        empty = new JLabel();
        retur = new JLabel();
        jLabel6 = new JLabel();
        Cancel = new JLabel();
        Cancel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
                Cancel.setForeground(new Color(0, 0, 0));
        	}
        	public void mouseExited(MouseEvent e) {
                Cancel.setForeground(new Color(255, 255, 255));
        	}
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		setVisible(false);
        	}
        });
        jLabel7 = new JLabel();
        disable = new JLabel();
        show = new JLabel();
        panel = new JPanel();
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Email = email.getText();
        		if (Email.isEmpty())
        		{
        			retur.setVisible(false);
        	        empty.setVisible(true);
        		}
        		else if (Terrain.search(Email)==0)
        		{
        			retur.setVisible(true);
        	        empty.setVisible(false);
        		}
        		else
        		{
        			retur.setVisible(false);
        	        empty.setVisible(false);
        	        VerificationPassword secondpage = new VerificationPassword(); 
        	        secondpage.GetMail(Email);
        	        secondpage.setVisible(true);
        	        dispose();
        		}
        	}
        });
        
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new ImageIcon(forgetPass.class.getResource("/icon/image4.jpg"))); // NOI18N
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 440));

        jPanel2.setBackground(new Color(25, 118, 211));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        panel.setBackground(new Color(30, 200, 200));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        

        jLabel2.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 40, 29));

        jLabel3.setFont(new Font("Segoe UI", 0, 32)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Find Your Account");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 420, 41));

        jLabel4.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("Please enter your email address to search for your account.");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 94, 420, -1));

        jLabel5.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new Color(199, 226, 255));
        jLabel5.setText("Email");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(34,173, 341, -1));
        
        retur.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        retur.setForeground(new Color(255, 0, 0));
        retur.setText("The Application Didn't Return Your Account");
        jPanel2.add(retur, new org.netbeans.lib.awtextra.AbsoluteConstraints(34,228, 341, -1));
        
        empty.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        empty.setForeground(new Color(255, 0, 0));
        empty.setText("Please Fill The Email Field");
        jPanel2.add(empty, new org.netbeans.lib.awtextra.AbsoluteConstraints(34,228, 341, -1));
        
        retur.setVisible(false);
        empty.setVisible(false);

        email.setFont(email.getFont().deriveFont(email.getFont().getSize()+2f));
        email.setForeground(new Color(255, 255, 255));
        email.setBorder(null);
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 190, 240, 30));
        

        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setText("_________________________________________");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 197, 290, 39));
        
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setIcon(new ImageIcon(getClass().getResource("/icon/icons8_user_20px_1.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 197, 40, 39));
        
        Cancel.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        Cancel.setForeground(new Color(255, 255, 255));
        Cancel.setHorizontalAlignment(SwingConstants.CENTER);
        Cancel.setText("Cancel");
        Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 352, 80, -1));

        jButton1.setBackground(new Color(255, 255, 255));
        jButton1.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new Color(25, 118, 211));
        jButton1.setText("Send Verification Code");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 306, 341, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 420, 440));

        setSize(new java.awt.Dimension(916, 438));
        setLocationRelativeTo(null);
        }
    private void formWindowOpened(WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <=1.0; i = i+0.1){
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(50);
            }catch(Exception e){
                
            }
        }
    }
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JTextField jTextField1;
    private JTextField txtusername;
    // End of variables declaration//GEN-END:variables
	@Override
	public void run() {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgetPass().setVisible(true);
            }
        });
	}
}
