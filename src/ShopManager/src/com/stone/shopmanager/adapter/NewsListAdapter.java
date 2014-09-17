package com.stone.shopmanager.adapter;

import java.util.ArrayList;
import java.util.List;

import com.stone.shopmanager.R;
import com.stone.shopmanager.model.News;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 新闻列表适配器
 * 
 * @date 2014-5-3
 * @author Stone
 */
public class NewsListAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater = null;
	private List<News> mNewsList = null; // 所选分类下的所有店铺列表

	public NewsListAdapter(Context context, List<News> newsList) {
		mContext = context;
		mNewsList = newsList;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mNewsList.size();
	}

	@Override
	public Object getItem(int position) {
		return mNewsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// 刷新列表中的数据
	public void refresh(ArrayList<News> list) {
		mNewsList = list;
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		NewsHolder newsHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.news_list_item, null);
			newsHolder = new NewsHolder();
			newsHolder.tvNewsType = (TextView) convertView
					.findViewById(R.id.tv_news_type);
			newsHolder.tvNewsTitle = (TextView) convertView
					.findViewById(R.id.tv_news_title);
			newsHolder.tvNewsDate = (TextView) convertView
					.findViewById(R.id.tv_news_date);
			convertView.setTag(newsHolder);
		} else {
			newsHolder = (NewsHolder) convertView.getTag();
		}
		//拆分字符串，只取年月日
		String[] ss = new String[2];
		ss = mNewsList.get(position).getCreatedAt().split(" ");
		newsHolder.tvNewsType.setText(mNewsList.get(position).getType());	//新闻类型
		newsHolder.tvNewsTitle.setText(mNewsList.get(position).getTitle());	//新闻标题
		newsHolder.tvNewsDate.setText(ss[0]);	//新闻发布日期
		return convertView;
	}

}
