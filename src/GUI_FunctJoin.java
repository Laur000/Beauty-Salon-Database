import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Toolkit;

public class GUI_FunctJoin {

	private JFrame frmAltele;

	public GUI_FunctJoin(Connection con) {
		initialize(con);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Connection con) {
		frmAltele = new JFrame();
		frmAltele.setTitle("ALTELE");
		frmAltele.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\others1.png"));
		frmAltele.setBounds(100, 100, 874, 659);
	
		frmAltele.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		frmAltele.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JRadioButton fct1 = new JRadioButton("NUMARUL DE CLIENTI ALOCATI FIECARUI ANGAJAT LA TOATE PROGRAMRILE FACUTE");
		fct1.setBackground(new Color(47, 79, 79));
		fct1.setForeground(new Color(60, 179, 113));
		fct1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		fct1.setBounds(16, 29, 509, 23);
		panel.add(fct1);
		
		JRadioButton fct2 = new JRadioButton("PROGRAMARI ALOCATE PE FIECARE LOCATIE");
		fct2.setBackground(new Color(47, 79, 79));
		fct2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		fct2.setForeground(new Color(60, 179, 113));
		fct2.setBounds(16, 55, 303, 23);
		panel.add(fct2);
		
		JRadioButton fct3 = new JRadioButton("ANGAJATUL CEL MAI OCUPAT");
		fct3.setBackground(new Color(47, 79, 79));
		fct3.setForeground(new Color(60, 179, 113));
		fct3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		fct3.setBounds(16, 81, 303, 23);
		panel.add(fct3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 281, 801, 328);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(60, 179, 113));
		textArea.setBackground(new Color(47, 79, 79));
		scrollPane.setViewportView(textArea);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Interogare Complexa 1");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		rdbtnNewRadioButton.setForeground(new Color(60, 179, 113));
		rdbtnNewRadioButton.setBackground(new Color(47, 79, 79));
		rdbtnNewRadioButton.setBounds(16, 107, 235, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Interogare Complexa 2");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		rdbtnNewRadioButton_1.setForeground(new Color(60, 179, 113));
		rdbtnNewRadioButton_1.setBackground(new Color(47, 79, 79));
		rdbtnNewRadioButton_1.setBounds(16, 133, 167, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Interogare Complexa 3");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		rdbtnNewRadioButton_2.setBackground(new Color(47, 79, 79));
		rdbtnNewRadioButton_2.setForeground(new Color(60, 179, 113));
		rdbtnNewRadioButton_2.setBounds(16, 159, 167, 23);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Interogare Complexa 4");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		rdbtnNewRadioButton_3.setForeground(new Color(60, 179, 113));
		rdbtnNewRadioButton_3.setBackground(new Color(47, 79, 79));
		rdbtnNewRadioButton_3.setBounds(16, 185, 167, 23);
		panel.add(rdbtnNewRadioButton_3);
		
		JButton buton = new JButton("CLICK");
		
		buton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					
					try {
						
						if(fct1.isSelected()) {
							textArea.setText("");
							
							String query = "SELECT  A.Nume, A.Prenume , COUNT(C.ClientiID) AS Nr_Clienti\r\n" + 
									"FROM Angajati A   LEFT JOIN Clienti C  ON  A.AngajatID  = C.AngajatID \r\n" + 
									"GROUP BY A.Nume, A.Prenume;" ;
							
							Statement st = con.createStatement() ;
							ResultSet rs = st.executeQuery(query) ;
							
							while(rs.next()) {
								String Nume = rs.getString("Nume");
								String Prenume = rs.getString("Prenume");
								int  Nr_Clienti = rs.getInt("Nr_Clienti");
								

								textArea.append( Nume + "\n" + Prenume +"\n" );
								textArea.append("Clienti: " + Nr_Clienti +"\n\n" );	
							}
				
							fct1.doClick();
						}
						else if(fct2.isSelected()) {
							textArea.setText("");
							
							String query = "SELECT L.Nume, COUNT(P.ProgramareID) AS Programari\r\n" + 
									"FROM  Programari P LEFT JOIN Locatii L ON P.LocatieID = L.LocatieID\r\n" + 
									"GROUP BY L.Nume;" ;
							
							Statement st = con.createStatement() ;
							ResultSet rs = st.executeQuery(query) ;
							
							while(rs.next()) {
								String Nume = rs.getString("Nume");
								
								int  Nr_Prog = rs.getInt("Programari");
								

								textArea.append( Nume + "\n" );
								textArea.append("Nr_Programari: " + Nr_Prog +"\n\n" );	
							}
							
							
							fct2.doClick();
				
						}
						
						else if(fct3.isSelected()) {
							
							textArea.setText("");
									
							String query = "SELECT TOP 1 A.Nume, A.Prenume, COUNT(C.ClientiID) AS Nr_Clienti FROM Angajati A INNER JOIN Clienti C ON C.AngajatID = A.AngajatID GROUP BY A.Nume, A.Prenume ORDER BY COUNT(C.ClientiID) DESC ; " ; 
									
							
							Statement st = con.createStatement() ;
							ResultSet rs = st.executeQuery(query) ;
							

							while(rs.next()) {
								
								String Nume = rs.getString("Nume");
								String Prenume = rs.getString("Prenume");
								int  Nr_Clienti = rs.getInt("Nr_Clienti");
								

								textArea.append( Nume + "\n" + Prenume + "\n" );
								textArea.append("Nr_Clienti: " + Nr_Clienti +"\n\n" );	
							}
							
							
							fct3.doClick();
							
							
							
						}
						
						

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				   }
			});
		
		
		
		
		
		buton.setBackground(new Color(0, 100, 0));
		buton.setBounds(596, 78, 206, 130);
		panel.add(buton);
	}
}
