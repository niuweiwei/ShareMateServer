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

}
