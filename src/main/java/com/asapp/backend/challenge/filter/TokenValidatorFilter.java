package com.asapp.backend.challenge.filter;

import java.util.Base64;

import com.asapp.backend.challenge.resources.LoginResource;
import com.assap.backend.challenge.dao.TokenDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.utils.StringUtils;

public class TokenValidatorFilter {

	private static TokenDao tokenDao = TokenDao.getInstance();
	private static ObjectMapper objectMapper = new ObjectMapper();
	
    public static Filter validateUser = (Request req, Response resp) -> {
     /*   String authorization = req.headers("Authorization");
        if(StringUtils.isEmpty(authorization)){
        	Spark.halt(400, "Auth Header required");
        }
        String auth = authorization.split(" ")[1];
        LoginResource resource = objectMapper.readValue(Base64.getDecoder().decode(auth),LoginResource.class);
        if(!tokenDao.tokenExists(resource.getId(), resource.getToken())){
            Spark.halt(401, "Invalid token");
        }*/
        
    };
}
