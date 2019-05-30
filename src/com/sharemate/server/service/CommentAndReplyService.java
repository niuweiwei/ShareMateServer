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
	 * 根据用户的id查询出所有相关的评论及回复列表
	 * */
	public List<CommentAndReply> getAllCAndR(int userId); 

	/**
	 * 回复某条评论或回复
	 * @param userId 发布回复的用户id
	 * @param tag 用来判断是对评论的回复 还是对回复的回复
	 * @param id 要进行回复的评论id 或者是回复id
	 * @param replyDetail 回复的详情
	 * */
	public void replyCommentOrReply(int userId,int tag,int id,String replyDetail);
}
