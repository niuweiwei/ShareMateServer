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
	
	/**
	 * 付娆
	 */
	public List<Follow> findGuanzhuUser(int followuserid);
	
	/*
	 * 薇薇
	 */
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
