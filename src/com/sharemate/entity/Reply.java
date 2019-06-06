package com.sharemate.entity;


public class Reply {
	
   private int replyId;
   private int commentId;
   private int userId;
   private String replyDetail;
   private String replyTime;
   private User user;
   private User replyedUser;
   private boolean isLike;
   /*薇薇*/
   private Comment comment;
   private int reReplyId;//该回复 回复的 回复id
   private String replyDate;
   
   public Reply() {
		super();
	   }

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getReReplyId() {
		return reReplyId;
	}

	public void setReReplyId(int reReplyId) {
		this.reReplyId = reReplyId;
	}

	public String getReplyDetail() {
		return replyDetail;
	}

	public void setReplyDetail(String replyDetail) {
		this.replyDetail = replyDetail;
	}

	public String getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getReplyedUser() {
		return replyedUser;
	}

	public void setReplyedUser(User replyedUser) {
		this.replyedUser = replyedUser;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isLike() {
	   return isLike;
	}

	public void setLike(boolean isLike) {
	   this.isLike = isLike;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

}
