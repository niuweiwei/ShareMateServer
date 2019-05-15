package com.sharemate.server.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.server.dao.FollowMapper;
import com.sharemate.server.service.FollowService;

/**

* @author fengjiaxing

* @version 2019年5月15日 下午3:56:02 

*/
@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	private FollowMapper followMapper;
	
	@Override
	public int getFollowCountByUserId(int userId) {
		return followMapper.getFollowCountByUserId(userId);
	}

	@Override
	public int getFanCountByUserId(int userId) {
		return followMapper.getFanCountByUserId(userId);
	}

}
