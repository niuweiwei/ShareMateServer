package com.sharemate.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharemate.entity.Follow;

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
	/**
	 * 根据被关注的id查询粉丝
	 * @param userId
	 * @return
	 */
	public List<Follow> getFan(int userId);
	/**
	 * 插入粉丝
	 * @param followId   对应数据库的follow_user_id
	 * @param userId     对应数据库的followed_user_id
	 * @return
	 */
	public int insertFan(@Param("followId")int followId,
						@Param("userId")int userId);
	/**
	 * 删除取消关注的用户
	 * @param followId   对应数据库的follow_user_id
	 * @param userId     对应数据库的followed_user_id
	 * @return
	 */
	public int deleteFollow(@Param("followId")int followId,
							@Param("userId")int userId);
	/**
	 * 判断是否是粉丝
	 * @param follow
	 * @return
	 */
	public Follow eachFan(@Param("followId")int followId,
							@Param("userId")int userId);
	/**
	 * 根据follow_user_id查看关注的人
	 * @param userId
	 * @return
	 */
	public List<Follow> getFollowed(int userId);
}
