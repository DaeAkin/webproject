package com.www.preschool.test;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.www.preschool.controller.LoginController;
import com.www.preschool.dto.MemberDto;
import com.www.preschool.exception.TokeninvalidException;
import com.www.preschool.service.LoginService;
import com.www.preschool.utils.JWTFilter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "context-testContext.xml")
public class LoginTest {
	
	@Autowired
	LoginService loginService;
	
	private MockMvc mockMvc;
	
	String token;
	@Before
	public void setUp() {
		this.mockMvc =
				MockMvcBuilders.standaloneSetup(new LoginController()).build();
		
	}
	
	@Test
	public void test2() {
		MemberDto member = new MemberDto();
		member.setMember_id("admin");
		member.setMember_pwd("admin");
		
		
		loginService.login(member);
	}
	
	@Test
	public void JWTTestWithJWTFilter() throws Exception {
		 
		
		MemberDto member = new MemberDto();
		member.setMember_id("admin");
		member.setMember_pwd("admin");
		
		// 토큰 생성
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
	    
		JSONObject jsonObj = new JSONObject("{\"child_no\":\"3\"}");
		this.mockMvc.perform(post("/testaa")
	    		.contentType(MediaType.APPLICATION_JSON)
	    		.content(jsonObj.toString()))
	    		
	    		.andDo(print())	
	    		
	    		
	            .andExpect(status().isOk());

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
	
	@Test
	public void testAlertFilterView() throws Exception {
//		JSONObject jsonObj = new JSONObject("{\"child_no\":\"3\",\"cat\":\"WP\"}");
		JSONObject jsonObj = new JSONObject("{\"child_no\":\"3\"}");
		this.mockMvc.perform(post("/testaa")
	    		.contentType(MediaType.APPLICATION_JSON)
	    		.content(jsonObj.toString()))
	    		
	    		.andDo(print())	
	    		
	    		
	            .andExpect(status().isOk());
//	            .andExpect(content().json("{'data':[{'token':'asd']}"));
	         
	      
	    }
}
