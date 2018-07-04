package by.tc.vcl.dao;

import by.tc.vcl.dao.exception.DAOException;
import by.tc.vcl.entity.User;
import by.tc.vcl.entity.UserDetails;

public interface UserDAO {

	 User createAccount(UserDetails userDetails) throws DAOException;

	 User login(UserDetails userDetails) throws DAOException;
	
}
