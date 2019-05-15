package com.sharemate.entity;


import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 * @author niuweiwei
 * 评论类
 * */
@Repository
public class Comment {
	
	private int commentId;
	private String commentDetail;
	private String commentDate;
	private User user;
	private Note note;
	
	public Comment() {
		super();
	}
	public Comment(int commentId, String commentDetail, String commentDate, User user, Note note) {
		super();
		this.commentId = commentId;
		this.commentDetail = commentDetail;
		this.commentDate = commentDate;
		this.user = user;
		this.note = note;
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
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
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
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentDetail=" + commentDetail + ", commentDate=" + commentDate
				+ ", user=" + user + ", note=" + note + "]";
	}
	
	
	
}
