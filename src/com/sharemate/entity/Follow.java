package com.sharemate.entity;

import java.sql.Date;

public class Follow {
	private int id;
	private int followuserid;
	private int followeduserid;
	private Date followdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
}
