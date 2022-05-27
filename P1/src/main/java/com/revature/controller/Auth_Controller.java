package com.revature.controller;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.repositories.User_DAO;
import com.revature.services.Auth_Service;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpCode;


Auth_Service ac = new Auth_Service();
ObjectMapper Mapper = new ObjectMapper();

public class Auth_Controller {
	
	
	    public void handleRegister(Context ctx) {

	        try {

	            String input = ctx.body();

	            User users = Mapper.readValue(input, User.class);

	            int id = Auth_Service.register(users);

	            if(id == 0) {

	                ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
	                ctx.result("Registration unsuccessful.");
	            }

	        } catch (Exception e) {

	            ctx.status(HttpCode.INTERNAL_SERVER_ERROR);

	            if(!e.getMessage().isEmpty()) {
	                ctx.result(e.getMessage());
	            }

	            e.printStackTrace();
	        }

	    }
	    Auth_Service as = new Auth_Service();

	    public Handler loginHandler = (ctx) -> {
	        String body = ctx.body();

	        Gson gson = new Gson();
	        //I recommend you make this an employee object 
	        Users u = gson.fromJson(body, Users.class);

	        if(as.login(u.getUsername(), u.getPassword()) == 1) {
	            ctx.status(201);
	            ctx.result("Manager Login Sucessful!");
	        }
	        else if(as.login(u.getUsername(), u.getPassword()) == 2) {
	            ctx.status(202);
	            ctx.result("Employee Login Sucessful!");
	        }
	        else {
	        ctx.result("Login Failed!");
	        ctx.status(401);
	        }
	    };
	}
	
 public Handler handleLogin = (ctx) -> {
    String body = ctx.body();
    Gson gson = new Gson();
	User allEmployees = gson.fromJson(body, User.class); 
	User temp = Auth_Service.loginMenu(allEmployees.getUsername(),allEmployees.getPassword());
	String JSONObject = gson.toJson(allEmployees);
	
    ctx.result("Login Successful");
	ctx.status(200);
	
 };
 
/*	
	if  
	
	else
		
	ctx.result("Login Failed")
	ctx.status(301);
	*/


public Handler handleRegister (ctx) -> {
	String body = ctx.body();
    Gson gson = new Gson();
	User user = gson.fromJson(body, User.class);
	User temp = Auth Service.
	String JSONObject = gson.toJson(user);
    ctx.result("Login Successful");
	ctx.status(200);
	if(user != null) {
		// Telling the client that registration failed
		User_DAO.create(user);
		ctx.status(HttpCode.CREATED);
		ctx.result("Registration unsuccessful.");
	} else {
		ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
		ctx.result("Registration unsuccessful.");
	}
};

}




	
	
	
	
	
	
/*	public void handleLogin(Context ctx) {
	
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
			ctx.result(username.getUserByRole());
			
			
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

/*public void handleRegister(Context ctx) {
	
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
*/
