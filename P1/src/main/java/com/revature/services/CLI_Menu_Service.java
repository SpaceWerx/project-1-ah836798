package com.revature.services;

import java.sql.SQLException;
import java.util.*;
import java.util.List;

import java.util.Scanner; // import the Scanner class

import com.revature.models.Reimbursement;
import com.revature.models.Reimbursement_Type;
import com.revature.models.Roles;
import com.revature.models.Status;
import com.revature.models.User;


import com.revature.services.User_Service;
import com.revature.services.Reimbursement_Service;

public class CLI_Menu_Service {
	
	public static void main(String[] args) {
		
	}
	static Scanner scan = new Scanner(System.in);
	Reimbursement_Service rService = new Reimbursement_Service();
    User_Service userService = new User_Service();
	//CLI Menu is the Command Line Interface Menu for the 
		//initialize a new CLI Menu Service  
	        
//Display Main Menu Method//	       
public void displayMenu() throws SQLException {
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
		
//Scanner firstChoice = new Scanner(System.in);
		// Calls the promptSelection() helper method to handle validation
		// The parameteres list the valid options that the user must choose from  
		String firstChoice = scan.nextLine();
		
		// Takes the user input and the switch statement executes the appropriate code
		switch (firstChoice) {
		
		// A break in each case block so that the other cases will not run 
		case "1":   
			handlePortal(Roles.Employee);
			break;
		case "2":   
			handlePortal(Roles.Manager);
			break; 
		case "0":   
			System.out.println("\nHave a great day! Goodbye.");
			menuOptions = false;
			break;
		default:
			System.out.println("Invalid entry");
		}	
	}//end of while loop
}

//Display Employee Menu Method//

public void displayEmployeeMenu(User employee) throws SQLException {
	boolean employeePortal = true;
	
	System.out.println("--------------------------------------------------------");
	System.out.println("Welcome to the Employee Portal, " + employee.getUsername());
    System.out.println("--------------------------------------------------------");
    System.out.println();
    
    while (employeePortal) {
    	System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
    	System.out.println("1 -> View Previous Requests");
    	System.out.println("2 -> Submit a Reimbursement");
    	System.out.println("0 -> Return to Main Menu");
    
    	//user chooses a menu option and the scanner takes the input and put it into a int variable
    	String firstChoice = scan.nextLine();
    	
    	switch (firstChoice) {
    	    case "1":
    	    	displayPreviousRequests(employee);
    	    	break;
    	    case "2":
    	    	submitReimbursement(employee);
    	    	break;
    	    case "0":
    	    	System.out.println("Returning to Main Menu...");
    	    	employeePortal = false;
    	    	break;
    	    	
    	}
        
    }
}

/*
 *
//Display Manager Menu Method//	
public void displayFinanceManagerMenu(User manager) throws SQLException {
	boolean managerPortal = true; 
	
	System.out.println("--------------------------------------------------------");
	System.out.println("Welcome to the Manager Portal, " + manager.getUsername());
    System.out.println("--------------------------------------------------------");
    System.out.println();
    
    while (managerPortal) {
    	System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
    	System.out.println("1 -> View All Pending Reimbursements");
    	System.out.println("2 -> View All Resolved Reimbursements");
    	System.out.println("3 -> Process a Reimbursement");
    	System.out.println("0 -> Return to Main Menu");
    
    	//user chooses a menu option and the scanner takes the input and put it into a int variable
    	String firstChoice = scan.nextLine();
    	
    	switch (firstChoice) {
    	    case "1":
    	    	displayPendingReimbursements();
    	    	break;
    	    case "2":
    	    	displayResolvedReimbursements();
    	    	break;
    	    case "3":
    	    	processReimbursement(manager);
    	    	
    	    case "0":
    	    	System.out.println("Returning to Main Menu...");
    	    	managerPortal = false;
    	    	break;
    	    	
    	}
        
    }
}
/*
//Fetch Input Helper Method//

/** 
 * Prompts the user for input, ignoring everything after the first whitepspace.
 * For example, "123 456" will be converted to "123", and the " 456" will be discarded.
 * This is known as the first "token" of the user's input.
 * 
 * @return the first token of user input on the next line
 */



//
	public static String fetchInput() {
        return scan.nextLine().split(" ")[0];
}

//Prompt Selection Helper Method//

