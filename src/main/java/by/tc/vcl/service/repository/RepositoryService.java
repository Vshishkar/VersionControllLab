package by.tc.vcl.service.repository;

import by.tc.vcl.entity.repository.Repository;
import by.tc.vcl.entity.user.User;

public interface RepositoryService {

    void addContributor(User user);


    /**
     *
     *  create  {@param repository},which is created by {@param user}
     *
     */
    void createRepository(Repository repository,User user);




}
