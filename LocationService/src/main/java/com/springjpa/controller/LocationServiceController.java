package com.springjpa.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springjpa.model.LocationServiceModel;
import com.springjpa.responsitory.LocationServiceResponsitory;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


@Controller
public class LocationServiceController {
	
	@Autowired
	LocationServiceResponsitory locationServiceResponsitory;
	//
	private LoadBalancerClient loadBalancerClient;
	
	@RequestMapping(value = "/api/province", method = RequestMethod.POST)
	@ResponseBody
	public String findAllLocationOffsetLimit(HttpServletRequest request){
		int offset = 0;
		int limit = 0;
		int count = 0;
		
		String preName = null;
		try {
			limit = Integer.valueOf(request.getParameter("limit"));
			offset = Integer.valueOf(request.getParameter("offset"));
			preName = "%"+request.getParameter("preName").toString().trim()+"%";
		}catch(Exception e) {
			System.out.println("LocationServiceController findAllLocationOffsetLimit");
		}
		List<LocationServiceModel> listLocationServiceModels = null;
		try {
			listLocationServiceModels = locationServiceResponsitory.findLocationNameLimitOffset(preName, offset, limit);
			count = (int) locationServiceResponsitory.count();

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JSONObject resultset = new JSONObject();
		JSONObject metadata = new JSONObject();
		JSONArray results = new JSONArray();
		JSONObject jsonMain = new JSONObject();
		
		if(listLocationServiceModels.size() > 0) {
			resultset.put("count", count);
			resultset.put("offset", offset);
			resultset.put("limit", limit);
			metadata.put("resultset", resultset);
			
			for(LocationServiceModel pre:listLocationServiceModels) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("pre_id", pre.getPre_id());
				jsonObject.put("pre_name", pre.getPre_name());
				results.add(jsonObject);
			}
			jsonMain.put("metadata", metadata);
			jsonMain.put("results", results);
		}else {
			resultset.put("count", listLocationServiceModels.size());
			resultset.put("offset", offset);
			resultset.put("limit", limit);
			metadata.put("resultset", resultset);
			
			jsonMain.put("metadata", metadata);
			jsonMain.put("results", results);
		}
		
		return jsonMain.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "say-yeah", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "fallBackMethod")
	public String service2CallHello() {
		return new RestTemplate().getForObject("http://localhost:8100/hello", String.class);
	}
	
	public String fallBackMethod() //phải có cùng tham số nhận vào với ngoại lệ cần bắt
	{
		return "Fallback form UnitController Web-Service";
	} 
 
}