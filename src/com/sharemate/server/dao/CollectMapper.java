package com.sharemate.server.dao;

import java.util.List;

/**

* @author fengjiaxing

* @version 2019年5月15日 上午11:46:03 

*/
public interface CollectMapper {
	/**
	 * 根据userId查询noteId
	 * @param userId
	 * @return
	 */
	public List<Integer> findNoteIdByUserId(int userId);
}
