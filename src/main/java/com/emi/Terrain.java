package com.emi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;



public class Terrain {
	
	private Terrain()
	{
		
	}
	
	private static Connection connect()
	{
    	Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_terrains","root","AbdelilahLegend12345@");
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return conn;
	}
	
	public static int SignUp(String nom,String prenom,String mail,String mdp,String adress,String ville,String tel,String datenaiss) {
        String sql = "INSERT INTO profile(nom,prenom,mail,mdp,adress,ville,tel,datenaiss,IsAdmin) VALUES(?,?,?,?,?,?,?,Str_To_Date(?,'%d/%m/%Y'),?)";
        int c=1;
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if (search(mail)==0)
            {
	        	pstmt.setString(1, nom);
	            pstmt.setString(2, prenom);
	            pstmt.setString(3, mail);
	            pstmt.setString(4, mdp);
	            pstmt.setString(5, adress);
	            pstmt.setString(6, ville);
	            pstmt.setString(7, tel);
	            pstmt.setString(8,datenaiss);
	            pstmt.setInt(9, 1);
	            pstmt.executeUpdate();
	            conn.close();
	            c=0;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return c;
        }
	public static int Login(String email,String mdp)
	{
		ResultSet rs;
		Connection conn = connect();
		PreparedStatement stmt = null;
		int c=0;
		int a=0;
		try 
        {
        	stmt = conn.prepareStatement("select count(*),IsAdmin from profile where mdp=? and mail=?");
            stmt.setString(1,mdp);
            stmt.setString(2,email);
        	rs = stmt.executeQuery();
        	rs.next();
        	c=rs.getInt(1);
        	if (c==1)
        	{
        		a=rs.getInt(2);
        	}
        	conn.close();
           } catch (SQLException e) {
               System.out.println(e);
           }
		return a;
    }
	public  static int ajouter(String ville,String NomTer,String hrFermeture,String hrOuverture,int prix,String adress,String mail)
	{
		int c = 0;
		String sql = "INSERT INTO terrain VALUES(?,?,?,?,Str_To_Date(?,'%T'),Str_To_Date(?,'%T'),?)";
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        		PreparedStatement stmt = conn.prepareStatement("select count(*) from terrain where nomTer=? and ville=?"))
        		{
        			stmt.setString(1,NomTer);
        			stmt.setString(2,ville);
        			ResultSet rs=stmt.executeQuery();
        			rs.next();
        			c=rs.getInt(1);
        			if (c==0)
        			{
	        			pstmt.setString(1,NomTer);
	        			pstmt.setString(2,ville);
	        			pstmt.setString(3,adress);
	        			pstmt.setInt(4, prix);
	        			pstmt.setString(5,hrFermeture);
	        			pstmt.setString(6,hrOuverture);
	        			pstmt.setString(7, mail);
	        			pstmt.executeUpdate();
        			}
        		}
		catch (SQLException e)
        {
			System.out.println(e);
        }
        return c;
	}
	public static int forget_password(String email)
	{
		int randomNum = ThreadLocalRandom.current().nextInt(100000,999999);
		
		String verif=Integer.toString(randomNum);
		String recipient = email;
		 
	      // email ID of  Sender.
	      String sender = "no-reply@amca.live";
	      String password="AVosSysT2S}T";
	      // using host as localhost
	      String host = "mail.privateemail.com";
	 
	      // Getting system properties
	      Properties properties = System.getProperties();
	 
	      // Setting up mail server
	      properties.put("mail.smtp.auth","true");
	      properties.put("mail.smtp.starttls.enable","true");
	      properties.put("mail.smtp.host", host);
	      properties.put("mail.smtp.port", "465");
	      properties.put("mail.smtp.ssl.trust", host);
	      properties.put("mail.transport.protocol","smtp");
	      properties.put("mail.smtp.ssl.enable", "true");
	      properties.put(
                  "mail.user", 
                  sender);
          properties.put(
                  "mail.password",
                  password);

	      // creating session object to get properties
	      Session session = Session.getDefaultInstance(properties,
	              new javax.mail.Authenticator() {
	                
	                //override the getPasswordAuthentication method
	                protected PasswordAuthentication
	                               getPasswordAuthentication() {
	                                            
	                    return new PasswordAuthentication(sender,password);
	                }
	              });
	      try
	      {
	    	  // MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From Field: adding senders email to from field.
	         message.setFrom(new InternetAddress(sender));
	 
	         // Set To Field: adding recipient's email to from field.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
	 
	         // Set Subject: subject of the email
	         message.setSubject("Verification Code");

	         // set body of the email.
	         message.setText(verif);
	         
	         

	         Transport.send(message);
	      }
	      catch (MessagingException mex)
	      {
	    	  System.out.println(mex);
	      }
	      return randomNum;
	}
	
