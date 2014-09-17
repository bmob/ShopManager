package com.stone.shopmanager.model;

import cn.bmob.v3.BmobObject;

/**
 * 首页校内新闻实体类
 * 
 * @date 2014-5-3
 * @author Stone
 */
public class News extends BmobObject {

	// private String id;
	// private String time;

	private String type; // 新闻类型
	private String title; // 新闻标题
	private String author; // 新闻作者
	private String content; // 新闻内容

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
