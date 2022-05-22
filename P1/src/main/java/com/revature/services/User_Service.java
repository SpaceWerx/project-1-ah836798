package com.revature.services;

import java.util.ArrayList;

import java.util.List;

import com.revature.models.User;

public class User_Service {
	
//Get User by Username  Method//
	public User getuseridByUserName(String username) {
		
		for (User u : user ) {
			if (u.getuserName() == username) {
				return username;
			}
		}
	    return null;   
	}

//Get User by ID Method
public User getuseridById(int userid) {

	for (User u : user ) {
		if (u.getId() == userid) {
			return userid;
		}
	}
    return null;   
}

//Get All Users Method by Username Method 

public List<User> getAllUserByUsername  String username) {
	List<User> username = new ArrayList<>();
		
		for (User u: username) {
			if (u.getUsername() == username ||
		    }
		}
		return username;

}

//Get All Users Method by Id Method 

public List<User> getAllUserByUsername int userid) {
	List<User> userid = new ArrayList<>();
		
		for (User u: userid) {
			if (u.getUsername() == userid ||
		    }
		}
		return userid;

}

//Query user exists by ID Method
public List<User> queryUserById  String userid) {
			List<User> userid = new ArrayList<>();
		
	for (User u : userid ) {
		if (u.contains() == true); 
				
		//must deterimine if user exists in list/
		
			System.out.println("The user exists.");
		else 
			System.out.println("The user does not exist")
			
		}
			}
			
			}
}
			


//Get users by Role Method

public User getuseridByRole(String role) {
	
	for (User u : user ) {
		if (u.getRole() == role) {
			return role;
		}
	}
    return null;   
}