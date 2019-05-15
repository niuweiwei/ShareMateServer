package com.sharemate.entity;

public class Follow {
	
	private int id;
	private User followUser;
	private User followedUser;
	private String followDate;
	//用于标记被关注的人时候关注了关注的人(followedUser时候关注了followUser)
	private boolean isFollow;
	
	public Follow() {
		super();
	}
	
	public Follow(int id, User followUser, User followedUser, String followDate, boolean isFollow) {
		super();
		this.id = id;
		this.followUser = followUser;
		this.followedUser = followedUser;
		this.followDate = followDate;
		this.isFollow = isFollow;
	}

	public boolean isFollow() {
		return isFollow;
	}

	public void setFollow(boolean isFollow) {
		this.isFollow = isFollow;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFollowDate() {
		return followDate;
	}
	public void setFollowDate(String followDate) {
		this.followDate = followDate;
	}
	@Override
	public String toString() {
		return "Follow [id=" + id + ", followUser=" + followUser + ", followedUser=" + followedUser + ", followDate="
				+ followDate + "]";
	}
	
}
