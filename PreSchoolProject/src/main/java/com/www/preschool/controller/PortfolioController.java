package com.www.preschool.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.www.preschool.service.PortfolioService;

@RestController
public class PortfolioController {
	
	final static String ADD_ERROR = "300001";
	
	@Autowired
	PortfolioService portfolioService;

	@RequestMapping("/test")
	public Map<String, Object> testMethod() {
		Map<String, Object> returnMap = new HashMap<>();
		
		returnMap.put("test", "test!!");
		
		return returnMap;
		
	}
	
	@RequestMapping("/portfolio/add")
	public Map<String, Object> addPortfolio(@RequestBody Map<String, Object> paramMap,
			HttpServletRequest request,HttpServletResponse response) {
		
		System.out.println(paramMap.toString());
		
		Map<String,Object> resultMap = new HashMap<>();
		
		resultMap.put("code", ADD_ERROR);
		resultMap.put("message", "등록에 실패했습니다.");
		
		
		return resultMap;
	}
	
	@RequestMapping("/portfolio/update")
	public Map<String, Object> updatePortfolio(@RequestBody Map<String, Object> paramMap,
			HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> resultMap = new HashMap<>();
				return paramMap;
		
	}
	
	@RequestMapping("/portfolio/delete")
	public Map<String, Object> deletePortfolio(@RequestBody Map<String, Object> paramMap,
			HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<>();
		
		
		return null;
	}
	
//	@RequestMapping("/portfolio/add")
//	public Map<String, Object> addPortfolio(@RequestBody Map<String, Object> paramMap,
//			HttpServletRequest request,HttpServletResponse response) {
//		
//	}
}
