package com.www.preschool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.www.preschool.dto.PortfolioDto;
import com.www.preschool.service.PortfolioService;

@RestController
public class PortfolioController {
	
	final static String ADD_ERROR = "300001";
	final static String UPDATE_FAIL = "300002";	
	
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
		
		int result = portfolioService.insert(paramMap);
		
		
	
		
		Map<String,Object> resultMap = new HashMap<>();
		if(result < 1) {
		resultMap.put("code", ADD_ERROR);
		resultMap.put("message", "등록에 실패했습니다.");
		}
		
		
		return resultMap;
	}
	
	@RequestMapping("/portfolio/update")
	public Map<String, Object> updatePortfolio(@RequestBody Map<String, Object> paramMap,
			HttpServletRequest request,HttpServletResponse response) {
			
			Map<String, Object> resultMap = new HashMap<>();
			
			
		return resultMap;
		
	}
	
	@RequestMapping("/portfolio/delete")
	public Map<String, Object> deletePortfolio(@RequestBody Map<String, Object> paramMap,
			HttpServletRequest request,HttpServletResponse response) {
		
		int result = portfolioService.delete(paramMap);
		
		Map<String, Object> resultMap = new HashMap<>();
		
		
		return null;
	}
	
	@RequestMapping("/portfolio/view")
	public Map<String, Object> viewPortfolio(@RequestBody Map<String, Object> paramMap,
			HttpServletRequest request,HttpServletResponse response) {
		//조회할 학생의 no 가져오기
		int child_no = Integer.parseInt((String)paramMap.get("child_no"));
		
		System.out.println("child_no : " + child_no);
		
		System.out.println("portfolioService : " + portfolioService);
		List<PortfolioDto> list = 
		portfolioService.getOnePortfolioWtihChildren_no(child_no);
		
		Map<String, Object> resultMap = new HashMap<>();
		
		resultMap.put("portfolio", list);
		
		return resultMap;
	}
	
//	@RequestMapping("/portfolio/add")
//	public Map<String, Object> addPortfolio(@RequestBody Map<String, Object> paramMap,
//			HttpServletRequest request,HttpServletResponse response) {
//		
//	}
}
