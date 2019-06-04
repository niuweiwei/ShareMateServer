package com.sharemate.server.service;

import com.sharemate.entity.User;

public interface UserService {
	
	/**
	 * 通过userId获取User对象
	 * */
	public User getUserByUserId(int userId);
}
