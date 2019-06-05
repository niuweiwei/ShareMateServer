package com.sharemate.server.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.Title;
import com.sharemate.server.dao.TitleMapper;
import com.sharemate.server.service.TitleService;

/**

* @author fengjiaxing

* @version 2019年5月30日 上午10:00:03 

*/
@Service
public class TitleServiceImpl implements TitleService {

	@Autowired
	private TitleMapper titleMapper;
	
	@Override
	public int insertTitle(int userId, int typeId) {
		return titleMapper.insertTitle(userId, typeId);
	}

	@Override
	public int deleteTitle(int userId, int typeId) {
		return titleMapper.deleteTitle(userId, typeId);
	}

	@Override
	public List<Title> findType(int userId) {
		return titleMapper.findType(userId);
	}

}
