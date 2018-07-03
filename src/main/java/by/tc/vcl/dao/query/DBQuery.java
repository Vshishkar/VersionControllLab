package by.tc.vcl.dao.query;

public class DBQuery {

	private DBQuery() {};
	
	public static final String getUsers = "SELECT * FROM USERS";
	
	public static final String CREATE_NEW_USER= "insert into users(username,email,password) values (?,?,?)";
	
	
}
