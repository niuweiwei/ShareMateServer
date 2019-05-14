package com.sharemate.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sharemate.entity.Like;

/**
 * @author niuweiwei 
 * */
@Service
public interface LikeService {

	/**
	 * 根据当前用户id 获取到该用户发布过的所有笔记得到的赞
	 * @param userId 当前用户的id
	 * @return 所有赞的信息
	 * */
	public List<Like> getLikeListByUserId(int userId);
}
