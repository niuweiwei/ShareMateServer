package com.sharemate.entity;

import java.sql.Date;

public class comment {
	private String commentDetail;
	private Date commentDate;
	private int commentLikeCount;
	private int userId;
	private int noteId;
	public String getCommentDetail() {
		return commentDetail;
	}
	public void setCommentDetail(String commentDetail) {
		this.commentDetail = commentDetail;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public int getCommentLikeCount() {
		return commentLikeCount;
	}
	public void setCommentLikeCount(int commentLikeCount) {
		this.commentLikeCount = commentLikeCount;
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
	
}
