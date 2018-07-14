package by.tc.vcl.service.repository;

import by.tc.vcl.dao.DAOFactory;
import by.tc.vcl.dao.exception.DAOException;
import by.tc.vcl.dao.repository.RepositoryDAO;
import by.tc.vcl.entity.repository.Repository;
import by.tc.vcl.entity.user.User;
import by.tc.vcl.service.exception.ServiceException;

public class RepositoryServiceImpl implements RepositoryService {

    public DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public void addContributor(User user) throws ServiceException {

        RepositoryDAO repositoryDAO = daoFactory.getRepositoryDAO();


        try {
            repositoryDAO.addContributor(user);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException("Service exception while adding new contributor",e);
        }

        return ;
    }

    @Override
    public void createRepository(Repository repository,User user) throws ServiceException {

        RepositoryDAO repositoryDAO = daoFactory.getRepositoryDAO();

        try {
            repositoryDAO.createRepository(repository,user);

        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException("Service exception while creating new repository",e);
        }


        return ;


    }
}
