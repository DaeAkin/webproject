package com.www.preschool.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.www.preschool.dto.MemberDto;
import com.www.preschool.service.LoginService;
import com.www.preschool.utils.JWTFilter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "context-testContext.xml")
public class LoginTest {
	
	@Autowired
	LoginService loginService;
	
	@Before
	public void test1() {
		
		
	}
	
	@Test
	public void test2() {
		MemberDto member = new MemberDto();
		member.setMember_id("admin");
		member.setMember_pwd("admin");
		
		
		loginService.login(member);
	}
	
	@Test
	public void JWTTestWithJWTFilter() throws IOException, ServletException {
		 // create the objects to be mocked
		
		MemberDto member = new MemberDto();
		member.setMember_id("admin");
		member.setMember_pwd("admin");
		
		
		loginService.login(member);
		
		
	    HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
	    
	    HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
	    FilterChain filterChain = mock(FilterChain.class);
	    // mock the getRequestURI() response
//	    when(httpServletRequest.getRequestURI()).thenReturn("/otherurl.jsp");

	   JWTFilter JWTfilter = new JWTFilter();
	    JWTfilter.doFilter(httpServletRequest, httpServletResponse,
	            filterChain);

	    // verify if a sendRedirect() was performed with the expected value
//	    verify(httpServletResponse).sendRedirect("/maintenance.jsp");
	}
}
