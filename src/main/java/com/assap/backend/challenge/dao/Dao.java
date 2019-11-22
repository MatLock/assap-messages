package com.assap.backend.challenge.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.asapp.backend.challenge.configuration.SessionFactoryBuilder;

public abstract class Dao {

	protected static SessionFactory factory = SessionFactoryBuilder.getSessionFractory();
	
	public <T> void save(T u){
	    Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
		    session.save(u);
		}finally{
		    transaction.commit();
			session.close();
	    }
 	}
}
