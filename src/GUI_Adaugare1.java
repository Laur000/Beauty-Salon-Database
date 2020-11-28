import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Toolkit;

public class GUI_Adaugare1 {

	 private static JFrame frmAdaugari = new JFrame();
	    private static JPanel contentPanel = new JPanel();
	    private static JLabel Date_Client ;
	    private static JLabel Date_Programare ;
	    private static JLabel Date_Angajat ;
	    private static JTextField T_numeClient;
	    private static JLabel L_numeClient;
	    private static JTextField T_prenumeClient;
	    private static JLabel L_prenumeClient;
	    private static JTextField T_telefon;
	    private static JLabel L_telefon;
	    private static JTextField T_email;
	    private static JLabel L_email;
	    private static JTextField T_ora;
	    private static JLabel L_ora;
	    private static JTextField T_data;
	    private static JLabel L_data;
	    private static JTextField T_numeAngajat;
	    private static JLabel L_numeAngajat;
	    private static JButton Buton_Adaugare;
	    private static JLabel L_serviciu;
	    private static JTextField T_numeServiciu;
	    private static JLabel L_numeServiciu;
	    private JTextField T_Locatie;
	    private JLabel L_Locatie;
	    private JButton buton_Client;
	   
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public GUI_Adaugare1(Connection con) {
		initialize(con);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Connection con) {
        frmAdaugari.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\find.png"));
        frmAdaugari.setTitle("ADAUGARI");
   //----FRAME---------
        
        frmAdaugari.setSize(500,442);
        frmAdaugari.getContentPane().setBackground(new Color(50, 50, 50));      //lighter shade of black cu RGB values
        frmAdaugari.getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(null);

        //------DATE CLIENT------------
        Date_Client = new JLabel("DATE CLIENT:");
        Date_Client.setBounds(20,24,100,25);
        Date_Client.setBackground(new Color(166,244,243));
        Date_Client.setForeground(new Color(125, 100, 0));
        Date_Client.setHorizontalAlignment(JLabel.CENTER);
        Date_Client.setOpaque(true);

        contentPanel.add(Date_Client) ;
        //-----------------DATE PROGRAMARE------------------------------
        Date_Programare = new JLabel("DATE PROGRAMARE:");
        Date_Programare.setBounds(299,24,120,25);
        Date_Programare.setBackground(new Color(166,244,243));
        Date_Programare.setForeground(new Color(125, 100, 0));
       
        Date_Programare.setOpaque(true);

        contentPanel.add(Date_Programare) ;
        
        //-----------------DATE ANGAJAT------------------------------
        Date_Angajat = new JLabel("ANGAJAT (*OPTIONAL*):");
        Date_Angajat.setBounds(20,178,150,25);
        Date_Angajat.setBackground(new Color(166,244,243));
        Date_Angajat.setForeground(new Color(125, 100, 0));
       
        Date_Angajat.setOpaque(true);

        contentPanel.add(Date_Angajat) ;
        
        //------Nume Client------------
        L_numeClient = new JLabel("NUME:");
        L_numeClient.setBounds(20,60,50,25);
        L_numeClient.setForeground(new Color(51,51,0));
       // L_numeClient.setHorizontalAlignment(JLabel.CENTER);
        L_numeClient.setOpaque(true);
        contentPanel.add(L_numeClient) ;

        T_numeClient = new JTextField();
        T_numeClient.setBounds(100,60,100,20);
        contentPanel.add(T_numeClient);

        //------Prenume Client------------
        L_prenumeClient = new JLabel("PRENUME:");
        L_prenumeClient.setBounds(20,80,70,25);
        L_prenumeClient.setForeground(new Color(51,51,0));
        // L_numeClient.setHorizontalAlignment(JLabel.CENTER);
        L_prenumeClient.setOpaque(true);
        contentPanel.add(L_prenumeClient) ;

        T_prenumeClient = new JTextField();
        T_prenumeClient.setBounds(100,82,100,20);
        contentPanel.add(T_prenumeClient);


        //------NR TEL------------
        L_telefon = new JLabel("TELEFON:");
        L_telefon.setBounds(20,110,70,25);
        L_telefon.setForeground(new Color(51,51,0));
        // L_numeClient.setHorizontalAlignment(JLabel.CENTER);
        L_telefon.setOpaque(true);
        contentPanel.add(L_telefon) ;

        T_telefon = new JTextField();
        T_telefon.setBounds(100,113,100,20);
        contentPanel.add(T_telefon);

        //------EMAIL------------
        L_email = new JLabel("EMAIL:");
        L_email.setBounds(20,142,70,25);
        L_email.setForeground(new Color(51,51,0));
        // L_numeClient.setHorizontalAlignment(JLabel.CENTER);
        L_email.setOpaque(true);
        contentPanel.add(L_email) ;

        T_email = new JTextField();
        T_email.setBounds(100,144,100,20);
        contentPanel.add(T_email);

        //------ORA------------
        L_ora= new JLabel("ORA:");
        L_ora.setBounds(299,60,50,25);
        L_ora.setForeground(new Color(51,51,0));
       // L_numeClient.setHorizontalAlignment(JLabel.CENTER);
        L_ora.setOpaque(true);
        contentPanel.add( L_ora) ;

        T_ora = new JTextField();
        T_ora.setBounds(350,60,100,20);
        contentPanel.add(T_ora);
        
        //------DATA------------
        L_data= new JLabel("DATA:");
        L_data.setBounds(299,80,50,25);
        L_data.setForeground(new Color(51,51,0));
       // L_numeClient.setHorizontalAlignment(JLabel.CENTER);
        L_data.setOpaque(true);
        contentPanel.add( L_data) ;

        T_data = new JTextField();
        T_data.setBounds(350,85,100,20);
        contentPanel.add(T_data);
        
        
        //------Nume Angajat------------
        L_numeAngajat = new JLabel("ID:");
        L_numeAngajat.setBounds(30,212,23,25);
        L_numeAngajat.setForeground(new Color(51,51,0));
        L_numeAngajat.setOpaque(true);
        contentPanel.add(L_numeAngajat) ;

        T_numeAngajat = new JTextField();
        T_numeAngajat.setBounds(100,214,100,20);
        contentPanel.add(T_numeAngajat);
        
        //------DATE SERVICIU------------
        L_serviciu = new JLabel("DATE SERVICIU:");
        L_serviciu.setBounds(20,240,100,25);
        L_serviciu.setBackground(new Color(166,244,243));
        L_serviciu.setForeground(new Color(125, 100, 0));
        L_serviciu.setHorizontalAlignment(JLabel.CENTER);
        L_serviciu.setOpaque(true);

        contentPanel.add(L_serviciu) ;
        
        //------Nume Serviciu------------
        L_numeServiciu = new JLabel("ID SERVICIU:");
        L_numeServiciu.setBounds(20,276,70,25);
        L_numeServiciu.setForeground(new Color(51,51,0));
        L_numeServiciu.setOpaque(true);
        contentPanel.add(L_numeServiciu) ;

        T_numeServiciu = new JTextField();
        T_numeServiciu.setBounds(100,276,100,20);
        contentPanel.add(T_numeServiciu);
        
        //----DATE LOCATIE----------------
        
        JLabel L_DateLocatie = new JLabel("DATE LOCATIE:");
        L_DateLocatie.setBounds(24, 305, 86, 20);
        L_DateLocatie.setBackground(new Color(166,244,243));
        L_DateLocatie.setForeground(new Color(125, 100, 0));
        L_DateLocatie.setOpaque(true);
        contentPanel.add(L_DateLocatie);
        
        //--------------------Locatie------------
        T_Locatie = new JTextField();
        T_Locatie.setBounds(100, 333, 100, 20);
        contentPanel.add(T_Locatie);
        T_Locatie.setColumns(10);
        
        L_Locatie = new JLabel("ID LOCATIE:");
        L_Locatie.setBounds(24, 336, 66, 14);
        contentPanel.add(L_Locatie);
        
   
        //--------BUTON CLIENT----------------------
        
        
        buton_Client = new JButton("ADAUGA CLIENT");
        buton_Client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement stmt2 = con.prepareStatement("INSERT INTO Clienti (AngajatID, Nume , Prenume , Nr_tel , Email  ) VALUES ( ?, ? , ? , ? ,?);");
				
				
					String Nume = T_numeClient.getText() ;
					String Prenume = T_prenumeClient.getText() ;
					String Telefon =T_telefon.getText();				
					String Email = T_email.getText();
					
					
					//In caz ca nu adaugam id de angajat, cum e optional, o sa adaugam un angajat
					//random din cei din tabel
					 int id_Angajat = 0 ;
					if(T_numeAngajat.getText().equals("") == false) {
					 id_Angajat = Integer.parseInt(T_numeAngajat.getText()) ;
					}
					else {
					 id_Angajat = 1 + (int)(Math.random() * 7);
					}
				
					//adaugare Clienti in tabel
					
					stmt2.setInt(1, id_Angajat );
					stmt2.setString(2, Nume);				
					stmt2.setString(3, Prenume);
					stmt2.setString(4, Telefon);
					stmt2.setString(5, Email);
				
				
					stmt2.executeUpdate() ;
				
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}              
            }
            });
            
        
        
        
        buton_Client.setBounds(299, 142, 161, 91);
        contentPanel.add(buton_Client);
        //----------------BUTONU--------------------
        Buton_Adaugare =  new JButton("ADAUGA PROGRAMARE" );
        Buton_Adaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement stmt = con.prepareStatement("INSERT INTO Programari (TipID,AngajatID, ClientiID , LocatieID , Ora , Data  ) VALUES (?, ?, ? , ? , ? ,?);");
					
					//Preluare Date
					String Nume = T_numeClient.getText() ;
					String Prenume = T_prenumeClient.getText() ;
					int id_Tip = Integer.parseInt(T_numeServiciu.getText()) ;
					int id_Locatie = Integer.parseInt(T_Locatie.getText()) ;
					String Ora = T_ora.getText() ;
					
					//aparent trebuie sa convertim java.util.Date cu java.sql.Date
					Date Data = new SimpleDateFormat("yyyy-MM-dd").parse(T_data.getText());  
					java.sql.Date Data_sql = new java.sql.Date(Data.getTime()) ;
					
					
					
					
					String query = "SELECT ClientiID,AngajatID FROM Clienti WHERE Nume ='"+ Nume + "' AND Prenume ='" + Prenume + "'" ;
					Statement st = con.createStatement() ;
					ResultSet rs = st.executeQuery(query) ;
					
					int id_Client = 0  ;
					int id_Angajat= 0 ;
					while(rs.next()) {
					
					 id_Client = rs.getInt("ClientiID"); 
					 id_Angajat = rs.getInt("AngajatID");
					
					
					}

					
					stmt.setInt(1, id_Tip);
					stmt.setInt(2, id_Angajat);
					stmt.setInt(3, id_Client);
					stmt.setInt(4, id_Locatie);
					stmt.setString(5, Ora);
					stmt.setDate(6, Data_sql);
					
					
					stmt.executeUpdate() ;

					//Resetare Date
					
					T_numeClient.setText("");
					T_prenumeClient.setText("") ;
					T_telefon.setText("");	
					T_email.setText("");
					T_numeServiciu.setText("");
					T_numeAngajat.setText("") ;
					T_Locatie.setText("");
					T_ora.setText("") ;
					T_data.setText("");
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

               
            }
        }); 
        Buton_Adaugare.setBounds(299, 268, 161, 94);
        contentPanel.add(Buton_Adaugare);



        frmAdaugari.getContentPane().add(contentPanel);
        frmAdaugari.setVisible(true);

	}
}
