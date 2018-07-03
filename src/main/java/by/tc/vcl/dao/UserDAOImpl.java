package by.tc.vcl.dao;

import static by.tc.vcl.dao.query.DBQuery.CREATE_NEW_USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.tc.vcl.dao.exception.ConnectionPoolException;
import by.tc.vcl.dao.exception.DAOException;
import by.tc.vcl.dao.pool.ConnectionPool;
import by.tc.vcl.entity.User;
import by.tc.vcl.entity.UserDetails;

public class UserDAOImpl implements UserDAO {

	private PreparedStatement preparedStatement = null;
	
	@Override
	public User createAccount(UserDetails userDetails) throws DAOException {
		
        String username = userDetails.getUsername();
        String email = userDetails.getEmail();
        String password = userDetails.getPassword();

		ConnectionPool connectionPool = ConnectionPool.getInstanse();
		try {
			connectionPool.initPoolData();
			Connection connection = connectionPool.takeConnection();
			
			preparedStatement = connection.prepareStatement(CREATE_NEW_USER);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			preparedStatement.executeUpdate();
			
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error establishing connection", e);
		}catch(SQLException e) {
			throw new DAOException("Error executing sql query " , e);
		}
		
		return new User(username,username,email);
	}

	
}
