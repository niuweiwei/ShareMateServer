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
	
	/**
	 * 根据手机号判断用户是否存在
	 * @param userPhone
	 * @param resp
	 * @throws IOException 
	 */
	@RequestMapping("login")
	public void login(String userPhone,HttpServletResponse resp) throws IOException {
		boolean isExist = userService.isExistUser(userPhone);
		System.out.println("isExist----"+isExist);
		JSONObject object = new JSONObject();
		if(isExist == true) {
			//用户存在
			User user = userService.findUserByUserPhone(userPhone);
			object.put("msg", "用户存在");
			object.put("userId", user.getUserId());
			object.put("userPhone", user.getUserPhone());
			resp.getWriter().append(object.toString());
		}else {
			//用户不存在
			object.put("msg", "用户不存在");
			resp.getWriter().append(object.toString());
		}
	}
	/**
	 * 注册用户
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	public void register(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		InputStream is = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String json = br.readLine();
		System.out.println("register---"+json);
		JSONObject object = JSONObject.fromObject(json);
		String userName = object.getString("userName");
		String userPassword = object.getString("userPassword");
		String userPhone = object.getString("userPhone");
		String userPhoto = "images/userPhotos/0.png";
		String userIntro = "添加个人描述，可以让大家更好的认识你";
		String userAddress = "完善你的位置信息";
		System.out.println("头像：" + userPhoto + "; 用户名：" + userName + "; 密码：" + userPassword + "; 电话：" + userPhone);
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setUserPhone(userPhone);
		user.setUserPhoto(userPhoto);
		user.setUserAddress(userAddress);
		user.setUserIntro(userIntro);
		boolean isRegist = userService.isExistUser(userPhone);
		if(isRegist == true) {
			//该用户已经注册过
			resp.getWriter().append("该用户已经注册");
		}else {
			//该用户是新用户
			int count = userService.insertUser(user);
			System.out.println("插入了"+count+"行");
			if(count != 0) {
				resp.getWriter().append("注册成功");
			}else {
				resp.getWriter().append("注册失败");
			}
		}
	}
	/**
	 * 注册用户2  性别和生日
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping(value="register2",method=RequestMethod.POST)
	public void register2(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		InputStream is = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String json = br.readLine();
		System.out.println("register2---"+json);
		JSONObject object = JSONObject.fromObject(json);
		String userSex = object.getString("userSex");
		String userBirth = object.getString("userBirth");
		User user = new User();
		user.setUserSex(userSex);
		user.setUserBirth(userBirth);
		int maxId = userService.getMaxUserId();
		int count = userService.updateUser(user, maxId);
		System.out.println("更新了"+count+"行");
		if(count != 0) {
			JSONObject result = new JSONObject();
			result.put("msg", "更新成功");
			result.put("userId", maxId);
			resp.getWriter().append(result.toString());
		}else {
			resp.getWriter().append("更新失败");
		}
	}
	/**
	 * 根据userId查询user
	 * @param userId
	 * @param resp
	 * @throws IOException
	 */
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
