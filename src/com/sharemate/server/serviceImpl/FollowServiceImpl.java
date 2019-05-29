package com.sharemate.server.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.Follow;
import com.sharemate.entity.User;
import com.sharemate.server.dao.FollowMapper;
import com.sharemate.server.dao.UserMapper;
import com.sharemate.server.service.FollowService;

/**

* @author fengjiaxing

* @version 2019年5月15日 下午3:56:02 

*/
@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	private FollowMapper followMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int getFollowCountByUserId(int userId) {
		return followMapper.getFollowCountByUserId(userId);
	}

	@Override
	public int getFanCountByUserId(int userId) {
		return followMapper.getFanCountByUserId(userId);
	}

	@Override
	public List<Follow> getFan(int userId) {
		List<Follow> followList = new ArrayList<>();
		List<Follow> follows = followMapper.getFan(userId);
		System.out.println("follows---"+follows);
		for(int i=0;i<follows.size();i++) {
			int followId = follows.get(i).getFollowUser().getUserId();
			int uId = follows.get(i).getFollowedUser().getUserId();
			boolean isStatus = this.eachFan(followId, uId);
			User followUser = userMapper.findUserByUserId(follows.get(i).getFollowUser().getUserId());
			User followedUser = userMapper.findUserByUserId(follows.get(i).getFollowedUser().getUserId());
			Follow f = new Follow();
			f.setFollowUser(followUser);
			f.setStatus(isStatus);
			f.setFollowedUser(followedUser);
			f.setFollowDate(follows.get(i).getFollowDate());
			followList.add(f);
		}
		return followList;
	}

	@Override
	public int insertFan(int followId, int userId) {
		return followMapper.insertFan(followId, userId);
	}

	@Override
	public int deleteFollow(int followId, int userId) {
		return followMapper.deleteFollow(followId, userId);
	}

	@Override
	public boolean eachFan(int followId, int userId) {
		Follow follow = followMapper.eachFan(followId, userId);
		System.out.println("follow---"+follow);
		if(follow != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Follow> getFollowed(int userId) {
		List<Follow> follows = followMapper.getFollowed(userId);
		List<Follow> followList = new ArrayList<>();
		for(int i=0;i<follows.size();i++) {
			int followId = follows.get(i).getFollowUser().getUserId();
			int uId = follows.get(i).getFollowedUser().getUserId();
			boolean isStatus = this.eachFan(followId, uId);
			User followUser = userMapper.findUserByUserId(follows.get(i).getFollowUser().getUserId());
			User followedUser = userMapper.findUserByUserId(follows.get(i).getFollowedUser().getUserId());
			Follow f = new Follow();
			f.setFollowUser(followUser);
			f.setStatus(isStatus);
			f.setFollowedUser(followedUser);
			f.setFollowDate(follows.get(i).getFollowDate());
			followList.add(f);
		}
		return followList;
	}

}
