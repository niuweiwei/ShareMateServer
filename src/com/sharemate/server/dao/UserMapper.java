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
	@Results(id="userMap",value= {
			@Result(column="user_id",property="userId",id=true),
			@Result(column="user_name",property="userName"),
			@Result(column="user_password",property="userPassword"),
			@Result(column="user_photo",property="userPhoto"),
			@Result(column="user_sex",property="userSex"),
			@Result(column="user_phone",property="userPhone"),
			@Result(column="user_address",property="userAddress"),
			@Result(column="user_birth",property="userBirth"),
			@Result(column="user_intro",property="userIntro")
	})
	@Select("select * from user where user_id = #{userId}")
	public User findUserByUserId(int userId);
}
