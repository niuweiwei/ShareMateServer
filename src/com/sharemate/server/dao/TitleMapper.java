package com.sharemate.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharemate.entity.Title;

/**

* @author fengjiaxing

* @version 2019年5月30日 上午9:33:27 

*/
public interface TitleMapper {
	/**
	 * 根据userId和typeId插入用户所选type
	 * @param userId
	 * @param typeId
	 * @return
	 */
	public int insertTitle(@Param("userId")int userId,
			@Param("typeId")int typeId);
	/**
	 * 删除用户选择后有不选的type
	 * @param userId
	 * @param typeId
	 * @return
	 */
	public int deleteTitle(@Param("userId")int userId,
			@Param("typeId")int typeId);
	/**
	 * 根据userId查询出type
	 * @param userId
	 * @return
	 */
	public List<Title> findType(int userId);
}
