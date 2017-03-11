package com.hospital.activity;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test.R;
import com.hospital.global.Global;
import com.hospital.model.User;
import com.hospital.util.GsonUtil;
import com.hospital.util.HttpUtil;
import com.hospital.util.MyContants;

public class HospitalActivity extends Activity {
	
	private EditText userNameEdit;  
	private EditText userPasswordEdit;
	private Button loginButton;
	private Button quitButton;
	private Button registerButton;
	private User user;
	private Map<String, String> userInfo = new HashMap<String, String>();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        userNameEdit = (EditText)findViewById(R.id.userName);
        userPasswordEdit = (EditText)findViewById(R.id.userPassword);
        loginButton = (Button)findViewById(R.id.login);
        quitButton = (Button)findViewById(R.id.quit);
        registerButton = (Button)findViewById(R.id.register);
        
        loginButton.setOnClickListener(new OnClickListener() {  
			public void onClick(View v) {
				
				userInfo.put("userName", userNameEdit.getText().toString());
				userInfo.put("password", userPasswordEdit.getText().toString());
				if (userInfo.get("userName").equals("") || userInfo.get("password").equals("")){
					Toast.makeText(HospitalActivity.this, "请将信息输入完整!", 2).show();
					return ;
				}
				try {
					String result = HttpUtil.postRequest(MyContants.BASE_URL + "LoginServlet", userInfo);
					if (result == null){
						Toast.makeText(HospitalActivity.this, "登陆失败！请检查输入信息和网络连接!", 2).show();
						return ;
					}
					else {
						user = GsonUtil.getGson().fromJson(result, User.class);  // 解析Json
						Global.user = user;
					}
				} catch (Exception e) {
					Toast.makeText(HospitalActivity.this, "登陆失败！请检查网络连接!", 2).show();
					e.printStackTrace();
					return ;
				}
				
				Intent intent = new Intent(HospitalActivity.this, InfoActivity.class);
				startActivity(intent);
			}
		});
		quitButton.setOnClickListener(new OnClickListener() {  
			public void onClick(View v) {
				HospitalActivity.this.finish();
			}
		});
		registerButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(HospitalActivity.this, RegisterActivity.class);
				startActivity(intent);
			}
		});
    }
}