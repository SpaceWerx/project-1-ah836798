package Models;

import Models.User_Model;
public enum Roles {

	Employee, Manager;
	
//two roles are Employee and Manager//

  public static void main(String []args) {
	 
	 for (Roles role : Roles.values())
		 System.out.println(role);
	 
	 System.out.println("Role of Employee is: "+Roles.valueOf("Employee"));
	 System.out.println("Role of Manager is: "+Roles.valueOf("Manager"));
	 }
  }	
