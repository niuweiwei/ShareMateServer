package com.sharemate.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sharemate.entity.User;

/**
 * @author fengjiaxing
 * @version 2019年5月14日 上午11:12:32
 */
public interface UserMapper {
	/**
	 * 根据输入的手机号判断用户是否存在
	 * @param userPhone
	 * @return
	 */
	public User findUserByUserPhone(String userPhone);
	/**
	 * 根据userId查询用户
	 * @param userId
	 * @return
	 */
	public User findUserByUserId(int userId);

	/**
	 * 更新user信息
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	/**
	 * 插入用户
	 * @param user
	 * @return
	 */
	public int insertUser(User user);
	/**
	 * 获得新插入的用户id
	 * @return
	 */
	public int getMaxUserId();
	/**
	 * 补全性别和生日
	 * @param user
	 * @param userId
	 * @return
	 */
	public int updateUser2(@Param("userSex")String userSex,
			@Param("userBirth")String userBirth,@Param("userId")int userId);
	/**
	 * 根据手机号、密码判断用户是否存在
	 * @param userPhone
	 * @param userPassword
	 * @return
	 */
	public User findUserByPhoneAndPwsd(@Param("userPhone")String userPhone,
			@Param("userPassword")String userPassword);
	
	/**
	 * 春柳
	 */
	//得到所有用户列表
	public List<User> findAllUsers();

	//根据userId查询用户
	public User getUserByUserId(int userId);
}
