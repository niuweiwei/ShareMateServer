package com.sharemate.entity;
/**

* @author fengjiaxing

* @version 2019年5月15日 下午3:45:00 

*/
public class Follow {
	private int id;
	private User user;
	private String followDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFollowDate() {
		return followDate;
	}
	public void setFollowDate(String followDate) {
		this.followDate = followDate;
	}
	
}
