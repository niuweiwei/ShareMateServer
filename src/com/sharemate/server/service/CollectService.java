package com.sharemate.server.service;

import java.util.List;

/**

* @author fengjiaxing

* @version 2019年5月15日 上午11:50:47 

*/
public interface CollectService {
	
	public List<Integer> findNoteIdByUserId(int userId);
}
