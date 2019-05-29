package com.sharemate.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sharemate.entity.Reply;

@Repository
public interface ReplyMapper {
	
	/**
	 * 根据指定的用户id获取该用户发布过的所有回复
	 * @param userId 指定用户id
	 * @return 返回回复列表
	 * */
	public List<Reply> getReplyListByUserId(int userId);
	
	/**
	 * 根据回复的id查询回复的详情
	 * @param replyId 指定回复id
	 * @return 返回回复对象
	 * */
	public Reply getReplyByReplyId(int replyId);
	
	/**
	 * 查询回复了指定回复的回复列表
	 * @param reReplyId 指定的回复
	 * */
	public List<Reply> getReplyListByReReplyId(int reReplyId);

	/**
	 * 根据指定的评论id获取对该评论的所有回复
	 * */
	public List<Reply> getReplyListByCommentId(int commentId);
}
