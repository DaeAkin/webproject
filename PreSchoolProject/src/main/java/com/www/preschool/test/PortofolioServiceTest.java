package com.www.preschool.test;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.www.preschool.dto.PortfolioDto;
import com.www.preschool.service.PortofolioService;

public class PortofolioServiceTest {
	
	@Autowired
	PortofolioService portofolioService;
	
	PortfolioDto portfolioDto = null;
	
	// 테스트 실행하기전에 넣어야할 작업관련 메소드
	@Before
	public void setUp() {
		
	
	}
	
	// DB에 넣고 가져오기 테스트  
	@Test
	public void addAndGet() {
		
	}

}
