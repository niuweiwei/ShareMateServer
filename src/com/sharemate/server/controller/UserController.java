package com.sharemate.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * user控制类
 * @author fengjiaxing
 * @version 2019年5月14日 上午11:11:57
 */

import com.sharemate.entity.User;
import com.sharemate.server.service.UserService;
@Controller
//@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("findUserByUserId")
	public void findUserByUserId() {
		int userId = 1;
		User user = userService.findUserByUserId(userId);
		System.out.println(user);
	}
}
