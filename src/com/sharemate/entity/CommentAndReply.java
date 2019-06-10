package com.sharemate.entity;

public class CommentAndReply {
	
	 public static final int COMMENT_TYPE = 0;//代表是对笔记的评论
	 public static final int REPLY_TYPE = 1;//代表是对评论的回复
	 public static final int RE_REPLY_TYPE = 2;//代表是对回复的回复

	 private int tag;//用以判断是对笔记的评论 评论的回复还是回复的回复
	 private User user;//发布评论或回复的人
	 private String commentContent;//评论或回复的内容

	 private User arguedUser;//被评论的用户的用户名
     private String commentedContent;//被评论的内容
	 private String commentDate;//评论或者回复的日期
	 private Note note;//该评论或回复涉及到的笔记
	 private int arguedId;//被回复的评论id或被回复的回复id
	 private boolean isLike;//当前用户是否对该评论进行点赞
	 private int id;//当前的评论id或回复id
	    
		public CommentAndReply() {
			super();
		}

		public CommentAndReply(int tag, User user, String commentContent, User arguedUser, String commentedContent,
				String commentDate, Note note, int arguedId, boolean isLike) {
			super();
			this.tag = tag;
			this.user = user;
			this.commentContent = commentContent;
			this.arguedUser = arguedUser;
			this.commentedContent = commentedContent;
			this.commentDate = commentDate;
			this.note = note;
			this.arguedId = arguedId;
			this.isLike = isLike;
		}

		public int getTag() {
			return tag;
		}

		public void setTag(int tag) {
			this.tag = tag;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getCommentContent() {
			return commentContent;
		}

		public void setCommentContent(String commentContent) {
			this.commentContent = commentContent;
		}

		public User getArguedUser() {
			return arguedUser;
		}

		public void setArguedUser(User arguedUser) {
			this.arguedUser = arguedUser;
		}

		public String getCommentedContent() {
			return commentedContent;
		}

		public void setCommentedContent(String commentedContent) {
			this.commentedContent = commentedContent;
		}

		public String getCommentDate() {
			return commentDate;
		}

		public void setCommentDate(String commentDate) {
			this.commentDate = commentDate;
		}

		public Note getNote() {
			return note;
		}

		public void setNote(Note note) {
			this.note = note;
		}

		public int getArguedId() {
			return arguedId;
		}

		public void setArguedId(int arguedId) {
			this.arguedId = arguedId;
		}

		public boolean isLike() {
			return isLike;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setLike(boolean isLike) {
			this.isLike = isLike;
		}

		public static int getCommentType() {
			return COMMENT_TYPE;
		}

		public static int getReplyType() {
			return REPLY_TYPE;
		}

		public static int getReReplyType() {
			return RE_REPLY_TYPE;
		}
		
		@Override
		public String toString() {
			return "CommentAndReply [tag=" + tag + ", user=" + user + ", commentContent=" + commentContent
					+ ", arguedUser=" + arguedUser + ", commentedContent=" + commentedContent + ", commentDate="
					+ commentDate + ", note=" + note + ", arguedId=" + arguedId + ", isLike=" + isLike + "]";
		}
	    
		
}