package com.sharemate.server.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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

	/*
	 * 付娆
	 */
	@Override
	public List<Follow> findGuanzhuUser(int userid) {
		System.out.println("findguanzhuUserServiceimpl");
		List<Follow> followlist=new ArrayList<Follow>();
		Follow follow=new Follow();
		follow.setFolloweduserid(1);
		followlist.add(follow);
		return followlist;
	}
	
	/*
	 * 薇薇
	 */
	@Override
	public List<Follow> getFollowList(int followedId) {
		// TODO Auto-generated method stub
		List<Follow> follows = followMapper.getAllFollowsByFollowedId(followedId);
		for(Follow follow:follows) {
			Follow tmp = followMapper.isFollow(followedId, follow.getFollowUser().getUserId());
			if(tmp == null)
				follow.setFollow(false);
			else
				follow.setFollow(true);
		}
		follows.sort(new DateComparator());
		return follows;
	}
	
	@Override
	public List<User> getContactList(int followId) {
		// TODO Auto-generated method stub
		List<User> contactList = new ArrayList<>();
		List<Follow> follows = followMapper.getAllFollowsByFollowId(followId);
		for(Follow follow :follows) {
			User user = follow.getFollowedUser();
			contactList.add(user);
		}
		return contactList;
	}
	
	@Override
	public void follow(int followId, int followedId, String followDate) {
		// TODO Auto-generated method stub
		followMapper.follow(followId, followedId, followDate);
	}

	@Override
	public void cancelFollow(int followId, int followedId) {
		// TODO Auto-generated method stub
		followMapper.cancelFollow(followId, followedId);
	}
	
	private class DateComparator implements Comparator<Follow>{

		@Override
		public int compare(Follow o1, Follow o2) {
			// TODO Auto-generated method stub
			String date1 = o1.getFollowDate();
			String date2 = o2.getFollowDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date time1 = new Date();
			Date time2 = new Date();
			try {
				time1 = dateFormat.parse(date1);
				time2 = dateFormat.parse(date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(time1.after(time2)) 
				return -1;
			else if(time1.before(time2))
				return 1;
			else
				return 0;
		}
	}
}
