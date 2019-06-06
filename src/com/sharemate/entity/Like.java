package com.sharemate.entity;

import java.util.Date;

public class Like {
	private int userid;
	private int noteid;
//	private Date likeDate;
	/*薇薇*/
	private int likeId;
	private User user;
	private Note note;//与该赞的记录相关的笔记
	private Comment comment;
	private Reply reply;
	private String likeDate;
	
//	public Date getLikeDate() {
//		return likeDate;
//	}
//	
//	public void setLikeDate(Date likeDate) {
//		this.likeDate = likeDate;
//	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getNoteid() {
		return noteid;
	}
	public void setNoteid(int noteid) {
		this.noteid = noteid;
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

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}
	public String getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(String likeDate) {
		this.likeDate = likeDate;
	}
}
