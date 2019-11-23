package com.asapp.backend.challenge.resources;

import java.time.Instant;

import com.assap.challenge.model.Message;
import com.fasterxml.jackson.annotation.JsonFormat;


public class MessageCreatedResource extends CreateMessageResource {
  
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant timeStamp;
    
	public MessageCreatedResource() {}

	public MessageCreatedResource(Message m, ContentResource resource) {
		super(m.getSenderId(),m.getRecipentId(),resource);
		this.id = m.getId();
		this.timeStamp = m.getCreationDate();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Instant getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}
    
}
