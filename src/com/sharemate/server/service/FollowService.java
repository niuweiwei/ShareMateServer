package com.sharemate.server.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.sharemate.entity.Follow;

@Service
public interface FollowService {
	
	/**
	 * 根据用户的id得到其所有的粉丝
	 * @param followedId 被关注的人的id
	 * @return 返回所有符合条件的关注记录
	 * */
	public List<Follow> getFollowList(int followedId);
	
	/**
	 * 当前用户关注指定用户
	 * @param followId 当前用户的id
	 * @param followedId 指定用户的id
	 * 	@param followDate 关注的日期
	 * */
	public void follow(int followId,int followedId,String followDate);
	
	/**
	 * 当前用户取消关注指定用户
	 * @param followId 当前用户的id
	 * @param followedId 指定用户的id
	 * */
	public void cancelFollow(int followId,int followedId);
	
}