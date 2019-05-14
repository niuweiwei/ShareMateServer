package com.sharemate.server.dao;

import org.springframework.stereotype.Repository;

import com.sharemate.entity.User;

@Repository
public interface UserMapper {
	
	/**
	 * @author niuweiwei
	 * 根据用户的id得到用户的具体信息
	 * @param id:要查询的用户的用户ID
	 * @return User 返回User对象 对象封装了用户的具体信息
	 * */
	public User getUserByUserId(int id);
}
