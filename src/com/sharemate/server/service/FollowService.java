package com.sharemate.server.service;

import java.util.List;

import com.sharemate.entity.Follow;
import com.sharemate.entity.User;

/**

* @author fengjiaxing

* @version 2019年5月15日 下午3:55:36 

*/
public interface FollowService {

	public int getFollowCountByUserId(int userId);
	
	public int getFanCountByUserId(int userId);
	
	public List<Follow> getFan(int userId);
	
	public int insertFan(int followId,int userId);
	
	public int deleteFollow(int followId,int userId);
	
	public boolean eachFan(int followId,int userId);
	
	public List<Follow> getFollowed(int userId);
	/*付娆*/
	public List<Follow> findGuanzhuUser(int userid);

//	List<Follow> getFollowList(int followedId);

//	List<User> getContactList(int followId);
	/*
	 * 薇薇
	 */
	/**
	 * 根据用户的id得到其所有的粉丝
	 * @param followedId 被关注的人的id
	 * @return 返回所有符合条件的关注记录
	 * */
	public List<Follow> getFollowList(int followedId);
	
	/**
	 * 根据用户的id得到其关注的所有用户 即为其联系人的列表
	 * @param followId 关注的人的id （当前用户id）
	 * @return 返回联系人列表
	 * */
	public List<User> getContactList(int followId);
	
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
