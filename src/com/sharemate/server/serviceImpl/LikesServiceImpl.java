package com.sharemate.server.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.server.dao.LikesMapper;
import com.sharemate.server.service.LikesService;

/**

* @author fengjiaxing

* @version 2019年5月15日 下午4:59:12 

*/
@Service
public class LikesServiceImpl implements LikesService {

	@Autowired
	private LikesMapper likesMapper;
	
	@Override
	public int getLikesCount(int noteId) {
		return likesMapper.getLikesCount(noteId);
	}

}
