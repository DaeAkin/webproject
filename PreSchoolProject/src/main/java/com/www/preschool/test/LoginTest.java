package com.www.preschool.test;

import static org.junit.Assert.assertThat;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.www.preschool.dto.MemberDto;
import com.www.preschool.exception.TokeninvalidException;
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
		
		
		String loginToken = loginService.login(member);
//		String jsonToken = " { token : " + loginToken + "}";
		
		
		
		System.out.println("---- httpServletRequest -----");
//	    HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    // 위에서 로그인한 사람의 토큰을 헤더에 넣어줌.
	    request.addHeader("token", loginToken);
	    
	    
//	    HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
	    MockHttpServletResponse response = new MockHttpServletResponse();
	    
	    FilterChain filterChain = mock(FilterChain.class);
	    // mock the getRequestURI() response
//	    when(httpServletRequest.getRequestURI()).thenReturn("/otherurl.jsp");
	    //  JWT필터 생성
	   JWTFilter JWTfilter = new JWTFilter();
	   // 필터에 request와 response를 넘겨준다.
	    JWTfilter.doFilter(request, response,
	            filterChain);

	    // verify if a sendRedirect() was performed with the expected value
//	    verify(httpServletResponse).sendRedirect("/maintenance.jsp");
	    
	   
	    
	}
	
	//해당 클래스 Exception이 나올것으로 예상. 
	// 밑에의 Exception이 떠도 해당 코드는 문제가 없음. 
	@Test(expected=TokeninvalidException.class)
	//토큰 인증 실패 케이스
	public void JWTTestWithJWTFilterWithError() throws IOException, ServletException {
		 // create the objects to be mocked
		
		MemberDto member = new MemberDto();
		member.setMember_id("admin");
		member.setMember_pwd("admin");
		
		
		String loginToken = loginService.login(member);

		
		loginToken +="a";
		
		System.out.println("---- httpServletRequest -----");

	    MockHttpServletRequest request = new MockHttpServletRequest();
	    // 위에서 로그인한 사람의 토큰을 헤더에 넣어줌.
	    request.addHeader("token", loginToken);
	    
	    

	    MockHttpServletResponse response = new MockHttpServletResponse();
	    
	    FilterChain filterChain = mock(FilterChain.class);


	    //  JWT필터 생성
	   JWTFilter JWTfilter = new JWTFilter();
	   // 필터에 request와 response를 넘겨준다.
	    JWTfilter.doFilter(request, response,
	            filterChain);



	    
	   
	    
	}
}
