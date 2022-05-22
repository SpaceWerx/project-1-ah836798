package com.revature.repositories;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
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
		PreparedStatement preparedStatement = connection.preparedStatment(sql); //prepareStatement() as opposed to createStatement()
        
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


