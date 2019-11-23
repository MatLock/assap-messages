package com.asapp.backend.challenge.resources;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MessageResource {
   
	private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	private Instant timestamp;
		
	public MessageResource() {	}
	public MessageResource(Integer id, Instant timestamp) {
		super();
		this.id = id;
		this.timestamp = timestamp;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Instant getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
