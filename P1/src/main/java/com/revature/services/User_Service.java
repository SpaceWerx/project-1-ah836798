package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.revature.models.Roles;
import com.revature.models.User;
import com.revature.repositories.User_DAO;

public class User_Service {
	static User_DAO userDAO = new User_DAO();

    public static User getUsername(String username) throws SQLException {
        return User_DAO.getbyUsername(username);
    }
//////////////////////////////////////////////////

    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////
    public void UserExistsById(int id) throws SQLException {
    for(User user : userDAO.getAllUsers()) {
        if(user.getId()== id) {
            System.out.println("This ID exists");
            break;
        }
    }
        System.out.println("This ID does not exist");
}
//////////////////////////////////////////////
    public List<User> getUserByRole(Roles role) throws SQLException{
        List<User> byRole = new ArrayList<>();
        for(User user : userDAO.getAllUsers()) {
            if(user.getRole() == role) 
            {
                byRole.add(user);
            }
        }

        return byRole;
    }
/////////////////////////////////////////////////////////////////////////
    public static User getUserById(int userid) throws SQLException {
        return userDAO.getUserbyId(userid);
    }
//////////////////////////////////////////////////////////////////////////
    public void addUser(User newEmployee) throws SQLException {

        //take in the Employee object sent from the menu and send it to the EmployeeDAO to be inserted into the database

        //call the DAO method that inserts the new Employee
        User_DAO.addUser(newEmployee);
    }

    public boolean checkUserExistsById(int id) {
        return false;
    }

}