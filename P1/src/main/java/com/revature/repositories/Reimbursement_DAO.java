package com.revature.repositories;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.Reimbursement_Type;
import com.revature.models.Status;
import com.revature.services.Reimbursement_Service;
import com.revature.utilities.Connection_Factory_Utility;


public class Reimbursement_DAO {

	





/**
 * Should retrieve a Reimbursement from the DB with the corresponding id or null if there is no match.
 */
	
 public Reimbursement getReimbursementbyId(int id) {

	 //try+catch block to catch sql exception that can be thrown with connection 
	 try(Connection connection = Connection_Factory_Utility.getConnection()) {
		 
		 String sql ="select * from ers_reimbursements where id = ?";
		 
		//when we need parameters we need to use a PREPARED Statement  as opposed to a Statement (seen above)
		PreparedStatement preparedStatement = connection.prepareStatement(sql); //prepareStatement() as opposed to createStatement()
        
		//insert the methods argument (int id) as the first (and only) variable in our SQL query
		preparedStatement.setInt(1, id); //the 1 here is referring to the first parameter (?) found in our SQL String
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		// if there are results in the result set...
		if (resultSet.next()) {
			
			// return a reimbursement with the data to be returned to the service layer
			return new Reimbursement(
					resultSet.getInt("id"),
					resultSet.getInt("author"),
					resultSet.getInt("resolver"),
					Reimbursement_Type.valueOf(resultSet.getString("type")),
					Status.valueOf(resultSet.getString("status")),
					resultSet.getDouble("amount")
					);	
		
		}
	 
				
		
	 } catch (SQLException e) {
		 System.out.println("Something went wrong with the database!");
		 e.printStackTrace();
	 }
 }



