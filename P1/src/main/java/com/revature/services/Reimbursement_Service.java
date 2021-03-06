package com.revature.services;

import com.revature.controller.Reimbursement_Controller;
import com.revature.models.Reimbursement;
import com.revature.models.Roles;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.Reimbursement_DAO;

import MockData.Mockreimbursementdata;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Reimbursement_Service {

	public static  Reimbursement_DAO reimbursementDAO = new Reimbursement_DAO();
	public  User_Service rService = new User_Service();
	public  User_Service userService;
	public  List<Mockreimbursementdata> mockData = new ArrayList<>();
	public  ArrayList<Reimbursement> reimbursements = new ArrayList<>();	
//	public static void clearData() {	
//		reimbursements.clear();
//	}

public Reimbursement update(Reimbursement unprocessedReimbursement, int resolverId, Status updatedStatus) throws SQLException {	

	User manager = userService.getUserById(resolverId);
	
	if(manager.getRole() != Roles.Manager) {
		throw new IllegalArgumentException("There was an error processing this reimbursement, please try again.");
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
	
	
	
	public int submitReimbursement (Reimbursement reimbursementToBeSubmitted) throws SQLException {
		
//		User employee = userService.getUserById(Reimbursement_Controller.currentid);
		User employee = userService.getUserById(reimbursementToBeSubmitted.getAuthor()); 
		if(employee.getRole() != Roles.Employee) {
			
			throw new IllegalArgumentException("Managers cannot submit reimbursement requests.");
		} else {
			reimbursementToBeSubmitted.setStatus(Status.Pending);	

			return reimbursementDAO.create(reimbursementToBeSubmitted);
	}
	}

/////////////////////////////////////////////////////////////////////////////		
	
//public int submitReimbursement (Reimbursement reimbursementToBeSubmitted) throws SQLException {
//	
////	User employee = userService.getUserById(Reimbursement_Controller.currentid);
//	User employee = userService.getUserById(reimbursementToBeSubmitted.getAuthor()); 
//	if(employee.getRole() != Roles.Manager) {
//		
//		throw new IllegalArgumentException("Employees cannot submit reimbursement requests.");
//	} else {
//		reimbursementToBeSubmitted.setStatus(Status.Pending);	
//
//		return reimbursementDAO.create(reimbursementToBeSubmitted);
//}
//}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public List<Reimbursement> getReimbursementsByAuthor(int userId) {
		return reimbursementDAO.getReimbursementsByUser(userId);
////	List<Reimbursement> userReimbursements = new ArrayList<>();
//	
////		for(Reimbursement r : reimbursements) {
//			if (r.getAuthor() == userId || r.getResolver() == userId) {
//			}
//		}
//		return userReimbursements;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
public Reimbursement updateManager(Reimbursement unprocessedReimbursement, int resolverId, Status updatedStatus) throws SQLException {

//	getUserService();//DELETE IF NECESSARY
	User manager = userService.getUserById(resolverId);
	
	if(manager.getRole() != Roles.Manager) {
		
		throw new IllegalArgumentException("An Employee cannot process reimbursement requests.");
	}else {
		unprocessedReimbursement.setResolver(resolverId);
		unprocessedReimbursement.setStatus(updatedStatus);
		
		reimbursementDAO.update(unprocessedReimbursement);
		
		return unprocessedReimbursement;
	}
}
//////////////////////////////////////////
public Reimbursement getReimbursementById(int userId) {
	return reimbursementDAO.getReimbursementById(userId);
}




public static Reimbursement update(Reimbursement unprocessedReimbursement) {
	// TODO Auto-generated method stub
	reimbursementDAO.update(unprocessedReimbursement);

    return unprocessedReimbursement;
}




//public List<Reimbursement> getReimbursementByAuthor(int userId) {
//return reimbursementDAO.getReimbursementsByUser(userId);
//}
//public User_Service getUserService() {
//    return rService;
//}
//
//public void setUserService(User_Service userService) {
//    Reimbursement_Service.rService = userService;
//}

}