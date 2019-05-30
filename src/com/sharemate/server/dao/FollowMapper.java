package com.sharemate.server.dao;

import java.util.List;

import com.sharemate.entity.Follow;

public interface FollowMapper {
	public List<Follow> findGuanzhuUser(int followuserid);
}
