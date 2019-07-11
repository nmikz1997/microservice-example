package com.springjpa.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springjpa.model.WardServiceModel;
import com.springjpa.responsitory.WardServiceResponsitory;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


@Controller
public class WardServiceController {
	
	@Autowired
	WardServiceResponsitory wardServiceResponsitory;
		
//	@RequestMapping(value = "/api/ward", method = RequestMethod.GET)
//	@ResponseBody
//	public String findAllward(){
//		int offset = 0;
//		int limit = 0;
//		int count = 0;
//		
//		List<wardServiceModel> listwardServiceModels = wardServiceResponsitory.findAllward();
//		count = listwardServiceModels.size();
//		limit = count;
//		JSONObject resultset = new JSONObject();
//		JSONObject metadata = new JSONObject();
//		JSONArray results = new JSONArray();
//		JSONObject jsonMain = new JSONObject();
//		
//		if(listwardServiceModels.size() > 0) {
//			resultset.put("count", count);
//			resultset.put("offset", offset);
//			resultset.put("limit", limit);
//			metadata.put("resultset", resultset);
//			
//			for(wardServiceModel dit:listwardServiceModels) {
//				JSONObject jsonObject = new JSONObject();
//				jsonObject.put("wad_id", dit.getwad_id());
//				jsonObject.put("wad_name", dit.getwad_name());
//				results.add(jsonObject);
//			}
//			jsonMain.put("metadata", metadata);
//			jsonMain.put("results", results);
//		}else {
//			resultset.put("count", listwardServiceModels.size());
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

	
	@RequestMapping(value = "/api/ward", method = RequestMethod.POST)
	@ResponseBody
	public String findAllwardOffsetLimit(HttpServletRequest request){
		int offset = 0;
		int limit = 0;
		int count = 0;
		long dit_id=0;
		String wad_name = null;
		try {
			dit_id = Integer.valueOf(request.getParameter("dit_id"));
			wad_name = "%"+request.getParameter("wad_name")+"%";
			System.out.println("dit_id: "+ dit_id);
			System.out.println("wad_name "+wad_name);
			//limit = Integer.valueOf(request.getParameter("limit"));
			//offset = Integer.valueOf(request.getParameter("offset"));
		}catch(Exception e) {
			System.out.println("wardServiceController findAllwardOffsetLimit");
		}
		List<WardServiceModel> listwardServiceModels = null;
		try {
			listwardServiceModels = wardServiceResponsitory.findAllwardLimitOffset(dit_id, wad_name);
			System.out.println("listwardServiceModels.size():"+listwardServiceModels.size());
			count = (int) wardServiceResponsitory.count();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JSONObject resultset = new JSONObject();
		JSONObject metadata = new JSONObject();
		JSONArray results = new JSONArray();
		JSONObject jsonMain = new JSONObject();
		
		if(listwardServiceModels.size() > 0) {
			resultset.put("count", count);
			resultset.put("offset", offset);
			resultset.put("limit", limit);
			metadata.put("resultset", resultset);
			
			for(WardServiceModel dit:listwardServiceModels) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("wad_id", dit.getwad_id());
				jsonObject.put("wad_name", dit.getwad_name());
				results.add(jsonObject);
			}
			jsonMain.put("metadata", metadata);
			jsonMain.put("results", results);
		}else {
			resultset.put("count", listwardServiceModels.size());
			resultset.put("offset", offset);
			resultset.put("limit", limit);
			metadata.put("resultset", resultset);
			
			jsonMain.put("metadata", metadata);
			jsonMain.put("results", results);
		}
		
		return jsonMain.toString();
	}
}