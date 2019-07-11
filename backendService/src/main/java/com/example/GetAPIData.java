package com.example;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class GetAPIData {

	public String getDataURL(String url, List<NameValuePair> params) {
		String data = "";
		HttpClient httpClient = new DefaultHttpClient();
	    HttpPost httpPost = new HttpPost(url);
	    try {
	        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	    try {
	        HttpResponse response = httpClient.execute(httpPost);
	        HttpEntity respEntity = response.getEntity();
	        if (respEntity != null) {
	            data =  EntityUtils.toString(respEntity);
	        }
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return data;
	}
}
