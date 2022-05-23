package com.revature.Tests;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.Reimbursement_Type;
import com.revature.models.Roles;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.Reimbursement_DAO;
import com.revature.services.Reimbursement_Service;
import com.revature.services.User_Service;

public class Reimbursement_Service_Tests {

private static Reimbursement_Service reimbursementService;
private static User_Service userService;
private static Reimbursement_DAO reimbursementDAO;

private Reimbursement REIMBURSEMENT_TO_PROCESS;
private List<Reimbursement> mockPendingReimbursements;
private List<Reimbursement> mockApprovedReimbursements;
private List<Reimbursement> mockDeniedReimbursements;
private User GENERIC_EMPLOYEE_1;
private User GENERIC_MANAGER_1;

@BeforeClass
public static void setUpBeforeClass() throws Exception {
	
	// Instantiating a new reimbursement service that is being tested
	reimbursementService = new Reimbursement_Service();
}

/ This method will be called before each test is initiated
@Before
public void setUp() throws Exception {
	
	// Mocking the user service and reimbursementDAO because they are not directly tested here
	userService = mock(UserService.class);
	reimbursementDAO - mock(ReimbursementDAO.class);
	
	// Retrieving the mock data we made in week 1 to leverage in our tests
	MockReimbursementData mockReimbursementData = new MockReimbursementData();
	
	// We must assign the mocks to the instantiated reimbursement service to ensure it's not using
	reimbursementService.reimbursementDAO = reimbursementDAO;
	reimbursementService.userService = userService;
	
	// Generic mock users to use in our tests
	GENERIC_EMPLOYEE_1 = new User(1, "genericEmployee1", "genericPassword", Roles.Employee);
	GENERIC_MANAGER_1 = new User(1, "genericManager1", "genericPassword", Roles.Manager);
	
	// mock reimbursement that can be tested by processing 
	REIMBURSEMENT_TO_PROCESS = new Reimbursement(2, GENERIC_EMPLOYEE_1.getId(), "Oracle Certification", Reimbursement_Type.Other, Status.Pending);
	
	// Creating lists of reimbursements from the mockReimbursementData
	// These lists will be used in various tests of the Reimbursement Service
	List<Reimbursement> mockReimbursements = mockReimbursement.Data .getReimbursements();
	mockPendingReimbursements = new ArrayList<>();
	mockApprovedReimbursements = new ArrayList<>();
	mockDeniedReimbursements = new ArrayList<>();
	
	// Iterating through the mock reimbursements and adding them to their respective lists by status
	for(Reimbursement reimbursement: mockReimbursements) {
		if(reimbursement.getStatus() == Status.Pending) {
			mockPendingReimbursements.add(reimbursement);
		} else if (reimbursement.getStatus() == Status.Approved) {
			mockApprovedReimbursements.add(reimbursement);
		} else {
			mockDeniedReimbursements.add(reimbursement);
		}
	
	}
	
}

@Test

public void testUpdateThrowsIllegalArgumentExceptionWhernResolverIsNotManager() {
	
	// Telling the nested userService method to return an Employee when called in the tested update method
	when(userService.getUserById(anyInt())).thenReturn(GENERIC_EMPLOYEE_1);
	
	// Checking to make sure the tested update method throws the exception we want
	assertThrows(IllegalArgumentException.class,
			() -> reimbursementService.update(REIMBURSEMENT_TO_PROCESS, GENERIC_EMPLOYEE_1.getId(), Status.Approved)
	);
	
	
	// Verifying that the mocked reimbursementDAO update method is never called
	// Verifying that the mock userService getUserById method is called
	verify(reimbursementDAO, never()).update(REIMBURSEMENT_TO_PROCESS);
	verify(userService).getUserById(GENERIC_EMPLOYEE_1.getId());
}



@Test

public void testResolverIsAssignedAfterReimbursementUpdate() {
	
	// Telling the nested userService method to return a Manager when called in the tested update method 
	when(userService.getUserById(anyInt())).thenReturn(GENERIC_MANAGER_1);
	
	// Checking to make sure the resolver is assigned accordingly when the update method is called
	assertEquals(GENERIC_MANAGER_1.getId, reimbursementService.update(REIMBURSEMENT_TO_PROCESS, GENERIC_EMPLOYEE_1.getId(), Status.Approved));
		
	// Verifying that the mocked reimbursementDAO update method is never called
	// Verifying that the mock userService getUserById method is called
	verify(reimbursementDAO, never()).update(REIMBURSEMENT_TO_PROCESS);
	verify(userService).getUserById(GENERIC_MANAGER_1.getId());
}


@Test

public void testSubmitReimbursementThrowsIllegalArgumentExceptionWhernSubmittedByManager() {
	
	// Telling the nested userService method to return a Manager when called in the tested update method
	when(userService.getUserById(anyInt())).thenReturn(GENERIC_MANAGER_1);
	
	// Checking to make sure the tested update method throws the exception we want
	assertThrows(IllegalArgumentException.class,
			() -> reimbursementService.update(REIMBURSEMENT_TO_PROCESS, GENERIC_EMPLOYEE_1.getId(), Status.Approved)
	);
	
	
	// Verifying that the mocked reimbursementDAO update method is never called
	// Verifying that the mock userService getUserById method is called
	verify(reimbursementDAO, never()).update(REIMBURSEMENT_TO_PROCESS);
	verify(userService).getUserById(GENERIC_MANAGER_1.getId());
}

@Test

public void testReimbursementStatusIsChangedAfterUpdate() {
	
	// Telling the nested userService method to return a Manager when called in the tested update method
	when(userService.getUserById(anyInt())).thenReturn(GENERIC_MANAGER_1);
	
	// Checking to make sure the tested update method throws the exception we want
	assertEquals(Status.Approved, reimbursementService.update(REIMBURSEMENT_TO_PROCESS, GENERIC_MANAGER_1.getId(), Status.Approved)
	);
	
	
	// Verifying that the mocked reimbursementDAO update method is never called
	// Verifying that the mock userService getUserById method is called
	verify(reimbursementDAO).update(REIMBURSEMENT_TO_PROCESS);
	verify(userService).getUserById(GENERIC_EMPLOYEE_1.getId());
}

@Test
public void testGetResolvedReimbursementsRetrunsOnlyAppovedAndDenied() {
	
	// Telling the nested reimbursementDAO getByStatus method to return the mocked list of Approved and Denied reimbursements
	when(reimbursementDAO.getByStatus(Status.Approved)).thenReturn(mockApprovedReimbursements);
	when(reimbursementDAO.getByStatus(Status.Denied)).thenReturn(mockDeniedReimbursements);
	
	// Creating a new list that combines the mocked approved and denied reimbursements (similar to how the service method works)
	List<Reimbursement> resolvedReimbursements = new ArrayList<>();
	resolvedReimbursements.addAll(mockApprovedReimbursements);
	resolvedReimbursements.addAll(mockDeniedReimbursements);
	
	// Checking to make sure the service method throws the correct data 
	assertEquals(resolvedReimbursements, reimbursementService.getResolvedReimbursements()); 
		
	
	// Verifying that the mocked reimbursementDAO method getByStatus is called twice 
	
	verify(reimbursementDAO).getByStatus(Status.Approved);
	verify(reimbursementDAO).getByStatus(Status.Denied);
}


@Test
public void testGetPendingReimbursementsRetrunsOnlyPending() {
	
	// Telling the nested reimbursementDAO getByStatus method to return the mocked list of Approved and Denied reimbursements
	when(reimbursementDAO.getByStatus(Status.class))).thenReturn(mockPendingReimbursements);
	
	// Checking to make sure the service method throws the correct data 
	assertEquals(mockPendingReimbursements, reimbursementService.getResolvedReimbursements()); 
		
	
	// Verifying that the mocked reimbursementDAO method getByStatus is called twice 
	
	verify(reimbursementDAO).getByStatus(Status.Pending);


}

}
