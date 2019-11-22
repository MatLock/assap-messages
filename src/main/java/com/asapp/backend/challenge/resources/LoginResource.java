package com.asapp.backend.challenge.resources;

public class LoginResource {

  private String token;
  private Integer id;

  public LoginResource(Integer id,String token) {
	super();
	this.token = token;
	this.id = id;
  }
  
  public LoginResource(){}

  public String getToken() {
	return token;
  }

  public void setToken(String id) {
	this.token = id;
  }

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}
  
  
  
  
}
