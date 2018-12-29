package com.www.preschool.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import com.www.preschool.dto.MemberDto;
import com.www.preschool.service.LoginService;
import com.www.preschool.service.LoginServiceImpl;

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
		member.setMember_Id("admin");
		member.setMember_pwd("admin");
		
		
		System.out.println(loginService.login(member).getMember_Id());
	}
}
