package com.www.preschool.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class JWTFilter implements Filter{

//	private String encoding;
	
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("---- init call ----");
		//web.xml에서 필터 등록시 정의했던 파라미터를 가져온다.
//		this.encoding = config.getInitParameter("encoding");
		
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
//		request.setCharacterEncoding(this.encoding);
//		 request = new JsonRequestWrapper((HttpServletRequest) request);
//		 Wrapper 생성.
		JsonRequestWrapper jrw = new JsonRequestWrapper((HttpServletRequest)request);
			System.out.println("---- doFilter ----");
			
		
			
	
		
		chain.doFilter(jrw, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
