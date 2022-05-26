package com.revature.controller;

import java.util.Objects;

import com.revature.models.User;
import com.revature.services.Auth_Service;
import com.revature.services.Reimbursement_Service;
import com.revature.services.User_Service; 

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpCode;

public class Auth_Controller {

	
	objectMapper mapper = new objectMapper();
	public Handler handleLogin;
	public Handler handleRegister;
public void handleLogin(Context ctx) {
	
	// Reading the form parameters from the http request with the respective string keys.
	// Storing the form parameters in local variables
	String username = ctx.formParam("username");
	String password = ctx.formParam("password");
	
	// Checking to make sure that the appropriate forms are provided
	if (Objects.equals(username,"") || Objects.equals(password,"")) {
	
		// Returning a bad request status and message
		ctx.status(HttpCode.BAD_REQUEST);
		ctx.result("Invalid Credentials");
	} else {
		
		// Calling the authService login method
		try {
			username = Auth_Service.loginMenu(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Ensuring the user was found and accepted
		// The service returns null if unsuccesful
		if (username != null) {
			
			// Sending accepted status code
			ctx.status(HttpCode.ACCEPTED);
			// Giving the front-end access to the response headers
			ctx.header("Access-Control-Expose-Headers", "Current-User" );
			// Returning a Current-User header for authentication
			ctx.header("Current-User", ""+ User.getId); 
			// Sending user role for portal navigation
			ctx.result(username.getUserByRole();
			
			
		} else {
			
			// Sending bad request and message if unsuccessful login service method
			ctx.status(HttpCode.BAD_REQUEST);
			ctx.result("Invalid Credentials");
		}
	}
}

/** 
 * This Javelin handler method leverages the Http call context to call the register AuthService method.
 * The input json user object must have an ID of 0 to map correctly
*/

public void handleRegister(Context ctx) {
	
	//try+catch block to catch any exceptions thrown
	try {
		// Storing the json body as a string
		String input = ctx.body();
		
		// Instantiating and using the object mapper
		// This will parse the input string to a User object and store it in a local variable
		objectMapper mapper = new objectMapper();
		User user = mapper.readValue(input, User.class);
		
		//Once user object is created, storing the positive integer ID from the regular service method
		int id = Auth_Service.registerMenu(user);
		
		// If ID is still 0, the registration was unsuccessful
		if(id == 0) {
			// Telling the client that registration failed
			ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
			ctx.result("Registration unsuccessful.");
		} else {
			//Proclaiming successful creation of new user
			ctx.status(HttpCode.CREATED);
			ctx.result("Registration unsuccessful.");
			
		}
	// Catching any exceptions thrown
	} catch (Exception e) {
		// Returning 500 status
		ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
		
		// if the exception has a message, send it back in the body
		if(!e.getMessage().isEmpty()) {
			ctx.result(e.getMessage());
		}
		
		// Stacktrace to help debug the server
		e.printStackTrace();
	}
}
}

