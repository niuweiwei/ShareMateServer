package com.sharemate.entity;
/**

* @author fengjiaxing

* @version 2019年5月15日 上午11:45:16 

*/
public class Collect {
	/*嘉星*/
	private User user;
	private Note note;
	/*付娆*/
	private int user_id;
	private int note_id;
	
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
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