/**
 * Prompts the user for input.<br>
 * If the provided input is not a valid option, the user will be prompted again until a valid answer is provided.
 *
 * @param validEntries the valid int values that the user must choose from 
 * @return the selected option as an int
 */


public int promptSelection(int ...validEntries) {
	int input;  
	boolean valid = false; // flag to track if the input matched a valid entry
	
	do { // do-while loop to continue to prompt user until the response is valide
		// process the input
		input = parseIntegerInput(fetchInput());
		
		// Check if the input\\ matches a valid entry
		for (int entry : validEntries) {
			if (entry == input) {
				//if it does, we activate the flag, which will end the do-while loop
				valid = true;
				break; //stop searching for-loop since we have already found the match
				
			}
		}
		// check if the input was not valid, so we can inform the user that we need a new input
		if (!valid) {
			System.out.println("Input received was not a valid option, please try again.");
			
		}
	} while (!valid);
	return input;
	
}

//Parse Integer and Double Helper Methods//
/** 
 * Attempt to parse input from the user as an int to be useful for control-flow.
 * Leverages the built-in Integer.parseInt method.
 * Note: If the input is not a valid int, such as "hello, world",
 * Integer. parseInt throws a NumberFormatException, which will need to be handled.
 * 
 * @param input the user input that will be parsed into an int
 * @return the input as an int or zero if it was malformed
 */
public int parseIntegerInput(String input) {
	try {
		return Integer.parseInt(input);
	} catch (NumberFormatException e) {	
		System.out.println("The input received was malformed, please try again.");
		return -1; //return -1 by default to be rejected by other validation contigencies
	}
}

public double parseDoubleInput(String input) {
	try {
		return Double.parseDouble(input);
	} catch (NumberFormatException e) {	
		System.out.println("The input received was not valid, please try again.");
		return -1; //return -1 by default to be rejected by other validation contigencies
	}
}


//Handle Portal Helper Method//
public void handlePortal(Roles role) throws SQLException {
	// get the List of employees from the repository layer
	List<User> users = User_Service.getUserByRole(role);
	
	int[] ids = new int[users.size() + 1];
	ids[users.size()] = 0;
	for (int i = 0; i < users.size(); i++) {
		ids[i] = users.get(i).getId();
		
	}
	
	// Ask for employee ID number to continue
	System.out.println("----------------------------------------------------------");
	System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
	
	// Enhance for loop to print out all users one by one
	for (User u : users) {
		System.out.println(u.getId() + " -> " + u.getUsername());
	}
	System.out.println("0 -> Return to Main Menu");
	System.out.println();
	
	int userChoice = promptSelection(ids);
	
	if (userChoice == 0) {
		return;
	}
	User employee = User_Service.getUserById(userChoice);
	
	if (role == Roles.Manager) {
		System.out.println("Opening Manager Portal for " + employee.getUsername());
		displayFinanceManagerMenu(employee);
	} else {
		System.out.println("Opening Employee Portal for " + employee.getUsername());
		displayEmployeeMenu(employee);
	
	}
}

//Display Previous Requests helper method//
public void displayPreviousRequests(User employee) {
	List<Reimbursement> reimbursements = rService.getReimbursementsByAuthor(employee.getId());
	
	if (reimbursements.isEmpty()) {
		System.out.println("No Previous Requests...");
		System.out.println("Returning to Previous Menu... ");
	}
	for (Reimbursement r : reimbursements) {
		System.out.println(r);
	}
}

//Submit Reimbursement helper method//

