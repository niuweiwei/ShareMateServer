package com.sharemate.server.dao;

import java.util.List;

import com.sharemate.entity.Comment;
import com.sharemate.entity.Reply;
import com.sharemate.entity.User;

public interface CommentMapper {

	//根据noteId查询评论列表
	public List<Comment> getCommentListByNoteId(int noteId);
	//根据评论id查询评论的回复列表 
	public List<Reply> getReplyListByCommentId(int commentId);
	//根据replyId查询回复的回复列表 
	public void getReReplyListByReplyId(Reply reply,List<Reply>reReplyList);
	//根据replyId查询回复的回复
	public List<Reply> getReReplyByReplyId(int replyId);
}
