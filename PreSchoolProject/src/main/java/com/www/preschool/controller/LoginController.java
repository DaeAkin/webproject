package com.www.preschool.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.www.preschool.dto.MemberDto;
import com.www.preschool.service.LoginService;
import com.www.preschool.utils.JWTUtil;



@RestController
public class LoginController {
	@Autowired
	LoginService loginService;

	@Resource
	HttpSession session;

	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public int login(@RequestBody Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("connected");
		response.setHeader("token", 
				JWTUtil.createToken((String)paramMap.get("testId")));
		
		if(session.getAttribute("session_prs")!=null) {
			session.removeAttribute("session_prs");
		}

		//
		//MemberDto session_prs = loginService.login(member);

//		if (session_prs != null) {
//			session.setAttribute("session_prs", session_prs);
//			return 1;
//		} else {
//			return 0;
//		}
		
	}
	
	@RequestMapping("logout")
	public int logout() {
		session.removeAttribute("session_prs");
		return 1;
	}

}

