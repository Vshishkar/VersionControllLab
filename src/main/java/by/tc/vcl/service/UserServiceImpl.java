package by.tc.vcl.service;

import by.tc.vcl.dao.DAOFactory;
import by.tc.vcl.dao.UserDAO;
import by.tc.vcl.dao.exception.DAOException;
import by.tc.vcl.entity.User;
import by.tc.vcl.entity.UserDetails;
import by.tc.vcl.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	private static final DAOFactory factory = DAOFactory.getInstance();
	
	@Override
	public User createAccount(UserDetails userDetails) throws ServiceException {
		
		UserDAO userDAO = factory.getUserDAO();
		
		User user = null;
		
		try {
			user = userDAO.createAccount(userDetails);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Service Error: can't registrate user",e);
		}
		
		return user;
	}

	@Override
	public User login(UserDetails userDetails) throws ServiceException {

		UserDAO userDAO = factory.getUserDAO();

		User user = null;

		try {
			user = userDAO.login(userDetails);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Service Error: can't login user",e);
		}

		return user;
	}

}
