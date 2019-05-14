package com.sharemate.entity;

import java.sql.Date;

import org.springframework.stereotype.Repository;

/**
 * @author niuweiwei
 * 笔记类
 * */
@Repository
public class Note {
	
	private int noteId;
	private String noteTitle;
	private String noteDetail;
	private String noteImage;
	private Date noteDate;
	private int noteType;
	private User user;
	
	public Note() {
		super();
	}
	public Note(int noteId, String noteTitle, String noteDetail, String noteImage, Date noteDate, int noteType,
			User user) {
		super();
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteDetail = noteDetail;
		this.noteImage = noteImage;
		this.noteDate = noteDate;
		this.noteType = noteType;
		this.user = user;
	}
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
	public Date getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}
	public int getNoteType() {
		return noteType;
	}
	public void setNoteType(int noteType) {
		this.noteType = noteType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteTitle=" + noteTitle + ", noteDetail=" + noteDetail + ", noteImage="
				+ noteImage + ", noteDate=" + noteDate + ", noteType=" + noteType + ", user=" + user + "]";
	}
	
	

}
