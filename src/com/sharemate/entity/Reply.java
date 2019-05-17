package com.sharemate.entity;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author niuweiwei
 * 回复类
 * */
@Repository
public class Reply {

	private int replyId;
	private Comment comment;
	private int reReplyId;//该回复 回复的 回复id
	private User user;
	private String replyDetail;
	private String replyDate;
	
	public Reply() {
		super();
	}
	public Reply(int replyId, Comment comment, int reReplyId, User user, String replyDetail, String replyDate) {
		super();
		this.replyId = replyId;
		this.comment = comment;
		this.reReplyId = reReplyId;
		this.user = user;
		this.replyDetail = replyDetail;
		this.replyDate = replyDate;
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public int getReReplyId() {
		return reReplyId;
	}
	public void setReReplyId(int reReplyId) {
		this.reReplyId = reReplyId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getReplyDetail() {
		return replyDetail;
	}
	public void setReplyDetail(String replyDetail) {
		this.replyDetail = replyDetail;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", comment=" + comment + ", reReplyId=" + reReplyId + ", user=" + user
				+ ", replyDetail=" + replyDetail + ", replyDate=" + replyDate + "]";
	}
	
	
}
