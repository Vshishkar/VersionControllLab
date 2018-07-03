package by.tc.vcl.test;

import by.tc.vcl.dao.DAOFactory;
import by.tc.vcl.dao.UserDAO;
import by.tc.vcl.dao.exception.DAOException;
import by.tc.vcl.entity.User;
import by.tc.vcl.entity.UserDetails;

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
	
		System.out.println(registeredUser.toString());
		
	}

}
