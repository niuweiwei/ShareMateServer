package com.sharemate.entity;

import java.util.Date;

public class Like {
private int userid;
private int noteid;
private Date likeDate;
public Date getLikeDate() {
	return likeDate;
}

public void setLikeDate(Date likeDate) {
	this.likeDate = likeDate;
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
