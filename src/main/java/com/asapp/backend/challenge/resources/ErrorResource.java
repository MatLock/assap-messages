package com.asapp.backend.challenge.resources;

public class ErrorResource {

  private Boolean error;
  private String message;
  
  
  public ErrorResource(String error){
    this.error = Boolean.TRUE;
    this.message = error;
  }
  
  public Boolean getError() {
	return error;
  }
  public void setError(Boolean error) {
	this.error = error;
  }
  public String getMessage() {
	return message;
  }
  public void setMessage(String message) {
	this.message = message;
  }
	
  
  
}
