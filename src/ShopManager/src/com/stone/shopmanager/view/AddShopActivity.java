package com.stone.shopmanager.view;

import cn.bmob.v3.listener.InsertListener;

import com.stone.shopmanager.R;
import com.stone.shopmanager.model.Shop;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddShopActivity extends Activity implements OnClickListener {

	private EditText etShopName;
	private EditText etShopUser;
	private EditText etShopType;
	private EditText etShopLoc;
	private EditText etShopInfo;
	private EditText etShopSale;
	private EditText etShopPhone;
	
	private Button btnAddShop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addshop);
		
		initView();
	}

	public void initView() {
		etShopName = (EditText) findViewById(R.id.et_shop_name);
		etShopUser = (EditText) findViewById(R.id.et_shop_user);
		etShopType = (EditText) findViewById(R.id.et_shop_type);
		etShopLoc = (EditText) findViewById(R.id.et_shop_loc);
		etShopInfo = (EditText) findViewById(R.id.et_shop_info);
		etShopSale = (EditText) findViewById(R.id.et_shop_sale);
		etShopPhone = (EditText) findViewById(R.id.et_shop_phone);
		
		btnAddShop = (Button) findViewById(R.id.btn_create_shop);
		btnAddShop.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_create_shop:
			if (etShopName.getText().equals("")
					|| etShopUser.getText().toString().equals("")
					|| etShopType.getText().toString().equals("")
					|| etShopLoc.getText().toString().equals("")
					|| etShopInfo.getText().toString().equals("")
					|| etShopPhone.getText().toString().equals("")) {
				toast("请完善信息后再次提交");
			} else {
				addShop(new String[] { etShopName.getText().toString(),
						etShopUser.getText().toString(),
						etShopType.getText().toString(),
						etShopLoc.getText().toString(),
						etShopInfo.getText().toString(),
						etShopSale.getText().toString(),
						etShopPhone.getText().toString()});
			}
			break;

		default:
			break;
		}
	}

	private void addShop(String[] shopInfo) {
		Shop shop = new Shop();
		shop.setName(shopInfo[0]);
		shop.setUserID(shopInfo[1]);
		shop.setType(shopInfo[2]);
		shop.setLocation(shopInfo[3]);
		shop.setInfo(shopInfo[4]);
		shop.setSale(shopInfo[5]);
		shop.setPhone(shopInfo[6]);
		shop.insertObject(this, new InsertListener() {
			
			@Override
			public void onSuccess() {
				toast("添加成功");
			}
			
			@Override
			public void onFailure(String arg0) {
				toast("添加失败");
			}
		});
	}

	private void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	}

}
