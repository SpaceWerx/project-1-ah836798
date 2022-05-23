package MockData;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Roles;
import com.revature.models.User;

         
public class Mockuserdata {
		private final List<User> users = new ArrayList<>();
		
	    public Mockuserdata() {

	    	User generic_Employee_1 = new User(1, "genericEmployee1 ", "genericPassword1", Roles.Employee);
	    	User generic_Employee_2 = new User(2, "genericEmployee2 ","genericPassword2", Roles.Employee);
	    	User generic_Employee_3 = new User(3, "genericEmployee3 ", "genericPassword3", Roles.Employee);
	    	User generic_Finance_Manager_1 = new User(4, "genericManager1 ", "genericPassword1", Roles.Manager);
	    	User generic_Finance_Manager_2 = new User(5, "genericManager2 ", "genericPassword2", Roles.Manager);
	    	User generic_Finance_Manager_3 = new User(6, "genericManager3 ", "genericPassword3", Roles.Manager);
	    			
	    	
	        users.add(generic_Employee_1);
	        users.add(generic_Employee_2);
	        users.add(generic_Employee_3);
	        users.add(generic_Finance_Manager_1);
	        users.add(generic_Finance_Manager_2);	
	        users.add(generic_Finance_Manager_3);
	    }
	    
	    public List<User> getUsers() { return users; }  
	}

