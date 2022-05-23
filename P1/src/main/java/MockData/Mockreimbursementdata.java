package MockData;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.Reimbursement_Type;
import com.revature.models.Status;

public class Mockreimbursementdata {

		private final List<Reimbursement> reimbursements = new ArrayList<>();
		public Mockreimbursementdata() {  

		Mockuserdata userData = new Mockuserdata(); 

		Reimbursement Reimbursement_To_Process_1 = new Reimbursement(1,1,0, "Oracle Java Certification", Reimbursement_Type.Other, Status.Pending, 250.00);
		Reimbursement Reimbursement_To_Process_2 = new Reimbursement(2,2,0, "Travel to Reston HQ", Reimbursement_Type.Travel, Status.Pending, 600.00);
		Reimbursement Reimbursement_To_Approved_1 = new Reimbursement(3,1,3, "Free lunch offer from Sean", Reimbursement_Type.Food, Status.Pending, 600.00);
		Reimbursement Reimbursement_To_Approved_2 = new Reimbursement(4,2,4, "2-night hotel stay near Orlando Office for visit ", Reimbursement_Type.Lodging, Status.Pending, 300.00);
		Reimbursement Reimbursement_To_Denied_1 = new Reimbursement(5,1,3, "Rental Car to drive from Boston to Orlando", Reimbursement_Type.Travel, Status.Denied, 2500.00);
		    	
		    	
        reimbursements.add(Reimbursement_To_Process_1);
		reimbursements.add(Reimbursement_To_Process_2);
		reimbursements.add(Reimbursement_To_Approved_1);
		reimbursements.add(Reimbursement_To_Approved_2);
		reimbursements.add(Reimbursement_To_Denied_1);

		   }
		    
		    public List<Reimbursement> getReimbursements() { return reimbursements; }  
		    public void getNewReimbursement (int id, int resolver, String description, Reimbursement_Type type, Status status, double amount) {
		        Reimbursement pending = new Reimbursement (reimbursements.size() + 1, id, resolver, description, type, status, amount);


		            reimbursements.add(pending);
		    }
}

