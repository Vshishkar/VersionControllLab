package by.tc.vcl.dao;

import by.tc.vcl.dao.repository.RepositoryDAO;
import by.tc.vcl.dao.repository.RepositoryDAOImpl;
import by.tc.vcl.dao.user.UserDAO;
import by.tc.vcl.dao.user.UserDAOImpl;

public class DAOFactory {
private static final DAOFactory instance = new DAOFactory();
	
	private final UserDAO userDAO = new UserDAOImpl();
	
	private DAOFactory() {}

	public static DAOFactory getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	};

	public final RepositoryDAO repositoryDAO = new RepositoryDAOImpl();

	public RepositoryDAO getRepositoryDAO() {
		return repositoryDAO;
	}
}
