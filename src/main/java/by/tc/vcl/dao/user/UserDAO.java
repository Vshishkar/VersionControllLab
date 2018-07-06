package by.tc.vcl.dao.user;

import by.tc.vcl.dao.exception.DAOException;
import by.tc.vcl.entity.user.User;
import by.tc.vcl.entity.user.UserDetails;

public interface UserDAO {

	 User createAccount(UserDetails userDetails) throws DAOException;

	 User login(UserDetails userDetails) throws DAOException;
	
}
