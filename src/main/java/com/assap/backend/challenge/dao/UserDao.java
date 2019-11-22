package com.assap.backend.challenge.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.assap.challenge.model.User;

@SuppressWarnings(value = { "unchecked","rawtypes" })
public class UserDao extends Dao{
	
	private static UserDao userDao;


	public static UserDao getInstance(){
	  if(userDao == null){
		 userDao = new UserDao(); 
	  }
	  return userDao;
	}
	
	private UserDao(){}
	
	public Integer countUsers(){
	  Session session = factory.openSession();	
	  try{
		  List<User> users = session.createQuery("FROM USER").list();
		  return users.size();
	  }finally{
		  session.close();
	  }	 
	}
	
	public boolean userExists(String username){
	  Session session = factory.openSession();
	  try{
		  Query q = session.createQuery("FROM USER WHERE USERNAME = :username");
		  q.setParameter("username", username);
		  return q.uniqueResult() != null; 
	  }finally{
		  session.close();
	  }	 
	}
	
	public User getUser(String username,String password){
		Session session = factory.openSession();
		try{
			Query q = session.createQuery("FROM USER WHERE USERNAME = :username AND password = :password");
			q.setParameter("username", username);
			q.setParameter("password", password);
			return (User) q.uniqueResult(); 
	    }finally{
		    session.close();
	    }	 
	}
}
