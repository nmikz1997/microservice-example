package com.example.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.example.GetAPIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UnitController {
	
	@Value("${server.port}")
	private int serverPort;
	
	GetAPIData getAPIData = new GetAPIData();
	 
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@PostMapping(value = "/units") //add param va gui post len api va tra ve kieu chuoi
	@HystrixCommand(fallbackMethod = "fallBackMethod")
	public @ResponseBody String callFindUnit(@RequestBody Map<String,Object> body) {
		
		ServiceInstance serviceInstance = loadBalancerClient.choose("UNIT-SERVICE");
		
		URI uri = serviceInstance.getUri();
		
		String offset 	= body.get("offset").toString();
		String limit 	= body.get("limit").toString();
		
		//String unitName = body.get("unitName").toString();
		
	    List<NameValuePair> params = new ArrayList<NameValuePair>();
	    
	    params.add(new BasicNameValuePair("offset", offset));
	    params.add(new BasicNameValuePair("limit", limit));
	    
	    System.out.println(serviceInstance.getUri().toString());
	    System.out.println(uri);
	    
	    String data = "";
	    
	    data = getAPIData.getDataURL(serviceInstance.getUri().toString()+"/api/units", params);
		return data;
	} 
	@PostMapping(value = "/units/search") //add param va gui post len api va tra ve kieu chuoi
	@HystrixCommand(fallbackMethod = "fallBackMethod")
	public @ResponseBody String callFindUnitByName(@RequestBody Map<String,Object> body) {		
		ServiceInstance serviceInstance = loadBalancerClient.choose("UNIT-SERVICE");
		
		String offset 	= body.get("offset").toString();
		String limit 	= body.get("limit").toString();
		
		String untName	= body.get("untName").toString();
		String preId	= body.get("preId").toString();
		String ditId	= body.get("ditId").toString();
		String wadId	= body.get("wadId").toString();
		
	    List<NameValuePair> params = new ArrayList<NameValuePair>();
	    
	    params.add(new BasicNameValuePair("offset", offset));
	    params.add(new BasicNameValuePair("limit", limit));
	    
	    params.add(new BasicNameValuePair("untName", untName));
	    params.add(new BasicNameValuePair("preId", preId));
	    params.add(new BasicNameValuePair("ditId", ditId));
	    params.add(new BasicNameValuePair("wadId", wadId));
	    
	    System.out.println("backEnd Service port: " +serverPort);
	    System.out.println(serviceInstance.getUri().toString());
	    
	    String data = "";
	    
	    data = getAPIData.getDataURL(serviceInstance.getUri().toString()+"/api/units/search", params);
		return data;
	} 
	
	public String fallBackMethod(@RequestBody Map<String,Object> body) //phải có cùng tham số nhận vào với ngoại lệ cần bắt
	{
		return "Fallback form UnitController Web-Service";
	} 
}
