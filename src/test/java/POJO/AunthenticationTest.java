package POJO;

public class AunthenticationTest {
	/*
	 * POJO - Plain old Java object - its class which follow encapsulation rule - data+function together data must be
	 *  priavte and functions are public
	 *  
	 *  '{
    "username" : "admin",
    "password" : "password123"
}'
	 */
	//Data - private 
	private String username;
	private String password;
	

	
	//Functions - public,getter - get the data and setter - set the data 
	
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
	
}
