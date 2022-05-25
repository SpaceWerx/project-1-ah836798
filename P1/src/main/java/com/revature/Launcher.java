package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner; // import the Scanner class 

import com.revature.controller.Auth_Controller;
import com.revature.controller.Reimbursement_Controller;
import com.revature.controller.User_Controller;
import com.revature.services.CLI_Menu_Service;
import com.revature.services.Auth_Service;
import com.revature.utilities.Connection_Factory_Utility;

import io.javalin.Javalin;

public class Launcher {
	public static void main(String[] args) throws SQLException {
		
		// Instantiating respective controllers to access methods for the routes configuration
		User_Controller uc = new User_Controller();
		Reimbursement_Controller rc = new Reimbursement_Controller();
		Auth_Controller ac = new Auth_Controller();
	
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

	        CLI_Menu_Service options = new CLI_Menu_Service();
	        options.displayMenu();
	        options.loginMenu();
	        options.registerMenu(); 
	      }
	      
	      /**
	  	 * This method is used in the Launcher class to start the Javalin app on the desired port.
	  	 */
	      public void start(int port) {
	  		// Starting the Javalin instance on the server
	  		this.app.start(3000);
	  		
	  	}
     
	      

// Creating the Javalin app to designate routes
// Enabling CORS for all origins to avoid http request constraints
Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins).routes(()->{

	// Setting the /login path
	path("login", () -> {
		// routes the http post requests to /login to the respective authContoller method
		post(authController::handleLogin);
	});
	
	// Setting the /register path
	path("register", () -> {
		//routes the http post requests to /register to the respective authController method
		post(authController::handleRegister);
		
	});
	
	// Setting the /users path
	path("users", () -> {
		// Routes get requests to /users
		// Query Params such as /users?username=x will use the respective userController method 
		get(userController::handleGetUsers);
		
		// Setting sub-path for /users/{id} where {id} is a path parameter
		path("{id}", () -> {
			//Routes get requests with id path parameter to respective userController method
		    get(userController::handleGetUserById);
	});			
	
	// Setting the /reimbursements path
	path("reimbursements", () -> {
		// Routes get requests to /reimbursements to the respective reimbursementController method
		// Query Params such as /reimbursements?author=x will use respective reimbursementController method
		get(reimbursementController::handleGetReimbursements);
		// Routes post http requests to the submit method
		post(reimbursementController::handleSubmit);
		
		// Setting sub-path for /reimbursements/{id} where {id} is a path parameter
		path("{id}", () -> {
			// Routes get requests with id path parameter to respective reimbursementController method
		    get(reimbursementController::handleGetReimbursementById);
		    // Routes put http requests for /reimbursements/{id} to process requirements
		    put(reimbursementController::handleProcess);
		
		});
	});	      
});
}
