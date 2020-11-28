import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class SalonCosmetice1 {

	   private static JFrame frmMenu = new JFrame();
	    private static JPanel title_panel = new JPanel();
	    private static JLabel textfield_tittle = new JLabel() ;


	    private static JPanel button_panel = new JPanel();
	    private static JButton buttonAdaugare = new JButton();
	    private static JButton buttonStergere = new JButton();
	    private static JButton buttonTotal = new JButton();
	    private static JButton buttonCautaAngajatClient = new JButton();
	    private static JButton buttonCautaClient= new JButton();
	    

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public SalonCosmetice1(Connection con) {
		initialize(con);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Connection con) {
        frmMenu.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\menu.png"));
        frmMenu.setTitle("MENU");
		//----FRAME---------
        frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMenu.setSize(800,800);
        frmMenu.getContentPane().setBackground(new Color(50, 50, 50));      //lighter shade of black cu RGB values
        frmMenu.getContentPane().setLayout(new BorderLayout());
        frmMenu.setVisible(true);

        //-----TextField------
        textfield_tittle.setBackground(new Color(248, 248, 255));
        textfield_tittle.setForeground(new Color(128, 128, 128));
        textfield_tittle.setFont(new Font("Chiller", Font.BOLD, 75));
        textfield_tittle.setHorizontalAlignment(JLabel.CENTER);
        textfield_tittle.setText("Pagina principala");
        textfield_tittle.setOpaque(true);


        //------TitlePanel-------
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0 , 800, 100);
        title_panel.add(textfield_tittle);
        button_panel.setBackground(new Color(240, 248, 255));


        //---------buton pannel--------
        button_panel.setLayout(null);
        button_panel.setBounds(0 , 180 , 800 , 700);


        
        //----------------------------BUTOANEEEEE------------------------------------

        //-----buton 1------------------
        
        ImageIcon loginImage = new ImageIcon("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\FCT1.png") ;
        buttonAdaugare = new JButton("" ,loginImage);
        
      //  buttonAdaugare = new JButton("Adauga Programare");
        buttonAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI_Adaugare1 a = new GUI_Adaugare1(con);
               // a.setVisible(true);
            }
        }); 

        buttonAdaugare.setBounds(22,83,200,180);

        button_panel.add(buttonAdaugare) ;

        //-------BUTON 2------------
        
        ImageIcon loginImage1 = new ImageIcon("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\fct2.png") ;
        buttonStergere = new JButton("" ,loginImage1);
        
       
        buttonStergere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI_Stergere c = new GUI_Stergere(con);
               // a.setVisible(true);
            }
        }); 
        buttonStergere.setBounds(291,83,200,180);

        button_panel.add(buttonStergere) ;


        //-------buton 3------------
        ImageIcon loginImage2 = new ImageIcon("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\fct3.png") ;
        buttonTotal = new JButton("" ,loginImage2);
        
        
        
        buttonTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI_ProgramariZi c = new GUI_ProgramariZi(con);
               // a.setVisible(true);
            }
        });
     
        
        buttonTotal.setBounds(559,83,200,180);

        button_panel.add(buttonTotal) ;

        //-------buton 4------------
        
        ImageIcon loginImage3 = new ImageIcon("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\fct4.png") ;
        buttonCautaAngajatClient = new JButton("" ,loginImage3);
        
        
        
        buttonCautaAngajatClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI_Cautare c = new GUI_Cautare(con);
               // a.setVisible(true);
            }
        });
        buttonCautaAngajatClient.setBounds(22,348,200,180);

        button_panel.add(buttonCautaAngajatClient) ;


        //-------buton 5------------
        ImageIcon loginImage4 = new ImageIcon("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\fct5.png") ;
        buttonCautaClient = new JButton("" ,loginImage4);
        
       
        buttonCautaClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI_ListareClienti c = new GUI_ListareClienti(con);
               // a.setVisible(true);
            }
        });
        buttonCautaClient.setBounds(559,348,200,180);

        button_panel.add(buttonCautaClient) ;
       
        
        //------------------buton 6 ----------------
        
        ImageIcon loginImage5 = new ImageIcon("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\others.png") ;
       
        JButton btnNewButton = new JButton("" ,loginImage5);
        
        
        btnNewButton.addActionListener(new ActionListener() {  
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		 GUI_FunctJoin c = new  GUI_FunctJoin(con) ;
        		
        		 
        		
        		
        		
        	
        	}
        });
       
        
        
        
        
        btnNewButton.setBounds(291, 348, 200, 180);
        button_panel.add(btnNewButton);
        
        //----------buton 7 ------------------
        
        ImageIcon loginImage7 = new ImageIcon("C:\\Users\\Laurentiu\\eclipse-workspace\\BazaDeDate_Eclipse\\src\\update.png") ;
        JButton   buton7 = new JButton("" ,loginImage7);
        
        buton7.setBounds(291, 570, 200, 69);
        
        
        buton7.addActionListener(new ActionListener() {  
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		 GUI_Update c = new  GUI_Update(con) ;
        				
        	
        	}
        });
        
        button_panel.add(buton7);

        frmMenu.getContentPane().add(title_panel, BorderLayout.NORTH);            // title_panel ramane blocat sus

        frmMenu.getContentPane().add(button_panel);
       
        
        
        
        
       

    }
	}




