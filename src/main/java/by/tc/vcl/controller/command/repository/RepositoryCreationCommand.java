package by.tc.vcl.controller.command.repository;

import static by.tc.vcl.util.RequestParameterKey.*;
import static by.tc.vcl.util.PageURL.*;
import by.tc.vcl.controller.command.Command;
import by.tc.vcl.entity.repository.Repository;
import by.tc.vcl.entity.user.User;
import by.tc.vcl.service.ServiceFactory;
import by.tc.vcl.service.exception.ServiceException;
import by.tc.vcl.service.repository.RepositoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RepositoryCreationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String repositoryTitle = request.getParameter(REPOSITORY_TITLE);

        Repository repository = new Repository(repositoryTitle);

        User user = (User) request.getSession(false).getAttribute("user");

        if(user == null){
            System.out.println("user is null :(");
        }

        RepositoryService repositoryService = ServiceFactory.getInstance().getRepositoryService();

        try {
            repositoryService.createRepository(repository,user);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.sendRedirect(ERROR_PAGE);
        }

    }
}
