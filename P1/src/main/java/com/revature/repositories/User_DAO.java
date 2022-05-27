package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.Reimbursement_Type;
import com.revature.models.Roles;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.utilities.Connection_Factory_Utility;

public class User_DAO {

	
public User getUserbyId(int id) throws SQLException {

		 //try+catch block to catch sql exception that can be thrown with connection 
		 try(Connection connection = Connection_Factory_Utility.getConnection()) {
			 
			 String sql ="select * from ers_users where id = ?";
			 
			//when we need parameters we need to use a PREPARED Statement  as opposed to a Statement (seen above)
			PreparedStatement preparedStatement = connection.prepareStatement(sql); //prepareStatement() as opposed to createStatement()
	        
			//insert the methods argument (int id) as the first (and only) variable in our SQL query
			preparedStatement.setInt(1, id); //the 1 here is referring to the first parameter (?) found in our SQL String
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// if there are results in the result set...
			if (resultSet.next()) {
				
				// return a reimbursement with the data to be returned to the service layer
				return new User(
						resultSet.getInt("Id"),
						resultSet.getString("username"),
						resultSet.getString("password"),
						Roles.valueOf(resultSet.getString("role"))

						);	
			}
		 
					
			
		 } catch (SQLException e) {
			 System.out.println("Something went wrong with the database!");
			 e.printStackTrace();
		 }
		return null;
	 }
	
	
	private Roles Roles(String string) {
	// TODO Auto-generated method stub
	return null;
}


	public List<User> getAllUsers() throws SQLException {
		
			 try(Connection connection = Connection_Factory_Utility.getConnection()) {
						 
				String sql = "select * from ers_users;";
				
			
				PreparedStatement preparedStatement = connection.prepareStatement(sql); 
											
				ResultSet resultSet = preparedStatement.executeQuery();
						 
				List<User> userList = new ArrayList<>();
				
			
			while(resultSet.next()) {
				User u = new User(
						resultSet.getInt("Id"),
						resultSet.getString("username"),
						resultSet.getString("password"),
						Roles.valueOf(resultSet.getString("role"))
						);	
				userList.add(u);
			}
			return userList;
		}
		catch (SQLException e) {
			System.out.println("Something went wrong while getting employees");
			e.printStackTrace();
			return null;
		}
	}
			
	
	public static int addUser(User newEmployee) throws SQLException {
		// TODO Auto-generated method stub
		  
		// try+catch block to catch sql exception that can be thrown with connection
		try (Connection connection = Connection_Factory_Utility.getConnection()) {
			
			// writing out the (relativity complex) sql insert string to create a new record
			// we explicitly ask the database to return the new id after entry
			String sql = "INSERT INTO ers_users (id, username, password, role)"
					+ "VALUES(?,? ,? , ?::role)"
					+ "RETURNING ers_users.id";
			
			// We must use a prepared statement because we have parameters
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//use the PreparedStatementobjects method to insert values into the query
			//the values will come from the Reimbursement object we send in. 
			preparedStatement.setInt(1, newEmployee.getId());
			preparedStatement.setString(2, newEmployee.getUsername());
			preparedStatement.setString(3, newEmployee.getPassword());
			preparedStatement.setObject(4, newEmployee.getRole());	
			
						
			preparedStatement.executeUpdate();
		
		    //We need to use the result set to retrieve the newly generated ID after entry of the new record
		    ResultSet resultSet;
		    
		    //Here, we are checking that the sql query executed and returned the reimbursement record with new id
		    if((resultSet = preparedStatement.executeQuery()) !=null) {
		    	  //must call this to get the returned reimbursement record id
		    	resultSet.next();
		    	//finally returning the new id
		    	
		    	System.out.println("Employee " + newEmployee.getUsername() + " was created. Welcome to the team!");
			}
				return resultSet.getInt(1);
		    	
		    }
		
		 catch (SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
			
		}
		//Fail-safe if the try+catch block does not run
		return 0;
		
	}

	
	public static User getbyUsername(String username) throws SQLException{

		 //try+catch block to catch sql exception that can be thrown with connection 
		 try(Connection connection = Connection_Factory_Utility.getConnection()) {
			 
			 String sql ="select * from ers_users where id = ?";
			 
			//when we need parameters we need to use a PREPARED Statement  as opposed to a Statement (seen above)
			PreparedStatement preparedStatement = connection.prepareStatement(sql); //prepareStatement() as opposed to createStatement()
	        
			//insert the methods argument (int id) as the first (and only) variable in our SQL query
			preparedStatement.setString(1, username); //the 1 here is referring to the first parameter (?) found in our SQL String
			
			ResultSet resultSet = preparedStatement.executeQuery();
			List<User> userList = new ArrayList<User>();
			// if there are results in the result set...
			if (resultSet.next()) {
				
				// return a reimbursement with the data to be returned to the service layer
			 User u = new User(
						resultSet.getInt("Id"),
						resultSet.getString("username"),
						resultSet.getString("password"),
						Roles.valueOf(resultSet.getString("role"))

						);
				userList.add(u);
			}
		 
					
			
		 } catch (SQLException e) {
			 System.out.println("Something went wrong with the database!");
			 e.printStackTrace();
			 return null;
		 }
		return null;
		
	 }


}