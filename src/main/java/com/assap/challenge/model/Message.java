package com.assap.challenge.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "MESSAGE")
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID",unique = true)	
	private Integer id;
	@Column(name = "SENDER_ID")	
	private Integer senderId;
	@Column(name = "RECIPENT_ID")	
	private Integer recipentId;
	@Column(name = "CREATION_DATE")	
	private Instant creationDate;
	@Column(name = "CONTENT_URL")	
	private String contentUrl;
	@Column(name = "MEDIA")
	private String media;
	
	public Message() {}
	public Message(Integer senderId, Integer recipentId, String contentUrl,String media) {
		super();
		this.senderId = senderId;
		this.recipentId = recipentId;
		this.creationDate = Instant.now();
		this.contentUrl = contentUrl;
		this.media = media;
	}
	
	
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public Integer getRecipentId() {
		return recipentId;
	}
	public void setRecipentId(Integer recipentId) {
		this.recipentId = recipentId;
	}
	public Instant getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	
	
	
	
}
