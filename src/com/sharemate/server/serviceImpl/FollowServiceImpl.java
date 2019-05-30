package com.sharemate.server.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.Follow;
import com.sharemate.server.dao.FollowMapper;
import com.sharemate.server.service.FollowService;
@Service
public class FollowServiceImpl implements FollowService{
	@Autowired
	private FollowMapper followMapper;
	@Override
	public List<Follow> findGuanzhuUser(int userid) {
		System.out.println("findguanzhuUserServiceimpl");
		List<Follow> followlist=new ArrayList<Follow>();
		Follow follow=new Follow();
		follow.setFolloweduserid(1);
		followlist.add(follow);
		return followlist;
	}

}
