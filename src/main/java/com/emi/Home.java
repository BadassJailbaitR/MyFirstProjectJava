package com.emi;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author pc
 */
public class Home extends JFrame {
    private JLabel mail;
	private JLabel User;
    String user;
    String Mail;
    String email;
    int a;
	private JLabel adm;
	log back;
    
    public String getMail()
    {
    	return Mail;
    }
    
	public void setMail(String mail1) {
		Mail = mail1;
		mail.setText(mail1);
	}
	public void setAdmin(int a1)
	{
		a=a1;
		String admn=Integer.toString(a1);
		adm.setText(admn);
	}
	/**
     * Creates new form Home
     */

	public Home()
	{
		this(null);
	}
	
    public Home(log l) {
    	back = l;
    	if (back!=null)
    		initComponents();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/Images/hoome.jpg")));
		setTitle("Reservation");
    }
    public void SetName(String email)
    {
    	if (!email.isEmpty())
    	{
    		user=email;
	    	User.setText(email);
    	}
    }
    
    private void initComponents() {

    	jPanel1 = new javax.swing.JPanel();
        jLabel1 = new JLabel();
        jLabel4 = new JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new JLabel();
        jLabel5 = new JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new JLabel();
        jLabel6 = new JLabel();
        User = new JLabel();
        adm= new JLabel();
        mail = new JLabel();
        User.setBounds(628, 10, 174, 27);
        jPanel4 = new javax.swing.JPanel();
        jComboBox1 = new JComboBox<>();
        jComboBox1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String choice = (String) jComboBox1.getSelectedItem();
        		if (choice=="Log out")
        		{
        			new log().setVisible(true);
        			dispose();
        		}
        		if(choice=="Mes reservation")
        		{
        			Register();
        		}
        		if(choice=="Modifier terrain")
        		{
        			Modifier();
        		}
        		if(choice=="Valider terrain")
        		{
        			Valider();
        		}
        		if(choice=="Modifier client")
        		{
        			Client();
        		}
        		if (choice=="Les Reservations")
        		{
        			Reserv();
        		}
        	}
        });
        jComboBox1.setBounds(812, 11, 98, 20);
        jLabel8 = new JLabel();
        jLabel8.setBounds(578, 0, 50, 50);
        jLabel10 = new JLabel();
        jLabel10.setBounds(946, 11, 24, 39);
        jLabel7 = new JLabel();
        a=back.GetLog();

        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new Color(51, 51, 255));
        setLocation(new java.awt.Point(170, 70));
        setMaximumSize(new java.awt.Dimension(1000, 610));
        setMinimumSize(new java.awt.Dimension(980, 610));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(990, 620));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Plus_128px_2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));
        jLabel1.setBackground(new Color(0, 0, 0, 128));
        jLabel2.setBackground(new Color(0, 0, 0, 128));
        jLabel3.setBackground(new Color(0, 0, 0, 128));
        jLabel4.setBackground(new Color(0, 0, 0, 128));
        jLabel5.setBackground(new Color(0, 0, 0, 128));
        jLabel6.setBackground(new Color(0, 0, 0, 128));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("Ajouter un terrain");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 186, 70));
        jPanel1.add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(2000, 2000, 186, 70));

        adm.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        adm.setForeground(new Color(255, 255, 255));
        jPanel1.add(adm, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 186, 70));
        
        
        if (a==2 || a==3)
        	getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 260, 270));
        jPanel1.setBackground(new Color(0, 0, 0, 128));
        jPanel2.setBackground(new Color(0, 0, 0, 128));
        jPanel3.setBackground(new Color(0, 0, 0, 128));

        jPanel2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        
        System.out.println(adm.getText());
        
        jLabel2.setIcon(new ImageIcon(Home.class.getResource("/Images/icons8_search_property_128px.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 120, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setText("Evaluer un terrain");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 194, 47));

        if (a==1)
            getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 260, 270));
        if (a==2 || a==3)
            getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 260, 270));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Checkmark_128px_1.png"))); // NOI18N
        jLabel3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 120));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setText("Reserver un terrain");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 192, 49));
        jPanel4.setLayout(null);
        
        User.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        User.setForeground(new Color(255, 255, 255));
        jPanel4.add(User);

        
        
        if (a==1)
        	getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 250, 270));
        if (a==2 || a==3)
        	getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 250, 270));
        
        jPanel4.setBackground(new Color(0, 153, 0));

        jComboBox1.setMaximumRowCount(2);
        jComboBox1.setModel(new DefaultComboBoxModel(new String[] {"Mes reservation", "Log out"}));
        jComboBox1.setSelectedIndex(-1);

        
        if(a==3)
        {
        	jComboBox1.setModel(new DefaultComboBoxModel(new String[] {"Modifier terrain","Valider terrain","Modifier client","Mes reservation","Les Reservations","Log out"}));
            jComboBox1.setSelectedIndex(-1);
        	jComboBox1.setMaximumRowCount(6);
        }
        if(a==2)
        {
        	jComboBox1.setModel(new DefaultComboBoxModel(new String[] {"Modifier terrain","Mes reservation","Les Reservations", "Log out"}));
            jComboBox1.setSelectedIndex(-1);
        	jComboBox1.setMaximumRowCount(4);
        }
        
        
        jLabel8.setIcon(new ImageIcon(getClass().getResource("/images/icons8_contacts_50px_1.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("X");
        jLabel10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel8.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 50));
        jPanel4.add(jLabel8);
        jPanel4.add(jComboBox1);
        jPanel4.add(jLabel10);

        jLabel7.setBackground(new Color(0, 102, 0));
        jLabel7.setIcon(new ImageIcon(getClass().getResource("/images/hoome.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 980, 560));
        
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Reserver secondPage = new Reserver(this);
        email=mail.getText();
        secondPage.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    
    private void jLabel10MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jPanel2MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
       Evualuer ev = new Evualuer(this); 
       ev.setVisible(true);
       dispose();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void Register()
    {
    	MesReservations m = new MesReservations(this);
		m.SetEmail(email);
        email=mail.getText();
		m.setVisible(true);
		this.dispose();
    }
    private void Valider()
    {
    	ValiderTerrain val = new ValiderTerrain(this);
		val.setVisible(true);
		this.dispose();
    }
    private void Modifier()
    {
    	ModifierTerrain ter = new ModifierTerrain(this);
    	ter.setVisible(true);
    	this.dispose();
    }
    private void Reserv()
    {
    	LesReservations re = new LesReservations(this);
    	re.setVisible(true);
    	this.dispose();
    }
    private void Client()
    {
    	ModifierCompte mod = new ModifierCompte(this);
		mod.setVisible(true);
		this.dispose();
    }
    private void jPanel1MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
         Ajouter secondPage = new Ajouter(this);
        secondPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jPanel1MouseClicked
    
    public String GetMail()
    {
    	return email;
    }
    public int GetLog()
    {
    	return a;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
}