package com.assap.backend.challenge.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

@SuppressWarnings("rawtypes")
public class TokenDao extends Dao {

	private static TokenDao tokenDao;
	
	private TokenDao(){}
	
	public static TokenDao getInstance(){
	  if(tokenDao == null){
		  tokenDao = new TokenDao(); 
	  }
	  return tokenDao;
	}
	
	public boolean tokenExists(Integer userId, String tokenId){
	  Session session = factory.openSession();
	  try{
		  Query q = session.createQuery("FROM TOKEN WHERE USER_ID = :userId AND TOKEN_ID = :tokenId");
		  q.setParameter("userId", userId);
		  q.setParameter("tokenId",tokenId);
		  return q.uniqueResult() != null; 
	  }finally{
		  session.close();
	  }	
	}
}
