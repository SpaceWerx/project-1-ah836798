package com.revature;

import java.util.Scanner; // import the Scanner class 

public class Launcher {

	//CLI Menu is the Command Line Interface Menu for the 
		//initialize a new CLI Menu Service 
	      public static void main(String[] args) {
	        Scanner cliMenu1 = new Scanner(System.in);
	        String userName;
	        
	        // Enter username and press Enter
	        
	        System.out.println("Welcome to the P1 CLI Menu ");
            System.out.println("Please enter username");
	        userName = cliMenu1.nextLine();  // Read user input
	        System.out.println("Username is: " + userName);  // Output user input
	      }
	    }