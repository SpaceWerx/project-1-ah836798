package Models;

import Models.Reimbursement_Model;
import java.util.Scanner;


public enum Status {

		Pending, Approved, Denied;
		
	//The Status Options are Pending, Approved and Denied 
	//Reimbursements can only switch from:

		//Pending -> Approved

	//	or 

	//	Pending -> Denied
//		//Reimbursements ***CANNOT*** go from Denied to Approved or vice versa.//
	
//	   
/*		 Status options =Status.Pending;
		 
		 switch(options){
			
		 case Pending:
			 
		 System.out.println("Pending");
		 break;
		 
		 case Approved:
			 
	     System.out.println("Approved");
	     break;
	     
	     default:
	    	
	     System.out.println("Denied"); // 		
		 }
	  }	
*/}

