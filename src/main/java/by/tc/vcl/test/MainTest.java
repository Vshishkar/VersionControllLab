package by.tc.vcl.test;

import by.tc.vcl.dao.DAOFactory;
import by.tc.vcl.dao.repository.RepositoryDAO;
import by.tc.vcl.dao.repository.RepositoryDAOImpl;
import by.tc.vcl.dao.user.UserDAO;
import by.tc.vcl.dao.exception.DAOException;
import by.tc.vcl.entity.repository.Repository;
import by.tc.vcl.entity.user.User;
import by.tc.vcl.entity.user.UserDetails;

import java.util.List;

public class MainTest {
	
	public static void main(String [] args) {
		
		UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
		
		String username = "User3";
		String password = "1234";
		String email = "us2er@email.com";
		
		UserDetails userDetails = new UserDetails(username, email, password);
		User registeredUser = null;
		try {
			 registeredUser = userDAO.createAccount(userDetails);
		} catch (DAOException e) {
			e.printStackTrace();
		}

		registeredUser = new User(username,email,username);

		Repository repository = new Repository("mySecondTestRep");

		RepositoryDAO repositoryDAO = new RepositoryDAOImpl();

		try {
			repositoryDAO.createRepository(repository,registeredUser);
		} catch (DAOException e) {
			e.printStackTrace();
			System.out.println("unLucky :(");
		}

		System.out.println(registeredUser.toString());

		List<Repository> repositories = null;

		try {
			repositories = repositoryDAO.getRepositoryByUsername(username);
		} catch (DAOException e) {
			e.printStackTrace();
		}

		System.out.println(repositories.toString());

	}

}
