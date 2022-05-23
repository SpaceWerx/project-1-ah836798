package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.models.Roles;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.Reimbursement_DAO;

import MockData.Mockreimbursementdata;

import java.util.ArrayList;
import java.util.List;


public class Reimbursement_Service {

	public Reimbursement_DAO reimbursementDAO = new Reimbursement_DAO();
	public User_Service rService = new User_Service();
	public static List<Mockreimbursementdata> mockData = new ArrayList<>();
	public static ArrayList<Reimbursement> reimbursements = new ArrayList<>();	
	public static void clearData() {	
		reimbursements.clear();
	}

public Reimbursement update(Reimbursement unprocessedReimbursement, int resolverId, Status updatedStatus) {	

	User manager = rService.getUserById(resolverId);
	
	if(manager.getRole() != Roles.Manager) {
		throw new RuntimeException("There was an error processing this reimbursement, please try again.");
	}else {
		
		unprocessedReimbursement.setResolver(resolverId);
		unprocessedReimbursement.setStatus(updatedStatus);
		
		reimbursementDAO.update(unprocessedReimbursement);
		
		return unprocessedReimbursement;
	}
}
		
	


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public List<Reimbursement> getPendingReimbursements() { 

		return reimbursementDAO.getByStatus(Status.Pending);
}
////////////////////////////////////////////////////////////////////

	public List<Reimbursement> getResolvedReimbursements(){
		
		List<Reimbursement> resolvedReimbursements = new ArrayList<>();
		

		resolvedReimbursements.addAll(reimbursementDAO.getByStatus(Status.Approved));
		resolvedReimbursements.addAll(reimbursementDAO.getByStatus(Status.Denied));
		return resolvedReimbursements;
		
		
	}

/////////////////////////////////////////////////////////////////////////////		
	
public int submitReimbursement (Reimbursement reimbursementToBeSubmitted) {
	


	User employee = rService.getUserById(reimbursementToBeSubmitted.getAuthor());

	if(employee.getRole() != Roles.Employee) {
		
		throw new IllegalArgumentException("Managers cannot submit reimbursement requests.");
	} else {
		reimbursementToBeSubmitted.setStatus(Status.Pending);
		

		return reimbursementDAO.create(reimbursementToBeSubmitted);
}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public List<Reimbursement> getReimbursementsByAuthor(int userId) {
	
	List<Reimbursement> userReimbursements = new ArrayList<>();
	
		for(Reimbursement r : reimbursements) {
			if (r.getAuthor() == userId || r.getResolver() == userId) {
			}
		}
		return userReimbursements;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
public Reimbursement updateManager(Reimbursement unprocessedReimbursement, int resolverId, Status updatedStatus) {

	getUserService();//DELETE IF NECESSARY
	User manager = rService.getUserById(resolverId);
	
	if(manager.getRole() != Roles.Manager) {
		
		throw new IllegalArgumentException("An Employee cannot process reimbursement requests.");
	}else {
		unprocessedReimbursement.setResolver(resolverId);
		unprocessedReimbursement.setStatus(updatedStatus);
		
		reimbursementDAO.update(unprocessedReimbursement);
		
		return unprocessedReimbursement;
	}
}
////////////////////////////////////////
public Reimbursement getReimbursementById(int id) {return Reimbursement_DAO.getReimbursementById(id);}

public List<Reimbursement> getReimbursementByAuthor(int userId) {
return reimbursementDAO.getReimbursementsByUser(userId);
}
public User_Service getUserService() {
    return rService;
}

public void setUserService(User_Service userService) {
    this.rService = userService;
}
}