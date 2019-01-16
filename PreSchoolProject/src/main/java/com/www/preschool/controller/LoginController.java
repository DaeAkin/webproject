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

	@RequestMapping(value = "/testaa" , produces = "application/json; charset=utf-8")
	public void testaa(@RequestBody Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("---- testaa ----");
		
		System.out.println("child_no : " + paramMap.get("child_no"));
	}
	
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public void login(@RequestBody Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("connected");
		
		MemberDto member = new MemberDto();
		member.setMember_id((String)paramMap.get("adminID"));
		member.setMember_pwd((String)paramMap.get("adminPWD"));
		
		if(loginService.login(member) !=null) {
			response.setHeader("token", 
					JWTUtil.createToken((String)paramMap.get("adminID")));
//			if(session.getAttribute("session_prs")!=null) {
//				session.setAttribute("session_prs",);
//			}
		}
	}
	
	@RequestMapping("/admin/{adminID}/password")
	public int updatePwd() {
		return 1;
	}
	
	@RequestMapping("/admin/{adminID}/logout")
	public int logout() {
		session.removeAttribute("session_prs");
		return 1;
	}
	

}

