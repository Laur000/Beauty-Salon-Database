import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Toolkit;

public class GUI_Stergere {

	public static JFrame frmStergere;
	public static JTextField T_IdProg;
	private JTextField L_Nume;
	private JTextField L_Prenume;


	GUI_Stergere(Connection con){
		frmStergere = new JFrame();
		frmStergere.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\search.png"));
		frmStergere.setTitle("STERGERE CLIENTI/PROGRAMARE");
		frmStergere.setResizable(false);
		frmStergere.setBounds(100, 100, 669, 492);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		frmStergere.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NrProgramare:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setBounds(10, 25, 82, 14);
		panel.add(lblNewLabel);
		
		T_IdProg = new JTextField();
		T_IdProg.setBounds(98, 23, 65, 20);
		panel.add(T_IdProg);
		T_IdProg.setColumns(10);
		
		JButton buton_Programare = new JButton("STERGE PROGRAMARE");
		buton_Programare.setBackground(new Color(248, 248, 255));
		buton_Programare.setFont(new Font("Yu Gothic Light", Font.BOLD, 10));
		buton_Programare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "DELETE FROM Programari WHERE ProgramareID = " + T_IdProg.getText() + ";" ;
				
				
				try {
					
					PreparedStatement stmt = con.prepareStatement(query) ;
					stmt.executeUpdate() ;		
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		
		
		
		buton_Programare.setBounds(21, 243, 164, 43);
		panel.add(buton_Programare);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(206, 11, 447, 441);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(230, 230, 250));
		scrollPane.setViewportView(textArea);
		
		 
		 JButton buton_Client = new JButton("STERGE CLIENT");
		 buton_Client.setBackground(new Color(248, 248, 255));
		 buton_Client.setFont(new Font("Yu Gothic Light", Font.BOLD, 11));
		 
		 buton_Client.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String query = "DELETE FROM Clienti WHERE Nume ='" + L_Nume.getText() + "' AND Prenume ='" + L_Prenume.getText() + " ' ;" ;	
					try {
						
						PreparedStatement stmt = con.prepareStatement(query) ;
						stmt.executeUpdate() ;	
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				   }
			});
		 
		 
		 buton_Client.setBounds(21, 297, 164, 42);
		 panel.add(buton_Client);
		 
		 JLabel lblNewLabel_2 = new JLabel("DATE CLIENT:");
		 lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		 lblNewLabel_2.setForeground(Color.GRAY);
		 lblNewLabel_2.setBackground(Color.WHITE);
		 lblNewLabel_2.setBounds(10, 51, 82, 14);
		 panel.add(lblNewLabel_2);
		 
		 JLabel lblNewLabel_3 = new JLabel("Nume:");
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 13));
		 lblNewLabel_3.setBounds(10, 76, 46, 14);
		 panel.add(lblNewLabel_3);
		 
		 JLabel lblNewLabel_4 = new JLabel("Prenume:");
		 lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 13));
		 lblNewLabel_4.setBounds(10, 101, 57, 14);
		 panel.add(lblNewLabel_4);
		 
		 L_Nume = new JTextField();
		 L_Nume.setBounds(77, 73, 86, 20);
		 panel.add(L_Nume);
		 L_Nume.setColumns(10);
		 
		 L_Prenume = new JTextField();
		 L_Prenume.setBounds(77, 98, 86, 20);
		 panel.add(L_Prenume);
		 L_Prenume.setColumns(10);
		 
		 JRadioButton rdbtn_Clienti = new JRadioButton("Clienti");
		 rdbtn_Clienti.setForeground(new Color(105, 105, 105));
		 rdbtn_Clienti.setBackground(new Color(255, 240, 245));
		 rdbtn_Clienti.setFont(new Font("Tahoma", Font.ITALIC, 11));
		 rdbtn_Clienti.setBounds(31, 137, 109, 23);
		 panel.add(rdbtn_Clienti);
		 
		 JRadioButton rdbtn_Programari = new JRadioButton("Programari");
		 rdbtn_Programari.setForeground(new Color(105, 105, 105));
		 rdbtn_Programari.setBackground(new Color(255, 240, 245));
		 rdbtn_Programari.setFont(new Font("Tahoma", Font.ITALIC, 11));
		 rdbtn_Programari.setBounds(31, 163, 109, 23);
		 panel.add(rdbtn_Programari);
		 
		
		 
	
		 JButton  buton_Afisare = new JButton("AFISEAZA" );
		 buton_Afisare.setBackground(new Color(248, 248, 255));
		 buton_Afisare.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 11));
		 
		 buton_Afisare.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	               
	            	String query = "SELECT * FROM Programari" ;
	            	String query1 = "SELECT * FROM Clienti" ;
	            	
	            	try {		
						textArea.setText("");
							
						
						if(rdbtn_Programari.isSelected()) {
							if(!rdbtn_Clienti.isSelected()) {
								Statement st = con.createStatement() ;
								ResultSet rs = st.executeQuery(query) ;
								
						while(rs.next()) {
							int id_Programare = rs.getInt("ProgramareID");
							int id_Tip = rs.getInt("TipID");
							int id_Angajat = rs.getInt("AngajatID");
							int id_Client = rs.getInt("ClientiID");
							int id_Locatie = rs.getInt("LocatieID");
							String ora = rs.getString("Ora");
							Date data_pr = rs.getDate("Data") ;
								//textField_Lista.setText("ProgramareID" + );
								textArea.append("ProgramareID: " + id_Programare +"\nTipID:  " + id_Tip + "\nAngajatID: " + id_Angajat +"\nClientID: " + id_Client + "\nLocatieID: "  + id_Locatie + "\nOra: " + ora + "\nData: " + data_pr + "\n------------------------\n" );
		
						}															
					}
							rdbtn_Programari.doClick(); 
				}
						
						else if(rdbtn_Clienti.isSelected()) {
							if(!rdbtn_Programari.isSelected()) {
								Statement st = con.createStatement() ;
								ResultSet rs = st.executeQuery(query1) ;
						while(rs.next()) {
							
							int id_Clienti = rs.getInt("ClientiID");
							int id_Angajat = rs.getInt("AngajatID");
							String Nume = rs.getString("Nume");
							String Prenume = rs.getString("Prenume");
							String Nr_tel = rs.getString("Nr_tel");
							String Email = rs.getString("Email");	
								//textField_Lista.setText("ProgramareID" + );
								textArea.append("ClientiID: " + id_Clienti +"\nAngajatID:  " + id_Angajat + "\nNume: " + Nume +"\nPrenume: " + Prenume + "\nNr_tel: "  + Nr_tel + "\nEmail: " + Email + "\n------------------------\n" );				
						}															
					}
							rdbtn_Clienti.doClick(); 
				}
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 	            	
	            }
	        }); 
		 buton_Afisare.setBounds(21, 193, 164, 39);
		 panel.add(buton_Afisare);
		 
		 
		 
		 
		 
		 

			
			frmStergere.getContentPane().add(panel);
	        frmStergere.setVisible(true);
	}
}
