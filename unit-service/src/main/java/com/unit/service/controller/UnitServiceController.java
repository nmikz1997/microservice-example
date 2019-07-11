package com.unit.service.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unit.service.modal.UnitServiceModal;
import com.unit.service.responsitory.UnitServiceResponsitory;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


@Controller
public class UnitServiceController {	
	@Autowired
	UnitServiceResponsitory unitServiceResponsitory;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String helloWorld() {
		return "hello";
	}
	
	@RequestMapping(value = "/api/units", method = RequestMethod.POST)
	@ResponseBody
	public String findAllUnitOffsetLimit(HttpServletRequest request){
		int offset = 0;
		int limit = 0;
		int count = 0;
		
		try {
			limit = Integer.valueOf(request.getParameter("limit"));
			offset = Integer.valueOf(request.getParameter("offset"));
		}catch(Exception e) {
			System.out.println("UnitServiceController findAllUnitOffsetLimit");
		}
		List<UnitServiceModal> listUnitServiceModals = null;
		try {
			System.out.println("limit:"+limit);
			System.out.println("offset:"+offset);
			listUnitServiceModals = unitServiceResponsitory.findAllUnitLimitOffset(offset, limit);
			System.out.println("listUnitServiceModals.size():"+listUnitServiceModals.size());
			count = (int) unitServiceResponsitory.count();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JSONObject resultset = new JSONObject();
		JSONObject metadata = new JSONObject();
		JSONArray results = new JSONArray();
		JSONObject jsonMain = new JSONObject();
		
		if(listUnitServiceModals.size() > 0) {
			resultset.put("count", count);
			resultset.put("offset", offset);
			resultset.put("limit", limit);
			metadata.put("resultset", resultset);
			
			for(UnitServiceModal unt:listUnitServiceModals) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("unt_id", unt.getUnt_id());
				jsonObject.put("unt_name", unt.getUnt_name());
				results.add(jsonObject);
			}
			jsonMain.put("metadata", metadata);
			jsonMain.put("results", results);
		}else {
			resultset.put("count", listUnitServiceModals.size());
			resultset.put("offset", offset);
			resultset.put("limit", limit);
			metadata.put("resultset", resultset);
			
			jsonMain.put("metadata", metadata);
			jsonMain.put("results", results);
		}
		
		return jsonMain.toString();
	}
	
	@RequestMapping(value = "/api/units/search", method = RequestMethod.POST)
	@ResponseBody
	public String findUnitByNameOffsetLimit(HttpServletRequest request){
		int offset = 0;
		int limit = 0;
		int count = 0;
		
		String untName = null;

		int preId = 0;
		int ditId = 0;
		int wadId = 0;
		
		try {
			limit = Integer.valueOf(request.getParameter("limit"));
			offset = Integer.valueOf(request.getParameter("offset"));
			untName = "%"+request.getParameter("untName").toString().trim()+"%";
			
			preId = Integer.valueOf(request.getParameter("preId"));
			ditId = Integer.valueOf(request.getParameter("ditId"));
			wadId = Integer.valueOf(request.getParameter("wadId"));
			
		}catch(Exception e) {
			System.out.println("UnitServiceController findAllUnitOffsetLimit");
		}
		List<UnitServiceModal> listUnitServiceModals = null;
		try {
			
			if(preId > 0) {
				listUnitServiceModals = unitServiceResponsitory.findUnitByPreIdAndName(untName, preId, offset, limit);
				count = (int) unitServiceResponsitory.countUnitByPreIdAndName(untName, preId).size();
			}else if(ditId > 0) {
				listUnitServiceModals = unitServiceResponsitory.findUnitByDitIdAndName(untName, ditId, offset, limit);
				count = (int) unitServiceResponsitory.countUnitByDitIdAndName(untName, ditId).size();
			}else if(wadId > 0) {
				listUnitServiceModals = unitServiceResponsitory.findUnitByWadIdAndName(untName, wadId, offset, limit);
				count = (int) unitServiceResponsitory.countUnitByWadIdAndName(untName, wadId).size();
			}else {
				listUnitServiceModals = unitServiceResponsitory.findUnitByNameLimitOffset(untName, offset, limit);
				count = (int) unitServiceResponsitory.countUnitByName(untName).size();
			}
			
			//listUnitServiceModals = unitServiceResponsitory.findUnitByNameLimitOffset(untName, offset, limit);
			
			//count = (int) unitServiceResponsitory.count();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JSONObject resultset = new JSONObject();
		JSONObject metadata = new JSONObject();
		JSONArray results = new JSONArray();
		JSONObject jsonMain = new JSONObject();
		
		if(listUnitServiceModals.size() > 0) {
			resultset.put("count", count);
			resultset.put("offset", offset);
			resultset.put("limit", limit);
			metadata.put("resultset", resultset);
			
			for(UnitServiceModal unt:listUnitServiceModals) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("unt_id", unt.getUnt_id());
				jsonObject.put("unt_name", unt.getUnt_name());
				jsonObject.put("unt_describe", unt.getUnt_describe());
				jsonObject.put("unt_address", unt.getUnt_address());
				jsonObject.put("unt_phone", unt.getUnt_phone());
				jsonObject.put("unt_website", unt.getUnt_website());
				results.add(jsonObject);
			}
			jsonMain.put("metadata", metadata);
			jsonMain.put("results", results);
		}else {
			resultset.put("count", listUnitServiceModals.size());
			resultset.put("offset", offset);
			resultset.put("limit", limit);
			metadata.put("resultset", resultset);
			
			jsonMain.put("metadata", metadata);
			jsonMain.put("results", results);
		}
		
		return jsonMain.toString();
	}
}
