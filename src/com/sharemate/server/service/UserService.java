package com.sharemate.server.service;

import com.sharemate.entity.User;
/**
 * user服务类
 * @author fengjiaxing
 * @version 2019年5月14日 上午11:12:41
 */
public interface UserService {
	
	public User findUserByUserId(int userId);
	
	public int updateUser(User user);
}
