package com.asapp.backend.challenge.resources;

public class CreateMessageResource {

	
	private Integer sender;
	private Integer recipent;
	private ContentResource content;
	
	public CreateMessageResource(Integer sender, Integer recipent, ContentResource content) {
		super();
		this.sender = sender;
		this.recipent = recipent;
		this.content = content;
	}
	public CreateMessageResource() {}
	
	public Integer getSender() {
		return sender;
	}
	public void setSender(Integer sender) {
		this.sender = sender;
	}
	public Integer getRecipent() {
		return recipent;
	}
	public void setRecipent(Integer recipent) {
		this.recipent = recipent;
	}
	public ContentResource getContent() {
		return content;
	}
	public void setContent(ContentResource content) {
		this.content = content;
	}
	
	
	
	
}
