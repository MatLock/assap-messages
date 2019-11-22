package com.asapp.backend.challenge.resources;

public class UserResource {
   
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsernamer(String user) {
		this.username = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserResource(String user, String password) {
		super();
		this.username = user;
		this.password = password;
	}	
	
	public UserResource(){}
}
