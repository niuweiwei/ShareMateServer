package com.sharemate.server.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	private static final RequestMethod[] post = null;
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
	/**
	 * 更新用户信息
	 * @param user
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping(value="updateUser",method=RequestMethod.POST)
	public void updateUser(HttpServletResponse resp,HttpServletRequest req) throws IOException {
		InputStream is = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String json = br.readLine();
		System.out.println("数据："+json);
		JSONObject object = JSONObject.fromObject(json);
		int userId = object.getInt("userId");
		String userName = object.getString("userName");
		String userAddress = object.getString("userAddress");
		String userSex = object.getString("userSex");
		String userBirth = object.getString("userBirth");
		String userIntro = object.getString("userIntro");
		
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserAddress(userAddress);
		user.setUserBirth(userBirth);
		user.setUserIntro(userIntro);
		user.setUserSex(userSex);
		int count = userService.updateUser(user);
		System.out.println("user---"+user);
		System.out.println("更新了"+count+"行");
		if(count != 0) {
			resp.getWriter().append("更新成功");
		}else {
			resp.getWriter().append("更新失败");
		}
	}
}
