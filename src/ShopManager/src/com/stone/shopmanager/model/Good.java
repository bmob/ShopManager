package com.stone.shopmanager.model;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * 商品实体类
 * @date 2014-4-24
 * @author Stone
 */
public class Good extends BmobObject implements Serializable{
	
	private static final long serialVersionUID = -3248168273019127389L;
	
	//private String id;  商品ID, 默认
	
	private String shopID = ""; 		// 商店ID
	private String shopName = "";		//商店名称
	private String type = ""; 		// 类型
	private String name = ""; 		// 名称
	private String price = ""; 		// 价格
	private BmobFile picGood = null; 	// 商品主图
	
	public Good(String name, String price) {
		this.name = name;
		this.price  = price;
	}
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
