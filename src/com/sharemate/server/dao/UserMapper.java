package com.sharemate.server.dao;

import java.util.List;

import com.sharemate.entity.User;

public interface UserMapper {

	//得到所有用户列表
	public List<User> findAllUsers();

	//根据userId查询用户
	public User getUserByUserId(int userId);
}
