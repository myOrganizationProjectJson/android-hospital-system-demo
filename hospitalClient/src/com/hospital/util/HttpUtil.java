package com.hospital.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.widget.Toast;

public class HttpUtil {
	
	
	// Get方法
	public static String getRequest(String url) throws Exception{
		System.out.println("使用了get");
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);  // 创建Get对象
		HttpResponse httpResponse = httpClient.execute(get);
		if (httpResponse.getStatusLine().getStatusCode() == 200){  // 如果服务器成功返回响应
			System.out.println("get成功");
			String result = EntityUtils.toString(httpResponse.getEntity());  // 获取响应字符串
			return result;
		}
		return null;
	}
	
	public static String postRequest(String url, Map<String, String> rawParams) throws Exception {
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);  // 创建HttpPost对象
		System.out.println(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for (String key : rawParams.keySet()){
			// 封装请求
			params.add(new BasicNameValuePair(key, rawParams.get(key)));
		}
		// 设置请求参数
		post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
		System.out.println("*****************");
		HttpResponse httpResponse = httpClient.execute(post);  // 发送Post请求
		System.out.println("*****************");
		if (httpResponse.getStatusLine().getStatusCode() == 200){
			
			String result = EntityUtils.toString(httpResponse.getEntity());
			return result;
		}
		
		return null;
		
	}
	
}
