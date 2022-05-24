package com.revature.services;

import java.sql.SQLException;

import com.revature.models.User;
import com.revature.repositories.User_DAO;

public class Auth_Service {

// 
//  The login method is used to check the information give and vefity their credentials
//
// @return User object
//
  
public static User loginMenu(String username, String password) {
   // Instantiating a temporary user
   User user;
   
   //The try+catch block will catch any exceptions thrown by the userDAO methods
   try {
	   
	   // Retrieving the user data from the database from the username given
	   user = User_DAO.getbyUsername(username);
	   
	   // These conditional statements are checking various contingencies
	   // The first is checking if the user exists and that the password given matches the one stored
	   if (user!=null && password.equals(user.getPassword())) {
		   
		   //If this one is true, the user object is returned and login is deemed successful
		   System.out.println("Logged in Successfully!");
		   return user;
		   
	   // The second is checking if the user exists and the password given is different than the one stored
	   } else if (user!=null && !password.equals(user.getPassword())){
		   
	        //If this one is true and the previous false; a null object is returned and login is deemed unsuccessful
		   System.out.println("Wrong Password");
           return null;
	   
	   // The third is the final contingency and will only occur if the username does not exist in the database
	   } else {
		   
		   // This outcome will return a null object and login is deemed unsuccessful
	      System.out.println("User Does Not Exist!");
	      return null;
	   }   } catch (Exception e) {
		   System.out.println("Login Unsuccessful");
		   e.printStackTrace(); // Helpful debugging tool
	 }
	   
	  
	   // if the try+catch does not run, a null object is returned and login is deemed unsuccessful
	   return null;
   }
   

	/////registerMenu////
/**
 * Note: userToBeRegistered will have an id=0.
 * After registration, the id will be a positive integer.
 * @throws SQLException 
 */
	
// making a new user object
public int registerMenu(User userToBeRegistered) throws SQLException {
	
	// checking if the username already exists in the database
	// if the method returns null, the username is already taken 
	if(User_DAO.getbyUsername(userToBeRegistered.getUsername()) != null) {

		// Throws a NullPointerException if the username is already taken
        throw new NullPointerException("Username is already taken");
	}
	
    // take in the user object sent from the menu and send it to the userDAO to be inserted into the database
    // After the entry has been made, the ID of the new user is immediately removed
    try {
		return User_DAO.create(userToBeRegistered);
		e.printStackTrace();
	}    
}
}
