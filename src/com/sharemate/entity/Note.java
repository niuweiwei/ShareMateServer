package com.sharemate.entity;

import java.util.Date;

public class Note {
	private int noteId;
	private String noteTitle;
	private String noteDetail;
	private String noteImage;
	private Date noteDate;
	private String notePosition;
	private int noteCommentCount;
	private int noteCollectionCount;
	private int noteLikeCount;
	private String userId;
	private String typeId;
	private String commentdetial;
	
	public String getCommentdetial() {
		return commentdetial;
	}
	public void setCommentdetial(String commentdetial) {
		this.commentdetial = commentdetial;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public int getNoteId() {
		return noteId;
	}
	public String getNotePosition() {
		return notePosition;
	}
	public void setNotePosition(String notePosition) {
		this.notePosition = notePosition;
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
	public Date getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
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
	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteTitle=" + noteTitle + ", noteDetail=" + noteDetail + ", noteImage="
				+ noteImage + ", noteDate=" + noteDate + ", noteCommentCount=" + noteCommentCount
				+ ", noteCollectionCount=" + noteCollectionCount + ", noteLikeCount=" + noteLikeCount + "]";
	}
}
