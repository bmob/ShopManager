package com.stone.shopmanager.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

import com.stone.shopmanager.R;
import com.stone.shopmanager.model.Shop;

public class HomeActivity extends Activity implements OnClickListener{
	
	@SuppressWarnings("unused")
	private static final String TAG = "HomeActivity";
	
	private Button btnShopManager;
	private Button btnGoodsManager;
	private Button btnOrdersManager;
	private Button btnAboutApp;
	private Button btnNewsManager;
	private TextView tvShopName;
	private TextView tvShopLabel;
	
	private List<Shop> myShopList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		initView();
		initData();
	}

	private void initData()
	{
		myShopList = new ArrayList<Shop>();
		BmobQuery<Shop> query = new BmobQuery<Shop>();
		query.addWhereEqualTo("userID", "admin");
		query.findObjects(this, new FindListener<Shop>() {
		        
				@Override
		        public void onSuccess(List<Shop> shopList) {
					myShopList = shopList;
					if(shopList.size()>0)
					{
						tvShopLabel.setVisibility(View.VISIBLE);
						tvShopName.setVisibility(View.VISIBLE);
						tvShopName.setText(shopList.get(0).getName());
					}
						
		        }

				@Override
				public void onError(String arg0) {
					
				}
		});
	}
	
	private void initView()
	{
		btnShopManager = (Button) findViewById(R.id.btn_m_shop);
		btnGoodsManager = (Button) findViewById(R.id.btn_m_good);
		btnOrdersManager = (Button) findViewById(R.id.btn_m_order);
		btnAboutApp = (Button) findViewById(R.id.btn_m_about);
		btnNewsManager = (Button) findViewById(R.id.btn_m_news);
		tvShopName = (TextView) findViewById(R.id.tv_shop_name);
		tvShopLabel = (TextView) findViewById(R.id.tv_shop_label);
		
		btnShopManager.setOnClickListener(this);
		btnGoodsManager.setOnClickListener(this);
		btnOrdersManager.setOnClickListener(this);
		btnAboutApp.setOnClickListener(this);
		btnNewsManager.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_m_shop:
			Intent toShopManagerActivity = new Intent(HomeActivity.this, ShopManagerActivity.class);
			startActivity(toShopManagerActivity);
			break;
		case R.id.btn_m_good:
			//将当前点击的Shop对象传递给下一个Activity
			Intent toGoodsManagerActivity = new Intent(HomeActivity.this, GoodManagerActivity.class);
			if(myShopList.size()!=0)
			{
				Bundle bundle = new Bundle();  
				bundle.putSerializable("shop", myShopList.get(0));  
	        	bundle.putString("shopID", myShopList.get(0).getObjectId()); //商铺的ID需要单独传递,否则获取到的是null
	        	toGoodsManagerActivity.putExtras(bundle);
	        	startActivity(toGoodsManagerActivity);
			}
			break;
		case R.id.btn_m_order:
			Intent toOrdersManagerActivity = new Intent(HomeActivity.this, OrderManagerActivity.class);
			startActivity(toOrdersManagerActivity);
			break;
		case R.id.btn_m_about:
			Intent toAboutActivity = new Intent(HomeActivity.this, AboutActivity.class);
			startActivity(toAboutActivity);
			break;
		case R.id.btn_m_news:
			Intent toNewsManagerActivity = new Intent(HomeActivity.this, NewsManagerActivity.class);
			startActivity(toNewsManagerActivity);
			break;
		default:
			break;
		}
	}
	
	public void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	};

	
}
