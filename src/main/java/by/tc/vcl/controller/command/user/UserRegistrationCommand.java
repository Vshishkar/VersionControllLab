package by.tc.vcl.controller.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.vcl.entity.User;
import by.tc.vcl.entity.UserDetails;
import by.tc.vcl.service.UserService;
import by.tc.vcl.service.ServiceFactory;
import by.tc.vcl.service.exception.ServiceException;

public class UserRegistrationCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String login =  (String) request.getParameter("Login");		
		String password = (String) request.getParameter("Password");		
		String email = (String) request.getParameter("Email");
		
		UserDetails userDetails = new UserDetails(login,email,password);				
		ServiceFactory factory = ServiceFactory.getInstance();		
		UserService service = factory.getUserService();
		
		User user = null;
		try {
			user =  service.createAccount(userDetails);
		} catch (ServiceException e) {
			e.printStackTrace();
			try {
				response.sendRedirect("/WEB-INF/jsp/404.jsp");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
