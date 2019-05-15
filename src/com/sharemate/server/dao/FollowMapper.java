package com.sharemate.server.dao;
/**

* @author fengjiaxing

* @version 2019年5月15日 下午3:38:17 

*/
public interface FollowMapper {
	/**
	 * 查询关注数量
	 * @param userId
	 * @return
	 */
	public int getFollowCountByUserId(int userId);
	/**
	 * 根据userId查询粉丝数量
	 * @param userId
	 * @return
	 */
	public int getFanCountByUserId(int userId);
}
