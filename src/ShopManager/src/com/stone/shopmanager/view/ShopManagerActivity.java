package com.stone.shopmanager.view;

import com.stone.shopmanager.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ShopManagerActivity extends Activity implements OnClickListener {

	private static final String TAg = "ShopManagerActivity";

	private Button btnAddNewShop;
	private Button btnModifyShop;
	private Button btnAddShopSale;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_m_shop);

		initView();
	}

	private void initView() {
		btnAddNewShop = (Button) findViewById(R.id.btn_m_shop_add);
		btnModifyShop = (Button) findViewById(R.id.btn_m_shop_modify);
		btnAddShopSale = (Button) findViewById(R.id.btn_m_shop_sale);

		btnAddNewShop.setOnClickListener(this);
		btnModifyShop.setOnClickListener(this);
		btnAddShopSale.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_m_shop_add:
			Intent toAddShopActivityIntent = new Intent(ShopManagerActivity.this, AddShopActivity.class);
			startActivity(toAddShopActivityIntent);
			break;
			
		case R.id.btn_m_shop_modify:

			break;
			
		case R.id.btn_m_shop_sale:

			break;

		default:
			break;
		}
	}

}
