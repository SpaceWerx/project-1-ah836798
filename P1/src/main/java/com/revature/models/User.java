package com.revature.models;

import com.revature.models.Roles;

//need to import the data from Mockuserdata.java//

public class User {

  private int Id;
  private String username;
  private String password;
  private Roles role;
  
  
  
  //create boilercode//
  
  //created superclass//
public User() {
	super();
	// TODO Auto-generated constructor stub//
}


//create fields//

public User(int id, String username, String password, Roles role) {
	super();
	this.Id = id;
	this.username = username;
	this.password = password;
	this.role = role;
}

public User(String username, String password, Roles role) {
	super();
	this.username = username;
	this.password = password;
	this.role = role;
}

//created getters and setters//
public int getId() {
	return Id;
}


public void setId(int id) {
	this.Id = id;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public Roles getRole() {
	return role;
}


public void setRole(Roles role) {
	this.role = role;
	
}
}