public void submitReimbursement(User employee) throws SQLException {
	Reimbursement reimbursementToBeSubmitted = new Reimbursement();
	reimbursementToBeSubmitted.setAuthor(employee.getId());
	
	System.out.println(" What type or reimbursement would you like to submit");
	System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
	System.out.println("1 -> Lodging");
	System.out.println("2 -> Travel");
	System.out.println("3 -> Food");
	System.out.println("4 -> Other");
    String typeDecision = scan.nextLine();
	
	switch (typeDecision) {
    case "1":
    	reimbursementToBeSubmitted.setType(Reimbursement_Type.Lodging);
    	break;
    case "2":
    	reimbursementToBeSubmitted.setType(Reimbursement_Type.Travel);
    	break;
	case "3":
		reimbursementToBeSubmitted.setType(Reimbursement_Type.Food);
	break;
	case "4":
    	reimbursementToBeSubmitted.setType(Reimbursement_Type.Other);
    	break;
	}
	
	System.out.println("Please enter the dollar amount that you are requesting to be reimbursed");
	System.out.println("$");
	
	reimbursementToBeSubmitted.setAmount(parseDoubleInput(fetchInput()));
	if (reimbursementToBeSubmitted.getAmount() <= 0) {
		System.out.println("Invalid Amount has been entered, please input a correct dollar amount"); 
		boolean valid = false;
		while (!valid) {
			reimbursementToBeSubmitted.setAmount(parseDoubleInput(fetchInput()));
			if (reimbursementToBeSubmitted.getAmount() != 0) {
            valid = true;
			}	
		}	
	}	
	
	System.out.println("Please enter a description/reason for you reimbursement request.");
		
	reimbursementToBeSubmitted.setDescription(scan.nextLine());
	if (reimbursementToBeSubmitted.getDescription().trim().equals("")) {
		System.out.println("You cannot submit a request with an empty description, please explain the reason for your request.");		 
		boolean valid = false;
		while (!valid) {
			reimbursementToBeSubmitted.setDescription(scan.nextLine());
			if (reimbursementToBeSubmitted.getDescription().trim().equals("")) {
            valid = true;
			}	
		}	
	}	
	rService.submitReimbursement(reimbursementToBeSubmitted);
	
}

//Display Reimbursement Method//
public void displayPendingReimbursements() {
	List<Reimbursement> pendingReimbursements = rService.getPendingReimbursements();

	if (pendingReimbursements.isEmpty()) {
		System.out.println("No Pending Requests...");
		System.out.println("Returning to Previous Menu...");		
	}
	for (Reimbursement r : pendingReimbursements) {
		System.out.println(r);
	}
	
}

public void displayResolvedReimbursements() {
	List<Reimbursement> resolvedReimbursements = rService.getResolvedReimbursements();

	if (resolvedReimbursements.isEmpty()) {
		System.out.println("No Resolved Requests...");
		System.out.println("Returning to Previous Menu...");		
	}
	for (Reimbursement r : resolvedReimbursements) {
		System.out.println(r);
	}
	
}

//Process Reimbursement Helper Method//
public void processReimbursement(User manager) throws SQLException {
	boolean processPortal = true;
	
	System.out.println("--------------------------------------------------------");
	System.out.println("Welcome to the Manager Processing Portal, " + manager.getUsername());
    System.out.println("--------------------------------------------------------");
    System.out.println();
    
    while (processPortal) {
    	List<Reimbursement> reimbursements = rService.getPendingReimbursements();
    
    	if (reimbursements.isEmpty()) {
    		System.out.println("There are no reimbursements to process.");
    		System.out.println("Returning to previous menu...");
    		return;
    	}
    	
    	int[] ids =new int[reimbursements.size()];
    	for (int i = 0; i< reimbursements.size(); i++) {
    		Reimbursement r = reimbursements.get(i);
    		User author = userService.getUserById(r.getAuthor());
    		System.out.println(r.getId() + " -> " + author.getUsername() + " : $" + r.getAmount());
    		ids[i] = r.getId();
    		
    	}
    	
    	System.out.println("Please enter the ID of the Reimbursement you wish to process.");
    	
    	int selection = promptSelection(ids);
    	Reimbursement reimbursementToBeProcessed = rService.getReimbursementById(selection);
        System.out.println("Processing reimbursement #" +reimbursementToBeProcessed.getId());
        System.out.println("Details\nAuthor: "
        		+ userService.getUserById(reimbursementToBeProcessed.getAuthor()).getUsername()
        		+ "\nAmount: " + reimbursementToBeProcessed.getAmount()
    	        + "\nDescription: " + reimbursementToBeProcessed.getDescription()
    	        
    	);
        
        System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
        System.out.println("1 -> Approve");
        System.out.println("2 -> Deny");
        
        int decision = promptSelection( 1,2);
        Status status = (decision == 1) ? Status.Approved : Status.Denied;
        rService.update(reimbursementToBeProcessed, manager.getId(), status);
        
        System.out.println("Would you like to process another reimbursememt?");
        System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
        System.out.println("1 -> Yes");
        System.out.println("2 -> No");
        
        String lastChoice = scan.nextLine();
        
        if (lastChoice == "2") {
        	processPortal = false;
        }  	        
    }
    
    
}

public void loginMenu() {
	// TODO Auto-generated method stub
	
}
}