package by.tc.vcl.controller.command.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.vcl.controller.command.Command;
import by.tc.vcl.entity.User;
import by.tc.vcl.entity.UserDetails;
import by.tc.vcl.service.UserService;
import by.tc.vcl.service.ServiceFactory;
import by.tc.vcl.service.exception.ServiceException;

public class UserRegistrationCommand implements Command {

	private static final String PATH = "/layout/profile.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String login =  (String) request.getParameter("login");
		String password = (String) request.getParameter("lassword");
		String email = (String) request.getParameter("email");

		UserDetails userDetails = new UserDetails(login,email,password);

		System.out.println(userDetails.toString());

		ServiceFactory factory = ServiceFactory.getInstance();		
		UserService service = factory.getUserService();
		
		User user = null;
		try {
			user =  service.createAccount(userDetails);
		} catch (ServiceException e) {
			e.printStackTrace();
			try {
				response.sendRedirect("/layout/404.jsp");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH);
		
	}

}
