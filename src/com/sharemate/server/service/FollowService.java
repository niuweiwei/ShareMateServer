package com.sharemate.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sharemate.entity.Follow;
@Service
public interface FollowService {
	public List<Follow> findGuanzhuUser(int userid); 
}
