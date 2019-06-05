package com.sharemate.server.service;

import java.util.List;

import com.sharemate.entity.Title;

/**

* @author fengjiaxing

* @version 2019年5月30日 上午9:59:28 

*/
public interface TitleService {
	
	public int insertTitle(int userId,int typeId);
	
	public int deleteTitle(int userId,int typeId);
	
	public List<Title> findType(int userId);
}
