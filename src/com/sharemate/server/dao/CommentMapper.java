package com.sharemate.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharemate.entity.Comment;
import com.sharemate.entity.Reply;

public interface CommentMapper {

	/*春柳*/
	//根据noteId查询评论列表
	public List<Comment> getCommentListByNote(int noteId);
	//根据评论id查询评论的回复列表 
	public List<Reply> getReplyListByCommentId(int commentId);
	//根据replyId查询回复的回复列表 
	public void getReReplyListByReplyId(Reply reply,List<Reply>reReplyList);
	//根据replyId查询回复的回复
	public List<Reply> getReReplyByReplyId(int replyId);
	//添加评论
	public int addComment(@Param("userId")int userId,@Param("noteId")int noteId,
			@Param("date")String date,@Param("comment")String comment);
	//添加回复
	public int addReply(@Param("userId")int userId,@Param("commentId")int commentId,
			@Param("date")String date,@Param("reply")String reply);
	//添加回复的回复
	public int addReReply(@Param("userId")int userId,@Param("reReplyId")int reReplyId,
			@Param("date")String date,@Param("reply")String reply);
	
	//根据userId查询赞表中被该用户赞过的评论列表 
	public List<Integer> getLikeCommentByUserId(int userId);
	
	//根据userId查询赞表中被该用户赞过的回复列表 
	public List<Integer> getLikeReplyByUserId(int userId);
	
	//评论点赞
	public int insertPick(@Param("userId")int userId, @Param("commentId")int commentId,
			@Param("date")String date);
	//评论取消赞
	public int deletePick(@Param("userId")int userId, @Param("commentId")int commentId);
	
	//回复点赞
	public int insertReplyPick(@Param("userId")int userId, @Param("replyId")int commentId,
			@Param("date")String date);
	//回复取消赞
	public int deleteReplyPick(@Param("userId")int userId, @Param("replyId")int commentId);

	/*薇薇*/
	/**
	 * 根据用户的id查询其发过的所有评论
	 * @param userId 传入指定的userId
	 * @return 返回评论列表
	 * */
	public List<Comment> getCommentListByUserId(int userId);
	
	/**
	 * 根据评论的id查询评论
	 * @param commentId 评论的id
	 * @return 返回Comment对象 其中封装了Comment相关内容
	 * */
	public Comment getCommentByCommentId(int commentId);
	
	/**
	 * 根据笔记的id查询该笔记的所有评论
	 * */
	public List<Comment> getCommentListByNoteId(int noteId);
	
	/**
	 * 从评论表中删除评论
	 * */
	public int deleteComment(int commentId);
}
