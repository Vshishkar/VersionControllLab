package by.tc.vcl.service;

import by.tc.vcl.service.repository.RepositoryService;
import by.tc.vcl.service.repository.RepositoryServiceImpl;
import by.tc.vcl.service.user.UserService;
import by.tc.vcl.service.user.UserServiceImpl;

public class ServiceFactory {
	private ServiceFactory() {};
	
	private static final  ServiceFactory instance = new ServiceFactory();
	
	private final UserService userService = new UserServiceImpl();

	private final RepositoryService repositoryService = new RepositoryServiceImpl();

	public static synchronized ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public RepositoryService getRepositoryService() {
		return repositoryService;
	}
}
