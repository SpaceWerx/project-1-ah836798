package Service;

import Models.Reimbursement;
import Models.Status;

public class Reimbursement_Service {

// Submit Reimbursement Method//

    private String latestReimbursement;
    
    
public void submitReimbursement (Reimbursement reinbursementToBeSubmitted)	{
	Reimbursement latestReimbursement = reimbursement.get(reimbursement_Model.size() - 1);
	int id = latestReimbursement.getId() + 1; //New ID is higher than the previous highest
	
	reimbursementToBeSubmitted.setId(id);
	reimbursementToBeSubmitted.setstatus(Status.Pending);
	reimbursements.add(reimbursementToBeSubmitted);	
}

// Update Reimbursement Method//

public void update(Reimbursement unprocessedReinbursementToBeSubmitted, resolverId, Status updatedStatus) {	
	
	for (Reimbursement reimbursement : reimbursements) {
		if (reimbursement.getId() == unprocessedReimbursement.getId))
			reimbursement.setResolver(resolverId);
			reimbursement.setStatus(updatedStatus);
			return;
	    }
	}
	throw new RuntimeException("There was an error processing this reimbursment, please try again.")
}

//Get by Id Method//

public Reimbursement getReimbursementById(int id) {
	
	for (Reimbursement reimbursement : reimbursements ) {
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
		if (reimbursement.getStatus() == Status.Pending;
			pendingReimbursements.add(reimbursement);
	    }
	}
	return pendingReimburserments;
}

//Get Approved and Resolved Reimbursements Method//

public List<Reimbursement> getResolvedReimbursements() {
	List<Reimbursement> getResolvedReimbursements = new ArrayList<>();
	
	for (Reimbursement reimbursement : reimbursements) {
		if (reimbursement.getStatus() == Status.Approved || reimbursement.getStatus() == Status.Denied
			resolvedReimbursements.add(reimbursement);
	    }
	}
	return resolvedReimburserments;
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