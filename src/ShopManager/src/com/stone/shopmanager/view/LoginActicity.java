package com.stone.shopmanager.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.InsertListener;

import com.stone.shopmanager.view.HomeActivity;
import com.stone.shopmanager.R;
import com.stone.shopmanager.model.User;
import com.stone.util.Util;

/**
 * 登陆界面
 * 
 * @date 2014-4-24
 * @author Stone
 */
public class LoginActicity extends Activity implements OnClickListener {

	private static final String TAG = "LoginActicity";

	private Button btnLogin;
	private EditText etUsername;
	private EditText etPassword;

	private String username;
	private String password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 初始化 Bmob SDK
		// 使用时请将第二个参数Application ID替换成你在Bmob服务器端创建的Application ID
		Bmob.initialize(this, "999848e5d36a83ae049281de8b8ae1a5");
		setContentView(R.layout.activity_login);

		btnLogin = (Button) findViewById(R.id.btn_login);

		etUsername = (EditText) findViewById(R.id.et_username);
		etPassword = (EditText) findViewById(R.id.et_password);

		btnLogin.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 登陆
		case R.id.btn_login:
			username = etUsername.getText().toString();
			password = etPassword.getText().toString();

			username = "admin";
			password = "12345";
			
			if( !Util.isNetworkConnected(this) ){
				toast("亲, 没有网络 ( ⊙ o ⊙ ) ");
			} else if (username.equals("") || password.equals("")) {
				toast("亲, 请输入小菜账号和密码");
				break;
			} else {
				User bu2 = new User();
				bu2.setUsername(username);
				bu2.setPassword(password);
				bu2.login(this, new InsertListener() {
					@Override
					public void onSuccess() {
						toast("亲, 小菜来罗~");
						// 跳转到主页
						Intent toHome = new Intent(LoginActicity.this, HomeActivity.class);
						startActivity(toHome);
						//finish();
					}

					@Override
					public void onFailure(String msg) {
						toast("用户名或密码错误");
					}
				});
			}
			break;
		default:
			break;

		}
	}

	public void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	};

}
