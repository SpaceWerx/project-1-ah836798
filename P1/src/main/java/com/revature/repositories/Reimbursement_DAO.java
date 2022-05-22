package com.revature.repositories;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.services.Reimbursement_Service;
import com.revature.utilities.Connection_Factory_Utility;


public class Reimbursement_DAO {

	
/**
 * Should retreive a Reimbursement from the DB with the corresponding id or null if there is no match.
 */
	
 public Reimbursement getReimbursementbyId(int id) {

	 //try+catch block to catch sql exception that can be thrown with connection 
	 try(Connection connection = Connection_Factory_Utility.getConnection()) {
		 
		 String sql ="select * from ers_reimbursements where id = ?";
		 
		//when we need parameters we need to use a PREPARED Statement  as opposed to a Statement (seen above)
		PreparedStatement preparedStatement = connection.prepareStatement(sql); //prepareStatement() as opposed to createStatement()
        
		//insert the methods argument (int id) as the first (and only) variable in our SQL query
		preparedStatement.setInt(parameterindex 1, id); //the 1 here is referring to the first parameter (?) found in our SQL String
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		// if there are results in the result set...
		if (resultSet.next()) {
			
			// return a reimbursement with the data to be returned to the service layer
			return new Reimbursement
					resultSet.getInt(columnLabel: "id"),
					resultSet.getInt(columnLabel: "author"),
					resultSet.getInt(columnLabel: "resolver"),
					resultSet.getInt(columnLabel: "resolver"),
					Reimbursement_Type.valueOf(resultSet.getString(columnlabel: "type")),
					Staus.valueOf(resultSet.getString(columnlabel:"status"))
					resultSet.getDouble(columnLabel:"amount")
					);	
		}
	 
	 } catch (SQLException e) {
		 System.out.println("Something went wrong with the database!");
		 e.printStackTrace();
	 }
 }
     //Fail=safe if the try+catch block does not run
     return null;
}
/**
 *This method is inteded to extract any reimbursements from the database
 *that were submitted by a specific user, whose ID is passed in as a paramenter
 *
 * @return List of reimbursements created by author with matching userID
*/

public List<Reimbursement> getReimbursementsByUser (int userID) {

	//tray+catch block to catch sql exception that can be thwown with connection
	try (Connection connection =Connection_Factory_Utility.getConnection()) {
		
		// SQL statement prepared as a string
		// In this instance, we are filtering reimbursements by an author (user) id
		String sql ="select * from ers_reimbursements by an author =?";
		
		//Prepareing the sql statement to be executed once we fill the query parameters
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql); 
		
		// Filling the missing query value (?) with the method parameter (userId)
		preparedStatement.setInt(parameterindex 1, userId); 
				
		//Building a sql result set from the execution of the query statement
		ResultSet resultSet = preparedStatement.executeQuery();
		
		// Initializing a new Reimbursement array list to house and return with the data from the database
		List<Reimbursement> reimbursements =new ArrayList<>();
		
		// This while loop will continue to add reimbursements to the list
		// unitl all the data from the result set has run out 
		while (resultSet.next() ) {
			
			//Adding reimbursements to the list with the data extracted from the database
			reimbursements.add(new Reimbursement(
					resultSet.getInt(columnLabel: "id"),
					resultSet.getInt(columnLabel: "author"),
					resultSet.getInt(columnLabel: "resolver"),
					resultSet.get.String(columnLabel: "description"),
					Reimbursement_Type.valueOf(resultSet.getString(columnlabel: "type")),
					Staus.valueOf(resultSet.getString(columnlabel:"status"))
					resultSet.getDouble(columnLabel:"amount")
					));	
		}
					
		//Return the list of reimbursements that hava a matching author (user) id
		return reimbursements;
	} catch (SQLException e) {
		
		// Catching the sql exception (this is a good place to utilize custom exception handling
		System.out.println("Something Went Wrong Obtaining Your List");
		e.printStackTrace();
	}
			
	//Fail=safe if the try*catch block does not run
	return null;
	
}
