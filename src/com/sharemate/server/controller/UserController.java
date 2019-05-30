package com.sharemate.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.server.service.UserService;
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	public  UserService userservice;
	@RequestMapping("text")
	public void text() {
		userservice.text();
		
	}
}
