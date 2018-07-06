package by.tc.vcl.dao.repository;

import static by.tc.vcl.dao.query.DBQuery.*;
import by.tc.vcl.dao.exception.ConnectionPoolException;
import by.tc.vcl.dao.exception.DAOException;
import by.tc.vcl.dao.pool.ConnectionPool;
import by.tc.vcl.entity.repository.Repository;
import by.tc.vcl.entity.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositoryDAOImpl implements RepositoryDAO {


    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;



    @Override
    public void addContributor(User user) throws DAOException {

        String username = user.getName();
        String email = user.getEmail();

        Connection connection = null;
        ConnectionPool connectionPool = ConnectionPool.getInstanse();

        try {
            connectionPool.initPoolData();

            connection = connectionPool.takeConnection();




        } catch (ConnectionPoolException e) {
            e.printStackTrace();
            throw new DAOException("Error establishing connection",e);
        }


        return;


    }


    @Override
    public void createRepository(Repository repository,User user) throws DAOException {

        String username = user.getName();
        String email = user.getEmail();
        String repositoryTitle = repository.getTitle();

        Connection connection = null;
        ConnectionPool connectionPool = ConnectionPool.getInstanse();

        try {
            connectionPool.initPoolData();

            connection = connectionPool.takeConnection();

            preparedStatement = connection.prepareStatement(CREATE_NEW_REPOSITORY);
            preparedStatement.setString(1,repositoryTitle);
            preparedStatement.executeUpdate();

            preparedStatement = null;

            preparedStatement = connection.prepareStatement(GET_REPOSITORY_BY_TITLE);
            preparedStatement.setString(1,repositoryTitle);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();


            int repositoryId = resultSet.getInt(1);

            resultSet = null;
            preparedStatement = null;

            preparedStatement = connection.prepareStatement(GET_USER_BY_NAME);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int userId =  resultSet.getInt(1);

            preparedStatement = null;
            preparedStatement = connection.prepareStatement(CONNECT_REPOSITORY_2_USER);
            preparedStatement.setInt(1,userId);
            preparedStatement.setInt(2,repositoryId);
            preparedStatement.executeUpdate();


        } catch (ConnectionPoolException e) {
            e.printStackTrace();
            throw new DAOException("Error establishing connection",e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Error executing sql query",e);
        }

    }

    @Override
    public List<Repository> getRepositoryByUsername(String username) throws DAOException {



        Connection connection = null;
        ConnectionPool connectionPool = ConnectionPool.getInstanse();

        List<Repository> repositories = new ArrayList<>();

        try {
            connectionPool.initPoolData();

            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(GET_REPOSITORY_BY_USERNAME);
            preparedStatement.setString(1,username);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String repositoryTitle = resultSet.getString(1);
                repositories.add(new Repository(repositoryTitle));
            }


        } catch (ConnectionPoolException e) {
            e.printStackTrace();
            throw new DAOException("Error establishing connection",e);
        }catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Error executing sql query",e);
        }

        if(repositories.size() == 0){
            return Collections.emptyList();
        }


        return repositories;
    }
}
