package com.stone.shopmanager.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import cn.bmob.v3.listener.InsertListener;

import com.stone.shopmanager.R;
import com.stone.shopmanager.model.News;

public class AddNewsActivity extends Activity implements OnClickListener ,OnItemSelectedListener{

	private EditText etNewsTitle;
	private Spinner  spNewsType = null;
	private EditText etNewsAuthor;
	private EditText etNewsContent;
	
	private Button btnAddNews;
	private String newsType="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addnews);
		
		initView();
	}

	public void initView() {
		etNewsTitle = (EditText) findViewById(R.id.et_news_title);
		spNewsType = (Spinner) findViewById(R.id.sp_news_type);
		etNewsAuthor = (EditText) findViewById(R.id.et_news_author);
		etNewsContent = (EditText) findViewById(R.id.et_news_content);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.news_type_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spNewsType.setAdapter(adapter);
		spNewsType.setOnItemSelectedListener(this);
		
		btnAddNews = (Button) findViewById(R.id.btn_add_news);
		btnAddNews.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_add_news:
			if (etNewsTitle.getText().equals("")
					|| etNewsAuthor.getText().toString().equals("")
					|| etNewsContent.getText().toString().equals("")
					|| newsType.equals("")) {
				toast("请完善信息后再次提交");
			} else {
				addShop(new String[] { etNewsTitle.getText().toString(),
						"【"+newsType+"】",
						etNewsAuthor.getText().toString(),
						etNewsContent.getText().toString() });
			}
			break;

		default:
			break;
		}
	}

	private void addShop(String[] shopInfo) {
		News news = new News();
		news.setTitle(shopInfo[0]);
		news.setType(shopInfo[1]);
		news.setAuthor(shopInfo[2]);
		news.setContent(shopInfo[3]);
		news.insertObject(this, new InsertListener() {

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

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		newsType = getResources().getStringArray(R.array.news_type_array)[position];
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		newsType = "";
		toast("请选择新闻的类型");
	}

}
