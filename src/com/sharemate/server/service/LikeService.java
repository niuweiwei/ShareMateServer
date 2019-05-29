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
	 * 根据当前用户id 获取到该用户发布过的所有笔记,评论,回复得到的赞
	 * @param userId 当前用户的id
	 * @return 所有赞的信息
	 * */
	public List<Like> getLikeListByUserId(int userId);
	
	/**
	 * 当前用户点赞评论或点赞回复
	 * @param tag 根据tag值判断是对评论点赞还是对回复点赞
	 * @param userId 当前用户的id
	 * @param id 点赞的评论id或是回复的id
	 * */
	public void likeCommentOrReply(int tag,int userId,int id);
	
	/**
	 * 取消当前用户对评论或回复的点赞
	 * @param tag 根据tag值判断是取消对评论点赞还是取消对回复点赞
	 * @param userId 当前用户的id
	 * @param id 点赞的评论id或是回复的id
	 * */
	public void cancelLikeCommentOrReply(int tag,int userId,int id);
}
