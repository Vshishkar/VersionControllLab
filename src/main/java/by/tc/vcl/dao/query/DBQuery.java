package by.tc.vcl.dao.query;

public class DBQuery {

	private DBQuery() {};

	public static final String CREATE_NEW_REPOSITORY="INSERT INTO `version_control_db`.`repositories`\n" +
			"(\n" +
			"`title`)\n" +
			"VALUES\n" +
			"(\n" +
			"?);";

	public static final String GET_REPOSITORY_BY_TITLE="SELECT id_rep,title FROM `version_control_db`.`repositories` WHERE title = ?";

	public static final String GET_REPOSITORY_BY_USERNAME = "select title from repositories \n" +
			"\tinner join user2repository on \n" +
			"\t\tuser2repository.repositories_id_rep = repositories.id_rep\n" +
			"\tinner join users on users.id_user = user2repository.users_id_user\n" +
			"    where users.username = ?";

	public static final String GET_USER_BY_NAME = "SELECT id_user,username FROM users WHERE username = ?";

	public static final String CONNECT_REPOSITORY_2_USER="INSERT INTO `version_control_db`.`user2repository`\n" +
			"(`users_id_user`,\n" +
			"`repositories_id_rep`)\n" +
			"VALUES\n" +
			"(?,\n" +
			"?);";

	public static final String CREATE_NEW_USER= "insert into users(username,email,password) values (?,?,?)";

	public static final String GET_USER_INFO = "select username,email,password from users where username = ? and password = ?";
}
