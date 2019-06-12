package com.sharemate.server.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemate.entity.Comment;
import com.sharemate.entity.Reply;
import com.sharemate.entity.User;
import com.sharemate.server.dao.CommentMapper;
import com.sharemate.server.dao.UserMapper;
import com.sharemate.server.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<Comment> getCommentListByNote(int noteId) {
		//根据noteId查询评论列表
		return commentMapper.getCommentListByNote(noteId);
		
	}

	@Override
	public List<Reply> getReplyListByCommentId(int commentId) {
		//根据评论id查询评论的回复列表 
		return commentMapper.getReplyListByCommentId(commentId);
	}

	@Override
	public void getReReplyListByReplyId(Reply reply, List<Reply> reReplyList) {
		//根据replyId查询回复的回复列表 
		List<Reply> rlist = commentMapper.getReReplyByReplyId(reply.getReplyId());
		if(rlist!=null) {
			for(Reply r:rlist) {
				User user = userMapper.getUserByUserId(r.getUserId());
				User u = reply.getUser();
				r.setUser(user);
				r.setReplyedUser(u);
				reReplyList.add(r);
				getReReplyListByReplyId(r,reReplyList);
			}
		}
	}

	@Override
	public List<Reply> getReReplyByReplyId(int replyId) {
		//根据replyId查询回复的回复列表
		return commentMapper.getReReplyByReplyId(replyId);
	}

	@Override
	public int addComment(int userId, int noteId, String date, String comment) {
		//添加评论
		return commentMapper.addComment(userId, noteId, date, comment);
	}

	@Override
	public int addReply(int userId, int commentId, String date, String reply) {
		// 添加回复
		return commentMapper.addReply(userId, commentId, date, reply);
	}

	@Override
	public int addReReply(int userId, int reReplyId, String date, String reply) {
		// 添加回复的回复
		return commentMapper.addReReply(userId, reReplyId, date, reply);
	}

	@Override
	public List<Integer> getLikeCommentByUserId(int userId) {
		////根据userId查询赞表中被该用户赞过的评论列表 
		return commentMapper.getLikeCommentByUserId(userId);
	}

	@Override
	public List<Integer> getLikeReplyByUserId(int userId) {
		//根据userId查询赞表中被该用户赞过的回复列表 
		return commentMapper.getLikeReplyByUserId(userId);
	}

	@Override
	public int insertPick(int userId, int commentId, String date) {
		//评论点赞
		return commentMapper.insertPick(userId, commentId, date);
		
	}

	@Override
	public int deletePick(int userId, int commentId) {
		//评论取消赞
		return commentMapper.deletePick(userId, commentId);
	}

	@Override
	public int insertReplyPick(int userId, int replyId, String date) {
		// 回复点赞
		return commentMapper.insertReplyPick(userId, replyId, date);
	}

	@Override
	public int deleteReplyPick(int userId, int replyId) {
		//回复取消赞
		return commentMapper.deleteReplyPick(userId, replyId);
	}
}
