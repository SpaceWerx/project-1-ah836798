package Models;

import Models.Reimbursement_Model;

public enum Reimbursement_Type {
   
	Lodging, Travel, Food, Other;
	
	public static void main(String []args) {
		 
		 for (Reimbursement_Type type : Reimbursement_Type.values())
			 System.out.println(type);
		 
		 Reimbursement_Type t1 = Reimbursement_Type.Lodging;
		 Reimbursement_Type t2 = Reimbursement_Type.Travel;
		 Reimbursement_Type t3 = Reimbursement_Type.Food;
		 Reimbursement_Type t4 = Reimbursement_Type.Other;
		 
		 
		 //
		 
		
		 //System.out.println("Reimbursement Type is: "+Reimbursement_Type.valueOf("Lodging"));
		 //System.out.println("Reimbursement Type is: "+Reimbursement_Type.valueOf("Travel"));
		 //System.out.println("Reimbursement Type is: "+Reimbursement_Type.valueOf("Lodging"));
		 //System.out.println("Reimbursement Type is: "+Reimbursement_Type.valueOf("Travel"));
		 
		 
		 }

	
	
	
}