     //Fail=safe if the try+catch block does not run
   
/**
 *This method is inteded to extract any reimbursements from the database
 *that were submitted by a specific user, whose ID is passed in as a paramenter
 *
 * @return List of reimbursements created by author with matching userID
*/

public List<Reimbursement> getReimbursementsByUser(int userID) {

	//try+catch block to catch sql exception that can be thrown with the connection
	try (Connection connection =Connection_Factory_Utility.getConnection()) {
		
		// SQL statement prepared as a string
		// In this instance, we are filtering reimbursements by an author (user) id
		String sql ="select * from ers_reimbursements by an author =?";
		
		//Prepareing the sql statement to be executed once we fill the query parameters
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql); 
		
		// Filling the missing query value (?) with the method parameter (userId)
		preparedStatement.setInt(1, userID); 
				
		//Building a sql result set from the execution of the query statement
		ResultSet resultSet = preparedStatement.executeQuery();
		
		// Initializing a new Reimbursement array list to house and return with the data from the database
		List<Reimbursement> reimbursements =new ArrayList<>();
		
		// This while loop will continue to add reimbursements to the list
		// unitl all the data from the result set has run out 
		while (resultSet.next() ) {
			
			//Adding reimbursements to the list with the data extracted from the database
			reimbursements.add(new Reimbursement(
					resultSet.getInt("id"),
					resultSet.getInt("author"),
					resultSet.getInt("resolver"),
					resultSet.getString("description"),
					Reimbursement_Type.valueOf(resultSet.getString("type")),
					Status.valueOf(resultSet.getString("status")),
					resultSet.getDouble("amount")
					
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


/** 
 * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
 */

public List<Reimbursement> getByStatus(Status status) {
	
	// try+catch block to catch sql exception that can be thrown with connection 
 try (Connection connection =Connection_Factory_Utility.getConnection()) {
		
	//Write the query that we want to send to the database and assign it a String
	String sql ="select * from ers_reimbursements by an status =?::status";
	
	//Put the SQL query into a Statement ohject (The Connection object has a method for this implicitly). 
	
	PreparedStatement preparedStatement = connection.prepareStatement(sql); 
	
	// Filling the missing query value (?) with the method parameter (userId)
	preparedStatement.setInt(1, status.toString()); 
			
	//Execute the Query by putting the results of the query into our ResultSet object (resultSet)
	//The Statement object has a method that takes Strings to execute as a SQL query
	ResultSet resultSet = preparedStatement.executeQuery();
	
	// ALL THE CODE ABOVE MAKES A CALL TO OUR DATABASE. Now we need to store the data in an ArrayList.
	List<Reimbursement> reimbursements =new ArrayList<>(); //Upcasting, we are instantiating an Arraylist
	
	//while there are results in the results
	 while (resultSet.next() ) {
		
		//Adding reimbursements to the list with the data extracted from the database
		reimbursements.add(new Reimbursement(
				resultSet.getInt("id"),
				resultSet.getInt("author"),
				resultSet.getInt("resolver"),
				resultSet.getString("description"),
				Reimbursement_Type.valueOf(resultSet.getString("type")),
				Status.valueOf(resultSet.getString("status")),
				resultSet.getDouble("amount")	
				
		));
		
	 }
				
	//when there are no more results in resultSet, the while loop will break
	//then, return the populated ArrayList of Users
	 return reimbursements;
	
 } catch (SQLException e) {
	
	// Catching the sql exception (this is a good place to utilize custom exception handling
	System.out.println("Something Went Wrong obtaining the reimbursements!");
	e.printStackTrace();
 }
		
 //Fail=safe if the try*catch block does not run
 return null;
}


public List<Reimbursement> getAllReimbursement() {
	
	// try+catch block to catch sql exception that can be thrown with connection 
 try (Connection connection =Connection_Factory_Utility.getConnection()) {
	
	 // Instantiate a new arrayList to store the records from the database
	 List<Reimbursement> reimbursements =new ArrayList<>();
	 
	//Write out the appropriate sql query string 
	String sql ="select * from ers_reimbursements";
	
	// we can use createStatement in this case because we do not have any parameters in the query
	
	Statement statement = connection.createStatement();
	
	//storing the records from the query in a result set
	ResultSet resultSet = statement.executeQuery(sql);
	
	// Looping over the records from the query to then add to the return list 
			
	while(resultSet.next() ) {
		reimbursements.add(new Reimbursement(
				resultSet.getInt("id"),
				resultSet.getInt("author"),
				resultSet.getInt("resolver"),
				resultSet.getString("description"),
				Reimbursement_Type.valueOf(resultSet.getString("type")),
				Status.valueOf(resultSet.getString("status")),
				resultSet.getDouble("amount")
		));	
	 }			
	// returning the list of records after the result set runs out
	return reimbursements;
	
 } catch (SQLException e) {
	
	// Catching the sql exception (this is a good place to utilize custom exception handling
	System.out.println("Something Went Wrong obtaining the reimbursements!");
	e.printStackTrace();
 }
		
 //Fail=safe if the try*catch block does not run
 return null;
}



// The create method is meant to create a new record in the database for new reimbursement submissions

public int create(Reimbursement reimbursementToBeSubmitted, int columnindex) {
  
	// try+catch block to catch sql exception that can be thrown with connection
	try (Connection connection = Connection_Factory_Utility.getConnection()) {
		
		// writing out the (relativity complex) sql insert string to create a new record
		// we explicitly ask the database to return the new id after entry
		String sql = "INSERT INTO ers_reimbursements (author, description, type, status, amount)"
				+ "VALUES(?, ? .?::type, ?::status, ?)"
				+ "RETURNING ers_reimbursements.id";
		
		// We must use a prepared statement because we have parameters
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		//use the PreparedStatementobjects method to insert values into the query
		//the values will come from the Reimbursement object we send in. 
		preparedStatement.setInt(1, reimbursementToBeSubmitted.getAuthor());
		preparedStatement.setString(2, reimbursementToBeSubmitted.getDescription());
		preparedStatement.setObject(3, reimbursementToBeSubmitted.getType().name());
		preparedStatement.setObject(4, reimbursementToBeSubmitted.getStatus());		
	    preparedStatement.setDouble(5, reimbursementToBeSubmitted.getAmount());
	
	    //We need to use the result set to retrieve the newly generated ID after entry of the new record
	    ResultSet resultSet;
	    
	    //Here, we are checking that the sql query executed and returned the reimbursement record with new id
	    if((resultSet = preparedStatement.executeQuery()) !=null) {
	    	  //must call this to get the returned reimbursement record id
	    	resultSet.next();
	    	//finally returning the new id
	    	
			return resultSet.getInt(1);
	    	
	    }
	
	} catch (SQLException e) {
		System.out.println("Creating reimbursement has failed");
		e.printStackTrace();
		
	}
	//Fail-safe if the try+catch block does not run
	return 0;
	
}



	
	/** 
	 * The update method is meant to process reimbursements
	 * This method is void because we are only using it to update specific fields in a given record
	 */

public void update(Reimbursement unprocessedReimbursement) {

	//try-catch block to catch sql exception that can be thrown with connection 
	try (Connection connection = Connection_Factory_Utility.getConnection()) {

		//Write the query that we want to send to the database and assign it to a String 	
		String sql = "UPDATE ers reimbursements SET resolver = ?, status = ?::status WHERE id = ?";

		//Creating a prepared statement with the sql string we created
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		//Setting the update parameteres (?'s) with their respective values.
		int paramenterindex;
		preparedStatement.setInt(1, unprocessedReimbursement.getResolver());
		preparedStatement.setObject(2, unprocessedReimbursement.getStatus().name());
		preparedStatement.setInt(3, unprocessedReimbursement.getId());

		//executing the record update
		preparedStatement.executeUpdate();
	
		// Proclaim victory
		System.out.println("Reimbursement Successfuly Updated!");

	} catch (SQLException e) {
		System.out.println("Updating Failed!"); //Proclaim defeat
		e.printStackTrace(); // useful debugging tool
	}
}



	public Object getByStatus(Class<Status> class1) {
		// TODO Auto-generated method stub
		return null;
	}
}

