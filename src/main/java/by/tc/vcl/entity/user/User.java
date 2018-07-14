package by.tc.vcl.entity.user;

import java.io.Serializable;

public class User implements Serializable {
	
	private String name;
	
	private String email;
	
	private String login;

	public User() {
		super();
	}

	public User(String name, String email, String login) {
		super();
		this.name = name;
		this.email = email;
		this.login = login;
	}

	@Override
	public String toString() {
		
		return name + " " + email + " " + login + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return this.getEmail().equals(other.getEmail()) 
				&& this.getLogin().equals(other.getLogin())
				&& this.getName().equals(other.getLogin());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	

}
