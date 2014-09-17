package com.stone.shopmanager.model;

import cn.bmob.v3.BmobObject;

/**
 * 中奖用户
 * @date 2014-5-28
 * @author Stone
 */
public class LuckyUser extends BmobObject {
	
	private String username;
	private String award;
	
	public String getUsername() {
		return username;
	}
	public String getAward() {
		return award;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAward(String award) {
		this.award = award;
	}

}
