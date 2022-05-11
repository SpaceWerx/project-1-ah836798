package Models;

import mockuserdata.java;

public class User_Model {

  private int userId;
  private String userName;
  private String passWord;
  private Roles role;
  
  //create boilerplate code//
  
//created the constructor for User_Model//
public User_Model() {
	super();
	//created the constructor for User_Model//
	// TODO Auto-generated constructor stub
}

//created the constructor for User_Model fields //
public User_Model(int userId, String userName, String passWord, Roles ole) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.passWord = passWord;
	this.role = role;
	
}

//Generated getters and setters for User_Model//
public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassWord() {
	return passWord;
}

public void setPassWord(String passWord) {
	this.passWord = passWord;
}

public Roles getRole() {
	return role;
}

public void setRole(Roles role) {
	this.role = role;
}
//generate toString//

@Override
public String toString() {
	return "User_Model [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", role=" + role
			+ "]";
}


//generate hashCode() and equals//

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	result = prime * result + userId;
	result = prime * result + ((userName == null) ? 0 : userName.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User_Model other = (User_Model) obj;
	if (passWord == null) {
		if (other.passWord != null)
			return false;
	} else if (!passWord.equals(other.passWord))
		return false;
	if (role != other.role)
		return false;
	if (userId != other.userId)
		return false;
	if (userName == null) {
		if (other.userName != null)
			return false;
	} else if (!userName.equals(other.userName))
		return false;
	return true;
}





}


  


