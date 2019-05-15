package com.sharemate.server.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.server.dao.CollectMapper;
import com.sharemate.server.service.CollectService;

/**

* @author fengjiaxing

* @version 2019年5月15日 上午11:51:33 

*/
@Service
public class CollectServiceImpl implements CollectService {

	@Autowired
	private CollectMapper collectMapper;
	
	@Override
	public List<Integer> findNoteIdByUserId(int userId) {
		return collectMapper.findNoteIdByUserId(userId);
	}

}
