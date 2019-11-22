package com.asapp.backend.challenge.controller;

import java.util.UUID;

import com.asapp.backend.challenge.resources.ErrorResource;
import com.asapp.backend.challenge.resources.LoginResource;
import com.asapp.backend.challenge.resources.UserResource;
import com.asapp.backend.challenge.utils.JSONUtil;
import com.assap.backend.challenge.dao.TokenDao;
import com.assap.backend.challenge.dao.UserDao;
import com.assap.challenge.model.Token;
import com.assap.challenge.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import spark.*;
import spark.utils.StringUtils;

public class AuthController {
	
	private static UserDao userDao = UserDao.getInstance();
	private static TokenDao tokenDao = TokenDao.getInstance();
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	
    public static Route login = (Request req, Response resp) -> {
    	UserResource resource = objectMapper.readValue(req.body(), UserResource.class);
    	try{
    		validateRequest(resource);
    		User u = checkUserExists(resource);
    		Token token = new Token(u.getId(),UUID.randomUUID().toString());
    		tokenDao.save(token);
            return JSONUtil.dataToJson(new LoginResource(token.getUserId(),token.getTokenId()));
    	}catch(Exception e){
    		resp.status(404);
    		return JSONUtil.dataToJson(new ErrorResource(e.getMessage()));
    	}
    };
    
    private static void validateRequest(UserResource req){
        if(StringUtils.isEmpty(req.getUsername()) || StringUtils.isEmpty(req.getPassword())){
      	 throw new RuntimeException("All Fields Are Mandatory");  
        }
   }
    
    private static User checkUserExists(UserResource u){
    	User user = userDao.getUser(u.getUsername(), u.getPassword());
        if(user == null){
      	 throw new RuntimeException("User not found"); 
        }
      return user;  
   }

}