	public static int minute(String NomTer,String Ville)
	{
		ResultSet rs;
		int c;
		int minf = 0;
		Time hro ;
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement("select hrouverture from terrain where nomter=? and ville=?"))
        {
        	pstmt.setString(1, NomTer);
        	pstmt.setString(2, Ville);
        	rs = pstmt.executeQuery();
        	rs.next();
        	hro=rs.getTime(1);
        	LocalTime hrf1=hro.toLocalTime();
        	minf=hrf1.getMinute();
        	return minf;
        }
        catch(SQLException e)
        {
        	
        }
        return minf;
	}
	
	public static int reserver(String NomTer,String email,String DateMatch,int heure,String ville,long no)
	{
		ResultSet rs;
		ResultSet rs1;
		int c;
		int prx;
		int min=minute(NomTer,ville);
		Time hrf ;
		Time hro ;
		String hre=Integer.toString(heure)+":"+Integer.toString(min);
		LocalTime hr=LocalTime.of(heure, min);
		String sql = "Select count(*) From reservation where heure=? and NomTer=? and DateMatch=Str_To_Date(?,'%d/%m/%Y') and ville=?";
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {
        	pstmt.setString(1,hre);
        	pstmt.setString(2,NomTer);
        	pstmt.setString(3,DateMatch);
        	pstmt.setString(4,ville);
        	rs = pstmt.executeQuery();
        	rs.next();
        	c=rs.getInt(1);
        	PreparedStatement stmt2=conn.prepareStatement("select hrFermeture,hrOuverture From terrain where nomTer=? and ville=?;");
        	stmt2.setString(1,NomTer);
        	stmt2.setString(2,ville);
        	ResultSet rs3=stmt2.executeQuery();
        	rs3.next();
        	hrf=rs3.getTime(1);
        	hro=rs3.getTime(2);
        	LocalTime hrf1=hrf.toLocalTime();
        	LocalTime hro1=hro.toLocalTime();
        	int o=hro1.compareTo(hr);
        	int f=hrf1.compareTo(hr);
        	if((o<0 && f>0 ) ||  (f==1 && o==0))
        	{
        		if (c==1)
            	{
            		System.out.println("le terrain est deja reserve...");
            		return 0;
            	}
        		else if (c==0)
	        	{
	        		PreparedStatement stmt = conn.prepareStatement("select prix from terrain where nomter=? and ville=?");
	        		stmt.setString(1,NomTer);
	        		stmt.setString(2,ville);
	        		rs1 =stmt.executeQuery();
	        		rs1.next();
	        		prx=rs1.getInt(1);
	        		PreparedStatement stmt1 = conn.prepareStatement("insert into reservation values(?,?,Str_To_Date(?,'%d/%m/%Y'),Str_To_Date(?,'%T'),?,?,?)");
	        		stmt1.setString(1,ville);
	        		stmt1.setString(2,NomTer);
	        		stmt1.setString(3,DateMatch);
	        		stmt1.setString(4,hre);
	        		stmt1.setString(5,email);
	        		stmt1.setInt(6,prx);
	        		stmt1.setLong(7, no);
	        		stmt1.executeUpdate();
	        		System.out.println("vous avez reserve le terrain...");
	        		return 1;
	        	}
        	}
        	else
        	{
        		System.out.println("le terrain n'est pas disponible a cette heure");
        		return 2;
        	}
        }
        catch(SQLException e)
        {
        	System.out.println(e);
        }
        return 3;
	}
	public static void affichage(JTable Table)
	{
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("select nomter,ville,adress,prix,hrouverture,hrfermeture from terrain;"))
		{
			ResultSet rs = stmt.executeQuery();
			java.sql.ResultSetMetaData metadata = rs.getMetaData();
			int nbColonnes = metadata.getColumnCount();
			String[] colonnes = new String[nbColonnes];
	        Object[] ligne = new Object[nbColonnes];
	        Object[] array1 = new Object[] {"Nom de Terrain","La Ville","L'Adress","Heure D'Ouverture","Heure De Fermeture","Prix"};
	        for (int i1 = 1; i1 <= nbColonnes; i1++) {
				   colonnes[i1-1] = (String) array1[i1-1];
				}
			int c=0;
			TableModel model = new DefaultTableModel(colonnes, 0);
		      while (rs.next())
		      {
		        String nomTer = rs.getString("nomTer");
		        String ville = rs.getString("ville");
		        String adress = rs.getString("adress");
		        int prix = rs.getInt("prix");
		        String px = Integer.toString(prix);
		        Time hrOuverture = rs.getTime("hrOuverture");
		        String hro=hrOuverture.toString();
		        Time hrFermeture = rs.getTime("hrFermeture");
		        String hrf=hrFermeture.toString();
		        Object[] array = new Object[] {nomTer,ville,adress,hro,hrf,px};
		        for (int i = 1; i <= nbColonnes; i++) {
		           ligne[i-1] = array[i-1];
		        }
				((DefaultTableModel) model).addRow(ligne);
		      }
		    Table.setModel(model);
		    stmt.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	public static int search(String email)
	{
		int c = 0;
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("select count(*) from profile where mail=?;"))
		{
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
		    rs.next();
		    c=rs.getInt(1);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return c;
	}
	public static boolean emailvalidation(String email) {
		String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";  
        Pattern pattern = Pattern.compile(regex);  
        Matcher matcher = pattern.matcher(email);  
        return matcher.matches();
	}
	public static boolean passwordvalidation(String password)
	{
		if (password.length()>=8)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean isValidFirstName(String firstName) {
	    // Check if the first name is non-empty
	    if (firstName == null || firstName.trim().isEmpty()) {
	        return false;
	    }

	    // Check if the first name contains only letters
	    for (int i = 0; i < firstName.length(); i++) {
	        char c = firstName.charAt(i);
	        if (!Character.isLetter(c)) {
	            return false;
	        }
	    }

	    // First name is valid
	    return true;
	}
	public static boolean isValidLastName(String lastName) {
	    // Check if the last name is non-empty
	    if (lastName == null || lastName.trim().isEmpty()) {
	        return false;
	    }

	    // Check if the last name contains only letters
	    for (int i = 0; i < lastName.length(); i++) {
	        char c = lastName.charAt(i);
	        if (!Character.isLetter(c)) {
	            return false;
	        }
	    }

	    // Last name is valid
	    return true;
	}
	public static boolean searchTer(String ville,String nomTer)
	{
		ResultSet rs;
		int c = 0;
		try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement("select count(*) from terrain where ville=? and nomter=?"))
        {
        	pstmt.setString(1,ville);
        	pstmt.setString(2,nomTer);
        	rs = pstmt.executeQuery();
        	rs.next();
        	c=rs.getInt(1);
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		if (c==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public static String user(String email)
	{
		String user="";
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("select nom,prenom from profile where mail=?;"))
		{
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
		    rs.next();
		    String nom=rs.getString(1);
		    String prenom=rs.getString(2);
		    user=prenom+" "+nom;
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return user;
	}
	public static void Change_Password(String Email,String mdp)
	{
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("Update profile Set mdp=? where mail=?"))
		{
			stmt.setString(1, mdp);
			stmt.setString(2, Email);
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}	
	}
	public static void Available(String Ville,int Heure,String DateMatch,JTable Table)
	{
		int o=Heure+1;
		String hr1=Integer.toString(o)+":"+"00";
		System.out.println(hr1);
		String hr=Integer.toString(Heure)+":"+"00";
		System.out.println(hr);
		String sql="SELECT nomter,ville,adress,prix,hrOuverture,hrFermeture FROM terrain WHERE ville=? and hrOuverture<STR_TO_DATE(?,'%T') and hrFermeture>=STR_TO_DATE(?,'%T') and nomTer not in (SELECT nomTer from reservation where dateMatch=STR_TO_DATE(?,'%d/%m/%Y') and heure>=Str_To_Date(?,'%T') and heure<=Str_To_Date(?,'%T') and ville=?);";
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement(sql))
		{
			stmt.setString(1,Ville);
			stmt.setString(2, hr1);
			stmt.setString(3, hr1);
			stmt.setString(4,DateMatch);
			stmt.setString(5,hr);
			stmt.setString(6,hr1);
			stmt.setString(7,Ville);
			ResultSet rs = stmt.executeQuery();
			java.sql.ResultSetMetaData metadata = rs.getMetaData();
			int nbColonnes = metadata.getColumnCount();
			String[] colonnes = new String[nbColonnes];
	        String[] array1 = new String[] {"Nom de Terrain","La Ville","L'Adress","Heure D'Ouverture","Heure De Fermeture","Prix"};
			for (int i1 = 1; i1 <= nbColonnes; i1++) {
			   colonnes[i1-1] = array1[i1-1];
			}
	        Object[] ligne = new Object[nbColonnes];

			TableModel model = new DefaultTableModel(colonnes, 0);
		      while (rs.next())
		      {

		        String nomTer = rs.getString("nomTer");
		        String ville = rs.getString("ville");
		        String adress = rs.getString("adress");
		        int prix = rs.getInt("prix");
		        String px = Integer.toString(prix);
		        Time hrOuverture = rs.getTime("hrOuverture");
		        String hro=hrOuverture.toString();
		        Time hrFermeture = rs.getTime("hrFermeture");
		        String hrf=hrFermeture.toString();
		        Object[] array = new Object[] {nomTer,ville,adress,hro,hrf,px};
		        for (int i = 1; i <= nbColonnes; i++) {
		           ligne[i-1] = array[i-1];
		        }
				((DefaultTableModel) model).addRow(ligne);
		      }
		    Table.setModel(model);
		    stmt.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	public static void mesreservations(String email,JTable Table)
	{
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("select nomter,ville,datematch,heure,nofacture from reservation where mail=?;"))
		{
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			java.sql.ResultSetMetaData metadata = rs.getMetaData();
			int nbColonnes = metadata.getColumnCount();
			String[] colonnes = new String[nbColonnes];
	        String[] array1 = new String[] {"Nom de Terrain","La Ville","Date de Match","Heure de Match","nofacture"};
			for (int i1 = 1; i1 <= nbColonnes; i1++) {
			   colonnes[i1-1] = array1[i1-1];
			}
	        Object[] ligne = new Object[nbColonnes];

			TableModel model = new DefaultTableModel(colonnes, 0);
		      while (rs.next())
		      {
		    	  String nomTer = rs.getString("nomTer");
			        String ville = rs.getString("ville");
			        long nofactur = rs.getLong("nofacture");
			        String no = Long.toString(nofactur);
			        Time heure = rs.getTime("heure");
			        Date date = rs.getDate("datematch");
			        String DateM = date.toString();
			        String hro=heure.toString();
		        Object[] array = new Object[] {nomTer,ville,DateM,hro,no};
		        LocalDateTime now = LocalDateTime.now();
		        DateFormat df = DateFormat.getDateInstance();
		        String str = df.format(date);
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
        		LocalDate Date1 = LocalDate.parse(str, formatter);
        		int h=heure.getHours();
        		int m=heure.getMinutes();
        		LocalTime time=LocalTime.of(h,m);
        		LocalDateTime date2=Date1.atTime(time);
        		System.out.println(date2);
	        if (now.isBefore(date2))
	        {
		        for (int i = 1; i <= nbColonnes; i++) {
		           ligne[i-1] = array[i-1];
		        }
				((DefaultTableModel) model).addRow(ligne);
	        }
		      }
		    Table.setModel(model);
		    stmt.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	public static void DeleteRes(long nofacture,String email)
	{
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("delete from reservation where nofacture=? and mail=?;"))
		{
			stmt.setLong(1, nofacture);
			stmt.setString(2, email);
			System.out.println(email);
			System.out.println(nofacture);
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	public  static int ajouter1(String ville,String NomTer,String hrFermeture,String hrOuverture,int prix,String adress,String mail)
	{
		int c = 0;
		String sql = "INSERT INTO queue VALUES(?,?,?,?,Str_To_Date(?,'%T'),Str_To_Date(?,'%T'),?)";
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        		PreparedStatement stmt = conn.prepareStatement("select count(*) from terrain where nomTer=? and ville=?"))
        		{
        			stmt.setString(1,NomTer);
        			stmt.setString(2,ville);
        			ResultSet rs=stmt.executeQuery();
        			rs.next();
        			c=rs.getInt(1);
        			if (c==0)
        			{
	        			pstmt.setString(1,NomTer);
	        			pstmt.setString(2,ville);
	        			pstmt.setString(3,adress);
	        			pstmt.setInt(4, prix);
	        			pstmt.setString(5,hrFermeture);
	        			pstmt.setString(6,hrOuverture);
	        			pstmt.setString(7, mail);
	        			pstmt.executeUpdate();
        			}
        		}
		catch (SQLException e)
        {
			System.out.println(e);
        }
        return c;
	}
	public static void Comptes(JTable Table)
	{
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("select nom,prenom,mail,IsAdmin from profile;"))
		{
			ResultSet rs = stmt.executeQuery();
			java.sql.ResultSetMetaData metadata = rs.getMetaData();
			int nbColonnes = metadata.getColumnCount();
			String[] colonnes = new String[nbColonnes];
	        Object[] ligne = new Object[nbColonnes];
	        Object[] array1 = new Object[] {"Nom","Prenom","E-Mail","Role"};
	        for (int i1 = 1; i1 <= nbColonnes; i1++) {
				   colonnes[i1-1] = (String) array1[i1-1];
				}
			TableModel model = new DefaultTableModel(colonnes, 0);
		      while (rs.next())
		      {
		        String nom = rs.getString("nom");
		        String prenom = rs.getString("prenom");
		        String mail = rs.getString("mail");
		        int role = rs.getInt("IsAdmin");
		        String rol = null;
		        if (role==1)
		        	rol="Client";
		        if (role==2)
		        	rol="Responsable de terrain";
		        if (role==3)
		        	rol="Admin";
		        Object[] array = new Object[] {nom,prenom,mail,rol};
		        for (int i = 1; i <= nbColonnes; i++) {
		           ligne[i-1] = array[i-1];
		        }
				((DefaultTableModel) model).addRow(ligne);
		      }
		    Table.setModel(model);
		    stmt.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	public static void DeleteCompte(String email)
	{
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("delete from profile where mail=?;"))
		{
			stmt.setString(1, email);
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	public static void ModifierCompte(String email,int role)
	{
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("UPDATE profile SET IsAdmin=? WHERE mail=?;"))
		{
			stmt.setString(2, email);
			stmt.setInt(1, role);
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	public  static int ValiderTerrain(String ville,String NomTer,String hrFermeture,String hrOuverture,int prix,String adress,String mail)
	{
		int c = 0;
		String sql = "INSERT INTO terrain VALUES(?,?,?,?,Str_To_Date(?,'%T'),Str_To_Date(?,'%T'),?)";
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        		PreparedStatement stmt = conn.prepareStatement("Delete from queue where nomter=? and ville=?"))
        		{
        			pstmt.setString(1,NomTer);
        			pstmt.setString(2,ville);
        			pstmt.setString(3,adress);
        			pstmt.setInt(4, prix);
        			pstmt.setString(5,hrFermeture);
        			pstmt.setString(6,hrOuverture);
        			pstmt.setString(7, mail);
        			pstmt.executeUpdate();
        			stmt.setString(1, NomTer);
        			stmt.setString(2,ville);
        			stmt.executeUpdate();
        		}
		catch (SQLException e)
        {
			System.out.println(e);
        }
        return c;
	}
	public static void Queue(JTable Table)
	{
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("select * from queue;"))
		{
			ResultSet rs = stmt.executeQuery();
			java.sql.ResultSetMetaData metadata = rs.getMetaData();
			int nbColonnes = metadata.getColumnCount();
			String[] colonnes = new String[nbColonnes];
	        Object[] ligne = new Object[nbColonnes];
	        Object[] array1 = new Object[] {"Nom de Terrain","La Ville","L'Adress","Heure D'Ouverture","Heure De Fermeture","Prix","mail"};
	        for (int i1 = 1; i1 <= nbColonnes; i1++) {
				   colonnes[i1-1] = (String) array1[i1-1];
				}
			int c=0;
			TableModel model = new DefaultTableModel(colonnes, 0);
		      while (rs.next())
		      {
		        String nomTer = rs.getString("nomTer");
		        String ville = rs.getString("ville");
		        String adress = rs.getString("adress");
		        int prix = rs.getInt("prix");
		        String px = Integer.toString(prix);
		        Time hrOuverture = rs.getTime("hrOuverture");
		        String hro=hrOuverture.toString();
		        Time hrFermeture = rs.getTime("hrFermeture");
		        String hrf=hrFermeture.toString();
		        String mail= rs.getString("mail");
		        Object[] array = new Object[] {nomTer,ville,adress,hro,hrf,px,mail};
		        for (int i = 1; i <= nbColonnes; i++) {
		           ligne[i-1] = array[i-1];
		        }
				((DefaultTableModel) model).addRow(ligne);
		      }
		    Table.setModel(model);
		    stmt.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	public  static void supprimer(String ville,String NomTer)
	{
        try (Connection conn = connect();
        		PreparedStatement stmt = conn.prepareStatement("Delete from queue where nomter=? and ville=?"))
        		{
        			stmt.setString(1, NomTer);
        			stmt.setString(2,ville);
        			stmt.executeUpdate();
        		}
		catch (SQLException e)
        {
			System.out.println(e);
        }
	}
	public static void MesTerrains(JTable Table,String mail)
	{
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("select nomter,ville,adress,prix,hrouverture,hrfermeture from terrain where mail=?;"))
		{
			stmt.setString(1, mail);
			ResultSet rs = stmt.executeQuery();
			java.sql.ResultSetMetaData metadata = rs.getMetaData();
			int nbColonnes = metadata.getColumnCount();
			String[] colonnes = new String[nbColonnes];
	        Object[] ligne = new Object[nbColonnes];
	        Object[] array1 = new Object[] {"Nom de Terrain","La Ville","L'Adress","Heure D'Ouverture","Heure De Fermeture","Prix"};
	        for (int i1 = 1; i1 <= nbColonnes; i1++) {
				   colonnes[i1-1] = (String) array1[i1-1];
				}
			int c=0;
			TableModel model = new DefaultTableModel(colonnes, 0);
		      while (rs.next())
		      {
		        String nomTer = rs.getString("nomTer");
		        String ville = rs.getString("ville");
		        String adress = rs.getString("adress");
		        int prix = rs.getInt("prix");
		        String px = Integer.toString(prix);
		        Time hrOuverture = rs.getTime("hrOuverture");
		        String hro=hrOuverture.toString();
		        Time hrFermeture = rs.getTime("hrFermeture");
		        String hrf=hrFermeture.toString();
		        Object[] array = new Object[] {nomTer,ville,adress,hro,hrf,px,mail};
		        for (int i = 1; i <= nbColonnes; i++) {
		           ligne[i-1] = array[i-1];
		        }
				((DefaultTableModel) model).addRow(ligne);
		      }
		    Table.setModel(model);
		    stmt.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	public static void ModifierTerrain(int prx,String nomter,String ville,String hro,String hrf)
	{
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("UPDATE terrain SET prix=? , hrouverture=STR_TO_DATE(?,'%T') , hrfermeture=STR_TO_DATE(?,'%T') WHERE nomter=? and ville=?;"))
		{
			stmt.setInt(1, prx);
			stmt.setString(4, nomter);
			stmt.setString(5, ville);
			stmt.setString(2, hro);
			stmt.setString(3, hrf);
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	public static void reservations(JTable Table)
	{
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("select nomter,ville,datematch,heure,nofacture,mail from reservation;"))
		{
			ResultSet rs = stmt.executeQuery();
			java.sql.ResultSetMetaData metadata = rs.getMetaData();
			int nbColonnes = metadata.getColumnCount();
			String[] colonnes = new String[nbColonnes];
	        String[] array1 = new String[] {"Nom de Terrain","La Ville","Date de Match","Heure de Match","nofacture","Nom Complet"};
			for (int i1 = 1; i1 <= nbColonnes; i1++) {
			   colonnes[i1-1] = array1[i1-1];
			}
	        Object[] ligne = new Object[nbColonnes];

			TableModel model = new DefaultTableModel(colonnes, 0);
		      while (rs.next())
		      {
		    	  String mail=rs.getString("mail");
		    	  String nomTer = rs.getString("nomTer");
			        String ville = rs.getString("ville");
			        long nofactur = rs.getLong("nofacture");
			        String no = Long.toString(nofactur);
			        Time heure = rs.getTime("heure");
			        Date date = rs.getDate("datematch");
			        String DateM = date.toString();
			        String hro=heure.toString();
		        Object[] array = new Object[] {nomTer,ville,DateM,hro,no,Terrain.user(mail)};
		        LocalDateTime now = LocalDateTime.now();
		        DateFormat df = DateFormat.getDateInstance();
		        String str = df.format(date);
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
        		LocalDate Date1 = LocalDate.parse(str, formatter);
        		int h=heure.getHours();
        		int m=heure.getMinutes();
        		LocalTime time=LocalTime.of(h,m);
        		LocalDateTime date2=Date1.atTime(time);
        		System.out.println(date2);
	        if (now.isBefore(date2))
	        {
		        for (int i = 1; i <= nbColonnes; i++) {
		           ligne[i-1] = array[i-1];
		        }
				((DefaultTableModel) model).addRow(ligne);
	        }
		      }
		    Table.setModel(model);
		    stmt.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	public static void res(String email,JTable Table)
	{
		try (Connection conn=connect();
				PreparedStatement stmt=conn.prepareStatement("select nomter,ville,datematch,heure,mail,nofacture from reservation where nomter in (select nomter from terrain where mail=?);"))
		{
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			java.sql.ResultSetMetaData metadata = rs.getMetaData();
			int nbColonnes = metadata.getColumnCount();
			String[] colonnes = new String[nbColonnes];
	        String[] array1 = new String[] {"Nom de Terrain","La Ville","Date de Match","Heure de Match","nofacture","Nom Complet"};
			for (int i1 = 1; i1 <= nbColonnes; i1++) {
			   colonnes[i1-1] = array1[i1-1];
			}
	        Object[] ligne = new Object[nbColonnes];

			TableModel model = new DefaultTableModel(colonnes, 0);
		      while (rs.next())
		      {
		    	  String mail=rs.getString("mail");
		    	  String nomTer = rs.getString("nomTer");
			        String ville = rs.getString("ville");
			        long nofactur = rs.getLong("nofacture");
			        String no = Long.toString(nofactur);
			        Time heure = rs.getTime("heure");
			        Date date = rs.getDate("datematch");
			        String DateM = date.toString();
			        String hro=heure.toString();
		        Object[] array = new Object[] {nomTer,ville,DateM,hro,no,Terrain.user(mail)};
		        LocalDateTime now = LocalDateTime.now();
		        DateFormat df = DateFormat.getDateInstance();
		        String str = df.format(date);
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
        		LocalDate Date1 = LocalDate.parse(str, formatter);
        		int h=heure.getHours();
        		int m=heure.getMinutes();
        		LocalTime time=LocalTime.of(h,m);
        		LocalDateTime date2=Date1.atTime(time);
        		System.out.println(date2);
	        if (now.isBefore(date2))
	        {
		        for (int i = 1; i <= nbColonnes; i++) {
		           ligne[i-1] = array[i-1];
		        }
				((DefaultTableModel) model).addRow(ligne);
	        }
		    }
		    Table.setModel(model);
		    stmt.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
}