package com.asapp.backend.challenge.controller;

import com.asapp.backend.challenge.resources.HealthResource;
import com.asapp.backend.challenge.utils.JSONUtil;
import com.assap.backend.challenge.dao.UserDao;

import spark.Request;
import spark.Response;
import spark.Route;

public class HealthController {

	
	private static UserDao dao = UserDao.getInstance();
	
    public static Route check = (Request req, Response rep) -> {
    	try{
    		dao.countUsers();
    		HealthResource resource = new HealthResource("Ok");
    	    return JSONUtil.dataToJson(resource);
    	}catch(Exception e){
    		rep.status(500);
    		HealthResource resource = new HealthResource("Failed");
    		return JSONUtil.dataToJson(resource);
    	}
    };
}
