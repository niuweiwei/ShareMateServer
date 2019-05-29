package com.sharemate.server.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharemate.entity.Comment;
import com.sharemate.entity.Reply;
import com.sharemate.entity.User;

public interface CommentService {

	//根据noteId查询评论列表
	public List<Comment> getCommentListByNoteId(int noteId);
	//根据评论id查询评论的回复列表 
	public List<Reply> getReplyListByCommentId(int commentId);
	//根据replyId查询回复的回复列表 
	public void getReReplyListByReplyId(Reply reply,List<Reply>reReplyList);
	//根据replyId查询回复的回复
	public List<Reply> getReReplyByReplyId(int replyId);
	//添加评论
	public int addComment(int userId,int noteId,
			String date,String comment);
	//添加回复
	public int addReply(int userId,int commentId,String date,String reply);
	
	//添加回复的回复
	public int addReReply(int userId,int reReplyId,String date,String reply);
}
