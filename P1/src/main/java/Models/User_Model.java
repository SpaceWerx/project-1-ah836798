package Models;

//need to import the data from Mockuserdata.java//

public class User_Model {

  private int userid;
  private String username;
  private String password;
  private Roles role;

  
  //create boilercode//
  
  //created superclass//
  
  public User_Model() {
	super();
	// TODO Auto-generated constructor stub
}
//create fields//
public User_Model(int userid, String username, String password, Roles role) {
	super();
	this.userid = userid;
	this.username = username;
	this.password = password;
	this.role = role;
}

//created getters and setters//

public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Roles getRole() {
	return role;
}
public void setRole(Roles role) {
	this.role = role;
}
//created toString();
@Override
public String toString() {
	return "User_Model [userid=" + userid + ", username=" + username + ", password=" + password + ", role=" + role
			+ "]";
}

//created hashcode() and equals//


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	result = prime * result + userid;
	result = prime * result + ((username == null) ? 0 : username.hashCode());
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
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (role != other.role)
		return false;
	if (userid != other.userid)
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}
  
  
}

  

