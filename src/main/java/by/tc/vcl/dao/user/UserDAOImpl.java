package by.tc.vcl.dao.user;

import static by.tc.vcl.dao.query.DBQuery.CREATE_NEW_USER;
import static by.tc.vcl.dao.query.DBQuery.GET_USER_INFO;

import java.sql.*;

import by.tc.vcl.dao.user.auth.Authentication;
import by.tc.vcl.dao.exception.ConnectionPoolException;
import by.tc.vcl.dao.exception.DAOException;
import by.tc.vcl.dao.pool.ConnectionPool;
import by.tc.vcl.entity.user.User;
import by.tc.vcl.entity.user.UserDetails;

public class UserDAOImpl implements UserDAO {

	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
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

	@Override
	public User login(UserDetails userDetails) throws DAOException {

		String username = userDetails.getUsername();
		String password = userDetails.getPassword();

		User user = null;
		ConnectionPool connectionPool = ConnectionPool.getInstanse();

		try{
			connectionPool.initPoolData();
			Connection connection = connectionPool.takeConnection();

			preparedStatement = connection.prepareStatement(GET_USER_INFO);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			resultSet = preparedStatement.executeQuery();

			//TODO Fix result set. Next line will throw new SQLException();
			resultSet.next();

 			String DBUserPassword = resultSet.getString(3);
			String DBUserUsername = resultSet.getString(1);
			String DBUserEmail = resultSet.getString(2);

			if(Authentication.comparePasswords(password,DBUserPassword)
					&& Authentication.compareUsernames(username,DBUserUsername)){
				user = new User(DBUserUsername,DBUserEmail,DBUserUsername);
			}
			else{
				throw new DAOException("This user is already exists");
			}


		}catch (ConnectionPoolException e) {
			throw new DAOException("Error establishing connection", e);
		}
		catch(SQLException e) {
			throw new DAOException("Error executing sql query " , e);
		}
		return user;
	}


}
