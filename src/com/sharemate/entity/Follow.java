package com.sharemate.entity;

import java.sql.Date;

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
	/*付娆*/
	private int followuserid;
	private int followeduserid;
	private Date followdate;
	/*薇薇*/
	//用于标记被关注的人时候关注了关注的人(followedUser时候关注了followUser)
	private boolean isFollow;
		
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
	public int getFollowuserid() {
		return followuserid;
	}
	public void setFollowuserid(int followuserid) {
		this.followuserid = followuserid;
	}
	public int getFolloweduserid() {
		return followeduserid;
	}
	public void setFolloweduserid(int followeduserid) {
		this.followeduserid = followeduserid;
	}
	public Date getFollowdate() {
		return followdate;
	}
	public void setFollowdate(Date followdate) {
		this.followdate = followdate;
	}
	public boolean isFollow() {
		return isFollow;
	}
	public void setFollow(boolean isFollow) {
		this.isFollow = isFollow;
	}
	
}
