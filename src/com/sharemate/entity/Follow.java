package com.sharemate.entity;
/**

* @author fengjiaxing

* @version 2019年5月15日 下午3:45:00 

*/
public class Follow {
	private int id;
	private User followUser;
	private User followedUser;
	private String followDate;
	private boolean status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFollowDate() {
		return followDate;
	}
	public void setFollowDate(String followDate) {
		this.followDate = followDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public User getFollowUser() {
		return followUser;
	}
	public void setFollowUser(User followUser) {
		this.followUser = followUser;
	}
	public User getFollowedUser() {
		return followedUser;
	}
	public void setFollowedUser(User followedUser) {
		this.followedUser = followedUser;
	}
	
}
