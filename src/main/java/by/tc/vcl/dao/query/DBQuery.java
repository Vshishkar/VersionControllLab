package by.tc.vcl.dao.query;

public class DBQuery {

	private DBQuery() {};

	public static final String CREATE_NEW_USER= "insert into users(username,email,password) values (?,?,?)";

	public static final String GET_USER_INFO = "select username,email,password from users where username = ? and password = ?";
}
