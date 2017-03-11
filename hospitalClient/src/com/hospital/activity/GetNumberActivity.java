package com.hospital.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.test.R;
import com.hospital.util.MyContants;

public class GetNumberActivity extends Activity{
	
	private Spinner spinner;
	private TextView textView;
	private Button okButton;
	private String type = "外科";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.getnumber);
		
		spinner = (Spinner) findViewById(R.id.chooseOfficeSpinner);
		okButton = (Button) findViewById(R.id.chooseOfficeInfoButton);
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,MyContants.classArray);
		spinner.setAdapter(arrayAdapter);
		
		spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){ 
	        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) { 
	            type = MyContants.classArray[arg2];
	            arg0.setVisibility(View.VISIBLE); 
	        } 
	        public void onNothingSelected(AdapterView<?> arg0) { 
	           
	        } 
	    }); 
		
		okButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GetNumberActivity.this, DoctorActivity.class);
				intent.putExtra("type", type);
				startActivity(intent);	
			}
		});
	}
	
	
	
}
