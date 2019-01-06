package com.www.preschool.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.www.preschool.utils.JWTUtil;
import com.www.preschool.utils.JsonRequestWrapper;

public class JWTInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("---- JWFInterceptor ----");
		
		JsonRequestWrapper jrw = new JsonRequestWrapper(request);
		System.out.println(jrw.jsonToMap().toString());
		
//		Map<String, String> exMap = jrw.getParameterMap();
		
//		System.out.println("ex Map  : " + exMap.toString());
		
//		System.out.println("token : " +request.getParameter("token"));
		// JWT 인증 구현 코드 작성 
		
		// 인증이 정상이면 true 해서 컨트롤러게 다시 위임 
		// 토큰은 클라이언트에서 "token" 이라는 이름으로 토큰의 값을 넘겨준다.
//		return JWTUtil.verifyToken((String)request.getParameter("token"));
		// 인증이 비정상이면 fasle 해서 핸들러가 계속 제어를 가지고 있는다.
		
		return true;
		
	}

	
	

}
