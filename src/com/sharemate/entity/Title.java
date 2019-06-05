package com.sharemate.entity;
/**

* @author fengjiaxing

* @version 2019年5月30日 上午9:51:08 

*/
public class Title {
	private int id;
	private User user;
	private Type type;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
