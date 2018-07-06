package by.tc.vcl.service;

import by.tc.vcl.service.user.UserService;
import by.tc.vcl.service.user.UserServiceImpl;

public class ServiceFactory {
	private ServiceFactory() {};
	
	private static final  ServiceFactory instance = new ServiceFactory();
	
	private final UserService userService = new UserServiceImpl();

	public static synchronized ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}
	
	
}
