package net.codejava.sql ;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Main_app {

	public static void main(String[] args) {
		String Nume = "aaaa";
		String Prenume = "bbbbbbb";
		String query = "SELECT ClientiID,AngajatID FROM Clienti WHERE Nume ='"+ Nume + "' AND Prenume ='" + Prenume + "'" ;
		
		System.out.println(query);

	}

}
