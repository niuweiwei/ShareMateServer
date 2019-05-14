package com.sharemate.server.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.User;
import com.sharemate.server.dao.UserMapper;
import com.sharemate.server.service.UserService;
/**
 * user服务实现类
 * @author fengjiaxing
 * @version 2019年5月14日 上午11:12:56
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserByUserId(int userId) {
		return userMapper.findUserByUserId(userId);
	}
	
	
}
