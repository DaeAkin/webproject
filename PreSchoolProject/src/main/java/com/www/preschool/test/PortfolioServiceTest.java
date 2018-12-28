package com.www.preschool.test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.www.preschool.db.DBTemplate;
import com.www.preschool.dto.PortfolioDto;
import com.www.preschool.service.PortfolioService;
import com.www.preschool.service.PortfolioServiceImpl;
import com.www.preschool.utils.DtoToHashMap;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "context-testContext.xml")
public class PortfolioServiceTest {
	

	
	@Autowired
	PortfolioService portfolioService;
	
	PortfolioDto portfolio = null;
	PortfolioDto portfolio2 = null;
	
	
	
	// 테스트 실행하기전에 넣어야할 작업관련 메소드
	@Before
	public void setUp() {
		portfolio = new PortfolioDto(1, 2, "asd", "asd", "2018-05", "asd");
		portfolio2 = new PortfolioDto();
		DBTemplate.setXmlLocation("hibernate.cfg2.xml");
		
	}
	
	// DB에 넣고 가져오기 테스트  
	@Test
	public void addAndGet() {
		//데이터 전부삭제.
		portfolioService.deleteAllContent();
		// dto 하나 넣기
		int inserted_Portfoli_No = portfolioService.
				insert(DtoToHashMap.folioDtoToHashMap(portfolio));
		
		List<PortfolioDto> portfolioDtos = 
				portfolioService.getAllList();
		// DB의 전체 갯수가 1개인지 확인 
		assertThat(portfolioDtos.size(), is(1));
		
		// 방금 DB에 넣은 데이터 가져오기 
		PortfolioDto insertedPortfolio = 
				portfolioService.select(inserted_Portfoli_No);
		
		// title이 일치하는지 확인 
		assertThat(insertedPortfolio.getTitle(), is(portfolio.getTitle()));
		
	}
	
	@Test
	//포토폴리오 수정 테스트
	public void updateTest() {
		//데이터 전부삭제
		portfolioService.deleteAllContent();
		
		// dto 하나 넣기
		int inserted_Portfoli_No = 
				portfolioService.insert(DtoToHashMap.folioDtoToHashMap(portfolio));
				
		List<PortfolioDto> portfolioDtos = 
				portfolioService.getAllList();
		// DB의 전체 갯수가 1개인지 확인 
		assertThat(portfolioDtos.size(), is(1));
		
		// 방금 DB에 넣은 데이터 가져오기 
		PortfolioDto insertedPortfolio = 
				portfolioService.select(inserted_Portfoli_No);
		
		// title이 일치하는지 확인 
		assertThat(insertedPortfolio.getTitle(), is(portfolio.getTitle()));
		
		//title 변경
		portfolio.setTitle("update");
		Map<String,Object> paramMap = DtoToHashMap.folioDtoToHashMap(portfolio);
		paramMap.put("no", inserted_Portfoli_No);
		
		System.out.println("수정할 no는 ? : " + inserted_Portfoli_No);
		//수정
		portfolioService.update(paramMap);
		
		// 방금 DB에 넣은 데이터 가져오기
		PortfolioDto updateedPortfolio = 
				portfolioService.select(inserted_Portfoli_No);
		
		assertThat(updateedPortfolio.getTitle(), is(portfolio.getTitle()));
		
		
		
		
	}
	
	@Test
	//포토폴리오 보기 테스트 
	public void viewPortfolio() {
		List<PortfolioDto> list = 
				portfolioService.getOnePortfolioWtihChildren_no(
						portfolio.getChild_no());
		
		assertThat(list.size(), is(1));
		
		System.out.println(list.toString());
		
	}
	

}
