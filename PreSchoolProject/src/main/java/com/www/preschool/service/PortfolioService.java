package com.www.preschool.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.www.preschool.dto.PortfolioDto;

public interface PortfolioService {
	
	
	void imageUpload(MultipartFile file);
	
    PortfolioDto select(int portfolio_number);
	
	void update(PortfolioDto portfolio);
	
	int insert(PortfolioDto portofolio);
	
	List<PortfolioDto> getAllList();
	
	void deleteAllContent();

	PortfolioDto getOnePortfolio(String title);
		
	
}
