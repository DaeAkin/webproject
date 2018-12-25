package com.www.preschool.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.www.preschool.dto.PortfolioDto;

public interface PortfolioService {
	
	
	void imageUpload(MultipartFile file);
	
    PortfolioDto select(int portfolio_number);
	
	int update(Map<String, Object> paramMap);
	
	int insert(PortfolioDto portofolio);
	
	List<PortfolioDto> getAllList();
	
	void deleteAllContent();

	PortfolioDto getOnePortfolio(String title);
	
	List<PortfolioDto> getOnePortfolioWtihChildren_no(int children_no);
		
	
}
