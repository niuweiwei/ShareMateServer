package com.sharemate.server.service;

import java.util.List;


import com.sharemate.entity.Comment;
import com.sharemate.entity.Follow;
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
		
		//根据userId查询赞表中被该用户赞过的评论列表 
		public List<Integer> getLikeCommentByUserId(int userId);
			
		//根据userId查询赞表中被该用户赞过的回复列表 
		public List<Integer> getLikeReplyByUserId(int userId);
		
		//评论点赞
		public int insertPick(int userId, int commentId,String date);
		
		//评论取消赞
		public int deletePick(int userId,int commentId);
		
		//回复点赞
		public int insertReplyPick(int userId, int replyId,String date);
			
		//回复取消赞
		public int deleteReplyPick(int userId,int replyId);	
}
