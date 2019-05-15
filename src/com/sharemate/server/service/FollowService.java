package com.sharemate.server.service;
/**

* @author fengjiaxing

* @version 2019年5月15日 下午3:55:36 

*/
public interface FollowService {

	public int getFollowCountByUserId(int userId);
	
	public int getFanCountByUserId(int userId);
}
