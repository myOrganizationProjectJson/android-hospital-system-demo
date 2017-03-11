package com.hospital.activity;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;
import com.google.gson.reflect.TypeToken;
import com.hospital.global.Global;
import com.hospital.model.GetNumber;
import com.hospital.util.GsonUtil;
import com.hospital.util.HttpUtil;
import com.hospital.util.MyContants;


public class InfoActivity extends Activity{
	
	private EditText userTrueName;
	private Button changeUserTrueName;
	private Button getInfo;
	private Button getNumber;
	private GetNumber getNumberInfo;
	private TextView getNumberContent;
	private Map<String, String> userInfo = new HashMap<String, String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
		
		userTrueName = (EditText) findViewById(R.id.userTureName);
		changeUserTrueName = (Button) findViewById(R.id.changeUserTrueName);
		getInfo = (Button) findViewById(R.id.getInfoButton);
		getNumber = (Button) findViewById(R.id.getNumber);
		getNumberContent = (TextView) findViewById(R.id.getNumberContent);
		
		userTrueName.setText(Global.user.getTrueName());
		
		try {
			String result = HttpUtil.getRequest(MyContants.BASE_URL + "GetNumberFindServlet?userId=" + Global.user.getId());
			getNumberInfo = GsonUtil.getGson().fromJson(result, new TypeToken<GetNumber>(){}.getType());
			if (getNumberInfo.getId() != 0){
				getNumberContent.setText("您已挂号\n  医生编号：" + getNumberInfo.getDoctorId() + "\n" + "请在医院排诊信息中查看该编号医生排诊信息！");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		changeUserTrueName.setOnClickListener(new OnClickListener() {  // 修改真实姓名
			@Override
			public void onClick(View v) {
				Global.user.setTrueName(userTrueName.getText().toString());
				System.out.println(Global.user.getTrueName());
				userInfo.put("userId", Global.user.getId()+"");
				userInfo.put("password", Global.user.getPassword());
				userInfo.put("trueName", Global.user.getTrueName());
				userInfo.put("userName", Global.user.getUserName());
				try {
					String result = HttpUtil.postRequest(MyContants.BASE_URL + "UserUpdateServlet", userInfo);
					if ("fail".equals(result)){
						Toast.makeText(InfoActivity.this, "修改失败!", 2).show();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Toast.makeText(InfoActivity.this, "网络出现错误!", 2).show();
					return ;
				}
				Toast.makeText(InfoActivity.this, "修改成功!", 2).show();
			}
		});
		
		getInfo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(InfoActivity.this, HospitalTableActivity.class);
				startActivity(intent);
			}
		});
		getNumber.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				if ("您未挂号！".equals(getNumberContent.getText().toString())){
					Intent intent = new Intent(InfoActivity.this, GetNumberActivity.class);
					startActivity(intent);
				}
				else {
					Builder builder = new Builder(InfoActivity.this);
					builder.setTitle("温馨提示");
					builder.setMessage("您是否删除原来的挂号信息重新挂号？点击 是 继续");
					builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialogg, int which) {
							// TODO Auto-generated method stub
							try {
								HttpUtil.getRequest(MyContants.BASE_URL + "GetNumberDeleteServlet?getNumberId=" + getNumberInfo.getId());
								Intent intent = new Intent(InfoActivity.this, GetNumberActivity.class);
								startActivity(intent);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								return ;
							}
						}
					});
					builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialogg, int which) {
							return ;
							
						}
					});
					builder.create().show();
				}
				
			}
		});
		
		
	}
}
