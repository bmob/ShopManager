package com.stone.shopmanager.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobQuery.CachePolicy;
import cn.bmob.v3.listener.FindListener;

import com.stone.shopmanager.R;
import com.stone.shopmanager.adapter.GoodsListAdapter;
import com.stone.shopmanager.model.Good;
import com.stone.shopmanager.model.Shop;

public class GoodManagerActivity extends Activity implements OnItemClickListener{

	@SuppressWarnings("unused")
	private static final String TAG = "GoodManagerActivity";

	private ListView lvMyGoodsList;
	private GoodsListAdapter goodsListAdapter;
	private Button btnBuyGood;

	private static List<Good> goodsList;
	
	// 从上级页面中传入的数据
	private Shop shop; // 当期选择的Shop
	private String shopID; // 当前选择的Shop的ID
	
	private Good selectGood;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_m_good);
		
		// 获取到从ShopAllActivity中传递过来的Shop对象
		shop = (Shop) getIntent().getSerializableExtra("shop");
		shopID = getIntent().getStringExtra("shopID");

		// 初始化商品页面以及适配数据
		initGoodsData();
		initView();
	}

	private void initView() {
		lvMyGoodsList = (ListView) findViewById(R.id.lv_m_goods);
		lvMyGoodsList.setAdapter(goodsListAdapter);
		lvMyGoodsList.setOnItemClickListener(this);
	}

	/**
	 * 获取某一商店的所有商品
	 * 
	 * @date 2014-5-1
	 * @autor Stone
	 */
	public void initGoodsData() {
		goodsList = new ArrayList<Good>();
		goodsListAdapter = new GoodsListAdapter(this, goodsList);
		BmobQuery<Good> query = new BmobQuery<Good>();
		query.addWhereEqualTo("shopID", shopID);
		query.setCachePolicy(CachePolicy.CACHE_ELSE_NETWORK); //
		// 先从缓存取数据，如果没有，再从网络取。
		query.setLimit(15); // 限制最多15个结果
		query.findObjects(this, new FindListener<Good>() {

			@Override
			public void onSuccess(List<Good> goods) {
				// toast("查询商品成功, 共" + goods.size());
				if (goods.size() == 0) {
					toast("亲, 该店还没有添加商品哦");
				}
				goodsList = goods;
				goodsListAdapter.refresh(goodsList);
				goodsListAdapter.notifyDataSetChanged();
			}

			@Override
			public void onError(String arg0) {
				toast("查询失败");
			}
		});

	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
	}
	
	public void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	}


}
