package com.sharemate.entity;

import java.sql.Date;

//对应数据库中likes表 点赞笔记的记录
public class Like {
	
	private int likeId;
	private User user;
	private Note note;
	private Date likeDate;
	
	public Like() {
		super();
	}
	public Like(int likeId, User user, Note note, Date likeDate) {
		super();
		this.likeId = likeId;
		this.user = user;
		this.note = note;
		this.likeDate = likeDate;
	}
	public int getLikeId() {
		return likeId;
	}
	public void setLikeId(int likeId) {
		this.likeId = likeId;
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
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", user=" + user + ", note=" + note + ", likeDate=" + likeDate + "]";
	}
	
	
}
