package com.hospital.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;
import com.google.gson.reflect.TypeToken;
import com.hospital.global.Global;
import com.hospital.model.Doctor;
import com.hospital.util.GsonUtil;
import com.hospital.util.HttpUtil;
import com.hospital.util.MyContants;

public class DoctorActivity extends Activity{
	
	private ListView listView;
	private List<Doctor> list;
	private int doctorId;
	private String type;
	private Map<String, String> getNumberInfo = new HashMap<String, String>();
	private Map<String, String> getDoctorInfo = new HashMap<String, String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctor);
		
		listView = (ListView) findViewById(R.id.doctorList);
		////
		Toast.makeText(this, getIntent().getExtras().getString("type"), 2).show();
		getDoctorInfo.put("type", getIntent().getExtras().getString("type"));
		
		try {
			String result = HttpUtil.postRequest(MyContants.BASE_URL+"DoctorFindServlet",getDoctorInfo);
			if (result == null){
				Toast.makeText(DoctorActivity.this, "没有该科医生或网络出现问题", 2).show();
				return ;
			}
			else {
				list = GsonUtil.getGson().fromJson(result, new TypeToken<List<Doctor>>(){}.getType());
				List<String> doctorInfoList = new ArrayList<String>();
				for (Doctor d : list){
					doctorInfoList.add("编号："+d.getId()+"   姓名："+d.getName() + "\n个人信息：" + d.getInfo() + "\n科室："+d.getType());
				}
				listView.setAdapter(new MyAdapter(doctorInfoList));
				listView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int position, long arg3) {
						doctorId = list.get(position).getId();
						getNumberInfo.put("userId", Global.user.getId()+"");
						getNumberInfo.put("doctorId", doctorId+"");

						try {
							HttpUtil.postRequest(MyContants.BASE_URL + "GetNumberAddServlet", getNumberInfo);
							Toast.makeText(DoctorActivity.this, "挂号成功", 2).show();
						} catch (Exception e) {
							Toast.makeText(DoctorActivity.this, "网络连接错误", 2).show();
							e.printStackTrace();
							return ;
						}
						Intent intent = new Intent(DoctorActivity.this, InfoActivity.class);
						startActivity(intent);
						DoctorActivity.this.finish();
					}
				});
			}
		} catch (Exception e) {
			Toast.makeText(DoctorActivity.this, "网络出现问题", 2).show();
			e.printStackTrace();
			return ;
		}
	}
	
	// 医生列表适配器
	class MyAdapter extends BaseAdapter{
		private List<String> list;
		
		public MyAdapter(List<String> list){
			this.list = list;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return list.get(arg0);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView textView = new TextView(DoctorActivity.this);
			textView.setTextSize(20);
			textView.setText(list.get(position));
			return textView;
		}
		
	}
}
