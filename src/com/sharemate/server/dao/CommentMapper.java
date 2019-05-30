package com.sharemate.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sharemate.entity.Comment;

@Repository
public interface CommentMapper {
	
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
