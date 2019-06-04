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
import com.sharemate.server.service.FollowService;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	private FollowMapper followMapper;
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
