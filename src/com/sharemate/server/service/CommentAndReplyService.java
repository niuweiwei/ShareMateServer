package com.sharemate.server.service;

import java.util.List;

import com.sharemate.entity.Comment;
import com.sharemate.entity.CommentAndReply;
import com.sharemate.entity.Reply;

public interface CommentAndReplyService {
	
	/**
	 * 将评论对象Comment封装为CommentAndReply对象
	 * @param userId 用于查询该条评论是否被当前用户赞过
	 * @param comment 评论对象
	 * @return 封装后的CommentAndReply对象
	 * */
	public CommentAndReply getCommentAndReplyByComment(int userId,Comment comment);
	
	/**
	 * 将回复对象Reply封装为CommentAndReply对象
	 * @param userId 用于查询该条回复是否被当前用户赞过
	 * @param reply 回复对象
	 * @return 封装后的CommentAndReply对象
	 * */
	public CommentAndReply getCommentAndReplyByReply(int userId,Reply reply);
	
	
	/**
	 * 将对某一条的所有回复 放入CommentAndReply的list中
	 * @param reply Reply对象
	 * @param list CommentAndReply的集合
	 * */
	public void putReRepliesIntoList(int userId,Reply reply,List<CommentAndReply> list);
	
	/**
	 * 根据用户的id
	 * */
	public List<CommentAndReply> getAllCAndR(int userId); 

}
