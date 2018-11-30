package com.www.preschool.test;


import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.www.preschool.dto.PortfolioDto;
import com.www.preschool.service.PortfolioService;
import com.www.preschool.service.PortfolioServiceImpl;

public class PortflioServiceTest {
	
	@Autowired
	PortfolioService portfolioService = new PortfolioServiceImpl();
	
	PortfolioDto portfolio = null;
	
	// 테스트 실행하기전에 넣어야할 작업관련 메소드
	@Before
	public void setUp() {
		portfolio = new PortfolioDto(1, 2, "asd", "asd", "2018-02", "asd");
		
	}
	
	// DB에 넣고 가져오기 테스트  
	@Test
	public void addAndGet() {
		portfolioService.insert(portfolio);
		
		
	}

}
