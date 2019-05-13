package com.sharemate.server.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.User;
import com.sharemate.server.dao.UserMapper;
import com.sharemate.server.service.UserService;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAllUsers() {
		//得到所有用户列表
		return userMapper.findAllUsers();
	}

	@Override
	public User getUserByUserId(int userId) {
		//根据userId查询用户
		return userMapper.getUserByUserId(userId);
	}
}
