package by.tc.vcl.dao.repository;

import by.tc.vcl.dao.exception.DAOException;
import by.tc.vcl.entity.repository.Repository;
import by.tc.vcl.entity.user.User;

import java.util.List;

public interface RepositoryDAO {

    void addContributor(User user) throws DAOException;

    void createRepository(Repository repository,User user) throws DAOException;

    List<Repository> getRepositoryByUsername(String username) throws DAOException;

}
