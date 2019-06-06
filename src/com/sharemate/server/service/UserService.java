package com.sharemate.server.service;

import java.util.List;

import com.sharemate.entity.User;
/**
 * user服务类
 * @author fengjiaxing
 * @version 2019年5月14日 上午11:12:41
 */
public interface UserService {
	
	public User findUserByUserPhone(String userPhone);
	
	public boolean isExistUser(String userPhone);
	
	public User findUserByUserId(int userId);
	
	public int updateUser(User user);
	
	public int insertUser(User user);
	
	public int getMaxUserId();
	
	public int updateUser2(String userSex,String userBirth,int userId);
	
	public User findUserByPhoneAndPwsd(String userPhone,String userPassword);
	
	public boolean isExistUserByPhoneAndPwsd(String userPhone,String userPassword);

	/*
	 * 春柳
	 */
	//得到所有用户列表
	public List<User> findAllUsers();
	//根据userId查询用户
	public User getUserByUserId(int userId);
}
