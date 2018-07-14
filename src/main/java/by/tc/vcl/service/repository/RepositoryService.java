package by.tc.vcl.service.repository;

import by.tc.vcl.entity.repository.Repository;
import by.tc.vcl.entity.user.User;
import by.tc.vcl.service.exception.ServiceException;

public interface RepositoryService {

    void addContributor(User user) throws ServiceException;


    /**
     *
     *  create  {@param repository},which is created by {@param user}
     *
     */
    void createRepository(Repository repository,User user) throws ServiceException;




}
