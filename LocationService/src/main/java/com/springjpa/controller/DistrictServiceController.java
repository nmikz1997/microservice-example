package com.springjpa.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springjpa.model.DistrictServiceModel;
import com.springjpa.responsitory.DistrictServiceResponsitory;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


@Controller
public class DistrictServiceController {
	
	@Autowired
	DistrictServiceResponsitory districtServiceResponsitory;
		
//	@RequestMapping(value = "/api/district", method = RequestMethod.GET)
//	@ResponseBody
//	public String findAlldistrict(){
//		int offset = 0;
//		int limit = 0;
//		int count = 0;
//		
//		List<districtServiceModel> listdistrictServiceModels = districtServiceResponsitory.findAlldistrict();
//		count = listdistrictServiceModels.size();
//		limit = count;
//		JSONObject resultset = new JSONObject();
//		JSONObject metadata = new JSONObject();
//		JSONArray results = new JSONArray();
//		JSONObject jsonMain = new JSONObject();
//		
//		if(listdistrictServiceModels.size() > 0) {
//			resultset.put("count", count);
//			resultset.put("offset", offset);
//			resultset.put("limit", limit);
//			metadata.put("resultset", resultset);
//			
//			for(districtServiceModel dit:listdistrictServiceModels) {
//				JSONObject jsonObject = new JSONObject();
//				jsonObject.put("dit_id", dit.getdit_id());
//				jsonObject.put("dit_name", dit.getdit_name());
//				results.add(jsonObject);
//			}
//			jsonMain.put("metadata", metadata);
//			jsonMain.put("results", results);
//		}else {
//			resultset.put("count", listdistrictServiceModels.size());
//			resultset.put("offset", offset);
//			resultset.put("limit", limit);
//			metadata.put("resultset", resultset);
//			
//			jsonMain.put("metadata", metadata);
//			jsonMain.put("results", results);
//		}
//		
//		return jsonMain.toString();
//	}
//	
//	

	
	@RequestMapping(value = "/api/district", method = RequestMethod.POST)
	@ResponseBody
	public String findAlldistrictOffsetLimit(HttpServletRequest request){
		int offset = 0;
		int limit = 0;
		int count = 0;
		int pre_id=0;
		
		String dit_name= null;
		try {
			pre_id = Integer.valueOf(request.getParameter("pre_id"));
			dit_name = "%"+request.getParameter("dit_name")+"%";
			
			limit = Integer.valueOf(request.getParameter("limit"));
			offset = Integer.valueOf(request.getParameter("offset"));
			
		}catch(Exception e) {
			System.out.println("districtServiceController findAlldistrictOffsetLimit");
		}
		List<DistrictServiceModel> listdistrictServiceModels = null;
		try { 
			listdistrictServiceModels = districtServiceResponsitory.countDistrictByNameAndPreId(pre_id, dit_name);
			System.out.println("Hello: " +districtServiceResponsitory.countDistrictByNameAndPreId(pre_id, dit_name).size());
			count = districtServiceResponsitory.countDistrictByNameAndPreId(pre_id, dit_name).size();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JSONObject resultset = new JSONObject();
		JSONObject metadata = new JSONObject();
		JSONArray results = new JSONArray();
		JSONObject jsonMain = new JSONObject();
		
		if(listdistrictServiceModels.size() > 0) {
			resultset.put("count", count);
			resultset.put("offset", offset);
			resultset.put("limit", limit);
			metadata.put("resultset", resultset);
			
			for(DistrictServiceModel dit:listdistrictServiceModels) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("dit_id", dit.getdit_id());
				jsonObject.put("dit_name", dit.getdit_name());
				results.add(jsonObject);
			}
			jsonMain.put("metadata", metadata);
			jsonMain.put("results", results);
		}else {
			resultset.put("count", listdistrictServiceModels.size());
			resultset.put("offset", offset);
			resultset.put("limit", limit);
			metadata.put("resultset", resultset);
			
			jsonMain.put("metadata", metadata);
			jsonMain.put("results", results);
		}
		
		return jsonMain.toString();
	}
}