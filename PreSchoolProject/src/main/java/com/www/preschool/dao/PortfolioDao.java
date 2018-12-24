package com.www.preschool.dao;

import java.util.List;

import com.www.preschool.dto.PortfolioDto;

public interface PortfolioDao {
	int addPortofolio(PortfolioDto portofolio);
	
	List<PortfolioDto> getAllList();
	
	<T> void deleteAllContent();
	
	
	
	<T> void updatePortfolio(PortfolioDto portfolio);
	PortfolioDto getOnePortfolio(int portfolio_number);
	
	
	List<PortfolioDto> getOnePortfolioWtihChildren_no(int children_no);
}
