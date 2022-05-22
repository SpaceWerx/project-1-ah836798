package com.revature.services;

import Models.Reimbursement;
import Models.Status;

public class Reimbursement_Service {

// Submit Reimbursement Method//

    private String latestReimbursement;
    
   
public void submitReimbursement (Reimbursement reimbursementToBeSubmitted)	{
	Reimbursement latestReimbursement = reimbursement.get(reimbursement.size() - 1);
	int id = latestReimbursement.getId() + 1; //New ID is higher than the previous highest
	
	reimbursementToBeSubmitted.setId(id);
	reimbursementToBeSubmitted.setStatus(Status.Pending);
	Reimbursement.add(reimbursementToBeSubmitted);	
}

// Update Reimbursement Method//

public void update(Reimbursement unprocessedReinbursementToBeSubmitted, resolver, Status updatedStatus) {	
	
	for (Reimbursement reimbursement : reimbursements) {
		if (Reimbursement.getId() == unprocessedReimbursement.getId);
			Reimbursement.setResolver(resolverId);
			Reimbursement.setStatus(updatedStatus);
			return;
	    }
	}
	throw new RuntimeException("There was an error processing this reimbursment, please try again.")
}

//Get by Id Method//

public Reimbursement getReimbursementById(int id) {
	
	for (Reimbursement reimbursement : reimbursement ) {
		if (reimbursement.getId() == id) {
			return reimbursement;
		}
	}
    return null;   
}

//Get Pending Reimbursements Method//

public List<Reimbursement> getPendingReimbursements() {
	List<Reimbursement> pendingReimbursements = new ArrayList<>();
	
	for (Reimbursement reimbursement : reimbursements) {
		if (Reimbursement.getStatus() == Status.Pending;
			pendingReimbursements.add(reimbursement);
	    }
	}
	return pendingReimbursements;
}

//Get Approved and Resolved Reimbursements Method//

public List<Reimbursement> getResolvedReimbursements() {
	List<Reimbursement> getResolvedReimbursements = new ArrayList<>();
	
	for (Reimbursement reimbursement : reimbursements) {
		if (reimbursement.getStatus() == Status.Approved || reimbursement.getStatus() == Status.Denied
			resolvedReimbursements.add(reimbursement);
	    }
	}
	return resolvedReimbursements;
}

//Get By Author..which is UserID... Method//
public List<Reimbursement> getReimbursementsbyAuthor(int id) {
	List<Reimbursement> userReimbursements = new ArrayList<>();
	
	for (Reimbursement r: reimbursements) {
		if (r.getAuthor() == id || r.getResolver() == id) {
			userReimbursements.add(r);
	    }
	}
	return userReimbursements;
}