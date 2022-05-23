package com.revature.controller;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class Reimbursement_Controller {

/** 
 * This Javalin handler method controls any reimbursement submission http calls 	
 */

public void handleSubmit(Context ctx) {
	// Try+catch block to catch any exceptions
	try {
		// Storing the json object input as a string
		String input = ctx.body();
		
		// Utilizing the object mapper to parse the input into a reimbursement object
		Reimbursement reimbursement = objectMapper.readValue(input, Reimbursement.class);
		
		// Storing the positive integer ID that is returned from the service method
		int id = reimbursementService.submitReimbursement(reimbursement);
		
		// If the ID is still 0, the submission was unsuccessful
		if(id !=0) {
			// Proclaim victory and returning the ID
			ctx.status(HttpCode.CREATED);
			ctx.result(""+id);
		} else {
			// Proclaim defeat if the ID was unchanged
			ctx.status(HttpCode.BAD_REQUEST);
			CTX.RESULT("Reimbursement submission was unsuccessful");
		}
	// Catching any exception thrown
	} catch (Exception e) {
		// Returning 500 status
		ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
		
		// If the exception has a message, send it back to the body 
		if(!e.getMessage().isEmpty()) {
			ctx.result(e.getMessage());
		}
		
		// Stacktrace to help debug the server
		e.printStackTrace();
			
		
	}
}

public void handleProcess(Context ctx) {
	
	// Retrieving the header sent with the request that stores the ID of the current user
	String authHeader = ctx.header("Current-User);"
	
	// Making sure the client sent the header along with the request
	if(authHeader !=null) {
		
		// Parsing the ID they sent in the header
		int userId = Integer.parseInt(authHeader);
		
		// Try+catch block to catch any exceptions
		try {
			// Retrieving the id from the path parameters as designated in the Javalin Routes config
			String reimbursementIDInput = ctx.pathParam(key: "id");
			//Parsing the reimbursement ID from the path parameter
			int id = Integer.parseInt(ReimbursementIDInput);
			
			// Storing the new status sent with the request as a form parameter
			String statusInput = ctx.formParam(key: "status");
			
			// Calling the getReimbursementByID Method and storing the return method
			Reimbursement reimbursement =reimbursementService.getReimbursementById(id);
			
			// Checking to ensure that the reimbursement exists in the database before updating
			if(reimbursement != null) {
				// Calling the update method and storing the updated reimbursement
				Reimbursement processedReimbursement = reimbursementService.updated(reimbursement, userid, Status.valueOf(statusInput));
				
				// Proclaim victory and return the processed reimbursement object
				ctx.status(HttpCode.ACCEPTED);
				ctx.json(processedReimbursement);
				
			} else {
				// Proclaim defeat and tell client processing was unsuccessful
				ctx.status(HttpCode.BAD_REQUEST);
				ctx.result("Reimbursement processing was not successful");
			}
		} catch (Exception e) {
			// Returning 500 status
			ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
			
			// If the exception has a message, send it back to the body 
			if(!e.getMessage().isEmpty()) {
				ctx.result(e.getMessage());
			}
			
			// Stacktrace to help debug the server
			e.printStackTrace();
		}
	} else {
		
		// Telling the client they are missing the authHeader
		ctx.status(HttpCode.FORBIDDEN);
		ctx.result("Missing Current User Header with ID");
	}

}










