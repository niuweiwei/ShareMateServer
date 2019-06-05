package com.sharemate.entity;

import java.util.Date;
import java.util.List;

/**

* @author fengjiaxing

* @version 2019年5月15日 上午8:45:06 

*/
public class Note {

	private int noteId;
	private String noteVideo;
	private String noteTitle;
	private String noteDetail;
	private String noteImage;
	private String noteDate;
	private String noteAddress;
	private int typeId;
	private Type type;
	private User user;
	private int likeCount;
	private int collectCount;
	private int commentCount;
	private boolean isLike;
	private boolean isCollect;
	private boolean isFollow;

	public Note() {
		super();
	}
	
	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getNoteVideo() {
		return noteVideo;
	}
	public void setNoteVideo(String noteVideo) {
		this.noteVideo = noteVideo;
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
	public String getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(String noteDate) {
		this.noteDate = noteDate;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
	public boolean isLike() {
		return isLike;
	}
	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}
	public int getCollectCount() {
		return collectCount;
	}
	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}
	public boolean isCollect() {
		return isCollect;
	}
	public void setCollect(boolean isCollect) {
		this.isCollect = isCollect;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public boolean isFollow() {
		return isFollow;
	}
	public void setFollow(boolean isFollow) {
		this.isFollow = isFollow;
	}
	public String getNoteAddress() {
		return noteAddress;
	}
	public void setNoteAddress(String noteAddress) {
		this.noteAddress = noteAddress;
	}
		
}
