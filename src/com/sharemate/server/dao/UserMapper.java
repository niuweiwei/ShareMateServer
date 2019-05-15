package com.sharemate.server.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sharemate.entity.User;

/**
 *  创建映射器接口，在接口里定义抽象方法
 * @author fengjiaxing
 * @version 2019年5月14日 上午11:12:32
 */
public interface UserMapper {
	/**
	 * 根据userId查询用户
	 * @param userId
	 * @return
	 */
	public User findUserByUserId(int userId);
}
