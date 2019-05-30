package com.sharemate.server.serviceImpl;

import org.springframework.stereotype.Service;

import com.sharemate.server.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public void text() {
		System.out.println("usertest");
		
	}

}
