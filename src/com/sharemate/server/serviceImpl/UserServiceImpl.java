package com.sharemate.server.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.User;
import com.sharemate.server.dao.UserMapper;
import com.sharemate.server.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserMapper userMapper;
	
	@Override
	public User getUserByUserId(int userId) {
		// TODO Auto-generated method stub
		User user = userMapper.getUserByUserId(userId);
		return user;
	}

}
