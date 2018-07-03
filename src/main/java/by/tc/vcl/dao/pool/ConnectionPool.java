package by.tc.vcl.dao.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import by.tc.vcl.dao.config.DBParameter;
import by.tc.vcl.dao.config.DBResourseManager;
import by.tc.vcl.dao.exception.ConnectionPoolException;
import by.tc.vcl.dao.pool.ConnectionPool;

public final class ConnectionPool {

	private static final ConnectionPool instanse = new ConnectionPool();
 
	public static ConnectionPool getInstanse() {
		return instanse;
	}
	
	private BlockingQueue<Connection> connectionQueue;
	
	private BlockingQueue<Connection> givenAwayConQueue;
	
	private String driverName;
	private String url;
	private String password;
	private String user;
	private int poolSize;

	private ConnectionPool() {
		DBResourseManager dbResourseManager = DBResourseManager.getInstance();
		
		this.driverName = dbResourseManager.getValue(DBParameter.DB_DRIVER);
		this.url = dbResourseManager.getValue(DBParameter.DB_URL);
		this.password = dbResourseManager.getValue(DBParameter.DB_PASSWORD);
		this.user = dbResourseManager.getValue(DBParameter.DB_USER);
		try {
			this.poolSize = Integer.parseInt(dbResourseManager.getValue(DBParameter.DB_POOLSIZE));
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
			this.poolSize = 5;
		}
	}

	public void initPoolData() throws ConnectionPoolException {
		try {
			Class.forName(driverName);
			givenAwayConQueue = new ArrayBlockingQueue<>(poolSize);
			connectionQueue = new ArrayBlockingQueue<>(poolSize);
			
			for(int i = 0; i < poolSize;i++) {
				Connection connection = DriverManager.getConnection(url, user, password);
				PooledConnection pooledConnection = new PooledConnection(connection);
				connectionQueue.add(pooledConnection);
			}
			
		}catch(SQLException e) {
			throw new ConnectionPoolException("SQLException in connection pool");
		}
		catch(ClassNotFoundException e) {
			throw new ConnectionPoolException("Can't find database driver class",e);
		}
		
	}

	
	public void dispose() {
		clearConnectionQueue();
	}
	
	private void clearConnectionQueue() {
		try {
			closeConnectionsQueue(connectionQueue);
			closeConnectionsQueue(givenAwayConQueue);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public BlockingQueue<Connection> getGivenAwayConQueue() {
		return givenAwayConQueue;
	}

	public void setGivenAwayConQueue(BlockingQueue<Connection> givenAwayConQueue) {
		this.givenAwayConQueue = givenAwayConQueue;
	}
	
	public BlockingQueue<Connection> getConnectionQueue() {
		return connectionQueue;
	}

	public void setConnectionQueue(BlockingQueue<Connection> connectionQueue) {
		this.connectionQueue = connectionQueue;
	}
	
	public Connection takeConnection() throws ConnectionPoolException {
		Connection connection = null;
		try {
			connection = connectionQueue.take();
			givenAwayConQueue.add(connection);
		}catch(InterruptedException e) {
			throw new ConnectionPoolException("Error connecting to the data sourse",e);
		}
		
		return connection;	
	}
	
	public void closeConnection(Connection conn,Statement st,ResultSet rs) {
		try {
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			st.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void closeConnection(Connection conn,Statement st) {
		try {
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			st.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void closeConnectionsQueue(BlockingQueue<Connection> queue) throws SQLException {
		Connection connection;
		while((connection = queue.poll()) != null) {
			if(!connection.getAutoCommit()) {
			connection.commit();
			}
			((PooledConnection) connection).reallyClose();
		}
		
	}
	


}