package com.www.preschool.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.www.preschool.utils.JWTUtil;

public class JWTInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		// JWT 인증 구현 코드 작성 
		
		// 인증이 정상이면 false 해서 컨트롤러게 다시 위임 
		// 토큰은 클라이언트에서 "token" 이라는 이름으로 토큰의 값을 넘겨준다.
		return JWTUtil.verifyToken((String)request.getParameter("token"));
		// 인증이 비정상이면 true 해서 핸들러가 계속 제어를 가지고 있는다.
		
	}

	
	

}
