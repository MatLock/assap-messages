package com.assap.backend.challenge.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.assap.challenge.model.Message;

@SuppressWarnings({"rawtypes","unchecked"})
public class MessageDao extends Dao {

	private static MessageDao messageDao;
	
	public static MessageDao getInstance(){
	  if(messageDao == null){
		  messageDao = new MessageDao(); 
	  }
	  return messageDao;
	}
	
	private MessageDao(){}
	
	public List<Message> getMessagesFor(Integer recipentId,Integer start,Integer maxResult){
	  Session session = factory.openSession();
	  try{
		Query query = session.createQuery("FROM MESSAGE WHERE RECIPENT_ID = :recipentId ORDER BY CREATION_DATE");
		  query.setFirstResult(start);
		  query.setMaxResults(maxResult);
		  query.setParameter("recipentId", recipentId);
		  return query.list();
	  }finally{
		  session.close();
	  }
	}
	
}
