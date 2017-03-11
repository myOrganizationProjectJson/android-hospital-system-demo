package com.hospital.activity;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;
import com.google.gson.reflect.TypeToken;
import com.hospital.model.Diagnosis;
import com.hospital.util.GsonUtil;
import com.hospital.util.HttpUtil;
import com.hospital.util.MyContants;


public class HospitalTableActivity extends Activity{
	
	private TextView textView;
	private List<Diagnosis> diagnosisList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hospitaltable);
		textView = (TextView) findViewById(R.id.hospitalTable);
		try {
			String result = HttpUtil.getRequest(MyContants.BASE_URL + "DiagnosisListServlet");
			if (result == null){
				Toast.makeText(HospitalTableActivity.this, "登陆失败！请检查输入信息和网络连接!", 2).show();
				return ;
			}
			else {
				String info = "";
				diagnosisList = GsonUtil.getGson().fromJson(result, new TypeToken<List<Diagnosis>>(){}.getType());
				for (Diagnosis d : diagnosisList){
					info = info + "医生编号：" + d.getDoctorId() + "        星期：" + d.getWeek() + "\n";
				}
				textView.setText(info);
			}
		} catch (Exception e) {
			Toast.makeText(HospitalTableActivity.this, "登陆失败！请检查网络连接!", 2).show();
			e.printStackTrace();
			return ;
		}
		
	}
}
