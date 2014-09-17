package com.stone.old;

import java.util.Iterator;
import java.util.List;

import com.stone.shopmanager.R;
import com.stone.shopmanager.model.Good;
import com.stone.shopmanager.model.News;
import com.stone.shopmanager.model.Shop;
import com.stone.shopmanager.model.User;
import com.stone.shopmanager.view.AddNewsActivity;
import com.stone.shopmanager.view.AddShopActivity;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity implements OnClickListener {

	private Button btnLookUsers;
	private Button btnLookShops;
	private Button btnLookGoods;
	private Button btnLookNews;

	private Button btnAddShop;
	private Button btnAddGood;
	private Button btnAddNews;

	private TextView tvRes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);

		initView();
	}

	public void initView() {
		btnLookUsers = (Button) findViewById(R.id.btn_look_users);
		btnLookShops = (Button) findViewById(R.id.btn_look_shops);
		btnLookGoods = (Button) findViewById(R.id.btn_look_goods);
		btnLookNews = (Button) findViewById(R.id.btn_look_news);
		btnAddShop = (Button) findViewById(R.id.btn_add_shop);
		btnAddGood = (Button) findViewById(R.id.btn_add_good);
		btnAddNews = (Button) findViewById(R.id.btn_add_news);
		tvRes = (TextView) findViewById(R.id.tv_res);
		tvRes.setMovementMethod(ScrollingMovementMethod.getInstance());

		btnLookUsers.setOnClickListener(this);
		btnLookShops.setOnClickListener(this);
		btnLookGoods.setOnClickListener(this);
		btnLookNews.setOnClickListener(this);
		btnAddShop.setOnClickListener(this);
		btnAddGood.setOnClickListener(this);
		btnAddNews.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 查看所有注册的用户
		case R.id.btn_look_users:
			lookUsers();
			break;

		// 查看所有的店铺
		case R.id.btn_look_shops:
			lookShops();
			break;

		// 查看所有的商品
		case R.id.btn_look_goods:
			lookGoods();
			break;

		// 查看所有的新闻
		case R.id.btn_look_news:
			lookNews();
			break;

		// 添加店铺
		case R.id.btn_add_shop:
			addShop();
			break;

		// 添加商品
		case R.id.btn_add_good:
			addGood();
			break;

		// 添加新闻
		case R.id.btn_add_news:
			addNews();
			break;

		default:
			break;
		}
	}

	private void lookUsers() {
		toast("加载中...");
		BmobQuery<User> query = new BmobQuery<User>();
		// query.addWhereEqualTo("username", "lucky");
		query.findObjects(this, new FindListener<User>() {
			@Override
			public void onSuccess(List<User> object) {
				toast("查询用户成功：" + object.size());
				tvRes.setText(" ");
				Iterator<User> iterator = object.iterator();
				while (iterator.hasNext()) {
					User user = iterator.next();
					if (tvRes.getText().equals(" ")) {
						tvRes.setText("共计 " + object.size() + " 条数据" + "\n");
					}
					tvRes.setText(tvRes.getText() + user.getObjectId()
							+ "\t\t\t" + user.getUsername() + "\t\t\t"
							+ user.getUpdatedAt() + "\n");
				}
			}

			@Override
			public void onError(String msg) {
				toast("查询用户失败：" + msg);
			}
		});
	}

	private void lookShops() {
		BmobQuery<Shop> query = new BmobQuery<Shop>();
		query.findObjects(this, new FindListener<Shop>() {
			@Override
			public void onSuccess(List<Shop> object) {
				// TODO Auto-generated method stub
				toast("查询成功：共" + object.size() + "条数据。");
				tvRes.setText(" ");
				Iterator<Shop> iterator = object.iterator();
				while (iterator.hasNext()) {
					Shop shop = iterator.next();
					if (tvRes.getText().equals(" ")) {
						tvRes.setText("共计 " + object.size() + " 条数据" + "\n");
					}
					tvRes.setText(tvRes.getText() + shop.getObjectId()
							+ "\t\t\t" + shop.getName() + "\t\t\t"
							+ shop.getUserID() + "\t\t\t" + shop.getUpdatedAt()
							+ "\n");
				}
			}

			@Override
			public void onError(String msg) {
				// TODO Auto-generated method stub
				toast("查询失败：" + msg);
			}
		});
	}

	private void lookGoods() {
		BmobQuery<Good> query = new BmobQuery<Good>();
		query.findObjects(this, new FindListener<Good>() {
			@Override
			public void onSuccess(List<Good> object) {
				// TODO Auto-generated method stub
				toast("查询成功：共" + object.size() + "条数据。");
				tvRes.setText(" ");
				Iterator<Good> iterator = object.iterator();
				while (iterator.hasNext()) {
					Good good = iterator.next();
					if (tvRes.getText().equals(" ")) {
						tvRes.setText("共计 " + object.size() + " 条数据" + "\n");
					}
					tvRes.setText(tvRes.getText() + good.getObjectId()
							+ "\t\t\t" + good.getName() + "\t\t\t"
							+ good.getPrice() + "\t\t\t" + good.getShopName()
							+ "\t\t\t" + good.getUpdatedAt() + "\n");
				}
			}

			@Override
			public void onError(String msg) {
				// TODO Auto-generated method stub
				toast("查询失败：" + msg);
			}
		});
	}

	private void lookNews() {
		BmobQuery<News> query = new BmobQuery<News>();
		query.findObjects(this, new FindListener<News>() {
			@Override
			public void onSuccess(List<News> object) {
				// TODO Auto-generated method stub
				toast("查询成功：共" + object.size() + "条数据。");
				tvRes.setText(" ");
				Iterator<News> iterator = object.iterator();
				while (iterator.hasNext()) {
					News news = iterator.next();
					if (tvRes.getText().equals(" ")) {
						tvRes.setText("共计 " + object.size() + " 条数据" + "\n");
					}
					tvRes.setText(tvRes.getText() + news.getObjectId()
							+ "\t\t\t" + news.getTitle() + "\t\t\t"
							+ news.getType() + "\t\t\t" +news.getAuthor() + "\t\t\t" +news.getUpdatedAt()
							+ "\n");
				}
			}

			@Override
			public void onError(String msg) {
				// TODO Auto-generated method stub
				toast("查询失败：" + msg);
			}
		});
	}

	private void addShop() {
		Intent toAddShopActivity = new Intent(HomeActivity.this, AddShopActivity.class);
		startActivity(toAddShopActivity);
	}

	private void addGood() {

	}

	private void addNews() {
		Intent toAddNewsActivity = new Intent(HomeActivity.this, AddNewsActivity.class);
		startActivity(toAddNewsActivity);
	}

	private void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	}

}
