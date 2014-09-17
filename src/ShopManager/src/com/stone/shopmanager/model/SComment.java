package com.stone.shopmanager.model;

import cn.bmob.v3.BmobObject;

/**
 * 店铺评论实体类
 * @date 2014-5-3
 * @author Stone
 */
public class SComment extends BmobObject {

	// private String id;
	// private String time;

	private String shopID;
	private String shopName;
	private String userID;
	private String userName;
	private String content;

	public String getShopID() {
		return shopID;
	}

	public void setShopID(String shopID) {
		this.shopID = shopID;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
