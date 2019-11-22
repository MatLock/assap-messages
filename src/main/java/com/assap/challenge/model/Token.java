package com.assap.challenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TOKEN")
public class Token {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID",unique = true)	
	private Integer id;
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "TOKEN_ID")
	private String tokenId;	
	
	public Token(Integer id, String tokenId) {
		super();
		this.userId = id;
		this.tokenId = tokenId;
	}
	
	public Token() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer tokenId) {
		this.id = tokenId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String token) {
		this.tokenId = token;
	}
	
	
	
	
}
