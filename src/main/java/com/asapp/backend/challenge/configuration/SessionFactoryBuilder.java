package com.asapp.backend.challenge.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.assap.challenge.model.Message;
import com.assap.challenge.model.Token;
import com.assap.challenge.model.User;

public class SessionFactoryBuilder {
	
  private static SessionFactory sessionFactory;	
  
  public static SessionFactory getSessionFractory(){
    if(sessionFactory == null){
    	// jdbc:mysql://localhost:3306/camp_site com.mysql.jdbc.Driver org.hibernate.dialect.MySQL5Dialect
    	//jdbc:sqlite:localhost:3306/assap org.sqlite.JDBC  org.hibernate.dialect.SQLiteDialect
      Properties settings = new Properties();	
      settings.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
      settings.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:assap");
      settings.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
      settings.setProperty("hibernate.show_sql", "true");
      settings.setProperty("hibernate.hbm2ddl.auto", "create");
      settings.setProperty("hibernate.connection.username", "root");
      Configuration configuration = new Configuration();
      configuration.setProperties(settings);	         
      configuration.addAnnotatedClass(User.class);
      configuration.addAnnotatedClass(Token.class);
      configuration.addAnnotatedClass(Message.class);
      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
    			  .applySettings(configuration.getProperties()).build();
      sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    return sessionFactory;
  }
	

}
