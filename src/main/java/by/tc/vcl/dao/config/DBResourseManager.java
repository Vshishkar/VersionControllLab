package by.tc.vcl.dao.config;

import java.util.ResourceBundle;

import by.tc.vcl.dao.config.DBResourseManager;

public class DBResourseManager {

	private final static DBResourseManager instance = new DBResourseManager();
	
	private ResourceBundle bundle = ResourceBundle.getBundle("db");

	public static DBResourseManager getInstance() {
		return instance;
	}
	
	public String getValue(String key) {
		return this.bundle.getString(key);
	}
	
}