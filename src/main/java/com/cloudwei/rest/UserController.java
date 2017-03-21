package com.cloudwei.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudwei.entity.User;
import com.cloudwei.repository.UserRepository;
import com.cloudwei.service.TokenHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";
    
    @Autowired
    private UserRepository userRepository;
    
    private final TokenHandler tokenHandler = new TokenHandler();

    @RequestMapping(value= "/login" , method= RequestMethod.POST, params="appid=H5DB0C2A2")  
    public String login(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("cid") String cid) { 
	    Gson gson=new Gson();
		JsonObject obj=new JsonObject();
		obj.addProperty("isTrue", false);
		List<User> uLists=userRepository.findAll();
		for(User user: uLists){
    		if(user.getUserName().equals(name)&&user.getPassword().equals(password)){
    		    String token = tokenHandler.createTokenForUser(user);
    			obj.addProperty("isTrue", true);
    			obj.addProperty("email", user.getEmail());
    			obj.addProperty("authToken", token);
    			user.setCid(cid.replace("\"", ""));
    			user.setToken(token);
    			userRepository.save(user);
    			break;
    		}
    	}
		obj.addProperty("name", name);
		return gson.toJson(obj);
    }
    
    @RequestMapping(value= "/logout", method= RequestMethod.POST)
    public void logout(HttpServletRequest request) {
        String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null) {
            User user = tokenHandler.parseUserFromToken(token);
            user.setToken(null);
            userRepository.save(user);
        }
        SecurityContextHolder.clearContext();
    }
}
