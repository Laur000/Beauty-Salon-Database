

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class GUI_ProgramariZi {

	private JFrame frmCautaProgramariDupa;
	private JTextField textField_Data;
	private JLabel lblNewLabel_2 = new JLabel("");

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { GUI_ProgramariZi window = new
	 * GUI_ProgramariZi(); window.frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public GUI_ProgramariZi(Connection con) {
		initialize(con);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Connection con) {
		frmCautaProgramariDupa = new JFrame();
		frmCautaProgramariDupa.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\cautare.png"));
		frmCautaProgramariDupa.setTitle("CAUTA PROGRAMARI DUPA ZI");
		frmCautaProgramariDupa.setBounds(100, 100, 733, 547);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 209, 204));
		frmCautaProgramariDupa.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Data:");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 11, 54, 14);
		panel.add(lblNewLabel);
		
		textField_Data = new JTextField();
		textField_Data.setBounds(67, 9, 86, 20);
		panel.add(textField_Data);
		textField_Data.setColumns(10);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(206, 51, 501, 446);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(32, 178, 170));
		scrollPane.setViewportView(textArea);
		
		
		
		JLabel lblNewLabel_Total1 = new JLabel("Total:");
		lblNewLabel_Total1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_Total1.setBounds(206, 11, 39, 14);
		panel.add(lblNewLabel_Total1);
		
		JLabel lblNewLabel_Total2 = new JLabel("");
		lblNewLabel_Total2.setBounds(248, 11, 58, 14);
		panel.add(lblNewLabel_Total2);
		
		ImageIcon loginImage = new ImageIcon("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\find.png") ;
		JButton buton = new JButton("" , loginImage );
		
		   buton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                
	            	String query = "SELECT * FROM Programari" ;
	            	int aux = 0;
	            	
	            	try {
						Statement st = con.createStatement() ;
						ResultSet rs = st.executeQuery(query) ;
						String data = textField_Data.getText() ;
						if(data.equals("")) {
							lblNewLabel_2.setText("!!!  ADAUGATI DATA !!!");
							textArea.setText("");
							
							
						}
						
						else {
							lblNewLabel_2.setText("");
							textArea.setText("");
						while(rs.next()) {
							int id_Programare = rs.getInt("ProgramareID");
							int id_Tip = rs.getInt("TipID");
							int id_Angajat = rs.getInt("AngajatID");
							int id_Client = rs.getInt("ClientiID");
							int id_Locatie = rs.getInt("LocatieID");
							String ora = rs.getString("Ora");
							Date data_pr = rs.getDate("Data") ;
							
							Date data_aux = new SimpleDateFormat("yyyy-MM-dd").parse(data);  
							
							if( data_aux.compareTo(data_pr) == 0) {
								aux++;
								//textField_Lista.setText("ProgramareID" + );
								textArea.append("ProgramareID: " + id_Programare +"\nTipID:  " + id_Tip + "\nAngajatID: " + id_Angajat +"\nClientID: " + id_Client + "\nLocatieID: "  + id_Locatie + "\nOra: " + ora + "\nData: " + data_pr + "\n-------------\n" );
								
								
							}														
						}
					}
						lblNewLabel_Total2.setText(String.valueOf(aux));
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}            		                  	
	            }
	        });
		
		buton.setBounds(49, 123, 104, 109);
		panel.add(buton);

		 frmCautaProgramariDupa.getContentPane().add(panel);
		 
		 JLabel lblNewLabel_1 = new JLabel("(yyyy-MM-dd)");
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		 lblNewLabel_1.setBounds(77, 40, 70, 14);
		 panel.add(lblNewLabel_1);
		 
		
		 lblNewLabel_2.setForeground(Color.RED);
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		 lblNewLabel_2.setBounds(36, 275, 136, 71);
		 panel.add(lblNewLabel_2);
	        frmCautaProgramariDupa.setVisible(true);
	}
}
