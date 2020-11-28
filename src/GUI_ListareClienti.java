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
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class GUI_ListareClienti {

	private JFrame frmClientiDupaAngajat;
	private JTextField T_Nume;
	private JTextField T_Prenume;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { GUI_ListareClienti window = new
	 * GUI_ListareClienti(); window.frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public GUI_ListareClienti(Connection con) {
		initialize(con);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Connection con) {
		frmClientiDupaAngajat = new JFrame();
		frmClientiDupaAngajat.setTitle("CLIENTI DUPA ANGAJAT");
		frmClientiDupaAngajat.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\cautare.png"));
		frmClientiDupaAngajat.setBounds(100, 100, 611, 407);
		
		
		JPanel panel = new JPanel();
		
		
		panel.setBackground(new Color(240, 255, 255));
		frmClientiDupaAngajat.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lL_Nume = new JLabel("Nume:");
		lL_Nume.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		lL_Nume.setBounds(10, 46, 46, 14);
		panel.add(lL_Nume);
		
		JLabel L_Angajat = new JLabel("ANGAJAT:");
		L_Angajat.setFont(new Font("Sitka Text", Font.BOLD, 15));
		L_Angajat.setBounds(10, 17, 76, 14);
		panel.add(L_Angajat);
		
		T_Nume = new JTextField();
		T_Nume.setBounds(86, 43, 76, 20);
		panel.add(T_Nume);
		T_Nume.setColumns(10);
		
		JLabel L_Prenume = new JLabel("Prenume:");
		L_Prenume.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		L_Prenume.setBounds(10, 82, 69, 14);
		panel.add(L_Prenume);
		
		T_Prenume = new JTextField();
		T_Prenume.setBounds(86, 79, 76, 20);
		panel.add(T_Prenume);
		T_Prenume.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 35, 335, 289);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(224, 255, 255));
		scrollPane.setViewportView(textArea);
		
		 JLabel atentie = new JLabel("");
		 atentie.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		 atentie.setForeground(Color.RED);
		 atentie.setBounds(35, 298, 135, 26);
		 panel.add(atentie);
		
		//Aici afisez toti clientii care sunt programati l;a un anumit angajat
		 
		JButton buton = new JButton("cauta");
		 ImageIcon loginImage = new ImageIcon("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\click.png") ;
	        buton = new JButton("" ,loginImage);

		
		
		
		buton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String query = "SELECT C.Nume, C.Prenume FROM Clienti C INNER JOIN Angajati A ON C.AngajatID = A.AngajatID WHERE A.Nume ='" + T_Nume.getText() + "' AND A.Prenume ='" + T_Prenume.getText() + "' ;"  ;	
					try {
						
						Statement st = con.createStatement()  ;
						ResultSet rs = st.executeQuery(query) ;

						//AR TREBUII SA MEARGA
						textArea.setText("");
						
						
						
						
						if(T_Nume.getText().equals("") && T_Prenume.getText().equals("")) {
					
							atentie.setText("  !!! ADAUGA DATE !!!");
							
						}
						else {
							textArea.append("CLIENTI: \n\n");
							while(rs.next()) {
								atentie.setText("");
								
								String Nume = rs.getString("Nume");
								String Prenume = rs.getString("Prenume");		
									textArea.append( Nume + "\n"  + Prenume + "\n-----------\n" );
							}
						}
						
						
							
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				  }
			});
		 
		 
		buton.setBounds(55, 181, 98, 59);
		panel.add(buton);
		
		JLabel lblNewLabel = new JLabel("           CLIENTI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(355, 11, 115, 20);
		panel.add(lblNewLabel);
		

		 frmClientiDupaAngajat.getContentPane().add(panel);
		 
		
	        frmClientiDupaAngajat.setVisible(true);
	}
}
