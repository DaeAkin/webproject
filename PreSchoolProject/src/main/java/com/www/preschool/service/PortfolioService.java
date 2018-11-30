package com.www.preschool.service;

import org.springframework.web.multipart.MultipartFile;

import com.www.preschool.dto.PortfolioDto;

public interface PortfolioService {
	
	
	void imageUpload(MultipartFile file);
	
	void select();
	
	int insert(PortfolioDto portofolio);
	

}
