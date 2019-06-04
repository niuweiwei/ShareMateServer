package com.sharemate.server.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.entity.User;
import com.sharemate.server.service.UserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping("getUser/{userId}")
	public void getUser(@PathVariable("userId")int userId,HttpServletResponse response) throws IOException {
		User user = userService.getUserByUserId(userId);
		JSONObject jsonUser = new JSONObject();
		jsonUser.put("userId", user.getUserId());
		jsonUser.put("userName", user.getUserName());
		jsonUser.put("userPhoto", user.getUserPhoto());
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonUser.toString());
	}

}
