package com.asapp.backend.challenge.controller;

import com.asapp.backend.challenge.resources.ContentResource;
import com.asapp.backend.challenge.resources.CreateMessageResource;
import com.asapp.backend.challenge.resources.ErrorResource;
import com.asapp.backend.challenge.resources.MessageCreatedResource;
import com.asapp.backend.challenge.resources.MessageResource;
import com.asapp.backend.challenge.utils.JSONUtil;
import com.assap.backend.challenge.dao.MessageDao;
import com.assap.backend.challenge.dao.UserDao;
import com.assap.challenge.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import spark.Request;
import spark.Response;
import spark.Route;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
public class MessagesController {
	
	private static UserDao userDao = UserDao.getInstance();
	private static MessageDao messageDao = MessageDao.getInstance();
	private static ObjectMapper objectMapper = new ObjectMapper();
	private static final String RESOURCES = "src/main/resources/%s.txt";

    public static Route sendMessage = (Request req, Response rep) -> {
    	try{
    		CreateMessageResource body = objectMapper.readValue(req.body(),CreateMessageResource.class);
    		validateBody(body);
    		String url = saveContent(body.getContent().getText());
    		Message m = new Message(body.getSender(),body.getRecipent(),url,body.getContent().getType());
    		messageDao.save(m);
    		return JSONUtil.dataToJson(new MessageResource(m.getId(),m.getCreationDate()));    		
    	}catch(Exception e){
    		rep.status(400);
    		return JSONUtil.dataToJson(new ErrorResource(e.getMessage()));
    	}
    };

    public static Route getMessages = (Request req, Response rep) -> { 	
    	try{
    		Integer recipentId = Integer.valueOf(req.queryParams("recipent"));
        	Integer start = Integer.valueOf(req.queryParams("start"));
        	String limit = req.queryParams("limit");
    		validateParams(recipentId,start);
        	Integer maxResult = limit == null ? 100 : Integer.valueOf(limit);
        	List<Message> messages = messageDao.getMessagesFor(recipentId, start, maxResult);
            return JSONUtil.dataToJson(messages.stream()
            								   .map(MessagesController::toMessageCreatedResource)
            								   .collect(Collectors.toList()));	
    	}catch(Exception e){
    		rep.status(400);
    		return JSONUtil.dataToJson(new ErrorResource(e.getMessage()));
    	}
    	
    };
    
    private static void validateBody(CreateMessageResource body){
      if(body == null){
    	  throw new RuntimeException("body cannot be null");
      }
      if(body.getSender() == null || body.getRecipent() == null || body.getContent() == null){
    	  throw new RuntimeException("all fields are mandatory");
      }
      if(!userDao.userExists(body.getSender()) || !userDao.userExists(body.getRecipent())){
    	  throw new RuntimeException("sender or recipent not found");
      }
    }
    
    private static void validateParams(Integer recipent, Integer start){
    	if(recipent == null && start == null){
    		throw new RuntimeException("params 'start' and 'recipent' are mandatory");
    	}
    	if(!userDao.userExists(recipent)){
    		throw new RuntimeException("recipent does not exists");
    	}
    }
    
    private static MessageCreatedResource toMessageCreatedResource(Message m){
    	ContentResource resource = createResource(m.getContentUrl(),m.getMedia());
    	return new MessageCreatedResource(m,resource);
    }
    
    private static ContentResource createResource(String url, String media){
    	try{
    		File f = new File(url);
    		String content = new String(Files.readAllBytes(f.toPath()));
    		return new ContentResource(media,content); 		
    	}catch(Exception e){
    		throw new RuntimeException(e);
    	} 
    }
    
    private static String saveContent(String content){
    	String fileName =UUID.randomUUID().toString(); 
    	String url = String.format(RESOURCES,fileName);
    	try{
    		PrintWriter writer = new PrintWriter(new File(url));
    		writer.write(content);
    		writer.flush();
    		writer.close();
    	}catch(Exception e){
    		throw new RuntimeException(e);
    	}
 		return url;
    }

}
