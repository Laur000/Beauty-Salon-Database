import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Toolkit;

public class GUI_Cautare {

	private JFrame frmClientangajatInFunctie;
	private JTextField T_data;
	private JTextField T_ora;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public GUI_Cautare(Connection con) {
		initialize(con);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Connection con) {
		frmClientangajatInFunctie = new JFrame();
		frmClientangajatInFunctie.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\cautare.png"));
		frmClientangajatInFunctie.setTitle("CLIENT/ANGAJAT IN FUNCTIE DE DATA");
		frmClientangajatInFunctie.setBounds(100, 100, 570, 373);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmClientangajatInFunctie.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ORA SI DATA PROGRAMARE:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(10, 11, 175, 14);
		panel.add(lblNewLabel);
		
		JLabel L_Data = new JLabel("Data:");
		L_Data.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		L_Data.setBounds(10, 35, 46, 14);
		panel.add(L_Data);
		
		JLabel L_ora = new JLabel("Ora:");
		L_ora.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		L_ora.setBounds(10, 68, 46, 14);
		panel.add(L_ora);
		
		T_data = new JTextField();
		T_data.setBounds(76, 32, 86, 20);
		panel.add(T_data);
		T_data.setColumns(10);
		
		T_ora = new JTextField();
		T_ora.setForeground(Color.BLACK);
		T_ora.setBounds(76, 65, 86, 20);
		panel.add(T_ora);
		T_ora.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(224, 11, 320, 312);
		panel.add(scrollPane);
		
		
		 JLabel atentie = new JLabel("");
		 atentie.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		 atentie.setForeground(Color.RED);
		 atentie.setBounds(59, 93, 137, 14);
		 panel.add(atentie);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setForeground(Color.BLACK);
		scrollPane.setViewportView(textArea);
		
		JButton buton_Angajat = new JButton("Angajat");
		buton_Angajat.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		buton_Angajat.setBackground(Color.PINK);
		buton_Angajat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT A.Nume, A.Prenume FROM Angajati A INNER JOIN Programari P ON A.AngajatID = P.AngajatID WHERE P.Ora ='" + T_ora.getText() + "' AND P.Data ='" + T_data.getText() + "' ;"  ;	
				
				try {
					
					Statement st = con.createStatement()  ;
					
					ResultSet rs = st.executeQuery(query) ;
											
				
					textArea.setText("");
					
					
					if(T_ora.getText().equals("") && T_data.getText().equals("")) {
						
						atentie.setText("  !!! ADAUGA DATE !!!");
						
					}
					else {
					
					while(rs.next()) {
						atentie.setText("");
						String Nume = rs.getString("Nume");
						String Prenume = rs.getString("Prenume");
					
						
							
							textArea.append("ANGAJATI:\n" + Nume + "\n"  + Prenume + "\n-----------\n" );
	
					}
					}
					
					
					
					
						
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		
		
		
		buton_Angajat.setBounds(42, 112, 86, 52);
		panel.add(buton_Angajat);
		
		
		//-------------BUTONUL PENTRU AFISAREA CLIENTILOR CARE AU O ANUMITA PROGRAMARE, UN QUERY SIMPLU DE TIP JOIN-------------------
		
		JButton buton_Client = new JButton("Client");
		buton_Client.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		buton_Client.setBackground(Color.PINK);
		
		buton_Client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT C.Nume, C.Prenume, C.Nr_tel FROM Clienti C INNER JOIN Programari P ON C.ClientiID = P.ClientiID WHERE P.Ora ='" + T_ora.getText() + "' AND P.Data ='" + T_data.getText() + "' ;"  ;	
				
				try {
					
					Statement st = con.createStatement()  ;
					ResultSet rs = st.executeQuery(query) ;
											
				
					
				
					textArea.setText("");
					
					if(T_ora.getText().equals("") && T_data.getText().equals("")) {
						
						atentie.setText("  !!! ADAUGA DATE !!!");
						
					}
					
					else {
					while(rs.next()) {
						atentie.setText("");
						String Nume = rs.getString("Nume");
						String Prenume = rs.getString("Prenume");
						String Nr_tel = rs.getString("Nr_tel");
					
						
							
							textArea.append( "CLIENTI:\n" + Nume + "\n"  + Prenume + "\n" + Nr_tel + "\n-----------\n" );
	
					}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		buton_Client.setBounds(42, 175, 86, 52);
		panel.add(buton_Client);
		
		//-----------butonul pentru afisarea amandurora, cu doua queryuri de tip join --------------------------
		
		
		JButton buton_Amandoi = new JButton("Amandoi");
		buton_Amandoi.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		buton_Amandoi.setBackground(Color.PINK);
		
		buton_Amandoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT C.Nume, C.Prenume, C.Nr_tel FROM Clienti C INNER JOIN Programari P ON C.ClientiID = P.ClientiID WHERE P.Ora ='" + T_ora.getText() + "' AND P.Data ='" + T_data.getText() + "' ;"  ;	
				String query1 = "SELECT A.Nume, A.Prenume FROM Angajati A INNER JOIN Programari P ON A.AngajatID = P.AngajatID WHERE P.Ora ='" + T_ora.getText() + "' AND P.Data ='" + T_data.getText() + "' ;"  ;
				try {
					
					Statement st = con.createStatement()  ;
					ResultSet rs = st.executeQuery(query) ;
											
					Statement st1 = con.createStatement()  ;
					ResultSet rs1 = st1.executeQuery(query1) ;
											
					
				
					textArea.setText("");
					
					if(T_ora.getText().equals("") && T_data.getText().equals("")) {
						
						atentie.setText("  !!! ADAUGA DATE !!!");
						
					}
					else {
					
						atentie.setText("");	
					textArea.append("CLIENTI:\n");
					while(rs.next()) {
						String Nume = rs.getString("Nume");
						String Prenume = rs.getString("Prenume");
						String Nr_tel = rs.getString("Nr_tel");
						
						textArea.append( Nume + "\n"  + Prenume  + "\n" + Nr_tel+"\n-----------\n" );
	
					}	
					
					
					
					textArea.append("ANGAJATI:\n");
					while(rs1.next()) {
						String Nume = rs1.getString("Nume");
						String Prenume = rs1.getString("Prenume");
						
						textArea.append(Nume + "\n"  + Prenume +  "\n-----------\n" );
	
					}
					
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		
		
		buton_Amandoi.setBounds(42, 238, 86, 52);
		panel.add(buton_Amandoi);
		
		
		
		

		 frmClientangajatInFunctie.getContentPane().add(panel);
		 
		
	        frmClientangajatInFunctie.setVisible(true);
	}

}
