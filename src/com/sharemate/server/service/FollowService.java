package com.sharemate.server.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharemate.entity.Follow;

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
	
}
