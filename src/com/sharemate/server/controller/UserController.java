package com.sharemate.server.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sharemate.entity.User;
import com.sharemate.server.service.UserService;
import com.sharemate.util.JsonTools;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	//收藏和取消收藏
	@RequestMapping("/getUser/{userId}")
	@ResponseBody
	public void collect(@PathVariable Integer userId,
		HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		User user = userService.getUserByUserId(userId);
		String jsonString="";
		jsonString = JsonTools.createJsonString("user",user);
		try {
			response.getWriter().append(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
