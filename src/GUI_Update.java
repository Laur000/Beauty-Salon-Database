import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;

public class GUI_Update {

	private JFrame frmUpdate;
	private JTextField T_Nume;
	private JTextField T_Prenume;
	private JTextField T_Email;
	private JTextField T_NrTel;
	private JTextField T_Data;
	private JTextField T_Ora;
	private JTextField T_DataN;
	private JTextField T_OraN;

	
	public GUI_Update(Connection con) {
		initialize(con);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Connection con) {
		frmUpdate = new JFrame();
		frmUpdate.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\others1.png"));
		frmUpdate.setTitle("UPDATE");
		frmUpdate.setBounds(100, 100, 560, 417);
		
		frmUpdate.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(219, 112, 147));
		frmUpdate.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE CLIENT");
		lblNewLabel.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		lblNewLabel.setBounds(37, 21, 145, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UPDATE PROGRAMARE");
		lblNewLabel_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		lblNewLabel_1.setBounds(321, 21, 197, 14);
		panel.add(lblNewLabel_1);
		
		T_Nume = new JTextField();
		T_Nume.setBounds(77, 46, 86, 20);
		panel.add(T_Nume);
		T_Nume.setColumns(10);
		
		JLabel L_Nume = new JLabel("Nume:");
		L_Nume.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		L_Nume.setBounds(10, 50, 46, 14);
		panel.add(L_Nume);
		
		T_Prenume = new JTextField();
		T_Prenume.setBounds(77, 77, 86, 20);
		panel.add(T_Prenume);
		T_Prenume.setColumns(10);
		
		JLabel L_Prenume = new JLabel("Prenume:");
		L_Prenume.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		L_Prenume.setBounds(10, 80, 57, 14);
		panel.add(L_Prenume);
		
		JLabel lblNewLabel_2 = new JLabel("DATE");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblNewLabel_2.setBounds(61, 118, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel L_Email = new JLabel("Email:");
		L_Email.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		L_Email.setBounds(10, 154, 46, 14);
		panel.add(L_Email);
		
		T_Email = new JTextField();
		T_Email.setBounds(77, 150, 86, 20);
		panel.add(T_Email);
		T_Email.setColumns(10);
		
		JLabel L_NrTel = new JLabel("Telefon:");
		L_NrTel.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		L_NrTel.setBounds(10, 193, 46, 14);
		panel.add(L_NrTel);
		
		T_NrTel = new JTextField();
		T_NrTel.setBounds(77, 189, 86, 20);
		panel.add(T_NrTel);
		T_NrTel.setColumns(10);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Data:");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		lblNewLabel_3.setBounds(321, 50, 46, 14);
		panel.add(lblNewLabel_3);
		
		T_Data = new JTextField();
		T_Data.setBounds(377, 46, 86, 20);
		panel.add(T_Data);
		T_Data.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ora:");
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		lblNewLabel_4.setBounds(321, 80, 46, 14);
		panel.add(lblNewLabel_4);
		
		T_Ora = new JTextField();
		T_Ora.setBounds(377, 77, 86, 20);
		panel.add(T_Ora);
		T_Ora.setColumns(10);
		
		JLabel mesaj = new JLabel("");
		mesaj.setForeground(new Color(0, 250, 154));
		mesaj.setFont(new Font("Sylfaen", Font.BOLD, 13));
		mesaj.setBounds(112, 321, 319, 14);
		panel.add(mesaj);
		
		JLabel lblNewLabel_6 = new JLabel("DATE NOI");
		lblNewLabel_6.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblNewLabel_6.setBounds(362, 118, 86, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("DataN:");
		lblNewLabel_7.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		lblNewLabel_7.setBounds(321, 154, 46, 14);
		panel.add(lblNewLabel_7);
		
		T_DataN = new JTextField();
		T_DataN.setBounds(377, 150, 86, 20);
		panel.add(T_DataN);
		T_DataN.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("OraN:");
		lblNewLabel_8.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		lblNewLabel_8.setBounds(321, 192, 46, 14);
		panel.add(lblNewLabel_8);
		
		T_OraN = new JTextField();
		T_OraN.setBounds(377, 189, 86, 20);
		panel.add(T_OraN);
		T_OraN.setColumns(10);
		
		JLabel mesaj2 = new JLabel("");
		mesaj2.setForeground(new Color(255, 0, 0));
		mesaj2.setFont(new Font("Sylfaen", Font.BOLD, 13));
		mesaj2.setBounds(180, 346, 167, 14);
		panel.add(mesaj2);
		
		
		JButton buton_prg = new JButton("UPDATE PROG");
		buton_prg.setBackground(new Color(255, 240, 245));
		
		buton_prg.addActionListener(new ActionListener() {  
        	
        	public void actionPerformed(ActionEvent e) {
        			try {		
        	  		
        	  		if(!T_DataN.getText().equals("")) {
        	  			if(T_OraN.getText().equals("") ) {
        	  			
        	  			mesaj.setText("");
        	  			mesaj2.setText("");
        	  			String query = "UPDATE Programari SET Data='"+ T_DataN.getText()+"' WHERE Data='" + T_Data.getText() +"' AND Ora='"+ T_Ora.getText() + "';";
        	  			
        	  			PreparedStatement st = con.prepareStatement(query) ;
        	  			
        	  			st.executeUpdate() ;
						
						
						mesaj.setText("DATA UPDATATA CU SUCCES");
						
        	  			
        	  		}
        	  		}
        	  		
        	  		 if(T_DataN.getText().equals("")   ) {
        	  			if(!T_OraN.getText().equals("")) {
        	  				
        	  				mesaj.setText("");
            	  			mesaj2.setText("");
            	  			String query = "UPDATE Programari SET Ora= '"+ T_OraN.getText()+"' WHERE Data='" + T_Data.getText() +"' AND Ora='"+ T_Ora.getText() + "';";
            	  			
            	  			PreparedStatement st = con.prepareStatement(query) ;
            	  			
            	  			st.executeUpdate() ;
    						
    						
    						mesaj.setText("ORA UPDATATA CU SUCCES");
        	  		}
        	  			}
        	  		
        	  		 if(!T_DataN.getText().equals("")  ){
        	  			if( !T_OraN.getText().equals("") ) {
        	  				mesaj.setText("");
            	  			mesaj2.setText("");
            	  			String query = "UPDATE Programari SET Data= '"+ T_DataN.getText()+"' , Ora='" +T_OraN.getText() + "' WHERE Data='" + T_Data.getText() +"' AND Ora='"+ T_Ora.getText() + "';";
            	  			
            	  			PreparedStatement st = con.prepareStatement(query) ;
            	  			
            	  			st.executeUpdate() ;
    						
    						
    						mesaj.setText("DATE PROGRAMARE UPDATATE CU SUCCES");
        	  		}
        	  			}
        	  		 if(T_DataN.getText().equals("") ) {
        	  			if( T_OraN.getText().equals("")) {
        	  			mesaj2.setText("");
        	  			mesaj2.setText("!!!! ADAUGATI DATE !!!!!");
        	  			
        	  		}
        	  		}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
        		
            
           }    	
        });
		
		
		buton_prg.setBounds(279, 237, 124, 62);
		panel.add(buton_prg);
		
		
		JButton buton_client = new JButton("UPDATE CLIENT");
		buton_client.setBackground(new Color(255, 240, 245));
		
		buton_client.addActionListener(new ActionListener() {  
        	
        	public void actionPerformed(ActionEvent e) {
        
        	  	try {		
        	  		
        	  		if(!T_Email.getText().equals("")) {
        	  			if(T_NrTel.getText().equals("") ) {
        	  			
        	  			mesaj.setText("");
        	  			mesaj2.setText("");
        	  			String query = "UPDATE Clienti SET Email= '"+ T_Email.getText()+"' WHERE Nume='" + T_Nume.getText() +"' AND Prenume='"+ T_Prenume.getText() + "';";
        	  			
        	  			PreparedStatement st = con.prepareStatement(query) ;
        	  			
        	  			st.executeUpdate() ;
						
						
						mesaj.setText("EMAIL UPDATAT CU SUCCES");
						
        	  			
        	  		}
        	  		}
        	  		
        	  		 if(T_Email.getText().equals("")   ) {
        	  			if(!T_NrTel.getText().equals("")) {
        	  			mesaj.setText("");
        	  			mesaj2.setText("");
        	  			String query = "UPDATE Clienti SET Nr_tel= '"+ T_NrTel.getText()+"' WHERE Nume='" + T_Nume.getText() +"' AND Prenume='"+ T_Prenume.getText() + "';";
        	  			
        	  			PreparedStatement st = con.prepareStatement(query) ;
        	  			
        	  			st.executeUpdate() ;
        	  			
						mesaj.setText("NR DE TELEFON UPDATAT CU SUCCES");
        	  		}
        	  			}
        	  		
        	  		 if(!T_Email.getText().equals("")  ){
        	  			if( !T_NrTel.getText().equals("") ) {
        	  			mesaj2.setText("");
        	  			mesaj.setText("");
        	  			
        	  			String query = "UPDATE Clienti SET Nr_tel= '"+ T_NrTel.getText()+"' , Email = '" + T_Email.getText() + "' WHERE Nume='" + T_Nume.getText() +"' AND Prenume='"+ T_Prenume.getText() + "';";
        	  			
        	  			PreparedStatement st = con.prepareStatement(query) ;
        	  			
        	  			st.executeUpdate() ;
						mesaj.setText("DATE CLIENT UPDATATE CU SUCCES");
        	  		}
        	  			}
        	  		 if(T_Email.getText().equals("") ) {
        	  			if( T_NrTel.getText().equals("")) {
        	  			mesaj2.setText("");
        	  			mesaj2.setText("!!!! ADAUGATI DATE !!!!!");
        	  			
        	  		}
        	  		}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
            



           }    	
        });
		
		
		buton_client.setBounds(112, 237, 131, 62);
		panel.add(buton_client);
		
		
		
		
		
		
		
		
		
		
		
	}
}
