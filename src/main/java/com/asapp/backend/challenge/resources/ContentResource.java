package com.asapp.backend.challenge.resources;

public class ContentResource {

	private String type;
	private String text;
	
	public ContentResource() {}
	public ContentResource(String type, String text) {
		super();
		this.type = type;
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
