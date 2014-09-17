package com.stone.shopmanager.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.stone.shopmanager.R;
import com.stone.shopmanager.adapter.NewsListAdapter;
import com.stone.shopmanager.model.News;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetServerTimeListener;

public class NewsManagerActivity extends Activity implements
		OnItemClickListener {

	private static final String TAG = "HomeActivity";

	// 校园新闻
	private ListView lvNewsList;
	private List<News> newsList = new ArrayList<News>();
	private NewsListAdapter newsListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_m_news);

		getNewsData();
		initView();
	}

	private void initView() {
		lvNewsList = (ListView) findViewById(R.id.lv_news);
		// 新闻
		newsListAdapter = new NewsListAdapter(this, newsList);
		lvNewsList.setAdapter(newsListAdapter);
		lvNewsList.setOnItemClickListener(this);
	}

	/**
	 * 初始化新闻列表数据
	 * 
	 * @date 2014-5-3
	 * @author Stone
	 */
	public void getNewsData() {
		BmobQuery<News> query = new BmobQuery<News>();
		query.order("-updatedAt");
		query.findObjects(this, new FindListener<News>() {

			@Override
			public void onSuccess(List<News> object) {
				newsList = object;
				// 通知Adapter数据更新
				newsListAdapter.refresh((ArrayList<News>) newsList);
				newsListAdapter.notifyDataSetChanged();
			}

			@Override
			public void onError(String arg0) {
				toast("都怪小菜我, 获取数据失败了");
			}
		});
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// Intent toNewsDetail = new Intent(NewsManagerActivity.this,
		// NewsActivity.class);
		// toNewsDetail.putExtra("NewsTitle",
		// newsList.get(position).getTitle());
		// toNewsDetail.putExtra("NewsAuthor",
		// newsList.get(position).getAuthor());
		// toNewsDetail.putExtra("NewsTime",
		// newsList.get(position).getCreatedAt());
		// toNewsDetail.putExtra("NewsContent",
		// newsList.get(position).getContent());
		// startActivity(toNewsDetail);
	}

	public void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT);
	}

}
