package by.tc.vcl.service;

import by.tc.vcl.entity.User;
import by.tc.vcl.entity.UserDetails;
import by.tc.vcl.service.exception.ServiceException;

public interface UserService {

	User createAccount(UserDetails userDetails) throws ServiceException;

	User login(UserDetails userDetails) throws  ServiceException;

}
