package com.www.preschool.test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.www.preschool.db.DbOperations;
import com.www.preschool.dto.PortfolioDto;
import com.www.preschool.service.PortfolioService;
import com.www.preschool.service.PortfolioServiceImpl;

public class PortfolioServiceTest {
	
	@Autowired
	PortfolioService portfolioService = new PortfolioServiceImpl();
	
	PortfolioDto portfolio = null;
	PortfolioDto portfolio2 = null;
	
	// 테스트 실행하기전에 넣어야할 작업관련 메소드
	@Before
	public void setUp() {
		portfolio = new PortfolioDto(1, 2, "asd", "asd", "2018-02", "asd");
		portfolio2 = new PortfolioDto();
		DbOperations.setXmlLocation("hibernate.cfg2.xml");
		
	}
	
	// DB에 넣고 가져오기 테스트  
	@Test
	public void addAndGet() {
		//데이터 전부삭제.
		portfolioService.deleteAllContent();
		// dto 하나 넣기
		portfolioService.insert(portfolio);
		List<PortfolioDto> portfolioDtos = 
				portfolioService.getAllList();
	
		assertThat(portfolioDtos.size(), is(1));
		
	
		portfolio2 = portfolioService.select(portfolio.getNo());
		portfolio2.setTitle("literacture");
		portfolioService.update(portfolio2);
		assertThat(portfolio2.getTitle(), is("literacture"));
		
		
//		PortfolioDto dto = 
//				portfolioService.getOnePortfolio(portfolio.getTitle());
//		
//		assertThat(dto.getTitle(), is(portfolio.getTitle()));
		
		
		
	}

}
