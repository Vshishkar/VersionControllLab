package by.tc.vcl.controller.command.user;

import by.tc.vcl.controller.command.Command;
import by.tc.vcl.entity.user.User;
import by.tc.vcl.entity.user.UserDetails;
import by.tc.vcl.service.ServiceFactory;
import by.tc.vcl.service.user.UserService;
import by.tc.vcl.service.exception.ServiceException;

import static by.tc.vcl.util.PageURL.*;
import static by.tc.vcl.util.RequestParameterKey.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserSignInCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        UserDetails userDetails = new UserDetails(username,password);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        UserService userService = serviceFactory.getUserService();

        User user = null;

        try {
            user = userService.login(userDetails);

            HttpSession httpSession = request.getSession(true);

            httpSession.setAttribute("user",user);

            response.sendRedirect(request.getContextPath() + PROFILE_PAGE);


        } catch (ServiceException e) {
            response.sendRedirect(request.getContextPath() + ERROR_PAGE);
            e.printStackTrace();
        }


    }
}
