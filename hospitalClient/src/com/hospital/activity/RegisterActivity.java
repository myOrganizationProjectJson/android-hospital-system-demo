package com.hospital.activity;

import java.util.HashMap;
import java.util.Map;
import com.example.test.R;
import com.hospital.global.Global;
import com.hospital.util.GsonUtil;
import com.hospital.util.HttpUtil;
import com.hospital.util.MyContants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends Activity{
	
	private EditText userName;
	private EditText password;
	private EditText secondPassword;
	private EditText trueName;
	private Button register;
	private Button back;
	private Map<String, String> userInfo = new HashMap<String, String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		userName = (EditText) findViewById(R.id.registerUserName);
		password = (EditText) findViewById(R.id.registerUserPassword);
		secondPassword = (EditText) findViewById(R.id.registerUserSecondPassword);
		trueName = (EditText) findViewById(R.id.registerUserTrueName);
		register = (Button) findViewById(R.id.register);
		back = (Button) findViewById(R.id.registerBack);
		
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				userInfo.put("userName", userName.getText().toString());
				userInfo.put("password", password.getText().toString());
				userInfo.put("secondPassword", secondPassword.getText().toString());
				userInfo.put("trueName", trueName.getText().toString());
				if (userInfo.get("userName").equals("") || userInfo.get("password").equals("") ||
					userInfo.get("secondPassword").equals("") || userInfo.get("trueName").equals("")){
					Toast.makeText(RegisterActivity.this, "请将信息输入完整!", 2).show();
					return ;
				}
				if (!userInfo.get("password").equals(userInfo.get("secondPassword"))){
					Toast.makeText(RegisterActivity.this, "密码和确认密码不一致!", 2).show();
					return ;
				}
				else {
					try {
						String result = HttpUtil.postRequest(MyContants.BASE_URL + "UserAddServlet", userInfo);
						if (result == null || "fail".equals(result)){
							Toast.makeText(RegisterActivity.this, "登陆失败！请检查输入信息和网络连接!", 2).show();
							return ;
						}
						else {
							
						}
					} catch (Exception e) {
						Toast.makeText(RegisterActivity.this, "登陆失败！请检查网络连接!", 2).show();
						e.printStackTrace();
						return ;
					}
					Toast.makeText(RegisterActivity.this, "注册成功!", 2).show();
					RegisterActivity.this.finish();
				}
			}
		});
		back.setOnClickListener(new OnClickListener() {	
			public void onClick(View v) {
				RegisterActivity.this.finish();
			}
		});
	}
}
