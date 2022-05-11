package Service;

import java.util.*;
import java.util.Scanner; // import the Scanner class
import Models.Roles;


public class CLI_Menu_Service {

	//CLI Menu is the Command Line Interface Menu for the 
		//initialize a new CLI Menu Service 
	      public static void main(String[] args) {
	        Scanner cliMenu1 = new Scanner(System.in);
	        private int validEntries;	        
	        private int firstChoice;
	        
	       
public void displayMenu() {
	boolean menuOptions = true; //Using this to let the menu continue after user input
	
	//Greetings for the user
	System.out.println("-------------------------------------------------------");
	System.out.println("Welcome to the Revature Reimbursement System");
	System.out.println("--------------------------------------------===========");
	System.out.println();
	
	
	//display the menu as long as the menuOptions boolean == true
	//display all my menu options until boolean == false
	while (menuOptions) {
		// menu options
		System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
		System.out.println("1 -> Employee Portal");
		System.out.println("2 -> Finance Manager Portal");
		System.out.println("0 -> Exit Application");
		
		// The user chooses a menu option and the scanner takes the input and put it into an int variable
		// Calls the promptSelection() helper method to handle validation
		// The parameteres list the valid options that the user must choose from  
		int firstChoice = promptSelection(validEntries:  1, 2, 0);
		
		
		// Takes the user input and the switch statement executes the appropriate code
		switch (firstChoice) {
		
		// A break in each case block so that the other cases will not run 
		case 1:   
			handlePortal(Roles.Employee);
			break;
		case 2:   
			handlePortal(Roles.Manager);
			break; 
		case 0:   
			System.out.println("\nHave a great day! Goodbye.");
			menuOptions = false;
			break;
			
		}
		
	}//end of while loop
}
	      }
	      

			
