package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner; // import the Scanner class 

import com.revature.services.CLI_Menu_Service;
import com.revature.utilities.Connection_Factory_Utility;

public class Launcher {
	public static void main(String[] args) throws SQLException {
		User_Controller uc = new User_Controller();
		Reimbursement_Controller rc = new Reimbursement_Controller();
		
		
	//Testing Database Connectivity - just testing whether our Connection (from ConnectionFactory) is successful
			try(Connection conn = Connection_Factory_Utility.getConnection()){
				System.out.println("Connection Successful :)");
			} catch(SQLException e) {
				System.out.println("Connection failed");
				e.printStackTrace();
			}	
	}
	
	
	//CLI Menu is the Command Line Interface Menu for the 
		//initialize a new CLI Menu Service 
	      public static void main(String[] args) {
	        CLI_Menu_Service options = new CLI_Menu_Service();
	        options.displayMenu();
//	        options.loginMenu();
//	        options.registerMenu();
	      }
}

