package com.sharemate.entity;

import java.util.Date;
import java.util.List;

/**

* @author fengjiaxing

* @version 2019年5月15日 上午8:51:09 

*/
public class Comment {
	private int commentId;
	private String commentDetail;
//	private Date commentDate;
	private String commentDate;
	private int commentLikeCount;
	private User user;
	private Note note;
	/*付娆*/
	private int userId;
	private int noteId;
	/*春柳*/
	private List<Reply> replyList;
	private boolean isLike;
	
	public Comment() {
		super();
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentDetail() {
		return commentDetail;
	}
	public void setCommentDetail(String commentDetail) {
		this.commentDetail = commentDetail;
	}
//	public Date getCommentDate() {
//		return commentDate;
//	}
//	public void setCommentDate(Date commentDate) {
//		this.commentDate = commentDate;
//	}
	public int getCommentLikeCount() {
		return commentLikeCount;
	}
	public void setCommentLikeCount(int commentLikeCount) {
		this.commentLikeCount = commentLikeCount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public List<Reply> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
	public boolean isLike() {
		return isLike;
	}
	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	
}
