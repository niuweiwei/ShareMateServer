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
	private int userid;
	private int noteid;
	
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
	
}
