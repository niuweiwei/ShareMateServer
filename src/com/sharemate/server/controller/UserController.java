package com.sharemate.server.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.entity.Follow;
import com.sharemate.entity.User;
import com.sharemate.server.service.FollowService;
import com.sharemate.server.service.LikeService;
import com.sharemate.server.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	public UserService userService;
	@Autowired
	public FollowService followService;
	
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

	//得到与当前用户相关的所有用户 即其关注的所有用户、其所有粉丝 包括自己
	@RequestMapping("getUserList/{userId}")
	public void getUserList(@PathVariable("userId")int userId,HttpServletResponse response) throws IOException {
		List<User> userList = new ArrayList<>();
		//得到userId关注的用户
		List<User> contactList = followService.getContactList(userId);
		userList.addAll(contactList);
		//得到userId的所有粉丝
		List<Follow> followList = followService.getFollowList(userId);
		for(Follow follow : followList) {
			User user = follow.getFollowUser();
			userList.add(user);
		}
		//将当前用户
		User user = userService.getUserByUserId(userId);
		userList.add(user);
		
		JSONArray jsonUserList = new JSONArray();
		for(User item : userList) {
			JSONObject jsonUser = new JSONObject();
			jsonUser.put("userId", item.getUserId());
			jsonUser.put("userName", item.getUserName());
			jsonUser.put("userPhoto", item.getUserPhoto());
			jsonUserList.add(jsonUser);
		}
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonUserList.toString());
		
	}
}
