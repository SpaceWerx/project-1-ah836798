package com.revature.controller;


import java.util.List;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.User_Service;

import io.javalin.http.Handler;


public class User_Controller {

	
		User_Service us = new User_Service();
	
		public Handler getAllUsersHandler = (ctx) -> {
			List<User> allUsers = us.getAllUsers();
			
			Gson gson = new Gson();
			
			String JSONObject = gson.toJson(allUsers);
			
			ctx.result(JSONObject);
			ctx.status(200);
		};
		
		
		public Handler insertUsersHandler = (ctx) ->{
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			User u = gson.fromJson(body, User.class);
			
			us.addUser(u);
			
			ctx.result("Employee successfully added!");
			ctx.status(201);
			
		};



public Handler getUserByUsername = (ctx) ->{
		
		String username = ctx.body();
		User userbyusername = us.getUsername(username);
		Gson gson = new Gson();
		String JSONObject = gson.toJson(userbyusername);
		ctx.result(JSONObject);
		ctx.status(200);
	};
	
	
public Handler getUserByUserID = (ctx) ->{

	
// Having a problem with user id being declared as string vs. id.
	
        String userid = ctx.body();   
		User byuserID = us.getUserById(userid);
		Gson gson = new Gson();
		String JSONObject = gson.toJson(byuserID);
		ctx.result(JSONObject);
		ctx.status(200);
};

}
