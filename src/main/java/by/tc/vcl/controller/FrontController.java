package by.tc.vcl.controller;

import by.tc.vcl.controller.command.Command;
import by.tc.vcl.controller.command.CommandDirector;
import by.tc.vcl.controller.command.CommandType;
import by.tc.vcl.entity.UserDetails;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String commandType = request.getParameter("command");
		System.out.println(commandType);
		Command command = CommandType.getCommand(commandType);
		CommandDirector commandDirector = new CommandDirector(command);
		command.execute(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	
}
