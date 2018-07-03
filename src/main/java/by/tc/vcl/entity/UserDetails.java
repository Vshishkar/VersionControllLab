package by.tc.vcl.entity;

public class UserDetails {

	public String username;
	
	public String password;
	
	public String email;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserDetails(String username,String password) {
		this.username = username;
		this.password = password;
	}
	
	public UserDetails() {}
	
	public UserDetails(String username,String email,String password) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public String getUsername() {
		return this.username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		UserDetails other = (UserDetails) obj;
	
		return this.getUsername() == other.getUsername() && this.getEmail() == other.getEmail();		
	}
	
}
