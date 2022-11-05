package com.puhu17.addressapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/calljs")
	public String calljs() {
	return "popup.js";
	}
	@RequestMapping("/popuppage")
	public String popupPage() {
	return "getdata.jsp";
	}

}
