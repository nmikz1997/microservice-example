package com.example.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TrangChu {
	@RequestMapping(value = "/tra-cuu-thong-tin", method = RequestMethod.GET)
	public String traCuuThongTin() {
		return "traCuuThongTin";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String testScript() 
	{
		return "testScript";
	}
}
