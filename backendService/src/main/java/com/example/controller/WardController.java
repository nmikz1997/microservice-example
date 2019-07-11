package com.example.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.example.GetAPIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
 
@RestController
public class WardController {
	GetAPIData getAPIData = new GetAPIData();
	 
	@Autowired
	private LoadBalancerClient loadBalancerClient;
 
//	@GetMapping("/province")
//	@HystrixCommand(fallbackMethod = "fallBackMethod")
//	String loadBalancing() {
//		ServiceInstance serviceInstance = loadBalancerClient.choose("LocationService");
//		return serviceInstance.getUri().toString();
//	}
	
	@PostMapping(value = "/ward/search") //add param va gui post len api va tra ve kieu chuoi
	@HystrixCommand(fallbackMethod = "fallBackMethod")
	public @ResponseBody String callFindAllProvince(@RequestBody Map<String,Object> body) {
		
		ServiceInstance serviceInstance = loadBalancerClient.choose("LocationService");
		
		//String offset 	= body.get("offset").toString();
		//String limit 	= body.get("limit").toString();
		String dit_id 	= body.get("dit_id").toString();
		String wadName 	= body.get("wad_name").toString();
		
	    List<NameValuePair> params = new ArrayList<NameValuePair>();
	    
	    //params.add(new BasicNameValuePair("offset", offset));
	    //params.add(new BasicNameValuePair("limit", limit));
	    params.add(new BasicNameValuePair("dit_id", dit_id));
	    params.add(new BasicNameValuePair("wad_name", wadName));
	    
	    System.out.println(serviceInstance.getUri().toString());
	    String data;
	    data=  getAPIData.getDataURL(serviceInstance.getUri().toString()+"/api/ward", params);
		return data;
	} 
	
	public String fallBackMethod(@RequestBody Map<String,Object> body)
	{
		return "Fallback form Web-Service";
	}
}
