package com.sharemate.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharemate.server.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
}
