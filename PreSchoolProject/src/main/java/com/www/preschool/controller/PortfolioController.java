package com.www.preschool.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.www.preschool.service.PortfolioService;

@RestController
public class PortfolioController {
	
	@Autowired
	PortfolioService portfolioService;

	@RequestMapping("/test")
	public Map<String, Object> testMethod() {
		Map<String, Object> returnMap = new HashMap<>();
		
		returnMap.put("test", "test!!");
		
		return returnMap;
		
	}
	
	@RequestMapping("/folio/add")
	public Map<String, Object> addPortfolio() {
		
		return null;
	}
}
