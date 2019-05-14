package com.sharemate.entity;

import java.sql.Date;

import org.springframework.stereotype.Repository;

/**
 * @author niuweiwei
 * 赞类（包括对笔记的点赞 对评论的点赞 对回复的点赞）
 * */
@Repository
public class Like {
	
	private int likeId;
	private User user;
	private Note note;
	private Comment comment;
	private Reply reply;
	private Date likeDate;
	
	public Like() {
		super();
	}
	
	public Like(int likeId, User user, Note note, Comment comment, Reply reply, Date likeDate) {
		super();
		this.likeId = likeId;
		this.user = user;
		this.note = note;
		this.comment = comment;
		this.reply = reply;
		this.likeDate = likeDate;
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
		return "Like [likeId=" + likeId + ", user=" + user + ", note=" + note + ", comment=" + comment + ", reply="
				+ reply + ", likeDate=" + likeDate + "]";
	}
	
	
	
}
