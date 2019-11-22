package com.asapp.backend.challenge.controller;

import com.asapp.backend.challenge.resources.ErrorResource;
import com.asapp.backend.challenge.resources.UserCreatedResource;
import com.asapp.backend.challenge.resources.UserResource;
import com.asapp.backend.challenge.utils.JSONUtil;
import com.assap.backend.challenge.dao.UserDao;
import com.assap.challenge.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.utils.StringUtils;

public class UsersController {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	private static UserDao dao = UserDao.getInstance();

    public static Route createUser = (Request req, Response resp) -> {
    	UserResource resource = objectMapper.readValue(req.body(), UserResource.class);
    	try{
    		validateRequest(resource);
    		checkUserExists(resource);
            User u = new User(resource.getUsername(),resource.getPassword());
            dao.save(u);
            return JSONUtil.dataToJson(new UserCreatedResource(u.getId()));
    	}catch(Exception e){
    		resp.status(400);
    		return JSONUtil.dataToJson(new ErrorResource(e.getMessage()));
    	}
    };
    
    
    private static void validateRequest(UserResource req){
      if(StringUtils.isEmpty(req.getUsername()) || StringUtils.isEmpty(req.getPassword())){
    	 throw new RuntimeException("All Fields Are Mandatory");  
      }
    }
    
    private static void checkUserExists(UserResource u){
      if(dao.userExists(u.getUsername())){
    	 throw new RuntimeException("User already exists"); 
      }
    }
}
