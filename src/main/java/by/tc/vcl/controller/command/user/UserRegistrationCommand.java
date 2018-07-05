package by.tc.vcl.controller.command.user;

import java.io.IOException;
import static by.tc.vcl.util.PageURL.*;
import static by.tc.vcl.util.RequestParameterKey.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.vcl.controller.command.Command;
import by.tc.vcl.entity.User;
import by.tc.vcl.entity.UserDetails;
import by.tc.vcl.service.UserService;
import by.tc.vcl.service.ServiceFactory;
import by.tc.vcl.service.exception.ServiceException;

public class UserRegistrationCommand implements Command {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login =  (String) request.getParameter(LOGIN);
		String password = (String) request.getParameter(PASSWORD);
		String email = (String) request.getParameter(EMAIL);

		UserDetails userDetails = new UserDetails(login,email,password);

		ServiceFactory factory = ServiceFactory.getInstance();		
		UserService service = factory.getUserService();
		
		User user = null;
		try {
			user =  service.createAccount(userDetails);
		} catch (ServiceException e) {
			e.printStackTrace();
			try {
				response.sendRedirect(request.getContextPath() + ERROR_PAGE);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		response.sendRedirect(request.getContextPath() + PROFILE_PAGE);
    }

}
