package pojo;

import org.springframework.stereotype.Component;

@Component("user")
public class User {
	private String user;
	private String password;
	private int id;

	public String getUser () {
		return user;
	}

	public void setUser (String user) {
		this.user = user;
	}

	public String getPassword () {
		return password;
	}

	public void setPassword (String password) {
		this.password = password;
	}

	public int getId () {
		return id;
	}

	public void setId (int id) {
		this.id = id;
	}
}
