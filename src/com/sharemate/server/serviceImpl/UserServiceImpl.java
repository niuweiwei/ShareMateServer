package com.sharemate.server.serviceImpl;

import java.util.List;

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

	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public User findUserByUserPhone(String userPhone) {
		return userMapper.findUserByUserPhone(userPhone);
	}
	/**
	 * 根据手机号判断用户是否存在
	 */
	public boolean isExistUser(String userPhone) {
		User user = userMapper.findUserByUserPhone(userPhone);
//		int userId = user.getUserId();
		if(user != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int insertUser(User user) {
		return userMapper.insertUser(user);
	}

	@Override
	public int getMaxUserId() {
		return userMapper.getMaxUserId();
	}

	@Override
	public int updateUser2(String userSex,String userBirth,int userId) {
		return userMapper.updateUser2(userSex,userBirth, userId);
	}

	@Override
	public User findUserByPhoneAndPwsd(String userPhone, String userPassword) {
		return userMapper.findUserByPhoneAndPwsd(userPhone, userPassword);
	}
	/**
	 * 根据手机号和密码判断用户是否存在
	 * @param userPhone
	 * @return
	 */
	public boolean isExistUserByPhoneAndPwsd(String userPhone,String userPassword) {
		User user = userMapper.findUserByPhoneAndPwsd(userPhone, userPassword);
		if(user != null) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * 春柳
	 */
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
