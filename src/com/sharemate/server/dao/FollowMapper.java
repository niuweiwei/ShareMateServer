package com.sharemate.server.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sharemate.entity.Follow;

@Repository
public interface FollowMapper {
	
	/**
	 * 根据用户的id查询其全部的粉丝
	 * @param followedId 
	 * @return 查询出全部的关注信息
	 * */
	public List<Follow> getAllFollowsByFollowedId(int followedId);
	
	/**
	 * 查询当前用户关注的所有用户
	 * @param followId 即为当前用户的id
	 * @return 返回当前用户关注的所有用户
	 * */
	public List<Follow> getAllFollowsByFollowId(int followId);
	
	/**
	 * 查询被关注的人是否关注了 关注的人 即判断两人是否互关
	 * @param followedId:被关注的用户的id
	 * 				  followId:关注 的用户的id
	 * @return follow对象 
	 * */
	public Follow isFollow(@Param("followedId")int followedId,
			@Param("followId")int followId);
	
	
	/**
	 * 当前用户关注指定用户
	 * @param followId:当前用户的id
	 * 				  followedId:指定用户的id
	 * 				  followDate:关注的日期
	 * */
	public void follow(@Param("followId")int followId,
			@Param("followedId")int followedId,
			@Param("followDate")String followDate);
	
	/**
	 * 当前用户取消关注指定用户
	 * */
	public void cancelFollow(@Param("followId")int followId,
			@Param("followedId")int followedId);
}
