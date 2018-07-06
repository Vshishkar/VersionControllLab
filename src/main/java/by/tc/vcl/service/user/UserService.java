package by.tc.vcl.service.user;

import by.tc.vcl.entity.user.User;
import by.tc.vcl.entity.user.UserDetails;
import by.tc.vcl.service.exception.ServiceException;

public interface UserService {

	User createAccount(UserDetails userDetails) throws ServiceException;

	User login(UserDetails userDetails) throws  ServiceException;

}
