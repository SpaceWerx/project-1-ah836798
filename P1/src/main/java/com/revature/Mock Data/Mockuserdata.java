package com.revature;

import java.util.ArrayList;
import java.util.List;

         
public class Mockuserdata {
		private final List<User> users = new ArrayList<>();
		
	    public Mockuserdata() {

	    	User generic_Employee_1 = new User(id 1, username "genericEmployee1 ", password "genericPassword1", Role.Employee);
	    	User generic_Employee_2 = new User(id 2, username " genericEmployee2 ", password "genericPassword2", Role.Employee);
	    	User generic_Employee_3 = new User(id 3, username " genericEmployee3 ", password "genericPassword3", Role.Employee);
	    	User generic_Finance_Manager_1 = new User(id 4, username " genericManager1 ",  password "genericPassword1", Role.Manager);
	    	User generic_Finance_Manager_2 = new User(id 5, username " genericManager2 ",  password "genericPassword2", Role.Manager);
	    	User generic_Finance_Manager_3 = new User(id 6, username " genericManager3 ",  password "genericPassword3", Role.Manager);
	    			
	    	
	        users.add(generic_Employee_1);
	        users.add(generic_Employee_2);
	        users.add(generic_Employee_3);
	        users.add(generic_Finance_Manager_1);
	        users.add(generic_Finance_Manager_2);	
	        users.add(generic_Finance_Manager_3);
	    }
	    
	    public List<User> getUsers() { return user; }  
	}

