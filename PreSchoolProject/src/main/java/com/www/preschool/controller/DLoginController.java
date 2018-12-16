package com.www.preschool.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.www.preschool.utils.CommonUtils;
import com.www.preschool.utils.JWTUtil;

@RestController
public class DLoginController {
	
	// 동현이 작성한 LoginController 소스 
	
	@RequestMapping(value="/user")
	public void userLogin(@RequestBody Map<String, Object> paramMap, HttpServletRequest request,HttpServletResponse response) {
		System.out.println("connected");
		response.setHeader("token", 
				JWTUtil.createToken((String)paramMap.get("testId")));
	
		
		
		
	
		
	}
}
