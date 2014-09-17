package com.stone.shopmanager.model;

import cn.bmob.v3.BmobObject;

/**
 * 博学堂讲座实体类
 * @date 2014-5-10
 * @author Stone
 */
public class BXTNews extends BmobObject{
	
	//private String id;
	
	private String title;			//标题
	private String topic;			//讲座主题
	private String speaker;			//主 讲 人
	private String time;			//讲座时间
	private String location;		//讲座地点
	private String holder1;			//主办单位
	private String holder2;			//承办单位
	private String points;			//主讲内容提要
	private String speakerinfo;		//主讲人简介
	
	public String getTitle() {
		return title;
	}
	public String getTopic() {
		return topic;
	}
	public String getSpeaker() {
		return speaker;
	}
	public String getTime() {
		return time;
	}
	public String getLocation() {
		return location;
	}
	public String getHolder1() {
		return holder1;
	}
	public String getHolder2() {
		return holder2;
	}
	public String getPoints() {
		return points;
	}
	public String getSpeakerinfo() {
		return speakerinfo;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setHolder1(String holder1) {
		this.holder1 = holder1;
	}
	public void setHolder2(String holder2) {
		this.holder2 = holder2;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public void setSpeakerinfo(String speakerinfo) {
		this.speakerinfo = speakerinfo;
	}
}
