package com.sharemate.entity;


/**

* @author fengjiaxing

* @version 2019年5月15日 上午8:45:06 

*/
public class Note {
	private int noteId;
	private String noteTitle;
	private String noteDetail;
	private String noteImage;
	private String noteDate;
	private User user;
	private Type type;
	/*付娆*/
//	private Date noteDate;
	private String notePosition;
	private int noteCommentCount;
	private int noteCollectionCount;
	private int noteLikeCount;
	private int userId;
	private int typeId;
	private String commentdetial;
	private String videoPath;
	/*春柳*/
	private String noteVideo;
	private String noteAddress;
	private int likeCount;
	private int collectCount;
	private int commentCount;
	private boolean isLike;
	private boolean isCollect;
	private boolean isFollow;
	/*薇薇*/
	private int noteType;
	
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteDetail() {
		return noteDetail;
	}
	public void setNoteDetail(String noteDetail) {
		this.noteDetail = noteDetail;
	}
	public String getNoteImage() {
		return noteImage;
	}
	public void setNoteImage(String noteImage) {
		this.noteImage = noteImage;
	}
//	public Date getNoteDate() {
//		return noteDate;
//	}
//	public void setNoteDate(Date noteDate) {
//		this.noteDate = noteDate;
//	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getNotePosition() {
		return notePosition;
	}
	public void setNotePosition(String notePosition) {
		this.notePosition = notePosition;
	}
	public int getNoteCommentCount() {
		return noteCommentCount;
	}
	public void setNoteCommentCount(int noteCommentCount) {
		this.noteCommentCount = noteCommentCount;
	}
	public int getNoteCollectionCount() {
		return noteCollectionCount;
	}
	public void setNoteCollectionCount(int noteCollectionCount) {
		this.noteCollectionCount = noteCollectionCount;
	}
	public int getNoteLikeCount() {
		return noteLikeCount;
	}
	public void setNoteLikeCount(int noteLikeCount) {
		this.noteLikeCount = noteLikeCount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getCommentdetial() {
		return commentdetial;
	}
	public void setCommentdetial(String commentdetial) {
		this.commentdetial = commentdetial;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	public String getNoteVideo() {
		return noteVideo;
	}
	public void setNoteVideo(String noteVideo) {
		this.noteVideo = noteVideo;
	}
	public String getNoteAddress() {
		return noteAddress;
	}
	public void setNoteAddress(String noteAddress) {
		this.noteAddress = noteAddress;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getCollectCount() {
		return collectCount;
	}
	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public boolean isLike() {
		return isLike;
	}
	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}
	public boolean isCollect() {
		return isCollect;
	}
	public void setCollect(boolean isCollect) {
		this.isCollect = isCollect;
	}
	public boolean isFollow() {
		return isFollow;
	}
	public void setFollow(boolean isFollow) {
		this.isFollow = isFollow;
	}
	public String getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(String noteDate) {
		this.noteDate = noteDate;
	}
	public int getNoteType() {
		return noteType;
	}
	public void setNoteType(int noteType) {
		this.noteType = noteType;
	}
	
}
