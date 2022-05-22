
import java.util.ArrayList;
import java.util.List;

package com.revature;
public class Mockreimbursementdata {

		private final List<Reimbursement> reimbursements = new ArrayList<>();
		public Mockreimbursementdata() {  

		Mockuserdata userData = new Mockuserdata(); 

		Reimbursement  Remimbursement_To_Process = new Reimbursement( id 1, author 1, resolver 0, description "Oracle Java Certification", ReimbursementType.Other, Status.Pending, amount 250.00);
		Reimbursement  Remimbursement_To_Process = new Reimbursement( id 2, author 2 resolver 0, description "Travel to Reston HQ", ReimbursementType.Travel, Status.Pending, amount 600.00);
		Reimbursement  Remimbursement_To_Approved_1 = new Reimbursement( id 3, author 1 resolver 3, description "Free lunch offer from Sean", ReimbursementType.Food, Status.Pending, amount 600.00);
		Reimbursement Remimbursement_To_Approved_2 = new Reimbursement( id 4, author 2 resolver 4, description "2-night hotel stay near Orlando Office for visit ", ReimbursementType.Lodging, Status.Pending, amount 300.00);
		Reimbursement Remimbursement_To_Denied_1 = new Reimbursement(id 5, author 1, resolver 3, description "Rental Car to drive from Boston to Orlando", ReimbursementType.Travel, Status.Denied, amount 2500.00);
		    	
		    	
        reimbursements.add(Reimbursement_To_Process_1);
		reimbursements.add(Reimbursement_To_Process_1);
		reimbursements.add(Reimbursement_To_Process_1);
		reimbursements.add(Reimbursement_To_Process_1);
		reimbursements.add(Reimbursement_To_Process_1);

		   }
		    
		    public List<Reimbursement> getReimbursements() { return user; }  
		}
}
