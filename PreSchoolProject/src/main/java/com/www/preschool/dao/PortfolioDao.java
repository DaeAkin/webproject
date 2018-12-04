package com.www.preschool.dao;

import java.util.List;

import com.www.preschool.dto.PortfolioDto;

public interface PortfolioDao {
	int addPortofolio(PortfolioDto portofolio);
	
	List<PortfolioDto> getAllList();
	
	void deleteAllContent();
	
	PortfolioDto getOnePortfolio(String title);
	
	void updatePortfolio(PortfolioDto portfolio);
	PortfolioDto getOnePortfolio(int portfolio_number);

}
