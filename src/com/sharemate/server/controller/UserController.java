package com.sharemate.server.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * user控制类
 * @author fengjiaxing
 * @version 2019年5月14日 上午11:11:57
 */

import com.sharemate.entity.User;
import com.sharemate.server.service.FollowService;
import com.sharemate.server.service.UserService;

import net.sf.json.JSONObject;
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findUserByUserId")
	public void findUserByUserId(int userId,HttpServletResponse resp) throws IOException {
		User user = userService.findUserByUserId(userId);
		System.out.println("user---"+user);
		JSONObject jsonUser = new JSONObject();
		jsonUser.put("userId", user.getUserId());
		jsonUser.put("userName", user.getUserName());
		jsonUser.put("userPassword", user.getUserPassword());
		jsonUser.put("userPhoto", user.getUserPhoto());
		jsonUser.put("userSex", user.getUserSex());
		jsonUser.put("userPhone", user.getUserPhone());
		jsonUser.put("userAddress", user.getUserAddress());
		jsonUser.put("userBirth", user.getUserBirth());
		jsonUser.put("userIntro", user.getUserIntro());
		System.out.println("jsonUser---"+jsonUser.toString());
		resp.getWriter().append(jsonUser.toString());
	}
}
